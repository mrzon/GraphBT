package behaviortree.graphBT.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import behaviortree.impl.*;
import behaviortree.util.*;
import behaviortree.*;

public class AddGeneralBtNodeFeature extends AbstractAddShapeFeature implements
IAddFeature {
	
	public AddGeneralBtNodeFeature(IFeatureProvider fp) {
		super(fp);
	}
		
    private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
        IColorConstant.BLACK;
 
    private static final IColorConstant E_CLASS_FOREGROUND =
        new ColorConstant(0, 0, 0);

    private static final IColorConstant E_CLASS_BACKGROUND =
        new ColorConstant(0, 255, 0);
 

 
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a EClass
        if (context.getNewObject() instanceof EClass) {
            // check if user wants to add to a diagram
            if (context.getTargetContainer() instanceof Diagram) {
                return true;
            }
        }
        return false;
    }
 
    public PictogramElement add(IAddContext context) {
    	
        EClass addedComponentClass = EcoreFactory.eINSTANCE.createEClass(); //(EClass) context.getNewObject();
        
        EClass addedBehaviorClass = EcoreFactory.eINSTANCE.createEClass();
        EClass addedTraceabilityLinkClass = EcoreFactory.eINSTANCE.createEClass();
        EClass addedTraceabilityStatusClass = EcoreFactory.eINSTANCE.createEClass();
        EClass addedOperatorClass = EcoreFactory.eINSTANCE.createEClass();
        
        Diagram targetDiagram = (Diagram) context.getTargetContainer();
 
        // CONTAINER SHAPE WITH RECTANGLE
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        ContainerShape containerShape =
             peCreateService.createContainerShape(targetDiagram, true);
 
        // default size for the shape
        int width = 170;
        int height = 80; 
        
        IGaService gaService = Graphiti.getGaService();
         
        Rectangle rectangle = gaService.createRectangle(containerShape);
        rectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
        rectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
        rectangle.setLineWidth(1);
        gaService.setLocationAndSize(rectangle, context.getX(), context.getY(), width, height);
 
        if (addedComponentClass.eResource() == null) {
        	getDiagram().eResource().getContents().add(addedComponentClass);
        }
            
        link(containerShape, addedComponentClass);
           
        if (addedBehaviorClass.eResource() == null)
        	getDiagram().eResource().getContents().add(addedBehaviorClass);
	       
        link(containerShape, addedBehaviorClass);
            
        if (addedTraceabilityLinkClass.eResource() == null) 
        	getDiagram().eResource().getContents().add(addedTraceabilityLinkClass);
	       
        link(containerShape, addedTraceabilityLinkClass);
	       
	    if (addedTraceabilityStatusClass.eResource() == null) 
	    	getDiagram().eResource().getContents().add(addedTraceabilityStatusClass);
	       
	    link(containerShape, addedTraceabilityStatusClass);
	       
	    if (addedOperatorClass.eResource() == null) 
	    	getDiagram().eResource().getContents().add(addedOperatorClass);
	       
	    link(containerShape, addedOperatorClass);
            
        // SHAPE FOR LINE
        {
            // create shape for line
            Shape shape = peCreateService.createShape(containerShape, false);
 
            // create and set graphics algorithm
            Polyline polyline =
                gaService.createPolyline(shape, new int[] { 40, 0, 40, height });
            polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
            polyline.setLineWidth(1);
        }
        
        // SHAPE WITH TEXT FOR COMPONENT
        {  	
        	Shape shapeComponent = peCreateService.createShape(containerShape, false);      	 
            Text text = gaService.createText(shapeComponent, addedComponentClass.getName());
            text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            text.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(text, 40, height/2 - 20, width - 40, 20);
     
            link(shapeComponent, addedComponentClass);
     
            IDirectEditingInfo directEditingInfo =
                getFeatureProvider().getDirectEditingInfo();
            directEditingInfo.setMainPictogramElement(shapeComponent);
            directEditingInfo.setPictogramElement(shapeComponent);
            directEditingInfo.setGraphicsAlgorithm(text);
        }
        
        // SHAPE WITH TEXT FOR BEHAVIOR
        {  	
        	Shape shapeBehavior = peCreateService.createShape(containerShape, true);        	 
            Text textBehavior = gaService.createText(shapeBehavior, addedBehaviorClass.getName());
            textBehavior.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textBehavior.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textBehavior.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textBehavior, 40, height/2 + 10, width - 40, 20);
     
            link(shapeBehavior, addedBehaviorClass);
            
            IDirectEditingInfo directEditingInfo =
                getFeatureProvider().getDirectEditingInfo();
            directEditingInfo.setMainPictogramElement(shapeBehavior);
            directEditingInfo.setPictogramElement(shapeBehavior);
            directEditingInfo.setGraphicsAlgorithm(textBehavior);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY LINK
        {  	
        	Shape shapeTraceabilityLink = peCreateService.createShape(containerShape, true);
        	 
            Text textTraceanilityLink = gaService.createText(shapeTraceabilityLink, addedTraceabilityLinkClass.getName());
            textTraceanilityLink.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceanilityLink.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textTraceanilityLink.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceanilityLink, 0, height/2 - 20, 40, 20);
     
            link(shapeTraceabilityLink, addedTraceabilityLinkClass);
            
            IDirectEditingInfo directEditingInfo =
                getFeatureProvider().getDirectEditingInfo();
            directEditingInfo.setMainPictogramElement(shapeTraceabilityLink);
            directEditingInfo.setPictogramElement(shapeTraceabilityLink);
            directEditingInfo.setGraphicsAlgorithm(textTraceanilityLink);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY STATUS
        {  	
        	Shape shapeTraceabilityStatus = peCreateService.createShape(containerShape, true);
        	 
            Text textTraceabilityStatus = gaService.createText(shapeTraceabilityStatus, addedTraceabilityStatusClass.getName());
            textTraceabilityStatus.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceabilityStatus.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textTraceabilityStatus.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceabilityStatus, 0, height/2 + 10, 40, 20);
     
            link(shapeTraceabilityStatus, addedTraceabilityStatusClass);
            
            IDirectEditingInfo directEditingInfo =
                getFeatureProvider().getDirectEditingInfo();
            directEditingInfo.setMainPictogramElement(shapeTraceabilityStatus);
            directEditingInfo.setPictogramElement(shapeTraceabilityStatus);
            directEditingInfo.setGraphicsAlgorithm(textTraceabilityStatus);
        }
        
        // SHAPE WITH TEXT FOR OPERATOR
        {  	
        	Shape shapeOperator = peCreateService.createShape(containerShape, true);
        	 
            Text textOperator = gaService.createText(shapeOperator, addedOperatorClass.getName());
            textOperator.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textOperator.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textOperator.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textOperator, 140, 5, 30, 20);
     
            link(shapeOperator, addedOperatorClass);
            
            IDirectEditingInfo directEditingInfo =
                getFeatureProvider().getDirectEditingInfo();
            directEditingInfo.setMainPictogramElement(shapeOperator);
            directEditingInfo.setPictogramElement(shapeOperator);
            directEditingInfo.setGraphicsAlgorithm(textOperator);
        }
        
        peCreateService.createChopboxAnchor(containerShape);
        layoutPictogramElement(containerShape);
               
        return containerShape;
    }
}



