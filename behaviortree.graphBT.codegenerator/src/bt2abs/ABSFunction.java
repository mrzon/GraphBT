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
public class ABSFunction implements ABSBlock{
    
    private String definition;
    private String body;
    public final ABSFunction GETVALUE = new ABSFunction("getValue");
    private ArrayList<ABSStatement> st = new ArrayList<ABSStatement>();

    private ABSFunction(String string) {
        if(string.equals("getValue"))
        {
            definition = "def T getValue<T>(Data<T> d)";
            body = "	case(d){\nVal(a) => a;\n};";
        }
    }
    
    public void setDefinition(String str)
    {
        definition = str;
    }
    
    public void setBody(String str)
    {
        body = str;
    }
    
    @Override
    public void addStatement(ABSStatement a) {
        st.add(a);
    }
     
    @Override
    public String toString()
    {
        String temp = definition+" = \n";
        
        temp+=body+";";
        return temp;
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
