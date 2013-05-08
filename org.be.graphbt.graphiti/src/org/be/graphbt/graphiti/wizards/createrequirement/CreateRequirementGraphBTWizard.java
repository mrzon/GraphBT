package org.be.graphbt.graphiti.wizards.createrequirement;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;

public class CreateRequirementGraphBTWizard extends Wizard {

	protected CreateRequirementFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateRequirementGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new CreateRequirementFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        d = ds.getDiagramTypeProvider().getDiagram();
		final BEModel be = GraphBTUtil.getBEModel(d);
		
		final Requirement r = GraphBTUtil.getBEFactory().createRequirement();
		//if(map.get(Component.COMPONENT_NAME)!=null||map.get(Component.COMPONENT_NAME)!="")
		r.setRequirement(map.get(Requirement.REQUIREMENT_NAME));
		r.setDescription(map.get(Requirement.REQUIREMENT_DESC));		
		r.setKey(map.get(Requirement.REQUIREMENT_KEY));	
		
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
					be.getRequirementList().getRequirements().add(r);
		    }
		};
		ds.getEditingDomain().getCommandStack().execute(cmd);
		return true;
		
	

	}
}