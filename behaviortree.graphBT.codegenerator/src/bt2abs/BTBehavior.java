package bt2abs;

import java.util.ArrayList;

enum BTRelationType{
    WHAT,WHERE,WHO,WHY
}
class BTRelation{
    private BTRelationType rel;
    private String cmpl="";
    private String com;
    
    
    public BTRelation(BTRelationType bt,String co,String c){
        rel = bt; com = co; cmpl = c;
    }
    public BTRelation(String bt,String co,String c){
        this(Enum.valueOf(BTRelationType.class,bt.toUpperCase()), co,c);
    }
    
    public BTRelationType getRelationType()
    {
        return rel;
    }
    
    
    public String getComplement()
    {
        return cmpl;
    }
    
    
    public String getComponentRef()
    {
        return com;
    }
    
    @Override
    public String toString()
    {
        return ((cmpl==null?"":cmpl)+" "+com).trim();
    }
}
class BTSelection extends BTBehavior{
    public BTSelection(String ref, String name)
    {
        super(BTType.SELECTION, ref, name);
    }
    
    @Override
    public String toString()
    {
        return "?"+this.getName()+"?";
    }
}
class BTStateRealization extends BTBehavior{
    public BTStateRealization(String ref, String name)
    {
        super(BTType.STATE, ref, name);
    }
    @Override
    public String toString()
    {
        return "["+this.getName()+"]";
    }
}
class BTGuard extends BTBehavior{
	public BTGuard(String ref, String name)
        {
            super(BTType.GUARD, ref, name);
        }
        
    @Override
        public String toString()
        {
            return "???"+this.getName()+"???";
        }
}

public class BTBehavior {
    private String name;
    private BTType type;
    private String ref;
    private ArrayList<BTRelation> rel = new ArrayList<BTRelation>(); 
    private ABSStatement absState = null;

    public BTBehavior(BTType t, String r, String n){
        name = n; type = t; ref = r;
    }
    public BTBehavior(String t, String r, String n){
        this(Enum.valueOf(BTType.class, (t.substring(t.indexOf(':')+1, t.length())).toUpperCase()),r,n);
    }
    @Override
    public String toString()
    {
        return type+" "+name;
    }
    public String getRef()
    {
        return ref;
    }
    public String getName()
    {
        return name;
    }
    
    public BTType getType()
    {
        return type;
    }
    public void addRelation(String bt, String ref)
    {
        addRelation(bt, ref, "");
    }
    public void addRelation(String bt, String ref, String c)
    {
        rel.add(new BTRelation(bt,ref,c));
    }
    
    public void setABSStatement(ABSStatement as)
    {
        absState = as;
    }

    ABSStatement getABSStatement() {
        return absState;
    }

    ArrayList<BTRelation> getRelations() {
        return this.rel;
    }
}
