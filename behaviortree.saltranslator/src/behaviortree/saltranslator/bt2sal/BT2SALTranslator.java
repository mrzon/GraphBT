package behaviortree.saltranslator.bt2sal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/**
 * Class BT2SALTranslator
 * 
 * @date May 21, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 *  
 */
public class BT2SALTranslator
{
	private String title;
	// list of components
	private List <Component> listOfComponents;
	// component mapping
	private Map<String, Component> componentmap;
	// it is our behavior tree B)
	private BehaviorTree bt;
	// list of program counter
	List<Integer> listPc = new ArrayList<Integer>();
	// list of local variable for INITIALIZATION
	private List<String> listOfLocalVarMsg = new ArrayList<String>();
	// sal variable mapping
	Map<String, SALVariable> salVarMap; 
	// translation rules
	TranslationRules translationRules;
	
	// hold result of translation here
	private StringBuffer temp = new StringBuffer();	
	
	/**
	 * constructor. needed some parameters.
	 * @param title
	 * @param listComponent, list of components.
	 * @param bt, behavior tree.
	 * @param map
	 * @param listPc
	 * @param salvarmap
	 */
	public BT2SALTranslator(String title, List <Component> componentList, BehaviorTree bt, 
			Map <String, Component> map, List<Integer> listPc, Map<String, SALVariable> salvarmap)
	{
		this.title = "mysal";
		this.listOfComponents = componentList;
		this.bt = bt;
		this.componentmap = map;
		this.listPc = listPc;
		this.salVarMap = salvarmap;
		
		translationRules = new TranslationRules();
	}
	
	/**
	 * it is main method for this class for translation need.
	 * @return translation result.
	 */
	public String translate()
	{		
		StringBuffer res = new StringBuffer();
		// name CONTEXT
		res.append(title+ ":" + "CONTEXT=");
		res.append("\n");
		res.append("BEGIN");
		res.append("\n");
		
		// global variables declaration		
		res.append(
				handleGlobalVariable(listOfComponents)
				);
		// start module
		res.append(
				handleModule()
				);
		
		res.append("\n");
		res.append("END"); //end of context
		
		return res.toString();
	}
	
	/**
	 * handle global variable of sal. 
	 * definition of global variable for SAL variable object
	 * is in toString() method.
	 * 
	 * @param componentList, list of components
	 * @return global variables.
	 */
	@SuppressWarnings("unchecked")
	private String handleGlobalVariable(List<Component> componentList)
	{
		StringBuffer res = new StringBuffer();
		// iterate a wrapper (sal variable name, sal variable object)
		Iterator iterator = salVarMap.entrySet().iterator();
		String key;
		while (iterator.hasNext()) 
		{
			Map.Entry me = (Map.Entry<String, SALVariable>) iterator.next();
			key = (String) me.getKey();
			// if key does'nt contains internal/external input/output, 
			// append sal variable to temp
			if(!(key.contains("internalInput") || key.contains("externalInput") 
					|| key.contains("internalOutput") || key.contains("externalOutput")))
			{
				// add toString() of SAL variable object
				res.append(me.getValue());
			}
		}
		return res.toString();
	}
	
	/**
	 * handle main module in sal specification.
	 * @return module result.
	 */
	private String handleModule()
	{
		StringBuffer res = new StringBuffer();
		
		res.append("\nbehavior:MODULE=\n");
		res.append("BEGIN");
		res.append("\n");
		// input
		res.append(
				handleInput()
				);
		// output
		res.append(
				handleOutput()
				);
		res.append("\n");
		// local variables declaration
		res.append(
				handleLocalVariable()
				);
		res.append("\n");
		// initialization
		res.append(
				handleInitialization()
				);
		res.append("\n");
		// transition
		res.append(
			handleTransition()
			);
		
		res.append("]");
		res.append("\n");
		res.append("END; %end of module"); //end of module
		
		return res.toString();
	}
	
