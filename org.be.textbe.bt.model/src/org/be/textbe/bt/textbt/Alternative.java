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
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Alternative#getChoices <em>Choices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends Branch
{
  /**
   * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.BehaviorTree}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Choices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Choices</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAlternative_Choices()
   * @model containment="true" required="true"
   * @generated
   */
  EList<BehaviorTree> getChoices();

} // Alternative
