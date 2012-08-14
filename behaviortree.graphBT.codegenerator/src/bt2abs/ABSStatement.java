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
enum ABSStatementType{
    DECLARATION,ADDON,ASSIGNMENT,BLOCK,CALL,RETURN;
} 
class _ABSIf implements ABSBlock
{
    _ABSCondition cond;
    ArrayList<ABSStatement> arr = null;
    boolean isNot;
    _ABSIf(_ABSCondition c){
        this.cond = c;
    }
    _ABSIf(){
        cond = null;
    }

    @Override
    public void addStatement(ABSStatement a) {
        if(arr == null)
        {
            arr = new ArrayList<ABSStatement>();
        }
        arr.add(a);
    }
    
    @Override
    public String toString()
    {
        String temp="";
        temp+=(cond==null?"":"if"+"("+cond.toString()+")")+"\n{\n";
        for(int i = 0; i < arr.size(); i++)
        {
            temp+=arr.get(i).toString()+"\n";
        }
        temp+="}\n";
        return temp;
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
class _ABSIfGroup  extends ABSStatement 
{
    private ArrayList<_ABSIf> abs = new ArrayList<_ABSIf>();
    public _ABSIfGroup()
    {
        this(new ArrayList<_ABSIf>());
    }
    public void addCondition(_ABSIf ai)
    {
        abs.add(ai);
    }
    public _ABSIfGroup(ArrayList<_ABSIf> abs)
    {
        super(ABSStatementType.BLOCK,abs.toString());
        this.abs = abs;
    }
    @Override
    public String toString()
    {
        String temp="";
        if(abs.size()>0)
        {
            temp+=abs.get(0).toString()+"\n";
        }
        
        for(int i = 1; i < abs.size(); i++)
        {
            temp+="else "+abs.get(i).toString()+"\n";
            if(abs.get(i-1).cond==null)
            {
                break;
            }
        }
        return temp;
    }
}
class _ABSCondition{
    private ABSDeclarable var;
    private String val;
    private String c;
    public _ABSCondition(String tr)
    {
        c = tr;
    }
        
    public _ABSCondition(ABSDeclarable var)
    {
        this.var = var;
        this.val = null;
    }
    public _ABSCondition(ABSDeclarable var,String val)
    {
        this.var = var;
        this.val = val;
    }
    
    @Override
    public String toString()
    {
        return c;
    }
}
class _ABSWhile extends ABSStatement implements ABSBlock{
    private _ABSCondition cond;
    private ArrayList<ABSStatement> stmnts = new ArrayList<ABSStatement>();
    public _ABSWhile(_ABSCondition abs)
    {
        super(ABSStatementType.BLOCK,abs.toString());
        cond = abs;
    }
    
    public _ABSCondition getCondition()
    {
        return cond;
    }
    
    @Override
    public String toString()
    {
        String temp = "while("+cond.toString()+") {\n";
        for(int i = 0; i < stmnts.size();i++)
        {
        	if(stmnts.get(i).toString().length()>1)
            temp+=stmnts.get(i).toString()+"\n";
        }
        temp+="}";
        return temp;        
    }

    @Override
    public void addStatement(ABSStatement a) {
        stmnts.add(a);
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


public class ABSStatement {
    private ABSStatementType type;
    private String stmnt;
    public ABSStatement(ABSStatementType t, String stmt)
    {
        this.type = t;
        stmnt = stmt;
    }
    
    @Override
    public String toString()
    {
    	String str = stmnt;
    	System.out.println("hh "+str);
    	if(stmnt.length()>1)
        return stmnt+(stmnt.endsWith(";")?"":";")+"\n";
    	return "";
    }
}
