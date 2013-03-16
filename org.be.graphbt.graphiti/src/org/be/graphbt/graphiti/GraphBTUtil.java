package org.be.graphbt.graphiti;

/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * Copyright (c) 2012 GreenCloud.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    GreenCloud - enhancement in adding feature for GraphBT
 *
 * </copyright>
 *
 *******************************************************************************/
import org.be.graphbt.graphiti.editor.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorTree;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Branch;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.ComponentList;
import org.be.graphbt.model.graphbt.Composition;
import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.model.graphbt.Formula;
import org.be.graphbt.model.graphbt.GraphBTFactory;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.Link;
import org.be.graphbt.model.graphbt.MapInformation;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.OperatorClass;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.RequirementList;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.State;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.model.graphbt.TraceabilityStatusClass;
import org.be.textbe.bt.textbt.*;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.RenderingStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IDiagramEditor;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.parts.PictogramElementDelegate;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class GraphBTUtil {
	public static void updateReversionNode(final IDiagramEditor ds) {
		if(!(ds instanceof GraphBTDiagramEditor))
		{
			return;
		}
		final GraphBTDiagramEditor de = (GraphBTDiagramEditor)ds;
		final Diagram d = de.getDiagramTypeProvider().getDiagram();
		
		if(de.reversionNode.size()==0) {
			de.errorReversionNode.clear();
			return;
		}
		System.out.println("di update revision: "+de.errorReversionNode.size()+" "+de.reversionNode.size());
		
		//RecordingCommand cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			//protected void doExecute() {
				ArrayList<StandardNode> list = new ArrayList<StandardNode>(de.errorReversionNode);
				for(int i = 0; i < list.size(); i++) {
					final StandardNode node = list.get(i);
					if(Graphiti.getLinkService().getPictogramElements(d, node).size()==0) {
						continue;
					}
					final PictogramElement pe = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
					Edge edge = node.getEdge();
					System.out.println("Edgenya nih "+edge+"Ancestornya nih "+GraphBTUtil.getAncestor(node));
					final Rectangle rectangle = (Rectangle) pe.getGraphicsAlgorithm();
					if(edge != null||GraphBTUtil.getAncestor(node)==null) {
						Color ren = rectangle.getBackground();
						if(!(ren.getBlue()==AccessoryUtil.ERROR_COLOR.getBlue()&&ren.getRed()==AccessoryUtil.ERROR_COLOR.getRed())) {
							rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.ERROR_COLOR));
						}
						System.out.println(ren.toString());
					}
					else
					{
						de.errorReversionNode.remove(node);
						rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.getNormalColor(node)));
						Color ren = rectangle.getBackground();
						System.out.println(ren.toString());
					}	//pe.getGraphicsAlgorithm().
				}
			//}
		//};
		//TransactionalEditingDomain f = ds.getEditingDomain();
		//f.getCommandStack().execute(cmd);
		System.out.println("setelah update: "+de.errorReversionNode.size()+" "+de.reversionNode.size());
		
	}
	
	/**
	 * This method is used to get the BE factory
	 * @return instance of Behavior Tree Factory
	 */
	public static GraphBTFactory getBEFactory() {
		return GraphBTFactory.eINSTANCE;
	}

	
	/**
	 * get active DiagramEditor instance
	 * @return the active DiagramEditor or null if there is no active DiagramEditor
	 */
	public static DiagramEditor getDiagramEditor() {
		IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(page!=null) {
			return page instanceof DiagramEditor?(DiagramEditor)page:null;
		}
		return null;
	}
	
	
	/**
	 * This method is invoked in each package creation to initialize persistent model of the 
	 * diagram
	 * @param uri
	 * @param packageName
	 */
	public static BEModel createNewModel(String packageName) {
		getBEFactory();
		BEModel model = getBEFactory().createBEModel();
		model.setName(packageName);
		return model;
	}

	
	/**
	 * get BEModel from a Diagram
	 * @param d the diagram
	 * @return existing model or new model if no existing found
	 */
	@SuppressWarnings("restriction")
	public static BEModel getBEModel(final Diagram d) {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model");
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		if (file == null || !file.exists()) {
			Log.info(0, "Model is not exist yet");
			Resource createResource = d.eResource().getResourceSet().createResource(uri);
			try {
				createResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			createResource.setTrackingModification(true);
		}

		Iterator<EObject> obj = d.eResource().getResourceSet().getResource(uri,true).getContents().iterator();
		while(obj.hasNext()) {
			EObject ob = obj.next();
			if(ob instanceof BEModel) {
				return (BEModel)ob;
			}
		}
		BEModel beModel = GraphBTUtil.getBEFactory().createBEModel();
		beModel.setName("BTPackage");
		try {
			saveToModelFile(beModel,d);

			for(int i = 0; i < Operator.VALUES.size(); i++) {
				OperatorClass oc = getBEFactory().createOperatorClass();
				oc.setOperatorLiteral(Operator.VALUES.get(i).getLiteral());
				saveToModelFile(oc,d);
			}
			for(int i = 0; i < TraceabilityStatus.VALUES.size(); i++) {
				TraceabilityStatusClass oc = getBEFactory().createTraceabilityStatusClass();
				oc.setTraceabilityStatusLiteral(TraceabilityStatus.VALUES.get(i).getLiteral());
				saveToModelFile(oc,d);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return beModel;
	}

	
	/**
	 * Get diagram files from a project
	 * @param p project instance
	 * @return collection of diagrams
	 */
	public static Collection<Diagram> getDiagrams(IProject p) {
		final List<IFile> files = getDiagramFiles(p);
		final List<Diagram> diagramList = new ArrayList<Diagram>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Diagram diagram = getDiagramFromFile(file, rSet);
			if (diagram != null) {
				diagramList.add(diagram);
			}
		}
		return diagramList;
	}

	
	/**
	 * Save an object to a corresponding diagram
	 * @param obj object that want to added
	 * @param d diagram instance
	 * @throws CoreException
	 * @throws IOException
	 */
	public static void saveToModelFile(final EObject obj, final Diagram d) throws CoreException, IOException {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		ResourceSet rSet = d.eResource().getResourceSet();
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		if (file == null || !file.exists()) {
			Resource createResource = rSet.createResource(uri);
			createResource.save(Collections.emptyMap());
			createResource.setTrackingModification(true);
		}
		final Resource resource = rSet.getResource(uri, true);
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		DiagramEditor ds = null;
		if(page == null)
			return;
		if(page.getActiveEditor() instanceof DiagramEditor) {
			ds = (DiagramEditor)page.getActiveEditor();	
		} else if(page.getActiveEditor() instanceof MultiPageEditor) {
			ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
		} else {
			return;
		}
		RecordingCommand cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				resource.getContents().add(obj);
			}
		};
		TransactionalEditingDomain f = ds.getEditingDomain();
		f.getCommandStack().execute(cmd);
	}

	
	/**
	 * get list of file which contain diagram instance from a folder 
	 * @param folder instance of folder
	 * @return list of diagram file
	 */
	private static List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".btdiagram")) { //$NON-NLS-1$
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return ret;
	}

	
	/**
	 * get diagram instance from a file
	 * @param file instance of file
	 * @param resourceSet instance of ResourceSet that used in the diagram 
	 * @return diagram instance
	 */
	public static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);

		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EList<EObject> contents = resource.getContents();
				for (final EObject object : contents) {
					if (object instanceof Diagram) {
						return (Diagram) object;
					}
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}


		return null;
	}

	
	public static URI getDiagramModelURI(Diagram d) {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		return uri;
	}

	
	/**
	 * get file URI from a file based on a ResourceSet
	 * @param file
	 * @param resourceSet
	 * @return
	 */
	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}

	
	/**
	 * get resourceset instance from a diagram
	 * @param d
	 * @return
	 * @throws CoreException
	 * @throws IOException
	 */
	public static ResourceSet getResourceSet(final Diagram d) throws CoreException, IOException {
		ResourceSet rSet = d.eResource().getResourceSet();
		return rSet;
	}

	
	/**
	 * check whether the uri is exist in a resource set
	 * @param rs the resourceset
	 * @param uri the uri
	 * @return true if exist, false if not
	 */
	public static boolean isExist(ResourceSet rs, URI uri) {
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()) {
			Resource res = it.next();
			if(res.getURI().equals(uri)) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * get a resource from a resourceset based on a uri
	 * @param rs the resource set
	 * @param uri the uri
	 * @return the resource
	 */
	public static Resource getResource(ResourceSet rs, URI uri) {
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()) {
			Resource res = it.next();

			if(res.getURI().equals(uri)) {
				return res;
			}
		}
		return null;
	}
	

	/**
	 * Get component instance based on a model and its name
	 * @param model bt model
	 * @param name component name
	 * @return
	 */
	public static Component getComponent(BEModel model, String name) {
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()) {
			Component c = it.next();

			if(/*c.getComponentRef().equals(ref)||*/c.getComponentName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	
	/**
	 * Get component instance from a model and based on its reference string
	 * @param model
	 * @param ref
	 * @return
	 */
	public static Component getComponentByRef(BEModel model, String ref) {
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()) {
			Component c = it.next();

			if(c.getComponentRef().equals(ref)/*||c.getComponentName().equals(ref)*/) {
				return c;
			}
		}
		return null;
	}

	
	/**
	 * Create new component in a model
	 * @param model the model instance
	 * @param com the component instance
	 * @return true if the adding success, false if not
	 */
	public static void removeComponentByRef(BEModel model, String ref) {
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()) {
			Component c = it.next();

			if(c.getComponentRef().equals(ref)/*||c.getComponentName().equals(ref)*/) {
				model.getComponentList().getComponents().remove(c);
				return;
			}
		}
		return;
	}

	
	/**
	 * get behavior instance from a component based on its tostring
	 * @param component
	 * @param ref
	 * @return behavior instance, null if there is no such behavior with the given tostring
	 */
	public static Behavior getBehaviorFromComponent(Component component,
			String ref) {
		if (component==null)
			return null;
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()) {
			Behavior b = it.next();

			if(b.toString().equals(ref)) {
				return b;
			}
		}
		return null;
	}

	/**
	 * get behavior instance from a component based on its reference string
	 * @param component
	 * @param ref
	 * @return behavior instance, null if there is no such behavior
	 */
	public static Behavior getBehaviorFromComponentByRef(Component component,
			String ref) {
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()) {
			Behavior b = it.next();

			if(b.getBehaviorRef().equals(ref)) {
				return b;
			}
		}
		return null;
	}
	

	/**
	 * removes behavior from component based on its reference
	 * @param component the component
	 * @param ref the reference
	 */
	public static void removeBehaviorFromComponentByRef(Component component,
			String ref) {
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()) {
			Behavior b = it.next();

			if(b.getBehaviorRef().equals(ref)) {
				component.getBehaviors().remove(b);
				return;
			}
		}
	}

	
	/**
	 * get requirement from a model based on the key
	 * @param model
	 * @param key
	 * @return
	 */
	public static Requirement getRequirement(Diagram d,
			String key) {
		Iterator<Requirement> it = GraphBTUtil.getBEModel(d).getRequirementList().getRequirements().iterator();
		while(it.hasNext()) {
			Requirement res = it.next();

			if(res.getKey().equals(key)) {
				return res;
			}
		}
		return GraphBTUtil.getDefaultRequirement(d);
	}

	/**
	 * Removes a requirement from model based on its key
	 * @param model the BEModel
	 * @param key the requirement key
	 */
	public static void removeRequirement(BEModel model,
			String key) {
		Iterator<Requirement> it = model.getRequirementList().getRequirements().iterator();
		while(it.hasNext()) {
			Requirement res = it.next();

			if(res.getKey().equals(key)) {
				model.getRequirementList().getRequirements().remove(res);
				return;
			}
		}
	}

	
	/**
	 * getRoots will return a list of available roots in the model. Root 
	 * node is a node which has no parent. 
	 * @param rs
	 * @return
	 */
	public static List<StandardNode> getRoots(ResourceSet rs) {
		List<StandardNode> l=new ArrayList<StandardNode>();
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()) {
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext()) {
				Object e = i.next();
				if(e instanceof StandardNode) {
					l.add((StandardNode)e);
				}
			}
		}

		return l;
	}

	/**
	 * get operator class
	 * @param rs
	 * @param literal
	 * @return
	 */
	public static OperatorClass getOperator(Diagram rs,String literal) {
		URI uri = rs.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		Iterator<EObject> it = rs.eResource().getResourceSet().getResource(uri,true).getContents().iterator();

		while(it.hasNext()) {
			Object e = it.next();
			if(e instanceof OperatorClass) {
				OperatorClass oc = (OperatorClass)e;
				if(oc.getOperatorLiteral().equals(literal)) {
					return oc;
				}
			}
		}
		if(Operator.get(literal) != null) {
			OperatorClass oc = getBEFactory().createOperatorClass();
			oc.setOperatorLiteral(literal);
			
				try {
					GraphBTUtil.saveToModelFile(oc,rs);
				} catch (CoreException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			return oc;
		}
		return null;
	}
	
	public static AlternativeClass getAlternativeClass(Diagram rs,String literal) {
		URI uri = rs.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		Iterator<EObject> it = rs.eResource().getResourceSet().getResource(uri,true).getContents().iterator();

		while(it.hasNext()) {
			Object e = it.next();
			if(e instanceof AlternativeClass) {
				AlternativeClass oc = (AlternativeClass) e;
				if(oc.getAlternativeAttribute().equals(literal)) {
					return oc;
				}
			}
		}
		AlternativeClass oc = getBEFactory().createAlternativeClass();
		oc.setAlternativeAttribute(literal);
		
			try {
				GraphBTUtil.saveToModelFile(oc,rs);
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		return oc;
	}

	
	/**
	 * get traceability status 
	 * @param rs
	 * @param literal
	 * @return
	 */
	public static TraceabilityStatusClass getTraceabilityStatus(Diagram rs,String literal) {
		URI uri = rs.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		Iterator<EObject> it = rs.eResource().getResourceSet().getResource(uri,true).getContents().iterator();
		while(it.hasNext()) {
			EObject res = it.next();
			if(res instanceof TraceabilityStatusClass) {
				TraceabilityStatusClass oc = (TraceabilityStatusClass)res;
				if(oc.getTraceabilityStatusLiteral().equals(literal)) {
					return oc;
				}
			}

		}
		if(TraceabilityStatus.get(literal) != null) {
			TraceabilityStatusClass oc = getBEFactory().createTraceabilityStatusClass();
			oc.setTraceabilityStatusLiteral(literal);

				try {
					GraphBTUtil.saveToModelFile(oc,rs);
				} catch (CoreException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			return oc;
		}
		return null;
	}

	/**
	 * get list of formula
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Formula> getFormulaList(BEModel model) {
		if(model.getFormulaList()!=null) {
			return (List<Formula>) model.getFormulaList();
		}
		return null;
	}

	/**
	 * get default requirement
	 * @param d
	 * @return
	 */
	public static Requirement getDefaultRequirement(Diagram d) {
		ResourceSet rs = d.eResource().getResourceSet();
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()) {
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext()) {
				Object e = i.next();
				if(e instanceof Requirement) {
					Requirement r = (Requirement)e;
					if(r.getKey().equals(""))
						return r;
				}
			}
		}
		Requirement r = getBEFactory().createRequirement();
		r.setKey("");
		r.setRequirement("This is the default Requirement");
		try {
			GraphBTUtil.saveToModelFile(r, d);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * looks whether target node is ancestor of source node
	 * @param src source node
	 * @param target target node
	 * @return true if target is ancestor of source, false if not
	 */
	public static boolean isAncestor(StandardNode src, StandardNode target) {
		Set <StandardNode> n = new HashSet<StandardNode>();
		collect(src, n);
		return n.contains(target);
	}

	/**
	 * collect node list to a set
	 * @param src
	 * @param n
	 */
	private static void collect(StandardNode src, Set<StandardNode> n) {
		if(src==null) {
			return;
		}
		else
		{
			if(src.getEdge() != null) {
				Edge e = src.getEdge();
				for(int i = 0; i < e.getChildNode().size();i++) {
					n.add((StandardNode) e.getChildNode().get(i).getTarget());
					collect((StandardNode) e.getChildNode().get(i).getTarget(),n);
				}
			}
		}
	}

	/**
	 * check whether a diagram is valid or not
	 * @param d 
	 * @return 0 if valid, other if not
	 */
	public static int isValid(Diagram d) {
		List<StandardNode> listNode = GraphBTUtil.getRoots(d.eResource().getResourceSet()); //get all roots from the model 
		if(getDiagramEditor() instanceof GraphBTDiagramEditor ) {
		GraphBTDiagramEditor de = (GraphBTDiagramEditor)getDiagramEditor();
		if(listNode.size()>0) {
			StandardNode node = listNode.get(0); 
	
			checkReversion(node); //check 
	
			if(listNode.size() != 1)
				return 1;
			if(de.errorReversionNode.size() > 0) {
				return 2;
			}
		}
		}
		return 0;
	}

	
	/**
	 * check error from reversion node
	 * @param node 
	 */
	private static void checkReversion(StandardNode node) {
		if(node.getEdge() != null && node.getOperator().equals(Operator.REVERSION.getLiteral())) {
		//	errorReversionNode.add(node);
		}
		else if(node.getEdge() != null && !node.getOperator().equals(Operator.REVERSION.getLiteral())) {
			List<Link> nodes = node.getEdge().getChildNode();
			for(Link node1 : nodes) {
				checkReversion((StandardNode) node1.getTarget());
			}
		}
		else {
			return;
		}
	}

	/**
	 * generate from bt file
	 * @param f bt file
	 * @param de diagram editor instance
	 */
	public static void generateFromBTFile(IFile f, final DiagramEditor de) {
		final Diagram d = de.getDiagramTypeProvider().getDiagram();
		File xml = getXMLFromBT(f);
		if(xml == null) {
			return;
		}
		URI ur = URI.createFileURI(xml.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(ur, true);
		Iterator<EObject> i = res.getAllContents();
		TextBT temp = null;
		while(i.hasNext()) {
			EObject e = i.next();
			if(e instanceof TextBT) {
				temp = (TextBT) e;
				break;
			}
		}
		if(temp==null)
			return;
		final TextBT btModel = temp;
		final BEModel beModel = getBEModel(d);
		de.getEditingDomain().getCommandStack().execute(new RecordingCommand(de.getEditingDomain(),"generating model") {
			@Override
			protected void doExecute() {
				beModel.setComponentList(getComponentList(btModel,d));
				BehaviorTree dbt = getBEFactory().createBehaviorTree();
				RequirementList rl = getBEFactory().createRequirementList();
				beModel.setRequirementList(rl);
				dbt.setRootNode(getRoot(btModel, de));
				beModel.setDbt(dbt);
			}
		});
		applyTreeLayout(d);
	}

	/**
	 * get StandardNode root from bt instance
	 * @param bt 
	 * @param de
	 * @return
	 */
	private static StandardNode getRoot(TextBT bt, DiagramEditor de) {
		StandardNode root = getBEFactory().createStandardNode();
		org.be.textbe.bt.textbt.BehaviorTree btbt = bt.getBehaviorTree();
		org.be.textbe.bt.textbt.Node rootbt = btbt.getRootNode();
		setNode(root,rootbt, de);
		setChild(root,rootbt, de);
		return root;
	}

	/**
	 * create instance of StandardNode node from which in TextBE model
	 * @param node
	 * @param nodebt
	 * @param de
	 */
	private static void setNode(final StandardNode node, org.be.textbe.bt.textbt.AbstractNode nodebt, final DiagramEditor de) {
		final Diagram d = de.getDiagramTypeProvider().getDiagram();

		node.setComponentRef(nodebt.getComponentRef());
		node.setBehaviorRef(nodebt.getBehaviorRef());
		node.setLabel(nodebt.getLabel()+""+System.currentTimeMillis());
		node.setOperator(nodebt.getOperator()==null?"":nodebt.getOperator());

		node.setTraceabilityStatus("");
		AddContext addContext = new AddContext();
		addContext.setNewObject(node);
		try {
			saveToModelFile(node,d);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		addContext.setTargetContainer(d);
		de.getDiagramTypeProvider().getFeatureProvider().addIfPossible(addContext);
	}

	/**
	 * create connection between standardnode s and standardnode t named edge e
	 * @param de
	 * @param s
	 * @param t
	 * @param e
	 * @param tipe
	 */
	private static void createConnection(DiagramEditor de, StandardNode s, StandardNode t, Link l, int tipe) {
		Diagram d = de.getDiagramTypeProvider().getDiagram();
		PictogramElement peS = Graphiti.getLinkService().getPictogramElements(d, s).get(0);
		PictogramElement peC = Graphiti.getLinkService().getPictogramElements(d, t).get(0);
		CreateConnectionContext context = new CreateConnectionContext();
		context.setSourcePictogramElement(peS);
		context.setTargetPictogramElement(peC);

		Anchor source = Graphiti.getPeService().getChopboxAnchor((ContainerShape) peS);
		if(source == null)
			return;
		Anchor target = Graphiti.getPeService().getChopboxAnchor((ContainerShape) peC);
		if(target == null)
			return;
		AddConnectionContext addContext =
				new AddConnectionContext(source, target);
		addContext.setNewObject(l);
		Connection connection = (Connection)de.getDiagramTypeProvider().getFeatureProvider().addIfPossible(addContext);
		//d.getConnections().add(connection);
	}

	/**
	 * set child
	 * @param node
	 * @param nodebt
	 * @param de
	 */
	private static void setChild(StandardNode node, org.be.textbe.bt.textbt.AbstractNode nodebt, DiagramEditor de) {
		Diagram d = de.getDiagramTypeProvider().getDiagram();
		AbstractBlockOrNode _childNode = null;
		if (nodebt instanceof org.be.textbe.bt.textbt.Node) {
			_childNode = ((org.be.textbe.bt.textbt.Node)nodebt).getChildNode();
		}
		else if (nodebt instanceof org.be.textbe.bt.textbt.AtomicNode) {
			_childNode = ((org.be.textbe.bt.textbt.AtomicNode)nodebt).getChildNode();
		}
		else if (nodebt instanceof org.be.textbe.bt.textbt.SequentialNode) {
			_childNode = ((org.be.textbe.bt.textbt.SequentialNode)nodebt).getChildNode();
		}

		if(_childNode==null)
			return;
		if(_childNode instanceof SequentialNode) {
			org.be.textbe.bt.textbt.SequentialNode childNode = (org.be.textbe.bt.textbt.SequentialNode)_childNode;
			StandardNode childSN = getBEFactory().createStandardNode();
			setNode(childSN,childNode, de);
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.SEQUENTIAL);
			Link l = getBEFactory().createLink();
			l.setSource(node);
			l.setTarget(childSN);
			e.getChildNode().add(l);
			childSN.setParent(node);
			childSN.setLeaf(true);
			node.setEdge(e);
			createConnection(de,node,childSN,l,0);
			setChild(childSN,childNode, de);
		}
		else if(_childNode instanceof AtomicNode) {
			org.be.textbe.bt.textbt.AtomicNode childNode = (org.be.textbe.bt.textbt.AtomicNode)_childNode;
			StandardNode childSN = getBEFactory().createStandardNode();
			setNode(childSN,childNode, de);
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.ATOMIC);
			Link l = getBEFactory().createLink();
			l.setSource(node);
			l.setTarget(childSN);
			e.getChildNode().add(l);
			childSN.setParent(node);
			childSN.setLeaf(true);
			node.setEdge(e);
			createConnection(de,node,childSN,l,1);
			setChild(childSN,childNode, de);
		}
		else if(_childNode instanceof AbstractBlock) {
			EList<org.be.textbe.bt.textbt.Node> childNodes = ((AbstractBlock)_childNode).getChildNode();
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.SEQUENTIAL);
			if(_childNode instanceof ParallelBlock) {
				e.setBranch(Branch.PARALLEL);
			}
			else
			{
				e.setBranch(Branch.ALTERNATIVE);
			}
			node.setEdge(e);
			for(int i = 0; i < childNodes.size(); i++) {
				org.be.textbe.bt.textbt.Node childNode = childNodes.get(i);
				StandardNode childSN = getBEFactory().createStandardNode();
				setNode(childSN,childNode, de);
				Link l = getBEFactory().createLink();
				l.setSource(node);
				l.setTarget(childSN);
				e.getChildNode().add(l);
				createConnection(de,node,childSN,l,3);
				childSN.setParent(node);
				childSN.setLeaf(true);
				setChild(childSN,childNode, de);
			}
		}

	}

	
	/**
	 * get GraphBT's component list from TextBE model
	 * @param bt 
	 * @param d
	 * @return
	 */
	private static ComponentList getComponentList(TextBT bt, Diagram d) {
		//System.out.print("GraphBTUtil getComponentList ");
		ComponentList cl = getBEFactory().createComponentList();
		org.be.textbe.bt.textbt.ComponentList clbt = bt.getComponents();
		for(int i = 0; i < clbt.getComponents().size(); i++) {
			Component cp = getBEFactory().createComponent();
			org.be.textbe.bt.textbt.Component cpbt = clbt.getComponents().get(i);
			//System.out.print(cpbt.getVal()+" "+cpbt.getRef());
			cp.setComponentName(cpbt.getVal());
			cp.setComponentRef(cpbt.getRef());
			cl.getComponents().add(cp);
			for(int j=0; j<cpbt.getBehaviors().size();j++) {
				Behavior b = getBEFactory().createBehavior();
				AbstractBehavior abbt = cpbt.getBehaviors().get(j);
				cp.getBehaviors().add(b);
				if(abbt instanceof org.be.textbe.bt.textbt.State) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.STATE_REALIZATION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				else if(abbt instanceof org.be.textbe.bt.textbt.Selection) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.SELECTION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				else if(abbt instanceof org.be.textbe.bt.textbt.Guard) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.GUARD);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.Event) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.GUARD);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.InternalInput) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.INTERNAL_INPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.InternalOutput) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.INTERNAL_OUTPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.ExternalInput) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.EXTERNAL_INPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.ExternalOutput) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.EXTERNAL_OUTPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.Assertion) {
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.SELECTION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				System.out.print("behavior ke "+j+": "+b.toString()+" "+abbt.toString());
			}

		}
		return cl;
	}

	
	/**
	 * return ancestor of a reversion node
	 * @param node
	 * @return
	 */
	public static StandardNode getAncestor(StandardNode node) {
		StandardNode parent = getAncestor(node.getParent(), node);
		return parent;
	}
	
	
	private static StandardNode getAncestor(StandardNode parent,
			StandardNode node) {
		if(parent==null)
			return null;
		if(parent.getBehaviorRef().equals(node.getBehaviorRef())&&parent.getComponentRef().equals(node.getComponentRef())) {
			return parent;
		}
		return getAncestor(parent.getParent(),node);
	}

	
	/**
	 * getXMLFromBT is used to get the file representation of XML 
	 * representation of a BT file. The implementation used the existing
	 * model that already defined in TextBE plugin. 
	 * @param file instance of BT file 
	 * @return File instance of the XML file, null is no XML file produced
	 */
	public static File getXMLFromBT(IFile file) {	
		IInjector injector = null;
		IExtractor extractor = null;
		IReferenceModel inMetamodel;
		IReferenceModel outMetamodel;
		File target = null;
		ModelFactory factory = null;	
		try {
			

			injector = CoreService.getInjector("EMF"); //$NON-NLS-1$
			extractor = CoreService.getExtractor("EMF"); //$NON-NLS-1$

			factory = CoreService.createModelFactory("EMF");
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
		//IPath path = (IPath) f.getLocation();
		IModel outputModel = null;
		// Defaults
		try {
			// Metamodels
			inMetamodel = factory.newReferenceModel();
			outMetamodel = factory.newReferenceModel();
			injector.inject(inMetamodel, "http://org.be.textbe/textbt");	    
			injector.inject(outMetamodel, "http://org.be.textbe/gv");		    

			// Getting Launcher
			ILauncher launcher = null;
			launcher = CoreService.getLauncher("EMF-specific VM");
			launcher.initialize(Collections.<String, Object> emptyMap());
			// Creating Models
			IModel inputModel = factory.newModel(inMetamodel);
			outputModel = factory.newModel(outMetamodel);
			// Loading Existing Model
			injector.inject(inputModel, file.getFullPath().toPortableString());

			target = File.createTempFile("tempbt2sal", ".textbt", null);

			IWorkbenchPart workbenchPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart(); 
			IFile fileRaw = (IFile) workbenchPart.getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			if (fileRaw == null)
				try {
					throw new FileNotFoundException();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			String path1 = fileRaw.getRawLocation().toOSString();

			path1 = path1.substring(0, path1.lastIndexOf("."));
			path1 = path1+".xml";
			File f1 = new File(path1);
			// DEBUG - Dump Input Model
			//extractor.extract(inputModel, filetest.getName());
			extractor.extract(inputModel, target.toURI().toString());
			//extractor.extract(inputModel, f1.toURI().toString());
			target.deleteOnExit();
			// Launching
			launcher.addOutModel(outputModel, "GV", "OUT");
			launcher.addInModel(inputModel, "TEXTBT", "IN");
			// Saving Model
			extractor.extract(outputModel, "outputModel.gv");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		return target;
	}

	
	/**
	 * get bt text from a diagram
	 * @param d the diagram representation
	 * @return TextBE text
	 */
	public static String getBTText(Diagram d) {
		BEModel be = GraphBTUtil.getBEModel(d);
		String content = be.toString();
		List<StandardNode> ln = GraphBTUtil.getRoots(d.eResource().getResourceSet());
		for(int i=0; i < ln.size(); i++) {
			content+="\n"+ln.get(i).toBTText();
		}
		return content;
	}

	
	/**
	 * generate bt file from diagram file
	 * @param diag
	 * @return
	 */
	public static boolean generateBTFromDiagramFile(IFile diag) {
		ResourceSet rs = new ResourceSetImpl();
		Diagram d = GraphBTUtil.getDiagramFromFile(diag, rs);
		if(isValid(d) > 0) {
			return false;
		}
		String content = getBTText(d);
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("bt");

		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		{
			Path path = new Path(uri.toPlatformString(true));
			IFile ifile = workspaceRoot.getFile(path);
			InputStream in = new ByteArrayInputStream(content.getBytes());
			try {
				if (file == null || !file.exists()) {
					ifile.create(in,false,null);
				}	
				else
				{
					ifile.setContents(in, false, false, null);
				}	
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	
	/**
	 * apply layout to a diagram
	 * @param d
	 */
	public static void applyTreeLayout(Diagram d) {
		List<StandardNode> roots = getRoots(d.eResource().getResourceSet());
		HashMap<StandardNode,Integer> widthMap = new HashMap<StandardNode,Integer>();
		HashMap<Integer,Integer> heightMap = new HashMap<Integer,Integer>();
		int currentY = 0;
		int currentX = 0;
		for(int i = 0; i < roots.size(); i++) {
			int width = getWidth(d,roots.get(i),widthMap);
			int height = getHeight(d,roots.get(i),heightMap,0);

			applyTreeLayout(d,roots.get(i),currentX,currentY,widthMap,heightMap,0);
			currentX+=width+hSpace;
			currentY=0;
		}
	}
	private static int hSpace = 20;
	private static int vSpace = 30;

	
	/**
	 * apply tree layout
	 * @param d
	 * @param node
	 * @param currentX
	 * @param currentY
	 * @param widthMap
	 */
	private static void applyTreeLayout(Diagram d, StandardNode node, int currentX, int currentY, HashMap<StandardNode,Integer> widthMap,HashMap<Integer,Integer> heightMap, int level) {
		if(Graphiti.getLinkService().getPictogramElements(d, node).size()==0){
			return;
		}
		PictogramElement rootP = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
		final int width = widthMap.get(node);
		final int height = heightMap.get(level);
		int currentHeight = rootP.getGraphicsAlgorithm().getHeight();
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final DiagramEditor ds;
		if(page.getActiveEditor() instanceof DiagramEditor) {
			ds = (DiagramEditor)page.getActiveEditor();	
		}
		else
		{
			ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
		}
		currentY = currentY + vSpace;
		if(node.getParent()==null || node.getParent()!=null && node.getParent().getEdge().getComposition().getValue()==Composition.SEQUENTIAL_VALUE) {
			if(node.getEdge()!=null && node.getEdge().getComposition().getValue()==Composition.ATOMIC_VALUE) {
				PictogramElement rootP1 = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
				currentHeight=rootP1.getGraphicsAlgorithm().getHeight();
				StandardNode child = node;
				while (child.getEdge()!=null && child.getEdge().getComposition().getValue()==Composition.ATOMIC_VALUE) {
					rootP1 = Graphiti.getLinkService().getPictogramElements(d, child).get(0);
					currentHeight+=rootP1.getGraphicsAlgorithm().getHeight();
					child = (StandardNode) child.getEdge().getChildNode().get(0).getTarget();
				}
				currentY=currentY+height/2-currentHeight/2;
				child = (StandardNode) node;
				while (child.getEdge()!=null && child.getEdge().getComposition().getValue()==Composition.ATOMIC_VALUE) {
					final PictogramElement rootP11 = Graphiti.getLinkService().getPictogramElements(d, child).get(0);
					final int cX = currentX;
					final int cY = currentY;
					final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Move Node") {
						protected void doExecute() {
							rootP11.getGraphicsAlgorithm().setX(cX+width/2);
							rootP11.getGraphicsAlgorithm().setY(cY);
						}
					};
					currentY+=rootP11.getGraphicsAlgorithm().getHeight();
					ds.getEditingDomain().getCommandStack().execute(cmd);
					child = (StandardNode) child.getEdge().getChildNode().get(0).getTarget();
				}
				node=child;
			}
			else
			{
				currentY=currentY+height/2-currentHeight/2;
			}
		}

		final PictogramElement rootP1 = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
		final int cX = currentX;
		final int cY = currentY;
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Move Node") {
			protected void doExecute() {
				rootP1.getGraphicsAlgorithm().setX(cX+width/2);
				rootP1.getGraphicsAlgorithm().setY(cY);
			}
		};
		currentY+=rootP1.getGraphicsAlgorithm().getHeight()+vSpace;
		ds.getEditingDomain().getCommandStack().execute(cmd);

		if(node.getEdge()==null) {
			return;
		}

		if(node.getEdge().getComposition().getValue()==Composition.SEQUENTIAL_VALUE) {
			currentY = currentY-currentHeight/2+height/2;
			for(int i = 0; i < node.getEdge().getChildNode().size(); i++) {
				GraphBTUtil.applyTreeLayout(d, (StandardNode) node.getEdge().getChildNode().get(i).getTarget(),currentX,currentY,widthMap,heightMap,level+1);
				int a = 0;
				if(widthMap.get((StandardNode) node.getEdge().getChildNode().get(i).getTarget())!=null) {
					a = widthMap.get((StandardNode) node.getEdge().getChildNode().get(i).getTarget());
				}
				currentX=currentX + hSpace+a;
			}
		}
	}

	
	/**
	 * get subtree width
	 * @param d
	 * @param node
	 * @param map
	 * @return
	 */
	private static int getWidth(Diagram d, StandardNode node, HashMap<StandardNode,Integer> map) {
		if(node==null)
			return 0;
		if(Graphiti.getLinkService().getPictogramElements(d, node) != null && (node.getEdge() == null||node.getEdge()!=null&&node.getEdge().getChildNode().size()==0)) {
			if(Graphiti.getLinkService().getPictogramElements(d, node).size()==0){
				EcoreUtil.delete(node);
				return 0;
			}
			PictogramElement rootP = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
			map.put(node, rootP.getGraphicsAlgorithm().getWidth());
			return rootP.getGraphicsAlgorithm().getWidth();
		}
		int width = getWidth(d, (StandardNode) node.getEdge().getChildNode().get(0).getTarget(), map);

		for(int i = 1; i < node.getEdge().getChildNode().size(); i++) {
			width=width+hSpace+getWidth(d, (StandardNode) node.getEdge().getChildNode().get(i).getTarget(),map);
		}
		map.put(node, width);
		return width;
	}

	
	/**
	 * get subtree height
	 * @param d
	 * @param node
	 * @param map
	 * @param level
	 * @return
	 */
	private static int getHeight(Diagram d, StandardNode node, HashMap<Integer,Integer> map, int level) {

		if(node==null||Graphiti.getLinkService().getPictogramElements(d, node).size()==0)
			return 0;
		int height=Graphiti.getLinkService().getPictogramElements(d, node).get(0).getGraphicsAlgorithm().getHeight();

		if(node.getEdge()==null) {
			if(map.get(level)==null||map.get(level)!=null&&map.get(level)<height) {
				map.put(level, height);
			}
			return 0;
		}
		if(node.getEdge().getComposition().getValue()==Composition.ATOMIC_VALUE) {
			StandardNode child = node;
			while (child.getEdge()!=null && child.getEdge().getComposition().getValue()==Composition.ATOMIC_VALUE) {
				PictogramElement rootP = Graphiti.getLinkService().getPictogramElements(d, child).get(0);
				height+=rootP.getGraphicsAlgorithm().getHeight();
				child = (StandardNode) child.getEdge().getChildNode().get(0).getTarget();
			}
			node=child;
		}
		if(map.get(level) == null || map.get(level) != null&&map.get(level)<height) {
			map.put(level, height);
		}
		for(int i = 0; node.getEdge()!=null&&i < node.getEdge().getChildNode().size(); i++) {
			StandardNode child = (StandardNode) node.getEdge().getChildNode().get(i).getTarget();
			getHeight(d,child,map,level+1);
		}
		return 0;
	}
	
	
	

	/**
	 * get Attribute instance from a component based on its reference string
	 * @param component
	 * @param ref
	 * @return behavior instance, null if there is no such behavior
	 */
	public static Attribute getAttributeFromComponentByName(Component c, String text) {
		Iterator<Attribute> it = c.getAttributes().iterator();
		while(it.hasNext()) {
			Attribute b = it.next();

			if(b.getName().equals(text)) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * get Attribute instance from a component based on its to string
	 * @param component
	 * @param ref
	 * @return behavior instance, null if there is no such behavior
	 */
	public static Attribute getAttributeFromComponent(Component c, String text) {
		Iterator<Attribute> it = c.getAttributes().iterator();
		while(it.hasNext()) {
			Attribute b = it.next();

			if(b.toString().equals(text)) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * remove attribute instance from component based on its name
	 * @param c
	 * @param name
	 */
	public static void removeAttributeFromComponentByName(Component c,
			String name) {
		Iterator<Attribute> it = c.getAttributes().iterator();
		while(it.hasNext()) {
			Attribute b = it.next();

			if(b.getName().equals(name)) {
				c.getAttributes().remove(b);
				return;
			}
		}
	}
	
	/**
	 * 
	 * @param c
	 * @param selected
	 * @return
	 */
	public static State getStateFromComponent(Component c, String selected) {
		Iterator<State> it = c.getState().iterator();
		while(it.hasNext()) {
			State b = it.next();
			if(b.getName().equals(selected)) {
				return b;
			}
		}
		return null;
	}
	public static void removeStateFromComponent(Component c, State s) {
		c.getState().remove(s);
	}
	public static State getStateFromComponentByRef(Component c, String key) {
		for(int i = 0; i < c.getState().size(); i++) {
			State s = c.getState().get(i);
			if(s.getRef().equals(key)) {
				return s;
			}
		}
		return null;
	}
	public static Library getLibraryFromComponent(Component c, String bSelection) {
		// TODO Auto-generated method stub
		for(Library l:c.getUses()) {
			if(l.getId().equals(bSelection))
				return l;
		}
		return null;
	}
}
