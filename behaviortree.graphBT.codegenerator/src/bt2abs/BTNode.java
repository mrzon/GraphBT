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
enum BTNodeType{
    ATOMICNODE,PARALLELBLOCK,SELECTIONBLOCK,SEQUENTIALNODE
}

enum BTNodeOp{
    REVERSION("^"),GOTO("=>"),SYNCRONIZATION("="),DEFAULT("");
    private String op="";
    BTNodeOp(String op)
    {
        this.op = op;
    }
    public static BTNodeOp fromString(String str)
    {
        if(str!=null)
        {
            for (BTNodeOp b : BTNodeOp.values()) {
                if (str.equalsIgnoreCase(b.op)) {
                    return b;
                }
            }
        }
        return null;
    }
    public String getOp()
    {
        return op;
    }
}
public class BTNode {
    private BTNodeOp op = BTNodeOp.DEFAULT; 
    private BTNodeType type = BTNodeType.SEQUENTIALNODE; 
    private BTComponent coRef = null;
    private BTBehavior beRef = null;
    private ArrayList<BTNode> child = new ArrayList<BTNode>();
    private String pc = "0";
    public BTNode(BTComponent c, BTBehavior b)
    {
        coRef = c;
        beRef = b;
    }
    
    public BTNode(String t, String f, BTComponent c, BTBehavior b)
    {
        coRef = c;
        beRef = b;
        //System.out.println(t);
        this.type = (t==null)?BTNodeType.SEQUENTIALNODE:Enum.valueOf(BTNodeType.class, (t.substring(t.indexOf(':')+1, t.length())).toUpperCase());
        op = (f==null)? BTNodeOp.DEFAULT:BTNodeOp.fromString(f);
    }
    
    public BTNode(String t)
    {
        //System.out.println(t);
        type=Enum.valueOf(BTNodeType.class, (t.substring(t.indexOf(':')+1, t.length())).toUpperCase());
    }
    
    public void addChild(BTNode n)
    {
        child.add(n);
    }
    
    public ArrayList<BTNode> getChilds()
    {
        return this.child;
    }
    
    public BTNodeOp getOp()
    {
        return op;
    }
    public BTNodeType getType()
    {
        return type;
    }
    
    public BTComponent getComponent()
    {
        return this.coRef;
    }
    
    
    public BTBehavior getBehavior()
    {
        return this.beRef;
    }
    
    public void setOperator(String s)
    {
        op = BTNodeOp.fromString(s);
    }
    
    public void setPC(String s)
    {
        pc = s;
    }
    
    @Override
    public String toString()
    {
        if(this.type != null && (coRef != null && beRef != null && pc != null))
        {
            return this.pc+" "+(this.type==BTNodeType.PARALLELBLOCK||this.type==BTNodeType.SELECTIONBLOCK?this.type.toString():" "+this.coRef.getName()+" "+this.beRef.toString()+" "+(this.op==null?"":this.op.getOp()));
        }
        return " ";
    }

    public String getPC() {
        return pc;
    }
}
