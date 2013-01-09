package behaviortree.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import org.eclipse.graphiti.mm.pictograms.Diagram;

public class ProjectInformation {
	public static URL getFileLocator(String bundleId,String path)
	{
		final URL file = FileLocator.find(Platform.getBundle(bundleId), new Path(path),
				null);
		URL base = Platform.getBundle(bundleId).getEntry(path); 
		
		try {
			URL ul = FileLocator.toFileURL(base);
			
			return ul;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			File f = FileLocator.getBundleFile(Platform.getBundle(bundleId));
			//System.out.println("Lokasi pluginnya "+f.+file);
			
			URL ul = new URL(f.toURI().getPath()+file.getPath());
			return ul;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return file;
	}
	
	public static IProject getProject(Diagram d)
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String homeDrivePath = root.getRawLocation().toOSString();
		String project =  d.eResource().getURI().toPlatformString(true);
		
		IResource res = root.findMember(project);
		if(res==null)
			return null;
		return res.getProject();
	}
	
	/**
	 * get file that exists in the shared folder by giving the related path
	 * @param path the path relative to the shared resource
	 * @return
	 */
	public static String getSharedResource(String path)
	{
		return getFileLocator("behaviortree.graphBT.common",path).getFile();
	}
	
	/**
	 * Using the parameter, return the resource instance
	 * @param str relative path from the workspace root
	 * @return the resource
	 */
	public static IResource getResource(String str)
	{
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//extract the .bt text
		IResource file = workspaceRoot.findMember(str);
		return file;
				
	}
}
