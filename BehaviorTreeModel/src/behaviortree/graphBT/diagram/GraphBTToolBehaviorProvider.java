package behaviortree.graphBT.diagram;

/*******************************************************************************
 * <copyright>
*
* Copyright (c) 2011, 2012 SAP AG.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    SAP AG - initial API, implementation and documentation
*    mwenz - Bug 358255 - Add Border/Background decorators
*
* </copyright>
*
*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultContextButtonPadData;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Requirement;
import behaviortree.StandardNode;

public class GraphBTToolBehaviorProvider  extends DefaultToolBehaviorProvider {

	public GraphBTToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public boolean isShowGuides() {
		return false;
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		return super.getDecorators(pe);
	}
	
	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = new DefaultContextButtonPadData();//new DefaultContextButtonPadData(); 
		PictogramElement pe = context.getPictogramElement();
		Object object = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		GraphicsAlgorithm ga = getSelectionBorder(pe);
		if (ga == null) {
			ga = pe.getGraphicsAlgorithm();
		}

		if (ga != null) {
			ILocation origin = getAbsoluteLocation(ga);
			data.getPadLocation().setRectangle(origin.getX(), origin.getY(), ga.getWidth(), ga.getHeight());
		}
		
		if(object instanceof StandardNode) {
			IContextButtonEntry deleteButton = GraphBTUtil.createGraphBtDeleteContextButton(
					getFeatureProvider(), pe);
			data.getGenericContextButtons().add(deleteButton);
		}

		return data;
	}
	
	
	@Override
	public IPaletteCompartmentEntry[] getPalette() {
	    List<IPaletteCompartmentEntry> ret =
	        new ArrayList<IPaletteCompartmentEntry>();
	 
	    // add compartments from super class
	    IPaletteCompartmentEntry[] superCompartments =
	        super.getPalette();
	    for (int i = 0; i < superCompartments.length; i++)
	        ret.add(superCompartments[i]);
	 
	    // add new compartment at the end of the existing compartments
	    PaletteCompartmentEntry compartmentEntry =
	        new PaletteCompartmentEntry("Stacked", null);
	    ret.add(compartmentEntry);
	 
	    // add new stack entry to new compartment
	    StackEntry stackEntry = new StackEntry("EObject", "EObject", null);
	    compartmentEntry.addToolEntry(stackEntry);
	 
	    // add all create-features to the new stack-entry
	    IFeatureProvider featureProvider = getFeatureProvider();
	    ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
	    for (ICreateFeature cf : createFeatures) {
	        ObjectCreationToolEntry objectCreationToolEntry = 
	               new ObjectCreationToolEntry(cf.getCreateName(),
	                 cf.getCreateDescription(), cf.getCreateImageId(),
	                    cf.getCreateLargeImageId(), cf);
	        stackEntry.addCreationToolEntry(objectCreationToolEntry);
	    }
	        
	    // add all create-connection-features to the new stack-entry
	    ICreateConnectionFeature[] createConnectionFeatures =
	         featureProvider.getCreateConnectionFeatures();
	    for (ICreateConnectionFeature cf : createConnectionFeatures) {
	        ConnectionCreationToolEntry connectionCreationToolEntry = 
	            new ConnectionCreationToolEntry(cf.getCreateName(), cf
	              .getCreateDescription(), cf.getCreateImageId(),
	                cf.getCreateLargeImageId());
	                    connectionCreationToolEntry.addCreateConnectionFeature(cf);
	        stackEntry.addCreationToolEntry(connectionCreationToolEntry);
	    }
	 
	    return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
	} 
	
	public IContextMenuEntry[] getContextMenu(ICustomContext context)
	{
		IContextMenuEntry[] ret = NO_CONTEXT_MENU_ENTRIES;
		List<IContextMenuEntry> retList = new ArrayList<IContextMenuEntry>();
		System.out.println("Aku kepencet.. kyaa~~");
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			System.out.println("getContextMenu "+customFeatures[i].canExecute(context));
			retList.add(new ContextMenuEntry(customFeature, context));
		}
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public String getToolTip(GraphicsAlgorithm ga) {
		PictogramElement pe = ga.getPictogramElement();
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Requirement) {
			Requirement req = ((Requirement) bo);
			StringBuffer strBuff = new StringBuffer(req.getRequirement());
			strBuff.append('\n');
			strBuff.append(req.getDescription());
			return strBuff.toString();
		}
		if(bo instanceof Component) {
			Component com = (Component) bo;
			StringBuffer strBuff = new StringBuffer(com.getComponentRef());
			strBuff.append(". ");
			strBuff.append(com.getComponentName());
			strBuff.append('\n');
			strBuff.append("Default description");
			return strBuff.toString();
		}
		if(bo instanceof Behavior) {
			Behavior beh = (Behavior) bo;
			StringBuffer strBuff = new StringBuffer(beh.getBehaviorRef());
			strBuff.append(". ");
			strBuff.append(beh.getBehaviorName());
			strBuff.append('\n');
			strBuff.append("Default description");
			return strBuff.toString();
		}
		
		return super.getToolTip(ga);
	}
}
