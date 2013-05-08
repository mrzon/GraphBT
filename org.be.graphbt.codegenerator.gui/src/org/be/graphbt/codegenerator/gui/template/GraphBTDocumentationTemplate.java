package org.be.graphbt.codegenerator.gui.template;

import org.be.graphbt.model.graphbt.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;

public class GraphBTDocumentationTemplate
{
  protected static String nl;
  public static synchronized GraphBTDocumentationTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphBTDocumentationTemplate result = new GraphBTDocumentationTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "<html>" + NL + "<head>" + NL + "<title> </title>" + NL + "</head>" + NL + "<body>" + NL + "<h1 class=\"title\">Title</h1>" + NL + "<h2 class=\"subtitle\">Subtitle</h2>" + NL + "<h3 class=\"version\">Version</h3>" + NL + "<h3 class=\"label\">Author:</h3>" + NL + "<h3 class=\"label\">Project Description: </h3>" + NL + "<h2 class=\"label\">Table of Contents:</h3>" + NL + "<h2 class=\"label\">Specifications:</h2>";
  protected final String TEXT_3 = NL + "<h3 class=\"label\">Requirements</h3>";
  protected final String TEXT_4 = NL + "<div id=\"requirement";
  protected final String TEXT_5 = "\"><span class=\"requirement id\">";
  protected final String TEXT_6 = "</span> <span class=\"requirement name\">";
  protected final String TEXT_7 = "</span><br/><span class=\"requirement description\">";
  protected final String TEXT_8 = "</span></div>";
  protected final String TEXT_9 = NL + "<h3 class=\"label\">Layouts</h3>" + NL;
  protected final String TEXT_10 = NL + "<h3 class=\"component\">Components</h3>";
  protected final String TEXT_11 = NL + "<div id=\"component";
  protected final String TEXT_12 = "\"><span class=\"component id\">";
  protected final String TEXT_13 = "</span> <span class=\"component name\">";
  protected final String TEXT_14 = "</span><br/><span class=\"component description\">";
  protected final String TEXT_15 = "</span><img class=\"component image\" src=\"\"></div>";
  protected final String TEXT_16 = NL + "<div class=\"attributes\"><h4>Attributes:</h4>";
  protected final String TEXT_17 = NL + "<div id=\"component";
  protected final String TEXT_18 = "-attribute";
  protected final String TEXT_19 = "\"><span class=\"attribute name\">";
  protected final String TEXT_20 = "</span> <span class=\"attribute type\">";
  protected final String TEXT_21 = "</span><br/><span class=\"attribute description\">";
  protected final String TEXT_22 = "</span></div>";
  protected final String TEXT_23 = NL + "</div>";
  protected final String TEXT_24 = NL + "<div class=\"behaviors\"><h4>Behaviors:</h4>";
  protected final String TEXT_25 = NL + "<div id=\"component";
  protected final String TEXT_26 = "-behavior";
  protected final String TEXT_27 = "\"><span class=\"behavior name\">";
  protected final String TEXT_28 = "</span><br/><span class=\"behavior description\">";
  protected final String TEXT_29 = "</span></div>";
  protected final String TEXT_30 = NL + "</div>";
  protected final String TEXT_31 = NL + "<div class=\"states\"><h4>States:</h4>";
  protected final String TEXT_32 = NL + "<div id=\"component";
  protected final String TEXT_33 = "-state";
  protected final String TEXT_34 = "\"><span class=\"state name\">";
  protected final String TEXT_35 = "</span><br/><span class=\"state description\">";
  protected final String TEXT_36 = "</span></div>";
  protected final String TEXT_37 = NL + NL + "</div>";
  protected final String TEXT_38 = NL + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    BEModel model = (BEModel) argument; 
	EList<Layout> layouts = null;
	EList<Component> components = null;
	EList<Requirement> requirements = null;

    stringBuffer.append(TEXT_1);
    if(model.getLayoutList()!=null) {
    layouts = model.getLayoutList().getLayouts(); }
    if(model.getComponentList()!=null) {
    components = model.getComponentList().getComponents(); }
    if(model.getRequirementList()!=null) {
    requirements = model.getRequirementList().getRequirements(); }
    stringBuffer.append(TEXT_2);
    if(requirements != null && requirements.size()>0) {
    stringBuffer.append(TEXT_3);
    for(int i = 0; i < requirements.size(); i++) {
	Requirement r = requirements.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(r.getKey());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(r.getKey());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(r.getRequirement());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(r.getDescription());
    stringBuffer.append(TEXT_8);
    }}
    stringBuffer.append(TEXT_9);
    if(components != null && components.size()>0) {
    stringBuffer.append(TEXT_10);
    for(int i = 0; i < components.size(); i++) {
Component c = components.get(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(c.getComponentRef());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(c.getComponentRef());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(c.getComponentName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(c.getComponentDesc());
    stringBuffer.append(TEXT_15);
    if(c.getAttributes().size() > 0) {
    stringBuffer.append(TEXT_16);
    for(int j = 0; j < c.getAttributes().size(); j++) {
	Attribute a = c.getAttributes().get(j);

    stringBuffer.append(TEXT_17);
    stringBuffer.append(c.getComponentRef());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(a.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(a.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(a.getType());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(a.getDesc());
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    }
    if(c.getBehaviors().size() > 0) {
    stringBuffer.append(TEXT_24);
    for(int j = 0; j < c.getBehaviors().size(); j++) {
	Behavior b = c.getBehaviors().get(j);

    stringBuffer.append(TEXT_25);
    stringBuffer.append(c.getComponentRef());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(b.getBehaviorRef());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(b.toString());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(b.getBehaviorDesc());
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    }
    if(c.getState().size() > 0) {
    stringBuffer.append(TEXT_31);
    for(int j = 0; j < c.getState().size(); j++) {
	State s = c.getState().get(j);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(c.getComponentRef());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(s.getRef());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(s.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(s.getDesc());
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    }
    }}
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
