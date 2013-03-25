/**
 * 
 */
package org.be.graphbt.graphiti.diagram;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class GraphBTDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public GraphBTDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphBTFeatureProvider(this));
		GraphBTUtil.getBEModel(getDiagram(), true);	
	}
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new GraphBTToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}

}
