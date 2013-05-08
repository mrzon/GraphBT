package org.be.graphbt.graphiti.wizards.addcode;

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
        RecordingCommand cmd;
        
        	cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
				protected void doExecute() {
					b.setTechnicalDetail(map.get(Behavior.DETAIL_VALUE));
				}
			};
        
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
		return true;
	}
}
