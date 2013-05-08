package org.be.graphbt.codegenerator.gui.template;

import org.be.graphbt.model.graphbt.*;
import org.eclipse.emf.common.util.*;;

public class GraphBTABSGuiTemplate
{
  protected static String nl;
  public static synchronized GraphBTABSGuiTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphBTABSGuiTemplate result = new GraphBTABSGuiTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "package [P];" + NL + "import java.io.*;" + NL + "import java.util.*;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.events.*;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.widgets.*;" + NL + "import abs.backend.java.lib.types.*;" + NL + "import BTObjects.*;" + NL + "" + NL + "import [P].GUIImpl_c;" + NL + "" + NL + "public class GUIImpl_fli extends GUIImpl_c {" + NL + "\tprivate Display display;" + NL + "\tprivate Shell shell;" + NL + "\tprivate Composite comp;" + NL + "\tObject locker = new Object();" + NL + "\tString cId;" + NL + "\tString sName;" + NL + "\t" + NL + "\tprivate HashMap<String, Control> widgets = new HashMap<String, Control>();" + NL + " \tpublic synchronized ABSUnit fli_show() {" + NL + "\t\tRunnable run = new Runnable() {" + NL + "\t\t\t@Override" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t \tinitialize();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tThread t = new Thread(run);" + NL + "\t\tt.start();" + NL + "\t\tfli_loop();" + NL + "\t \treturn ABSUnit.UNIT;" + NL + " \t} " + NL + "" + NL + "\tpublic void call(String cId) {" + NL + "\t\t//System.out.println(\"current thread in method call \"+currentThread.getName());" + NL + "\t\tif(cId==null)" + NL + "\t\t\treturn;" + NL + "\t\tComponent_i component = GUIImpl_fli.this.getComponent(abs.backend.java.lib.types.ABSString.fromString(cId));" + NL + "\t\tcomponent.async_click();" + NL + "\t\tlocker = null;" + NL + "\t}" + NL + "\tpublic synchronized ABSUnit fli_loop() {" + NL + "\t\tlocker = new Object();" + NL + "\t\twhile(true) {" + NL + "\t\t    // call action to start N threads" + NL + "\t\t\tif(locker==null)" + NL + "\t\t    \tbreak;" + NL + "\t\t    synchronized(locker) {" + NL + "\t\t    \tcall(cId);" + NL + "\t\t    }" + NL + "\t\t}" + NL + "\t \treturn ABSUnit.UNIT;" + NL + "\t}" + NL + "\t" + NL + " \tpublic void initialize(){" + NL + " \ttry {" + NL + "\t\tthis.display = new Display();" + NL + "\t\tthis.shell = new Shell(display);" + NL + "\t\tcomp = new Composite(shell, SWT.NULL);" + NL + "\t\tshell.setText(\"GUI\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\tFile file";
  protected final String TEXT_6 = " = new File(\"resource/";
  protected final String TEXT_7 = ".jpg\");" + NL + "\t\tImage image";
  protected final String TEXT_8 = " = new Image(display, new FileInputStream(file";
  protected final String TEXT_9 = "));" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\tfinal Button button";
  protected final String TEXT_11 = " = new Button(comp, SWT.NULL);" + NL + "\t\twidgets.put(\"";
  protected final String TEXT_12 = "\",button";
  protected final String TEXT_13 = ");" + NL + "\t\tbutton";
  protected final String TEXT_14 = ".setImage(image";
  protected final String TEXT_15 = ");" + NL + "\t\tbutton";
  protected final String TEXT_16 = ".setBounds(image";
  protected final String TEXT_17 = ".getBounds());\t" + NL + "\t   \tbutton";
  protected final String TEXT_18 = ".setLocation(";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ");" + NL + "\t   \tbutton";
  protected final String TEXT_21 = ".addSelectionListener(new SelectionAdapter() {" + NL + "\t\t\tpublic void widgetSelected(SelectionEvent event) {" + NL + "\t\t\t\tSystem.out.println(\"Clicked\");" + NL + "\t\t\t\tsynchronized(locker) {" + NL + "\t\t\t\t\tcId = \"";
  protected final String TEXT_22 = "\";" + NL + "\t\t\t\t\tlocker.notify();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\tfinal Label label";
  protected final String TEXT_24 = " = new Label(comp, SWT.NULL);" + NL + "\t\twidgets.put(\"";
  protected final String TEXT_25 = "\",label";
  protected final String TEXT_26 = ");\t" + NL + "\t\tlabel";
  protected final String TEXT_27 = ".setImage(image";
  protected final String TEXT_28 = ");" + NL + "\t\tlabel";
  protected final String TEXT_29 = ".setBounds(image";
  protected final String TEXT_30 = ".getBounds());\t" + NL + "\t   \tlabel";
  protected final String TEXT_31 = ".setLocation(";
  protected final String TEXT_32 = ",";
  protected final String TEXT_33 = ");\t" + NL + "\t   \t";
  protected final String TEXT_34 = NL + "\t\tcomp.pack();" + NL + "\t\tshell.open();" + NL + "\t\twhile(!shell.isDisposed()) {" + NL + "\t\t\tif(!display.readAndDispatch()) {" + NL + "\t\t\t\tdisplay.sleep();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + " \t\tdisplay.dispose();" + NL + " \t} catch (Exception e) {" + NL + " \t}" + NL + " \t\t" + NL + " \t}" + NL + " \t" + NL + "  \tpublic ABSUnit fli_dispose() {" + NL + " \t\tdisplay.dispose();" + NL + " \t\treturn abs.backend.java.lib.types.ABSUnit.UNIT;" + NL + " \t}" + NL + " \t" + NL + " \tpublic synchronized  ABSUnit fli_setState(ABSString componentName, ABSString stateName) {" + NL + " \tSystem.out.println(\"In set state\");" + NL + " \t\t\tif (display == null || display.isDisposed()) " + NL + "            return abs.backend.java.lib.types.ABSUnit.UNIT;" + NL + "        \tfinal String c = componentName.getString();" + NL + " \t\t\tfinal String s = stateName.getString();" + NL + " \t\t\t" + NL + "\t        display.asyncExec(new Runnable() {" + NL + "\t            public void run() {" + NL + "\t            try {" + NL + "\t\t \t\t\tFile file = new File(\"resource/\"+c+\"-\"+s+\".jpg\");" + NL + "\t\t\t\t\tImage image = new Image(display, new FileInputStream(file));" + NL + "\t\t\t\t\tControl w = widgets.get(c);" + NL + "\t\t\t\t\tif(w instanceof Button) {" + NL + "\t\t\t\t\t\t((Button) w).setImage(image);\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse if(w instanceof Label) {" + NL + "\t\t\t\t\t\t((Label) w).setImage(image);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcomp.pack();" + NL + "\t\t\t\t\t} catch (Exception e) { }\t                " + NL + "\t            }" + NL + "\t        });" + NL + "\t\t" + NL + " \t\treturn abs.backend.java.lib.types.ABSUnit.UNIT;" + NL + " \t}" + NL + " }";

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
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_9);
    if(l.getCRef().startsWith("CBUTTON")) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(l.getCRef());
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
    stringBuffer.append(l.getX());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(l.getY());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(l.getCRef());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(l.getX());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(l.getY());
    stringBuffer.append(TEXT_33);
    }}
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
