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
 * A representation of the model object '<em><b>What</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.What#getObservation <em>Observation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getWhat()
 * @model
 * @generated
 */
public interface What extends FreeTextRelation
{
  /**
   * Returns the value of the '<em><b>Observation</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Observation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Observation</em>' attribute list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getWhat_Observation()
   * @model required="true"
   * @generated
   */
  EList<String> getObservation();

} // What
