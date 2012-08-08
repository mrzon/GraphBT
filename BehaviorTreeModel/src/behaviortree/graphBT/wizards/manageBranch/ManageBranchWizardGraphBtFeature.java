package behaviortree.graphBT.wizards.manageBranch;


import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.Wizard;

public class ManageBranchWizardGraphBtFeature extends Wizard {

	protected ManageBranchFirstPageWizardGraphBtFeature one;
	protected HashMap<Integer, String> map;
	protected Diagram d;

	public ManageBranchWizardGraphBtFeature(HashMap<Integer, String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		one = new ManageBranchFirstPageWizardGraphBtFeature(map, d);
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
