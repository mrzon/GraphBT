package org.be.graphbt.graphiti.wizards.managecomponents;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.be.graphbt.graphiti.editor.pages.ManageComponentPage;

/**
 * Class to define the contents of manage component wizard
 * @author GraphBT Team
 *
 */
public class ManageComponentsFirstPageGraphBTWizard extends WizardPage {

	private ManageComponentPage container;
	private HashMap<Integer,String> map;
	private Diagram d;

	public ManageComponentsFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Manage Components Wizard");
		setTitle("Manage Components Wizard");
		setDescription("Manage components for the Behavior Tree.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new ManageComponentPage(parent, SWT.NULL,d,map);
		setControl(container);
	}
}
