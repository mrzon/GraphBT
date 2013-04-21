package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
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
        	Image image = (Image)shape.getGraphicsAlgorithm();
        	ContainerShape cs = (ContainerShape)shape.eContainer();
			if(cs.getGraphicsAlgorithm().getHeight() < image.getY()+image.getHeight()+10) {
	        	cs.getGraphicsAlgorithm().setHeight(image.getY()+image.getHeight()+10);
	        }
	        if(cs.getGraphicsAlgorithm().getWidth() < image.getX()+image.getWidth()+10) {
	        	cs.getGraphicsAlgorithm().setWidth(image.getX()+image.getWidth()+10);
	        }
        } else if (bo instanceof LayoutList) {
        	
        }
        super.moveShape(context);
    }
}
