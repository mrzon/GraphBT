package behaviortree.graphBT.features;

import java.util.HashMap;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import behaviortree.BehaviortreeFactory;
import behaviortree.Branch;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.StandardNode;
import behaviortree.graphBT.wizards.CreateStandardNodeGraphBTWizard;
import behaviortree.graphBT.wizards.manageBranch.ManageBranchWizardGraphBtFeature;


public class CreateSequentialConnectionGraphBtFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateSequentialConnectionGraphBtFeature(IFeatureProvider fp) {
		super(fp, "Sequential", "Creates a new sequential edge between nodes");
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
                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(edge);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
            
            PictogramElement pes = context.getSourcePictogramElement();
            PictogramElement pet = context.getTargetPictogramElement();
            
            System.out.println("source.getEdge().getChildNode().size(): " + 
            source.getEdge().getChildNode().size());
            
            if(source.getEdge().getChildNode().size() == 0) {
	            pet.getGraphicsAlgorithm().setX(pes.getGraphicsAlgorithm().getX());
	            pet.getGraphicsAlgorithm().setY(
	            		pes.getGraphicsAlgorithm().getY() + 
	            		pes.getGraphicsAlgorithm().getHeight() + 45);
            }
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
        	edge.setComposition(Composition.SEQUENTIAL);
        	source.setEdge(edge);
        }
        
        System.out.println("the branch name is: " + edge.getBranch().getLiteral());
        
        if(source.getEdge().getChildNode().size() == 1) {
        	HashMap<Integer, String> map = new HashMap<Integer, String>();
        	WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
                    getActiveWorkbenchWindow().getShell(),
        		new ManageBranchWizardGraphBtFeature(map, getDiagram()));
        		
    		if (wizardDialog.open() != Window.OK) {
    			return null;
    		}
    		
    		edge.setBranch(Branch.get(map.get(1)));
    		System.out.println("branch: " + edge.getBranch().getLiteral());
        }
        
        edge.getChildNode().add(target);
        return edge;
   }
}
