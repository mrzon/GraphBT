package behaviortree.graphBT.wizards.detailcomponent;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.Attribute;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.graphBT.editors.MultiPageEditor;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorFirstPageGraphBTWizard;

/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class DetailComponentGraphBTWizard extends Wizard {

	protected DetailComponentFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;

	public DetailComponentGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}

	@Override
	public void addPages() {
		one = new DetailComponentFirstPageGraphBTWizard(map,c);
		addPage(one);
	}

	@Override
	public boolean performFinish() {				
		IWorkbenchPage page=PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage();
        DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else {
        	ds = ((MultiPageEditor)page.
        			getActiveEditor()).getDiagramEditor();
        }
        Command cmd;
		cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				c.setComponentDesc(map.get(Component.DESC_VALUE));
			}
		};
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		return true;
	}
}
