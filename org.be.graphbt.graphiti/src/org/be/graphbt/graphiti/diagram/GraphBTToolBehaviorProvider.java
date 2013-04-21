/**
 * 
 */
package org.be.graphbt.graphiti.diagram;

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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultContextButtonPadData;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;

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
			IContextButtonEntry deleteButton = createGraphBtDeleteContextButton(
					getFeatureProvider(), pe);
			data.getGenericContextButtons().add(deleteButton);
			IContextButtonEntry button = new ContextButtonEntry(null, context);
		    button.setText("Create connection");
		    button.setIconId("GRAPHBT-IMAGE-C1");
		    data.getGenericContextButtons().add(button);
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
	
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		IContextMenuEntry[] ret = NO_CONTEXT_MENU_ENTRIES;
		List<IContextMenuEntry> retList = new ArrayList<IContextMenuEntry>();
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			retList.add(new ContextMenuEntry(customFeature, context));
		}
		
		if(retList.size() > 0) {
			ret = (IContextMenuEntry[]) retList.toArray(new IContextMenuEntry[retList.size()]);
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
			strBuff.append(com.getComponentDesc()==null?"":com.getComponentDesc());
			return strBuff.toString();
		}
		if(bo instanceof Behavior) {
			Behavior beh = (Behavior) bo;
			StringBuffer strBuff = new StringBuffer(beh.getBehaviorRef());
			strBuff.append(". ");
			strBuff.append(beh.getBehaviorName());
			strBuff.append('\n');
			strBuff.append(beh.getBehaviorDesc()==null?"":beh.getBehaviorDesc());
			return strBuff.toString();
		}
		return super.getToolTip(ga);
	}
	/**
	 * create GraphBTDeleteContextButton 
	 * @param featureProvider
	 * @param pe
	 * @return
	 */
	private static IContextButtonEntry createGraphBtDeleteContextButton(IFeatureProvider featureProvider, final PictogramElement pe) {
		final IDeleteContext deleteContext = new DeleteContext(pe);
		IEditorPart ep = (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
		final DiagramEditor de;
		if(ep instanceof MultiPageEditor)
			de = ((MultiPageEditor)ep).getDiagramEditor();
		else
			de = (DiagramEditor)ep;
		final IDeleteFeature deleteFeature = featureProvider.getDeleteFeature(deleteContext);

		IContextButtonEntry ret = null;

		if (deleteFeature != null) {
			ret = new ContextButtonEntry(deleteFeature, deleteContext) {
				@Override
				public boolean canExecute() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public void execute() {
					// TODO Auto-generated method stub
					final StandardNode node = (StandardNode) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

					de.getEditingDomain().getCommandStack().execute(new RecordingCommand(de.getEditingDomain(), "Remove Node object") {

						@Override
						protected void doExecute() {
							if(node.getParent()!=null) {
								StandardNode parent = node.getParent();
								int i = 0;
								while(i < parent.getEdge().getChildNode().size()) {
									if(parent.getEdge().getChildNode().get(i).getTarget()==node) {
										parent.getEdge().getChildNode().get(i).setSource(null);
										parent.getEdge().getChildNode().remove(i);
									} else if (parent.getEdge().getChildNode().get(i).getTarget()==null) {
										parent.getEdge().getChildNode().get(i).setSource(null);
										parent.getEdge().getChildNode().remove(i);
										} else {
										i++;
									}
								}
								node.setParent(null);
								if(parent.getEdge().getChildNode().size() ==1) {
									parent.getEdge().setBranch(null);
								}
								else if(parent.getEdge().getChildNode().size()==0) {
									parent.setEdge(null);
								}
								System.out.println(" "+node.toBTText());
							}
							if(node.getEdge() != null) {
								for(int i = 0; i < node.getEdge().getChildNode().size(); i++) {
									StandardNode child = (StandardNode) node.getEdge().getChildNode().get(i).getTarget();
									if(child == null) {
										continue;
									}
									child.setParent(null);
									child.setLeaf(false);
								}
								EList<Link> childNodes = node.getEdge().getChildNode();
								EList<EObject> objects = GraphBTUtil.getRoots(de.getDiagramTypeProvider().getDiagram().eResource().getResourceSet()).get(0).eResource().getContents();
								
								for(int i = 0; i < childNodes.size();i++) {
									if(childNodes.get(i).getTarget()!=null)
										objects.add(childNodes.get(i).getTarget());
								}
								node.getEdge().getChildNode().clear();
								node.setEdge(null);
							}
							
							deleteFeature.delete(deleteContext);
						}

					});
				}
			};
			ContextEntryHelper.markAsDeleteContextEntry(ret);
		}
		return ret;
	}
}
