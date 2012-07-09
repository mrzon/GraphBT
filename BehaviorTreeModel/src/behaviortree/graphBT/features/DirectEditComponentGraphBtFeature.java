package behaviortree.graphBT.features;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.BehaviortreeFactory;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirements;
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
		
		System.out.println("bisa direct edit gak sih? bo instanceof StandardNode kah?" + (bo instanceof StandardNode));
		
		if (bo instanceof StandardNode && ga instanceof Text) {
			System.out.println("bisa direct edit di true gak sih?");
			return true;
		}
		if (bo instanceof Component && ga instanceof Text) {
			System.out.println("bisa.. ternyata dia komponen sir");
			return true;
		}
		if (bo instanceof Behavior && ga instanceof Text) {
			System.out.println("bisa.. ternyata dia behavior sir");
			return true;
		}
		if (bo instanceof Requirements && ga instanceof Text) {
			System.out.println("bisa.. ternyata dia behavior sir");
			return true;
		}
		
		// direct editing not supported in all other cases
		System.out.println("bisa direct edit gak sih? oh gak bisa..");
		return false;
	}

	public String getInitialValue(IDirectEditingContext context) {
		// return the current name of the StandardNode
		PictogramElement pe = context.getPictogramElement();
		Object ob = getBusinessObjectForPictogramElement(pe);
		
		PictogramElement pel = this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();//
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pel);
        System.out.println("Current condition of standard node: "+node);
		
		if(ob instanceof Component) {
			return node.getComponentName();
		}
		//if the direct-edited object is and instance of behavior
		else if(ob instanceof Behavior) {
			return node.getBehavior().getBehaviorName();
		}
		//if the direct-edited object is an instance of operator
		/*else if(object instanceof Operator) {
			System.out.println("object instanceof operator");
			node.setOperator(Operator.get(value));
		}
		//if the direct-edited object is and instance of traceability status
		else if(object instanceof TraceabilityStatus) {
			System.out.println("object instanceof traceability status");
			node.setTraceabilityStatus(TraceabilityStatus.get(value));
		}*/
		//if the direct-edited object is and instance of traceability link
		else if(ob instanceof Requirements) {
			//TODO: add form to "add requirements"
			//TODO: add validasi untuk node yang ga punya traceability link"
			return ((Requirements) ob).getKey();
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
		ResourceSet rs = null;
		try {
			rs = GraphBTUtil.getResourceSet(this.getDiagram());
		} catch (CoreException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PictogramElement pe = context.getPictogramElement();
		
		Object object = (Object) getBusinessObjectForPictogramElement(pe);
		PictogramElement pel = this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();//
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pel);
        
		//StandardNode node = (StandardNode) this.getFeatureProvider().getDirectEditingInfo().getMainPictogramElement();
		System.out.println("In set Value "+node.getComponent().getComponentName());
		
		//if the direct-edited object is and instance of component
		if(object instanceof Component) {
			System.out.println("object instanceof component");
			try {
				//TODO: add form to "add component"
				if(!GraphBTUtil.isExist(rs, URI.createURI("bt.component." + value)))
				{
					Resource res = rs.createResource(URI.createURI("bt.component." + value));
					Component cp = BehaviortreeFactory.eINSTANCE.createComponent();
					cp.setComponentName(value);
					node.setComponent(cp);
					res.getContents().add(cp);
					rs.getResources().add(res);
					res.save(Collections.emptyMap());
					System.out.println("Artinya gw bikin komponen baru, namanya "+value);
				}
				else {
					System.out.println("Ternyata, komponen dengan nama "+value+" Sudah ada broh");
					node.setComponent(GraphBTUtil.getComponentByURI(rs, URI.createURI("bt.component."+value)));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//if the direct-edited object is and instance of behavior
		else if(object instanceof Behavior) {
			System.out.println("object instanceof behavior");
			Component component = node.getComponent();
			Behavior b = null;
			if((GraphBTUtil.getBehaviorFromComponent(component, value)==null))
			{
				Resource res = rs.createResource(URI.createURI("bt.component.behavior." + value));
				b = BehaviortreeFactory.eINSTANCE.createBehavior();
				b.setBehaviorName(value);
				component.getBehaviors().add(b);
				System.out.println("check direct edit ");
				res.getContents().add(b);
				rs.getResources().add(res);
				try {
					res.save(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Artinya gw bikin behavior baru, namanya "+value);
			}
			else{
				System.out.println("Ternyata, behavior dengan nama "+value+" Sudah ada broh");
				b = GraphBTUtil.getBehaviorFromComponent(component, value);
			}
			node.setBehavior(b);
		}
		//if the direct-edited object is an instance of operator
		else if(object instanceof Operator) {
			System.out.println("object instanceof operator");
			node.setOperator(Operator.get(value));
		}
		//if the direct-edited object is and instance of traceability status
		else if(object instanceof TraceabilityStatus) {
			System.out.println("object instanceof traceability status");
			node.setTraceabilityStatus(TraceabilityStatus.get(value));
		}
		//if the direct-edited object is and instance of traceability link
		else if(object instanceof Requirements) {
			//TODO: add form to "add requirements"
			//TODO: add validasi untuk node yang ga punya traceability link"
			System.out.println("object instanceof requirements");
			node.setTraceabilityLink(GraphBTUtil.getRequirements(rs, value));
			
			Requirements requirements = null;
			if(!(GraphBTUtil.getRequirements(rs, value) == null)){
				Resource res = rs.createResource(URI.createURI("bt.requirements." + value));
				requirements = BehaviortreeFactory.eINSTANCE.createRequirements();
				requirements.setRequirement(value);
				
				res.getContents().add(requirements);
				rs.getResources().add(res);
				try {
					res.save(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				requirements = GraphBTUtil.getRequirements(rs, value);
			}
			
			node.setTraceabilityLink(requirements);
		}
		System.out.println(node);
		// we know, that pe is the Shape of the Text, so its container is the
		// main shape of the EClass
		updatePictogramElement(((Shape) pe));
	}
}