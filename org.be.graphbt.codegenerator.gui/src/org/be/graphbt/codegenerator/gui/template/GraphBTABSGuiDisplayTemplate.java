package org.be.graphbt.codegenerator.gui.template;

import org.be.graphbt.model.graphbt.*;
import org.eclipse.emf.common.util.*;;

public class GraphBTABSGuiDisplayTemplate
{
  protected static String nl;
  public static synchronized GraphBTABSGuiDisplayTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphBTABSGuiDisplayTemplate result = new GraphBTABSGuiDisplayTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL + NL + "package [P];" + NL + "import java.io.*;" + NL + "import java.util.*;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.events.*;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.widgets.*;" + NL + "import abs.backend.java.lib.types.*;" + NL + "import abs.backend.java.lib.runtime.ABSFut;" + NL + "import BTObjects.*;" + NL + "" + NL + "public class DisplayImpl_fli extends DisplayImpl_c{" + NL + "\tpublic Display display;" + NL + "\tpublic Shell shell;" + NL + "\tpublic Composite composite;" + NL + "\tpublic HashMap<String, Widget> widgets = new HashMap<String, Widget>();" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
