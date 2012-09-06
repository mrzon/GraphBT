package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Requirement;
import behaviortree.StandardNode;


public class MoveGraphBtFeature extends DefaultMoveShapeFeature {
	 
    public MoveGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        boolean canMove = super.canMoveShape(context);
 
        if (canMove) {
            Shape shape = context.getShape();
            Object bo = getBusinessObjectForPictogramElement(shape);
            
            if(bo instanceof StandardNode)
            {
            	StandardNode node = (StandardNode)bo;
            	if(node.getEdge()==null && node.getParent() == null)
            		return true;
            }
        }
        return false;
    }
}
