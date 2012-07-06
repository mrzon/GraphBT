package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Operator;
import behaviortree.Requirements;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;


public class UpdateGraphBtFeature extends AbstractUpdateFeature {
 
    public UpdateGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a StandardNode
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        
        System.out.println("check if standard node: " + (bo instanceof StandardNode));
        
        //this.getAllBusinessObjectsForPictogramElement(context.getPictogramElement());
        return ((bo instanceof StandardNode));
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       	StandardNode node = (StandardNode) bo;
        String tLink = node.getTraceabilityLink().getKey();
        String operator = node.getOperator().getLiteral();
        String behavior = node.getBehavior().getBehaviorName();
        String component = node.getComponent().getComponentName();
        String tStatus = node.getTraceabilityStatus().getLiteral();
            
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramName = text.getValue();
                 // update needed, if names are different
                    boolean updateNameNeeded =
                        ((pictogramName == null && tLink != null) ||
                        		(pictogramName == null && tStatus != null) ||
                        		(pictogramName == null && operator != null) ||
                        		(pictogramName == null && behavior != null) ||
                        		(pictogramName == null && component != null) ||
                            (pictogramName != null && !pictogramName.equals(tLink)) ||
                            (pictogramName != null && !pictogramName.equals(tStatus)) ||
                            (pictogramName != null && !pictogramName.equals(behavior)) ||
                            (pictogramName != null && !pictogramName.equals(component)) ||
                            (pictogramName != null && !pictogramName.equals(operator))
                        );
                    if (updateNameNeeded) {
                        return Reason.createTrueReason("Name is out of date");
                    } 
                }
            }
        }
        
            return Reason.createFalseReason();
        
        // retrieve name from business model
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
    	StandardNode node = (StandardNode) bo;
        String t1 = node.getTraceabilityLink().getKey();
        String o = node.getOperator().getLiteral();
        String b = node.getBehavior().getBehaviorName();
        String c = node.getComponent().getComponentName();
        String ts = node.getTraceabilityStatus().getLiteral();
        System.out.println("in update.. value of bo "+bo);
        // Set name in pictogram model
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
                }
            }
        }
 
        return false;
    }
}