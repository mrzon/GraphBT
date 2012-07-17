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
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__EREFERENCE0 = 2;

	/**
	 * The feature id for the '<em><b>Component List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__COMPONENT_LIST = 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL__REQUIREMENTS = 4;

	/**
	 * The number of structural features of the '<em>BE Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BE_MODEL_FEATURE_COUNT = 5;

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
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__EREFERENCE0 = 0;

	/**
	 * The feature id for the '<em><b>Root Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__ROOT_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Behavior Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Edge</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Child Node</b></em>' containment reference.
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
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Edge</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Edge</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__COMPONENT = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__OPERATOR = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__LABEL = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__BEHAVIOR = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Traceability Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE__TRACEABILITY_LINK = NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Standard Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 6;

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
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 8;

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
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IMPORT = 2;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 3;

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
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 3;

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
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = 3;

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
	 * The meta object id for the '{@link behaviortree.Composition <em>Composition</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Composition
	 * @see behaviortree.impl.BehaviortreePackageImpl#getComposition()
	 * @generated
	 */
	int COMPOSITION = 16;

	/**
	 * The meta object id for the '{@link behaviortree.Branch <em>Branch</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Branch
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 17;

	/**
	 * The meta object id for the '{@link behaviortree.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.Operator
	 * @see behaviortree.impl.BehaviortreePackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 18;

	/**
	 * The meta object id for the '{@link behaviortree.BehaviorType <em>Behavior Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.BehaviorType
	 * @see behaviortree.impl.BehaviortreePackageImpl#getBehaviorType()
	 * @generated
	 */
	int BEHAVIOR_TYPE = 19;

	/**
	 * The meta object id for the '{@link behaviortree.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.EventType
	 * @see behaviortree.impl.BehaviortreePackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 20;

	/**
	 * The meta object id for the '{@link behaviortree.SpecialEdgeEnum <em>Special Edge Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.SpecialEdgeEnum
	 * @see behaviortree.impl.BehaviortreePackageImpl#getSpecialEdgeEnum()
	 * @generated
	 */
	int SPECIAL_EDGE_ENUM = 21;

	/**
	 * The meta object id for the '{@link behaviortree.TraceabilityStatus <em>Traceability Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.TraceabilityStatus
	 * @see behaviortree.impl.BehaviortreePackageImpl#getTraceabilityStatus()
	 * @generated
	 */
	int TRACEABILITY_STATUS = 22;


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
	 * Returns the meta object for the reference '{@link behaviortree.BEModel#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see behaviortree.BEModel#getEReference0()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_EReference0();

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
	 * Returns the meta object for the containment reference '{@link behaviortree.BEModel#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirements</em>'.
	 * @see behaviortree.BEModel#getRequirements()
	 * @see #getBEModel()
	 * @generated
	 */
	EReference getBEModel_Requirements();

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
	 * Returns the meta object for the reference '{@link behaviortree.BehaviorTree#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see behaviortree.BehaviorTree#getEReference0()
	 * @see #getBehaviorTree()
	 * @generated
	 */
	EReference getBehaviorTree_EReference0();

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
	 * Returns the meta object for the containment reference list '{@link behaviortree.Node#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge</em>'.
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
	 * Returns the meta object for the containment reference '{@link behaviortree.Edge#getChildNode <em>Child Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child Node</em>'.
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
	 * Returns the meta object for the reference '{@link behaviortree.StandardNode#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior</em>'.
	 * @see behaviortree.StandardNode#getBehavior()
	 * @see #getStandardNode()
	 * @generated
	 */
	EReference getStandardNode_Behavior();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.StandardNode#getTraceabilityLink <em>Traceability Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Traceability Link</em>'.
	 * @see behaviortree.StandardNode#getTraceabilityLink()
	 * @see #getStandardNode()
	 * @generated
	 */
	EReference getStandardNode_TraceabilityLink();

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
	 * Returns the meta object for the reference '{@link behaviortree.StandardNode#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see behaviortree.StandardNode#getComponent()
	 * @see #getStandardNode()
	 * @generated
	 */
	EReference getStandardNode_Component();

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
	 * Returns the meta object for the containment reference list '{@link behaviortree.Library#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see behaviortree.Library#getImport()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Import();

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
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__EREFERENCE0 = eINSTANCE.getBEModel_EReference0();

		/**
		 * The meta object literal for the '<em><b>Component List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__COMPONENT_LIST = eINSTANCE.getBEModel_ComponentList();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BE_MODEL__REQUIREMENTS = eINSTANCE.getBEModel_Requirements();

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
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE__EREFERENCE0 = eINSTANCE.getBehaviorTree_EReference0();

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
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Child Node</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_NODE__BEHAVIOR = eINSTANCE.getStandardNode_Behavior();

		/**
		 * The meta object literal for the '<em><b>Traceability Link</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_NODE__TRACEABILITY_LINK = eINSTANCE.getStandardNode_TraceabilityLink();

		/**
		 * The meta object literal for the '<em><b>Traceability Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_NODE__TRACEABILITY_STATUS = eINSTANCE.getStandardNode_TraceabilityStatus();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_NODE__COMPONENT = eINSTANCE.getStandardNode_Component();

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
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__IMPORT = eINSTANCE.getLibrary_Import();

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
