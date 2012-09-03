package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;

/**
 * Class to define resize feature for BT node  
 * of two connected BT node
 * @author GraphBT Team
 *
 */
public class ResizeGraphBtFeature extends DefaultResizeShapeFeature {

	public ResizeGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}

	/**
	 * Disables resize functionality for BT node
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false;
	}
}