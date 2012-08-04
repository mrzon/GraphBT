/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtFactory
 * @model kind="package"
 * @generated
 */
public interface TextbtPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "textbt";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://org.be.textbe/textbt";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "textbt";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TextbtPackage eINSTANCE = org.be.textbe.bt.textbt.impl.TextbtPackageImpl.init();

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.TextBTImpl <em>Text BT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.TextBTImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getTextBT()
   * @generated
   */
  int TEXT_BT = 0;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BT__OPTIONS = 0;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BT__REQUIREMENTS = 1;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BT__COMPONENTS = 2;

  /**
   * The feature id for the '<em><b>Behavior Tree</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BT__BEHAVIOR_TREE = 3;

  /**
   * The number of structural features of the '<em>Text BT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.RequirementListImpl <em>Requirement List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.RequirementListImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRequirementList()
   * @generated
   */
  int REQUIREMENT_LIST = 1;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_LIST__REQUIREMENTS = 0;

  /**
   * The number of structural features of the '<em>Requirement List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.RequirementImpl <em>Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.RequirementImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRequirement()
   * @generated
   */
  int REQUIREMENT = 2;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REF = 0;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__VAL = 1;

  /**
   * The number of structural features of the '<em>Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.ComponentListImpl <em>Component List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.ComponentListImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getComponentList()
   * @generated
   */
  int COMPONENT_LIST = 3;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_LIST__COMPONENTS = 0;

  /**
   * The number of structural features of the '<em>Component List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.ComponentImpl <em>Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.ComponentImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getComponent()
   * @generated
   */
  int COMPONENT = 4;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__REF = 0;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__VAL = 1;

  /**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__BEHAVIORS = 2;

  /**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__QUANTIFIER = 3;

  /**
   * The number of structural features of the '<em>Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.BehaviorImpl <em>Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.BehaviorImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getBehavior()
   * @generated
   */
  int BEHAVIOR = 12;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.StateImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getState()
   * @generated
   */
  int STATE = 13;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.SelectionImpl <em>Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.SelectionImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSelection()
   * @generated
   */
  int SELECTION = 14;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.EventImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 15;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.GuardImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 16;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.InternalInputImpl <em>Internal Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.InternalInputImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getInternalInput()
   * @generated
   */
  int INTERNAL_INPUT = 17;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.InternalOutputImpl <em>Internal Output</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.InternalOutputImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getInternalOutput()
   * @generated
   */
  int INTERNAL_OUTPUT = 18;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.ExternalInputImpl <em>External Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.ExternalInputImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getExternalInput()
   * @generated
   */
  int EXTERNAL_INPUT = 19;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.ExternalOutputImpl <em>External Output</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.ExternalOutputImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getExternalOutput()
   * @generated
   */
  int EXTERNAL_OUTPUT = 20;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.NodeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getNode()
   * @generated
   */
  int NODE = 25;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.SequentialNodeImpl <em>Sequential Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.SequentialNodeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSequentialNode()
   * @generated
   */
  int SEQUENTIAL_NODE = 26;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AtomicNodeImpl <em>Atomic Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AtomicNodeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAtomicNode()
   * @generated
   */
  int ATOMIC_NODE = 27;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.ParallelBlockImpl <em>Parallel Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.ParallelBlockImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getParallelBlock()
   * @generated
   */
  int PARALLEL_BLOCK = 28;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AlternativeBlockImpl <em>Alternative Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AlternativeBlockImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAlternativeBlock()
   * @generated
   */
  int ALTERNATIVE_BLOCK = 29;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.FiveWs <em>Five Ws</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.FiveWs
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getFiveWs()
   * @generated
   */
  int FIVE_WS = 30;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.Validity <em>Validity</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.Validity
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getValidity()
   * @generated
   */
  int VALIDITY = 31;

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.TextBT <em>Text BT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text BT</em>'.
   * @see org.be.textbe.bt.textbt.TextBT
   * @generated
   */
  EClass getTextBT();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.TextBT#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Options</em>'.
   * @see org.be.textbe.bt.textbt.TextBT#getOptions()
   * @see #getTextBT()
   * @generated
   */
  EReference getTextBT_Options();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.TextBT#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirements</em>'.
   * @see org.be.textbe.bt.textbt.TextBT#getRequirements()
   * @see #getTextBT()
   * @generated
   */
  EReference getTextBT_Requirements();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.TextBT#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Components</em>'.
   * @see org.be.textbe.bt.textbt.TextBT#getComponents()
   * @see #getTextBT()
   * @generated
   */
  EReference getTextBT_Components();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.TextBT#getBehaviorTree <em>Behavior Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Behavior Tree</em>'.
   * @see org.be.textbe.bt.textbt.TextBT#getBehaviorTree()
   * @see #getTextBT()
   * @generated
   */
  EReference getTextBT_BehaviorTree();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.RequirementList <em>Requirement List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement List</em>'.
   * @see org.be.textbe.bt.textbt.RequirementList
   * @generated
   */
  EClass getRequirementList();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.RequirementList#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirements</em>'.
   * @see org.be.textbe.bt.textbt.RequirementList#getRequirements()
   * @see #getRequirementList()
   * @generated
   */
  EReference getRequirementList_Requirements();

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.BehaviorTreeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getBehaviorTree()
   * @generated
   */
  int BEHAVIOR_TREE = 8;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AbstractBehaviorImpl <em>Abstract Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AbstractBehaviorImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBehavior()
   * @generated
   */
  int ABSTRACT_BEHAVIOR = 9;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.RelationalBehaviorImpl <em>Relational Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.RelationalBehaviorImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRelationalBehavior()
   * @generated
   */
  int RELATIONAL_BEHAVIOR = 10;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AssertionImpl <em>Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AssertionImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAssertion()
   * @generated
   */
  int ASSERTION = 21;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AbstractBlockOrNodeImpl <em>Abstract Block Or Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AbstractBlockOrNodeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBlockOrNode()
   * @generated
   */
  int ABSTRACT_BLOCK_OR_NODE = 22;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AbstractBlockImpl <em>Abstract Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AbstractBlockImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBlock()
   * @generated
   */
  int ABSTRACT_BLOCK = 23;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.AbstractNodeImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractNode()
   * @generated
   */
  int ABSTRACT_NODE = 24;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.RelationImpl <em>Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.RelationImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRelation()
   * @generated
   */
  int RELATION = 11;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.SystemComponentImpl <em>System Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.SystemComponentImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSystemComponent()
   * @generated
   */
  int SYSTEM_COMPONENT = 5;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_COMPONENT__REF = COMPONENT__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_COMPONENT__VAL = COMPONENT__VAL;

  /**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_COMPONENT__BEHAVIORS = COMPONENT__BEHAVIORS;

  /**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_COMPONENT__QUANTIFIER = COMPONENT__QUANTIFIER;

  /**
   * The number of structural features of the '<em>System Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.OptionListImpl <em>Option List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.OptionListImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getOptionList()
   * @generated
   */
  int OPTION_LIST = 6;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_LIST__OPTIONS = 0;

  /**
   * The number of structural features of the '<em>Option List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.be.textbe.bt.textbt.impl.OptionImpl <em>Option</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.be.textbe.bt.textbt.impl.OptionImpl
   * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getOption()
   * @generated
   */
  int OPTION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION__VALUE = 1;

  /**
   * The number of structural features of the '<em>Option</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPTION_FEATURE_COUNT = 2;

  /**
   * The feature id for the '<em><b>Root Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TREE__ROOT_NODE = 0;

  /**
   * The number of structural features of the '<em>Behavior Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TREE_FEATURE_COUNT = 1;

  /**
   * The number of structural features of the '<em>Abstract Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BEHAVIOR_FEATURE_COUNT = 0;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_BEHAVIOR__BEHAVIOR = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_BEHAVIOR__RELATIONS = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relational Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_BEHAVIOR_FEATURE_COUNT = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Question</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__QUESTION = 0;

  /**
   * The feature id for the '<em><b>Preposition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__PREPOSITION = 1;

  /**
   * The feature id for the '<em><b>Component Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__COMPONENT_REF = 2;

  /**
   * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__BEHAVIOR_REF = 3;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__LEVEL = 4;

  /**
   * The feature id for the '<em><b>Component Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__COMPONENT_LEVEL = 5;

  /**
   * The feature id for the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__COMPONENT_SET = 6;

  /**
   * The feature id for the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__MCI = 7;

  /**
   * The number of structural features of the '<em>Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_FEATURE_COUNT = 8;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__REF = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__VAL = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR__RELATIONS = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_FEATURE_COUNT = ABSTRACT_BEHAVIOR_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_INPUT__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_INPUT__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_INPUT__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Internal Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_INPUT_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_OUTPUT__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_OUTPUT__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_OUTPUT__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Internal Output</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_OUTPUT_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_INPUT__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_INPUT__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_INPUT__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>External Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_INPUT_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OUTPUT__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OUTPUT__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OUTPUT__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>External Output</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_OUTPUT_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__REF = BEHAVIOR__REF;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__VAL = BEHAVIOR__VAL;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__RELATIONS = BEHAVIOR__RELATIONS;

  /**
   * The number of structural features of the '<em>Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Block Or Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BLOCK_OR_NODE_FEATURE_COUNT = 0;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BLOCK__CHILD_NODE = ABSTRACT_BLOCK_OR_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BLOCK_FEATURE_COUNT = ABSTRACT_BLOCK_OR_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Component Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__COMPONENT_REF = 0;

  /**
   * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__BEHAVIOR_REF = 1;

  /**
   * The feature id for the '<em><b>Requirement Ref</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__REQUIREMENT_REF = 2;

  /**
   * The feature id for the '<em><b>Traceability Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__TRACEABILITY_STATUS = 3;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__LABEL = 4;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__OPERATOR = 5;

  /**
   * The feature id for the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__COMPONENT_SET = 6;

  /**
   * The feature id for the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE__MCI = 7;

  /**
   * The number of structural features of the '<em>Abstract Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NODE_FEATURE_COUNT = 8;

  /**
   * The feature id for the '<em><b>Component Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__COMPONENT_REF = ABSTRACT_NODE__COMPONENT_REF;

  /**
   * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__BEHAVIOR_REF = ABSTRACT_NODE__BEHAVIOR_REF;

  /**
   * The feature id for the '<em><b>Requirement Ref</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__REQUIREMENT_REF = ABSTRACT_NODE__REQUIREMENT_REF;

  /**
   * The feature id for the '<em><b>Traceability Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__TRACEABILITY_STATUS = ABSTRACT_NODE__TRACEABILITY_STATUS;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__LABEL = ABSTRACT_NODE__LABEL;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__OPERATOR = ABSTRACT_NODE__OPERATOR;

  /**
   * The feature id for the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__COMPONENT_SET = ABSTRACT_NODE__COMPONENT_SET;

  /**
   * The feature id for the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__MCI = ABSTRACT_NODE__MCI;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__CHILD_NODE = ABSTRACT_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Component Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__COMPONENT_REF = ABSTRACT_NODE__COMPONENT_REF;

  /**
   * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__BEHAVIOR_REF = ABSTRACT_NODE__BEHAVIOR_REF;

  /**
   * The feature id for the '<em><b>Requirement Ref</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__REQUIREMENT_REF = ABSTRACT_NODE__REQUIREMENT_REF;

  /**
   * The feature id for the '<em><b>Traceability Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__TRACEABILITY_STATUS = ABSTRACT_NODE__TRACEABILITY_STATUS;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__LABEL = ABSTRACT_NODE__LABEL;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__OPERATOR = ABSTRACT_NODE__OPERATOR;

  /**
   * The feature id for the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__COMPONENT_SET = ABSTRACT_NODE__COMPONENT_SET;

  /**
   * The feature id for the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__MCI = ABSTRACT_NODE__MCI;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE__CHILD_NODE = ABSTRACT_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sequential Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Component Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__COMPONENT_REF = ABSTRACT_NODE__COMPONENT_REF;

  /**
   * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__BEHAVIOR_REF = ABSTRACT_NODE__BEHAVIOR_REF;

  /**
   * The feature id for the '<em><b>Requirement Ref</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__REQUIREMENT_REF = ABSTRACT_NODE__REQUIREMENT_REF;

  /**
   * The feature id for the '<em><b>Traceability Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__TRACEABILITY_STATUS = ABSTRACT_NODE__TRACEABILITY_STATUS;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__LABEL = ABSTRACT_NODE__LABEL;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__OPERATOR = ABSTRACT_NODE__OPERATOR;

  /**
   * The feature id for the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__COMPONENT_SET = ABSTRACT_NODE__COMPONENT_SET;

  /**
   * The feature id for the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__MCI = ABSTRACT_NODE__MCI;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE__CHILD_NODE = ABSTRACT_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atomic Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARALLEL_BLOCK__CHILD_NODE = ABSTRACT_BLOCK__CHILD_NODE;

  /**
   * The number of structural features of the '<em>Parallel Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARALLEL_BLOCK_FEATURE_COUNT = ABSTRACT_BLOCK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Child Node</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE_BLOCK__CHILD_NODE = ABSTRACT_BLOCK__CHILD_NODE;

  /**
   * The number of structural features of the '<em>Alternative Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE_BLOCK_FEATURE_COUNT = ABSTRACT_BLOCK_FEATURE_COUNT + 0;

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Requirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement</em>'.
   * @see org.be.textbe.bt.textbt.Requirement
   * @generated
   */
  EClass getRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Requirement#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.be.textbe.bt.textbt.Requirement#getRef()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Requirement#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.be.textbe.bt.textbt.Requirement#getVal()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_Val();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.ComponentList <em>Component List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component List</em>'.
   * @see org.be.textbe.bt.textbt.ComponentList
   * @generated
   */
  EClass getComponentList();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.ComponentList#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Components</em>'.
   * @see org.be.textbe.bt.textbt.ComponentList#getComponents()
   * @see #getComponentList()
   * @generated
   */
  EReference getComponentList_Components();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component</em>'.
   * @see org.be.textbe.bt.textbt.Component
   * @generated
   */
  EClass getComponent();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Component#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.be.textbe.bt.textbt.Component#getRef()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Component#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.be.textbe.bt.textbt.Component#getVal()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Val();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.Component#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behaviors</em>'.
   * @see org.be.textbe.bt.textbt.Component#getBehaviors()
   * @see #getComponent()
   * @generated
   */
  EReference getComponent_Behaviors();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Component#getQuantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quantifier</em>'.
   * @see org.be.textbe.bt.textbt.Component#getQuantifier()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Quantifier();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Behavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior</em>'.
   * @see org.be.textbe.bt.textbt.Behavior
   * @generated
   */
  EClass getBehavior();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Behavior#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.be.textbe.bt.textbt.Behavior#getRef()
   * @see #getBehavior()
   * @generated
   */
  EAttribute getBehavior_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Behavior#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.be.textbe.bt.textbt.Behavior#getVal()
   * @see #getBehavior()
   * @generated
   */
  EAttribute getBehavior_Val();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.Behavior#getRelations <em>Relations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relations</em>'.
   * @see org.be.textbe.bt.textbt.Behavior#getRelations()
   * @see #getBehavior()
   * @generated
   */
  EReference getBehavior_Relations();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.be.textbe.bt.textbt.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Selection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection</em>'.
   * @see org.be.textbe.bt.textbt.Selection
   * @generated
   */
  EClass getSelection();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see org.be.textbe.bt.textbt.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see org.be.textbe.bt.textbt.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.InternalInput <em>Internal Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Internal Input</em>'.
   * @see org.be.textbe.bt.textbt.InternalInput
   * @generated
   */
  EClass getInternalInput();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.InternalOutput <em>Internal Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Internal Output</em>'.
   * @see org.be.textbe.bt.textbt.InternalOutput
   * @generated
   */
  EClass getInternalOutput();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.ExternalInput <em>External Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Input</em>'.
   * @see org.be.textbe.bt.textbt.ExternalInput
   * @generated
   */
  EClass getExternalInput();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.ExternalOutput <em>External Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Output</em>'.
   * @see org.be.textbe.bt.textbt.ExternalOutput
   * @generated
   */
  EClass getExternalOutput();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see org.be.textbe.bt.textbt.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.Node#getChildNode <em>Child Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child Node</em>'.
   * @see org.be.textbe.bt.textbt.Node#getChildNode()
   * @see #getNode()
   * @generated
   */
  EReference getNode_ChildNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.SequentialNode <em>Sequential Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequential Node</em>'.
   * @see org.be.textbe.bt.textbt.SequentialNode
   * @generated
   */
  EClass getSequentialNode();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.SequentialNode#getChildNode <em>Child Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child Node</em>'.
   * @see org.be.textbe.bt.textbt.SequentialNode#getChildNode()
   * @see #getSequentialNode()
   * @generated
   */
  EReference getSequentialNode_ChildNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AtomicNode <em>Atomic Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Node</em>'.
   * @see org.be.textbe.bt.textbt.AtomicNode
   * @generated
   */
  EClass getAtomicNode();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.AtomicNode#getChildNode <em>Child Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child Node</em>'.
   * @see org.be.textbe.bt.textbt.AtomicNode#getChildNode()
   * @see #getAtomicNode()
   * @generated
   */
  EReference getAtomicNode_ChildNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.ParallelBlock <em>Parallel Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parallel Block</em>'.
   * @see org.be.textbe.bt.textbt.ParallelBlock
   * @generated
   */
  EClass getParallelBlock();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AlternativeBlock <em>Alternative Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternative Block</em>'.
   * @see org.be.textbe.bt.textbt.AlternativeBlock
   * @generated
   */
  EClass getAlternativeBlock();

  /**
   * Returns the meta object for enum '{@link org.be.textbe.bt.textbt.FiveWs <em>Five Ws</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Five Ws</em>'.
   * @see org.be.textbe.bt.textbt.FiveWs
   * @generated
   */
  EEnum getFiveWs();

  /**
   * Returns the meta object for enum '{@link org.be.textbe.bt.textbt.Validity <em>Validity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Validity</em>'.
   * @see org.be.textbe.bt.textbt.Validity
   * @generated
   */
  EEnum getValidity();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.BehaviorTree <em>Behavior Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Tree</em>'.
   * @see org.be.textbe.bt.textbt.BehaviorTree
   * @generated
   */
  EClass getBehaviorTree();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.BehaviorTree#getRootNode <em>Root Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root Node</em>'.
   * @see org.be.textbe.bt.textbt.BehaviorTree#getRootNode()
   * @see #getBehaviorTree()
   * @generated
   */
  EReference getBehaviorTree_RootNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AbstractBehavior <em>Abstract Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Behavior</em>'.
   * @see org.be.textbe.bt.textbt.AbstractBehavior
   * @generated
   */
  EClass getAbstractBehavior();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.RelationalBehavior <em>Relational Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Behavior</em>'.
   * @see org.be.textbe.bt.textbt.RelationalBehavior
   * @generated
   */
  EClass getRelationalBehavior();

  /**
   * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.RelationalBehavior#getBehavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Behavior</em>'.
   * @see org.be.textbe.bt.textbt.RelationalBehavior#getBehavior()
   * @see #getRelationalBehavior()
   * @generated
   */
  EReference getRelationalBehavior_Behavior();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.RelationalBehavior#getRelations <em>Relations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relations</em>'.
   * @see org.be.textbe.bt.textbt.RelationalBehavior#getRelations()
   * @see #getRelationalBehavior()
   * @generated
   */
  EReference getRelationalBehavior_Relations();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assertion</em>'.
   * @see org.be.textbe.bt.textbt.Assertion
   * @generated
   */
  EClass getAssertion();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AbstractBlockOrNode <em>Abstract Block Or Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Block Or Node</em>'.
   * @see org.be.textbe.bt.textbt.AbstractBlockOrNode
   * @generated
   */
  EClass getAbstractBlockOrNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AbstractBlock <em>Abstract Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Block</em>'.
   * @see org.be.textbe.bt.textbt.AbstractBlock
   * @generated
   */
  EClass getAbstractBlock();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.AbstractBlock#getChildNode <em>Child Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child Node</em>'.
   * @see org.be.textbe.bt.textbt.AbstractBlock#getChildNode()
   * @see #getAbstractBlock()
   * @generated
   */
  EReference getAbstractBlock_ChildNode();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.AbstractNode <em>Abstract Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Node</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode
   * @generated
   */
  EClass getAbstractNode();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getComponentRef <em>Component Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Ref</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getComponentRef()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_ComponentRef();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getBehaviorRef <em>Behavior Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behavior Ref</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getBehaviorRef()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_BehaviorRef();

  /**
   * Returns the meta object for the attribute list '{@link org.be.textbe.bt.textbt.AbstractNode#getRequirementRef <em>Requirement Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Requirement Ref</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getRequirementRef()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_RequirementRef();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getTraceabilityStatus <em>Traceability Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Traceability Status</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getTraceabilityStatus()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_TraceabilityStatus();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getLabel()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_Label();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getOperator()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getComponentSet <em>Component Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Set</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getComponentSet()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_ComponentSet();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.AbstractNode#getMci <em>Mci</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mci</em>'.
   * @see org.be.textbe.bt.textbt.AbstractNode#getMci()
   * @see #getAbstractNode()
   * @generated
   */
  EAttribute getAbstractNode_Mci();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation</em>'.
   * @see org.be.textbe.bt.textbt.Relation
   * @generated
   */
  EClass getRelation();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getQuestion <em>Question</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Question</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getQuestion()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_Question();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getPreposition <em>Preposition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Preposition</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getPreposition()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_Preposition();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getComponentRef <em>Component Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Ref</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getComponentRef()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_ComponentRef();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getBehaviorRef <em>Behavior Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behavior Ref</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getBehaviorRef()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_BehaviorRef();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getLevel()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_Level();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getComponentLevel <em>Component Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Level</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getComponentLevel()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_ComponentLevel();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getComponentSet <em>Component Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Set</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getComponentSet()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_ComponentSet();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Relation#getMci <em>Mci</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mci</em>'.
   * @see org.be.textbe.bt.textbt.Relation#getMci()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_Mci();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.SystemComponent <em>System Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System Component</em>'.
   * @see org.be.textbe.bt.textbt.SystemComponent
   * @generated
   */
  EClass getSystemComponent();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.OptionList <em>Option List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Option List</em>'.
   * @see org.be.textbe.bt.textbt.OptionList
   * @generated
   */
  EClass getOptionList();

  /**
   * Returns the meta object for the containment reference list '{@link org.be.textbe.bt.textbt.OptionList#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Options</em>'.
   * @see org.be.textbe.bt.textbt.OptionList#getOptions()
   * @see #getOptionList()
   * @generated
   */
  EReference getOptionList_Options();

  /**
   * Returns the meta object for class '{@link org.be.textbe.bt.textbt.Option <em>Option</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Option</em>'.
   * @see org.be.textbe.bt.textbt.Option
   * @generated
   */
  EClass getOption();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Option#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.be.textbe.bt.textbt.Option#getName()
   * @see #getOption()
   * @generated
   */
  EAttribute getOption_Name();

  /**
   * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.Option#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.be.textbe.bt.textbt.Option#getValue()
   * @see #getOption()
   * @generated
   */
  EAttribute getOption_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TextbtFactory getTextbtFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.TextBTImpl <em>Text BT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.TextBTImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getTextBT()
     * @generated
     */
    EClass TEXT_BT = eINSTANCE.getTextBT();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXT_BT__OPTIONS = eINSTANCE.getTextBT_Options();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXT_BT__REQUIREMENTS = eINSTANCE.getTextBT_Requirements();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXT_BT__COMPONENTS = eINSTANCE.getTextBT_Components();

    /**
     * The meta object literal for the '<em><b>Behavior Tree</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXT_BT__BEHAVIOR_TREE = eINSTANCE.getTextBT_BehaviorTree();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.RequirementListImpl <em>Requirement List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.RequirementListImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRequirementList()
     * @generated
     */
    EClass REQUIREMENT_LIST = eINSTANCE.getRequirementList();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_LIST__REQUIREMENTS = eINSTANCE.getRequirementList_Requirements();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.RequirementImpl <em>Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.RequirementImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRequirement()
     * @generated
     */
    EClass REQUIREMENT = eINSTANCE.getRequirement();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__REF = eINSTANCE.getRequirement_Ref();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__VAL = eINSTANCE.getRequirement_Val();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.ComponentListImpl <em>Component List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.ComponentListImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getComponentList()
     * @generated
     */
    EClass COMPONENT_LIST = eINSTANCE.getComponentList();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_LIST__COMPONENTS = eINSTANCE.getComponentList_Components();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.ComponentImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getComponent()
     * @generated
     */
    EClass COMPONENT = eINSTANCE.getComponent();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__REF = eINSTANCE.getComponent_Ref();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__VAL = eINSTANCE.getComponent_Val();

    /**
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT__BEHAVIORS = eINSTANCE.getComponent_Behaviors();

    /**
     * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__QUANTIFIER = eINSTANCE.getComponent_Quantifier();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.BehaviorImpl <em>Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.BehaviorImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getBehavior()
     * @generated
     */
    EClass BEHAVIOR = eINSTANCE.getBehavior();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR__REF = eINSTANCE.getBehavior_Ref();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR__VAL = eINSTANCE.getBehavior_Val();

    /**
     * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR__RELATIONS = eINSTANCE.getBehavior_Relations();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.StateImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.SelectionImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSelection()
     * @generated
     */
    EClass SELECTION = eINSTANCE.getSelection();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.EventImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.GuardImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.InternalInputImpl <em>Internal Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.InternalInputImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getInternalInput()
     * @generated
     */
    EClass INTERNAL_INPUT = eINSTANCE.getInternalInput();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.InternalOutputImpl <em>Internal Output</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.InternalOutputImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getInternalOutput()
     * @generated
     */
    EClass INTERNAL_OUTPUT = eINSTANCE.getInternalOutput();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.ExternalInputImpl <em>External Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.ExternalInputImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getExternalInput()
     * @generated
     */
    EClass EXTERNAL_INPUT = eINSTANCE.getExternalInput();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.ExternalOutputImpl <em>External Output</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.ExternalOutputImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getExternalOutput()
     * @generated
     */
    EClass EXTERNAL_OUTPUT = eINSTANCE.getExternalOutput();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.NodeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Child Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__CHILD_NODE = eINSTANCE.getNode_ChildNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.SequentialNodeImpl <em>Sequential Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.SequentialNodeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSequentialNode()
     * @generated
     */
    EClass SEQUENTIAL_NODE = eINSTANCE.getSequentialNode();

    /**
     * The meta object literal for the '<em><b>Child Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENTIAL_NODE__CHILD_NODE = eINSTANCE.getSequentialNode_ChildNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AtomicNodeImpl <em>Atomic Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AtomicNodeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAtomicNode()
     * @generated
     */
    EClass ATOMIC_NODE = eINSTANCE.getAtomicNode();

    /**
     * The meta object literal for the '<em><b>Child Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_NODE__CHILD_NODE = eINSTANCE.getAtomicNode_ChildNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.ParallelBlockImpl <em>Parallel Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.ParallelBlockImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getParallelBlock()
     * @generated
     */
    EClass PARALLEL_BLOCK = eINSTANCE.getParallelBlock();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AlternativeBlockImpl <em>Alternative Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AlternativeBlockImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAlternativeBlock()
     * @generated
     */
    EClass ALTERNATIVE_BLOCK = eINSTANCE.getAlternativeBlock();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.FiveWs <em>Five Ws</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.FiveWs
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getFiveWs()
     * @generated
     */
    EEnum FIVE_WS = eINSTANCE.getFiveWs();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.Validity <em>Validity</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.Validity
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getValidity()
     * @generated
     */
    EEnum VALIDITY = eINSTANCE.getValidity();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.BehaviorTreeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getBehaviorTree()
     * @generated
     */
    EClass BEHAVIOR_TREE = eINSTANCE.getBehaviorTree();

    /**
     * The meta object literal for the '<em><b>Root Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TREE__ROOT_NODE = eINSTANCE.getBehaviorTree_RootNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AbstractBehaviorImpl <em>Abstract Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AbstractBehaviorImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBehavior()
     * @generated
     */
    EClass ABSTRACT_BEHAVIOR = eINSTANCE.getAbstractBehavior();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.RelationalBehaviorImpl <em>Relational Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.RelationalBehaviorImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRelationalBehavior()
     * @generated
     */
    EClass RELATIONAL_BEHAVIOR = eINSTANCE.getRelationalBehavior();

    /**
     * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_BEHAVIOR__BEHAVIOR = eINSTANCE.getRelationalBehavior_Behavior();

    /**
     * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_BEHAVIOR__RELATIONS = eINSTANCE.getRelationalBehavior_Relations();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AssertionImpl <em>Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AssertionImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAssertion()
     * @generated
     */
    EClass ASSERTION = eINSTANCE.getAssertion();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AbstractBlockOrNodeImpl <em>Abstract Block Or Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AbstractBlockOrNodeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBlockOrNode()
     * @generated
     */
    EClass ABSTRACT_BLOCK_OR_NODE = eINSTANCE.getAbstractBlockOrNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AbstractBlockImpl <em>Abstract Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AbstractBlockImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractBlock()
     * @generated
     */
    EClass ABSTRACT_BLOCK = eINSTANCE.getAbstractBlock();

    /**
     * The meta object literal for the '<em><b>Child Node</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_BLOCK__CHILD_NODE = eINSTANCE.getAbstractBlock_ChildNode();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.AbstractNodeImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getAbstractNode()
     * @generated
     */
    EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

    /**
     * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__COMPONENT_REF = eINSTANCE.getAbstractNode_ComponentRef();

    /**
     * The meta object literal for the '<em><b>Behavior Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__BEHAVIOR_REF = eINSTANCE.getAbstractNode_BehaviorRef();

    /**
     * The meta object literal for the '<em><b>Requirement Ref</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__REQUIREMENT_REF = eINSTANCE.getAbstractNode_RequirementRef();

    /**
     * The meta object literal for the '<em><b>Traceability Status</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__TRACEABILITY_STATUS = eINSTANCE.getAbstractNode_TraceabilityStatus();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__LABEL = eINSTANCE.getAbstractNode_Label();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__OPERATOR = eINSTANCE.getAbstractNode_Operator();

    /**
     * The meta object literal for the '<em><b>Component Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__COMPONENT_SET = eINSTANCE.getAbstractNode_ComponentSet();

    /**
     * The meta object literal for the '<em><b>Mci</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_NODE__MCI = eINSTANCE.getAbstractNode_Mci();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.RelationImpl <em>Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.RelationImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getRelation()
     * @generated
     */
    EClass RELATION = eINSTANCE.getRelation();

    /**
     * The meta object literal for the '<em><b>Question</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__QUESTION = eINSTANCE.getRelation_Question();

    /**
     * The meta object literal for the '<em><b>Preposition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__PREPOSITION = eINSTANCE.getRelation_Preposition();

    /**
     * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__COMPONENT_REF = eINSTANCE.getRelation_ComponentRef();

    /**
     * The meta object literal for the '<em><b>Behavior Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__BEHAVIOR_REF = eINSTANCE.getRelation_BehaviorRef();

    /**
     * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__LEVEL = eINSTANCE.getRelation_Level();

    /**
     * The meta object literal for the '<em><b>Component Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__COMPONENT_LEVEL = eINSTANCE.getRelation_ComponentLevel();

    /**
     * The meta object literal for the '<em><b>Component Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__COMPONENT_SET = eINSTANCE.getRelation_ComponentSet();

    /**
     * The meta object literal for the '<em><b>Mci</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__MCI = eINSTANCE.getRelation_Mci();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.SystemComponentImpl <em>System Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.SystemComponentImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getSystemComponent()
     * @generated
     */
    EClass SYSTEM_COMPONENT = eINSTANCE.getSystemComponent();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.OptionListImpl <em>Option List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.OptionListImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getOptionList()
     * @generated
     */
    EClass OPTION_LIST = eINSTANCE.getOptionList();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPTION_LIST__OPTIONS = eINSTANCE.getOptionList_Options();

    /**
     * The meta object literal for the '{@link org.be.textbe.bt.textbt.impl.OptionImpl <em>Option</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.be.textbe.bt.textbt.impl.OptionImpl
     * @see org.be.textbe.bt.textbt.impl.TextbtPackageImpl#getOption()
     * @generated
     */
    EClass OPTION = eINSTANCE.getOption();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

  }

} //TextbtPackage
