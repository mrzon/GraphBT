package bt.model;

import java.util.ArrayList;



/**
 * BT Behavior defines the behavior of Node.<br/>
 * <code>behavior name</code> is the statement of the behavior<br/>
 * <code>behavior type</code> is the BTType. If the <code>type</code> is difference and <code>name</code> is same, then it will be executed differently.<br/>
 * <code>reference number</code> is the reference number of the behavior that is defined previously in Component	 
 * @author agung
 *
 */
public class BTBehavior {
    private String behaviorName;
    private BTBehaviorType behaviorType;
    private String referenceNumber;
    private ArrayList<BTBehaviorRelation> rel = new ArrayList<BTBehaviorRelation>(); 
//    private BTSemantic semantic;

    public BTBehavior(BTBehaviorType t, String r, String n){
        behaviorName = n; behaviorType = t; referenceNumber = r;
    }
    public BTBehavior(String t, String r, String n){
    	this(Enum.valueOf(BTBehaviorType.class, (t.substring(t.indexOf(':')+1, t.length())).toUpperCase()),r,n);
    }
    @Override
    public String toString()
    {
        return behaviorType+" "+behaviorName;
    }
    
    /**
     * 
     * @return <code>ref</code> is the reference number of the behavior that is defined previously in Component
     */
    public String getReferenceNumber()
    {
        return referenceNumber;
    }
    
    /**
     * 
     * @return the behavior name which defines the statement to be executed.
     */
    public String getName()
    {
        return behaviorName;
    }
    
    /**
     * 
     * @return the behavior Type. It can be <code> BTType.SELECTION, BTType.GUARD, and etc</code>
     */
    public BTBehaviorType getType()
    {
        return behaviorType;
    }
    
    public void addRelation(String bt, String ref)
    {
        addRelation(bt, ref, "");
    }
    
    public void addRelation(String bt, String ref, String c)
    {
        rel.add(new BTBehaviorRelation(bt,ref,c));
    }
  
    public ArrayList<BTBehaviorRelation> getRelations() {
        return this.rel;
    }
    
//    public static class BTSemantic{
//    	public static final int ASSIGNMENT = 0;
//    }
}




