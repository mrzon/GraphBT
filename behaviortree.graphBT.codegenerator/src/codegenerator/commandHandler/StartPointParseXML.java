package codegenerator.commandHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.core.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import codegenerator.helper.Helper;

import bt2abs.ABSForeign;
import bt2abs.ABSModule;
import bt2abs.BTParser;

public class StartPointParseXML extends AbstractHandler implements IHandler {
	//private static final String DEBUGGER_PERSPECTIVE_ID = "btdebuggertool.perspective.DebuggerPerspective";
	
	
	IFile chosenFile;
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selectedFiles = (IStructuredSelection)HandlerUtil.getActiveMenuSelection(event);
		
		final StringBuffer buf = new StringBuffer();
		final Object selectedFile = selectedFiles.getFirstElement();
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		
		BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
			
			@Override
			public void run() {
				boolean isValid = false;
				if(selectedFile instanceof IFile && ((IFile)selectedFile).getFileExtension().equals("xml")){
					IFile xml = (IFile)selectedFile;
					
					chosenFile = xml;
					try {
						
						
						//InputStream is = xml.getContents(true);
						String modName = xml.getName().substring(0, xml.getName().lastIndexOf("."));
						StringBuffer strB = new StringBuffer(modName);
						strB.setCharAt(0,(modName.substring(0, 1).toUpperCase().charAt(0)));
						modName = strB.toString();
						System.out.println("File yang mau digenerate ini.. "+xml.getRawLocation().toOSString());
						//IWorkspaceRoot workspace= ResourcesPlugin.getWorkspace().getRoot();
						//System.out.println(btURI.getAbsolutePath());
						
						String path = xml.getRawLocation().toOSString();
						IContainer r = xml.getParent();
						String folder="";
						IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
						folder = workspaceRoot.getRawLocation().append(modName).toOSString();
						IProject pr = xml.getProject();
						//folder = new File(pr.getRawLocation().toOSString()).getAbsolutePath();
						System.out.println("nama workspacenya "+pr.getName());
						parseXmlToBT(path,folder,modName, false);
						//javaPath = xml.getParent().getRawLocation().append("java\\gen").toOSString();
						//System.out.println("path buat naro javanya "+javaPath);
//						GlobalData.tree = parseXmlToBT(is);
//						System.out.println(GlobalData.tree.toString());
						
						isValid = true;
					} catch (Exception e) {
						e.printStackTrace();
						buf.append(e.getMessage());
						isValid = false;
					}
				}
				else if(selectedFile instanceof IFile && ((IFile)selectedFile).getFileExtension().equals("bt"))
				{
					IFile bt = (IFile)selectedFile;
					chosenFile = bt;
					try {
						processGVModel(bt);
						IWorkspace workspace= ResourcesPlugin.getWorkspace();
						System.out.println(btURI.getAbsolutePath());
						IPath location= Path.fromOSString(btURI.getAbsolutePath()); 
						IFile xml= workspace.getRoot().getFileForLocation(location);
						System.out.println(xml);
						//InputStream is = new FileInputStream(btURI);
						//InputStream is = xml.getContents(true);
						String modName = bt.getName().substring(0, bt.getName().lastIndexOf("."));
						StringBuffer strB = new StringBuffer(modName);
						strB.setCharAt(0,(modName.substring(0, 1).toUpperCase().charAt(0)));
						modName = strB.toString();
						System.out.println("File yang mau digenerate ini.. "+bt.getRawLocation().toOSString());
						String folder="";
						IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
						folder = workspaceRoot.getRawLocation().append(modName).toOSString();

						
						IProject pr = bt.getProject();
						System.out.println("nama workspacenya "+folder);
							//folder = new File(pr.getRawLocation().toOSString()).getAbsolutePath();
						
						
						parseXmlToBT(btURI.getAbsolutePath(),folder,modName, false);
						
						//javaPath = xml.getParent().getRawLocation().append("java\\gen").toOSString();
						//System.out.println("path buat naro javanya "+javaPath);
//						GlobalData.tree = parseXmlToBT(is);
//						System.out.println(GlobalData.tree.toString());
						
//						GlobalData.tree = 
//						System.out.println("Ini datanya"+GlobalData.tree.toString());
						//is.close();
						isValid = true;
					} catch (Exception e) {
						e.printStackTrace();
						buf.append(e.getMessage());
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
				
				if(!isValid){
					Display.getDefault().syncExec(new Runnable() {
						
						@Override
						public void run() {
							String message = buf.toString();
							if(message.length() > 0)
								MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", buf.toString());
							else
								MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", "The selected file is not xml");
						}
					});
				}else{
					//showing the console view
					//IWorkbenchPage perspectivePage = PlatformUI.getWorkbench().showPerspective(DEBUGGER_PERSPECTIVE_ID, window);// showPerspective(DEBUGGER_PERSPECTIVE_ID, window);
					//IConsole myConsole = findConsole("btdebuggertool.view.consoleView");
					//IConsoleView consoleView = (IConsoleView) perspectivePage.showView(IConsoleConstants.ID_CONSOLE_VIEW);
					//consoleView.display(myConsole);
					
					//getting the output stream for the writing purpose
					//((MessageConsole)myConsole).clearConsole();
					//MessageConsoleStream out = ((MessageConsole)myConsole).newMessageStream();
				}
				

			}
		});

