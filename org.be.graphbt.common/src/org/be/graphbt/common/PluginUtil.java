package org.be.graphbt.common;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class PluginUtil {
	public static MessageConsoleStream getConsoleStream(String id, final IWorkbenchPage page) {
		final IConsole myConsole = findConsole(id);
		final IConsoleView consoleView[] = new IConsoleView[1];
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consoleView[0] = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
					consoleView[0].display(myConsole);
					
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
		});
		
		//getting the output stream for the writing purpose
		((MessageConsole)myConsole).clearConsole();
		MessageConsoleStream out = ((MessageConsole)myConsole).newMessageStream();
		return out;
	}
	
	private static MessageConsole findConsole(String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});
	      return myConsole;
	}
	
}
