/**
 * 
 */
package org.be.graphbt.graphiti.diagram;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Layout;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.internal.GraphitiUIPlugin;

public class GraphBTDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	private IToolBehaviorProvider[] toolBehaviorProviders;

	@SuppressWarnings("restriction")
	public GraphBTDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphBTFeatureProvider(this));
		GraphBTUtil.getBEModel(getDiagram(),true);
	}
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new GraphBTToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
}
