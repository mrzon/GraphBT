/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.be.graphbt.common.ProjectUtil;

/**
 *
 * @author Emerson
 */
public class ABSForeign {
    private String absCode="";
    private String name="";
    private String javaCode="";/*
    public static ABSForeign IO = new ABSForeign("IO");
    public static ABSForeign MATH = new ABSForeign("Math");
    public static ABSForeign MOUSE = new ABSForeign("Mouse");
    public ABSForeign(String name) {
        this.name = name;
        if(name.equals("IO")||name.equals("Math")||name.equals("Mouse")) {
            BufferedReader f = null;
            try {
                if(name.equals("IO")) {
                    f = new BufferedReader(new FileReader(ProjectUtil.getSharedResource("files/template_abs/IO")));
                    javaCode = "IOImpl_fli";
                }
                else if(name.equals("Math")) {
                	f = new BufferedReader(new FileReader(ProjectUtil.getSharedResource("files/template_abs/Math")));
                    javaCode = "Math_fli";
                }else if(name.equals("Mouse")) {
                	f = new BufferedReader(new FileReader(ProjectUtil.getSharedResource("files/template_abs/Mouse")));
                    javaCode = "Mouse_fli";
                }
                String temp;
                temp=f.readLine();
                
                absCode += temp+"\n";

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
    }*/
    
    public ABSForeign(String name, String c) {
        this.name = name;
        absCode = c;
    }
    
    public ABSForeign() {
		// TODO Auto-generated constructor stub
	}


    public void setABSCode(String c) {
        absCode = c;
    }
    
    public void setJavaCode(String c) {
        javaCode = c;
    }
    
    public String getABSCode() {
        return absCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String str) {
    	name = str;
    }
    public String getJavaCode() {
        return javaCode;
    }
            
    @Override
    public String toString() {
        return absCode;
    }
}
