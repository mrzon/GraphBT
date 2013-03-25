package org.be.graphbt.graphiti.wizards.createcomponent;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;

public class CreateComponentGraphBTWizard extends Wizard {

	protected CreateComponentFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateComponentGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new CreateComponentFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
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
		System.out.println(be+"di component nih");
		
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				Component c = GraphBTUtil.getBEFactory().createComponent();
				//if(map.get(Component.COMPONENT_NAME)!=null||map.get(Component.COMPONENT_NAME)!="")
				c.setComponentName(map.get(Component.NAME_VALUE));
				c.setComponentRef(map.get(Component.REF_VALUE));
				c.setComponentDesc(map.get(Component.DESC_VALUE));
				
				be.getComponentList().getComponents().add(c);		
		    }
		};
		ds.getEditingDomain().getCommandStack().execute(cmd);
		return true;
		
	}
}
