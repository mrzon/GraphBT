package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;


import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;

public class DirectEditTraceabilityStatusGraphBtFeature extends AbstractDirectEditingFeature {

	public DirectEditTraceabilityStatusGraphBtFeature(IFeatureProvider fp) {
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
		
		try{
			switch(Integer.parseInt(value)){
				case 0:
					node.setTraceabilityStatus(TraceabilityStatus.ORIGINAL);
					break;
				case 1:
					node.setTraceabilityStatus(TraceabilityStatus.IMPLIED);
					break;
				case 2:
					node.setTraceabilityStatus(TraceabilityStatus.MISSING);
					break;
				case 3:
					node.setTraceabilityStatus(TraceabilityStatus.UPDATED);
					break;
				case 4:
					node.setTraceabilityStatus(TraceabilityStatus.DELETED);
					break;
				case 5:
					node.setTraceabilityStatus(TraceabilityStatus.DESIGN_REFINEMENT);
					break;
				default:
					node.setTraceabilityStatus(TraceabilityStatus.ORIGINAL);
					break;
			}
			
		}
		catch(NumberFormatException e){
			node.setOperator(Operator.NO_OPERATOR);
		}
		// we know, that pe is the Shape of the Text, so its container is the
		// main shape of the EClass
		updatePictogramElement(((Shape) pe).getContainer());
	}
}