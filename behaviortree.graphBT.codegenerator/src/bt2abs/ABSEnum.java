/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

import java.util.ArrayList;

/**
 *
 * @author Emerson
 */
public class ABSEnum extends ABSDataType{
    private ArrayList<String> vals = new ArrayList<String>();
    private String n;
    public ABSEnum(String name)
    {
        super(name);
        n = name;
        setDefaultValue(name+"_Default");
    }
    
    public void addValue(String s)
    {
        vals.add(s);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o != null && o instanceof ABSEnum)
        {
            return hashCode() == ((ABSEnum)o).hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return n.hashCode();
    }
    @Override
    public String toString()
    {
        String temp = "data "+getName() + " = ";
        for(int i = 0; i < vals.size(); i++)
        {
            temp+=vals.get(i)+" | ";
        }
            
        temp += getDefaultValue()+";";
        return temp;
    }
    

} 
