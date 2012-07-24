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

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;

public class GraphBTToolBehaviorProvider  extends DefaultToolBehaviorProvider {

	//private List<Square> allowedSquaresForMove = new ArrayList<Square>();

	public GraphBTToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public boolean isShowGuides() {
		return false;
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		Object object = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		// Check if the business object of the given pictogram element (the
		// square) is one of the allowed squares (see CreateChessMoveFeature)
		// for a move in progress
		
		return super.getDecorators(pe);
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
}
