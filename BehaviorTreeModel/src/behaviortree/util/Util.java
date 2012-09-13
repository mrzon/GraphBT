package behaviortree.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class Util {
	/**
	 * read file from system environment.
	 * 
	 * @param systemPath
	 * @param fileName
	 * @return
	 */
	public static String readFileSystemEnv(String systemPath, String fileName) {
		StringBuffer res = new StringBuffer();

		try {
			// open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream(systemPath + "\\"
					+ fileName);
			// get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// print the content on the console
				res.append(strLine + "\n");
			}
			// close the input stream
			in.close();
		} catch (Exception e) {
			System.err.println("Error [Util.java]: " + e.getMessage());
		}

		return res.toString();
	}

	/**
	 * write file to system environment.
	 * 
	 * @param systemPath
	 * @param fileName
	 * @param content
	 */
	public static void writeFileSystemEnv(String systemPath, String fileName, String content) {
		try {
			// create file
			FileWriter fstream = new FileWriter(systemPath
					+ "\\" + fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(content);
			// close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error [Util.java]: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param d
	 * @param extension
	 * @param content
	 */
	public static void writeFileToWorkspace(Diagram d, String extension,
			String content) {
		// set uri file
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension(extension);

		// WRITE TO FILE
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();

		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		{
			Path path = new Path(uri.toPlatformString(true));
			IFile btIFile = workspaceRoot.getFile(path);

			// Log.d(path.toString());
			InputStream in = new ByteArrayInputStream(content.getBytes());
			try {
				if (file == null || !file.exists()) {
					btIFile.create(in, false, null);
				} else {
					btIFile.setContents(in, false, false, null);
				}
			} catch (CoreException e) {
				System.err.println("Error [Util.java]: " + e.getMessage());
			}
		}
	}

}
