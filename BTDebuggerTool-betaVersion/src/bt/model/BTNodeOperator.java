package bt.model;

/**
 * Defines operator on Node
 * @author agung
 *
 */
public enum BTNodeOperator{
	/**
	 * REVERSION on Node appears <code>^</code>
	 */
    REVERSION("^"),
    
    /**
	 * GOTO on Node appears <code>=></code>
	 */
    GOTO("=>"),
    
    /**
     * SYNCRONIZATION on Node appears <code>=</code>
     */
    SYNCRONIZATION("="),
    
    /**
     * DEFAULT on Node appears empty 
     */
    DEFAULT("");
    
    
    private String operator="";
    
    BTNodeOperator(String operator)
    {
        this.operator = operator;
    }
    
    
    public static BTNodeOperator fromString(String str)
    {
        if(str!=null)
        {
            for (BTNodeOperator b : BTNodeOperator.values()) {
                if (str.equalsIgnoreCase(b.operator)) {
                    return b;
                }
            }
        }
        return null;
    }
    
    public String getOperator()
    {
        return operator;
    }
}