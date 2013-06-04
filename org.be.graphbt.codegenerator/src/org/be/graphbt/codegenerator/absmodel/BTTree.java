/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Emerson
 */
public class BTTree {
	private Set<BTComponent> s = new HashSet<BTComponent>();
	private Set<BTNode> bN = new HashSet<BTNode>();

	private BTNode root = null;
	public BTTree(BTNode ro) {
		root = ro;
	}

	public void addBTNode(BTNode ro) {
		bN.add(ro);
	}
	public BTNode getNodeByQualifier(String comp, String beh) {
		Iterator <BTNode> i = bN.iterator();
		while(i.hasNext()) {
			BTNode bt = i.next();
			if(bt.getOp()!=BTNodeOp.REVERSION) {
				if(bt.getComponent()!=null&&comp.equals(bt.getComponent().getName())&&bt.getBehavior()!=null&&beh.equals(bt.getBehavior().getName())) {
					return bt;
				}
			}
		}
		return null;    
	}
	public BTNode getNodeByPC(String pc) {
		Iterator <BTNode> i = bN.iterator();
		while(i.hasNext()) {
			BTNode bt = i.next();
			if(bt.getOp()!=BTNodeOp.REVERSION && pc.equals(bt.getPC())) {
				return bt;
			}
		}
		return null;    
	}

	public void addComponent(BTComponent b) {
		s.add(b);
	}

	public void setRoot(BTNode bn) {
		root = bn;
	}

	public BTNode getRoot() {
		return root;
	}

	public BTComponent getComponent(String ref) {
		Iterator<BTComponent> i = s.iterator();

		while(i.hasNext()) {
			BTComponent b = i.next();
			if(b.getRef().equals(ref)) {
				return b;
			}
		}
		return null;
	}

	private String getNextPC(BTNode root) {
		if(root.getComponent()!=null && root.getComponent().isPrimitive()) {
			return getNextPC(root.getChilds().get(0));
		}
		return root.getPC();
	}
	public String toStringABS(BTNode root, String nodeBlock) {
		String temp = "";
		if(root==null)
			return "";
		if(root.getComponent()!=null && root.getComponent().isPrimitive()) {
			return toStringABS(root.getChilds().get(0),nodeBlock);
		}
		if(root.getOp()==BTNodeOp.REVERSION) {
			//System.out.println("hoh "+root);
			if(getNodeByQualifier(root.getComponent().getName(),root.getBehavior().getName())!=null) {
				String comp = root.getComponent()==null?"null":root.getComponent().getRef().toLowerCase()+"_var";
				String beh = root.getBehavior()==null?"":"method"+root.getBehavior().getRef();
				String type = root.getType()==null?"":root.getType().toString();
				String qtype = root.getBehavior()==null?"STATE":root.getBehavior().getType().toString();
				String op = root.getOp()==null?"":root.getOp().toString();

				temp += "N node"+root.getPC()+" = new Node("+comp+",\""+beh+"\",\""+type+"\","+qtype+","+op+",\""+root.getPC()+"\");\n";
				temp += "node"+root.getPC()+".setNodeBlock("+nodeBlock+");\n";
				temp += "node"+root.getPC() +".addNode(node"+getAncestor(root, root.getParent()).getPC()+");\n";
				return temp;
			}
			return "";
		}
		String comp = root.getComponent()==null?"null":root.getComponent().getRef().toLowerCase()+"_var";
		String beh = root.getBehavior()==null?"":"method"+root.getBehavior().getRef();
		String type = root.getType()==null?"":root.getType().toString();
		String qtype = root.getBehavior()==null?"STATE":root.getBehavior().getType().toString();
		String op = root.getOp()==null?"":root.getOp().toString();
		if(nodeBlock==null) {
			nodeBlock = "nodeBlock";
			temp += "NodeBlock nodeBlock = new NodeBlockImpl();\n";
		}
		temp += "N node"+root.getPC()+" = new Node("+comp+",\""+beh+"\",\""+type+"\","+qtype+","+op+",\""+root.getPC()+"\");\n";
		temp += "node"+root.getPC()+".setNodeBlock("+nodeBlock+");\n";
		if(root.getChilds().size() == 1) {
			temp += toStringABS(root.getChilds().get(0),nodeBlock);
			temp += "node"+root.getPC()+".addNode(node"+getNextPC(root.getChilds().get(0))+");\n";
		} else {
			for(int i = 0; i < root.getChilds().size(); i++) {
				temp += "NodeBlock "+nodeBlock+i+" = new NodeBlockImpl();\n";
				temp += nodeBlock+i+".setParent("+nodeBlock+");\n";
				temp += toStringABS(root.getChilds().get(i),nodeBlock+i);
				temp += "node"+getNextPC(root.getChilds().get(i))+".setNodeBlock("+nodeBlock+i+");\n";
				temp += "node"+root.getPC()+".addNode(node"+getNextPC(root.getChilds().get(i))+");\n";
			}
		}
		return temp;
	}

	public String toString(BTNode root) {
		if(root == null) {
			return "";
		}
		if(root.getChilds().isEmpty())
			return root.toString();
		String temp = "";
		temp = root.toString();
		if(root.getType()==BTNodeType.ATOMICNODE) {
			temp+=";; "+toString(root.getChilds().get(0));
		}
		else if(root.getType()==BTNodeType.SEQUENTIALNODE)
			temp+="; "+toString(root.getChilds().get(0));
		else if(root.getType()==BTNodeType.PARALLELBLOCK) {
			temp+=" P {\n";
			for(int i = 0; i < root.getChilds().size(); i++) {
				temp+=toString(root.getChilds().get(i))+"\n";
			}
			temp+="}";
		}
		else if(root.getType()==BTNodeType.SELECTIONBLOCK) {
			temp+=" N {\n";
			for(int i = 0; i < root.getChilds().size(); i++) {
				temp+=toString(root.getChilds().get(i))+"\n";
			}
			temp+="}";
		}

		return temp;
	}
	@Override
	public String toString() {   
		String temp;
		Iterator<BTComponent> i = s.iterator();
		temp = i.next().toString();
		while(i.hasNext()) {
			temp=temp+"\n"+i.next().toString();
		}
		temp+="\n#T "+toString(root);
		return temp;
	}

	public int getHeight() {
		return getHeight(root);
	}

	public int getHeight(BTNode b) {
		if(b == null) {
			return -1;
		}
		int m = 0;
		for(int i = 0; i < b.getChilds().size(); i++) {
			int temp = getHeight(b.getChilds().get(i));
			if(temp > m) {
				m = temp;
			}
		}
		return m+1;
	}
	public BTNode getAncestor(BTNode node, BTNode parent) {
		if(parent==null || node==null) {
			return null;
		}
		if(parent.getType().equals(BTNodeType.ALTERNATIVEBLOCK)||parent.getType().equals(BTNodeType.ALTERNATIVEBLOCK)) {
			return getAncestor(node, parent.getParent());
		}
		if(parent.getComponent()==node.getComponent() && parent.getBehavior()==node.getBehavior()) {
			return parent;
		} else {
			return getAncestor(node, parent.getParent());
		}
	}
	public Set<BTComponent> getComponents() {
		return s;
	}
}
