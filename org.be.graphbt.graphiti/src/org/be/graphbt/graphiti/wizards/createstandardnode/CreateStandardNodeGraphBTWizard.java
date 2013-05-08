package org.be.graphbt.graphiti.wizards.createstandardnode;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;

import org.be.graphbt.model.graphbt.StandardNode;

public class CreateStandardNodeGraphBTWizard extends Wizard {

	protected CreateStandardNodeFirstPageGraphBTWizard one;
	protected HashMap<Integer, String> map;
	protected DiagramEditor d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateStandardNodeGraphBTWizard(HashMap<Integer, String> map, DiagramEditor d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new CreateStandardNodeFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
