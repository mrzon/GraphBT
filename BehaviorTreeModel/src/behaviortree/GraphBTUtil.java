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
	import org.eclipse.emf.common.util.EList;
	import org.eclipse.emf.common.util.URI;
	import org.eclipse.emf.common.util.WrappedException;
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.resource.Resource;
	import org.eclipse.emf.ecore.resource.ResourceSet;
	import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
	import org.eclipse.graphiti.mm.pictograms.Diagram;


	public class GraphBTUtil {

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
			final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
			if (file == null || !file.exists()) {
				Resource createResource = rSet.createResource(uri);
				createResource.save(Collections.emptyMap());
				createResource.setTrackingModification(true);
			}
			final Resource resource = rSet.getResource(uri, true);
			resource.getContents().add(obj);
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
						if (file.getName().endsWith(".diagram")) { //$NON-NLS-1$
							ret.add(file);
						}
					}
				}
			} catch (final CoreException e) {
				e.printStackTrace();
			}
			return ret;
		}

		private static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
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
			URI uri = d.eResource().getURI();
			uri = uri.trimFragment();
			uri = uri.trimFileExtension();
			uri = uri.appendFileExtension("model"); //$NON-NLS-1$
			ResourceSet rSet = d.eResource().getResourceSet();

			return rSet;
		}
		
		public static boolean isExist(ResourceSet rs, URI uri)
		{
			Iterator<Resource> it = rs.getResources().iterator();
			while(it.hasNext()){
				Resource res = it.next();
				
				if(res.getURI().equals(uri)){
					return true;
				}
			}
			return false;
		}
		
		public static Component getComponentByURI(ResourceSet rs, URI uri)
		{
			Iterator<Resource> it = rs.getResources().iterator();
			while(it.hasNext()){
				Resource res = it.next();
		
				if(res.getURI().equals(uri)) {
					return (Component)res.getContents().get(0);
				}
			}
			return null;
		}

		public static Behavior getBehaviorFromComponent(Component component,
				String value) {
			Iterator<Behavior> it = component.getBehaviors().iterator();
			while(it.hasNext()){
				Behavior b = it.next();
		
				if(b.getBehaviorName().equals(value)) {
					return b;
				}
			}
			return null;
		}
		
		public static Requirements getRequirements(ResourceSet rs,
				String value) {
			Iterator<Resource> it = rs.getResources().iterator();
			while(it.hasNext()){
				Resource res = it.next();
		
				if(res.getURI().equals(value)) {
					return (Requirements) res.getContents().get(0);
				}
			}
			return null;
		}

	}

