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
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
//<<<<<<< HEAD
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
//=======
//>>>>>>> refs/remotes/origin/masterComment
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.OperatorClass;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatusClass;
import behaviortree.graphBT.features.AddAtomicConnectionGraphBtFeature;
import behaviortree.graphBT.features.AddGeneralBtNodeFeature;
import behaviortree.graphBT.features.AddSequentialConnectionGraphBtFeature;
import behaviortree.graphBT.features.ConnectionReconnectGraphBTFeature;
import behaviortree.graphBT.features.CopyNodeGraphBtFeature;
import behaviortree.graphBT.features.CreateAtomicConnectionGraphBtFeature;
import behaviortree.graphBT.features.CreateGeneralBtNodeFeature;
import behaviortree.graphBT.features.CreateSequentialConnectionGraphBtFeature;
import behaviortree.graphBT.features.LayoutGraphBtFeature;
import behaviortree.graphBT.features.MoveGraphBtFeature;
import behaviortree.graphBT.features.PasteNodeGraphBtFeature;
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
		if (context instanceof IAddConnectionContext && 
				context.getNewObject() instanceof Edge) {
			Edge edge = (Edge) context.getNewObject();
			
			if(edge.getComposition().getLiteral().
					equals(Composition.ATOMIC.getLiteral())) {
				return new AddAtomicConnectionGraphBtFeature(this);
			}
			else {
				return new AddSequentialConnectionGraphBtFeature(this);
			}
		} else if (context.getNewObject() instanceof StandardNode) {
			return new AddGeneralBtNodeFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	    PictogramElement pictogramElement = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	    if (bo instanceof StandardNode) {
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof Component) {
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof Behavior) {
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof Requirement) {
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof OperatorClass) {
			return new UpdateGraphBtFeature(this);
		}
	    if (bo instanceof TraceabilityStatusClass) {
			return new UpdateGraphBtFeature(this);
		}
	   return super.getUpdateFeature(context);
	 } 
	
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
	    return new MoveGraphBtFeature(this);
	 } 
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		if (context.getPictogramElement() instanceof ContainerShape) {
			return  new LayoutGraphBtFeature(this);
		}
		return super.getLayoutFeature(context);
	}
	
	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return  new CopyNodeGraphBtFeature(this);
	}
	
	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return  new PasteNodeGraphBtFeature(this);
	}
	
//	@Override
//	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
//		return new ICustomFeature[] { new RenameGraphBtFeature(this) };
//	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(
	        IResizeShapeContext context) {
    	return new ResizeGraphBtFeature(this);
	}
	
	@Override
    public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
        return getCreateConnectionFeatures();
    }
	
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context)
	{
		return new ConnectionReconnectGraphBTFeature(this);
	}
}
