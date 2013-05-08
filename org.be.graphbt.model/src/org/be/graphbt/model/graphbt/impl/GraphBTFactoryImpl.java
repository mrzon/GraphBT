/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import org.be.graphbt.model.graphbt.*;

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
public class GraphBTFactoryImpl extends EFactoryImpl implements GraphBTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphBTFactory init() {
		try {
			GraphBTFactory theGraphBTFactory = (GraphBTFactory)EPackage.Registry.INSTANCE.getEFactory("http://graphbt/1.0"); 
			if (theGraphBTFactory != null) {
				return theGraphBTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphBTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphBTFactoryImpl() {
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
			case GraphBTPackage.BE_MODEL: return createBEModel();
			case GraphBTPackage.BEHAVIOR_TREE: return createBehaviorTree();
			case GraphBTPackage.NODE: return createNode();
			case GraphBTPackage.EDGE: return createEdge();
			case GraphBTPackage.SPECIAL_EDGE: return createSpecialEdge();
			case GraphBTPackage.EMPTY_NODE: return createEmptyNode();
			case GraphBTPackage.STANDARD_NODE: return createStandardNode();
			case GraphBTPackage.COMPONENT: return createComponent();
			case GraphBTPackage.ATTRIBUTE: return createAttribute();
			case GraphBTPackage.CT_EDGE: return createCTEdge();
			case GraphBTPackage.STATE: return createState();
			case GraphBTPackage.LIBRARY: return createLibrary();
			case GraphBTPackage.REQUIREMENT: return createRequirement();
			case GraphBTPackage.BEHAVIOR: return createBehavior();
			case GraphBTPackage.COMPONENT_LIST: return createComponentList();
			case GraphBTPackage.REQUIREMENT_LIST: return createRequirementList();
			case GraphBTPackage.FORMULA_LIST: return createFormulaList();
			case GraphBTPackage.FORMULA: return createFormula();
			case GraphBTPackage.OPERATOR_CLASS: return createOperatorClass();
			case GraphBTPackage.TRACEABILITY_STATUS_CLASS: return createTraceabilityStatusClass();
			case GraphBTPackage.LINK: return createLink();
			case GraphBTPackage.ALTERNATIVE_CLASS: return createAlternativeClass();
			case GraphBTPackage.MAP_INFORMATION: return createMapInformation();
			case GraphBTPackage.INFORMATION: return createInformation();
			case GraphBTPackage.INPUT_TYPE: return createInputType();
			case GraphBTPackage.OUTPUT_TYPE: return createOutputType();
			case GraphBTPackage.GUI_IMPLEMENTABLE: return createGUIImplementable();
			case GraphBTPackage.GUI: return createGUI();
			case GraphBTPackage.INPUT_GUI: return createInputGUI();
			case GraphBTPackage.OUTPUT_GUI: return createOutputGUI();
			case GraphBTPackage.LIBRARIES: return createLibraries();
			case GraphBTPackage.METHOD_DECLARATION: return createMethodDeclaration();
			case GraphBTPackage.PARAMETER: return createParameter();
			case GraphBTPackage.LAYOUT_LIST: return createLayoutList();
			case GraphBTPackage.LAYOUT: return createLayout();
			case GraphBTPackage.BUTTON: return createButton();
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
			case GraphBTPackage.COMPOSITION:
				return createCompositionFromString(eDataType, initialValue);
			case GraphBTPackage.BRANCH:
				return createBranchFromString(eDataType, initialValue);
			case GraphBTPackage.OPERATOR:
				return createOperatorFromString(eDataType, initialValue);
			case GraphBTPackage.BEHAVIOR_TYPE:
				return createBehaviorTypeFromString(eDataType, initialValue);
			case GraphBTPackage.EVENT_TYPE:
				return createEventTypeFromString(eDataType, initialValue);
			case GraphBTPackage.SPECIAL_EDGE_ENUM:
				return createSpecialEdgeEnumFromString(eDataType, initialValue);
			case GraphBTPackage.TRACEABILITY_STATUS:
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
			case GraphBTPackage.COMPOSITION:
				return convertCompositionToString(eDataType, instanceValue);
			case GraphBTPackage.BRANCH:
				return convertBranchToString(eDataType, instanceValue);
			case GraphBTPackage.OPERATOR:
				return convertOperatorToString(eDataType, instanceValue);
			case GraphBTPackage.BEHAVIOR_TYPE:
				return convertBehaviorTypeToString(eDataType, instanceValue);
			case GraphBTPackage.EVENT_TYPE:
				return convertEventTypeToString(eDataType, instanceValue);
			case GraphBTPackage.SPECIAL_EDGE_ENUM:
				return convertSpecialEdgeEnumToString(eDataType, instanceValue);
			case GraphBTPackage.TRACEABILITY_STATUS:
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
	public MapInformation createMapInformation() {
		MapInformationImpl mapInformation = new MapInformationImpl();
		return mapInformation;
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
	public Libraries createLibraries() {
		LibrariesImpl libraries = new LibrariesImpl();
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodDeclaration createMethodDeclaration() {
		MethodDeclarationImpl methodDeclaration = new MethodDeclarationImpl();
		return methodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutList createLayoutList() {
		LayoutListImpl layoutList = new LayoutListImpl();
		return layoutList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createLayout() {
		LayoutImpl layout = new LayoutImpl();
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Button createButton() {
		ButtonImpl button = new ButtonImpl();
		return button;
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
	public GraphBTPackage getGraphBTPackage() {
		return (GraphBTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphBTPackage getPackage() {
		return GraphBTPackage.eINSTANCE;
	}

} //GraphBTFactoryImpl
