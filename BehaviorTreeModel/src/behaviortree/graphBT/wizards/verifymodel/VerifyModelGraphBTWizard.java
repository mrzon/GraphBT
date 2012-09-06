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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
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
		if(flagVerRes != null && flagVerRes.equalsIgnoreCase("true")) {
			translateAndSaveVerificationResult();
		}
		if(flagFormula != null && flagFormula.equalsIgnoreCase("true")) {
			saveFormulaToFile();
		}
		
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 */
	private void translateAndSaveVerificationResult() {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model");
		
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		{
			Path path = new Path(uri.toPlatformString(true));
			IFile btIFile = workspaceRoot.getFile(path);
			
			try {
				InputStream is = btIFile.getContents();
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
			    String inputLine;
			    StringBuffer res = new StringBuffer();
			 
			    while ((inputLine = in.readLine()) != null) {
			        Log.d(inputLine);
			        res.append(inputLine);
			    }
			 
			    in.close();
			} catch(Exception e) {
				
			}
		}
			
		
	}
}
