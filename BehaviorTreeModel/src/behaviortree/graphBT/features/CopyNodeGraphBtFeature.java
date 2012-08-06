package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;

import behaviortree.StandardNode;

public class CopyNodeGraphBtFeature extends AbstractCopyFeature {

	public CopyNodeGraphBtFeature(IFeatureProvider fp) {
		super(fp);
		System.out.println("so, this is not even called too?! That's preposterous!");
	}
	
	@Override
	public boolean canCopy(ICopyContext context) {
		System.out.println("in the can copy method.");
		
		final PictogramElement[] pes = context.getPictogramElements();
		if (pes == null || pes.length == 0) { // nothing selected
			return false;
		}

		// return true, if all selected elements are a EClasses
		for (PictogramElement pe : pes) {
			final Object bo = getBusinessObjectForPictogramElement(pe);
			if (!(bo instanceof StandardNode)) {
				System.out.println("one of these pictograms cannot be copied.");
				return false;
			}
		}
		System.out.println("this standard node can be copied.");
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
        
        System.out.println("in the copy method");
        // put all business objects to the clipboard
        putToClipboard(bos);
	}
}