package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.LayoutList;
import org.be.graphbt.model.graphbt.StandardNode;


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
            
            if(bo instanceof StandardNode) {
            	StandardNode node = (StandardNode)bo;
            	if(node.getEdge()==null && node.getParent() == null)
            		return true;
            } else if(bo instanceof Layout || bo instanceof LayoutList) {
            	return true;
            }
        }
        return false;
    }
    
    @Override
    public void moveShape(IMoveShapeContext context) {
    	Shape shape = context.getShape();
        Object bo = getBusinessObjectForPictogramElement(shape);
        if(bo instanceof Layout){
        	Layout l = (Layout)bo;
        	l.setX(context.getX());
        	l.setY(context.getY());
        } else if (bo instanceof LayoutList) {
        	
        }
        super.moveShape(context);
    }
}
