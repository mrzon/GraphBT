/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

/**
 *
 * @author Emerson
 */

public class ABSDataType {
    public static ABSDataType BOOL = new ABSDataType("Bool","False");
    private String type;
    private String defaultVal = "null";
    public static final ABSDataType UNIT = new ABSDataType("Unit");
    public static final ABSDataType INT = new ABSDataType("Int","0");
    public static final ABSDataType DATA = new ABSDataType("Int","0");
    public static final ABSDataType LIST = new ABSDataType("List","Nil",INT);
    public static final ABSDataType SET = new ABSDataType("Set","Nil");
    public static final ABSDataType STRING = new ABSDataType("String","\"\"");
    private ABSDataType gen = null;
    public ABSDataType(String type)
    {
        this.type = type;
    }
    public ABSDataType(String type, String def)
    {
        this.type = type;
        this.defaultVal = def;
    }
    public ABSDataType(String type, String def,ABSDataType p)
    {
        this.type = type;
        this.defaultVal = def;
        gen = p;
    }
    
    public String getName()
    {
        return type;
    }
    public String getDefaultValue()
    {
        return defaultVal;
    }
    public void setDefaultValue(String gg)
    {
        defaultVal = gg;
    }
    public void setGenericType(ABSDataType a)
    {
        gen = a;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(o instanceof ABSDataType)
        {
            return type.equals(((ABSDataType)o).getName());
        }
        return false;
    }
    @Override
    public String toString()
    {
        
        return type+(gen == null?"":"<"+gen.type+">");
    }
}
