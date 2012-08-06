package behaviortree.graphBT.diagram;


import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.features.AddAtomicConnectionGraphBtFeature;
import behaviortree.graphBT.features.AddGeneralBtNodeFeature;
import behaviortree.graphBT.features.AddGraphBtConnectionFeature;
import behaviortree.graphBT.features.CopyNodeGraphBtFeature;
import behaviortree.graphBT.features.CreateAtomicConnectionGraphBtFeature;
import behaviortree.graphBT.features.CreateGeneralBtNodeFeature;
import behaviortree.graphBT.features.CreateSequentialConnectionGraphBtFeature;
import behaviortree.graphBT.features.LayoutGraphBtFeature;
import behaviortree.graphBT.features.MoveGraphBtFeature;
import behaviortree.graphBT.features.PasteNodeGraphBtFeature;
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
		return new ICreateConnectionFeature[] {
				new CreateSequentialConnectionGraphBtFeature(this), 
				new CreateAtomicConnectionGraphBtFeature(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Edge) {
			Edge edge = (Edge) context.getNewObject();
			
			if(edge.getComposition().getLiteral().equals(Composition.ATOMIC.getLiteral())) {
				System.out.println("di add atomic connection context");
				return new AddAtomicConnectionGraphBtFeature(this);
			}
			else {
				System.out.println("di add sequential connection context");
				return new AddGraphBtConnectionFeature(this);
			}
		} else if (context instanceof IAddContext /* && context.getNewObject() instanceof <DomainObject> */) {
			return new AddGeneralBtNodeFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	    PictogramElement pictogramElement = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	    System.out.println("yeee masih masuk di update feature provider!");
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
	    if (bo instanceof StandardNode) {
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
	public ICopyFeature getCopyFeature(ICopyContext context) {
		System.out.println("getCopyFeature() is invoked");
		
		return  new CopyNodeGraphBtFeature(this);
	}
	
	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return  new PasteNodeGraphBtFeature(this);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { new RenameGraphBtFeature(this) };
	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(
	        IResizeShapeContext context) {
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StandardNode) {
	    	return new ResizeGraphBtFeature(this);
		}
		
		else if (bo instanceof Component || 
				bo instanceof Operator ||
				bo instanceof Behavior ||
				bo instanceof TraceabilityStatus ||
				bo instanceof Requirement) {
	    	return new ResizeGraphBtFeature(this);
		}
		
		return super.getResizeShapeFeature(context);
	}
	
	@Override
    public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
        // simply return all create connection features
        return getCreateConnectionFeatures();

    }
}
