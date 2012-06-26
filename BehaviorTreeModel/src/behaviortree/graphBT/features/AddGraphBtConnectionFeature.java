package behaviortree.graphBT.features;



import org.eclipse.emf.ecore.EReference;
import behaviortree.graphBT.StyleUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
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

public class AddGraphBtConnectionFeature extends AbstractAddFeature implements
		IAddFeature {

	public AddGraphBtConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		
		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof EReference) {
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

		Polyline polyline = gaService.createPlainPolyline(connection);
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		EReference addedEReference = (EReference) context.getNewObject();
		link(connection, addedEReference);
		
		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		Text text = gaService.createPlainText(textDecorator);
		text.setStyle(StyleUtil.getStyleForTextDecorator((getDiagram())));
		gaService.setLocation(text, 10, 0);

		EReference eReference = (EReference) context.getNewObject();
		text.setValue(eReference.getName());

		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);
		
		return connection;
	}
	
		
	private Polygon createArrow(GraphicsAlgorithmContainer gaContainer) {
		
		Polygon polygon = Graphiti.getGaCreateService().createPlainPolygon(gaContainer, new int[] { -15, 10, 0, 0, -15, -10, -15, 10 });
				
//		polygon.setBackground((org.eclipse.graphiti.mm.algorithms.styles.Color) Color.BLACK);
//		polygon.setForeground((org.eclipse.graphiti.mm.algorithms.styles.Color) Color.BLACK);

		return polygon;
	}
}
