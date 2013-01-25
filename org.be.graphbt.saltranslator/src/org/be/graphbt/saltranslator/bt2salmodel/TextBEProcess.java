package org.be.graphbt.saltranslator.bt2salmodel;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Map;

import java.io.File;

/**
 * Class TextBEProcess,
 * parsing metamodel behavior tree and save it to corresponding model class.
 * 
 * @author Niken Listya Pratiwi
 * @date May 20, 2011
 * @modified Ardi
 * 
 */
public class TextBEProcess extends DefaultHandler
{
	/** list of components. ex., {DOOR, OVEN} */
	List<Component> listOfComponents;
	/** map component reference to component value, based hash function ex., <"C1", new Component()>*/
	Map<String, Component> mapOfComponents;
	/** list of highest value of range from program counter pc. ex., [0..h] */
	List<Integer> listForRangePc;
	/** sal variable mapping */
	Map<String, SALVariable> salvarmap;
	
	private Component tempComponent;
	private Behavior tempBehavior;
	private BehaviorTree tempBT;
	private BTNode btnode;
	private BTNode btnparent;
	private Stack<BTNode> stackBTN;
	private int pcNow = 1;
	/** path of textbt file */
	private File uriFile;
	/** path of sal file as output */
	private IFile pathSALFile;
	
	/**
	 * constructor, initialize variables.
	 */	
	public TextBEProcess(File uriFile, IFile pathSALFile) {
		listOfComponents = new ArrayList<Component>();
		stackBTN = new Stack<BTNode>();
		mapOfComponents = new HashMap<String, Component>();
		salvarmap = new HashMap<String, SALVariable>();
		listForRangePc = new ArrayList<Integer>();
		
		this.uriFile = uriFile;
		this.pathSALFile = pathSALFile;
	}
	
	/**
	 * do parsing process and translation bt to sal.
	 * linked methods:
	 * process > parsing > startElement & endElement > translationBT2SAL.  
	 */
	public void process() {
		// parsing metamodel behavior tree in xml
		parsing();
		// remove one component. from metamodel behavior tree in xml, the last component don't be used 
		listOfComponents.remove((listOfComponents.size())-1);
		// translate BT to SAL spesification using BT2SALTranslator
		translationBT2SAL();
	}
	
