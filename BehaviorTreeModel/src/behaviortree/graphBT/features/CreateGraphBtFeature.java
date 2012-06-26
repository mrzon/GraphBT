package behaviortree.graphBT.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;


public class CreateGraphBtFeature extends AbstractCreateFeature  implements
ICreateFeature {

    public CreateGraphBtFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "General BT Node", "Create Behavior Tree Node");
    }

    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
        // create new EClass
        EClass newClass = EcoreFactory.eINSTANCE.createEClass();
     
        getDiagram().eResource().getContents().add(newClass);
        addGraphicalRepresentation(context, newClass);
     
        // activate direct editing after object creation
        getFeatureProvider().getDirectEditingInfo().setActive(true);
     
        // return newly created business object(s)
        return new Object[] { newClass };
     } 
}
