/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.model;

import java.util.*;

/**
 *
 * @author Emerson
 */
public class BTTree {
    private Set<BTComponent> componentSet = new HashSet<BTComponent>();
    private Set<BTNode> btNodeSet = new HashSet<BTNode>();
    
    private BTNode rootNode = null;
    public BTTree(BTNode ro)
    {
        rootNode = ro;
    }
    
    public void addBTNode(BTNode ro)
    {
        btNodeSet.add(ro);
    }
    
    public BTNode getDestinationReversionNode(BTNode reversionNode)
    {
    	if(reversionNode.getBTNodeOperator() != BTNodeOperator.REVERSION)
    		throw new IllegalStateException();
    	
    	String suffixCode = reversionNode.getNodeNumber();
    	String componentName = reversionNode.getBTComponent().getName();
    	String behaviorName = reversionNode.getBehavior().getName();
    	BTBehaviorType behaviorType = reversionNode.getBehavior().getType();
//    	System.out.println("suffixCode:"+suffixCode);
//    	System.out.println("ComponentName:"+componentName);
//    	System.out.println("behaviorName:"+behaviorName);
//    	System.out.println("behaviorType:"+behaviorType.toString());
        BTNode root = this.rootNode;
        ArrayList<BTNode> dests = new ArrayList<BTNode>();
        for(int i = 1; i < suffixCode.length() - 1; ++i){
        	int ind = suffixCode.charAt(i)  - '0';
        	root = root.getDirectChilds().get(ind);
        	if(root.getBTNodeType() != BTNodeType.PARALLELBLOCK){
//	        	System.out.println("suffixCode:"+root.getNodeNumber());
//	        	System.out.println("ComponentName:"+root.getBTComponent().getName());
//	        	System.out.println("behaviorName:"+root.getBehavior().getName());
//	        	System.out.println("behaviorType:"+root.getBehavior().getType().toString());
//	        	System.out.println("btNodeOperator:"+root.getBTNodeOperator().toString());
        	}
        	if(root.getBTNodeType()!=BTNodeType.ALTERNATIVEBLOCK &&
        			root.getBTNodeOperator() != BTNodeOperator.REVERSION && 
        			root.getBTNodeType() != BTNodeType.PARALLELBLOCK &&
        			root.getBTComponent().getName().equalsIgnoreCase(componentName) &&
        			root.getBehavior().getName().equalsIgnoreCase(behaviorName) &&
        			root.getBehavior().getType() == behaviorType){
        		dests.add(root);
//        		System.out.println("DAPAT");
        	}
        }
        if(dests.size() > 0)
        	return dests.get(dests.size()-1);
        return null;
        
    }
    
    public void giveBTTNumberForBTNode(){
    	int start = 1;
    	
    	Stack<BTNode> stack = new Stack<BTNode>();
    	stack.add(this.rootNode);
    	while(!stack.isEmpty()){
    		BTNode node = stack.pop();
    		
    		node.setNodeNumberForBTT(start);
    		start++;
    		ArrayList<BTNode> childs = null;
    		if(node.hasParallelChild()){
    			childs = node.getUndirectChildren();
    		}else{
    			if(node.getBTNodeType() == BTNodeType.ATOMICNODE){
    				boolean hasAtomicChildToo = false;
    				ArrayList<BTNode> nodes = null;
    				do{
    					hasAtomicChildToo = false;
        				nodes = node.getDirectChilds();
	    				for (BTNode btNode : nodes) {
							if(btNode.getBTNodeType() == BTNodeType.ATOMICNODE){
								hasAtomicChildToo = true;
								break;
							}
						}
	    				if(hasAtomicChildToo && nodes.size() > 1){
	    					throw new IllegalStateException("Atomic Child can't have more than 1 atomic childs 'A', which A has another sibling");
	    				}else if(hasAtomicChildToo && nodes.size() == 1){
	    					node = nodes.get(0);
	    				}
//	    				System.out.println("ADA TERUS : "+node);
    				}while(hasAtomicChildToo);
    				if(nodes!=null && nodes.size() > 0){
    					childs = nodes;
    				}
    			}else{
    				childs = node.getDirectChilds();
    			}
    			
    		}
    		
    		if(childs!=null && childs.size() > 0){
    			for(int i = childs.size() - 1; i >= 0 ;--i){
    				stack.add(childs.get(i));
    			}
    		}
    		
    	}
    }
    
    
    
    public BTNode getNodeByQualifier(String comp, String beh)
    {
        Iterator <BTNode> i = btNodeSet.iterator();
        while(i.hasNext())
        {
            BTNode bt = i.next();
            if(bt.getBTNodeOperator()!=BTNodeOperator.REVERSION)
            {
                if(bt.getBTComponent()!=null&&comp.equals(bt.getBTComponent().getName())&&bt.getBehavior()!=null&&beh.equals(bt.getBehavior().getName()))
                {
                    return bt;
                }
            }
        }
        return null;    
    }
    
