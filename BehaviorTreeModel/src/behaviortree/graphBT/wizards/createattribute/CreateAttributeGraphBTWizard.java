package behaviortree.graphBT.wizards.createattribute;

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
public class CreateAttributeGraphBTWizard extends Wizard {

	protected CreateAttributeFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;

	public CreateAttributeGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}

	@Override
	public void addPages() {
		one = new CreateAttributeFirstPageGraphBTWizard(map,c);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		if(map.get(Attribute.NAME_VALUE).equals("") ||
				map.get(Attribute.NAME_VALUE) == null) {
			return false;
		}
		final Attribute b = GraphBTUtil.getBEFactory().createAttribute();
		b.setName(map.get(Attribute.NAME_VALUE));
		//b.setDesc(map.get(Attribute.DESC_VALUE));
		b.setValue(map.get(Attribute.VAL_VALUE)==null?b.getDefaultValue(map.get(Attribute.TYPE_VALUE)):map.get(Attribute.VAL_VALUE));
		b.setType(map.get(Attribute.TYPE_VALUE));
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

        Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				c.getAttributes().add(b);
		    }
		};
		
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		
		return true;
	}
}
