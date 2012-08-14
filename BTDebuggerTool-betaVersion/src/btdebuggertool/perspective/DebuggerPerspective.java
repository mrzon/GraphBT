package btdebuggertool.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.console.IConsoleConstants;

public class DebuggerPerspective implements IPerspectiveFactory {
	public static final String ID = "btdebuggertool.perspective.DebuggerPerspective";
	public static final String ZEST_VIEW_ID = "btdebuggertool.view.ZestDebuggerView";
	public static final String STATE_VAR_VIEW_ID = "btdebuggertool.view.StateVarDebuggerView";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.25f,
		    IPageLayout.ID_EDITOR_AREA);
//		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		left.addView(STATE_VAR_VIEW_ID);
		
		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.TOP, 0.7f, IPageLayout.ID_EDITOR_AREA);
		topRight.addView(ZEST_VIEW_ID);
		
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.2f, IPageLayout.ID_EDITOR_AREA);
		bottomRight.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		
		layout.setFixed(false);
 		layout.setEditorAreaVisible(false);

	}

}
