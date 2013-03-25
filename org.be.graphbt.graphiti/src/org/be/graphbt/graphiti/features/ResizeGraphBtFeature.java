package org.be.graphbt.graphiti.features;

import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.LayoutList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Class to define resize feature for BT node  
 * of two connected BT node
 * @author GraphBT Team
 *
 */
public class ResizeGraphBtFeature extends DefaultResizeShapeFeature {

	public ResizeGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}

	/**
	 * Disables resize functionality for BT node
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object ob = getBusinessObjectForPictogramElement(pe);
		if(ob instanceof LayoutList || ob instanceof Layout) {
			return true;
		}
		return false;
	}
	
	@Override
	public void resizeShape(IResizeShapeContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object ob = getBusinessObjectForPictogramElement(pe);
		if(ob instanceof LayoutList){
			
		} else if(ob instanceof Layout) {
			Layout l = (Layout) ob;
			l.setHeight(context.getHeight());
			l.setWidth(context.getWidth());
			Image image = (Image)pe.getGraphicsAlgorithm();
			image.setHeight(context.getHeight());
			image.setWidth(context.getWidth());
			image.setStretchH(true);
			image.setStretchV(true);
			image.setProportional(true);
		}
		super.resizeShape(context);
	}
}