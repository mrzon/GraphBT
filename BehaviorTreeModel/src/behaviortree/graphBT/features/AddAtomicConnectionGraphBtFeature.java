package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import behaviortree.Edge;
import behaviortree.graphBT.StyleUtil;

public class AddAtomicConnectionGraphBtFeature extends AbstractAddFeature implements
		IAddFeature {

	public AddAtomicConnectionGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		
		if (context instanceof IAddConnectionContext && 
				context.getNewObject() instanceof Edge) {
			return true;
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

//		connection.getEnd().getGraphicsAlgorithm().
//			setX(connection.getStart().getGraphicsAlgorithm().getX());
//		connection.getEnd().getGraphicsAlgorithm().
//		setY(connection.getStart().getGraphicsAlgorithm().getY() +
//				connection.getStart().getGraphicsAlgorithm().getHeight());
		
		Polyline polyline = gaService.createPlainPolyline(connection);
		
		gaService.setLocation(polyline, addConContext.getX(), addConContext.getY());
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		Edge addedEdge = (Edge) context.getNewObject();
		link(connection, addedEdge);
		
//		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
//		Text text = gaService.createPlainText(textDecorator);
//		text.setStyle(StyleUtil.getStyleForTextDecorator((getDiagram())));
//		gaService.setLocation(text, 10, 0);

		return connection;
	}
}
