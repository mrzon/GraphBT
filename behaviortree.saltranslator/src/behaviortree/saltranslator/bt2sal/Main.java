package behaviortree.saltranslator.bt2sal;

import java.io.File;
import org.eclipse.core.resources.IFile;
/**
* Class Main, 
* processing metamodel behavior tree to SAL file.
* 
* @date May 21, 2011
* @author Niken Listya Pratiwi
* @modified Ardi
*  
*/
public class Main
{
	/**
	 * main method, program executed first here.
	 * example:
	 * uriFile: "E:/Dropbox/Behavior Tree Research/Bt to Sal Translator/tempbt2sal_r6.textbt"
	 * pathSALFile: "E:/Dropbox/Behavior Tree Research/Bt to Sal Translator/newhome.sal"
	 */
	public static void run(File textbt, IFile sal)
	{
		// File input;
		try
		{
			
			TextBEProcess tb = new TextBEProcess(textbt, 
					sal);
			tb.process();
			
		}
		catch (Exception e)
        {
			e.printStackTrace();
		}

	}
}