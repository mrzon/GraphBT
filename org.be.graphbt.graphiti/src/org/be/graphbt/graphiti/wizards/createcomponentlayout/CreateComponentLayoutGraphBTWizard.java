package org.be.graphbt.graphiti.wizards.createcomponentlayout;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Attribute;
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
public class CreateComponentLayoutGraphBTWizard extends Wizard {

	protected CreateComponentLayoutFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	private Diagram d = null;

	public CreateComponentLayoutGraphBTWizard(HashMap<Integer, String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}
	
	@Override
	public void addPages() {
		one = new CreateComponentLayoutFirstPageGraphBTWizard(map,d);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
