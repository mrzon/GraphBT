package org.be.graphbt.graphiti;

import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AccessoryUtil {
	
	public static final IColorConstant ORIGINAL_BEHAVIOR_COLOR =
			new ColorConstant("99FF66");
	public static final IColorConstant IMPLIED_BEHAVIOR_COLOR =
			new ColorConstant("FFFF33");	//yellow
	public static final IColorConstant MISSING_BEHAVIOR_COLOR =
			new ColorConstant("FF6666");	//red
	public static final IColorConstant UPDATED_BEHAVIOR_COLOR =
			new ColorConstant("66CCFF");	//blue
	public static final IColorConstant DELETED_BEHAVIOR_COLOR =
			new ColorConstant("FFFFFF");	//white
	public static final IColorConstant ERROR_COLOR =
			new ColorConstant("D32121");	//red
	
	public static IColorConstant getNormalColor(StandardNode node) {
		int t = TraceabilityStatus.get(node.getTraceabilityStatus()).getValue();
		switch (t) {
		case TraceabilityStatus.ORIGINAL_VALUE:
			return ORIGINAL_BEHAVIOR_COLOR;
		case TraceabilityStatus.DELETED_VALUE:
			return DELETED_BEHAVIOR_COLOR;
		case TraceabilityStatus.DESIGN_REFINEMENT_VALUE:
			return DELETED_BEHAVIOR_COLOR;
		case TraceabilityStatus.IMPLIED_VALUE:
			return IMPLIED_BEHAVIOR_COLOR;
		case TraceabilityStatus.MISSING_VALUE:
			return MISSING_BEHAVIOR_COLOR;
		case TraceabilityStatus.UPDATED_VALUE:
			return UPDATED_BEHAVIOR_COLOR;
		}
		return null;
	}
	
}
