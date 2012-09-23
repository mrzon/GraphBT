package behaviortree.graphBT.features;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

public class DeleteNodeGraphBTFeature extends DefaultDeleteFeature {

	public DeleteNodeGraphBTFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe !=null)
		{
			Object ob = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		 	if(ob instanceof StandardNode)
		 	{
		 	 	return true;
		 	}
		}
		return false;
	}


	public void preDelete(IDeleteContext deleteContext) {
		final StandardNode node = (StandardNode) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(deleteContext.getPictogramElement());

		if(node.getParent()!=null)
		{
			StandardNode parent = node.getParent();
			parent.getEdge().getChildNode().remove(node);
			node.setParent(null);
			if(parent.getEdge().getChildNode().size() ==1)
			{
				parent.getEdge().setBranch(null);
			}
			else if(parent.getEdge().getChildNode().size()==0)
			{
				parent.setEdge(null);
			}
		}
		if(node.getEdge() != null)
		{
			for(int i = 0; i < node.getEdge().getChildNode().size(); i++)
			{
				StandardNode child = (StandardNode) node.getEdge().getChildNode().get(i);
				child.setParent(null);
				child.setLeaf(false);
			}

			GraphBTUtil.getRoots(getDiagram().eResource().getResourceSet()).get(0).eResource().getContents().addAll(node.getEdge().getChildNode());
			node.getEdge().getChildNode().clear();
			node.setEdge(null);
		}
	}
}

