package org.be.graphbt.graphiti.wizards.managelibrary;

import java.util.HashMap;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.be.graphbt.graphiti.editor.pages.ManageLibraryPage;
/**
 * Class to define the contents of manage component wizard
 * @author GraphBT Team
 *
 */
public class ManageLibraryFirstPageGraphBTWizard extends WizardPage {

	private HashMap<Integer,String> map;
	private DiagramEditor d;
	public ManageLibraryFirstPageGraphBTWizard(HashMap<Integer,String> map, DiagramEditor d) {
		super("Manage Library Wizard");
		setTitle("Manage Library Wizard");
		setDescription("Manage library of the project.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		ManageLibraryPage container = new ManageLibraryPage(parent, SWT.NULL,d);
		setControl(container);
	}
	
}
