package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import behaviortree.Edge;
import behaviortree.GraphBTUtil;
import behaviortree.Link;
import behaviortree.StandardNode;

public class DeleteConnectionGraphBTFeature extends DefaultDeleteFeature{

	public DeleteConnectionGraphBTFeature(
			IFeatureProvider fp) {
		super(fp);
		System.out.println("Delete Connection Graph BT Feature");
		// TODO Auto-generated constructor stub
	}
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe !=null)
		{
			Object ob = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		 	if(ob instanceof Link)
		 	{
		 	 	return true;
		 	}
		}
		return false;
	}
	public void preDelete(IDeleteContext deleteContext) {
		Link link = (Link) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(deleteContext.getPictogramElement());
		
		StandardNode node = (StandardNode) link.getTarget();
		node.setParent(null);
		node.setLeaf(false);
		GraphBTUtil.getRoots(getDiagram().eResource().getResourceSet()).get(0).eResource().getContents().add(node);
		
		link.getSource().getEdge().getChildNode().remove(link);
		if(link.getSource().getEdge().getChildNode().size()==0)
		{
			link.getSource().setEdge(null);
		}
		else if(link.getSource().getEdge().getChildNode().size()==1)
		{
			link.getSource().getEdge().setBranch(null);
		}
		link.setSource(null);
		link.setTarget(null);
		System.out.println("URI dari standardnodenya "+GraphBTUtil.getRoots(getDiagram().eResource().getResourceSet()).get(0).eResource().getURI().toString());
	}
}