	/**
	 * handle input variable. just happens for EXTERNALIINPUT type.
	 * @return input result.
	 */
	@SuppressWarnings("unchecked")
	private String handleInput()
	{
		StringBuffer res = new StringBuffer();
		// iterate a wrapper (sal variable name, sal variable object)
		Iterator iterator = salVarMap.entrySet().iterator();
		// for formatting need
		boolean isFirst = true; 
		StringBuffer tempHandleInput = new StringBuffer();
		
		while(iterator.hasNext()) {
			// get wrapper, then get the key and its value
			Map.Entry<String, SALVariable> me = (Map.Entry<String, SALVariable>) iterator.next();
			String key = me.getKey();
			SALVariable salVar = (SALVariable) me.getValue();
			if(key.contains("externalInput")) {
				if(isFirst) {
					tempHandleInput.append(salVar.getLocalVar() + ": BOOLEAN");
					isFirst = false;
				}
				else {
					tempHandleInput.append(",");
					tempHandleInput.append("\n");
					tempHandleInput.append(salVar.getLocalVar() + ": BOOLEAN");
				}
			}
		}
		
		if(tempHandleInput.length() != 0) {
			res.append("INPUT");
			res.append("\n");
			res.append(tempHandleInput);
			res.append("\n");
		}
		
		return res.toString();
	}
	
	/**
	 * handle output variable. just happens for EXTERNALIOUTPUT type.
	 * @return output result
	 */
	private String handleOutput() {
		StringBuffer res = new StringBuffer();
		// iterate a wrapper (sal variable name, sal variable object)
		Iterator iterator = salVarMap.entrySet().iterator();
		// for formatting need
		boolean isFirst = true;
		StringBuffer tempHandleOutput = new StringBuffer();
		
		while(iterator.hasNext()) {
			// get wrapper, then get the key and its value.
			Map.Entry<String, SALVariable> me = (Map.Entry<String, SALVariable>) iterator.next();
			String key = me.getKey();
			SALVariable salVar = (SALVariable) me.getValue();
			if(key.contains("externalOutput")) {
				if(isFirst) {
					tempHandleOutput.append(salVar.getLocalVar() + ": BOOLEAN");
					isFirst = false;
				}
				else {
					tempHandleOutput.append(",");
					tempHandleOutput.append("\n");
					tempHandleOutput.append(salVar.getLocalVar() + ": BOOLEAN");
				}
				
				listOfLocalVarMsg.add(salVar.getLocalVar());
			}
		}
		if(tempHandleOutput.length() != 0)
		{
			res.append("\n");
			res.append("OUTPUT");
			res.append("\n");
			res.append(tempHandleOutput);
			res.append("\n");
		}
		
		return res.toString();
	}
	
	/**
	 * handle declaration of local variable, sal local variable + program counter (pc).
	 * no EXTERNALINPUT and EXTERNALOUTPUT declaration here.
	 * @return local variable result.
	 */
	@SuppressWarnings("unchecked")
	private String handleLocalVariable()
	{
		StringBuffer res = new StringBuffer();
		res.append("LOCAL");
		res.append("\n");
		// iterate a wrapper (sal variable name, sal variable object)
		Iterator iterator = salVarMap.entrySet().iterator();
		
		while(iterator.hasNext()) 
		{
			Map.Entry me = (Map.Entry<String, SALVariable>) iterator.next();
			String key = (String) me.getKey();
			SALVariable salVar = (SALVariable) me.getValue();
			// here is definition of common variable:
			// there is no internal/external input/output
			if(!(key.contains("internalInput") || key.contains("externalInput") 
					|| key.contains("internalOutput") || key.contains("externalOutput")))
			{
				res.append(salVar.getLocalVar() + ": " + key);
				res.append(",");
				res.append("\n");
			}
			// just for internalInput and internalOutput. 
			// there are no externalInput and externalOutput because it has 
			// been handled in appropriate method
			else if(key.contains("internalInput") || key.contains("internalOutput"))
			{
				res.append(salVar.getLocalVar() + ": BOOLEAN");
				res.append(",");
				res.append("\n");
				// add local variable to list
				listOfLocalVarMsg.add(salVar.getLocalVar());
			}
		}
		
		// initialize program counter pc
		for(int i=0; i<listPc.size(); i++) {
			res.append("pc" + (i+1) + ": [" + 0 + ".." + (listPc.get(i)+1) + "]");
			// if position is not in the end, add comma (,)
			if(i < (listPc.size()-1)) {
				res.append(",");
			}
			res.append("\n");
		}
		
		return res.toString();
	}
	
