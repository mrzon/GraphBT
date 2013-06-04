package org.be.graphbt.graphiti.wizards.createuses;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.*;
/**
 * Class for mananing the create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateUsesGraphBTWizard extends Wizard {

	protected CreateUsesFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Component c;
	private Diagram d = null;

	public CreateUsesGraphBTWizard(Component c, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = new HashMap<Integer,String>();
		this.c = c;
		this.d = d;
	}
	
	@Override
	public void addPages() {
		one = new CreateUsesFirstPageGraphBTWizard(map,c,d);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		if(map.get(0) == null) {
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
        final BEModel model = GraphBTUtil.getBEModel(d);
        RecordingCommand cmd;
        cmd = new RecordingCommand(ds.getEditingDomain(), "Add uses") {
    				protected void doExecute() {
        for(Library l:model.getLibraries().getImport()) {
        	if(l.getId().equals(map.get(0))) {
    					c.getUses().add(EcoreUtil.copy(l));
    					c.getAttributes().addAll(EcoreUtil.copyAll(l.getAttributes()));
    					c.getBehaviors().addAll(EcoreUtil.copyAll(l.getBehaviors()));
    					c.getState().addAll(EcoreUtil.copyAll(l.getStates()));
    					break;
    			    }
	        	}
	        }
		};
    		TransactionalEditingDomain f = ds.getEditingDomain();
    		f.getCommandStack().execute(cmd);	
		return true;
	}
}
