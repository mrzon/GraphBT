package behaviortree.graphBT.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;


public class CreateGraphBtConnectionFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateGraphBtConnectionFeature(IFeatureProvider fp) {
		super(fp, "Connection", "Creates a new connection");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getEClass(context.getSourceAnchor()) != null) {
            return true;
        }
        return false;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		EClass source = getEClass(context.getSourceAnchor());
        EClass target = getEClass(context.getTargetAnchor());
        if (source != null && target != null && source != target) {
            return true;
        }
        return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null; 

        // get EClasses which should be connected
        EClass source = getEClass(context.getSourceAnchor());
        EClass target = getEClass(context.getTargetAnchor());

        if (source != null && target != null) {
            // create new business object
            EReference eReference = createEReference(source, target);
            
            // add connection for business object
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(eReference);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }

        return newConnection;
	}
	
    private EClass getEClass(Anchor anchor) {
        if (anchor != null) {
            Object object =
                getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof EClass) {
                return (EClass) object;
            }
        }
        return null;
    }
    
    
    private EReference createEReference(EClass source, EClass target) {
        EReference eReference = EcoreFactory.eINSTANCE.createEReference();
        //eReference.setName("new EReference");
        eReference.setEType(target);
        eReference.setLowerBound(0);
        eReference.setUpperBound(1);
        source.getEStructuralFeatures().add(eReference);
        return eReference;

   }
}
