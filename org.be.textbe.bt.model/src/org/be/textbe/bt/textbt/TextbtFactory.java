/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage
 * @generated
 */
public interface TextbtFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TextbtFactory eINSTANCE = org.be.textbe.bt.textbt.impl.TextbtFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Text BT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text BT</em>'.
   * @generated
   */
  TextBT createTextBT();

  /**
   * Returns a new object of class '<em>Requirement List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement List</em>'.
   * @generated
   */
  RequirementList createRequirementList();

  /**
   * Returns a new object of class '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement</em>'.
   * @generated
   */
  Requirement createRequirement();

  /**
   * Returns a new object of class '<em>Component List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component List</em>'.
   * @generated
   */
  ComponentList createComponentList();

  /**
   * Returns a new object of class '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component</em>'.
   * @generated
   */
  Component createComponent();

  /**
   * Returns a new object of class '<em>Selection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection</em>'.
   * @generated
   */
  Selection createSelection();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard</em>'.
   * @generated
   */
  Guard createGuard();

  /**
   * Returns a new object of class '<em>Internal Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Internal Input</em>'.
   * @generated
   */
  InternalInput createInternalInput();

  /**
   * Returns a new object of class '<em>Internal Output</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Internal Output</em>'.
   * @generated
   */
  InternalOutput createInternalOutput();

  /**
   * Returns a new object of class '<em>External Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Input</em>'.
   * @generated
   */
  ExternalInput createExternalInput();

  /**
   * Returns a new object of class '<em>External Output</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Output</em>'.
   * @generated
   */
  ExternalOutput createExternalOutput();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  Node createNode();

  /**
   * Returns a new object of class '<em>Sequential Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequential Node</em>'.
   * @generated
   */
  SequentialNode createSequentialNode();

  /**
   * Returns a new object of class '<em>Atomic Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Node</em>'.
   * @generated
   */
  AtomicNode createAtomicNode();

  /**
   * Returns a new object of class '<em>Parallel Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parallel Block</em>'.
   * @generated
   */
  ParallelBlock createParallelBlock();

  /**
   * Returns a new object of class '<em>Alternative Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alternative Block</em>'.
   * @generated
   */
  AlternativeBlock createAlternativeBlock();

  /**
   * Returns a new object of class '<em>Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assertion</em>'.
   * @generated
   */
  Assertion createAssertion();

  /**
   * Returns a new object of class '<em>System Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System Component</em>'.
   * @generated
   */
  SystemComponent createSystemComponent();

  /**
   * Returns a new object of class '<em>Option List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Option List</em>'.
   * @generated
   */
  OptionList createOptionList();

  /**
   * Returns a new object of class '<em>Option</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Option</em>'.
   * @generated
   */
  Option createOption();

  /**
   * Returns a new object of class '<em>Behavior Tree</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Tree</em>'.
   * @generated
   */
  BehaviorTree createBehaviorTree();

  /**
   * Returns a new object of class '<em>Relational Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Behavior</em>'.
   * @generated
   */
  RelationalBehavior createRelationalBehavior();

  /**
   * Returns a new object of class '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation</em>'.
   * @generated
   */
  Relation createRelation();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TextbtPackage getTextbtPackage();

} //TextbtFactory
