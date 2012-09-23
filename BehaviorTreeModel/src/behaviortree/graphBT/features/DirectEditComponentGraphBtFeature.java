package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.MessageDialog;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviortreeFactory;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;

public class DirectEditComponentGraphBtFeature extends AbstractDirectEditingFeature {

	public DirectEditComponentGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		// there are several possible editor-types supported:
		// text-field, checkbox, color-chooser, combobox, ...
		return TYPE_TEXT;
	}
 
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		// support direct editing, if it is a StandardNode, and the user clicked
		// directly on the text and not somewhere else in the rectangle
		
		if (bo instanceof Component && ga instanceof Text) {
			return true;
		}
		if (bo instanceof Behavior && ga instanceof Text) {
			return true;
		}
		if (bo instanceof Requirement && ga instanceof Text) {
			return true;
		}
		
		// direct editing not supported in all other cases
		return false;
	}

	public String getInitialValue(IDirectEditingContext context) {
		// return the current name of the StandardNode
		PictogramElement pe = context.getPictogramElement();
		Object ob = getBusinessObjectForPictogramElement(pe);
		
		//PictogramElement pel = //this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();//
		PictogramElement pel = ((Shape)pe).getContainer();
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pel);
		if(ob instanceof Component) {
			String str = node.getComponentRef()==null?"":((Component)ob).getComponentName();
			return str;
		}
		//if the direct-edited object is and instance of behavior
		else if(ob instanceof Behavior) {
			String str = node.getBehaviorRef()==null?"":((Behavior)ob).getBehaviorName();
			return str;
		}
		//if the direct-edited object is an instance of operator
		/*else if(object instanceof Operator) {
			node.setOperator(Operator.get(value));
		}
		//if the direct-edited object is and instance of traceability status
		else if(object instanceof TraceabilityStatus) {
			node.setTraceabilityStatus(TraceabilityStatus.get(value));
		}*/
		//if the direct-edited object is and instance of traceability link
		else if(ob instanceof Requirement) {
			//TODO: add form to "add requirements"
			//TODO: add validasi untuk node yang ga punya traceability link"
			String str = node.getTraceabilityLink()==null?"":node.getTraceabilityLink();
			return str;
		}
		return "Default Value";
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		if (value.length() < 1)
			return "Please enter any text."; //$NON-NLS-1$
		if (value.contains("\n")) //$NON-NLS-1$
			return "Line breakes are not allowed in class names."; //$NON-NLS-1$

		// null means, that the value is valid
		return null;
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		
		Object object = (Object) getBusinessObjectForPictogramElement(pe);
		//PictogramElement pel = this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();//
		PictogramElement pel = ((Shape)pe).getContainer();
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pel);
        
		//StandardNode node = (StandardNode) this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();
		
		//if the direct-edited object is and instance of component
		if(object instanceof Component) {
			//TODO: add form to "add component"
			if(GraphBTUtil.getComponent(getModel(), value)==null)
			{
				Component cp = BehaviortreeFactory.eINSTANCE.createComponent();
				cp.setComponentName(value);
				cp.setComponentRef(value);
				node.setComponentRef(cp.getComponentRef());
				getModel().getComponentList().getComponents().add(cp);
				/*try {
					GraphBTUtil.saveToModelFile(cp, getDiagram());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				MessageDialog.openInformation(null, "Info", "Component \""+value+"\" is created");
			}
			else {
				Component cp = GraphBTUtil.getComponent(this.getModel(),value);
				node.setComponentRef(cp.getComponentRef());
				Behavior beh = cp.getBehaviors().size()>0?cp.getBehaviors().get(0):null;
				node.setBehaviorRef(beh.getBehaviorRef());
			}
			//TODO kasih peringatan untuk perubahan nama
		}
		//if the direct-edited object is and instance of behavior
		else if(object instanceof Behavior) {
			Component component = GraphBTUtil.getComponent(getModel(), node.getComponentRef());
			if(component==null)
			{
				MessageDialog.openError(null, "Error set behavior name", "You must set the correct component name before adding behavior name");
				return;
			}
			Behavior b = null;
			if((GraphBTUtil.getBehaviorFromComponent(component, value)==null))
			{
				boolean answer = MessageDialog.openConfirm(null, "Insert new behavior in component "+component.getComponentName(), "Are you sure you want to insert behavior "+value+" in this component?");
				if(answer)
				{
					b = BehaviortreeFactory.eINSTANCE.createBehavior();
					b.setBehaviorName(value);
					component.getBehaviors().add(b);
					MessageDialog.openInformation(null, "Info", "Behavior \""+value+"\" is created");
				}
			}
			else{
				b = GraphBTUtil.getBehaviorFromComponent(component, value);
			}
			node.setBehaviorRef(b.getBehaviorRef());
		}
		//if the direct-edited object is an instance of operator
		else if(object instanceof Operator) {
			node.setOperator(value);
		}
		//if the direct-edited object is and instance of traceability status
		else if(object instanceof TraceabilityStatus) {
			node.setTraceabilityStatus(value);
		}
		//if the direct-edited object is and instance of traceability link
		else if(object instanceof Requirement) {
			//TODO: add form to "add requirements"
			//TODO: add validasi untuk node yang ga punya traceability link"
			
			Requirement requirements = null;
			if(!(GraphBTUtil.getRequirement(getModel(), value) == null)){
				requirements = BehaviortreeFactory.eINSTANCE.createRequirement();
				requirements.setRequirement(value);
				getModel().getRequirementList().getRequirements().add(requirements);
			}
			else{
				requirements = GraphBTUtil.getRequirement(getModel(), value);
			}
			node.setTraceabilityLink(requirements.getKey());
		}
		// we know, that pe is the Shape of the Text, so its container is the
		// main shape of the EClass
		updatePictogramElement(((Shape) pe));
	}
	public BEModel getModel()
    {
    	return GraphBTUtil.getBEModel(getDiagram());
    }
}
