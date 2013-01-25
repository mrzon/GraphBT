package org.be.graphbt.saltranslator.bt2salmodel;

/**
 * Class BehaviorTree. It has one BT Node as root.
 * 
 * @date May 20, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 * 
 */
public class BehaviorTree
{
	public BTNode btRoot;
	
	public BehaviorTree() {
	}
	
	public BehaviorTree(BTNode btRoot) {
		this.btRoot = btRoot;
	}
	
	public void setBTRoot(BTNode btRoot) {
		this.btRoot = btRoot;
	}
	
	public BTNode getBTRoot() {
		return btRoot;
	}
	
	public void insertBTNode(BTNode btn) {
		if(btRoot==null) {
			btRoot = btn;
		}
		else
		{
			btRoot.getListChild().add(btn);
		}
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer();
		temp.append("Root: " + getBTRoot());
		
		return temp.toString();
	}
}