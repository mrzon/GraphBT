package behaviortree.graphBT.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;


public class GraphBTDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public GraphBTDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphBTFeatureProvider(this));
	}
}
