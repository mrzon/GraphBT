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
import behaviortree.GraphBTUtil;
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
		
		PictogramElement pe = context.getSourcePictogramElement();
		if (this.getBusinessObjectForPictogramElement(pe) != null)
		{
			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode)
			{
				StandardNode st = (StandardNode)this.getBusinessObjectForPictogramElement(pe);
				
				if (st.getEdge() == null || (st.getEdge() != null && st.getEdge().getComposition().getValue() != Composition.ATOMIC_VALUE)) {
					
		            return true;
		        }
			}
		}
		
        return false;
	}

	/**
	 * Criteria that a node can be created
	 * - the target
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		
		PictogramElement pe = context.getTargetPictogramElement();
		PictogramElement peS = context.getTargetPictogramElement();
		if (this.getBusinessObjectForPictogramElement(pe) != null)
		{
			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode)
			{
				StandardNode ss = (StandardNode)this.getBusinessObjectForPictogramElement(peS);
				
				return true;
		    }
		}
        return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null; 
		System.out.println("Kepanggil woi.."+context.getSourcePictogramElement()+" "+context.getTargetPictogramElement());
        // get EClasses which should be connected
        StandardNode source = getStandardNode(context.getSourcePictogramElement());
        StandardNode target = getStandardNode(context.getTargetPictogramElement());
        
        
        if (source != null && target != null) {
            // create new business object
        	
            Edge edge = createEdge(source, target);
            if (edge==null)
            {
            	return null;
            }
            
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
	
    private StandardNode getStandardNode(PictogramElement pe) {
        if (pe != null) {
            Object object =
                getBusinessObjectForPictogramElement(pe);
            if (object instanceof StandardNode) {
                return (StandardNode) object;
            }
        }
        return null;
    }
    
    
    private Edge createEdge(StandardNode source, StandardNode target) {
    	if(GraphBTUtil.isAncestor(target, source))
    	{
    		return null;
    	}
    	if(target.isLeaf())
    	{
    		return null;
    	}
    	Edge edge = source.getEdge();
    	System.out.println("Ini edgenya "+edge);
    	
        if(edge == null)
        {
        	edge = BehaviortreeFactory.eINSTANCE.createEdge();
        	edge.setComposition(Composition.SEQUENTIAL);
        	source.setEdge(edge);
        }
        else
        {
        	if(edge.getChildNode().contains(target))
        	{
        		return null;
        	}
        	if(edge.getChildNode().size()>0)
        	{
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
        }
        edge.getChildNode().add(target);
        target.setLeaf(true);
        return edge;
   }
}
