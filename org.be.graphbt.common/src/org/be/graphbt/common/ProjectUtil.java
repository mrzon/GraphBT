package org.be.graphbt.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import org.eclipse.graphiti.mm.pictograms.Diagram;

public class ProjectUtil {
	
	public static String RESOURCE_LOCATION = "resource";
	public static URL getFileLocator(String bundleId,String path) {
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
	
	public static IProject getProject(Diagram d) {
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
	public static File getSharedResource(String path) {
		return new File(getFileLocator("org.be.graphbt.common",path).getFile());
	}
	
	/**
	 * Using the parameter, return the resource instance
	 * @param str relative path from the workspace root
	 * @return the resource
	 */
	public static IResource getResource(String str) {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//extract the .bt text
		IResource file = workspaceRoot.findMember(str);
		return file;
				
	}
	
	/**
	 * Copy file from src to target
	 * @param src source file
	 * @param target target file
	 * @throws IOException
	 */
	public static void copy(File src, File target) throws IOException
	{
		if(!target.exists()) {
			target.createNewFile();
		}
	    InputStream inStream = new FileInputStream(src);
	    OutputStream outStream = new FileOutputStream(target);
	    byte[] buffer = new byte[1024];
	    int length;
	    //copy the file content in bytes 
	    while ((length = inStream.read(buffer)) > 0) {
	    	outStream.write(buffer, 0, length);
	    }
	    inStream.close();
	    outStream.close();
	}
}
