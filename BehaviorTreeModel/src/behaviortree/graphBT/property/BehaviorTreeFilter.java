package behaviortree.graphBT.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.eclipse.graphiti.mm.pictograms.Shape;
import behaviortree.*;


public class BehaviorTreeFilter extends AbstractPropertySectionFilter {
	
    @Override
    protected boolean accept(PictogramElement pe) {
        EObject eObject =
            Graphiti.getLinkService()
            .getBusinessObjectForLinkedPictogramElement(pe);
        if(!(pe instanceof Shape))
        	return false;
        EObject eObj =
                Graphiti.getLinkService()
                .getBusinessObjectForLinkedPictogramElement(((Shape)pe).getContainer());
            
        
        System.out.println("Ane masuk filter nyakkk");
        boolean isTrue = false;
        if (eObject instanceof StandardNode) {
        	isTrue = true;
        	System.out.println("Ini adalah standard node di treefilter..");
        }
        if (eObject instanceof Component) {
        	isTrue = true;
        	System.out.println("Ini adalah component di treefilter..");
        }
        if (eObject instanceof Behavior) {
        	isTrue = true;
        	System.out.println("Ini adalah behavior di treefilter..");
        }
        if (eObj instanceof StandardNode) {
        	isTrue = true;
        	System.out.println("Ini adalah standard node..");
        }
        if (eObj instanceof Component) {
        	isTrue = true;
        	System.out.println("Ini adalah component..");
        }
        if (eObj instanceof Behavior) {
        	isTrue = true;
        	System.out.println("Ini adalah behavior..");
        }
        return isTrue;
    }
}
