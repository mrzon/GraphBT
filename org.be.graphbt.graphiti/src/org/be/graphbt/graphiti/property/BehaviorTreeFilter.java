package org.be.graphbt.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.be.graphbt.model.graphbt.*;

/**
 * Class to filter whether property section of BT node can be accessed or not
 * @author GraphBT Team
 *
 */
public class BehaviorTreeFilter extends AbstractPropertySectionFilter {
	
    @Override
    protected boolean accept(PictogramElement pe) {
        EObject eObject =
            Graphiti.getLinkService()
            .getBusinessObjectForLinkedPictogramElement(pe);

        EObject eObj = null;
        if(pe instanceof Shape){
	        eObj = Graphiti.getLinkService()
	                .getBusinessObjectForLinkedPictogramElement(((Shape)pe).getContainer());
        }
        else {
        	return false;
        }
        
        boolean isTrue = false;
        if (eObject instanceof StandardNode) {
        	isTrue = true;
        }
        if (eObject instanceof Component) {
        	isTrue = true;
        }
        if (eObject instanceof Behavior) {
        	isTrue = true;
        }
        if (eObj instanceof StandardNode) {
        	isTrue = true;
        }
        if (eObj instanceof Component) {
        	isTrue = true;
        }
        if (eObj instanceof Behavior) {
        	isTrue = true;
        }
        return isTrue;
    }
}
