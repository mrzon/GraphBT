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
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Sequence#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Sequence#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getSequence()
 * @model abstract="true"
 * @generated
 */
public interface Sequence extends BehaviorTree
{
  /**
   * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.Node}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Steps</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getSequence_Steps()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Node> getSteps();

  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference.
   * @see #setChild(BehaviorTree)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getSequence_Child()
   * @model containment="true"
   * @generated
   */
  BehaviorTree getChild();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Sequence#getChild <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child</em>' containment reference.
   * @see #getChild()
   * @generated
   */
  void setChild(BehaviorTree value);

} // Sequence
