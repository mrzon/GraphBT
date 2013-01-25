package org.be.graphbt.saltranslator.bt2salmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * translation rules class.
 * @author Ardi
 *
 */
public class TranslationRules {
	/*
	 * list that take in nodes, used for SELECTION rule in NOT condition.
	 * used for getAdditionSelectionRule() method.
	 */
	private List<BTNode> list4Selection = new ArrayList<BTNode>();
	String tempe = "";
	
	/**
	 * translate node based defined rules.
	 * @param node
	 * @param btype
	 * @param counter
	 * @return
	 */
	public String translate(BTNode node, String btype, int counter) {
		StringBuffer result = new StringBuffer();
		result.append("A" + counter + ":pc" + node.getPc() + "=" + node.getPcVal());
		
		// GUARD AND EXTERNAL INPUT
		if(btype.equalsIgnoreCase("textbt:Event")
				|| btype.equalsIgnoreCase("textbt:Guard") 
				|| btype.equalsIgnoreCase("textbt:ExternalInput")) {
			result.append(" AND ");
			result.append(node.getSalLocalVar() + "=" + node.getSalType());
			result.append("\n");
			result.append("--> ");
		} 
		else if(btype.equalsIgnoreCase("textbt:InternalInput")) {
			result.append(" AND ");
			result.append(node.getSalLocalVar() + "=true");
			result.append("\n");
			result.append("--> ");
			result.append(node.getSalLocalVar() + "'=false");
			result.append(";");
			result.append("\n");
			
			tempe += node.getSalLocalVar() + "'=true;\n";
		}
		// SELECTION
		else if(btype.equalsIgnoreCase("textbt:Selection")) {
			result.append(" AND ");
			result.append(node.getSalLocalVar() + "=" + node.getSalType());
			result.append("\n");
			result.append("--> ");
			
			// add to list
			list4Selection.add(node);
		}
		// INTERNAL OUTPUT
		else if(btype.equalsIgnoreCase("textbt:InternalOutput")) {
			result.append("\n--> #");
		}
		// STATE REALIZATION, EXTERNAL OUTPUT
		else
		{
			result.append("\n");
			result.append("--> ");
			result.append(node.getSalLocalVar() + "'=" + node.getSalType());
			result.append(";");
			result.append("\n");
		}
		
		return result.toString();
	}
	
	/**
	 * addition selection rule from list that monitors translate() method.
	 * @param startCounter
	 * @return
	 */
	public String getAdditonSelectionRule(int startCounter) {
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<list4Selection.size(); i++) {
			result.append("[]");
			result.append("\n");
			result.append("\n");
			
			BTNode node = list4Selection.get(i);
			result.append("A" + startCounter + ":pc" + node.getPc() + "=" + node.getPcVal());
			result.append(" AND NOT ");
			result.append("(");
			result.append(node.getSalLocalVar() + "=" + node.getSalType());
			result.append(")");
			result.append("\n");
			result.append("--> ");
			result.append("pc" + node.getPc() + "'=" + 0 + ";");
			result.append("\n");
			
			startCounter++;
		}
		return result.toString();
	}

}