	/**
	 * handle initialization of local variable and program counter (pc).
	 * @return initialization result.
	 */
	private String handleInitialization() {
		StringBuffer res = new StringBuffer();
		
		res.append("INITIALIZATION");
		res.append("\n");
		
		// pc1 is always 1 :)
		res.append("pc" + 1 + "= " + 1);
		res.append(";");
		// the others pc is 0
		for(int i=1; i<listPc.size(); i++) {
			res.append("\n");
			res.append("pc" + (i+1) + "= " + 0);
			res.append(";");
		}
		
		for(int i=0; i<listOfLocalVarMsg.size(); i++) {
			// set local variable to false
			res.append("\n");
			res.append(listOfLocalVarMsg.get(i) + "= " + "false");
			res.append(";");
		}
		
		return res.toString();
	}
	
	/**
	 * handle transition system of sal.
	 * @return transition result.
	 */
	private String handleTransition() {
		BTNode btn = bt.getBTRoot();
		
		preOrder(btn);
		temp.append(translationRules.getAdditonSelectionRule(counter+1));
		
		return temp.toString();	
	}
	
	int counter =0;
	int pc;
	int pcval;
	
	/**
	 * explore node and translate each node visited.
	 * @param node, behavior tree node
	 */
	private void preOrder(BTNode node)
	{	
		// stack to hold node and its child 
		Stack<BTNode> ss = new Stack<BTNode>();
		ss.push(node);
		node.setBtnVisited(true);
		
		/*
		 * if node has child that has type AtomicNode, put it in INITIALIZATION.
		 * else, start TRANSITION and define first state 
		 */
		if(node.getListChild().get(0)!=null 
				&& node.getListChild().get(0).getBtnType().equalsIgnoreCase("textbt:AtomicNode"))
		{
			if(node.getSalVariable()!=null) {
				temp.append(node.getSalLocalVar() + "=" + node.getSalType());
			}
			temp.append(";");
			temp.append("\n");
		}
		else
		{
			temp.append("\n");
			temp.append("TRANSITION");
			temp.append("\n");
			temp.append("[");
			temp.append("\n");
			temp.append("A" + ++counter + ":pc" + node.getPc()+ "=" + node.getPcVal());
			temp.append("\n");
			temp.append("--> ");
			if(node.getSalVariable()!=null) {
				temp.append(node.getSalLocalVar() + "'=" + node.getSalType());
			}
			temp.append(";");
			temp.append("\n");
			appendPcChild(node);
		}
				
		while(!ss.isEmpty())
		{	
			BTNode nod = ss.peek();
			BTNode child = getUnvisitedChildNode(nod);
			
			String str = "";
			Component component = new Component();
			
			String btype="";
			
			if(child!=null)
			{			
				child.setBtnVisited(true);
				ss.push(child); // dimasukkan			

				if(child.getBtnComponentRef()!=null)
				{
					str = child.getBtnComponentRef();
					component = componentmap.get(str);
				}
			
				if(child.getBtnBehaviorRef()!=null)
				{
					int behaviorRef = Integer.parseInt(child.getBtnBehaviorRef());
					btype = component.listBehaviors.get(child.getBtnBehaviorRef()).getBehaviorType();
				}
				 
				/*
				 *  for the node that has type parallel branching or alternative branching
				 *  for m children/branches, we introduce m new pcs				 
				 */
				if(child.getBtnType()!=null && child.getBtnType().equalsIgnoreCase("textbt:ParallelBlock")) 
				{
					System.out.println("textbt:ParallelBlock");
					appendPcChild(child);
				}
				else if(child.getBtnType()!=null && child.getBtnType().equalsIgnoreCase("textbt:AlternativeBlock")) 
				{
					System.out.println("textbt:AlternativeBlock");
					appendPcChild(child);
				}
				// when pc1=0 and its type is atomic node. it is for the others node in atomic node.
				else if(child.getPc()== 1 && child.getPcVal()==0 && child.getBtnType()!=null 
						&& child.getBtnType().equalsIgnoreCase("textbt:AtomicNode"))
				{
					temp.append(child.getSalLocalVar() + "=" + child.getSalType());
					temp.append(";\n");
					if(!(child.getListChild().get(0).getBtnType().equalsIgnoreCase("textbt:AtomicNode")))
					{
						temp.append("\n");
						temp.append("TRANSITION");
						temp.append("\n");
						temp.append("[");
					}
				}
				// when node is atomic
				else if(child.getBtnType()!=null && child.getBtnType().equalsIgnoreCase("textbt:AtomicNode"))
				{
					temp.append(child.getSalLocalVar() + "'=" + child.getSalType());
					temp.append(";\n");
				}
				// when parent has type parallel block
				else if(child.getBtnParent()!= null && child.getBtnParent().getBtnType()!=null 
						&& child.getBtnParent().getBtnType().equalsIgnoreCase("textbt:ParallelBlock"))
				{
					temp.append("[]");
					temp.append("\n");
					temp.append("\n");
				
					counter++;
					String s = translationRules.translate(child, btype, counter);
					
					if(s.contains("\n--> #") && temp.indexOf("#") != -1) {
						temp.replace(temp.indexOf("#"), temp.indexOf("#")+1, translationRules.tempe);
						System.out.println("ashaaar: "+translationRules.tempe);
						translationRules.tempe = "";
					}
					temp.append(s);
					
					System.out.println("A" + counter + " : aku");
					
					appendPcChild(child);
				}
				// when parent has type alternative block
				else if(child.getBtnParent()!= null && child.getBtnParent().getBtnType()!=null 
						&& child.getBtnParent().getBtnType().equalsIgnoreCase("textbt:AlternativeBlock"))
				{
					temp.append("[]");
					temp.append("\n");
					temp.append("\n");
				
					counter++;
					String s = translationRules.translate(child, btype, counter);
					
					if(s.contains("\n--> #") && temp.indexOf("#") != -1) {
						temp.replace(temp.indexOf("#"), temp.indexOf("#")+1, translationRules.tempe);
						System.out.println("ashaaar: "+translationRules.tempe);
						translationRules.tempe = "";
					}
					temp.append(s);
					
					System.out.println("A" + counter + " : kamu");
					
					appendPcChild(child);
					// set the others pc branch to 0
					for(int i=0; i<(child.getBtnParent().getListChild().size()); i++)
					{
						if(!(child == child.getBtnParent().getListChild().get(i)))
						{
							int pcChild = child.getBtnParent().getListChild().get(i).getPc();
							temp.append("pc" + pcChild + "'=" + 0);
							temp.append(";");
							temp.append("\n");
						}
					}
				}
				else // when no branching
				{
					if(!(child.getPc()==1 && child.getPcVal()<=1))
					{
						temp.append("[]");
						temp.append("\n");
					}
					temp.append("\n");
				
					counter++;
					String s = translationRules.translate(child, btype, counter);
					
					if(s.contains("\n--> #") && temp.indexOf("#") != -1) {
						temp.replace(temp.indexOf("#"), temp.indexOf("#")+1, translationRules.tempe);
						System.out.println("ashaaar: "+translationRules.tempe);
						translationRules.tempe = "";
					}
					temp.append(s);
					System.out.println("A" + counter + " : selamanya");
					
					appendPcChild(child);
				}
			}
			else
			{
				ss.pop(); // dikeluarin
			}
		}
		
		if(temp.indexOf("#") != -1) {
			temp.replace(temp.indexOf("#"), temp.indexOf("#")+1, translationRules.tempe);
			System.out.println("ashaaar: "+translationRules.tempe);
			translationRules.tempe = "";
		}
		
	}
	
