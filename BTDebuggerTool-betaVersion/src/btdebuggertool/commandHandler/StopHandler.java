package btdebuggertool.commandHandler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import btdebuggertool.view.ZestDebuggerView;

public class StopHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ZestDebuggerView view = ZestDebuggerView.getInstance();
		view.stop_Event();
		return null;
	}

}
