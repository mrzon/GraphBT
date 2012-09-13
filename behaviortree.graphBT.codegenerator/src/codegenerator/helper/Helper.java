package codegenerator.helper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class Helper {
	public static URL getURL(String path)
	{
		final URL file = FileLocator.find(Platform.getBundle("behaviortree.graphBT.codegenerator"), new Path(path),
				null);
		URL base = Platform.getBundle("behaviortree.graphBT.codegenerator").getEntry(path); 
		
		try {
			URL ul = FileLocator.toFileURL(base);
			
			return ul;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			File f = FileLocator.getBundleFile(Platform.getBundle("behaviortree.graphBT.codegenerator"));
			//System.out.println("Lokasi pluginnya "+f.+file);
			
			URL ul = new URL(f.toURI().getPath()+file.getPath());
			return ul;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return file;
	}
	public static URL getWorkSpaceURL(String path)
	{
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		//workspaceRoot.get
		
		final URL file = FileLocator.find(Platform.getBundle("behaviortree.graphBT.codegenerator"), new Path(path),
				null);
		return file;
	}
}
