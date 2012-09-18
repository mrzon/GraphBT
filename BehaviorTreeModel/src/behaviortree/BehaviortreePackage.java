/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

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
 * @see behaviortree.BehaviortreeFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviortreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "behaviortree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://bt/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviortreePackage eINSTANCE = behaviortree.impl.BehaviortreePackageImpl.init();

	/**
	 * The meta object id for the '{@link behaviortree.impl.BEModelImpl <em>BE Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BEModelImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBEModel()
	 * @generated
	 */
	int BE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Dbt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__DBT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__NAME = 1;

	/**
	 * The feature id for the '<em><b>Component List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__COMPONENT_LIST = 2;

	/**
	 * The feature id for the '<em><b>Requirement List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__REQUIREMENT_LIST = 3;

	/**
	 * The feature id for the '<em><b>Formula List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__FORMULA_LIST = 4;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__IMPORT = 5;

	/**
	 * The number of structural features of the '<em>BE Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BehaviorTreeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBehaviorTree()
	 * @generated
	 */
	int BEHAVIOR_TREE = 1;

	/**
	 * The feature id for the '<em><b>Root Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__ROOT_NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Behavior Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link behaviortree.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.NodeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INDEX = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 1;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGE = 2;

	/**
	 * The feature id for the '<em><b>Special E</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SPECIAL_E = 3;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link behaviortree.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.EdgeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 3;

	/**
	 * The feature id for the '<em><b>Child Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__CHILD_NODE = 0;

	/**
	 * The feature id for the '<em><b>Branch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__BRANCH = 1;

	/**
	 * The feature id for the '<em><b>Composition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__COMPOSITION = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__CONTAINER = 3;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SpecialEdgeImpl <em>Special Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SpecialEdgeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getSpecialEdge()
	 * @generated
	 */
	int SPECIAL_EDGE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_EDGE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_EDGE__DESTINATION = 1;

	/**
	 * The number of structural features of the '<em>Special Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_EDGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link behaviortree.impl.EmptyNodeImpl <em>Empty Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.EmptyNodeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getEmptyNode()
	 * @generated
	 */
	int EMPTY_NODE = 5;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE__INDEX = NODE__INDEX;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE__EDGE = NODE__EDGE;

	/**
	 * The feature id for the '<em><b>Special E</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE__SPECIAL_E = NODE__SPECIAL_E;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE__LABEL = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Empty Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.StandardNodeImpl <em>Standard Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.StandardNodeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getStandardNode()
	 * @generated
	 */
	int STANDARD_NODE = 6;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__INDEX = NODE__INDEX;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__EDGE = NODE__EDGE;

	/**
	 * The feature id for the '<em><b>Special E</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__SPECIAL_E = NODE__SPECIAL_E;

	/**
	 * The feature id for the '<em><b>Traceability Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__TRACEABILITY_STATUS = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__OPERATOR = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__LABEL = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__COMPONENT_REF = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__BEHAVIOR_REF = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Traceability Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__TRACEABILITY_LINK = NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__LEAF = NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__PARENT = NODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Standard Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ComponentImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 7;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPONENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ATTRIBUTES = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__STATE = 2;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INITIAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = 4;

	/**
	 * The feature id for the '<em><b>Related To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RELATED_TO = 5;

	/**
	 * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__BEHAVIORS = 6;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPONENT_REF = 7;

	/**
	 * The feature id for the '<em><b>Component Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPONENT_DESC = 8;

	/**
	 * The feature id for the '<em><b>Enumerated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ENUMERATED = 9;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AttributeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link behaviortree.impl.CTEdgeImpl <em>CT Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.CTEdgeImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getCTEdge()
	 * @generated
	 */
	int CT_EDGE = 9;

	/**
	 * The number of structural features of the '<em>CT Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CT_EDGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.StateImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getState()
	 * @generated
	 */
	int STATE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.LibraryImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TEXT = 1;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__DESC = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LOCATION = 3;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link behaviortree.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.RequirementImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 12;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Traceability Link</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TRACEABILITY_LINK = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BehaviorImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 13;

	/**
	 * The feature id for the '<em><b>Behavior Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Behavior Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_NAME = 1;

	/**
	 * The feature id for the '<em><b>Behavior Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_REF = 2;

	/**
	 * The feature id for the '<em><b>Behavior Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_DESC = 3;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ComponentListImpl <em>Component List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ComponentListImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getComponentList()
	 * @generated
	 */
	int COMPONENT_LIST = 14;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
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
	 * The meta object id for the '{@link behaviortree.impl.RequirementListImpl <em>Requirement List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.RequirementListImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getRequirementList()
	 * @generated
	 */
	int REQUIREMENT_LIST = 15;

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
	 * The meta object id for the '{@link behaviortree.impl.FormulaListImpl <em>Formula List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.FormulaListImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getFormulaList()
	 * @generated
	 */
	int FORMULA_LIST = 16;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_LIST__FORMULA = 0;

	/**
	 * The number of structural features of the '<em>Formula List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.FormulaImpl <em>Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.FormulaImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getFormula()
	 * @generated
	 */
	int FORMULA = 17;

	/**
	 * The feature id for the '<em><b>Formula Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA__FORMULA_NAME = 0;

	/**
	 * The number of structural features of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.OperatorClassImpl <em>Operator Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.OperatorClassImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getOperatorClass()
	 * @generated
	 */
	int OPERATOR_CLASS = 18;

	/**
	 * The feature id for the '<em><b>Operator Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CLASS__OPERATOR_LITERAL = 0;

	/**
	 * The number of structural features of the '<em>Operator Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CLASS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.TraceabilityStatusClassImpl <em>Traceability Status Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.TraceabilityStatusClassImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getTraceabilityStatusClass()
	 * @generated
	 */
	int TRACEABILITY_STATUS_CLASS = 19;

	/**
	 * The feature id for the '<em><b>Traceability Status Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL = 0;

	/**
	 * The number of structural features of the '<em>Traceability Status Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_STATUS_CLASS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.LinkImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getLink()
	 * @generated
	 */
	int LINK = 20;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AlternativeClassImpl <em>Alternative Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AlternativeClassImpl
	 * @see behaviortree.impl.BehaviortreePackageImpl#getAlternativeClass()
	 * @generated
	 */
	int ALTERNATIVE_CLASS = 21;

	/**
	 * The feature id for the '<em><b>Alternative Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE = 0;

	/**
	 * The number of structural features of the '<em>Alternative Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_CLASS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link behaviortree.Composition <em>Composition</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Composition
	 * @see behaviortree.impl.BehaviortreePackageImpl#getComposition()
	 * @generated
	 */
	int COMPOSITION = 22;

	/**
	 * The meta object id for the '{@link behaviortree.Branch <em>Branch</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Branch
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 23;

	/**
	 * The meta object id for the '{@link behaviortree.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Operator
	 * @see behaviortree.impl.BehaviortreePackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 24;

	/**
	 * The meta object id for the '{@link behaviortree.BehaviorType <em>Behavior Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.BehaviorType
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBehaviorType()
	 * @generated
	 */
	int BEHAVIOR_TYPE = 25;

	/**
	 * The meta object id for the '{@link behaviortree.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.EventType
	 * @see behaviortree.impl.BehaviortreePackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 26;

	/**
	 * The meta object id for the '{@link behaviortree.SpecialEdgeEnum <em>Special Edge Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.SpecialEdgeEnum
	 * @see behaviortree.impl.BehaviortreePackageImpl#getSpecialEdgeEnum()
	 * @generated
	 */
	int SPECIAL_EDGE_ENUM = 27;

	/**
	 * The meta object id for the '{@link behaviortree.TraceabilityStatus <em>Traceability Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.TraceabilityStatus
	 * @see behaviortree.impl.BehaviortreePackageImpl#getTraceabilityStatus()
	 * @generated
	 */
	int TRACEABILITY_STATUS = 28;


	/**
	 * Returns the meta object for class '{@link behaviortree.BEModel <em>BE Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BE Model</em>'.
	 * @see behaviortree.BEModel
	 * @generated
	 */
	EClass getBEModel();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.BEModel#getDbt <em>Dbt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dbt</em>'.
	 * @see behaviortree.BEModel#getDbt()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_Dbt();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.BEModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.BEModel#getName()
	 * @see #getBEModel()
	 * @generated
	 */
	EAttribute getBEModel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.BEModel#getComponentList <em>Component List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component List</em>'.
	 * @see behaviortree.BEModel#getComponentList()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_ComponentList();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.BEModel#getRequirementList <em>Requirement List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirement List</em>'.
	 * @see behaviortree.BEModel#getRequirementList()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_RequirementList();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.BEModel#getFormulaList <em>Formula List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formula List</em>'.
	 * @see behaviortree.BEModel#getFormulaList()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_FormulaList();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.BEModel#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see behaviortree.BEModel#getImport()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_Import();

	/**
	 * Returns the meta object for class '{@link behaviortree.BehaviorTree <em>Behavior Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Tree</em>'.
	 * @see behaviortree.BehaviorTree
	 * @generated
	 */
	EClass getBehaviorTree();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.BehaviorTree#getRootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Node</em>'.
	 * @see behaviortree.BehaviorTree#getRootNode()
	 * @see #getBehaviorTree()
	 * @generated
	 */
	EReference getBehaviorTree_RootNode();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.BehaviorTree#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.BehaviorTree#getName()
	 * @see #getBehaviorTree()
	 * @generated
	 */
	EAttribute getBehaviorTree_Name();

	/**
	 * Returns the meta object for class '{@link behaviortree.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see behaviortree.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Node#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see behaviortree.Node#getIndex()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Index();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see behaviortree.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.Node#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see behaviortree.Node#getEdge()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Edge();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.Node#getSpecialE <em>Special E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Special E</em>'.
	 * @see behaviortree.Node#getSpecialE()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SpecialE();

	/**
	 * Returns the meta object for class '{@link behaviortree.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see behaviortree.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.Edge#getChildNode <em>Child Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Node</em>'.
	 * @see behaviortree.Edge#getChildNode()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_ChildNode();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Edge#getBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch</em>'.
	 * @see behaviortree.Edge#getBranch()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Branch();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Edge#getComposition <em>Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composition</em>'.
	 * @see behaviortree.Edge#getComposition()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Composition();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.Edge#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see behaviortree.Edge#getContainer()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Container();

	/**
	 * Returns the meta object for class '{@link behaviortree.SpecialEdge <em>Special Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Edge</em>'.
	 * @see behaviortree.SpecialEdge
	 * @generated
	 */
	EClass getSpecialEdge();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.SpecialEdge#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see behaviortree.SpecialEdge#getType()
	 * @see #getSpecialEdge()
	 * @generated
	 */
	EAttribute getSpecialEdge_Type();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.SpecialEdge#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see behaviortree.SpecialEdge#getDestination()
	 * @see #getSpecialEdge()
	 * @generated
	 */
	EAttribute getSpecialEdge_Destination();

	/**
	 * Returns the meta object for class '{@link behaviortree.EmptyNode <em>Empty Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Node</em>'.
	 * @see behaviortree.EmptyNode
	 * @generated
	 */
	EClass getEmptyNode();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.EmptyNode#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see behaviortree.EmptyNode#getLabel()
	 * @see #getEmptyNode()
	 * @generated
	 */
	EAttribute getEmptyNode_Label();

	/**
	 * Returns the meta object for class '{@link behaviortree.StandardNode <em>Standard Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Node</em>'.
	 * @see behaviortree.StandardNode
	 * @generated
	 */
	EClass getStandardNode();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getTraceabilityLink <em>Traceability Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traceability Link</em>'.
	 * @see behaviortree.StandardNode#getTraceabilityLink()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_TraceabilityLink();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see behaviortree.StandardNode#isLeaf()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_Leaf();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.StandardNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see behaviortree.StandardNode#getParent()
	 * @see #getStandardNode()
	 * @generated
	 */
	EReference getStandardNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Ref</em>'.
	 * @see behaviortree.StandardNode#getComponentRef()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_ComponentRef();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getBehaviorRef <em>Behavior Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Ref</em>'.
	 * @see behaviortree.StandardNode#getBehaviorRef()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_BehaviorRef();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getTraceabilityStatus <em>Traceability Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traceability Status</em>'.
	 * @see behaviortree.StandardNode#getTraceabilityStatus()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_TraceabilityStatus();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see behaviortree.StandardNode#getOperator()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_Operator();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.StandardNode#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see behaviortree.StandardNode#getLabel()
	 * @see #getStandardNode()
	 * @generated
	 */
	EAttribute getStandardNode_Label();

	/**
	 * Returns the meta object for class '{@link behaviortree.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see behaviortree.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Component#getComponentName <em>Component Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Name</em>'.
	 * @see behaviortree.Component#getComponentName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ComponentName();

	/**
	 * Returns the meta object for the reference list '{@link behaviortree.Component#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see behaviortree.Component#getAttributes()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.Component#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see behaviortree.Component#getState()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_State();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.Component#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see behaviortree.Component#getInitialState()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_InitialState();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Component#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see behaviortree.Component#getId()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Id();

	/**
	 * Returns the meta object for the reference list '{@link behaviortree.Component#getRelatedTo <em>Related To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related To</em>'.
	 * @see behaviortree.Component#getRelatedTo()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_RelatedTo();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.Component#getBehaviors <em>Behaviors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behaviors</em>'.
	 * @see behaviortree.Component#getBehaviors()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Behaviors();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Component#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Ref</em>'.
	 * @see behaviortree.Component#getComponentRef()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ComponentRef();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Component#getComponentDesc <em>Component Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Desc</em>'.
	 * @see behaviortree.Component#getComponentDesc()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ComponentDesc();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Component#isEnumerated <em>Enumerated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enumerated</em>'.
	 * @see behaviortree.Component#isEnumerated()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Enumerated();

	/**
	 * Returns the meta object for class '{@link behaviortree.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see behaviortree.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see behaviortree.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see behaviortree.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link behaviortree.CTEdge <em>CT Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CT Edge</em>'.
	 * @see behaviortree.CTEdge
	 * @generated
	 */
	EClass getCTEdge();

	/**
	 * Returns the meta object for class '{@link behaviortree.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see behaviortree.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for class '{@link behaviortree.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see behaviortree.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Library#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.Library#getName()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Name();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Library#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see behaviortree.Library#getText()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Text();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Library#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see behaviortree.Library#getDesc()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Desc();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Library#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see behaviortree.Library#getLocation()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Location();

	/**
	 * Returns the meta object for class '{@link behaviortree.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see behaviortree.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Requirement#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see behaviortree.Requirement#getKey()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Key();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Requirement#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement</em>'.
	 * @see behaviortree.Requirement#getRequirement()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Requirement();

	/**
	 * Returns the meta object for the reference list '{@link behaviortree.Requirement#getTraceabilityLink <em>Traceability Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Traceability Link</em>'.
	 * @see behaviortree.Requirement#getTraceabilityLink()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_TraceabilityLink();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Requirement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see behaviortree.Requirement#getDescription()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Description();

	/**
	 * Returns the meta object for class '{@link behaviortree.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see behaviortree.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Behavior#getBehaviorType <em>Behavior Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Type</em>'.
	 * @see behaviortree.Behavior#getBehaviorType()
	 * @see #getBehavior()
	 * @generated
	 */
	EAttribute getBehavior_BehaviorType();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Behavior#getBehaviorName <em>Behavior Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Name</em>'.
	 * @see behaviortree.Behavior#getBehaviorName()
	 * @see #getBehavior()
	 * @generated
	 */
	EAttribute getBehavior_BehaviorName();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Behavior#getBehaviorRef <em>Behavior Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Ref</em>'.
	 * @see behaviortree.Behavior#getBehaviorRef()
	 * @see #getBehavior()
	 * @generated
	 */
	EAttribute getBehavior_BehaviorRef();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Behavior#getBehaviorDesc <em>Behavior Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Desc</em>'.
	 * @see behaviortree.Behavior#getBehaviorDesc()
	 * @see #getBehavior()
	 * @generated
	 */
	EAttribute getBehavior_BehaviorDesc();

	/**
	 * Returns the meta object for class '{@link behaviortree.ComponentList <em>Component List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component List</em>'.
	 * @see behaviortree.ComponentList
	 * @generated
	 */
	EClass getComponentList();

	/**
	 * Returns the meta object for the reference list '{@link behaviortree.ComponentList#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see behaviortree.ComponentList#getComponents()
	 * @see #getComponentList()
	 * @generated
	 */
	EReference getComponentList_Components();

	/**
	 * Returns the meta object for class '{@link behaviortree.RequirementList <em>Requirement List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement List</em>'.
	 * @see behaviortree.RequirementList
	 * @generated
	 */
	EClass getRequirementList();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.RequirementList#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see behaviortree.RequirementList#getRequirements()
	 * @see #getRequirementList()
	 * @generated
	 */
	EReference getRequirementList_Requirements();

	/**
	 * Returns the meta object for class '{@link behaviortree.FormulaList <em>Formula List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula List</em>'.
	 * @see behaviortree.FormulaList
	 * @generated
	 */
	EClass getFormulaList();

	/**
	 * Returns the meta object for the reference list '{@link behaviortree.FormulaList#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Formula</em>'.
	 * @see behaviortree.FormulaList#getFormula()
	 * @see #getFormulaList()
	 * @generated
	 */
	EReference getFormulaList_Formula();

	/**
	 * Returns the meta object for class '{@link behaviortree.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula</em>'.
	 * @see behaviortree.Formula
	 * @generated
	 */
	EClass getFormula();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Formula#getFormulaName <em>Formula Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula Name</em>'.
	 * @see behaviortree.Formula#getFormulaName()
	 * @see #getFormula()
	 * @generated
	 */
	EAttribute getFormula_FormulaName();

	/**
	 * Returns the meta object for class '{@link behaviortree.OperatorClass <em>Operator Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Class</em>'.
	 * @see behaviortree.OperatorClass
	 * @generated
	 */
	EClass getOperatorClass();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.OperatorClass#getOperatorLiteral <em>Operator Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Literal</em>'.
	 * @see behaviortree.OperatorClass#getOperatorLiteral()
	 * @see #getOperatorClass()
	 * @generated
	 */
	EAttribute getOperatorClass_OperatorLiteral();

	/**
	 * Returns the meta object for class '{@link behaviortree.TraceabilityStatusClass <em>Traceability Status Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traceability Status Class</em>'.
	 * @see behaviortree.TraceabilityStatusClass
	 * @generated
	 */
	EClass getTraceabilityStatusClass();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.TraceabilityStatusClass#getTraceabilityStatusLiteral <em>Traceability Status Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traceability Status Literal</em>'.
	 * @see behaviortree.TraceabilityStatusClass#getTraceabilityStatusLiteral()
	 * @see #getTraceabilityStatusClass()
	 * @generated
	 */
	EAttribute getTraceabilityStatusClass_TraceabilityStatusLiteral();

	/**
	 * Returns the meta object for class '{@link behaviortree.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see behaviortree.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see behaviortree.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see behaviortree.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Source();

	/**
	 * Returns the meta object for class '{@link behaviortree.AlternativeClass <em>Alternative Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Class</em>'.
	 * @see behaviortree.AlternativeClass
	 * @generated
	 */
	EClass getAlternativeClass();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.AlternativeClass#getAlternativeAttribute <em>Alternative Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alternative Attribute</em>'.
	 * @see behaviortree.AlternativeClass#getAlternativeAttribute()
	 * @see #getAlternativeClass()
	 * @generated
	 */
	EAttribute getAlternativeClass_AlternativeAttribute();

	/**
	 * Returns the meta object for enum '{@link behaviortree.Composition <em>Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Composition</em>'.
	 * @see behaviortree.Composition
	 * @generated
	 */
	EEnum getComposition();

	/**
	 * Returns the meta object for enum '{@link behaviortree.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Branch</em>'.
	 * @see behaviortree.Branch
	 * @generated
	 */
	EEnum getBranch();

	/**
	 * Returns the meta object for enum '{@link behaviortree.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see behaviortree.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the meta object for enum '{@link behaviortree.BehaviorType <em>Behavior Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Behavior Type</em>'.
	 * @see behaviortree.BehaviorType
	 * @generated
	 */
	EEnum getBehaviorType();

	/**
	 * Returns the meta object for enum '{@link behaviortree.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see behaviortree.EventType
	 * @generated
	 */
	EEnum getEventType();

	/**
	 * Returns the meta object for enum '{@link behaviortree.SpecialEdgeEnum <em>Special Edge Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Special Edge Enum</em>'.
	 * @see behaviortree.SpecialEdgeEnum
	 * @generated
	 */
	EEnum getSpecialEdgeEnum();

	/**
	 * Returns the meta object for enum '{@link behaviortree.TraceabilityStatus <em>Traceability Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traceability Status</em>'.
	 * @see behaviortree.TraceabilityStatus
	 * @generated
	 */
	EEnum getTraceabilityStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BehaviortreeFactory getBehaviortreeFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link behaviortree.impl.BEModelImpl <em>BE Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BEModelImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getBEModel()
		 * @generated
		 */
		EClass BE_MODEL = eINSTANCE.getBEModel();

		/**
		 * The meta object literal for the '<em><b>Dbt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__DBT = eINSTANCE.getBEModel_Dbt();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BE_MODEL__NAME = eINSTANCE.getBEModel_Name();

		/**
		 * The meta object literal for the '<em><b>Component List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__COMPONENT_LIST = eINSTANCE.getBEModel_ComponentList();

		/**
		 * The meta object literal for the '<em><b>Requirement List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__REQUIREMENT_LIST = eINSTANCE.getBEModel_RequirementList();

		/**
		 * The meta object literal for the '<em><b>Formula List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__FORMULA_LIST = eINSTANCE.getBEModel_FormulaList();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__IMPORT = eINSTANCE.getBEModel_Import();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BehaviorTreeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getBehaviorTree()
		 * @generated
		 */
		EClass BEHAVIOR_TREE = eINSTANCE.getBehaviorTree();

		/**
		 * The meta object literal for the '<em><b>Root Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE__ROOT_NODE = eINSTANCE.getBehaviorTree_RootNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_TREE__NAME = eINSTANCE.getBehaviorTree_Name();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.NodeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__INDEX = eINSTANCE.getNode_Index();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGE = eINSTANCE.getNode_Edge();

		/**
		 * The meta object literal for the '<em><b>Special E</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SPECIAL_E = eINSTANCE.getNode_SpecialE();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.EdgeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Child Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__CHILD_NODE = eINSTANCE.getEdge_ChildNode();

		/**
		 * The meta object literal for the '<em><b>Branch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__BRANCH = eINSTANCE.getEdge_Branch();

		/**
		 * The meta object literal for the '<em><b>Composition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__COMPOSITION = eINSTANCE.getEdge_Composition();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__CONTAINER = eINSTANCE.getEdge_Container();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SpecialEdgeImpl <em>Special Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SpecialEdgeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getSpecialEdge()
		 * @generated
		 */
		EClass SPECIAL_EDGE = eINSTANCE.getSpecialEdge();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIAL_EDGE__TYPE = eINSTANCE.getSpecialEdge_Type();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIAL_EDGE__DESTINATION = eINSTANCE.getSpecialEdge_Destination();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.EmptyNodeImpl <em>Empty Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.EmptyNodeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getEmptyNode()
		 * @generated
		 */
		EClass EMPTY_NODE = eINSTANCE.getEmptyNode();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPTY_NODE__LABEL = eINSTANCE.getEmptyNode_Label();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.StandardNodeImpl <em>Standard Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.StandardNodeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getStandardNode()
		 * @generated
		 */
		EClass STANDARD_NODE = eINSTANCE.getStandardNode();

		/**
		 * The meta object literal for the '<em><b>Traceability Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__TRACEABILITY_LINK = eINSTANCE.getStandardNode_TraceabilityLink();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__LEAF = eINSTANCE.getStandardNode_Leaf();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_NODE__PARENT = eINSTANCE.getStandardNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__COMPONENT_REF = eINSTANCE.getStandardNode_ComponentRef();

		/**
		 * The meta object literal for the '<em><b>Behavior Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__BEHAVIOR_REF = eINSTANCE.getStandardNode_BehaviorRef();

		/**
		 * The meta object literal for the '<em><b>Traceability Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__TRACEABILITY_STATUS = eINSTANCE.getStandardNode_TraceabilityStatus();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__OPERATOR = eINSTANCE.getStandardNode_Operator();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__LABEL = eINSTANCE.getStandardNode_Label();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ComponentImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Component Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__COMPONENT_NAME = eINSTANCE.getComponent_ComponentName();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ATTRIBUTES = eINSTANCE.getComponent_Attributes();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__STATE = eINSTANCE.getComponent_State();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INITIAL_STATE = eINSTANCE.getComponent_InitialState();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__ID = eINSTANCE.getComponent_Id();

		/**
		 * The meta object literal for the '<em><b>Related To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__RELATED_TO = eINSTANCE.getComponent_RelatedTo();

		/**
		 * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__BEHAVIORS = eINSTANCE.getComponent_Behaviors();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__COMPONENT_REF = eINSTANCE.getComponent_ComponentRef();

		/**
		 * The meta object literal for the '<em><b>Component Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__COMPONENT_DESC = eINSTANCE.getComponent_ComponentDesc();

		/**
		 * The meta object literal for the '<em><b>Enumerated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__ENUMERATED = eINSTANCE.getComponent_Enumerated();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AttributeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.CTEdgeImpl <em>CT Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.CTEdgeImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getCTEdge()
		 * @generated
		 */
		EClass CT_EDGE = eINSTANCE.getCTEdge();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.StateImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.LibraryImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__NAME = eINSTANCE.getLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__TEXT = eINSTANCE.getLibrary_Text();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__DESC = eINSTANCE.getLibrary_Desc();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__LOCATION = eINSTANCE.getLibrary_Location();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.RequirementImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__KEY = eINSTANCE.getRequirement_Key();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQUIREMENT = eINSTANCE.getRequirement_Requirement();

		/**
		 * The meta object literal for the '<em><b>Traceability Link</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__TRACEABILITY_LINK = eINSTANCE.getRequirement_TraceabilityLink();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__DESCRIPTION = eINSTANCE.getRequirement_Description();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BehaviorImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Behavior Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR__BEHAVIOR_TYPE = eINSTANCE.getBehavior_BehaviorType();

		/**
		 * The meta object literal for the '<em><b>Behavior Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR__BEHAVIOR_NAME = eINSTANCE.getBehavior_BehaviorName();

		/**
		 * The meta object literal for the '<em><b>Behavior Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR__BEHAVIOR_REF = eINSTANCE.getBehavior_BehaviorRef();

		/**
		 * The meta object literal for the '<em><b>Behavior Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR__BEHAVIOR_DESC = eINSTANCE.getBehavior_BehaviorDesc();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ComponentListImpl <em>Component List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ComponentListImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getComponentList()
		 * @generated
		 */
		EClass COMPONENT_LIST = eINSTANCE.getComponentList();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_LIST__COMPONENTS = eINSTANCE.getComponentList_Components();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.RequirementListImpl <em>Requirement List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.RequirementListImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getRequirementList()
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
		 * The meta object literal for the '{@link behaviortree.impl.FormulaListImpl <em>Formula List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.FormulaListImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getFormulaList()
		 * @generated
		 */
		EClass FORMULA_LIST = eINSTANCE.getFormulaList();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA_LIST__FORMULA = eINSTANCE.getFormulaList_Formula();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.FormulaImpl <em>Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.FormulaImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getFormula()
		 * @generated
		 */
		EClass FORMULA = eINSTANCE.getFormula();

		/**
		 * The meta object literal for the '<em><b>Formula Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULA__FORMULA_NAME = eINSTANCE.getFormula_FormulaName();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.OperatorClassImpl <em>Operator Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.OperatorClassImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getOperatorClass()
		 * @generated
		 */
		EClass OPERATOR_CLASS = eINSTANCE.getOperatorClass();

		/**
		 * The meta object literal for the '<em><b>Operator Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_CLASS__OPERATOR_LITERAL = eINSTANCE.getOperatorClass_OperatorLiteral();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.TraceabilityStatusClassImpl <em>Traceability Status Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.TraceabilityStatusClassImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getTraceabilityStatusClass()
		 * @generated
		 */
		EClass TRACEABILITY_STATUS_CLASS = eINSTANCE.getTraceabilityStatusClass();

		/**
		 * The meta object literal for the '<em><b>Traceability Status Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL = eINSTANCE.getTraceabilityStatusClass_TraceabilityStatusLiteral();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.LinkImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AlternativeClassImpl <em>Alternative Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AlternativeClassImpl
		 * @see behaviortree.impl.BehaviortreePackageImpl#getAlternativeClass()
		 * @generated
		 */
		EClass ALTERNATIVE_CLASS = eINSTANCE.getAlternativeClass();

		/**
		 * The meta object literal for the '<em><b>Alternative Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE = eINSTANCE.getAlternativeClass_AlternativeAttribute();

		/**
		 * The meta object literal for the '{@link behaviortree.Composition <em>Composition</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.Composition
		 * @see behaviortree.impl.BehaviortreePackageImpl#getComposition()
		 * @generated
		 */
		EEnum COMPOSITION = eINSTANCE.getComposition();

		/**
		 * The meta object literal for the '{@link behaviortree.Branch <em>Branch</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.Branch
		 * @see behaviortree.impl.BehaviortreePackageImpl#getBranch()
		 * @generated
		 */
		EEnum BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '{@link behaviortree.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.Operator
		 * @see behaviortree.impl.BehaviortreePackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link behaviortree.BehaviorType <em>Behavior Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.BehaviorType
		 * @see behaviortree.impl.BehaviortreePackageImpl#getBehaviorType()
		 * @generated
		 */
		EEnum BEHAVIOR_TYPE = eINSTANCE.getBehaviorType();

		/**
		 * The meta object literal for the '{@link behaviortree.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.EventType
		 * @see behaviortree.impl.BehaviortreePackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link behaviortree.SpecialEdgeEnum <em>Special Edge Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.SpecialEdgeEnum
		 * @see behaviortree.impl.BehaviortreePackageImpl#getSpecialEdgeEnum()
		 * @generated
		 */
		EEnum SPECIAL_EDGE_ENUM = eINSTANCE.getSpecialEdgeEnum();

		/**
		 * The meta object literal for the '{@link behaviortree.TraceabilityStatus <em>Traceability Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.TraceabilityStatus
		 * @see behaviortree.impl.BehaviortreePackageImpl#getTraceabilityStatus()
		 * @generated
		 */
		EEnum TRACEABILITY_STATUS = eINSTANCE.getTraceabilityStatus();

	}

} //BehaviortreePackage
