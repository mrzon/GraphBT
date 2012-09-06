package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IAddFeature;
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

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.OperatorClass;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.TraceabilityStatusClass;

/**
 * Class AddGeneralBtNodeFeature is for adding a standard BT node
 * to the graphical model
 * @author GraphBT Team
 *
 */
public class AddGeneralBtNodeFeature extends AbstractAddShapeFeature implements
IAddFeature {
	
	public AddGeneralBtNodeFeature(IFeatureProvider fp) {
		super(fp);
	}
		
    private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
        IColorConstant.BLACK;
 
    private static final IColorConstant E_CLASS_FOREGROUND =
        new ColorConstant(0, 0, 0);

    public static final IColorConstant ORIGINAL_BEHAVIOR_COLOR =
            new ColorConstant("99FF66");
        
    public static final IColorConstant IMPLIED_BEHAVIOR_COLOR =
            new ColorConstant("FFFF66");	//yellow
 
    public static final IColorConstant MISSING_BEHAVIOR_COLOR =
            new ColorConstant("FF6666");	//red
        
    public static final IColorConstant UPDATED_BEHAVIOR_COLOR =
                new ColorConstant("66CCFF");	//blue
    
    public static final IColorConstant DELETED_BEHAVIOR_COLOR =
            new ColorConstant("FFFFFF");	//white
    
    

    
    public boolean canAdd(IAddContext context) {
        if (context.getNewObject() instanceof StandardNode) {
            if (context.getTargetContainer() instanceof Diagram) {
                return true;
            }
        }
        return false;
    }
 
    public PictogramElement add(IAddContext context) {
		
    	StandardNode node = (StandardNode) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		System.out.println("AddGeneralBtNodeFeature add "+node.toBTText());
		return createPENode(targetDiagram, node,context.getX(),context.getY());
    }
    public PictogramElement createPENode(Diagram targetDiagram, StandardNode node, int x, int y){
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
        rectangle.setBackground(manageColor(ORIGINAL_BEHAVIOR_COLOR));
        rectangle.setLineWidth(1);
        gaService.setLocationAndSize(rectangle, x, y, width, height);
        
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
        	String str = cp==null?"Default component":cp.getComponentName();
            Text text = gaService.createText(shapeComponent, str);
            text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            text.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(text, 40, height/2 - 20, width - 40, 20);
     
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
        	String str = b==null?"Default behavior":b.toString();
            Text textBehavior = gaService.createText(shapeBehavior, str);
            textBehavior.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textBehavior.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
            textBehavior.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textBehavior, 40, height/2 + 10, width - 40, 20);
            shapeBehavior.setActive(false);
            link(shapeBehavior, b);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY LINK
        {  	
        	Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(getDiagram()), node.getTraceabilityLink());
        	Shape shapeTraceabilityLink = peCreateService.createShape(containerShape, true);
        	String str = r==null?"":r.getKey(); 
        	Text textTraceabilityLink = gaService.createText(shapeTraceabilityLink, str);
            textTraceabilityLink.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceabilityLink.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
            textTraceabilityLink.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceabilityLink, 0, height/2 - 20, 40, 20);
            shapeTraceabilityLink.setActive(false);
            if(r == null){
            	r = GraphBTUtil.getDefaultRequirement(getDiagram());
            }
            
            link(shapeTraceabilityLink,	r);
        }
        
        // SHAPE WITH TEXT FOR TRACEABILITY STATUS
        {  	
        	Shape shapeTraceabilityStatus = peCreateService.createShape(containerShape, true);
        	
        	Text textTraceabilityStatus = gaService.createText(shapeTraceabilityStatus, node.getTraceabilityStatus());
            textTraceabilityStatus.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textTraceabilityStatus.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textTraceabilityStatus.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            gaService.setLocationAndSize(textTraceabilityStatus, 0, height/2 + 10, 40, 20);
            
            TraceabilityStatusClass tsc = GraphBTUtil.getTraceabilityStatus(getDiagram(), node.getTraceabilityStatus());
            
            if(tsc.getTraceabilityStatusLiteral().equals(TraceabilityStatus.DELETED.getLiteral())) {
            	rectangle.setBackground(manageColor(DELETED_BEHAVIOR_COLOR));
            }
            else if(tsc.getTraceabilityStatusLiteral().equals(TraceabilityStatus.IMPLIED.getLiteral())) {
            	rectangle.setBackground(manageColor(IMPLIED_BEHAVIOR_COLOR));
            }
            else if(tsc.getTraceabilityStatusLiteral().equals(TraceabilityStatus.MISSING.getLiteral())) {
            	rectangle.setBackground(manageColor(MISSING_BEHAVIOR_COLOR));
            }
            else if(tsc.getTraceabilityStatusLiteral().equals(TraceabilityStatus.UPDATED.getLiteral())) {
            	rectangle.setBackground(manageColor(UPDATED_BEHAVIOR_COLOR));
            }
            else if(tsc.getTraceabilityStatusLiteral().equals(TraceabilityStatus.DESIGN_REFINEMENT.getLiteral())) {
            	rectangle.setBackground(manageColor(DELETED_BEHAVIOR_COLOR));
            }shapeTraceabilityStatus.setActive(false);
            link(shapeTraceabilityStatus, tsc);
        }
        
        // SHAPE WITH TEXT FOR OPERATOR
        {  	
        	Shape shapeOperator = peCreateService.createShape(containerShape, true);
        	 
            Text textOperator = gaService.createText(shapeOperator, node.getOperator());
            System.out.println("textOperator :" + textOperator.getValue());
            textOperator.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
            textOperator.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
            textOperator.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
            
            gaService.setLocationAndSize(textOperator, 140, 5, 30, 20);
            OperatorClass oc = GraphBTUtil.getOperator(getDiagram(), node.getOperator());
            shapeOperator.setActive(false);
            link(shapeOperator, oc);
        }
        
        peCreateService.createChopboxAnchor(containerShape);
        
        // create an additional box relative anchor at middle-right
//        final FixPointAnchor boxAnchor =
//             peCreateService.createFixPointAnchor(containerShape);
//      
//        boxAnchor.setLocation(gaService.createPoint(width/2, height));
//        boxAnchor.isUseAnchorLocationAsConnectionEndpoint();
        
        layoutPictogramElement(containerShape);
        
//        // create an additional box relative anchor at middle-right
//        final BoxRelativeAnchor boxAnchor =
//             peCreateService.createBoxRelativeAnchor(containerShape);
//      
//        boxAnchor.setRelativeWidth(0.5);
//        boxAnchor.setRelativeHeight(1.0);
//  
//        // anchor references visible rectangle instead of invisible rectangle
//        boxAnchor.setReferencedGraphicsAlgorithm(rectangle);
//  
//        // assign a graphics algorithm for the box relative anchor
//        Rectangle rect = gaService.createRectangle(boxAnchor);
//        rect.setFilled(true);
//  
//        // anchor is located on the right border of the visible rectangle
//        // and touches the border of the invisible rectangle
//  
//        int w = 6;
//        gaService.setLocationAndSize(rect, -2 * w, -w, 2 * w, 2 * w);
//        rect.setForeground(manageColor(E_CLASS_FOREGROUND));
//        rect.setBackground(manageColor(E_CLASS_BACKGROUND));
               
        return containerShape;
    }
}