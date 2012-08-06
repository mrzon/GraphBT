package behaviortree.graphBT.features;

/**
 * General BT Node adalah diagram untuk node 
 * kosong yang bisa dispesifikasikan menjadi Node yang lebih spesifik
 */

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

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
        if (context.getNewObject() instanceof StandardNode) {
            // check if user wants to add to a diagram
            if (context.getTargetContainer() instanceof Diagram) {
                return true;
            }
        }
        return false;
    }
 
    public PictogramElement add(IAddContext context) {
		
    	StandardNode node = (StandardNode) context.getNewObject();
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

        link(containerShape, node);

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
        Component cp = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(getDiagram()),node.getComponentRef());
    	
        // SHAPE WITH TEXT FOR COMPONENT
        {  	
        	Shape shapeComponent = peCreateService.createShape(containerShape, false);
        	String str = node.getComponentRef()==null?"Default component":cp.getComponentName();
            Text text = gaService.createText(shapeComponent, str);
            text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            text.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(text, 40, height/2 - 20, width - 40, 20);
     
            //
            //link(shapeComponent, node.getComponent());
            //link(shapeComponent, node);
            link(shapeComponent, cp);
//            final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
//            directEditingInfo.setMainPictogramElement(containerShape);
//            directEditingInfo.setPictogramElement(shapeComponent);
//            directEditingInfo.setGraphicsAlgorithm(text);
        }
        
        // SHAPE WITH TEXT FOR BEHAVIOR
        {
        	Behavior b = GraphBTUtil.getBehaviorFromComponentByRef(cp, node.getBehaviorRef());
        	Shape shapeBehavior = peCreateService.createShape(containerShape, true);
//        	String str = b==null?"Default behavior":b.toString();
            Text textBehavior = gaService.createText(shapeBehavior, b.toString());
            textBehavior.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textBehavior.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
            textBehavior.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textBehavior, 40, height/2 + 10, width - 40, 20);
            
            link(shapeBehavior, b);
//            
//            IDirectEditingInfo directEditingInfo =
//                getFeatureProvider().getDirectEditingInfo();
//            directEditingInfo.setMainPictogramElement(containerShape);
//            directEditingInfo.setPictogramElement(shapeBehavior);
//            directEditingInfo.setGraphicsAlgorithm(textBehavior);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY LINK
        {  	
        	Shape shapeTraceabilityLink = peCreateService.createShape(containerShape, true);
        	String str = node.getTraceabilityLink()==null?"":node.getTraceabilityLink().getKey(); 
        	Text textTraceabilityLink = gaService.createText(shapeTraceabilityLink, str);
            textTraceabilityLink.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceabilityLink.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
            textTraceabilityLink.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceabilityLink, 0, height/2 - 20, 40, 20);
     
            link(shapeTraceabilityLink, node.getTraceabilityLink());
            
//            IDirectEditingInfo directEditingInfo =
//                getFeatureProvider().getDirectEditingInfo();
//            directEditingInfo.setMainPictogramElement(containerShape);
//            directEditingInfo.setPictogramElement(shapeTraceabilityLink);
//            directEditingInfo.setGraphicsAlgorithm(textTraceabilityLink);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY STATUS
        {  	
        	Shape shapeTraceabilityStatus = peCreateService.createShape(containerShape, true);
        	
        	Text textTraceabilityStatus = gaService.createText(shapeTraceabilityStatus, node.getTraceabilityStatus().getLiteral());
            textTraceabilityStatus.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceabilityStatus.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textTraceabilityStatus.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceabilityStatus, 0, height/2 + 10, 40, 20);
            
            //link(shapeTraceabilityStatus, node.getTraceabilityStatus());
         
//            IDirectEditingInfo directEditingInfo =
//                getFeatureProvider().getDirectEditingInfo();
//            directEditingInfo.setMainPictogramElement(containerShape);
//            directEditingInfo.setPictogramElement(shapeTraceabilityStatus);
//            directEditingInfo.setGraphicsAlgorithm(textTraceabilityStatus);
        }
        
        // SHAPE WITH TEXT FOR OPERATOR
        {  	
        	Shape shapeOperator = peCreateService.createShape(containerShape, true);
        	 
            Text textOperator = gaService.createText(shapeOperator, node.getOperator().getLiteral());
            textOperator.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textOperator.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textOperator.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            
            gaService.setLocationAndSize(textOperator, 140, 5, 30, 20);
            
            //link(shapeOperator, node.getOperator());
            
//            IDirectEditingInfo directEditingInfo =
//                getFeatureProvider().getDirectEditingInfo();
//            
//            directEditingInfo.setMainPictogramElement(containerShape);
//            directEditingInfo.setPictogramElement(shapeOperator);
//            directEditingInfo.setGraphicsAlgorithm(textOperator);
        }
        
        peCreateService.createChopboxAnchor(containerShape);
        
     // create an additional box relative anchor at middle-right
//        final BoxRelativeAnchor boxAnchor =
//             peCreateService.createBoxRelativeAnchor(containerShape);
//
//        boxAnchor.setRelativeWidth(1.0);
//        boxAnchor.setRelativeHeight(0.5);
//
//        // anchor references visible rectangle instead of invisible rectangle
//        boxAnchor.setReferencedGraphicsAlgorithm(rectangle);
//
//        // assign a graphics algorithm for the box relative anchor
//        Rectangle rectangleBox = gaService.createRectangle(boxAnchor);
//        rectangleBox.setFilled(true);
//
//        // anchor is located on the right border of the visible rectangle
//        // and touches the border of the invisible rectangle
//        int w = 6;
//        gaService.setLocationAndSize(rectangleBox, -2 * w, -w, 2 * w, 2 * w);
        layoutPictogramElement(containerShape);
               
        return containerShape;
    }
}