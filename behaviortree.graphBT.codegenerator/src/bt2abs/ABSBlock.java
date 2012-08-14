/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

/**
 *
 * @author Emerson
 */
public interface ABSBlock {
    void addStatement(ABSStatement a);
    void isDeclared(ABSDeclarable a);
}
