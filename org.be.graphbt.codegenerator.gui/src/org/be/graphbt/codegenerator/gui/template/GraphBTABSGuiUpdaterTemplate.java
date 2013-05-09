package org.be.graphbt.codegenerator.gui.template;

import org.be.graphbt.model.graphbt.*;
import org.eclipse.emf.common.util.*;;

public class GraphBTABSGuiUpdaterTemplate
{
  protected static String nl;
  public static synchronized GraphBTABSGuiUpdaterTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphBTABSGuiUpdaterTemplate result = new GraphBTABSGuiUpdaterTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL + "package [P];" + NL + "import java.io.*;" + NL + "import java.util.*;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.events.*;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.widgets.*;" + NL + "import abs.backend.java.lib.types.*;" + NL + "import abs.backend.java.lib.runtime.ABSFut;" + NL + "import BTObjects.*;" + NL + "" + NL + "public class GUIUpdaterImpl_fli extends GUIUpdaterImpl_c{" + NL + "\tpublic ABSUnit fli_changeState(Display_i _d, ABSString _c, ABSString _s) {" + NL + "\t\tfinal DisplayImpl_fli d = (DisplayImpl_fli)_d;" + NL + "" + NL + "\t\tif (d.display == null || d.display.isDisposed())" + NL + "\t\t\treturn abs.backend.java.lib.types.ABSUnit.UNIT;" + NL + "" + NL + "\t\tfinal String c = _c.getString();" + NL + "\t\tfinal String s = _s.getString();" + NL + "" + NL + "        d.display.asyncExec(new Runnable() {" + NL + "            public void run() {" + NL + "            try {" + NL + "\t \t\t\tFile file = new File(\"resource/\"+c+\"-\"+s+\".jpg\");" + NL + "\t\t\t\tImage image = new Image(d.display, new FileInputStream(file));" + NL + "\t\t\t\tWidget w = d.widgets.get(c);" + NL + "\t\t\t\tif(w instanceof Button) {" + NL + "\t\t\t\t\t((Button) w).setImage(image);" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse if(w instanceof Label) {" + NL + "\t\t\t\t\t((Label) w).setImage(image);" + NL + "\t\t\t\t}" + NL + "\t\t\t\td.composite.pack();" + NL + "\t\t\t\t} catch (Exception e) { }" + NL + "            }" + NL + "        });" + NL + "" + NL + "        return abs.backend.java.lib.types.ABSUnit.UNIT;" + NL + "\t}" + NL + "}";
  protected final String TEXT_3 = NL + " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
