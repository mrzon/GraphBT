package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.model.graphbt.StandardNode;

public class DeleteConnectionGraphBTFeature extends DefaultDeleteFeature{

	public DeleteConnectionGraphBTFeature(
			IFeatureProvider fp) {
		super(fp);
	}
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe !=null) {
			Object ob = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		 	if(ob instanceof Link) {
		 	 	return true;
		 	}
		}
		return false;
	}
	public void preDelete(IDeleteContext deleteContext) {
		Link link = (Link) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(deleteContext.getPictogramElement());
		
		StandardNode node = (StandardNode) link.getTarget();
		if(node == null) {
			return;
		}
		node.setParent(null);
		node.setLeaf(false);
		GraphBTUtil.getRoots(getDiagram().eResource().getResourceSet()).get(0).eResource().getContents().add(node);
		
		link.getSource().getEdge().getChildNode().remove(link);
		if(link.getSource().getEdge().getChildNode().size()==0) {
			link.getSource().setEdge(null);
		}
		else if(link.getSource().getEdge().getChildNode().size()==1) {
			link.getSource().getEdge().setBranch(null);
		}
		link.setSource(null);
		link.setTarget(null);
	}
}
