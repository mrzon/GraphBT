package behaviortree.graphBT.wizards.verifymodel;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.templates.editor.HomeHTML;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Formula;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;
import behaviortree.util.Log;
import behaviortree.util.Util;

import behaviortree.saltranslator.bt2sal.*;

public class VerifyModelGraphBTWizard extends Wizard {

	protected VerifyModelFirstPage one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public VerifyModelGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new VerifyModelFirstPage(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	/**
	 * when finished, do action based on options in wizard.
	 * the options are:
	 * 1) save formulas to file,
	 * 2) save verification result to file.
	 */
	@Override
	public boolean performFinish() {
		String flagVerRes = map.get(ConstantsOfVerifyModel.REF_SELECTION_SAVE_VERIFICATION_RESULT);
		String flagFormula = map.get(ConstantsOfVerifyModel.REF_SELECTION_SAVE_FORMULA);
		
		/*if(flagVerRes != null && flagVerRes.equalsIgnoreCase("true")) {
			
		}*/
		if(flagFormula != null && flagFormula.equalsIgnoreCase("true")) {
			saveFormulaToFile();
		}
		
		translateAndSaveVerificationResult();
		
	
		return true;		
	}
	
	/**
	 * save formulas in master list.
	 */
	private void saveFormulaToFile() {
		StringBuffer content = new StringBuffer();
		content.append("<formulas>\n");
		// GET FORMULAS
		final BEModel be = GraphBTUtil.getBEModel(d);
		if(be.getFormulaList() != null) {
			for(Formula formula : be.getFormulaList().getFormula()) {
				content.append("\t<elm>"+formula.getFormulaName()+"</elm>\n");
			}
		}
		content.append("</formulas>\n");
		
		// SET FILE URI
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("formula");
		
		// WRITE TO FILE
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		{
			Path path = new Path(uri.toPlatformString(true));
			IFile btIFile = workspaceRoot.getFile(path);
			
			Log.d(path.toString());
			InputStream in = new ByteArrayInputStream(content.toString().getBytes());
			try {
				if (file == null || !file.exists()) 
				{
					btIFile.create(in,false,null);
				}	
				else
				{
					btIFile.setContents(in, false, false, null);
				}	
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * here is the work flow:
	 * take the formulas, read .sal file, and merge formulas 
	 * with .sal file.
	 */
	private void translateAndSaveVerificationResult() {
		initPythonIntegrationFile();
		String homeDrivePath = System.getProperty("user.home");
		
		// READ SAL FILE
		StringBuffer salText = new StringBuffer();
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("sal");
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		{
			Path path = new Path(uri.toPlatformString(true));
			IFile btIFile = workspaceRoot.getFile(path);
			
			try {
				InputStream is = btIFile.getContents();
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
			    String inputLine;
			 
			    while ((inputLine = in.readLine()) != null) {
			        salText.append(inputLine + "\n");
			    }
			 
			    in.close();
			} catch(Exception e) { }
		}
		
		// GET FORMULAS AND WRITE
		StringBuffer formulasText = new StringBuffer();
		final BEModel be = GraphBTUtil.getBEModel(d);
		if(be.getFormulaList() != null) {
			for(Formula formula : be.getFormulaList().getFormula()) {
				formulasText.append("myth: THEOREM behavior |- " + 
						formula.getFormulaName() + ";" + "\n");
			}
		}
		Util.writeFileSystemEnv(homeDrivePath, "myth.txt", formulasText.toString());
		
		// COMBINE THEM AND WRITE
		int idx = salText.indexOf("%end of module");
		salText.insert(idx, "\n" + formulasText.toString());
		Util.writeFileSystemEnv(homeDrivePath, "mysal.sal", salText.toString());

		// JUST WRITE NODE REF
		Util.writeFileSystemEnv(homeDrivePath, "mynode.ref", "");
		
		//Log.d(salText.toString());
		//MessageDialog.openError(null, "Yay Error in validate BT", "The model should contain only one root!");	
		
		// TODO execute sal-script file (python code) for check modeling
		
		try {
			
			Process process = Runtime.getRuntime().exec(
				"cmd /c start cmd.exe /c \"cd " 
				+ homeDrivePath
				+ " && sh sal-script mysal mynode myth\"");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
		  Thread.currentThread().sleep(1000); //sleep for 1000 ms
		}
		catch(Exception e) {}
		
		// TODO read result in home drive path
		String resultText = Util.readFileSystemEnv(homeDrivePath, "mysal_myth.btt");
		Log.d(resultText);
		
		Util.writeFileToWorkspace(d, "result", resultText);
	}

	private void initPythonIntegrationFile() {
		String homeDrivePath = System.getProperty("user.home");
		StringBuffer eclFolderPath = new StringBuffer();
		
		String eclipseLaunchProp = System.getProperty("eclipse.launcher");
		// System.out.println(eclipseProp);
		String[] arrPath = eclipseLaunchProp.split("\\\\");
		for(int i=0; i<arrPath.length-1; i++) {
			eclFolderPath.append(arrPath[i] + "\\");
		}
		
		// temp
		String s = "";
		
		// move file from eclipse folder path to home drive path
		s = Util.readFileSystemEnv(eclFolderPath.toString(), "sal-output-filter");
		Util.writeFileSystemEnv(homeDrivePath, "sal-output-filter", s);
		
		s = Util.readFileSystemEnv(eclFolderPath.toString(), "sal-script");
		Util.writeFileSystemEnv(homeDrivePath, "sal-script", s);
		
		s = Util.readFileSystemEnv(eclFolderPath.toString(), "sal-to-bttrace");
		Util.writeFileSystemEnv(homeDrivePath, "sal-to-bttrace", s);
	}
}
