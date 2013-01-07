package behaviortree.graphBT.wizards.addcode;

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
import behaviortree.graphBT.editors.*;
/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class AddCodeGraphBTWizard extends Wizard {

	protected AddCodeFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;
	private Behavior b = null;
	public AddCodeGraphBTWizard(HashMap<Integer,String> m, Component c, Behavior b) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
		map = m;
		this.b = b;
	}

	@Override
	public void addPages() {
		one = new AddCodeFirstPageGraphBTWizard(map,c,b);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		if(map.get(Behavior.DETAIL_VALUE) == null||map.get(Behavior.DETAIL_VALUE).equals("")) {
			return false;
		}
		return true;
	}
}
