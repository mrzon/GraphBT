package behaviortree.editor;

import org.eclipse.graphiti.platform.IDiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

public class GraphBTDiagramEditorContributor extends DiagramEditorActionBarContributor{
	
	GraphBTDiagramEditorContributor(){
		super();
		buildActions();
	}
	
//	protected void buildActions() {
//		IActionBars actionBars = getActionBars();
//		System.out.println("outside actions in IDiagramEditor");
//		if (actionBars != null) {
////			IDiagramEditor editor = (part instanceof IDiagramEditor) ? (IDiagramEditor) part : null;
//			
//			System.out.println("actions in IDiagramEditor");
//	
//			actionBars.setGlobalActionHandler(
//					ActionFactory.DELETE.getId(),
//					getAction(ITextEditorActionConstants.DELETE));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.UNDO.getId(),
//					getAction(ITextEditorActionConstants.UNDO));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.REDO.getId(),
//					getAction(ITextEditorActionConstants.REDO));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.CUT.getId(),
//					getAction(ITextEditorActionConstants.CUT));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.COPY.getId(),
//					getAction(ITextEditorActionConstants.COPY));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.PASTE.getId(),
//					getAction(ITextEditorActionConstants.PASTE));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.SELECT_ALL.getId(),
//					getAction(ITextEditorActionConstants.SELECT_ALL));
//			actionBars.setGlobalActionHandler(
//					ActionFactory.FIND.getId(),
//					getAction(ITextEditorActionConstants.FIND));
//			actionBars.setGlobalActionHandler(
//					IDEActionFactory.BOOKMARK.getId(),
//					getAction(IDEActionFactory.BOOKMARK.getId()));
//			actionBars.updateActionBars();
//		}
//	}
}
