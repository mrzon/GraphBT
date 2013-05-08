package org.be.graphbt.graphiti.wizards.managerequirements;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;

public class ManageRequirementsGraphBTWizard extends Wizard {

	protected ManageRequirementsFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected DiagramEditor d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public ManageRequirementsGraphBTWizard(HashMap<Integer,String> map, DiagramEditor d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new ManageRequirementsFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		return true;
		
	}
}