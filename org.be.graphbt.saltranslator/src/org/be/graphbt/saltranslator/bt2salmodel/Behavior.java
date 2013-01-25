package org.be.graphbt.saltranslator.bt2salmodel;

/**
 * Class Behavior. Example in BT,
 * #S 1 Open #S 2 Closed
 *  
 * @date May 20, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 * 
 */
public class Behavior
{
	public String behaviorType; // ex., #S
	public String behaviorRef; // ex., 1
	public String behaviorVal; // ex., Open
		
	public Behavior() {	
	}
	
	public Behavior(String behaviorType, String behaviorRef, String behaviorVal) {
		this.behaviorType = behaviorType;
		this.behaviorRef = behaviorRef;
		this.behaviorVal = behaviorVal;
	}
	
	public void setBehaviorVal(String behaviorVal) {
		this.behaviorVal = behaviorVal;
	}	
	public void setBehaviorRef(String behaviorRef) {
		this.behaviorRef = behaviorRef;
	}
	public void setBehaviorType(String behaviorType) {
		this.behaviorType = behaviorType;
	}	
	
	public String getBehaviorVal() {
		return behaviorVal;
	}	
	public String getBehaviorRef() {
		return behaviorRef;
	}	
	public String getBehaviorType() {
		return behaviorType;
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer();
		temp.append("Behavior type: " + getBehaviorType());
		temp.append("; ");
		temp.append("Behavior reference: " + getBehaviorRef());
		temp.append("; ");
		temp.append("Behavior value: " + getBehaviorVal());
		temp.append(".\n");
		
		return temp.toString();
	}
}