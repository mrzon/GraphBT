package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import behaviortree.Branch;
import behaviortree.Edge;
import behaviortree.GraphBTUtil;

/**
 * Class AddSequentialConnectionGraphBtFeature is for adding sequential edge between
 * two connected nodes
 * @author GraphBT Team
 *
 */
public class AddSequentialConnectionGraphBtFeature extends AbstractAddFeature implements
		IAddFeature {

	public AddSequentialConnectionGraphBtFeature(IFeatureProvider fp) {
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
		System.out.println("AddSequentialConnection add: "+addConContext.getSourceAnchor()+" "+addConContext.getTargetAnchor());
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		Polyline polyline = gaService.createPlainPolyline(connection);
		
		
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		
		Edge addedEdge = (Edge) context.getNewObject();
		link(connection, addedEdge);
		
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);
		
		if(addedEdge.getBranch().getLiteral().equals(Branch.ALTERNATIVE.getLiteral())) {
			System.out.println("herehereh");
			ConnectionDecorator cd2;
			cd2 = peCreateService.createConnectionDecorator(connection, false, 0.0, true);
			createAlternativeIdentifier(cd2);
		}
		GraphBTUtil.applyTreeLayout(getDiagram());
		return connection;
	}
	
	private Polygon createArrow(GraphicsAlgorithmContainer gaContainer) {
		
		Polygon polygon = Graphiti.getGaCreateService().createPlainPolygon(gaContainer, new int[] { -15, 10, 0, 0, -15, -10, -15, 10 });
		return polygon;
	}
	
	private Polygon createAlternativeIdentifier(GraphicsAlgorithmContainer gaContainer) {
		Polygon polygon = Graphiti.getGaCreateService().createPlainPolygon(gaContainer, new int[] { -5, 5, 5, 5, 5, -5, -5, -5, -5, 5 });
		polygon.setBackground(manageColor(new ColorConstant(0, 255, 0)));
		polygon.setForeground(manageColor(new ColorConstant(0, 0, 0)));
		polygon.setLineWidth(1);
		return polygon;
	}
}
