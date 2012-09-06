package behaviortree.saltranslator.bt2sal;

import java.util.HashSet;
import java.util.Iterator;

public class ReferencePcProcessing {
	private BTNode result = null;
	private boolean b = true;
	
	public void a(BTNode node, BTNode goal) {
		for(int i=0; i<node.getListChild().size() && b; i++) {
			BTNode child = node.getListChild().get(i);
			
			if(goal.getBtnComponentRef()!=null && goal.getBtnComponentRef().equals(child.getBtnComponentRef()) &&
					goal.getBtnBehaviorRef()!=null && goal.getBtnBehaviorRef().equals(child.getBtnBehaviorRef()))
			{
				b = false;
				System.out.println("\t"+child.getSalType());
				System.out.println("\tpc"+child.getPc()+":"+goal.getPcVal());
				result = child;
				break;
			}
			
			// do recursively
			if(b) a(child, goal);
		}
	}
	
	public BTNode getReferenceNode() {
		return result;
	}
}
