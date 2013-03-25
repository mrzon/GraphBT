package org.be.graphbt.graphiti.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.GraphBTDiagramEditor;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.model.graphbt.StandardNode;

public class DeleteNodeGraphBTFeature extends DefaultDeleteFeature {

	public DeleteNodeGraphBTFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe !=null) {
			Object ob = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		 	if(ob instanceof StandardNode) {
		 	 	return true;
		 	}
		}
		return false;
	}


	public void preDelete(IDeleteContext deleteContext) {
		final StandardNode node = (StandardNode) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(deleteContext.getPictogramElement());

		if(node.getParent()!=null) {
			StandardNode parent = node.getParent();
			parent.getEdge().getChildNode().remove(node);
			int i =0;
			while(i < parent.getEdge().getChildNode().size()) {
				if(parent.getEdge().getChildNode().get(i).getTarget()==node) {
					parent.getEdge().getChildNode().get(i).setSource(null);
					parent.getEdge().getChildNode().remove(i);
				} else if (parent.getEdge().getChildNode().get(i).getTarget()==null) {
					parent.getEdge().getChildNode().get(i).setSource(null);
					parent.getEdge().getChildNode().remove(i);
					} else {
					i++;
				}
			}
			node.setParent(null);
			if(parent.getEdge().getChildNode().size() ==1) {
				parent.getEdge().setBranch(null);
			}
			else if(parent.getEdge().getChildNode().size()==0) {
				parent.setEdge(null);
			}
		}
		if(node.getOperator().equals("^")) {
			((GraphBTDiagramEditor)getDiagramEditor()).errorReversionNode.remove(node);
			((GraphBTDiagramEditor)getDiagramEditor()).reversionNode.remove(node);
		}
		
		if(node.getEdge() != null) {
			for(int i = 0; i < node.getEdge().getChildNode().size(); i++) {
				StandardNode child = (StandardNode) node.getEdge().getChildNode().get(i).getTarget();
				if(child!=null) {
					child.setParent(null);
					child.setLeaf(false);
				}
			}

			EList<Link> childNodes = node.getEdge().getChildNode();
			EList<EObject> objects = GraphBTUtil.getRoots(getDiagram().eResource().getResourceSet()).get(0).eResource().getContents();
			
			for(int i = 0; i < childNodes.size();i++) {
				if(childNodes.get(i).getTarget() != null)
					objects.add(childNodes.get(i).getTarget());
			}
			node.getEdge().getChildNode().clear();
			node.setEdge(null);
		}
	}
}

