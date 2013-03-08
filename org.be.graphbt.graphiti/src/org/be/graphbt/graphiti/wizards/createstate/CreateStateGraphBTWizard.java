package org.be.graphbt.graphiti.wizards.createstate;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.GraphBTFactory;
import org.be.graphbt.model.graphbt.State;

public class CreateStateGraphBTWizard extends Wizard {

	protected CreateStateFirstPageGraphBTWizard one;
	protected HashMap<Integer, String> map;
	protected Component c;
	protected State s;

	public CreateStateGraphBTWizard(Component c, State state) {
		super();
		setNeedsProgressMonitor(true);
		this.c = c;
		this.s = state;
		this.map = new HashMap<Integer,String>();
	}

	public CreateStateGraphBTWizard(Component c2) {
		super();
		setNeedsProgressMonitor(true);
		this.c = c2;
		this.map = new HashMap<Integer,String>();
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		if(s == null) {
			s = GraphBTUtil.getBEFactory().createState();
		}
		one = new CreateStateFirstPageGraphBTWizard(map,c,s);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		if(map.get(State.NAME_VALUE).equals("") ||
				map.get(State.NAME_VALUE) == null) {
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
        if(!c.getState().contains(s)) {
			s.setName(map.get(State.NAME_VALUE));
			s.setDesc(map.get(State.DESC_VALUE)==null?"":map.get(State.DESC_VALUE));
			s.setRef(map.get(State.ID_VALUE));
			s.setAttributes(GraphBTFactory.eINSTANCE.createMapInformation());
			cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
				protected void doExecute() {
					c.getState().add(s);
			    }
			};
        }
        else {
        	cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
				protected void doExecute() {
					s.setName(map.get(State.NAME_VALUE));
					s.setDesc(map.get(State.DESC_VALUE)==null?"":map.get(State.DESC_VALUE));
					s.setRef(map.get(State.ID_VALUE));
				}
			};
        }
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		return true;
	}
}
