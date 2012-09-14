package behaviortree.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.MultiPageEditorPart;

public class GraphBTDiagramEditor extends DiagramEditor{
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
		System.out.println("GraphBTDiagramEditor Terpanggil bro");
	}
}
