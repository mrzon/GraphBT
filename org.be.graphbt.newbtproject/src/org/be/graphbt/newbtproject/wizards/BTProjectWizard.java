package org.be.graphbt.newbtproject.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;


import org.be.graphbt.common.ProjectUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class BTProjectWizard extends Wizard implements INewWizard {

	BTProjectWizardPage page;
	public BTProjectWizard() {
		// TODO Auto-generated constructor stub
		super();
		page=new BTProjectWizardPage();
	}

	public void addPages()
	{
		this.addPage(page);
	}
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		//final Collection<ProjectDescriptor> projectDescriptors = getProjectDescriptors();
		//final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//;
	
		final String fileName = page.getFileName();
		
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(fileName);

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					
					project.create(monitor);
					project.open(monitor);
					IProjectDescription desc = project.getDescription();
				    String[] prevNatures = desc.getNatureIds();
				    String[] newNatures = new String[prevNatures.length + 1];
				    System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
				    newNatures[prevNatures.length] = "org.eclipse.jdt.core.javanature";
				    desc.setNatureIds(newNatures);
				    project.setDescription(desc, new NullProgressMonitor());
					System.out.println("Nature id"+Arrays.toString(project.getDescription().getNatureIds()));
					
					//project.getDescription().setBuildConfigs(builders);
					project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					
					IFolder src = project.getFolder("src");
					IFolder rbt = project.getFolder("rbt");
					IFolder resource = project.getFolder(ProjectUtil.RESOURCE_LOCATION);
					
					IFile btdiagram = project.getFile(fileName+".btdiagram");
					//IFile btlayout = project.getFile("resource/"+fileName+".btlayout");
					IFile bt = project.getFile(fileName+".bt");
					bt.create(new ByteArrayInputStream("".getBytes()), true, monitor);
					String contents ="<?xml version=\"1.0\" encoding=\"ASCII\"?>\n"+
							"<pi:Diagram xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:al=\"http://eclipse.org/graphiti/mm/algorithms\" xmlns:pi=\"http://eclipse.org/graphiti/mm/pictograms\" visible=\"true\" gridUnit=\"10\" diagramTypeId=\"graphbt\" name=\""+fileName+"\" snapToGrid=\"true\" version=\"0.9.0\">\n" +
							  "<graphicsAlgorithm xsi:type=\"al:Rectangle\" background=\"//@colors.1\" foreground=\"//@colors.0\" lineWidth=\"1\" transparency=\"0.0\" width=\"1000\" height=\"1000\"/>"+
							  "<colors red=\"227\" green=\"238\" blue=\"249\"/>"+
							  "<colors red=\"255\" green=\"255\" blue=\"255\"/>"+
							"</pi:Diagram>";
					btdiagram.create(new ByteArrayInputStream(contents.getBytes()), true, monitor);
					IJavaProject javaProject = JavaCore.create(project);
					IClasspathEntry[] newClasspath = new IClasspathEntry[4];
					newClasspath[0] = JavaCore.newSourceEntry(src.getFullPath());
					newClasspath[1] = JavaCore.newLibraryEntry(
						    new Path(ProjectUtil.getSharedResource("files/lib/swt.jar").getAbsolutePath()), // library location
						    null, //source archive location
						    src.getFullPath(), //source archive root path
						    true); //exported
					newClasspath[2] = JavaCore.newLibraryEntry(
						    new Path(ProjectUtil.getSharedResource("files/lib/absfrontend.jar").getAbsolutePath()), // library location
						    null, //source archive location
						    src.getFullPath(), //source archive root path
						    true); //exported
					newClasspath[3] = JavaRuntime.getDefaultJREContainerEntry();
					javaProject.setRawClasspath(newClasspath, monitor);
					javaProject.setOutputLocation(src.getFullPath(), monitor);
					src.create(true, true, monitor);
					resource.create(true, true, monitor);
					//btlayout.create(new ByteArrayInputStream(contents2.getBytes()), true, monitor);
					rbt.create(true, true, monitor);
					
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
}
