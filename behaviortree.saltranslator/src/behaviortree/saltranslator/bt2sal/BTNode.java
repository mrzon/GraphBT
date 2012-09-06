package behaviortree.saltranslator.bt2sal;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BTNode. 
 * 
 * @date May 21, 2011
 * @author Niken Listya Pratiwi
 * @modified Ardi
 * 
 */
public class BTNode
{
	private String btnType; // ex., textbt:AtomicNode
	private String btnComponentRef; // ex., C1
	private String btnBehaviorRef; // ex., 1 (first behavior from component)
	private String btnTraceStatus; // ex., +
	private String btnOperator; // node operator	
	private List <BTNode> listChilds = new ArrayList<BTNode>(); // one node holds array list of bt nodes
	private boolean btnVisited; // flag for visited bt node
	private BTNode btnParent; // reference to parent node
	
	private int pc; // program counter reference
	private int pcVal; // program counter value
	private String salVariable; // ex, Door
	private String salType; // ex., door
	private String salLocalVar; // ex., door_closed
	
	public BTNode()
	{
	}
	
	public void setBtnType(String btnType)
	{
		this.btnType = btnType;
	}
	
	public void setBtnComponentRef(String btnComponentRef)
	{
		this.btnComponentRef = btnComponentRef;
	}
	
	public void setBtnBehaviorRef(String btnBehaviorRef)
	{
		this.btnBehaviorRef = btnBehaviorRef;
	}
	
	public void setBtnTraceStatus(String btnTraceStatus)
	{
		this.btnTraceStatus = btnTraceStatus;
	}
	
	public void setBtnOperator(String btnOperator)
	{
		this.btnOperator = btnOperator;
	}
	
	public void setBtnVisited(boolean btnVisited)
	{
		this.btnVisited=btnVisited;
	}
	
	public void setBtnParent(BTNode btnParent)
	{
		this.btnParent = btnParent;
	}
	
	public void setPc(int pc)
	{
		this.pc = pc;
	}
	
	public void setPcVal(int pcVal)
	{
		this.pcVal = pcVal;
	}
	
	public void setSalVariable(String salVariable)
	{
		this.salVariable = salVariable;
	}
	
	public void setSalType(String salType)
	{
		this.salType = salType;
	}
	
	public void setSalLocalVar(String salLocalVar)
	{
		this.salLocalVar = salLocalVar;
	}
	
	public String getBtnType()
	{
		return btnType;
	}
	
	public String getBtnComponentRef()
	{
		return btnComponentRef;
	}
	
	public String getBtnBehaviorRef()
	{
		return btnBehaviorRef;
	}
	
	public String getBtnTraceStatus()
	{
		return btnTraceStatus;
	}
	
	public String getBtnOperator()
	{
		return btnOperator;
	}
	
	public List <BTNode> getListChild()
	{
		return listChilds;
	}
	
	public boolean getBtnVisited()
	{
		return btnVisited;
	}
	
	public BTNode getBtnParent()
	{
		return btnParent;
	}
	
	public int getPc()
	{
		return pc;
	}
	
	public int getPcVal()
	{
		return pcVal;
	}
	
	public String getSalVariable()
	{
		return salVariable;
	}
	
	public String getSalType()
	{
		return salType;
	}
	
	public String getSalLocalVar()
	{
		return salLocalVar;
	}
	
	public String getBtn()
	{
		return getBtnComponentRef()+ ":" + getBtnBehaviorRef();
	}
	
	public void printBtn()
	{
		System.out.println(getBtnComponentRef()+ ":" + getBtnBehaviorRef());
		System.out.println(getSalVariable() + ":" + getSalType());
		System.out.println("pc" + getPc() + "=" + getPcVal());
		System.out.println("\n");
	}
	
	public void clearBtn()
	{
		
	}
}