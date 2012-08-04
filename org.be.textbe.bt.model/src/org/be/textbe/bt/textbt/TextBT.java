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
 * A representation of the model object '<em><b>Text BT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.TextBT#getOptions <em>Options</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.TextBT#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.TextBT#getComponents <em>Components</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.TextBT#getBehaviorTree <em>Behavior Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getTextBT()
 * @model
 * @generated
 */
public interface TextBT extends EObject
{
  /**
   * Returns the value of the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Options</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Options</em>' containment reference.
   * @see #setOptions(OptionList)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTextBT_Options()
   * @model containment="true"
   * @generated
   */
  OptionList getOptions();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.TextBT#getOptions <em>Options</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Options</em>' containment reference.
   * @see #getOptions()
   * @generated
   */
  void setOptions(OptionList value);

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference.
   * @see #setRequirements(RequirementList)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTextBT_Requirements()
   * @model containment="true"
   * @generated
   */
  RequirementList getRequirements();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.TextBT#getRequirements <em>Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirements</em>' containment reference.
   * @see #getRequirements()
   * @generated
   */
  void setRequirements(RequirementList value);

  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference.
   * @see #setComponents(ComponentList)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTextBT_Components()
   * @model containment="true" required="true"
   * @generated
   */
  ComponentList getComponents();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.TextBT#getComponents <em>Components</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Components</em>' containment reference.
   * @see #getComponents()
   * @generated
   */
  void setComponents(ComponentList value);

  /**
   * Returns the value of the '<em><b>Behavior Tree</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior Tree</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior Tree</em>' containment reference.
   * @see #setBehaviorTree(BehaviorTree)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getTextBT_BehaviorTree()
   * @model containment="true" required="true"
   * @generated
   */
  BehaviorTree getBehaviorTree();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.TextBT#getBehaviorTree <em>Behavior Tree</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Tree</em>' containment reference.
   * @see #getBehaviorTree()
   * @generated
   */
  void setBehaviorTree(BehaviorTree value);

} // TextBT
