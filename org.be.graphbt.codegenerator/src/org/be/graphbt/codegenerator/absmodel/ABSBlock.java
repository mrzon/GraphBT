/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;

/**
 *
 * @author Emerson
 */
public interface ABSBlock {
	public void addStatement(int line, ABSStatement as);
    void addStatement(ABSStatement a);
    boolean isDeclared(ABSDeclarable a);
}
