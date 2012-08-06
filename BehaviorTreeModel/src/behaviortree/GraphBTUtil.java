package behaviortree;

/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *
 * </copyright>
 *
 *******************************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

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
		
		/*
		  getBEFactory();

	      // Register the XMI Resource factory for the.enterprise extension
	      // Obtain a new Resource set
	      // Load one of the resources into the resoruce set.
	     
	      // Print all the resources inthe Resource set.
	      // Note: the process of printing the contents of the first Resource

	      // will cause the second Resource to be demand loaded.
		  URI uri = URI.createURI("bt.model");
	      BEModel beModel = null;
	      if(GraphBTUtil.isExist(resourceSet, uri)&&resourceSet.getResource(uri, true).getContents().size()>0)
			{
	    	    System.out.println("Di method getBEModel sih resourcesetnya ini "+resourceSet);
				beModel = (BEModel)resourceSet.getResource(uri, true).getContents().get(0);
			}
			else
			{
				beModel = GraphBTUtil.getBEFactory().createBEModel();
				beModel.setName("BTPackage");
				beModel.setComponentList(GraphBTUtil.getBEFactory().createComponentList());
				beModel.setDbt(GraphBTUtil.getBEFactory().createBehaviorTree());
				beModel.setRequirements(GraphBTUtil.getBEFactory().createRequirementList());
				Resource createResource = resourceSet.createResource(uri);
				//resourceSet.getResources().add(createResource);
				createResource.getContents().add(beModel);
				try {
					createResource.save(Collections.emptyMap());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				createResource.setTrackingModification(true);
			}
		return beModel;*/
		// get model elements from the resource
		//return resource.getContents().size() != 0?(BEModel)resource.getContents().get(0):null; // get(0) might be dangerous. why?
	
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

	public static void saveToModelFile(final EObject obj, final Diagram d) throws CoreException, IOException {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		ResourceSet rSet = d.eResource().getResourceSet();
		System.out.println(uri.toFileString());
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

	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}
	
	public static ResourceSet getResourceSet(final Diagram d) throws CoreException, IOException {

		ResourceSet rSet = d.eResource().getResourceSet();
		
		return rSet;
	}
	
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
	public static Component getComponent(BEModel model, String ref)
	{
		Iterator<Component> it = model.getComponentList().getComponents().iterator();
		while(it.hasNext()){
			Component c = it.next();
	
			if(/*c.getComponentRef().equals(ref)||*/c.getComponentName().equals(ref)) {
				return c;
			}
		}
		return null;
	}
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
	public static boolean createNewComponent(BEModel model, Component com)
	{
		if(getComponent(model, com.getComponentName())!=null)
		{
			model.getComponentList().getComponents().add(com);
			return true;
		}
		return false;
	}
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
}
