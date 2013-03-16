//package org.be.graphbt.model.graphbt.graphBT.features;
//
//import java.util.HashMap;
//
//import org.eclipse.graphiti.features.ICreateConnectionFeature;
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.features.context.ICreateConnectionContext;
//import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
//import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
//import org.eclipse.graphiti.mm.pictograms.Connection;
//import org.eclipse.graphiti.mm.pictograms.PictogramElement;
//import org.eclipse.jface.window.Window;
//import org.eclipse.jface.wizard.WizardDialog;
//import org.eclipse.ui.PlatformUI;
//
//import org.be.graphbt.model.graphbt.BehaviortreeFactory;
//import org.be.graphbt.model.graphbt.Branch;
//import org.be.graphbt.model.graphbt.Composition;
//import org.be.graphbt.model.graphbt.Edge;
//import org.be.graphbt.model.graphbt.GraphBTUtil;
//import org.be.graphbt.model.graphbt.StandardNode;
//import org.be.graphbt.model.graphbt.graphBT.wizards.manageBranch.ManageBranchWizardGraphBtFeature;
//
///**
// * Class CreateSequentialConnectionGraphBtFeature is for creating sequential 
// * edge model of two connected BT node
// * @author GraphBT Team
// *
// */
//public class CreateSequentialConnectionGraphBtFeature extends AbstractCreateConnectionFeature
//		implements ICreateConnectionFeature {
//
//	public CreateSequentialConnectionGraphBtFeature(IFeatureProvider fp) {
//		super(fp, "Sequential", "Creates a new sequential edge between nodes");
//	}
//
//	@Override
//	public boolean canStartConnection(ICreateConnectionContext context) {
//		
//		PictogramElement pe = context.getSourcePictogramElement();
//		if (this.getBusinessObjectForPictogramElement(pe) != null) {
//			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode) {
//				StandardNode st = (StandardNode)this.getBusinessObjectForPictogramElement(pe);
//				
//				if (st.getEdge() == null || (st.getEdge() != null && st.getEdge().getComposition().getValue() != Composition.ATOMIC_VALUE)) {
//		            return true;
//		        }
//			}
//		}
//        return false;
//	}
//
//	/**
//	 * Criteria that a node can be created
//	 * - the target
//	 */
//	@Override
//	public boolean canCreate(ICreateConnectionContext context) {
//		
//		PictogramElement pe = context.getTargetPictogramElement();
//		if (this.getBusinessObjectForPictogramElement(pe) != null) {
//			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode) {
//				return true;
//		    }
//		}
//        return false;
//	}
//	
//	@Override
//	public Connection create(ICreateConnectionContext context) {
//		Connection newConnection = null; 
//
//		StandardNode source = getStandardNode(context.getSourcePictogramElement());
//        StandardNode target = getStandardNode(context.getTargetPictogramElement());
//        
//        
//        if (source != null && target != null) {
//        	
//            Edge edge = createEdge(source, target);
//            if (edge == null) {
//            	return null;
//            }
//            
//            AddConnectionContext addContext =
//                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
//            addContext.setNewObject(edge);
//            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
//            
//            PictogramElement pes = context.getSourcePictogramElement();
//            PictogramElement pet = context.getTargetPictogramElement();
//            
//            if(source.getEdge().getChildNode().size() == 0) {
//	            pet.getGraphicsAlgorithm().setX(pes.getGraphicsAlgorithm().getX());
//	            pet.getGraphicsAlgorithm().setY(
//	            		pes.getGraphicsAlgorithm().getY() + 
//	            		pes.getGraphicsAlgorithm().getHeight() + 45);
//            }
//        }
//        
//        return newConnection;
//	}
//	
//    private StandardNode getStandardNode(PictogramElement pe) {
//        if (pe != null) {
//            Object object =
//                getBusinessObjectForPictogramElement(pe);
//            if (object instanceof StandardNode) {
//                return (StandardNode) object;
//            }
//        }
//        return null;
//    }
//    
//    
//    private Edge createEdge(StandardNode source, StandardNode target) {
//    	if(GraphBTUtil.isAncestor(target, source)) {
//    		return null;
//    	}
//    	if(target.isLeaf()) {
//    		return null;
//    	}
//    	Edge edge = source.getEdge();
//    	
//        if(edge == null) {
//        	edge = BehaviortreeFactory.eINSTANCE.createEdge();
//        	edge.setComposition(Composition.SEQUENTIAL);
//        	source.setEdge(edge);
//        }
//        else {
//        	if(edge.getChildNode().contains(target)) {
//        		return null;
//        	}
////<<<<<<< HEAD
//        	if(edge.getBranch() == null && edge.getChildNode().size()>0)
//        	{
////=======
//        	if(edge.getChildNode().size() > 0) {
////>>>>>>> refs/remotes/origin/masterComment
//        		HashMap<Integer, String> map = new HashMap<Integer, String>();
//            	WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
//                        getActiveWorkbenchWindow().getShell(),
//            		new ManageBranchWizardGraphBtFeature(map, getDiagram()));
//            		
//        		if (wizardDialog.open() != Window.OK) {
//        			return null;
//        		}
//        		
//        		edge.setBranch(Branch.get(map.get(1)));
//        		System.out.println("branch: " + edge.getBranch().getLiteral());
//        	}
//        }
//        edge.getChildNode().add(target);
//        target.setParent(source);
//        target.setLeaf(true);
//        return edge;
//   }
//}

