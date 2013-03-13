package org.be.graphbt.graphiti.editor;

import java.util.EventObject;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
public class GraphBTDiagramEditor extends DiagramEditor{
	private StructuredViewer outlineViewer;
	public GraphBTDiagramEditor() {
		super();
	}
	
	@Override 
	public void init(IEditorSite s, IEditorInput i) {
		try {
			super.init(s,i);
			BEModel model = GraphBTUtil.getBEModel(this.getDiagramTypeProvider().getDiagram());
			GraphBTUtil.errorReversionNode.clear();
			GraphBTUtil.reversionNode.clear();
			GraphBTUtil.reversionNode.addAll(model.getReversionNode());
			GraphBTUtil.errorReversionNode.addAll(model.getErrorReversionNode());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doSave(IProgressMonitor i) {
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
}
