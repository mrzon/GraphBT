/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Component#getRef <em>Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Component#getVal <em>Val</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Component#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Component#getQuantifier <em>Quantifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getComponent_Ref()
   * @model required="true"
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Component#getRef <em>Ref</em>}' attribute.
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getComponent_Val()
   * @model required="true"
   * @generated
   */
  String getVal();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Component#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(String value);

  /**
   * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.AbstractBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behaviors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviors</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getComponent_Behaviors()
   * @model containment="true"
   * @generated
   */
  EList<AbstractBehavior> getBehaviors();

  /**
   * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quantifier</em>' attribute.
   * @see #setQuantifier(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getComponent_Quantifier()
   * @model
   * @generated
   */
  String getQuantifier();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Component#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see #getQuantifier()
   * @generated
   */
  void setQuantifier(String value);

} // Component
