package org.be.graphbt.graphiti.features;

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

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Node;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.graphiti.wizards.createstandardnode.CreateStandardNodeGraphBTWizard;

/**
 * Class CreateGeneralBtNodeFeature is for creating BT model 
 * @author GraphBT Team
 *
 */
public class CreateGeneralBtNodeFeature extends AbstractCreateFeature  implements
ICreateFeature {
	private BEModel beModel;
	
    public CreateGeneralBtNodeFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "General BT Node", "Create Behavior Tree Node");
    }

    /**
     * Check whether the BT node model can be created
     */
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
    
    public void initiateBT(Node node) {
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
		
		StandardNode node = GraphBTUtil.getBEFactory().createStandardNode();
		node.setLabel(System.currentTimeMillis()+"");
		resource.getContents().add(node);
		
		BEModel beModel = GraphBTUtil.getBEModel(getDiagram());
		if(map.get(StandardNode.TRACEABILITYSTATUS_VALUE)==null ||(map.get(StandardNode.TRACEABILITYSTATUS_VALUE))!=null&&map.get(StandardNode.COMPONENT_VALUE).equals("")) {
			node.setTraceabilityStatus(TraceabilityStatus.ORIGINAL.getLiteral());
		}
		else {
			node.setTraceabilityStatus(TraceabilityStatus.getByName(map.get(StandardNode.TRACEABILITYSTATUS_VALUE)).getLiteral());
		}
		if(map.get(StandardNode.OPERATOR_VALUE)==null ||(map.get(StandardNode.OPERATOR_VALUE)!=null&&map.get(StandardNode.COMPONENT_VALUE).equals(""))) {
			node.setOperator(Operator.NO_OPERATOR.getLiteral());
		}
		else {
			node.setOperator(Operator.getByName(map.get(StandardNode.OPERATOR_VALUE)).getLiteral());
		}
		
		Component c = null;
		if(map.get(StandardNode.COMPONENT_VALUE)==null ||(map.get(StandardNode.COMPONENT_VALUE)!=null&&map.get(StandardNode.COMPONENT_VALUE).equals(""))) {
			c = GraphBTUtil.getBEFactory().createComponent();
			c.setComponentName("DefaultComponent");
			c.setComponentRef("DefaultComponent");
		}
		else {
			c = GraphBTUtil.getComponent(beModel, map.get(StandardNode.COMPONENT_VALUE));
		}
		
	    node.setComponentRef(c.getComponentRef());
	    
	    Behavior b = null;
	    if(map.get(StandardNode.BEHAVIOR_VALUE).equals("")) {
			b = GraphBTUtil.getBEFactory().createBehavior();
			b.setBehaviorName("DefaultBehavior");
		}
		else {
			b = GraphBTUtil.getBehaviorFromComponent(c, map.get(StandardNode.BEHAVIOR_VALUE));
		}
		
	    node.setBehaviorRef(b.getBehaviorRef());
	    
	    Requirement r = GraphBTUtil.getRequirement(getDiagram(), map.get(StandardNode.TRACEABILITYLINK_VALUE));
	    node.setTraceabilityLink(r==null?null:r.getKey());

		if(beModel != null) {

		}
		else {
			beModel = GraphBTUtil.getBEFactory().createBEModel();
			beModel.setName("Model");
			resource.getContents().add(beModel);
		}
		
		if(beModel.getComponentList() == null) {
			beModel.setComponentList(GraphBTUtil.getBEFactory().createComponentList());
		}
		if(beModel.getRequirementList() == null) {
			beModel.setRequirementList(GraphBTUtil.getBEFactory().createRequirementList());
		}
		if(beModel.getDbt()== null) {
			initiateBT(node);
		}
		
		try {
			GraphBTUtil.saveToModelFile(node, getDiagram());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		
		// Delegate to the add feature
		addGraphicalRepresentation(context, node);
		
		return new Object[] { node };
     }    
}