	/**
	 * append program counter of child if node has parallel
	 * branching or alternative branching. 
	 * @param node, node that will be checked.
	 */
	private void appendPcChild(BTNode node)
	{
		int pc;
		int pcval;
		int pcvalparent = node.getPcVal();
		BTNode parent;
		BTNode currNode;
		
		// if node has no child or one child, 
		if(node.getListChild().size() <= 1)
		{
			pc = node.getPc();
			pcval = node.getPcVal()+1;
			
			// REVERSION
			if(node.getBtnOperator()!=null && node.getBtnOperator().equals("^"))
			{
				// start from node
				currNode = node;
				
				while(currNode.getBtnParent()!=null)
				{
					parent = currNode.getBtnParent();
					
					if(parent.getBtnComponentRef()!=null && parent.getBtnComponentRef().equals(node.getBtnComponentRef()) &&
							parent.getBtnBehaviorRef()!=null && parent.getBtnBehaviorRef().equals(node.getBtnBehaviorRef()))
					{
						//temp.append(";\n");
						appendPcChild(parent);
						temp.append(new ReversionPcProcessing().process(parent));
						break;
					}
					currNode = parent;
				}
			}
			// REFERENCE
			else if(node.getBtnOperator()!=null && node.getBtnOperator().equals("=>")) {
				temp.append("pc" + pc + "'=" + pcval);
				temp.append(";\n");
				
				// start from parent of node
				currNode = node.getBtnParent();
				// go to branching node first
				while(currNode != null && currNode.getListChild().size()<=1)
				{
					parent = currNode.getBtnParent();
					currNode = parent;
				}
				System.out.println("=> get branching node: "+currNode.getBtnType()+" dan pc"+currNode.getPc()+":"+currNode.getPcVal());
				// search in every path 
				for(int i=0; i<currNode.getListChild().size(); i++) {
					// get child and every child must search the same node 
					BTNode child = currNode.getListChild().get(i);
					if(child.getPc() != node.getPc()) {
						ReferencePcProcessing rpp = new ReferencePcProcessing();
						rpp.a(child, node);
						BTNode refNode = rpp.getReferenceNode();
						if(refNode != null) {
							appendPcChild(refNode);
							
							BTNode brNode = null;
							if(refNode.getListChild().size() != 0) {
								brNode = refNode.getListChild().get(0);
							}
							
							if(refNode.getListChild().size() == 1 && brNode != null && 
									brNode.getBtnType() != null && 
									(
											brNode.getBtnType().equalsIgnoreCase("textbt:ParallelBlock") ||
											brNode.getBtnType().equalsIgnoreCase("textbt:AlternativeBlock")
									)
							) {
								
								for(int k=0; k < brNode.getListChild().size(); k++) {
									int pcTemp = brNode.getListChild().get(k).getPc();
									int pcValTemp = brNode.getListChild().get(k).getPcVal();
									
									if(pcTemp != 0 || pcValTemp != 0) {
										temp.append("pc" + pcTemp + "'=" + pcValTemp);
										temp.append(";\n");
									}
								}
							}
							
						}
						
					}
				}
			}
			else {
				temp.append("pc" + pc + "'=" + pcval);
				temp.append(";\n");
			}
		}
		else if(node.getListChild().size() > 1)
		{
			for(int jj=0; jj<node.getListChild().size(); jj++)
			{
				pc = node.getListChild().get(jj).getPc();
				pcval = node.getListChild().get(jj).getPcVal();
				//System.out.println("\tappend child: pc"+pc+"="+pcval);
				if((pc!=0 || pcval!=0) && pcval!=pcvalparent)
				{
					if(pc == 1 && pcval==1)
					{
						temp.append("\n");
						temp.append("TRANSITION");
						temp.append("\n");
						temp.append("[");
						temp.append("\n");
					}
					else
					{
						temp.append("pc" + pc + "'=" + pcval);
						temp.append(";\n");
					}
				}
			}
		}
	}
	
	/**
	 * get unvisited child node.
	 * @param btnode
	 * @return
	 */
	private BTNode getUnvisitedChildNode(BTNode btnode)
	{
		Iterator tor = btnode.getListChild().iterator();
		BTNode child;
		while(tor.hasNext())
		{
			child= (BTNode)tor.next();
			if(child.getBtnVisited()==false)
			{
				return child;
			}
		}
		return null;
	}
}