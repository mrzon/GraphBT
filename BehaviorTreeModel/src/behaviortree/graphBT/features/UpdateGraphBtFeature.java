package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.AlternativeClass;
import behaviortree.Behavior;
import behaviortree.Branch;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.OperatorClass;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatusClass;

/**
 * Class UpdateGraphBtFeature is for updating the graphical BT model if
 * some changes are made 
 * @author GraphBT Team
 *
 */
public class UpdateGraphBtFeature extends AbstractUpdateFeature {
 
    public UpdateGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a StandardNode
    	PictogramElement pictogramElement = context.getPictogramElement();
    	Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        
        return ((bo instanceof Component)|| (bo instanceof Behavior)|| (bo instanceof OperatorClass) ||
        		(bo instanceof Requirement) || (bo instanceof TraceabilityStatusClass) || (bo instanceof AlternativeClass));
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
        
        if(!(oSN instanceof StandardNode)) {
        	return Reason.createFalseReason();
        }
       	
        StandardNode node = (StandardNode) oSN;
        String businessName = null;
		
        if (bo instanceof Component) {
			Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef());
			if(c != null) {
				businessName = c.getComponentName();
			}
		}
		else if (bo instanceof Behavior) {
			if(node.getBehaviorRef() != null) {
				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef());
				businessName = GraphBTUtil.getBehaviorFromComponentByRef(c, node.getBehaviorRef()).toString();
			}
			else {
				businessName = null;
			}
		}
		else if (bo instanceof Requirement) {
			Requirement c = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(getDiagram()), node.getTraceabilityLink());
			if(c != null) {
				businessName = c.getKey();
			}
			else {
				businessName = "";
			}
		}
		else if (bo instanceof TraceabilityStatusClass) {
			businessName = node.getTraceabilityStatus();
		}
		else if (bo instanceof OperatorClass) {
			businessName = node.getOperator();
		}
		else if(bo instanceof AlternativeClass) {
			if(node.getEdge() == null) {
				return Reason.createFalseReason();
			}
			else if(node.getEdge().getBranch() == null) {
				return Reason.createFalseReason();				
			}
			else if(node.getEdge().getBranch() != null) {
				if(node.getEdge().getBranch().getName().equals(Branch.ALTERNATIVE.getName())) {
					businessName = "A";
				}
				else {
					businessName = "";
				}
			}
		}

		if(((Shape)pictogramElement).getGraphicsAlgorithm() instanceof Text) {
			pictogramName = ((Text)((Shape)pictogramElement).getGraphicsAlgorithm()).getValue();
		}
		
		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || 
				(pictogramName != null && !pictogramName.equals(businessName)));
		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date");
		} else {
			return Reason.createFalseReason();
		}
        // retrieve name from business model
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	StandardNode node = (StandardNode) oSN;

        if (bo instanceof Component) {
        	Component comp = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef()); 
        	businessName = comp.getComponentName();
            Shape shape = (Shape) pictogramElement;
            pictogramElement.getLink().getBusinessObjects().clear();
            pictogramElement.getLink().getBusinessObjects().add(comp);
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                return true;
             }
        }
        if (bo instanceof Behavior) {
        	Behavior beh = GraphBTUtil.getBehaviorFromComponentByRef(GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()), node.getComponentRef()), node.getBehaviorRef());
        	businessName = beh.toString();
            Shape shape = (Shape) pictogramElement;

            pictogramElement.getLink().getBusinessObjects().clear();
            pictogramElement.getLink().getBusinessObjects().add(beh);
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                return true;
             }
        }
        if (bo instanceof Requirement) {
        	Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(getDiagram()), node.getTraceabilityLink());
        	Shape shape = (Shape) pictogramElement;
            pictogramElement.getLink().getBusinessObjects().clear();
            pictogramElement.getLink().getBusinessObjects().add(r);
            
        	if(r != null)
        		businessName = r.getKey();
        	else
        		businessName = "";
        	
        
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                return true;
            }
        }
        if (bo instanceof TraceabilityStatusClass) {
        	businessName = node.getTraceabilityStatus();
            Shape shape = (Shape) pictogramElement;
            
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                link(shape, GraphBTUtil.getTraceabilityStatus(getDiagram(), businessName));
                return true;
            }
        }
        if (bo instanceof OperatorClass) {
        	businessName = node.getOperator();
            Shape shape = (Shape) pictogramElement;
        
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                return true;
            }
        }
        if (bo instanceof AlternativeClass) {
        	if(node.getEdge().getBranch()!=null && node.getEdge().getBranch().equals(Branch.ALTERNATIVE)) {
        		businessName = "A";
        	}
        	else {
        		businessName = "";
        	}
        	
            Shape shape = (Shape) pictogramElement;
        
            if (shape.getGraphicsAlgorithm() instanceof Text) {
                Text text = (Text) shape.getGraphicsAlgorithm();
                text.setValue(businessName);
                return true;
            }
        }
        
        return false;
    }
}