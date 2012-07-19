package behaviortree.graphBT.wizards;

import org.eclipse.jface.wizard.Wizard;

import behaviortree.StandardNode;

public class CreateStandardNodeGraphBTWizard extends Wizard {

	protected CreateStandardNodeFirstPageGraphBTWizard one;
	protected String stringCarrier[];
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateStandardNodeGraphBTWizard(String[] stringCarrier) {
		super();
		setNeedsProgressMonitor(true);
		this.stringCarrier = stringCarrier;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new CreateStandardNodeFirstPageGraphBTWizard(stringCarrier);
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
