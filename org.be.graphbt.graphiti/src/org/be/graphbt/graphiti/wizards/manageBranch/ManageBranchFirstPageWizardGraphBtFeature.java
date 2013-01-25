package org.be.graphbt.graphiti.wizards.manageBranch;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.be.graphbt.model.graphbt.Branch;

/**
 * Class to define the contents of manage branch wizard
 * @author GraphBT Team
 *
 */
public class ManageBranchFirstPageWizardGraphBtFeature extends WizardPage {
	
	private Composite container;
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	private Diagram d;
	private CCombo chooseBranchTypeCombo;
	  
	public ManageBranchFirstPageWizardGraphBtFeature(HashMap<Integer, String> map, Diagram d) {
		super("Manage Branch Wizard");
		;
		setTitle("Manage Branch");
		setDescription("Select branch type.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

	    final Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("Select Branch");
		
		chooseBranchTypeCombo = new CCombo(container, SWT.NULL);
		chooseBranchTypeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		for(Branch branch : Branch.VALUES) {
			chooseBranchTypeCombo.add(branch.getLiteral());
		}
		
		chooseBranchTypeCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	CCombo combo = (CCombo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	System.out.println("selected: " + selected);
		    	
		    	map.put(1, selected);
		    	System.out.println("map in wizard: " + map);
		    	changeDialog();
		    }
	    });
		
		setPageComplete(false);
		setControl(container);
	}
	
	private void changeDialog() {
		if(chooseBranchTypeCombo.getSelectionIndex()==-1) {
    		changeDialog("Please select a branch type.");
    	}else {
    		changeDialog(null);
    	}

	}
	private void changeDialog(String message) {
		setErrorMessage(message);
		setPageComplete(message==null);
	}
}