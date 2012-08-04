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
 * A representation of the model object '<em><b>Why</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Why#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getWhy()
 * @model
 * @generated
 */
public interface Why extends FreeTextRelation
{
  /**
   * Returns the value of the '<em><b>Reason</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reason</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reason</em>' attribute list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getWhy_Reason()
   * @model required="true"
   * @generated
   */
  EList<String> getReason();

} // Why
