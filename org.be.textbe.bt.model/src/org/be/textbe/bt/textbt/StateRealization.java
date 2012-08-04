/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.StateRealization#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getStateRealization()
 * @model
 * @generated
 */
public interface StateRealization extends Behavior, NamedBehavior
{

  /**
   * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifier</em>' attribute.
   * @see #setQualifier(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getStateRealization_Qualifier()
   * @model
   * @generated
   */
  String getQualifier();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.StateRealization#getQualifier <em>Qualifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualifier</em>' attribute.
   * @see #getQualifier()
   * @generated
   */
  void setQualifier(String value);
} // StateRealization
