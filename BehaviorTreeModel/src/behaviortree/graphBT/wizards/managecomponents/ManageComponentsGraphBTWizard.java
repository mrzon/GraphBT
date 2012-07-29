package behaviortree.graphBT.wizards.managecomponents;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.Wizard;

import behaviortree.BEModel;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

public class ManageComponentsGraphBTWizard extends Wizard {

	protected ManageComponentsFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public ManageComponentsGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
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
		
		BEModel be = GraphBTUtil.getBEModel(d);
		
		System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
		Component c = GraphBTUtil.getBEFactory().createComponent();
		//if(map.get(Component.COMPONENT_NAME)!=null||map.get(Component.COMPONENT_NAME)!="")
		c.setComponentName(map.get(Component.COMPONENT_NAME));
		c.setComponentRef(map.get(Component.COMPONENT_REF));
		
		//if(!c.getComponentName().equals("")&&c.getComponentName()!=null)
		try {
			GraphBTUtil.saveToModelFile(c, d);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		be.getComponentList().getComponents().add(c);
		
		return true;
		
	}
}