		return null;
	}
	
	private void parseXmlToBT(String path, String folder,String modName,boolean trace) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
        BTParser bp = new BTParser(modName,folder,trace);
        saxParser.parse( new File(path), bp);
	}
	
	private MessageConsole findConsole(String name) {
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
	
	private String javaPath;
	private String absName;
	
	private File btURI; 

	private void processGVModel(IFile file){	
		IInjector injector = null;
		IExtractor extractor = null;
		IReferenceModel inMetamodel;
		IReferenceModel outMetamodel;
		URL btASMURL;
		URL ctASMURL;
		URL stASMURL;
		ModelFactory factory = null;	
		try {
			Bundle bundle = Platform.getBundle("BTDebuggerTool");
			btASMURL = bundle.getEntry("transformations/textBT2GV.asm");
			ctASMURL = null;
			stASMURL = null;
			
			injector = CoreService.getInjector("EMF"); //$NON-NLS-1$
			extractor = CoreService.getExtractor("EMF"); //$NON-NLS-1$
			
			factory = CoreService.createModelFactory("EMF");
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
		IFile f = (IFile) file;
		IPath path = (IPath) f.getLocation();
		IModel outputModel = null;

		// Defaults
		try {
			// Metamodels
			inMetamodel = factory.newReferenceModel();
			outMetamodel = factory.newReferenceModel();
			injector.inject(inMetamodel, "http://org.be.textbe/textbt");	    
			injector.inject(outMetamodel, "http://org.be.textbe/gv");		    

			// Getting Launcher
			ILauncher launcher = null;
			launcher = CoreService.getLauncher("EMF-specific VM");
			launcher.initialize(Collections.<String, Object> emptyMap());

			// Creating Models
			IModel inputModel = factory.newModel(inMetamodel);
			outputModel = factory.newModel(outMetamodel);

			// Loading Existing Model
			System.out.println("file .btnya "+file.getFullPath().toPortableString());
			System.out.println("file .bt1nya "+file.getFullPath().toString());
			
			Scanner s = new Scanner(file.getContents(true));
			System.out.println("Konteks nya adalah:");
			while(s.hasNext())
			{
				System.out.println(s.next());
			}
			
			injector.inject(inputModel, file.getFullPath().toPortableString());

			btURI = File.createTempFile("tempbt2sal", ".textbt", null);
			System.out.println(btURI.toURI().toString());
			IWorkbenchPart workbenchPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart(); 
			IFile fileRaw = (IFile) workbenchPart.getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			if (fileRaw == null)
				try {
					throw new FileNotFoundException();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			String path1 = fileRaw.getRawLocation().toOSString();
			
			path1 = path1.substring(0, path1.lastIndexOf("."));
			path1 = path1+".xml";
			File f1 = new File(path1);
			System.out.println("path Init: " + path1);
			
			// DEBUG - Dump Input Model
			//extractor.extract(inputModel, filetest.getName());
			extractor.extract(inputModel, btURI.toURI().toString());
			//extractor.extract(inputModel, f1.toURI().toString());
			btURI.deleteOnExit();
			// Launching
			launcher.addOutModel(outputModel, "GV", "OUT");
			launcher.addInModel(inputModel, "TEXTBT", "IN");

			// Saving Model
			extractor.extract(outputModel, "outputModel.gv");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}
}
