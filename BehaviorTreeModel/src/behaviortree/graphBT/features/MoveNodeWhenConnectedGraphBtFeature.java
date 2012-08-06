package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.AbstractMoveShapeFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.func.IMoveShape;

import behaviortree.StandardNode;

public class MoveNodeWhenConnectedGraphBtFeature 
	extends AbstractMoveShapeFeature implements IMoveShape {

	public MoveNodeWhenConnectedGraphBtFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		if(getBusinessObjectForPictogramElement(context.getPictogramElement()) 
				instanceof StandardNode){
			StandardNode node = 
					(StandardNode) getBusinessObjectForPictogramElement(
							context.getPictogramElement());
			
			return true;
		}
		return false;
	}

	@Override
	public void moveShape(IMoveShapeContext context) {
//		context.getTargetConnection().
		
	}
}
