package behaviortree.saltranslator.bt2sal;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Component. Example in BT,
 * #C C1 DOOR 
 * 	#S 1 Open 2 Closed
 * 
 * @date May 20, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 *
 */
public class Component
{
	public String componentReference; // ex., C1
	public String componentVal; // ex., DOOR
	// list of behavior. ex., #S 1 Open #S 2 Closed 
	Map<String, Behavior> listBehaviors = new HashMap<String, Behavior>();
	
	public Component()
	{
	}
	
	public Component(String componentReference, String componentVal, Map<String, Behavior> listBehaviors)
	{	
		this.componentReference = componentReference;
		this.componentVal = componentVal;
		this.listBehaviors = listBehaviors;
	}
	
	public void setComponentVal(String componentVal)
	{
		this.componentVal = componentVal;
	}
	public void setComponentReference(String componentReference)
	{
		this.componentReference = componentReference;
	}
	
	public String getComponentVal()
	{
		return componentVal;
	}
	
	public String getComponentReference()
	{
		return componentReference;
	}	
}