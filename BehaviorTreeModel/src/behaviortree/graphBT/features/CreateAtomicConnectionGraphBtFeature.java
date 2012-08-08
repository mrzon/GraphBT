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
import behaviortree.Branch;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.Node;
import behaviortree.StandardNode;


public class CreateAtomicConnectionGraphBtFeature 
		extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateAtomicConnectionGraphBtFeature(IFeatureProvider fp) {
		super(fp, "Atomic", "Creates a new atomic " +
				"composition edge between nodes");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getStandardNode(context.getSourceAnchor()) != null) {
            return true;
        }
        return false;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		StandardNode source = getStandardNode(context.getSourceAnchor());
		StandardNode target = getStandardNode(context.getTargetAnchor());
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
                new AddConnectionContext(context.getSourceAnchor(), 
                		context.getTargetAnchor());
            addContext.setNewObject(edge);
            newConnection = (Connection) getFeatureProvider().
            		addIfPossible(addContext);
            
            PictogramElement pes = context.getSourcePictogramElement();
            PictogramElement pet = context.getTargetPictogramElement();
            
            pet.getGraphicsAlgorithm().setX(pes.getGraphicsAlgorithm().getX());
            pet.getGraphicsAlgorithm().setY(
            		pes.getGraphicsAlgorithm().getY() + 
            		pes.getGraphicsAlgorithm().getHeight());
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
    	Edge edge = source.getEdge();
        if(edge == null)
        {
        	edge = BehaviortreeFactory.eINSTANCE.createEdge();
        	edge.setComposition(Composition.ATOMIC);
        	source.setEdge(edge);
        }
        edge.getChildNode().add(target);
        return edge;
   }
}
