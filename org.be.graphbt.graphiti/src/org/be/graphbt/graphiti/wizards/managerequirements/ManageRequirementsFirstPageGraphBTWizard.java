package org.be.graphbt.graphiti.wizards.managerequirements;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.be.graphbt.graphiti.editor.pages.ManageRequirementPage;;

/**
 * Class to define the contents of manage requirement wizard
 * @author GraphBT Team
 *
 */
public class ManageRequirementsFirstPageGraphBTWizard extends WizardPage {


	private HashMap<Integer,String> map;
	private Diagram d;


	public ManageRequirementsFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Manage Requirement Wizard");
		setTitle("Manage Requirement Wizard");
		setDescription("Manage the requirement elements.");		
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		ManageRequirementPage container = new ManageRequirementPage(parent, SWT.NULL,d,map);
		setControl(container);
	}
}