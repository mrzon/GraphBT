package org.be.graphbt.graphiti;


import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.console.IConsoleConstants;

public class GraphBTPerspective implements IPerspectiveFactory {
	public static final String ID = "org.be.graphbt.perspective.GraphBTPerspective";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.25f,
		    IPageLayout.ID_NAVIGATE_ACTION_SET);
		
		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.TOP, 0.7f, IPageLayout.ID_EDITOR_AREA);
		
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.2f, IPageLayout.ID_EDITOR_AREA);
		bottomRight.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		
		layout.setFixed(false);
 		layout.setEditorAreaVisible(false);

	}

}
