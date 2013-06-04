package org.be.graphbt.codegenerator.gui.template;

import org.be.graphbt.model.graphbt.*;
import org.eclipse.emf.common.util.*;
import org.be.graphbt.common.*;

public class GraphBTABSGuiViewerTemplate
{
  protected static String nl;
  public static synchronized GraphBTABSGuiViewerTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphBTABSGuiViewerTemplate result = new GraphBTABSGuiViewerTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "package [P];" + NL + "import java.io.*;" + NL + "import java.util.*;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.events.*;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.widgets.*;" + NL + "import abs.backend.java.lib.types.*;" + NL + "import abs.backend.java.lib.runtime.ABSFut;" + NL + "import BTObjects.*;" + NL + "" + NL + "public class GUIViewerImpl_fli extends GUIViewerImpl_c {" + NL + " \tpublic ABSUnit fli_show(Display_i _d) {" + NL + " \ttry {" + NL + "\t\tfinal DisplayImpl_fli d = (DisplayImpl_fli)_d;" + NL + "\t\td.display = new Display();" + NL + "\t\td.shell = new Shell(d.display);" + NL + "\t\td.composite = new Composite(d.shell, SWT.NULL);" + NL + "\t\td.shell.setText(\"GUI\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\tFile file";
  protected final String TEXT_7 = " = new File(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\tImage image";
  protected final String TEXT_9 = " = new Image(d.display, new FileInputStream(file";
  protected final String TEXT_10 = "));" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\tfinal Button button";
  protected final String TEXT_12 = " = new Button(d.composite, SWT.NULL);" + NL + "\t\td.widgets.put(\"";
  protected final String TEXT_13 = "\",button";
  protected final String TEXT_14 = ");" + NL + "\t\tbutton";
  protected final String TEXT_15 = ".setImage(image";
  protected final String TEXT_16 = ");" + NL + "\t\tbutton";
  protected final String TEXT_17 = ".setBounds(image";
  protected final String TEXT_18 = ".getBounds());\t" + NL + "\t   \tbutton";
  protected final String TEXT_19 = ".setLocation(";
  protected final String TEXT_20 = ",";
  protected final String TEXT_21 = ");" + NL + "\t   \tbutton";
  protected final String TEXT_22 = ".addSelectionListener(new SelectionAdapter() {" + NL + "\t\t\tpublic void widgetSelected(SelectionEvent event) {" + NL + "\t\t\t\tABSFut<Component_i> f = d.async_getComponent(abs.backend.java.lib.types.ABSString.fromString(\"";
  protected final String TEXT_23 = "\"));" + NL + "\t\t\t\tf.await();" + NL + "\t\t\t\tComponent_i component = f.getValue();" + NL + "\t\t\t\tif(component!=null) {" + NL + "\t\t\t\t\tABSFut<ABSUnit> u = component.async_click();" + NL + "\t\t\t\t\tu.await();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tbutton";
  protected final String TEXT_24 = ".addMouseListener(new MouseAdapter() {" + NL + "\t\t\tpublic void mouseDown(org.eclipse.swt.events.MouseEvent arg0){" + NL + "\t\t\t\tABSFut<Component_i> f = d.async_getComponent(abs.backend.java.lib.types.ABSString.fromString(\"";
  protected final String TEXT_25 = "\"));" + NL + "\t\t\t\tf.await();" + NL + "\t\t\t\tComponent_i component = null;" + NL + "\t\t\t\tcomponent = f.getValue();" + NL + "\t\t\t\tif(component!=null) {" + NL + "\t\t\t\t\tABSFut<ABSUnit> u = component.async_press();" + NL + "\t\t\t\t\tu.await();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t  " + NL + "\t\t    public void mouseUp(org.eclipse.swt.events.MouseEvent arg0){" + NL + "\t\t\t\tABSFut<Component_i> f = d.async_getComponent(abs.backend.java.lib.types.ABSString.fromString(\"";
  protected final String TEXT_26 = "\"));" + NL + "\t\t\t\tf.await();" + NL + "\t\t\t\tComponent_i component = null;" + NL + "\t\t\t\tcomponent = f.getValue();" + NL + "\t\t\t\tif(component!=null) {" + NL + "\t\t\t\t\tABSFut<ABSUnit> u = component.async_release();" + NL + "\t\t\t\t\tu.await();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\tfinal Label label";
  protected final String TEXT_28 = " = new Label(d.composite, SWT.NULL);" + NL + "\t\td.widgets.put(\"";
  protected final String TEXT_29 = "\",label";
  protected final String TEXT_30 = ");\t" + NL + "\t\tlabel";
  protected final String TEXT_31 = ".setImage(image";
  protected final String TEXT_32 = ");" + NL + "\t\tlabel";
  protected final String TEXT_33 = ".setBounds(image";
  protected final String TEXT_34 = ".getBounds());\t" + NL + "\t   \tlabel";
  protected final String TEXT_35 = ".setLocation(";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ");\t" + NL + "\t   \t";
  protected final String TEXT_38 = NL + "\t\td.composite.pack();" + NL + "\t\td.shell.open();" + NL + "\t\twhile(!d.shell.isDisposed()) {" + NL + "\t\t\tif(!d.display.readAndDispatch()) {" + NL + "\t\t\t\td.display.sleep();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + " \t\td.display.dispose();" + NL + " \t} catch (Exception e) {" + NL + " \t}" + NL + "\t\t" + NL + "\t \treturn ABSUnit.UNIT;" + NL + " \t}" + NL + " }" + NL;
  protected final String TEXT_39 = NL + " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    BEModel model = (BEModel) argument; 
    if(model.getLayoutList()==null) return null;
    stringBuffer.append(TEXT_2);
    EList<Layout> layouts = model.getLayoutList().getLayouts(); 
    stringBuffer.append(TEXT_3);
    for (int i = layouts.size()-1; i >= 0 ; i--) { 
    stringBuffer.append(TEXT_4);
    Layout l = layouts.get(i);
    stringBuffer.append(TEXT_5);
    String path = ProjectUtil.getImageAbsolutePath(ProjectUtil.RESOURCE_LOCATION+"/"+l.getCRef());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_10);
    if(l.getCRef().startsWith("CBUTTON")) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(l.getX());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(l.getY());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(l.getX());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(l.getY());
    stringBuffer.append(TEXT_37);
    }}
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
