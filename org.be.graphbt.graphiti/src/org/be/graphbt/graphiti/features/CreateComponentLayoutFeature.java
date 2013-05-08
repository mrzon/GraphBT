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
import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.LayoutList;
import org.be.graphbt.model.graphbt.Node;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.wizards.createcomponentlayout.CreateComponentLayoutGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createstandardnode.CreateStandardNodeGraphBTWizard;

/**
 * Class CreateGeneralBtNodeFeature is for creating BT model 
 * @author GraphBT Team
 *
 */
public class CreateComponentLayoutFeature extends AbstractCreateFeature  implements
ICreateFeature {
	private BEModel beModel;
	
    public CreateComponentLayoutFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Component layout", "Create Component Layout");
    }

    /**
     * Check whether the BT node model can be created
     */
    public boolean canCreate(ICreateContext context) {
    	if(context.getTargetContainer().getLink()==null)
    		return false;
    	if(context.getTargetContainer().getLink().getBusinessObjects().size()==0)
    		return false;
    	if(context.getTargetContainer() instanceof Diagram)
    		return false;
        return context.getTargetContainer().getLink().getBusinessObjects().get(0) instanceof LayoutList;
    }
    
    
    public Object[] create(ICreateContext context) {
        
		HashMap <Integer,String> map = new HashMap <Integer,String>(); 
		
		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
                getActiveWorkbenchWindow().getShell(),
    		new CreateComponentLayoutGraphBTWizard(map, getDiagram()));
    		
		if (wizardDialog.open() != Window.OK) {
			return null;
		} 
		
		Layout layout = GraphBTUtil.getBEFactory().createLayout();
		layout.setCRef(map.get(Component.REF_VALUE));
		
		// Delegate to the add feature
		addGraphicalRepresentation(context, layout);
		
		return new Object[] { layout };
     }    
}