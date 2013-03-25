package org.be.graphbt.graphiti.features;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.LayoutList;
import org.be.graphbt.model.graphbt.Node;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.graphiti.wizards.createstandardnode.CreateStandardNodeGraphBTWizard;

/**
 * Class CreateGeneralBtNodeFeature is for creating BT model 
 * @author GraphBT Team
 *
 */
public class CreateLayoutFeature extends AbstractCreateFeature  implements
ICreateFeature {
	
    public CreateLayoutFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Layout", "Create Layout");
    }

    /**
     * Check whether the BT node model can be created
     */
    public boolean canCreate(ICreateContext context) {
    	BEModel model = GraphBTUtil.getBEModel(getDiagram());
    	LayoutList ll = model.getLayoutList();
    	if(ll!=null) {
    		return false;
    	}
        return context.getTargetContainer() instanceof Diagram;
    }
    
    
    public Object[] create(ICreateContext context) {
        
		LayoutList layout = GraphBTUtil.getBEFactory().createLayoutList();
		
		
		// Delegate to the add feature
		addGraphicalRepresentation(context, layout);
		
		return new Object[] { layout };
     }    
}