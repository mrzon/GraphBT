package behaviortree.graphBT.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import behaviortree.StandardNode;


public class GraphBTDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public GraphBTDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphBTFeatureProvider(this));
	
	}
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new GraphBTToolBehaviorProvider(this) };
		}
		DiagramEditor d = new DiagramEditor();
		
		return toolBehaviorProviders;
	}

}
