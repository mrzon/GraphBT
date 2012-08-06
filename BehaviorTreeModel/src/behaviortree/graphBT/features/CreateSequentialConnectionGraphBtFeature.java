package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import behaviortree.BehaviortreeFactory;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.StandardNode;


public class CreateSequentialConnectionGraphBtFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateSequentialConnectionGraphBtFeature(IFeatureProvider fp) {
		super(fp, "Sequential", "Creates a new sequential edge between nodes");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getStandardNode(context.getSourceAnchor()) != null) {
			System.out.println("can start connection.");
            return true;
        }
        return false;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		StandardNode source = getStandardNode(context.getSourceAnchor());
		StandardNode target = getStandardNode(context.getTargetAnchor());
		System.out.println("can start create connection.");
        if (source != null && target != null && source != target) {
            return true;
        }
        return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null; 

        // get EClasses which should be connected
        StandardNode source = getStandardNode(context.getSourceAnchor());
        StandardNode target = getStandardNode(context.getTargetAnchor());
        
        
        if (source != null && target != null) {
            // create new business object
            Edge edge = createEdge(source, target);
            
            // add connection for business object
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(edge);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
        
        return newConnection;
	}
	
    private StandardNode getStandardNode(Anchor anchor) {
        if (anchor != null) {
            Object object =
                getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof StandardNode) {
                return (StandardNode) object;
            }
        }
        return null;
    }
    
    
    private Edge createEdge(StandardNode source, StandardNode target) {
//        Edge edge = BehaviortreeFactory.eINSTANCE.createEdge();
//        
//        edge.setChildNode(target);
//        
//        edge.setComposition(Composition.SEQUENTIAL);
//        source.getEdge().add(edge);
//        
//        return edge;
    	Edge edge = source.getEdge();
        if(edge == null)
        {
        	edge = BehaviortreeFactory.eINSTANCE.createEdge();
        	edge.setComposition(Composition.SEQUENTIAL);
        	source.setEdge(edge);
        }
        edge.getChildNode().add(target);
        return edge;
   }
}
