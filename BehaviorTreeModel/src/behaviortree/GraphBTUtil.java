package behaviortree;

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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.be.textbe.bt.textbt.*;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class GraphBTUtil {
	/**
	 * This method is used to get the BE factory
	 * @return instance of Behavior Tree Factory
	 */
	public static BehaviortreeFactory getBEFactory()
	{
		return BehaviortreeFactory.eINSTANCE;
	}
	
	
	/**
	 * This method is invoked in each package creation to initialize persistent model of the 
	 * diagram
	 * @param uri
	 * @param packageName
	 */
	public static BEModel createNewModel(String packageName)
	{
		getBEFactory();
		BEModel model = getBEFactory().createBEModel();
		model.setName(packageName);
		return model;
	}
	
	public static BEModel getBEModel(final Diagram d)
	{
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model");
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		if (file == null || !file.exists()) {
			System.out.println("Ga nemu modelnya");
			Resource createResource = d.eResource().getResourceSet().createResource(uri);
			try {
				createResource.save(Collections.emptyMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			createResource.setTrackingModification(true);
		}
		
		Iterator<EObject> obj = d.eResource().getResourceSet().getResource(uri,true).getContents().iterator();
		while(obj.hasNext())
		{
			EObject ob = obj.next();
			if(ob instanceof BEModel)
			{
				return (BEModel)ob;
			}
		}
		System.out.println("BE Model belum dibuat kyaa kyaa kyaa");
		BEModel beModel = GraphBTUtil.getBEFactory().createBEModel();
		beModel.setName("BTPackage");
		beModel.setComponentList(GraphBTUtil.getBEFactory().createComponentList());
		beModel.setDbt(GraphBTUtil.getBEFactory().createBehaviorTree());
		beModel.setRequirementList(GraphBTUtil.getBEFactory().createRequirementList());
		//d.eResource().getContents().add(beModel);
		try {
			saveToModelFile(beModel,d);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
        DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor)
        {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
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
	public static boolean isExist(ResourceSet rs, URI uri)
	{
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			System.out.println("mencari... yng ditemukan "+res.getURI());
			if(res.getURI().equals(uri)){
				System.out.println("ketemu "+res.getContents().size());
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
	public static Resource getResource(ResourceSet rs, URI uri)
	{
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			
			if(res.getURI().equals(uri)){
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
	public static Component getComponent(BEModel model, String name)
	{
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()){
			Component c = it.next();
	
			if(/*c.getComponentRef().equals(ref)||*/c.getComponentName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
//<<<<<<< HEAD
	/**
	 * Get component instance from a model and based on its reference string
	 * @param model
	 * @param ref
	 * @return
	 */
//=======
//>>>>>>> refs/remotes/origin/master4
	public static Component getComponentByRef(BEModel model, String ref)
	{
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()){
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
	public static void removeComponentByRef(BEModel model, String ref)
	{
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()){
			Component c = it.next();
	
			if(c.getComponentRef().equals(ref)/*||c.getComponentName().equals(ref)*/) {
				model.getComponentList().getComponents().remove(c);
				return;
			}
		}
		return;
	}
	
	public static boolean createNewComponent(BEModel model, Component com)
	{
		if(getComponent(model, com.getComponentName())!=null)
		{
			model.getComponentList().getComponents().add(com);
			return true;
		}
		return false;
	}
	
	/**
	 * get behavior instance from a component based on its tostring
	 * @param component
	 * @param ref
	 * @return
	 */
	public static Behavior getBehaviorFromComponent(Component component,
			String ref) {
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()){
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
	 * @return
	 */
	public static Behavior getBehaviorFromComponentByRef(Component component,
			String ref) {
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()){
			Behavior b = it.next();
	
			if(b.getBehaviorRef().equals(ref)) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * get requirement
	 * @param model
	 * @param key
	 * @return
	 */
	public static void removeBehaviorFromComponentByRef(Component component,
			String ref) {
		Iterator<Behavior> it = component.getBehaviors().iterator();
		while(it.hasNext()){
			Behavior b = it.next();
	
			if(b.getBehaviorRef().equals(ref)) {
				component.getBehaviors().remove(b);
				return;
			}
		}
	}
	
	public static Requirement getRequirement(BEModel model,
			String key) {
		Iterator<Requirement> it = model.getRequirementList().getRequirements().iterator();
		while(it.hasNext()){
			Requirement res = it.next();
	
			if(res.getKey().equals(key)) {
				return res;
			}
		}
		return null;
	}
	
	/**
	 * get standardnode roots from a resourceset
	 * @param rs
	 * @return
	 */
	public static void removeRequirement(BEModel model,
			String key) {
		Iterator<Requirement> it = model.getRequirementList().getRequirements().iterator();
		while(it.hasNext()){
			Requirement res = it.next();
	
			if(res.getKey().equals(key)) {
				model.getRequirementList().getRequirements().remove(res);
				return;
			}
		}
	}
	
	public static List<StandardNode> getRoots(ResourceSet rs)
	{
		List<StandardNode> l=new ArrayList<StandardNode>();
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext())
			{
				Object e = i.next();
				if(e instanceof StandardNode)
				{
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
	public static OperatorClass getOperator(Diagram rs,String literal)
	{
		
		Iterator<Resource> it = rs.eResource().getResourceSet().getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext())
			{
				Object e = i.next();
				if(e instanceof OperatorClass)
				{
					OperatorClass oc = (OperatorClass)e;
					if(oc.getOperatorLiteral().equals(literal))
					{
						return oc;
					}
				}
			}
		}
		if(Operator.get(literal) != null)
		{
			OperatorClass oc = getBEFactory().createOperatorClass();
			oc.setOperatorLiteral(literal);
			try {
				GraphBTUtil.saveToModelFile(oc,rs);
			} catch (CoreException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oc;
		}
		return null;
	}
	
	/**
	 * get traceability status 
	 * @param rs
	 * @param literal
	 * @return
	 */
	public static TraceabilityStatusClass getTraceabilityStatus(Diagram rs,String literal)
	{
		Iterator<Resource> it = rs.eResource().getResourceSet().getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext())
			{
				Object e = i.next();
				if(e instanceof TraceabilityStatusClass)
				{
					TraceabilityStatusClass oc = (TraceabilityStatusClass)e;
					if(oc.getTraceabilityStatusLiteral().equals(literal))
					{
						return oc;
					}
				}
			}
		}
		if(TraceabilityStatus.get(literal) != null)
		{
			TraceabilityStatusClass oc = getBEFactory().createTraceabilityStatusClass();
			oc.setTraceabilityStatusLiteral(literal);
			try {
				GraphBTUtil.saveToModelFile(oc,rs);
			} catch (CoreException | IOException e) {
				// TODO Auto-generated catch block
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
	public List getFormulaList()
	{
		return null;
	}
	
	/**
	 * get default requirement
	 * @param d
	 * @return
	 */
	public static Requirement getDefaultRequirement(Diagram d)
	{
		ResourceSet rs = d.eResource().getResourceSet();
		Iterator<Resource> it = rs.getResources().iterator();
		while(it.hasNext()){
			Resource res = it.next();
			Iterator<EObject> i = res.getContents().iterator();
			while(i.hasNext())
			{
				Object e = i.next();
				if(e instanceof Requirement)
				{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	public static boolean isAncestor(StandardNode src, StandardNode target)
	{
		Set <StandardNode> n = new HashSet<StandardNode>();
		collect(src, n);
		return n.contains(target);
	}
	
	/**
	 * collect node list to a set
	 * @param src
	 * @param n
	 */
	private static void collect(StandardNode src, Set<StandardNode> n)
	{
		if(src==null)
		{
			return;
		}
		else
		{
			if(src.getEdge() != null)
			{
				Edge e = src.getEdge();
				for(int i = 0; i < e.getChildNode().size();i++)
				{
					n.add((StandardNode) e.getChildNode().get(i));
					collect((StandardNode) e.getChildNode().get(i),n);
				}
			}
		}
	}
	
	/**
	 * check whether a diagram is valid or not
	 * @param d 
	 * @return true if valide, false if not
	 */
	public static boolean isValid(Diagram d)
	{
		return GraphBTUtil.getRoots(d.eResource().getResourceSet()).size() == 1;
	}
	
	/**
	 * generate from bt file
	 * @param f bt file
	 * @param de diagram editor instance
	 */
	public static void generateFromBTFile(IFile f, final DiagramEditor de)
	{
		final Diagram d = de.getDiagramTypeProvider().getDiagram();
		File xml = getXMLFromBT(f);
		if(xml == null)
		{
			return;
		}
		URI ur = URI.createFileURI(xml.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(ur, true);
		System.out.println(res.getContents().toString());
		Iterator<EObject> i = res.getAllContents();
		TextBT temp = null;
		while(i.hasNext())
		{
			EObject e = i.next();
			if(e instanceof TextBT)
			{
				temp = (TextBT) e;
				break;
			}
		}
		if(temp==null)
			return;
		final TextBT btModel = temp;
		final BEModel beModel = getBEFactory().createBEModel();
		de.getEditingDomain().getCommandStack().execute(new RecordingCommand(de.getEditingDomain(),"generating model"){
			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				beModel.setComponentList(getComponentList(btModel,d));
				try {
					saveToModelFile(beModel,d);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BehaviorTree dbt = getBEFactory().createBehaviorTree();
				RequirementList rl = getBEFactory().createRequirementList();
				beModel.setRequirementList(rl);
				dbt.setRootNode(getRoot(btModel, de));
				beModel.setDbt(dbt);
				//System.out.println("GraphBTUtil generateFromBTFile "+beModel+"\n"+((StandardNode)dbt.getRootNode()).toBTText());
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
	private static StandardNode getRoot(TextBT bt, DiagramEditor de)
	{
		StandardNode root = getBEFactory().createStandardNode();
		org.be.textbe.bt.textbt.BehaviorTree btbt = bt.getBehaviorTree();
		org.be.textbe.bt.textbt.Node rootbt = btbt.getRootNode();
		setNode(root,rootbt, de);
		setChild(root,rootbt, de);
		return root;
	}
	
	/**
	 * create instance of StandardNode node
	 * @param node
	 * @param nodebt
	 * @param de
	 */
	private static void setNode(final StandardNode node, org.be.textbe.bt.textbt.AbstractNode nodebt, final DiagramEditor de)
	{
		final Diagram d = de.getDiagramTypeProvider().getDiagram();
		
		node.setComponentRef(nodebt.getComponentRef());
		node.setBehaviorRef(nodebt.getBehaviorRef());
		node.setLabel(nodebt.getLabel()+""+System.currentTimeMillis());
		System.out.println("operatornya "+nodebt.getOperator());
		node.setOperator(nodebt.getOperator()==null?"":nodebt.getOperator());
		
		node.setTraceabilityStatus("");
		AddContext addContext = new AddContext();
		addContext.setNewObject(node);
		try {
			saveToModelFile(node,d);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addContext.setTargetContainer(d);
		de.getDiagramTypeProvider().getFeatureProvider().addIfPossible(addContext);
		System.out.println("GraphBTUtil setNode nodebt: "+node.toBTText()+" PEnya: "+Graphiti.getLinkService().getPictogramElements(d, node).size());
	}
	
	/**
	 * create connection between standardnode s and standardnode t named edge e
	 * @param de
	 * @param s
	 * @param t
	 * @param e
	 * @param tipe
	 */
	private static void createConnection(DiagramEditor de, StandardNode s, StandardNode t, Edge e, int tipe)
	{
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
        addContext.setNewObject(e);
        Connection connection = (Connection)de.getDiagramTypeProvider().getFeatureProvider().addIfPossible(addContext);
        //d.getConnections().add(connection);
	}
	
	/**
	 * set child
	 * @param node
	 * @param nodebt
	 * @param de
	 */
	private static void setChild(StandardNode node, org.be.textbe.bt.textbt.AbstractNode nodebt, DiagramEditor de)
	{
		Diagram d = de.getDiagramTypeProvider().getDiagram();
		AbstractBlockOrNode _childNode = null;
		if (nodebt instanceof org.be.textbe.bt.textbt.Node)
		{
			_childNode = ((org.be.textbe.bt.textbt.Node)nodebt).getChildNode();
		}
		else if (nodebt instanceof org.be.textbe.bt.textbt.AtomicNode)
		{
			_childNode = ((org.be.textbe.bt.textbt.AtomicNode)nodebt).getChildNode();
		}
		else if (nodebt instanceof org.be.textbe.bt.textbt.SequentialNode)
		{
			_childNode = ((org.be.textbe.bt.textbt.SequentialNode)nodebt).getChildNode();
		}
		
		if(_childNode==null)
			return;
		if(_childNode instanceof SequentialNode)
		{
			//System.out.println("GraphBTUtil setChild ternyata ini sequential node");
			org.be.textbe.bt.textbt.SequentialNode childNode = (org.be.textbe.bt.textbt.SequentialNode)_childNode;
			StandardNode childSN = getBEFactory().createStandardNode();
			setNode(childSN,childNode, de);
			//System.out.println("setChild jumlahPE "+childSN.toBTText()+" "+Graphiti.getLinkService().getPictogramElements(d, childSN).size());
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.SEQUENTIAL);
			e.getChildNode().add(childSN);
			node.setEdge(e);
			createConnection(de,node,childSN,e,0);
			setChild(childSN,childNode, de);
		}
		else if(_childNode instanceof AtomicNode)
		{
			org.be.textbe.bt.textbt.AtomicNode childNode = (org.be.textbe.bt.textbt.AtomicNode)_childNode;
			StandardNode childSN = getBEFactory().createStandardNode();
			setNode(childSN,childNode, de);
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.ATOMIC);
			e.getChildNode().add(childSN);
			node.setEdge(e);
			createConnection(de,node,childSN,e,1);
			setChild(childSN,childNode, de);
		}
		else if(_childNode instanceof AbstractBlock)
		{
			EList<org.be.textbe.bt.textbt.Node> childNodes = ((AbstractBlock)_childNode).getChildNode();
			Edge e = getBEFactory().createEdge();
			e.setComposition(Composition.SEQUENTIAL);
			if(_childNode instanceof ParallelBlock)
			{
				e.setBranch(Branch.PARALLEL);
			}
			else
			{
				e.setBranch(Branch.ALTERNATIVE);
			}
			node.setEdge(e);
			for(int i = 0; i < childNodes.size(); i++)
			{
				org.be.textbe.bt.textbt.Node childNode = childNodes.get(i);
				StandardNode childSN = getBEFactory().createStandardNode();
				setNode(childSN,childNode, de);
				e.getChildNode().add(childSN);
				createConnection(de,node,childSN,e,3);
				setChild(childSN,childNode, de);
			}
		}
		
	}
	
	private static ComponentList getComponentList(TextBT bt, Diagram d)
	{
		//System.out.print("GraphBTUtil getComponentList ");
		ComponentList cl = getBEFactory().createComponentList();
		org.be.textbe.bt.textbt.ComponentList clbt = bt.getComponents();
		for(int i = 0; i < clbt.getComponents().size(); i++)
		{
			Component cp = getBEFactory().createComponent();
			org.be.textbe.bt.textbt.Component cpbt = clbt.getComponents().get(i);
			//System.out.print(cpbt.getVal()+" "+cpbt.getRef());
			cp.setComponentName(cpbt.getVal());
			cp.setComponentRef(cpbt.getRef());
			cl.getComponents().add(cp);
			for(int j=0; j<cpbt.getBehaviors().size();j++)
			{
				Behavior b = getBEFactory().createBehavior();
				AbstractBehavior abbt = cpbt.getBehaviors().get(j);
				cp.getBehaviors().add(b);
				if(abbt instanceof org.be.textbe.bt.textbt.State)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.STATE_REALIZATION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				else if(abbt instanceof org.be.textbe.bt.textbt.Selection)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.SELECTION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				else if(abbt instanceof org.be.textbe.bt.textbt.Guard)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.GUARD);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.Event)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.GUARD);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.InternalInput)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.INTERNAL_INPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.InternalOutput)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.INTERNA_OUTPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.ExternalInput)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.EXTERNAL_INPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.ExternalOutput)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.EXTERNAL_OUTPUT);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}else if(abbt instanceof org.be.textbe.bt.textbt.Assertion)
				{
					org.be.textbe.bt.textbt.Behavior bbt = (org.be.textbe.bt.textbt.Behavior)abbt;
					b.setBehaviorType(BehaviorType.SELECTION);
					b.setBehaviorName(bbt.getVal());
					b.setBehaviorRef(bbt.getRef());
				}
				System.out.print("behavior ke "+j+": "+b.toString()+" "+abbt.toString());
			}
			
			try {
				saveToModelFile(cp,d);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println();
		return cl;
	}
	
	private static File getXMLFromBT(IFile file){	
		IInjector injector = null;
		IExtractor extractor = null;
		IReferenceModel inMetamodel;
		IReferenceModel outMetamodel;
		File target = null;
		URL btASMURL;
		URL ctASMURL;
		URL stASMURL;
		ModelFactory factory = null;	
		try {
			Bundle bundle = Platform.getBundle("BTDebuggerTool");
			btASMURL = bundle.getEntry("transformations/textBT2GV.asm");
			ctASMURL = null;
			stASMURL = null;

			injector = CoreService.getInjector("EMF"); //$NON-NLS-1$
			extractor = CoreService.getExtractor("EMF"); //$NON-NLS-1$

			factory = CoreService.createModelFactory("EMF");
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
		IFile f = (IFile) file;
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
			Scanner s = new Scanner(file.getContents(true));
			injector.inject(inputModel, file.getFullPath().toPortableString());

			target = File.createTempFile("tempbt2sal", ".textbt", null);
			
			IWorkbenchPart workbenchPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart(); 
			IFile fileRaw = (IFile) workbenchPart.getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			if (fileRaw == null)
				try {
					throw new FileNotFoundException();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			String path1 = fileRaw.getRawLocation().toOSString();

			path1 = path1.substring(0, path1.lastIndexOf("."));
			path1 = path1+".xml";
			File f1 = new File(path1);
			System.out.println("path Init: " + path1);

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
	 * @param d
	 * @return
	 */
	public static String getBTText(Diagram d)
	{
		BEModel be = GraphBTUtil.getBEModel(d);
		String content = be.toString();
		List<StandardNode> ln = GraphBTUtil.getRoots(d.eResource().getResourceSet());
		for(int i=0; i < ln.size(); i++)
		{
			content+="\n"+ln.get(i).toBTText();
		}
		return content;
	}
	
	/**
	 * generate bt file from diagram file
	 * @param diag
	 * @return
	 */
	public static boolean generateBTFromDiagramFile(IFile diag)
	{
		ResourceSet rs = new ResourceSetImpl();
		Diagram d = GraphBTUtil.getDiagramFromFile(diag, rs);
		if(!isValid(d))
		{
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
				if (file == null || !file.exists()) 
				{
					ifile.create(in,false,null);
				}	
				else
				{
					ifile.setContents(in, false, false, null);
				}	
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	/**
	 * apply layout to a diagram
	 * @param d
	 */
	public static void applyTreeLayout(Diagram d)
	{
		if(!isValid(d))
		{
			return;
		}
		StandardNode root = getRoots(d.eResource().getResourceSet()).get(0);
		HashMap<StandardNode,Integer> map = new HashMap<StandardNode,Integer>();
		int width = getWidth(d,root,map);
		System.out.println(map.toString());
		int currentY = 0;
		int currentX = 0;
		applyTreeLayout(d,root,currentX,currentY,map);
		
	}
	private static int hSpace = 20;
	private static int vSpace = 30;
	
	/**
	 * apply tree layout
	 * @param d
	 * @param node
	 * @param currentX
	 * @param currentY
	 * @param map
	 */
	private static void applyTreeLayout(Diagram d, StandardNode node, int currentX, int currentY, HashMap<StandardNode,Integer> map)
	{
		final PictogramElement rootP = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
		final int width = map.get(node);
		final int cX = currentX;
		final int cY = currentY;
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor)
        {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Move Node") {
			protected void doExecute() {
				rootP.getGraphicsAlgorithm().setX(cX+width/2);
				rootP.getGraphicsAlgorithm().setY(cY);
			}
		};
		ds.getEditingDomain().getCommandStack().execute(cmd);
		if(node.getEdge()==null)
		{
			return;
		}
		currentY = currentY + vSpace + rootP.getGraphicsAlgorithm().getHeight();
		for(int i = 0; i < node.getEdge().getChildNode().size(); i++)
		{
			GraphBTUtil.applyTreeLayout(d, (StandardNode) node.getEdge().getChildNode().get(i),currentX,currentY,map);
			currentX=currentX + hSpace+map.get((StandardNode) node.getEdge().getChildNode().get(i));
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
		if(node.getEdge() == null)
		{
			PictogramElement rootP = Graphiti.getLinkService().getPictogramElements(d, node).get(0);
			map.put(node, rootP.getGraphicsAlgorithm().getWidth());
			return rootP.getGraphicsAlgorithm().getWidth();
		}
		int width = getWidth(d, (StandardNode) node.getEdge().getChildNode().get(0), map);
		
		for(int i = 1; i < node.getEdge().getChildNode().size(); i++)
		{
			width=width+hSpace+getWidth(d, (StandardNode) node.getEdge().getChildNode().get(i),map);
		}
		map.put(node, width);
		return width;
	}
	
	public static IContextButtonEntry createGraphBtDeleteContextButton(IFeatureProvider featureProvider, PictogramElement pe) {
		IDeleteContext deleteContext = new DeleteContext(pe);
		IDeleteFeature deleteFeature = featureProvider.getDeleteFeature(deleteContext);
		IContextButtonEntry ret = null;
		
		StandardNode node = (StandardNode) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		
//		node.getEdge().
		if (deleteFeature != null) {
			ret = new ContextButtonEntry(deleteFeature, deleteContext);
			ContextEntryHelper.markAsDeleteContextEntry(ret);
		}
		return ret;
	}
}
