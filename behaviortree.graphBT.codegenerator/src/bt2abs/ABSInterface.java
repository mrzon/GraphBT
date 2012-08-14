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
public class ABSInterface extends ABSDataType implements ABSBlock{
    
    private Set<ABSMethod> arr;
    private String name;
    private ABSInterface ex = null;
    public ABSInterface(String n)
    {
        super(n);
        name = n;
        arr = new HashSet<ABSMethod>();
    }
    public ABSInterface(ABSInterface ex, String n)
    {
        super(n);
        name = n;
        this.ex = ex;
        arr = new HashSet<ABSMethod>();
    }
    public void add(ABSMethod a)
    {
        arr.add(a);
    }

    public Set<ABSMethod> getMethods() {
        return arr;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    public void setParent(ABSInterface e)
    {
        ex = e;
    }
    
    @Override
    public String toString()
    {
        String temp = "interface "+name+(ex==null?"":" extends "+ex.getName())+"{\n";
        Iterator <ABSMethod> i = arr.iterator();
        while(i.hasNext())    
        {
            temp+=i.next().toString()+";\n";
        }
        temp+="}";
        return temp;
    }

    @Override
    public void addStatement(ABSStatement a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
