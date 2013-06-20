package org.be.graphbt.graphiti.property;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class ProjectPropertyFilter extends AbstractPropertySectionFilter {

	@Override
	public boolean accept(PictogramElement toTest) {
		if(toTest instanceof Diagram) {
        	return true;
        }
		return false;
	}
}
