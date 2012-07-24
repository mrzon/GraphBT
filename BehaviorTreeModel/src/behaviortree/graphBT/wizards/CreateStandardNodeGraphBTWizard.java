package behaviortree.graphBT.wizards;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.Wizard;

import behaviortree.StandardNode;

public class CreateStandardNodeGraphBTWizard extends Wizard {

	protected CreateStandardNodeFirstPageGraphBTWizard one;
	protected HashMap<Integer, String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public CreateStandardNodeGraphBTWizard(HashMap<Integer, String> map, Diagram d) {
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
		// Print the result to the console
		//System.out.println(one.getText1());
		//System.out.println(two.getText1());
		
		return true;
	}
}
