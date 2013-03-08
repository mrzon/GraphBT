package org.be.graphbt.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;

import org.be.graphbt.model.graphbt.StandardNode;

/**
 * Class for specifying copy feature for a standard BT node
 * @author GraphBT Team
 *
 */
public class CopyNodeGraphBtFeature extends AbstractCopyFeature {

	public CopyNodeGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canCopy(ICopyContext context) {
		final PictogramElement[] pes = context.getPictogramElements();
		if (pes == null || pes.length == 0) { // nothing selected
			return false;
		}

		// return true, if all selected elements are a EClasses
		for (PictogramElement pe : pes) {
			final Object bo = getBusinessObjectForPictogramElement(pe);
			if (!(bo instanceof StandardNode)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void copy(ICopyContext context) {
		PictogramElement[] pes = context.getPictogramElements();
        Object[] bos = new Object[pes.length ];
        for (int i = 0; i < pes.length ; i++) {
            PictogramElement pe = pes[i];
            bos[i] = getBusinessObjectForPictogramElement(pe);
            
        }
        // put all business objects to the clipboard
        putToClipboard(bos);
	}
	
	
}