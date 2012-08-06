package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;


public class UpdateGraphBtFeature extends AbstractUpdateFeature {
 
    public UpdateGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a StandardNode
    	PictogramElement pictogramElement = context.getPictogramElement();
    	Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        //Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	
        
        System.out.println("in update check if standard node: " + (bo instanceof StandardNode));
        
        //this.getAllBusinessObjectsForPictogramElement(context.getPictogramElement());
        return ((bo instanceof Component)||(bo instanceof Behavior));
//        return bo instanceof StandardNode;
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
        if(!(oSN instanceof StandardNode))
        {
        	return Reason.createFalseReason();
        }
       	StandardNode node = (StandardNode) oSN;
       	
       	System.out.println("This is updateNeeded method");
        String businessName = null;
		if (bo instanceof Component) {
			Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef());
			if(c != null)
			{
				businessName = c.getComponentName();
				System.out.println("This is updateNeeded method bo instanceof component: " + businessName);
			}
		}
		else if (bo instanceof Behavior) {
			if(node.getBehaviorRef()!=null) {
				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef());
				businessName = GraphBTUtil.getBehaviorFromComponentByRef(c, node.getBehaviorRef()).toString();
				
			}
			else {
				businessName = null;
			}
		}
		if(((Shape)pictogramElement).getGraphicsAlgorithm() instanceof Text)
		{
			pictogramName = ((Text)((Shape)pictogramElement).getGraphicsAlgorithm()).getValue();
		}

		// update needed, if names are different
		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName
				.equals(businessName)));
		if (updateNameNeeded) {
			System.out.println("Update is needed!");
			return Reason.createTrueReason("Name is out of date"); //$NON-NLS-1$
		} else {
			return Reason.createFalseReason();
		}
        // retrieve name from business model
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	StandardNode node = (StandardNode) oSN;
        System.out.println("in update.. value of bo "+bo);
        // Set name in pictogram model
        if (bo instanceof Component) {
        	businessName = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef()).getComponentName();
            Shape shape = (Shape) pictogramElement;
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
             }
        }
        if (bo instanceof Behavior) {
        	businessName = GraphBTUtil.getBehaviorFromComponentByRef(GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef()), node.getBehaviorRef()).toString();
            Shape shape = (Shape) pictogramElement;
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
             }
        }
        return false;
    }
}
