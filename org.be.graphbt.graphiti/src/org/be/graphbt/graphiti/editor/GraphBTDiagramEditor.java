package org.be.graphbt.graphiti.editor;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.StandardNode;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
public class GraphBTDiagramEditor extends DiagramEditor implements IPartListener2 {
	private StructuredViewer outlineViewer;
	public final Set<StandardNode> errorReversionNode = new HashSet<StandardNode>();
	public final List<StandardNode> reversionNode = new ArrayList<StandardNode>();
	
	public GraphBTDiagramEditor() {
		super();
	}
	
	@Override 
	public void init(IEditorSite s, IEditorInput i) {
		try {
			super.init(s,i);
			this.loadReversion();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doSave(IProgressMonitor i) {
		saveReversion();
		super.doSave(i);
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		updateActions(getSelectionActions());
	}
	
	@Override
	public void commandStackChanged(EventObject e) {
		super.commandStackChanged(e);
		//outlineViewer.refresh();
	}
	/**
     * Sets the given viewer as the current outline viewer.
     * 
     * @param viewer the viewer to be stored
     */
    public void setOutlineViewer(StructuredViewer viewer) {
            outlineViewer = viewer;
    }
    
    public void saveReversion() {
		final Diagram d = getDiagramTypeProvider().getDiagram();
		getEditingDomain().getCommandStack().execute(new RecordingCommand (getEditingDomain(),"Save reversion node Information") {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				BEModel model = GraphBTUtil.getBEModel(d);
				model.getReversionNode().clear();
				model.getErrorReversionNode().clear();
				model.setReversionNode(reversionNode);
				model.setErrorReversionNode(errorReversionNode);
			}
			
		});
	}
	
	public void loadReversion() {
		BEModel model = GraphBTUtil.getBEModel(getDiagramTypeProvider().getDiagram());
		errorReversionNode.clear();
		reversionNode.clear();
		reversionNode.addAll(model.getReversionNode());
		errorReversionNode.addAll(model.getErrorReversionNode());
	}
	
	
	
	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		System.out.println(partRef.getTitle()+" isActivated");
		this.loadReversion();
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		System.out.println(partRef.getTitle()+" isClosed");
		this.saveReversion();
		
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		System.out.println(partRef.getTitle()+" isDeactivated");
		this.saveReversion();
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		System.out.println(partRef.getTitle()+" isOpened");
		this.loadReversion();
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}
}
