package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.model.graphbt.StandardNode;

public class ConnectionReconnectGraphBTFeature extends DefaultReconnectionFeature {

	public ConnectionReconnectGraphBTFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canReconnect(IReconnectionContext context) {
	//	 //System.out.println("ConnectionReconnectGraphBTFeature canReconnect ndak?? "+ super.canReconnect(context));
		
		if(super.canReconnect(context)) {
			return true;
		}
		return false;
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		 //System.out.println("ConnectionReconnectGraphBTFeature preReconnect try to reconnecting");
		if(context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
			 //System.out.println("reconnect source "+context.toString()); 
			PictogramElement newTarget = context.getNewAnchor().getGraphicsAlgorithm().getPictogramElement();
			PictogramElement  oldChild = context.getConnection().getEnd().getLink().getPictogramElement();
			Object ob = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(newTarget);
			 //System.out.println("reconnect source "+newTarget.getLink().getBusinessObjects()); 
			if(ob instanceof StandardNode) {
				StandardNode parent = (StandardNode)ob;
				Edge e = parent.getEdge();
				if(e==null) {
					e = GraphBTUtil.getBEFactory().createEdge();
					parent.setEdge(e);
				}
				StandardNode nd = (StandardNode)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(oldChild);
				Link l = GraphBTUtil.getBEFactory().createLink();
				l.setSource(parent);
				l.setTarget(nd);
				e.getChildNode().add(l);
				StandardNode od =(StandardNode)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getOldAnchor().getLink().getPictogramElement()); 
				od.getEdge().getChildNode().remove(nd);
				 //System.out.println("ConnectionReconnectGraphBTFeature preReconnect old Parent "+ od.toString());
			}
		}
		else
		{
			
		}
	}


	@Override
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IReconnectionContext) {
			ret = canReconnect((IReconnectionContext) context);
		}
		return ret;
	}

	@Override
	public void execute(IContext context) {
		if (context instanceof IReconnectionContext) {
			reconnect((IReconnectionContext) context);
		}
	}
}
