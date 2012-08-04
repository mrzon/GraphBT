/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Behavior#getRef <em>Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Behavior#getVal <em>Val</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Behavior#getRelations <em>Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getBehavior()
 * @model abstract="true"
 * @generated
 */
public interface Behavior extends AbstractBehavior
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getBehavior_Ref()
   * @model required="true"
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Behavior#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see #setVal(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getBehavior_Val()
   * @model required="true"
   * @generated
   */
  String getVal();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Behavior#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(String value);

  /**
   * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.Relation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relations</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getBehavior_Relations()
   * @model containment="true"
   * @generated
   */
  EList<Relation> getRelations();

} // Behavior
