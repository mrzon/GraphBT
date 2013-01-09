package behaviortree.graphBT.editors;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchPart;
public class GraphBTDiagramEditor extends DiagramEditor{
	private StructuredViewer outlineViewer;
	public GraphBTDiagramEditor()
	{
		super();
	}
	
	public void doSave(IProgressMonitor i)
	{
		super.doSave(i);
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection)
	{
		super.selectionChanged(part, selection);
		updateActions(getSelectionActions());
	}
	
	@Override
	public void commandStackChanged(EventObject e)
	{
		super.commandStackChanged(e);
		outlineViewer.refresh();
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
