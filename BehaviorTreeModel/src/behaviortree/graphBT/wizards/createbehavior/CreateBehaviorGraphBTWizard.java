package behaviortree.graphBT.wizards.createbehavior;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

public class CreateBehaviorGraphBTWizard extends Wizard {

	protected CreateBehaviorFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateBehaviorGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new CreateBehaviorFirstPageGraphBTWizard(map,c);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		//System.out.println(one.getText1());
		//System.out.println(two.getText1());
		if(map.get(Behavior.BEHAVIOR_NAME).equals("")||map.get(Behavior.BEHAVIOR_REF).equals("")||
				map.get(Behavior.BEHAVIOR_NAME)==null||map.get(Behavior.BEHAVIOR_REF)==null)
		{
			return false;
		}
		final Behavior b = GraphBTUtil.getBEFactory().createBehavior();
		b.setBehaviorName(map.get(Behavior.BEHAVIOR_NAME));
		b.setBehaviorRef(map.get(Behavior.BEHAVIOR_REF));
		b.setBehaviorType(BehaviorType.getByName(map.get(Behavior.BEHAVIOR_TYPE)));
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor)
        {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				c.getBehaviors().add(b);
		    }
		};
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		
		
		return true;
		
	}
}
