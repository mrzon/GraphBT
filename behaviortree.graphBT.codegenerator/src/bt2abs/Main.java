/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

import java.io.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Emerson
 */
public class Main {
    public static void main (String argv [])
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// Set up output stream
			Writer  out = new OutputStreamWriter (System.out, "UTF8");
			BufferedReader  in = new BufferedReader(new InputStreamReader (System.in, "UTF8"));
                        String path,modName="";
                        boolean trace = false;
                        if(argv.length <= 1)
                        {
                            path = in.readLine();
                            if(path.length()==0)
                            {
                                path = "IBT.xml";
                            }
                            modName = in.readLine();
                            if(argv.length != 0 && argv[0].equals("-t"))
                            {
                                trace = true;
                            }
                        }
                        else if(argv.length >= 2)
                        {
                            path = argv[0];
                            modName = argv[1];
                            if(argv.length > 2 && argv[2].equals("-t"))
                            {
                                trace = true;
                            }
                        }
                        else 
                        {
                            throw new Exception();
                        }
                        /* name of the module should start with capital letter */
                        modName = modName.substring(0,1).toUpperCase()+modName.substring(1,modName.length());
                        
			// Parse the input
			SAXParser saxParser = factory.newSAXParser();
                        BTParser bp = new BTParser(modName,trace);
			saxParser.parse( new File(path), bp);
                        
                        //bp.endDocument();

		} catch (Exception t) {
                    t.printStackTrace();
                    System.out.println("How to use:\njava -jar BT2ABS.jar <xml file> <module> [option]\noption:\n-t : to trace the execution");
		}
		System.exit (0);
	}
}