	/**
	 * parse uriFile, textbt file that represents behavior tree
	 * in xml format.
	 */
	private void parsing() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try
		{
			SAXParser sp = spf.newSAXParser();	
			sp.parse(uriFile, this);
		}
		catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		catch(SAXException saxexception) {
			saxexception.printStackTrace();
		}
		catch(IOException ioexception) {
			ioexception.printStackTrace();
		}	
	}
	
	/**
	 * start element, default handler function to parse the XML. 
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if(qName.equalsIgnoreCase("components")) {
			tempComponent = new Component();
			tempComponent.setComponentReference(attributes.getValue("ref"));
			tempComponent.setComponentVal(attributes.getValue("val"));
		}
		else if(qName.equalsIgnoreCase("behaviors")) {
			tempBehavior = new Behavior();
			tempBehavior.setBehaviorType(attributes.getValue("xsi:type"));
			tempBehavior.setBehaviorRef(attributes.getValue("ref"));
			tempBehavior.setBehaviorVal(attributes.getValue("val"));
		}
		else if(qName.equalsIgnoreCase("behaviorTree")) {
			tempBT = new BehaviorTree();
		}
		else if(qName.equalsIgnoreCase("rootNode") || qName.equalsIgnoreCase("childNode")) {
			btnode = new BTNode();
			btnparent = new BTNode();
			
			btnode.setBtnType(attributes.getValue("xsi:type"));
			btnode.setBtnComponentRef(attributes.getValue("componentRef"));
			btnode.setBtnBehaviorRef(attributes.getValue("behaviorRef"));
			btnode.setBtnTraceStatus(attributes.getValue("traceabilityStatus"));
			btnode.setBtnOperator(attributes.getValue("operator"));
			btnode.setBtnVisited(false);
			
			// get BT node parent
			if(!stackBTN.empty()) {
				btnparent = stackBTN.peek();
			}
			
			// handle pc for non-alternative or non-parallel node
			if( btnode.getBtnType()!=null && (btnode.getBtnType().equalsIgnoreCase("textbt:ParallelBlock") ||
			btnode.getBtnType().equalsIgnoreCase("textbt:AlternativeBlock")) ) {				
			}
			else
			{
				handlePc(btnparent, btnode);
			}
			
			// add node to stack for translation need
			stackBTN.push(btnode);
			// when type is root, set the node as root and then 
			// set pc reference, pc value, and highest value of range from pc.
			if(qName.equalsIgnoreCase("rootNode")) {
				tempBT.btRoot = btnode;
				if(btnode.getBtnType()!=null && btnode.getBtnType().equalsIgnoreCase("textbt:AtomicNode")) {
					btnode.setPc(1);
					btnode.setPcVal(0);
					listForRangePc.add(1);
				}
				else
				{
					btnode.setPc(1);
					btnode.setPcVal(1);
					listForRangePc.add(1);
				}
			}
		}
	}	
	
	/**
	 * end element, default handler function to parse the XML. 
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		if(qName.equalsIgnoreCase("components")) {
			// add component to list and add to map
			listOfComponents.add(tempComponent);
			mapOfComponents.put(tempComponent.getComponentReference(), tempComponent);
		}
		else if(qName.equalsIgnoreCase("behaviors")) {
			// get behavior ref and put based on index
			String index = tempBehavior.getBehaviorRef();
			tempComponent.listBehaviors.put(index, tempBehavior);
		}
		else if(qName.equalsIgnoreCase("rootNode")) {
			// get node from top of stack
			BTNode temp = new BTNode();
			temp = stackBTN.peek();
			// then handle variable or set variable used in SAL syntax 
			handleVar(temp);
		}
		else if(qName.equalsIgnoreCase("childNode")) {
			try
			{
				// get node from uppermost stack
				BTNode temp1 = new BTNode();
				temp1 = stackBTN.pop();
				// get current node from stack
				BTNode temp = new BTNode();
				temp = stackBTN.peek();
				// set child and parent
				temp.getListChild().add(temp1);	
				temp1.setBtnParent(temp);
				
				// mapping to sal variable for temp1
				handleVar(temp1);
			}
			catch(EmptyStackException e) {
			}
		}
	}
	
	/**
	* function to set variable used in SAL syntax
	* @param BTNode child
	*/
	private void handleVar(BTNode child) {
		String cvalue = "";
		String bvalue = "";
		String btype = "";
		
		String salvariable = "";
		String saltype = "";
		String sallocalvar= "";
		
		String tempString = child.getBtnComponentRef(); // get component reference of BT node, ex. C1 
		Component component = mapOfComponents.get(tempString); // get the component based on the reference
		
		if(component!=null && child.getBtnBehaviorRef()!=null) {
			/* get behavior reference from node (C1), then  get its component value (DOOR) and
			 * its behavior value (Open) and behavior type (#S).
			 */
			String behaviorRef = child.getBtnBehaviorRef();
			cvalue = component.getComponentVal();
			bvalue = component.listBehaviors.get(behaviorRef).getBehaviorVal().toLowerCase();
			btype = component.listBehaviors.get(behaviorRef).getBehaviorType();
			
			System.out.println("bvalue: "+bvalue);
			System.out.println("cvalue: "+cvalue);
			
			cvalue = cvalue.replace("-", "_");
			bvalue = bvalue.replace("-", "_");
			
			// handle variable naming for assignment/state realization behavior type
			if(bvalue.contains(":=") || bvalue.contains("=") || bvalue.contains("[")) {
				String[] tempStringArray = new String[2];
				
				// ex., status:=critical
				if(bvalue.contains(":=")) {
					tempStringArray = bvalue.split(":=");
				}
				else if(bvalue.contains("=")) {
					tempStringArray = bvalue.split("=");
				}
				else if(bvalue.contains("[")) {
					tempStringArray = bvalue.split("\\[");
					tempStringArray[1] = tempStringArray[1].replace("]", "");
				}
				
				// salvariable: Consumer_status
				salvariable = cvalue.substring(0,1) + cvalue.substring(1).toLowerCase() + "_" + tempStringArray[0];
				// sallocalvar: consumerStatus
				sallocalvar = cvalue.toLowerCase() + tempStringArray[0].substring(0,1).toUpperCase() + tempStringArray[0].substring(1).toLowerCase();
				// saltype:  consumer_status__critical
				saltype = salvariable.toLowerCase() + "_" + tempStringArray[1];
			}
			else if(btype.equalsIgnoreCase("textbt:InternalInput")) //handle variable naming for internal input behavior type
			{
				salvariable = "internalInput_" + cvalue.substring(0,1) + cvalue.substring(1).toLowerCase() +"_"+ bvalue;
				sallocalvar = salvariable;
				// sallocalvar = "internalInput_" + cvalue.toLowerCase() + bvalue.substring(0,1).toUpperCase() + bvalue.substring(1).toLowerCase();
				saltype = "true";
			}
			else if(btype.equalsIgnoreCase("textbt:InternalOutput")) //handle variable naming for internal output behavior type
			{
				//salvariable = "internalOutput_" + cvalue.substring(0,1) + cvalue.substring(1).toLowerCase() +"_"+ bvalue;
				//sallocalvar = salvariable;
				// sallocalvar = "internalOutput_" + cvalue.toLowerCase() + bvalue.substring(0,1).toUpperCase() + bvalue.substring(1).toLowerCase();
				//saltype = "true";
			}
			//handle variable naming for external input or event behavior type
			else if(btype.equalsIgnoreCase("textbt:ExternalInput") || (btype.equalsIgnoreCase("textbt:Event"))) {
				salvariable = "externalInput_" + cvalue.substring(0,1) + cvalue.substring(1).toLowerCase() +"_"+ bvalue;
				sallocalvar = salvariable;
				// sallocalvar = "externalInput_" + cvalue.toLowerCase() + bvalue.substring(0,1).toUpperCase() + bvalue.substring(1).toLowerCase();
				saltype = "true";
				
			}
			else if(btype.equalsIgnoreCase("textbt:ExternalOutput")) //handle variable naming for external output behavior type
			{
				salvariable = "externalOutput_" + cvalue.substring(0,1) + cvalue.substring(1).toLowerCase() +"_"+ bvalue;
				sallocalvar = salvariable;
				// sallocalvar = "externalOutput_" + cvalue.toLowerCase() + bvalue.substring(0,1).toUpperCase() + bvalue.substring(1).toLowerCase();	
				saltype = "true";
			}
			else
			{
				salvariable = cvalue.substring(0,1) + cvalue.substring(1).toLowerCase();
				sallocalvar = cvalue.toLowerCase();
				saltype = salvariable.toLowerCase() +"_"+ bvalue;
			}
			
			// create SALVariable object and store it in map,
			// salvariable as key
			SALVariable salvar;
			if(!salvarmap.isEmpty() && salvarmap.containsKey(salvariable)) {
				salvar = salvarmap.get(salvariable);
				salvar.addTypeList(saltype);
			}
			else
			{
				if(salvariable.length() != 0) {
					salvar = new SALVariable(salvariable);
					salvar.addTypeList(saltype);
					salvar.setLocalVar(sallocalvar);
					salvarmap.put(salvariable, salvar);
				}
			 }
			
			System.out.println(salvariable + "..." + sallocalvar + "..." + saltype + "\n");
			// set about sal to node
			child.setSalVariable(salvariable);
			child.setSalLocalVar(sallocalvar);
			child.setSalType(saltype);
		}
	}
	
	/**
	 * handle pc for branching.
	 * @param BTNode parent
	 * @param BTNode child
	 */
	private void handlePc(BTNode parent, BTNode child) {
		// NOTE: root node is ignored here because no one case can will be valid. 
		// if parent is alternative or parallel node, increment pc reference and set it to node
		if(parent.getBtnType()!=null && (parent.getBtnType().equalsIgnoreCase("textbt:ParallelBlock") ||
				parent.getBtnType().equalsIgnoreCase("textbt:AlternativeBlock"))) {
			pcNow++;
			child.setPc(pcNow);
			child.setPcVal(1);
			listForRangePc.add(1);
		}
		// this case happens in atomic node and it is root. child duplicates parent's pc reference and pc value 
		else if(parent.getPc()==1 && parent.getPcVal()==1 &&
				child.getBtnType()!=null && 
				child.getBtnType().equalsIgnoreCase("textbt:AtomicNode")) {
			parent.setPcVal(0);
			child.setPc(parent.getPc());
			child.setPcVal(parent.getPcVal());
		}
		// happens in atomic node besides first node
		else if(child.getBtnType()!=null && 
				child.getBtnType().equalsIgnoreCase("textbt:AtomicNode")) {
			child.setPc(parent.getPc());
			child.setPcVal(parent.getPcVal());
		}
		// else for 'normal' node with parent's pc is not equal with 0  
		else if(parent.getPc()!=0) {
			child.setPc(parent.getPc());
			int pcValNow = parent.getPcVal()+1;
			child.setPcVal(pcValNow);
			listForRangePc.set(parent.getPc()-1, pcValNow);
		}
	}	
	
	/**
	 * translate BT to SAL specification and write the result in
	 * path sal file.
	 */
	private void translationBT2SAL() {
		try
		{
			//File salfile = pathSALFile;
//			String[] temp;
//			temp = pathSALFile.split("/");
//			BufferedWriter output = new BufferedWriter(new FileWriter(salfile)); // initialize buffer to write output
			
			String contextName = pathSALFile.getName();
			contextName = contextName.substring(0, contextName.length()-4);
			BT2SALTranslator temporary = new BT2SALTranslator(contextName, listOfComponents, tempBT, mapOfComponents, listForRangePc, salvarmap);
			String helper = temporary.translate();
			InputStream in = new ByteArrayInputStream(helper.getBytes());
			try {
				if (pathSALFile == null || !pathSALFile.exists()) {
					pathSALFile.create(in,false,null);
				}	
				else
				{
					pathSALFile.setContents(in, false, false, null);
				}	
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//pathSalFile.
		}
		catch (Exception e) {
			System.out.println(" caught a " + e.getClass() +
				 "\n with message: " + e.getMessage());
		}
	}
}

