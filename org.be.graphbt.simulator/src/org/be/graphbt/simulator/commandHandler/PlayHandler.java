package org.be.graphbt.simulator.commandHandler;

import org.be.graphbt.simulator.GlobalData;
import org.be.graphbt.simulator.perspective.DebuggerPerspective;
import org.be.graphbt.simulator.view.ZestDebuggerView;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;


public class PlayHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ZestDebuggerView view = ZestDebuggerView.getInstance();
		view.play_Event();
	
		return null;
	}
	
}
