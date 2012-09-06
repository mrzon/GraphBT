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
		boolean editorIsActive = getSite().getPage().isPartVisible(this);
		if (!editorIsActive) {
			// Check if we are a page of the active multi page editor
			IEditorPart activeEditor = getSite().getPage().getActiveEditor();
			if (activeEditor != null) {
				if (activeEditor instanceof MultiPageEditorPart) {
					Object selectedPage = ((MultiPageEditorPart) activeEditor).getAdapter(DiagramEditor.class);
					if (selectedPage instanceof DiagramEditor) {
						// Editor is active and diagram sub editor is its active
						// page
						System.out.println("GraphBTDiagramEditor Terpanggil bro kyukyu");
						editorIsActive = true;
					}
				}
			}
		}
		super.selectionChanged(part, selection);
		
		System.out.println("GraphBTDiagramEditor Terpanggil bro");
	}
}
