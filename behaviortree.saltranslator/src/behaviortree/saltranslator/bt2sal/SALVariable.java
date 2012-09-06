package behaviortree.saltranslator.bt2sal;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

/**
 * Class SALVariable. For Example,
 * Button:TYPE = {door_open, door_closed}
 * 
 * @date May 22, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 * 
 */
public class SALVariable
{
	String nameVar; // ex., Consumer_status
	String localVar; // ex., consumserStatus
	Set<String> variableTypeList = new HashSet<String>(); // ex., {consumser_status_critical, consumser_status_notcritical}
	
	public SALVariable()
	{
	}
	
	public SALVariable(String nameVar)
	{
		this.nameVar = nameVar;
	}
	
	public void setVariableName(String nameVar)
	{
		this.nameVar = nameVar;
	}
	
	public void addTypeList(String type)
	{
		variableTypeList.add(type);
	}
	
	public void setLocalVar(String localVar)
	{
		this.localVar=localVar;
	}
	
	public String getLocalVar()
	{
		return localVar;
	}
	
	public String getVariableName()
	{
		return nameVar;
	}
	
	public String toString()
	{
		StringBuffer temp = new StringBuffer();
		
		temp.append(nameVar);
		temp.append(": TYPE={");
		
		Iterator<String> i = variableTypeList.iterator();
		String helper;
		helper = (String) i.next();
		temp.append(helper.toLowerCase());
		while(i.hasNext())
		{
			temp.append(",");
			helper = (String) i.next();
			temp.append(helper.toLowerCase());
		}
		temp.append("};");
		temp.append("\n");
		
		return temp.toString();
	}
}