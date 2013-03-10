/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Emerson
 */
public class ABSMainBlock implements ABSBlock{
    private ArrayList<ABSStatement> st = new ArrayList<ABSStatement>();
    private Set<String> dV = new HashSet<String>();
    ABSMainBlock() {
        dV.add("i");
    }
    @Override
    public void addStatement(ABSStatement as) {
        st.add(as);
    }
    
    public ArrayList<ABSStatement> getStatements() {
        return st;
    }
    
    @Override
    public String toString() {
        String temp = "{\n";
        for(int i = 0; i < st.size(); i++) {
            temp+=st.get(i).toString();
        }
        temp+="}";
        
        return temp;
    }
    
    public void addDeclaredVariable(String var) {
        dV.add(var);
    }
    
    public boolean isDeclared(String var) {
        return dV.contains(var);
    }

    @Override
    public void isDeclared(ABSDeclarable a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
