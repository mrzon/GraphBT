package behaviortree.graphBT.wizards.createbehavior;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;

/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateBehaviorGraphBTWizard extends Wizard {

	protected CreateBehaviorFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;

	public CreateBehaviorGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}

	@Override
	public void addPages() {
		one = new CreateBehaviorFirstPageGraphBTWizard(map,c);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		if(map.get(Behavior.NAME_VALUE).equals("") ||
				map.get(Behavior.REF_VALUE).equals("") ||
				map.get(Behavior.NAME_VALUE) == null ||
				map.get(Behavior.REF_VALUE) == null) {
			return false;
		}
		final Behavior b = GraphBTUtil.getBEFactory().createBehavior();
		b.setBehaviorName(map.get(Behavior.NAME_VALUE));
		b.setBehaviorDesc(map.get(Behavior.DESC_VALUE));
		b.setBehaviorRef(map.get(Behavior.REF_VALUE));
		b.setBehaviorType(BehaviorType.getByName(map.get(Behavior.TYPE_VALUE)));
		IWorkbenchPage page=PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage();
        DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else {
        	ds = ((behaviortree.editor.MultiPageEditor)page.
        			getActiveEditor()).getDiagramEditor();
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
