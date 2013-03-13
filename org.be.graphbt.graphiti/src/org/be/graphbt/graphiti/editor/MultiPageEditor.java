/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2011, 2012 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    mwenz - Bug 387971 - Features cant't be invoked from contextMenu
 *
 * </copyright>
 *
 *******************************************************************************/

package org.be.graphbt.graphiti.editor;


import java.util.HashMap;
import java.util.Map;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.pages.ManageComponentPage;
import org.be.graphbt.graphiti.editor.pages.ManageLibraryPage;
import org.be.graphbt.graphiti.editor.pages.ManageRequirementPage;
import org.be.graphbt.model.graphbt.BEModel;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
public class MultiPageEditor extends MultiPageEditorPart implements IResourceChangeListener {

	/** The diagram editor used in page 0. */
	private DiagramEditor editor;
	
	/**
	 * Creates a multi-page editor example.
	 */
	public MultiPageEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	/**
	 * Creates page 0 of the multi-page editor,
	 * which contains a text editor.
	 */
	void createPage0() {
		try {
			editor = new GraphBTDiagramEditor();
			int index = addPage(editor, getEditorInput());
			setPageText(index, "Graphical");
		    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put("model", new XMIResourceFactoryImpl());
			//editor.getGraphicalViewer().setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.MOD1), MouseWheelZoomHandler.SINGLETON);
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested text editor",
				null,
				e.getStatus());
		}
	}

	private StyledText text;
	/**
	 * Creates page 1 of the multi-page editor,
	 * which allows you to change the font used in page 2.
	 */
	void createPage1() {

		Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		text = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		int index = addPage(composite);
		setPageText(index, "Textual");
	}
	
	void createPage2()
	{
		final Diagram d = this.editor.getDiagramTypeProvider().getDiagram();
		HashMap <Integer, String> map = new HashMap <Integer,String>();
		ManageRequirementPage container = new ManageRequirementPage(getContainer(), SWT.NULL,d,map);
		
		int index = addPage(container);
		setPageText(index, "Requirements");
	}
	void createPage3()
	{
		final Diagram d = this.editor.getDiagramTypeProvider().getDiagram();
		final HashMap<Integer, String> map = new HashMap<Integer, String>();
		ManageComponentPage container = new ManageComponentPage(getContainer(), SWT.NONE,d,map);
		
		int index = addPage(container);
		setPageText(index, "Components");
	}
	
	/**
	 * Library page
	 */
	void createPage4() {
		final DiagramEditor d = this.editor;
		ManageLibraryPage container = new ManageLibraryPage(getContainer(), SWT.NONE,d);
		int index = addPage(container);
		setPageText(index, "Library");
	}

	/**
	 * Interface page
	 */
	void createPage5() {
		Composite container = new Composite(getContainer(),SWT.NULL);
		int index = addPage(container);
		setPageText(index, "Interfaces");
	}
	
	/**
	 * Design layout page
	 */
	void createPage6() {
		Composite container = new Composite(getContainer(),SWT.NULL);
		int index = addPage(container);
		setPageText(index, "Layout");
	}
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		createPage0();
		createPage1();
		createPage2();
		createPage3();
		createPage4();
		createPage5();
		createPage6();
		this.setTitle(editor.getTitle());
	}
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {
		if(getActiveEditor() instanceof DiagramEditor) {
			DiagramEditor dEditor = ((DiagramEditor)getActiveEditor());
			final Diagram d = dEditor.getDiagramTypeProvider().getDiagram();
			dEditor.getEditingDomain().getCommandStack().execute(new RecordingCommand (dEditor.getEditingDomain(),"Save reversion node Information") {

				@Override
				protected void doExecute() {
					// TODO Auto-generated method stub
					BEModel model = GraphBTUtil.getBEModel(d);
					model.getReversionNode().clear();
					model.getErrorReversionNode().clear();
					model.setReversionNode(GraphBTUtil.reversionNode);
					model.setErrorReversionNode(GraphBTUtil.errorReversionNode);
				}
				
			});
			
			
			getActiveEditor().doSave(monitor);	
		}
	}
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());

	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);

		IDE.gotoMarker(getEditor(0), marker);
	}
	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
		

	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		final Diagram d = this.editor.getDiagramTypeProvider().getDiagram();
		HashMap <Integer, String> map = new HashMap <Integer,String>();
		switch (newPageIndex) {
		 case 0:  //case in editor 0

		 break;
		 case 1: //case in editor 1
		 /**
		  * set the text in getBTText
		  */
		 text.setText(GraphBTUtil.getBTText(((DiagramEditor)editor).getDiagramTypeProvider().getDiagram()));
		 break;
		 case 2:
			 setControl(2, new ManageRequirementPage(getContainer(), SWT.NULL,d,map));
			 break;
		 case 3:
			 setControl(3, new ManageComponentPage(getContainer(), SWT.NONE,d,map));
			 break;
		 case 4:
			 setControl(4,  new ManageLibraryPage(getContainer(), SWT.NONE,this.editor));
			 break;
		}
	}

	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event) {
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++) {
						if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())) {
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}

					}
				}            
			});
		}
	}

	public DiagramEditor getDiagramEditor() {
		return editor;	
	}
	
	public String getBTText() {
		return text.getText();
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// Propagate the selection changed event to all sub editors
		int pageCount = getPageCount();
		for (int i = 0; i < pageCount; i++) {
			IEditorPart editor = getEditor(i);
			if (editor instanceof ISelectionListener) {
				((ISelectionListener) editor).selectionChanged(part, selection);
			}
		}
	}
	/*
	public Object getAdapter(Class type) {
        if (type == IContentOutlinePage.class)
                // create a new outline page
                return new GraphBTContentOutlinePage(this.getDiagramEditor());
        else
                return super.getAdapter(type);
	}
	*/
}