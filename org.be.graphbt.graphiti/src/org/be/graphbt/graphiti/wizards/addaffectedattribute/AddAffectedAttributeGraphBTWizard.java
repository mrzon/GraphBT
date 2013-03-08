package org.be.graphbt.graphiti.wizards.addaffectedattribute;

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
import org.be.graphbt.model.graphbt.Information;
import org.be.graphbt.model.graphbt.MapInformation;
import org.be.graphbt.model.graphbt.State;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.*;
/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class AddAffectedAttributeGraphBTWizard extends Wizard {

	protected AddAffectedAttributeFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;
	private State a = null;
	private String selected;
	public AddAffectedAttributeGraphBTWizard(Component c) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
	}
	public AddAffectedAttributeGraphBTWizard(Component c, State a,String s) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
		this.a = a;
		selected = s;
	}
	
	@Override
	public void addPages() {
		one = new AddAffectedAttributeFirstPageGraphBTWizard(map,c,a,selected);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		System.out.println(map);
		if(map.get(Attribute.NAME_VALUE) == null || map.get(Attribute.NAME_VALUE).equals("")
				) {
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
		final MapInformation mapInfo= a.getAttributes();
		cmd = new RecordingCommand(ds.getEditingDomain(), "Set affected attribute") {
			protected void doExecute() {
				mapInfo.setValue(map.get(Attribute.NAME_VALUE),map.get(Attribute.VAL_VALUE));
		    }
		};
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		
		return true;
	}
}
