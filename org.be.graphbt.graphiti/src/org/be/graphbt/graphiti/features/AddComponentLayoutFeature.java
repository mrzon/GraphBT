package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.internal.GraphitiPlugin;
import org.eclipse.graphiti.mm.algorithms.Image;
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
import org.eclipse.graphiti.ui.internal.GraphitiUIPlugin;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Branch;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.adapter.StandardNodeAdapter;
import org.be.graphbt.graphiti.diagram.GraphBTImageProvider;
import org.be.graphbt.graphiti.editor.GraphBTDiagramEditor;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.LayoutList;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.OperatorClass;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.model.graphbt.TraceabilityStatusClass;

/**
 * Class AddGeneralBtNodeFeature is for adding a standard BT node
 * to the graphical model
 * @author GraphBT Team
 *
 */
public class AddComponentLayoutFeature extends AbstractAddShapeFeature implements
IAddFeature {
	
	public AddComponentLayoutFeature(IFeatureProvider fp) {
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
        if (context.getNewObject() instanceof Layout) {
            if (context.getTargetContainer().getLink()!=null && context.getTargetContainer().getLink().getBusinessObjects().size()>0&&
            		context.getTargetContainer().getLink().getBusinessObjects().get(0)instanceof LayoutList) {
                return true;
            }
        }
        return false;
    }
 
    public PictogramElement add(IAddContext context) {
		
    	Layout node = (Layout) context.getNewObject();
		ContainerShape targetDiagram = (ContainerShape) context.getTargetContainer();
		((LayoutList)targetDiagram.getLink().getBusinessObjects().get(0)).getLayouts().add(node);
		return createPENode(targetDiagram, node,context.getX(),context.getY());
    }
    @SuppressWarnings("restriction")
	public PictogramElement createPENode(ContainerShape targetDiagram, Layout layout, int x, int y) {
		// CONTAINER SHAPE WITH RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
        ContainerShape containerShape =
             peCreateService.createContainerShape(targetDiagram, true);
 
        // default size for the shape
        BEModel model = GraphBTUtil.getBEModel(getDiagram());
        IGaService gaService = Graphiti.getGaService();
         
        Rectangle rectangle = gaService.createRectangle(containerShape);
        rectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
        rectangle.setBackground(manageColor(ORIGINAL_BEHAVIOR_COLOR));
        Component c = GraphBTUtil.getComponentByRef(model, layout.getCRef());
        org.eclipse.swt.graphics.Image im = GraphBTUtil.getComponentImageDescription(c);
        try{
        	GraphitiUIPlugin.getDefault().getImageRegistry().put("IMAGE-"+layout.getCRef(), im);
        } catch (Exception e) {
        	
        }
        
        Image image = gaService.createImage(containerShape, "IMAGE-"+layout.getCRef());

        int width = im.getBounds().width;
        int height = im.getBounds().height; 

        //image.setWidth(100);
        //image.setHeight(100);
        //image.setProportional(true);
        //image.setLineWidth(2);
        //image.getStyle().getRenderingStyle().;
        rectangle.setLineWidth(1);
        gaService.setLocationAndSize(image, x, y, width, height);
        
        link(containerShape, layout);
        peCreateService.createChopboxAnchor(containerShape);
        
        layoutPictogramElement(containerShape);
        
        return containerShape;
    }
}