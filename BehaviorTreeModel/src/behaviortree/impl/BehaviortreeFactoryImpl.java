/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BehaviortreeFactoryImpl extends EFactoryImpl implements BehaviortreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BehaviortreeFactory init() {
		try {
			BehaviortreeFactory theBehaviortreeFactory = (BehaviortreeFactory)EPackage.Registry.INSTANCE.getEFactory("http://bt/1.0"); 
			if (theBehaviortreeFactory != null) {
				return theBehaviortreeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BehaviortreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviortreeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BehaviortreePackage.BE_MODEL: return createBEModel();
			case BehaviortreePackage.BEHAVIOR_TREE: return createBehaviorTree();
			case BehaviortreePackage.NODE: return createNode();
			case BehaviortreePackage.EDGE: return createEdge();
			case BehaviortreePackage.SPECIAL_EDGE: return createSpecialEdge();
			case BehaviortreePackage.EMPTY_NODE: return createEmptyNode();
			case BehaviortreePackage.STANDARD_NODE: return createStandardNode();
			case BehaviortreePackage.COMPONENT: return createComponent();
			case BehaviortreePackage.ATTRIBUTE: return createAttribute();
			case BehaviortreePackage.CT_EDGE: return createCTEdge();
			case BehaviortreePackage.STATE: return createState();
			case BehaviortreePackage.LIBRARY: return createLibrary();
			case BehaviortreePackage.REQUIREMENT: return createRequirement();
			case BehaviortreePackage.BEHAVIOR: return createBehavior();
			case BehaviortreePackage.COMPONENT_LIST: return createComponentList();
			case BehaviortreePackage.REQUIREMENT_LIST: return createRequirementList();
			case BehaviortreePackage.FORMULA_LIST: return createFormulaList();
			case BehaviortreePackage.FORMULA: return createFormula();
			case BehaviortreePackage.OPERATOR_CLASS: return createOperatorClass();
			case BehaviortreePackage.TRACEABILITY_STATUS_CLASS: return createTraceabilityStatusClass();
			case BehaviortreePackage.LINK: return createLink();
			case BehaviortreePackage.ALTERNATIVE_CLASS: return createAlternativeClass();
			case BehaviortreePackage.ADDITIONAL_INFORMATION: return createAdditionalInformation();
			case BehaviortreePackage.INFORMATION: return createInformation();
			case BehaviortreePackage.INPUT_TYPE: return createInputType();
			case BehaviortreePackage.OUTPUT_TYPE: return createOutputType();
			case BehaviortreePackage.GUI_IMPLEMENTABLE: return createGUIImplementable();
			case BehaviortreePackage.GUI: return createGUI();
			case BehaviortreePackage.INPUT_GUI: return createInputGUI();
			case BehaviortreePackage.OUTPUT_GUI: return createOutputGUI();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BehaviortreePackage.COMPOSITION:
				return createCompositionFromString(eDataType, initialValue);
			case BehaviortreePackage.BRANCH:
				return createBranchFromString(eDataType, initialValue);
			case BehaviortreePackage.OPERATOR:
				return createOperatorFromString(eDataType, initialValue);
			case BehaviortreePackage.BEHAVIOR_TYPE:
				return createBehaviorTypeFromString(eDataType, initialValue);
			case BehaviortreePackage.EVENT_TYPE:
				return createEventTypeFromString(eDataType, initialValue);
			case BehaviortreePackage.SPECIAL_EDGE_ENUM:
				return createSpecialEdgeEnumFromString(eDataType, initialValue);
			case BehaviortreePackage.TRACEABILITY_STATUS:
				return createTraceabilityStatusFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BehaviortreePackage.COMPOSITION:
				return convertCompositionToString(eDataType, instanceValue);
			case BehaviortreePackage.BRANCH:
				return convertBranchToString(eDataType, instanceValue);
			case BehaviortreePackage.OPERATOR:
				return convertOperatorToString(eDataType, instanceValue);
			case BehaviortreePackage.BEHAVIOR_TYPE:
				return convertBehaviorTypeToString(eDataType, instanceValue);
			case BehaviortreePackage.EVENT_TYPE:
				return convertEventTypeToString(eDataType, instanceValue);
			case BehaviortreePackage.SPECIAL_EDGE_ENUM:
				return convertSpecialEdgeEnumToString(eDataType, instanceValue);
			case BehaviortreePackage.TRACEABILITY_STATUS:
				return convertTraceabilityStatusToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BEModel createBEModel() {
		BEModelImpl beModel = new BEModelImpl();
		return beModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree createBehaviorTree() {
		BehaviorTreeImpl behaviorTree = new BehaviorTreeImpl();
		return behaviorTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialEdge createSpecialEdge() {
		SpecialEdgeImpl specialEdge = new SpecialEdgeImpl();
		return specialEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyNode createEmptyNode() {
		EmptyNodeImpl emptyNode = new EmptyNodeImpl();
		return emptyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardNode createStandardNode() {
		StandardNodeImpl standardNode = new StandardNodeImpl();
		return standardNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CTEdge createCTEdge() {
		CTEdgeImpl ctEdge = new CTEdgeImpl();
		return ctEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior createBehavior() {
		BehaviorImpl behavior = new BehaviorImpl();
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentList createComponentList() {
		ComponentListImpl componentList = new ComponentListImpl();
		return componentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementList createRequirementList() {
		RequirementListImpl requirementList = new RequirementListImpl();
		return requirementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaList createFormulaList() {
		FormulaListImpl formulaList = new FormulaListImpl();
		return formulaList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Formula createFormula() {
		FormulaImpl formula = new FormulaImpl();
		return formula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorClass createOperatorClass() {
		OperatorClassImpl operatorClass = new OperatorClassImpl();
		return operatorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityStatusClass createTraceabilityStatusClass() {
		TraceabilityStatusClassImpl traceabilityStatusClass = new TraceabilityStatusClassImpl();
		return traceabilityStatusClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeClass createAlternativeClass() {
		AlternativeClassImpl alternativeClass = new AlternativeClassImpl();
		return alternativeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionalInformation createAdditionalInformation() {
		AdditionalInformationImpl additionalInformation = new AdditionalInformationImpl();
		return additionalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Information createInformation() {
		InformationImpl information = new InformationImpl();
		return information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputType createInputType() {
		InputTypeImpl inputType = new InputTypeImpl();
		return inputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputType createOutputType() {
		OutputTypeImpl outputType = new OutputTypeImpl();
		return outputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GUIImplementable createGUIImplementable() {
		GUIImplementableImpl guiImplementable = new GUIImplementableImpl();
		return guiImplementable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GUI createGUI() {
		GUIImpl gui = new GUIImpl();
		return gui;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputGUI createInputGUI() {
		InputGUIImpl inputGUI = new InputGUIImpl();
		return inputGUI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputGUI createOutputGUI() {
		OutputGUIImpl outputGUI = new OutputGUIImpl();
		return outputGUI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composition createCompositionFromString(EDataType eDataType, String initialValue) {
		Composition result = Composition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranchFromString(EDataType eDataType, String initialValue) {
		Branch result = Branch.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBranchToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperatorFromString(EDataType eDataType, String initialValue) {
		Operator result = Operator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorType createBehaviorTypeFromString(EDataType eDataType, String initialValue) {
		BehaviorType result = BehaviorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBehaviorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType createEventTypeFromString(EDataType eDataType, String initialValue) {
		EventType result = EventType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialEdgeEnum createSpecialEdgeEnumFromString(EDataType eDataType, String initialValue) {
		SpecialEdgeEnum result = SpecialEdgeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpecialEdgeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityStatus createTraceabilityStatusFromString(EDataType eDataType, String initialValue) {
		TraceabilityStatus result = TraceabilityStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTraceabilityStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviortreePackage getBehaviortreePackage() {
		return (BehaviortreePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BehaviortreePackage getPackage() {
		return BehaviortreePackage.eINSTANCE;
	}

} //BehaviortreeFactoryImpl