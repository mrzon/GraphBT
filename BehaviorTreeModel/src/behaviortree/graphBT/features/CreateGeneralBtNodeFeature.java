package behaviortree.graphBT.features;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviortreeFactory;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Node;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.CreateStandardNodeGraphBTWizard;


public class CreateGeneralBtNodeFeature extends AbstractCreateFeature  implements
ICreateFeature {
	private BEModel beModel;
	
    public CreateGeneralBtNodeFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "General BT Node", "Create Behavior Tree Node");
    }

    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
    
    public void initiateBT(Node node)
    {
    	beModel.setDbt(GraphBTUtil.getBEFactory().createBehaviorTree());
    	beModel.getDbt().setRootNode(node);
    }
    
    public Object[] create(ICreateContext context) {
        
		Resource resource = getDiagram().eResource();
		HashMap <Integer,String> map = new HashMap <Integer,String>(); 
		
		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
                getActiveWorkbenchWindow().getShell(),
    		new CreateStandardNodeGraphBTWizard(map, getDiagram()));
    		
		if (wizardDialog.open() != Window.OK) {
			return null;
		} 
		
		StandardNode node = BehaviortreeFactory.eINSTANCE.createStandardNode();
		resource.getContents().add(node);

		BEModel beModel = GraphBTUtil.getBEModel(getDiagram());
		if(map.get(StandardNode.TRACEABILITYSTATUS_VALUE)==null ||(map.get(StandardNode.TRACEABILITYSTATUS_VALUE))!=null&&map.get(StandardNode.COMPONENT_VALUE).equals("")) {
			node.setTraceabilityStatus(TraceabilityStatus.ORIGINAL);
		}
		else {
			node.setTraceabilityStatus(TraceabilityStatus.getByName(map.get(StandardNode.TRACEABILITYSTATUS_VALUE)));
		}
		if(map.get(StandardNode.OPERATOR_VALUE)==null ||(map.get(StandardNode.OPERATOR_VALUE)!=null&&map.get(StandardNode.COMPONENT_VALUE).equals(""))) {
			node.setOperator(Operator.NO_OPERATOR);
		}
		else {
			node.setOperator(Operator.getByName(map.get(StandardNode.OPERATOR_VALUE)));
		}
		
		Component c = null;
		if(map.get(StandardNode.COMPONENT_VALUE)==null ||(map.get(StandardNode.COMPONENT_VALUE)!=null&&map.get(StandardNode.COMPONENT_VALUE).equals(""))) {
			c = BehaviortreeFactory.eINSTANCE.createComponent();
			c.setComponentName("DefaultComponent");
			c.setComponentRef("DefaultComponent");
			
		}
		else {
			System.out.println("awuoo wuoooo"+map.get(StandardNode.COMPONENT_VALUE));
			c = GraphBTUtil.getComponent(beModel, map.get(StandardNode.COMPONENT_VALUE));
		}
		
	    node.setComponentRef(c.getComponentRef());
	    
	    Behavior b = null;
	    if(map.get(StandardNode.BEHAVIOR_VALUE).equals("")) {
			b = BehaviortreeFactory.eINSTANCE.createBehavior();
			b.setBehaviorName("DefaultBehavior");
		}
		else {
			b = GraphBTUtil.getBehaviorFromComponent(c, map.get(StandardNode.BEHAVIOR_VALUE));
		}
		
	    node.setBehaviorRef(b.getBehaviorRef());
	    
	    Requirement r = GraphBTUtil.getRequirement(beModel, map.get(StandardNode.TRACEABILITYLINK_VALUE));
	    node.setTraceabilityLink(r==null?null:r.getKey());

		if(beModel != null) {
			System.out.println("Be model ternyata ga null :p");		
		}
		else {
			beModel = GraphBTUtil.getBEFactory().createBEModel();
			beModel.setName("Model");
			resource.getContents().add(beModel);
		}
		
		if(beModel.getComponentList() == null) {
			System.out.println("inisialisasi component list");
			beModel.setComponentList(GraphBTUtil.getBEFactory().createComponentList());
		}
		if(beModel.getRequirementList() == null) {
			System.out.println("inisialisasi requirement list");
			beModel.setRequirementList(GraphBTUtil.getBEFactory().createRequirementList());
		}
		if(beModel.getDbt()== null) {
			initiateBT(node);
		}
		try {
			try {
				GraphBTUtil.saveToModelFile(node, getDiagram());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		// Delegate to the add feature
		addGraphicalRepresentation(context, node);
		
		return new Object[] { node };
     }    
}