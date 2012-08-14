/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import codegenerator.helper.Helper;

/**
 *
 * @author Emerson
 */
public class ABSForeign {
    private String in="",cl="";
    private String n="";
    private String ji="";
    public static ABSForeign IO = new ABSForeign("IO");
    public static ABSForeign MATH = new ABSForeign("Math");
    
    public ABSForeign(String name)
    {
        n = name;
        if(n.equals("IO")||n.equals("Math"))
        {
            BufferedReader f = null;
            try {
                if(n.equals("IO"))
                {
                    f = new BufferedReader(new InputStreamReader(Helper.getURL("lib\\template_abs\\IO").openStream()));
                    ji = "IOImpl_fli";
                }
                else if(n.equals("Math"))
                {
                    f = new BufferedReader(new InputStreamReader(Helper.getURL("lib\\template_abs\\Math").openStream()));
                    ji = "Math_fli";
                }
                String temp;
                temp=f.readLine();
                
                if(temp.equals("<interface>"))
                {
                    while((temp=f.readLine())!=null)
                    {
                        if(temp.equals("</interface>"))
                            break;
                        in+=temp+"\n";
                    }
                }
                while(!temp.equals("<class>"))
                {
                    temp=f.readLine();
                }
                if(temp.equals("<class>"))
                {
                    while((temp=f.readLine())!=null)
                    {
                        if(temp.equals("</class>"))
                            break;
                        cl+=temp+"\n";
                    }
                }

            } catch (Exception ex) {
                    Logger.getLogger(ABSForeign.class.getName()).log(Level.SEVERE, null, ex);
                } 
            finally {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(ABSForeign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ABSForeign(String name,String i, String c)
    {
        n = name;
        in = i;
        cl = c;
    }
    
    public void setInterfaceCode(String i)
    {
        in = i;
    }

    public void setClassCode(String c)
    {
        cl = c;
    }
    
    public void setJavaCode(String c)
    {
        ji = c;
    }
    
    public String getInterfaceCode()
    {
        return in;
    }
    public String getClassCode()
    {
        return cl;
    }
    public String getName()
    {
        return n;
    }
    
    public String getJavaCode()
    {
        return ji;
    }
            
    @Override
    public String toString()
    {
        return in+"\n\n"+cl;
    }
}
