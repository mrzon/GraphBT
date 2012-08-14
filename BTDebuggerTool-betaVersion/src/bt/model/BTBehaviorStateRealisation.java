package bt.model;


public class BTBehaviorStateRealisation extends BTBehavior{
    public BTBehaviorStateRealisation(String ref, String name)
    {
    	super(BTBehaviorType.STATE, ref, name);
    }
    @Override
    public String toString()
    {
        return "["+this.getName()+"]";
    }
}