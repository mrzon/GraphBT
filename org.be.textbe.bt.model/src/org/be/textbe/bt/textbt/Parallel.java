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
 * A representation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Called a Parallel Branch in the original documentation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Parallel#getProcesses <em>Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getParallel()
 * @model
 * @generated
 */
public interface Parallel extends Branch
{
  /**
   * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.BehaviorTree}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Processes</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getParallel_Processes()
   * @model containment="true" required="true"
   * @generated
   */
  EList<BehaviorTree> getProcesses();

} // Parallel
