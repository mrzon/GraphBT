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
public class ABSClass implements ABSBlock{
    private ArrayList<ABSInterface> ai = new ArrayList<ABSInterface>();
    private String name;
    private ArrayList<ABSMethodImplementation> methods = null;
    private ArrayList<ABSParameter> params = null;
    private Set<ABSVariable> vars = new HashSet<ABSVariable>() ;
    private String annotation;
    public ABSClass(ABSInterface ai)
    {
        this.ai.add(ai);
        if(ai.getMethods().size() > 0)
        {
            methods = new ArrayList<ABSMethodImplementation>();
        }
    }

    public ABSClass(ABSInterface ai, String n) {
        this.ai.add(ai);
        this.name = n;
    }
    public void setAnnotation(String a)
    {
        annotation = a;
    }
    
    public String getAnnotation()
    {
        return annotation;
    }
    
    public ArrayList<ABSInterface> getInterfaces()
    {
        return ai;
    }
    
    public String getClassName()
    {
        return name;
    }
    
    public void addParameter(ABSParameter par)
    {
        if(params == null)
        {
            params = new ArrayList<ABSParameter>();
        }
        params.add(par);
    }
    public void addMethodImplementation(ABSMethodImplementation mi)
    {
        if(methods == null)
        {
            methods = new ArrayList<ABSMethodImplementation>();
        }
        methods.add(mi);
    }
    
    public void addVariable(ABSVariable a)
    {
        vars.add(a);
    }
    @Override
    public String toString()
    {
        String temp="";
        if(annotation != null)
        temp = "["+annotation+"]\n";
        temp+="class "+name+"(";
        if(params != null && params.size() > 0)
        {
            temp+=params.get(0);
            for(int i = 1; i < params.size(); i++)
            {
                temp += ","+params.get(i).toString();
            }
        }
        
        
        temp+=") implements "+ai.get(0).getName();
        for(int i = 1; i < ai.size(); i++)
        {
            temp += ","+ai.get(i).getName();
        }
        temp+=" {\n";
        if(vars != null)
        {
            Iterator<ABSVariable> i = vars.iterator();
            while(i.hasNext())
            {
                temp += i.next().toString()+"\n";
            }
        }
        temp+="\n";
        if(methods != null)
        {
            for(int i = 0; i < methods.size(); i++)
            {
                temp += methods.get(i).toString()+"\n\n";
            }
        }
        temp+="}";
        return temp;
    }
    public String initialize(String varName)
    {
        return ai.get(0).getName()+" "+varName+" = new "+getClassName()+"()";
    }
    
    public String initialize(String varName,String[]par)
    {
        String temp = "";
        if(par.length > 0)
            temp = par[0];
        for(int i = 1; i < par.length; i++)
        {
            temp+=","+par[i];
        }
        return ai.get(0).getName()+" "+varName+" = new "+getClassName()+"("+temp+");";
    }
    
    public void addInterface(ABSInterface ai)
    {
        this.ai.add(ai);
    }

    @Override
    public void addStatement(ABSStatement a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    Set<ABSVariable> getVariables() {
        return vars;
    }

    ArrayList<ABSParameter> getParameters() {
        return params;
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
