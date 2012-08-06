package behaviortree.graphBT.features;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import behaviortree.*;
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
    /*
    public void createNewModel(String modelName)
    {
		System.out.println("Create new model, named modelName");
		try {
			GraphBTUtil.saveToModelFile(GraphBTUtil.createNewModel(modelName), getDiagram());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
    
    public void initiateBT(Node node)
    {
    	beModel.setDbt(GraphBTUtil.getBEFactory().createBehaviorTree());
    	beModel.getDbt().setRootNode(node);
    }
    
    public Object[] create(ICreateContext context) {
        
		Resource resource = getDiagram().eResource();
//		ResourceSet rs = resource.getResourceSet();
		HashMap <Integer,String> map = new HashMap <Integer,String>(); 
		
		//invokeCreateStandardNodeWizard(wizardCarrier);
		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
                getActiveWorkbenchWindow().getShell(),
    		new CreateStandardNodeGraphBTWizard(map, getDiagram()));
    		
		if (wizardDialog.open() != Window.OK) {
			return null;
		} 
		
		// Create a new node and add it to an EMF resource
		StandardNode node = BehaviortreeFactory.eINSTANCE.createStandardNode();
		resource.getContents().add(node);
		/*URI uri = URI.createURI("bt.model");
		System.out.println("Di method create sih resourcesetnya ini "+rs);
		if(GraphBTUtil.isExist(rs, uri)&&rs.getResource(uri, true).getContents().size()>0)
		{
			System.out.println("1 Akhirnya kepanggil juga :DD");
			beModel = (BEModel)rs.getResource(uri, true).getContents().get(0);
		}
		else
		{
			try 
			{
				beModel = GraphBTUtil.getBEFactory().createBEModel();
				beModel.setName("BTPackage");
				Resource createResource = rs.createResource(uri);
				createResource.getContents().add(beModel);
				System.out.println("udah dimasukin tuh, cek size =" + createResource.getContents().size());
				createResource.save(Collections.emptyMap());
				createResource.setTrackingModification(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		BEModel beModel = GraphBTUtil.getBEModel(getDiagram());
		//set the operator as no operator
		node.setOperator(Operator.NO_OPERATOR);
		
		Component c=null;
//	    c.setComponentName("DefaultComponent");
		if(map.get(StandardNode.STANDARDNODE_COMPONENT)==null ||(map.get(StandardNode.STANDARDNODE_COMPONENT)!=null&&map.get(StandardNode.STANDARDNODE_COMPONENT).equals(""))){
			c = BehaviortreeFactory.eINSTANCE.createComponent();
			c.setComponentName("DefaultComponent");
		}
		else{
			c=GraphBTUtil.getComponent(beModel, map.get(StandardNode.STANDARDNODE_COMPONENT));
		}
		
	    node.setComponentRef(c.getComponentRef());
	    
	    Behavior b = null;
	    if(map.get(StandardNode.STANDARDNODE_BEHAVIOR).equals("")){
			b = BehaviortreeFactory.eINSTANCE.createBehavior();
			b.setBehaviorName("DefaultBehavior");
		}
		else{
			b=GraphBTUtil.getBehaviorFromComponent(c, map.get(StandardNode.STANDARDNODE_BEHAVIOR));
		}
		
	    node.setBehaviorRef(b.getBehaviorRef());
	    
	    Requirement r = null;
	    if(!map.get(StandardNode.STANDARDNODE_TRACEABILITYLINK).equals("")){
			b=GraphBTUtil.getBehaviorFromComponent(c, map.get(StandardNode.STANDARDNODE_TRACEABILITYLINK));
		}
	
		node.setTraceabilityLink(r);
		//set the traceability status as original
		node.setTraceabilityStatus(TraceabilityStatus.getByName(map.get(StandardNode.STANDARDNODE_TRACEABILITYSTATUS)));
		
		//node.setBehaviorType(BehaviorType.STATE_REALIZATION);
		
		if(beModel != null)
		{
			System.out.println("Be model ternyata ga null :p");		
		}
		else
		{
			beModel = GraphBTUtil.getBEFactory().createBEModel();
			beModel.setName("Model");
			resource.getContents().add(beModel);
		}
		if(beModel.getComponentList()==null)
		{
			System.out.println("inisialisasi component list");
			beModel.setComponentList(GraphBTUtil.getBEFactory().createComponentList());
		}
		if(beModel.getRequirementList()==null)
		{
			System.out.println("inisialisasi requirement list");
			beModel.setRequirementList(GraphBTUtil.getBEFactory().createRequirementList());
		}
		//beModel.getComponentList().getComponents().add(c);
		//beModel.getRequirementList().getRequirements().add(r);
		if(beModel.getDbt()== null)
		{
			initiateBT(node);
		}
		try {	
			try {
				//GraphBTUtil.saveToModelFile(beModel, getDiagram());
				GraphBTUtil.saveToModelFile(node, getDiagram());
				//GraphBTUtil.saveToModelFile(c, getDiagram());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
//		invokeCreateStandardNodeWizard(node);
		//getFeatureProvider().getDirectEditingInfo().setActive(true);

		// Delegate to the add feature
		addGraphicalRepresentation(context, node);
		
		return new Object[] { node };
     }    
}
