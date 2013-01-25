/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

/**
 *
 * @author Emerson
 */
public class ABSLibrary {
    private String name;
    public ABSLibrary(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "import "+name+";";
    }
}
