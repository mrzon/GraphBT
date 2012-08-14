package bt.model;


public class BTBehaviorRelation{
    private BTBehaviorRelationType rel;
    private String cmpl="";
    private String com;
    

    public BTBehaviorRelation(String bt,String co,String c){
        this(Enum.valueOf(BTBehaviorRelationType.class,bt.toUpperCase()), co,c);
    }
    
    public BTBehaviorRelation(BTBehaviorRelationType relationType,String componentName,String complement){
        this.rel = relationType; this.com = componentName; this.cmpl = complement;
    }
    
    public BTBehaviorRelationType getRelationType()
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