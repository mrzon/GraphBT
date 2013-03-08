package org.be.graphbt.graphiti.wizards.createattribute;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.*;
/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateAttributeGraphBTWizard extends Wizard {

	protected CreateAttributeFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;
	private Attribute a = null;
	public CreateAttributeGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}
	public CreateAttributeGraphBTWizard(Component c, Attribute a) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
		this.a = a;
	}
	
	@Override
	public void addPages() {
		one = new CreateAttributeFirstPageGraphBTWizard(map,c,a);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		if(map.get(Attribute.NAME_VALUE).equals("") ||
				map.get(Attribute.NAME_VALUE) == null) {
			return false;
		}
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
        if(a==null) {
			final Attribute b = GraphBTUtil.getBEFactory().createAttribute();
			b.setName(map.get(Attribute.NAME_VALUE));
			b.setDesc(map.get(Attribute.DESC_VALUE)==null?"":map.get(Attribute.DESC_VALUE));
			b.setType(map.get(Attribute.TYPE_VALUE));
			b.setValue(map.get(Attribute.VAL_VALUE)==null||map.get(Attribute.VAL_VALUE).equals("")?b.getDefaultValue(map.get(Attribute.TYPE_VALUE)):map.get(Attribute.VAL_VALUE));
			cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
				protected void doExecute() {
					c.getAttributes().add(b);
			    }
			};
        }
        else {
        	cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
				protected void doExecute() {
					a.setName(map.get(Attribute.NAME_VALUE));
					a.setType(map.get(Attribute.TYPE_VALUE));		
					a.setValue(map.get(Attribute.VAL_VALUE)==null||map.get(Attribute.VAL_VALUE).equals("")?a.getDefaultValue(map.get(Attribute.TYPE_VALUE)):map.get(Attribute.VAL_VALUE));
					a.setDesc(map.get(Attribute.DESC_VALUE)==null?"":map.get(Attribute.DESC_VALUE));
				}
			};
        }
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		
		return true;
	}
}