/* EXAMPLE OF METAMODEL BEHAVIOR TREE
<?xml version="1.0" encoding="ISO-8859-1"?>
<textbt:TextBT xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:textbt="http://org.be.textbe/textbt">
<requirements>
<requirements ref="R6" val="R6"/>
</requirements>
<components>
<components ref="C1" val="DOOR">
  <behaviors xsi:type="textbt:State" ref="1" val="Open"/>
  <behaviors xsi:type="textbt:State" ref="2" val="Closed"/>
</components>
<components ref="C2" val="USER">
  <behaviors xsi:type="textbt:Event" ref="1" val="Place">
    <relations question="What" componentRef="C3"/>
    <relations question="Where" preposition="in" componentRef="C4"/>
  </behaviors>
  <behaviors xsi:type="textbt:Event" ref="2" val="Close">
    <relations question="What" componentRef="C1"/>
  </behaviors>
</components>
<components ref="C3" val="FOOD"/>
<components ref="C4" val="OVEN">
  <behaviors xsi:type="textbt:State" ref="1" val="Idle"/>
  <behaviors xsi:type="textbt:State" ref="2" val="Cooking"/>
</components>
<components ref="C5" val="LIGHT">
  <behaviors xsi:type="textbt:State" ref="1" val="Off"/>
</components>
</components>
<behaviorTree>
<rootNode componentRef="C1" behaviorRef="1" traceabilityStatus="+">
  <requirementRef>R6</requirementRef>
  <childNode xsi:type="textbt:SequentialNode" componentRef="C2" behaviorRef="1">
    <requirementRef>R6</requirementRef>
    <childNode xsi:type="textbt:SequentialNode" componentRef="C2" behaviorRef="2" traceabilityStatus="+">
      <requirementRef>R6</requirementRef>
      <childNode xsi:type="textbt:SequentialNode" componentRef="C1" behaviorRef="2">
        <requirementRef>R6</requirementRef>
        <childNode xsi:type="textbt:SequentialNode" componentRef="C5" behaviorRef="1">
          <requirementRef>R6</requirementRef>
          <childNode xsi:type="textbt:SequentialNode" componentRef="C4" behaviorRef="1" traceabilityStatus="+">
            <requirementRef>R6</requirementRef>
            <childNode xsi:type="textbt:SequentialNode" componentRef="C4" behaviorRef="2" traceabilityStatus="+">
              <requirementRef>R6</requirementRef>
            </childNode>
          </childNode>
        </childNode>
      </childNode>
    </childNode>
  </childNode>
</rootNode>
</behaviorTree>
</textbt:TextBT>
*/
