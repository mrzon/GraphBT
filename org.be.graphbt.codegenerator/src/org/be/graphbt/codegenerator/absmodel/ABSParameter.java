/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

/**
 *
 * @author Emerson
 */
public class ABSParameter implements ABSDeclarable{
    private ABSDataType type;
    private String name;
    private String def;
    
    public ABSParameter(ABSDataType type,String name) {
        this.type = type;
        this.name = name;
    }

    ABSParameter(ABSDataType dataType, String string, String deft) {
        this(dataType,string);
        def=deft;
    }
    
    @Override
    public ABSDataType getDataType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getDataType().getName()+" "+getName();
    }
    
    public String getDefault() {
        return def;
    }
    
}
