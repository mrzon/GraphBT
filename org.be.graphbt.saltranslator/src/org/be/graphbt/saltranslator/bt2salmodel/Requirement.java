package org.be.graphbt.saltranslator.bt2salmodel;

/**
* Class Requirement
* 
* @date May 21, 2011
* @author Niken Listya Pratiwi
*  
*/
public class Requirement
{
	public String requirementRef;
	public String requirementVal;
	
	/**
	* Constructor
	*/
	public Requirement() {
	}
	
	public void setRequirementRef(String requirementRef) {
		this.requirementRef = requirementRef;
	}
	
	public void setRequirementVal(String requirementVal) {
		this.requirementVal = requirementVal;
	}
		
	public String getRequirementRef() {
		return requirementRef;
	}
	
	public String getRequirementVal() {
		return requirementVal;
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer();
		temp.append("Requirement reference: " + getRequirementRef());
		temp.append("; ");
		temp.append("Requirement value: " + getRequirementVal());
		temp.append(".\n");
		
		return temp.toString();
	}
}