package org.be.graphbt.graphiti.features;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.Branch;
import org.be.graphbt.model.graphbt.Composition;
import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.graphiti.wizards.manageBranch.ManageBranchWizardGraphBtFeature;


/**
* Class CreateSequentialConnectionGraphBtFeature is for creating sequential 
* edge model of two connected BT node
* @author GraphBT Team
*
*/
public class CreateSequentialConnectionGraphBtFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateSequentialConnectionGraphBtFeature(IFeatureProvider fp) {
		super(fp, "Sequential", "Creates a new sequential edge between nodes");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		
		PictogramElement pe = context.getSourcePictogramElement();
		if (this.getBusinessObjectForPictogramElement(pe) != null) {
			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode) {
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
		
		PictogramElement pe = context.getSourcePictogramElement();
		PictogramElement peS = context.getTargetPictogramElement();
		if (this.getBusinessObjectForPictogramElement(pe) != null) {
			if (this.getBusinessObjectForPictogramElement(pe) instanceof StandardNode) {
//				StandardNode ss = (StandardNode)this.getBusinessObjectForPictogramElement(peS);
				
				return true;
		    }
		}
        return false;
	}
	
	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null; 
        // get EClasses which should be connected
        StandardNode source = getStandardNode(context.getSourcePictogramElement());
        StandardNode target = getStandardNode(context.getTargetPictogramElement());
        
        
        if (source != null && target != null && target != source) {
            // create new business object
        	
            Link l = createLink(source, target);
            if (l==null) {
            	return null;
            }
            
            // add connection for business object
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(l);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
            
            PictogramElement pes = context.getSourcePictogramElement();
            PictogramElement pet = context.getTargetPictogramElement();
            
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
    
    
    protected void updatePictogramElement(PictogramElement pe) {
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        DiagramEditor ds;
        
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else {
        	ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }

		UpdateContext context = new UpdateContext(pe);
		ds.getDiagramTypeProvider().getFeatureProvider().updateIfPossible(context);
	}
    
    private Link createLink(StandardNode source, StandardNode target) {
    	if(GraphBTUtil.isAncestor(target, source)) {
    		return null;
    	}
    	if(target.isLeaf()) {
    		return null;
    	}
    	Edge edge = source.getEdge();
        if(edge == null) {
        	edge = GraphBTUtil.getBEFactory().createEdge();
        	edge.setComposition(Composition.SEQUENTIAL);
        	source.setEdge(edge);
        	edge.setContainer(source);
        }
        else
        {
        	for(int i = 0; i < edge.getChildNode().size();i++) {
        		if(edge.getChildNode().get(i).getTarget()==(target)) {
            		return null;
            	}
        	}
        	if(edge.getChildNode().size()==1) {
        		HashMap<Integer, String> map = new HashMap<Integer, String>();
            	WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
                        getActiveWorkbenchWindow().getShell(),
            		new ManageBranchWizardGraphBtFeature(map, getDiagram()));
            		
        		if (wizardDialog.open() != Window.OK) {
        			return null;
        		}
        		
        		edge.setBranch(Branch.get(map.get(1)));
        		
        		StandardNode sn = (StandardNode) edge.getChildNode().get(0).getTarget();
        		
        		ContainerShape cs = null;
        		if(sn==null) {
        			return null;
        		}
        		for(PictogramElement pe : Graphiti.getLinkService().getPictogramElements(getDiagram(), sn.getParent())) {
        			if(pe instanceof ContainerShape) {
        				cs = (ContainerShape) pe;
        			}
        		}
//        		ContainerShape cs = (ContainerShape) pe;
        		
        		Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();
					
					Object bo = Graphiti.getLinkService()
			                 .getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof AlternativeClass) {
						updatePictogramElement(n);
					}
				}
        	}
        }
        Link l = GraphBTUtil.getBEFactory().createLink();
		l.setSource(source);
		l.setTarget(target);
		edge.getChildNode().add(l);
        target.setParent(source);
        target.setLeaf(true);
        return l;
   }
}
