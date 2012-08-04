/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Requirement#getRef <em>Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Requirement#getVal <em>Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRequirement_Ref()
   * @model required="true"
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Requirement#getRef <em>Ref</em>}' attribute.
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRequirement_Val()
   * @model required="true"
   * @generated
   */
  String getVal();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Requirement#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(String value);

} // Requirement
