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
 * A representation of the model object '<em><b>Traceability Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.TraceabilityLink#getStatus <em>Status</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.TraceabilityLink#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getTraceabilityLink()
 * @model
 * @generated
 */
public interface TraceabilityLink extends EObject
{
  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * The literals are from the enumeration {@link org.be.textbe.bt.textbt.TraceabilityStatus}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see org.be.textbe.bt.textbt.TraceabilityStatus
   * @see #setStatus(TraceabilityStatus)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTraceabilityLink_Status()
   * @model
   * @generated
   */
  TraceabilityStatus getStatus();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.TraceabilityLink#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see org.be.textbe.bt.textbt.TraceabilityStatus
   * @see #getStatus()
   * @generated
   */
  void setStatus(TraceabilityStatus value);

  /**
   * Returns the value of the '<em><b>Requirement</b></em>' reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement</em>' reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTraceabilityLink_Requirement()
   * @model required="true"
   * @generated
   */
  EList<Requirement> getRequirement();

} // TraceabilityLink
