package org.be.graphbt.graphiti.wizards.managecomponents;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.Wizard;

public class ManageComponentsGraphBTWizard extends Wizard {

	protected ManageComponentsFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public ManageComponentsGraphBTWizard(Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map =  new HashMap<Integer, String>();;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new ManageComponentsFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		//System.out.println(one.getText1());
		//System.out.println(two.getText1());
		
		
		return true;
		
	}
}
