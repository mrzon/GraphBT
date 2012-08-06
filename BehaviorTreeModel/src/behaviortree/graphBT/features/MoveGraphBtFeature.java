package behaviortree.graphBT.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Requirement;


public class MoveGraphBtFeature extends DefaultMoveShapeFeature {
	 
    public MoveGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canMoveShape(IMoveShapeContext context) {
        boolean canMove = super.canMoveShape(context);
 
        // perform further check only if move allowed by default feature
        if (canMove) {
            // don't allow move if the class name has the length of 1
            Shape shape = context.getShape();
            Object bo = getBusinessObjectForPictogramElement(shape);
            if (bo instanceof Component ||
            		bo instanceof Behavior ||
            		bo instanceof Requirement) {
                canMove = false;
            }
        }
        return canMove;
    }
}