    public BTNode getNodeByPC(String pc)
    {
        Iterator <BTNode> i = btNodeSet.iterator();
        while(i.hasNext())
        {
            BTNode bt = i.next();
            if(bt.getBTNodeOperator()!=BTNodeOperator.REVERSION && pc.equals(bt.getNodeNumber()))
            {
                return bt;
            }
        }
        return null;    
    }
    
    public void addComponent(BTComponent b)
    {
        componentSet.add(b);
    }
    
    public void setRoot(BTNode bn)
    {
        rootNode = bn;
    }
    
    public BTNode getRoot()
    {
        return rootNode;
    }
    
    public BTComponent getComponent(String ref)
    {
        Iterator<BTComponent> i = componentSet.iterator();
        
        while(i.hasNext())
        {
            BTComponent b = i.next();
            if(b.getRef().equals(ref))
            {
                return b;
            }
        }
        return null;
    }
    
    private String getNextPC(BTNode root)
    {
        if(root.getBTComponent()!=null && root.getBTComponent().isPrimitive())
        {
            return getNextPC(root.getDirectChilds().get(0));
        }
        return root.getNodeNumber();
    }
    public String toStringABS(BTNode root)
    {
        if(root.getBTComponent()!=null && root.getBTComponent().isPrimitive())
        {
            return toStringABS(root.getDirectChilds().get(0));
        }
        if(root.getBTNodeOperator()==BTNodeOperator.REVERSION)
        {
            //System.out.println("hoh "+root);
            if(getNodeByQualifier(root.getBTComponent().getName(),root.getBehavior().getName())!=null)
            {
                String temp = "node"+root.getNodeNumber().substring(0, root.getNodeNumber().length()-1) +".addNode(node"+getNodeByQualifier(root.getBTComponent().getName(),root.getBehavior().getName()).getNodeNumber()+");";
                return temp;
            }
            return "";
        }
        String temp = "";
        String comp = root.getBTComponent()==null?"null":root.getBTComponent().getRef().toLowerCase()+"_var";
        String beh = root.getBehavior()==null?"":"method"+root.getBehavior().getReferenceNumber();
        String type = root.getBTNodeType()==null?"":root.getBTNodeType().toString();
        String qtype = root.getBehavior()==null?"":root.getBehavior().getType().toString();
        String op = root.getBTNodeOperator()==null?"":root.getBTNodeOperator().toString();
        temp = "N node"+root.getNodeNumber()+" = new Node("+comp+",\""+beh+"\",\""+type+"\",\""+qtype+"\",\""+op+"\",\""+root.getNodeNumber()+"\");\n";
        for(int i = 0; i < root.getDirectChilds().size(); i++)
        {
            temp+=toStringABS(root.getDirectChilds().get(i))+"\n";
            if(root.getDirectChilds().get(i).getBTNodeOperator()!=BTNodeOperator.REVERSION)
            temp+="node"+root.getNodeNumber()+".addNode(node"+getNextPC(root.getDirectChilds().get(i))+");";
        }
     
        return temp;
    }
    
    public String toString(BTNode root)
    {
        if(root == null)
        {
            return "";
        }
        if(root.getDirectChilds().isEmpty())
            return root.toString();
        String temp = "";
        temp = root.toString();
        if(root.getBTNodeType()==BTNodeType.ATOMICNODE)
        {
            temp+=";; "+toString(root.getDirectChilds().get(0));
        }
        else if(root.getBTNodeType()==BTNodeType.SEQUENTIALNODE)
            temp+="; "+toString(root.getDirectChilds().get(0));
        else if(root.getBTNodeType()==BTNodeType.PARALLELBLOCK)
        {
            //System.out.println(root.getChilds()+" kaehgk");
            temp+=" P {\n";
            for(int i = 0; i < root.getDirectChilds().size(); i++)
            {
                temp+=toString(root.getDirectChilds().get(i))+"\n";
            }
            temp+="}";
        }
        else if(root.getBTNodeType()==BTNodeType.ALTERNATIVEBLOCK)
        {
            temp+=" N {\n";
            for(int i = 0; i < root.getDirectChilds().size(); i++)
            {
                temp+=toString(root.getDirectChilds().get(i))+"\n";
            }
            temp+="}";
        }
        
        return temp;
    }
    @Override
    public String toString()
    {   
        String temp;
        Iterator<BTComponent> i = componentSet.iterator();
        temp = i.next().toString();
        while(i.hasNext())
        {
            temp=temp+"\n"+i.next().toString();
        }
        temp+="\n#T "+toString(rootNode);
        return temp;
    }
    
    public int getHeight()
    {
        return getHeight(rootNode);
    }
    
    public int getHeight(BTNode b)
    {
        if(b == null)
        {
            return -1;
        }
        int m = 0;
        for(int i = 0; i < b.getDirectChilds().size(); i++)
        {
            int temp = getHeight(b.getDirectChilds().get(i));
            if(temp > m)
            {
                m = temp;
            }
        }
        return m+1;
    }

    public Set<BTComponent> getComponents() {
        return componentSet;
    }
}


