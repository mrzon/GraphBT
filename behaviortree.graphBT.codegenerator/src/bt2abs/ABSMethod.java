/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;
import java.util.*;
/**
 *
 * @author Emerson
 */
public class ABSMethod implements ABSDeclarable{
    private ABSDataType type;
    private ArrayList <ABSParameter> params = new ArrayList <ABSParameter>();
    private String name;
    
    public ABSMethod(ABSDataType type, String name)
    {
        this.type = type;
        this.name = name;
        this.params = new ArrayList<ABSParameter>();
    }
    public ABSMethod(ABSDataType type, String name, ArrayList <ABSParameter> params)
    {
        this.type = type;
        this.name = name;
        this.params = params;
    }

    @Override
    public ABSDataType getDataType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public void addParam(ABSParameter par)
    {
        params.add(par);
    }
    
    public ABSParameter getParam(String ng)
    {
        for(int i = 0; i < params.size(); i++)
        {
            if(params.get(i).getName().equals(ng))
            {
                return params.get(i);
            }
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        String temp = getDataType().toString()+" "+getName()+"(";
        if(params.size()>0)
        {
            temp+=params.get(0);
        }
        for(int i = 1; i < params.size(); i++)
        {
            temp+=","+params.get(i);
        }
        temp+=")";
        return temp;
    }
}
