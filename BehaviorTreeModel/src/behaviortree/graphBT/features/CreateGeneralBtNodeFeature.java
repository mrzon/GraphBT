package behaviortree.graphBT.features;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import behaviortree.*;


public class CreateGeneralBtNodeFeature extends AbstractCreateFeature  implements
ICreateFeature {

    public CreateGeneralBtNodeFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "General BT Node", "Create Behavior Tree Node");
    }

    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
        
		Resource resource = context.getTargetContainer().eResource();
		
		//add component here
		//resource.getContents().
		
		// Create a new chess board and add it to an EMF resource
		StandardNode node = BehaviortreeFactory.eINSTANCE.createStandardNode();
		resource.getContents().add(node);
		node.setBehavior("new behavior");
		node.setBehaviorType(BehaviorType.STATE_REALIZATION);
		node.setOperator(Operator.NO_OPERATOR);
		
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
