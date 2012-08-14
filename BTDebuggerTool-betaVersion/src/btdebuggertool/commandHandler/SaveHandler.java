package btdebuggertool.commandHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

import btdebuggertool.view.ZestDebuggerView;


public class SaveHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ZestDebuggerView view = ZestDebuggerView.getInstance();
		view.save_Event();
		return null;
	}


}
