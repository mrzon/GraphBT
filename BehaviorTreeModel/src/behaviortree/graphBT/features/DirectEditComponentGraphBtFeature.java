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

import behaviortree.BehaviortreeFactory;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

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
		if (bo instanceof StandardNode && ga instanceof Text) {
			return true;
		}
		// direct editing not supported in all other cases
		return false;
	}

	public String getInitialValue(IDirectEditingContext context) {
		// return the current name of the StandardNode
		PictogramElement pe = context.getPictogramElement();
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pe);
		return node.getComponentName();
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
		StandardNode node = (StandardNode) getBusinessObjectForPictogramElement(pe);
		
		try {
			ResourceSet rs = GraphBTUtil.getResourceSet(this.getDiagram());
			if(!GraphBTUtil.isExist(rs, URI.createURI("bt.component." + value)))
			{
				Resource res = rs.createResource(URI.createURI("bt.component." + value));
				Component cp = BehaviortreeFactory.eINSTANCE.createComponent();
				cp.setName(value);
				
				node.setComponent(cp);
				
				res.getContents().add(cp);
				rs.getResources().add(res);
				res.save(Collections.emptyMap());
			}
			else {
				node.setComponent(GraphBTUtil.getComponentByURI(rs, URI.createURI("bt.component."+value)));
			}
			
			/*
			if(!GraphBTUtil.isExist(rs, URI.createURI("bt.component.behavior." + value)))
			{
				//Resource res = rs.createResource(URI.createURI("bt.component.behavior." + value));
				//Component cp = node.getComponent();
				
				node.setBehavior(value);
				node.setBehaviorType(BehaviorType.STATE_REALIZATION);
				
				System.out.println("check direct edit ");
				
				res.getContents().add(cp);
				rs.getResources().add(res);
				res.save(Collections.emptyMap());
				
			}
			 */
			
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// we know, that pe is the Shape of the Text, so its container is the
		// main shape of the EClass
		updatePictogramElement(((Shape) pe).getContainer());
	}
}