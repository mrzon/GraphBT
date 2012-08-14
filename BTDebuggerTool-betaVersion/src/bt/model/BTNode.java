/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.model;

import java.util.ArrayList;

/**
 * Defines the single Node of Behavior Tree
 * @author Emerson
 * @author Agung Pratama
 */
public class BTNode {
	private int processID = -1;
	private boolean breakPointed = false;
	private int nodeNumberForBTT = -1;
	private int parentAlternativeNodeNumber = -1;
	
    private BTNodeOperator btOperator = BTNodeOperator.DEFAULT; 
    private BTNodeType btType = BTNodeType.SEQUENTIALNODE; 
    private BTComponent componentRef = null;
    private BTBehavior behaviorRef = null;
    private ArrayList<BTNode> directChildren = new ArrayList<BTNode>();
    
    /**
     * This is used to get children of its child node which is PARALLEL  NODE
     */
    private String nodeNumber = "0";
    
    public BTNode(BTComponent component, BTBehavior behavior)
    {
        componentRef = component;
        behaviorRef = behavior;
    }
    
    public BTNode(String type, String operator, BTComponent component, BTBehavior behavior)
    {
        componentRef = component;
        behaviorRef = behavior;
        //System.out.println(t);
        this.btType = (type==null)?BTNodeType.SEQUENTIALNODE:Enum.valueOf(BTNodeType.class, (type.substring(type.indexOf(':')+1, type.length())).toUpperCase());
        btOperator = (operator==null)? BTNodeOperator.DEFAULT:BTNodeOperator.fromString(operator);
    }
    
    public BTNode(String type)
    {
        //System.out.println(t);
        btType=Enum.valueOf(BTNodeType.class, (type.substring(type.indexOf(':')+1, type.length())).toUpperCase());
    }
    private boolean hasParallelChild;
    
    public void addChild(BTNode node)
    {
        directChildren.add(node);
        
        //assume that parent can hold max 1 PARALLEL NODE child
        if(node.getBTNodeType() == BTNodeType.PARALLELBLOCK){
        	hasParallelChild = true;
        }
    }
    
    public ArrayList<BTNode> getDirectChilds()
    {
        return this.directChildren;
    }
    
    public BTNodeOperator getBTNodeOperator()
    {
        return btOperator;
    }
   
    public BTNodeType getBTNodeType()
    {
        return btType;
    }
    
    public BTComponent getBTComponent()
    {
        return this.componentRef;
    }
    
    
    public BTBehavior getBehavior()
    {
        return this.behaviorRef;
    }
    
    public void setOperator(String operator)
    {
        btOperator = BTNodeOperator.fromString(operator);
    }
    
    public void setNodeNumber(String number)
    {
        nodeNumber = number;
    }
    
    @Override
    public String toString()
    {
        if(this.btType != null && (componentRef != null && behaviorRef != null && nodeNumber != null))
        {
            return this.nodeNumber+" "+(this.btType==BTNodeType.PARALLELBLOCK||this.btType==BTNodeType.ALTERNATIVEBLOCK?this.btType.toString():" "+this.componentRef.getName()+" "+this.behaviorRef.toString()+" "+(this.btOperator==null?"":this.btOperator.getOperator()));
        }
        return " ";
    }

    public String getNodeNumber() {
        return nodeNumber;
    }

	public ArrayList<BTNode> getUndirectChildren() {
		if(this.hasParallelChild)
			return this.directChildren.get(0).getDirectChilds();
		return null;
	}
	
	public boolean hasParallelChild(){
		return this.hasParallelChild;
	}

	public int getProcessID() {
		return processID;
	}

	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public boolean isBreakPointed() {
		return breakPointed;
	}

	public void setBreakPointed(boolean breakPointed) {
		this.breakPointed = breakPointed;
	}

	public int getNodeNumberForBTT() {
		return nodeNumberForBTT;
	}

	public void setNodeNumberForBTT(int nodeNumberForBTT) {
		this.nodeNumberForBTT = nodeNumberForBTT;
	}

	public int getParentAlternativeNodeNumber() {
		return parentAlternativeNodeNumber;
	}

	public void setParentAlternativeNodeNumber(int parentAlternativeNodeNumber) {
		this.parentAlternativeNodeNumber = parentAlternativeNodeNumber;
	}
}
