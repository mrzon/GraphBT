package behaviortree.editor;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

//import org.be.textbe.bt.textbt.presentation.TextbtEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.osgi.framework.Bundle;

import behaviortree.BEModel;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;
import behaviortree.graphBT.wizards.CreateStandardNodeGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.createrequirement.CreateRequirementGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;
import behaviortree.graphBT.wizards.managerequirements.ManageRequirementsGraphBTWizard;
import behaviortree.graphBT.wizards.verifymodel.VerifyModelGraphBTWizard;

/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class MultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	private IEditorPart activeEditorPart;
	private Action generateBTCode;
	private Action addNewComponent;
	private Action manageComponents;
	private Action manageRequirements;
	
	private Action verifyModel;
	/**
	 * Creates a multi-page contributor.
	 */
	public MultiPageEditorContributor() {
		super();
		createActions();
	}
	/**
	 * Returns the action registed with the given text editor.
	 * @return IAction or null if editor is null.
	 */
	protected IAction getAction(ITextEditor editor, String actionID) {
		return (editor == null ? null : editor.getAction(actionID));
	}
	/* (non-JavaDoc)
	 * Method declared in AbstractMultiPageEditorActionBarContributor.
	 */

	public IEditorPart getActivePage()
	{
		return activeEditorPart;
	}
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		/*if(activeEditorPart instanceof DiagramEditor && part instanceof TextbtEditor)
		{
			
		}*/
		activeEditorPart = part;
		
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {

			ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

			actionBars.setGlobalActionHandler(
				ActionFactory.DELETE.getId(),
				getAction(editor, ITextEditorActionConstants.DELETE));
			actionBars.setGlobalActionHandler(
				ActionFactory.UNDO.getId(),
				getAction(editor, ITextEditorActionConstants.UNDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.REDO.getId(),
				getAction(editor, ITextEditorActionConstants.REDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.CUT.getId(),
				getAction(editor, ITextEditorActionConstants.CUT));
			actionBars.setGlobalActionHandler(
				ActionFactory.COPY.getId(),
				getAction(editor, ITextEditorActionConstants.COPY));
			actionBars.setGlobalActionHandler(
				ActionFactory.PASTE.getId(),
				getAction(editor, ITextEditorActionConstants.PASTE));
			actionBars.setGlobalActionHandler(
				ActionFactory.SELECT_ALL.getId(),
				getAction(editor, ITextEditorActionConstants.SELECT_ALL));
			actionBars.setGlobalActionHandler(
				ActionFactory.FIND.getId(),
				getAction(editor, ITextEditorActionConstants.FIND));
			actionBars.setGlobalActionHandler(
				IDEActionFactory.BOOKMARK.getId(),
				getAction(editor, IDEActionFactory.BOOKMARK.getId()));
			actionBars.updateActionBars();
		}
	}

	@SuppressWarnings("deprecation")
	private void createActions() {
		generateBTCode = new Action() {
			public void run(){
				if(activeEditorPart instanceof DiagramEditor)
				{
				Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
				String content = GraphBTUtil.getBEModel(d).toString();
				URI uri = d.eResource().getURI();
				uri = uri.trimFragment();
				uri = uri.trimFileExtension();
				uri = uri.appendFileExtension("bt");
				List<StandardNode> ln = GraphBTUtil.getRoots(d.eResource().getResourceSet());
				for(int i=0; i < ln.size(); i++)
				{
					content+="\n"+ln.get(i).toString();
				}
				final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				
				IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
				{
					Path path = new Path(uri.toPlatformString(true));
					IFile ifile = workspaceRoot.getFile(path);
					InputStream in = new ByteArrayInputStream(content.getBytes());
					try {
						if (file == null || !file.exists()) 
						{
							ifile.create(in,false,null);
						}	
						else
						{
							ifile.setContents(in, false, false, null);
						}	
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}}
		// Get the currently selected file from the editor
	};	
	
	Bundle bundleGenerateCode = Platform.getBundle("BehaviorTreeModel");
	IPath pathGenerateCode = new Path("icons/generateCode.gif");
	
	URL fileURLGenerateCode = FileLocator.find(bundleGenerateCode , pathGenerateCode , null);
	System.out.println("wooo "+fileURLGenerateCode.getPath());
	try {
		fileURLGenerateCode = FileLocator.resolve(fileURLGenerateCode );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ImageData imGenerateCode = new ImageData(fileURLGenerateCode.getPath());
	ImageDescriptor imdGenerateCode = ImageDescriptor.createFromImageData(imGenerateCode );

	generateBTCode.setText("Generate BT Code");
	generateBTCode.setToolTipText("Generate the corresponding BT Code of the BE model");
	generateBTCode.setImageDescriptor(imdGenerateCode);
	
		addNewComponent = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor)
				{
					System.out.println("Diagramnya kebuka euy");
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";
					
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
				                getActiveWorkbenchWindow().getShell(),
				    		new CreateComponentGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK)
						{
							return;
						}
						
						
						//System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
						
					
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		
		Bundle bundleAddComponent = Platform.getBundle("BehaviorTreeModel");
		IPath pathAddComponent = new Path("icons/newComponent.gif");
		
		URL fileURLAddComponent = FileLocator.find(bundleAddComponent, pathAddComponent, null);
		System.out.println("wooo "+fileURLAddComponent.getPath());
		try {
			fileURLAddComponent = FileLocator.resolve(fileURLAddComponent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageData imAddComponent = new ImageData(fileURLAddComponent.getPath());
		ImageDescriptor imdAddComponent = ImageDescriptor.createFromImageData(imAddComponent);

		addNewComponent.setText("Add new Component");
		addNewComponent.setToolTipText("Add new component to the model");
		addNewComponent.setImageDescriptor(imdAddComponent);

		
		
		
		manageComponents = new Action(){
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor)
				{
					System.out.println("Diagramnya kebuka euy");
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";
					if(d!=null)
					{
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
				                getActiveWorkbenchWindow().getShell(),
				    		new ManageComponentsGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK)
						{
							return;
						}
						BEModel be = GraphBTUtil.getBEModel(d);
						
						
						//System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
						
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		
		//final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//IResource file = workspaceRoot.findMember("icons/requirement.gif",true);
		//IPath ip = workspaceRoot.getWorkspace().;
		//System.out.println("Filenya "+ip.toOSString());
		
		//URL pluginInternalURL = getDefault().getBundle().getEntry("icons/requirement.gif"); 
		
		Bundle bundleComponent = Platform.getBundle("BehaviorTreeModel");
		IPath pathComponent = new Path("icons/component.gif");
		
		URL fileURLComponent = FileLocator.find(bundleComponent, pathComponent, null);
		System.out.println("wooo "+fileURLComponent.getPath());
		try {
			fileURLComponent = FileLocator.resolve(fileURLComponent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageData imComponent = new ImageData(fileURLComponent.getPath());
		ImageDescriptor imdComponent = ImageDescriptor.createFromImageData(imComponent);

		manageComponents.setText("Manage Components");
		manageComponents.setToolTipText("Manage components of the model");
		manageComponents.setImageDescriptor(imdComponent);
		
		
		manageRequirements = new Action(){
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor)
				{
					System.out.println("Diagramnya kebuka euy");
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";
					if(d!=null)
					{
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
				                getActiveWorkbenchWindow().getShell(),
				    		new ManageRequirementsGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK)
						{
							return;
						}
						BEModel be = GraphBTUtil.getBEModel(d);
						
						
						//System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
						
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		
		
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//IResource file = workspaceRoot.findMember("icons/requirement.gif",true);
		//IPath ip = workspaceRoot.getWorkspace().;
		//System.out.println("Filenya "+ip.toOSString());
		
		//URL pluginInternalURL = getDefault().getBundle().getEntry("icons/requirement.gif"); 
		
		Bundle bundle = Platform.getBundle("BehaviorTreeModel");
		IPath path = new Path("icons/requirement.gif");
		
		URL fileURL = FileLocator.find(bundle, path, null);
		System.out.println("wooo "+fileURL.getPath());
		try {
			fileURL = FileLocator.resolve(fileURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageData im = new ImageData(fileURL.getPath());
		ImageDescriptor imd = ImageDescriptor.createFromImageData(im);
		//System.out.println("Filenya "+ip.toString());
		manageRequirements.setText("Manage Requirements");
		manageRequirements.setToolTipText("Manage Requirements of The Model");
		manageRequirements.setImageDescriptor(imd);
		
		verifyModel = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor)
				{
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					if(d!=null)
					{
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
				                getActiveWorkbenchWindow().getShell(),
				    		new VerifyModelGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK)
						{
							return;
						}
						BEModel be = GraphBTUtil.getBEModel(d);
						
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		
		verifyModel.setText("Verify Model");
		verifyModel.setToolTipText("Verify model");
		verifyModel.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(IDE.SharedImages.IMG_OPEN_MARKER));
		
		
//		IEditorDescriptor eDesc = PlatformUI.getWorkbench().getActiveWorkbenchWindow().//findEditor("behaviortree.editor.MultiPageEditor");
//		if(eDesc != null)
//		{
//			eDesc.
//		}
	}
	public void contributeToMenu(IMenuManager manager) {
		IMenuManager menu = new MenuManager("Editor &Menu");
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		
		menu.add(generateBTCode);
		menu.add(addNewComponent);
		menu.add(manageComponents);
		menu.add(manageRequirements);
		menu.add(verifyModel);
		
	}
	public void contributeToToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(generateBTCode);
		manager.add(addNewComponent);
		manager.add(manageComponents);
		manager.add(manageRequirements);
		manager.add(verifyModel);
	}
}
