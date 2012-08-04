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
 * A representation of the model object '<em><b>Behavior Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.BehaviorTree#getRootNode <em>Root Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getBehaviorTree()
 * @model
 * @generated
 */
public interface BehaviorTree extends EObject
{

  /**
   * Returns the value of the '<em><b>Root Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root Node</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root Node</em>' containment reference.
   * @see #setRootNode(Node)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getBehaviorTree_RootNode()
   * @model containment="true" required="true"
   * @generated
   */
  Node getRootNode();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.BehaviorTree#getRootNode <em>Root Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root Node</em>' containment reference.
   * @see #getRootNode()
   * @generated
   */
  void setRootNode(Node value);
} // BehaviorTree
