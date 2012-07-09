package behaviortree.graphBT.diagram;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import behaviortree.*;
import behaviortree.graphBT.features.AddGeneralBtNodeFeature;
import behaviortree.graphBT.features.AddGraphBtConnectionFeature;
import behaviortree.graphBT.features.CreateGraphBtConnectionFeature;
import behaviortree.graphBT.features.CreateGeneralBtNodeFeature;
import behaviortree.graphBT.features.DirectEditComponentGraphBtFeature;
import behaviortree.graphBT.features.LayoutGraphBtFeature;
import behaviortree.graphBT.features.MoveGraphBtFeature;
import behaviortree.graphBT.features.RenameGraphBtFeature;
import behaviortree.graphBT.features.ResizeGraphBtFeature;
import behaviortree.graphBT.features.UpdateGraphBtFeature;



public class GraphBTFeatureProvider extends DefaultFeatureProvider {

	public GraphBTFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {new CreateGeneralBtNodeFeature(this)};
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {new CreateGraphBtConnectionFeature(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		System.out.println("yeee masih masuk di addcontext");
		if (context instanceof IAddConnectionContext /* && context.getNewObject() instanceof <DomainObject> */) {
			return new AddGraphBtConnectionFeature(this);
		} else if (context instanceof IAddContext /* && context.getNewObject() instanceof <DomainObject> */) {
			return new AddGeneralBtNodeFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	    PictogramElement pictogramElement = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	    System.out.println("yeee masih masuk di direct editnya feature provider!");
	    if (bo instanceof StandardNode) {
			System.out.println("objeknya ternyata standar node");
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof Component) {
			System.out.println("objeknya ternyata component");
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof Behavior) {
			System.out.println("objeknya ternyata behavior");
			return new UpdateGraphBtFeature(this);
		}
	   return super.getUpdateFeature(context);
	 } 
	
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
	    Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof EClass) {
	        return new MoveGraphBtFeature(this);
	    }
	    return super.getMoveShapeFeature(context);
	 } 
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		if (context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
			return  new LayoutGraphBtFeature(this);
		}

		return super.getLayoutFeature(context);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { new RenameGraphBtFeature(this) };
	}
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		System.out.println("yeee masih masuk di direct T________T si echon");
		PictogramElement pe = context.getPictogramElement();
		PictogramElement pel = this.getDirectEditingInfo().getMainPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pel);
		
		System.out.println("yeee masih masuk di direct T________T");
		if (bo instanceof StandardNode) {
			System.out.println("yeee masih masuk di direct editnya feature provider!");
			return new DirectEditComponentGraphBtFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(
	        IResizeShapeContext context) {
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof EClass) {
	    	return new ResizeGraphBtFeature(this);
		}
		return super.getResizeShapeFeature(context);
	}
}
