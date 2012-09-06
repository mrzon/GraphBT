package behaviortree.saltranslator.bt2sal;

import java.util.HashSet;
import java.util.Iterator;

public class ReversionPcProcessing {
	private HashSet<Integer> hs;
	private StringBuffer result;
	
	/**
	 * process node for searching reversion pc.
	 * @param node, starting node.
	 * @return result.
	 */
	public String process(BTNode node) {
		
		hs = new HashSet<Integer>();
		result = new StringBuffer();
		
		// main process
		checkBranching(node);
		exploreTree(node);
		
		// set result from hs
		Iterator<Integer> i = hs.iterator();
		while(i.hasNext()) {
			int pcVal = (Integer) i.next();
			result.append("pc" + pcVal + "'=" + 0);
			result.append(";\n");
		}
		
		return result.toString();
	}
	
	/**
	 * explore all path from the node.
	 * @param node, starting node.
	 */
	private void exploreTree(BTNode node) {
		// explore and add pc
		findAllPc(node);
		// cut down with first step pc
		cutDownPc(node);
	}
	
	/**
	 * find pc from all path started from this node.
	 * @param node, starting node.
	 */
	private void findAllPc(BTNode node)
	{	
		for(int i=0; i<node.getListChild().size(); i++) {
			BTNode child = node.getListChild().get(i);
			
			int pc = node.getListChild().get(i).getPc();
			// save node pc to hash set 
			if(pc != 0) {
				hs.add(pc);
			}
			
			// do recursively
			findAllPc(child);
		}
	}
	
	/**
	 * cut down pc with first step program counter.
	 * @param node, starting node.
	 */
	private void cutDownPc(BTNode node)
	{	
		BTNode brNode = null;
		if(node.getListChild().size() != 0) {
			brNode = node.getListChild().get(0);
		}
		
		if(node.getListChild().size() == 1 && brNode != null && 
				brNode.getBtnType() != null && 
				brNode.getBtnType().equalsIgnoreCase("textbt:ParallelBlock")) {
			
			for(int i=0; i < brNode.getListChild().size(); i++) {
				int programCounter = brNode.getListChild().get(i).getPc();
				hs.remove(programCounter);
			}
		}
	}
	
	/**
	 * check branching. maybe we can get pc from here.
	 * @param node
	 */
	private void checkBranching(BTNode node)
	{	
		// maybe one step from node is 'branching node'
		BTNode brNode = null;
		if(node.getListChild().size() != 0) {
			brNode = node.getListChild().get(0);
		}
		
		/* 
		 * the node must have one child that called branching child and 
		 * every child from branching child has type textbt:ParallelBlock. 
		 * then get program counter for every node.
		 */
		if(node.getListChild().size() == 1 && brNode != null && 
				brNode.getBtnType() != null && 
				brNode.getBtnType().equalsIgnoreCase("textbt:ParallelBlock")) {
			
			for(int i=0; i < brNode.getListChild().size(); i++) {
				int pc = brNode.getListChild().get(i).getPc();
				int pcVal = brNode.getListChild().get(i).getPcVal();
				
				if(pc != 0 || pcVal != 0) {
					result.append("pc" + pc + "'=" + pcVal);
					result.append(";\n");
				}
			}
		}
	}
}
