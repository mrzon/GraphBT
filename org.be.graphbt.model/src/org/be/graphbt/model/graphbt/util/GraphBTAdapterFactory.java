/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.util;

import org.be.graphbt.model.graphbt.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.be.graphbt.model.graphbt.GraphBTPackage
 * @generated
 */
public class GraphBTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphBTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphBTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GraphBTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphBTSwitch<Adapter> modelSwitch =
		new GraphBTSwitch<Adapter>() {
			@Override
			public Adapter caseBEModel(BEModel object) {
				return createBEModelAdapter();
			}
			@Override
			public Adapter caseBehaviorTree(BehaviorTree object) {
				return createBehaviorTreeAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseSpecialEdge(SpecialEdge object) {
				return createSpecialEdgeAdapter();
			}
			@Override
			public Adapter caseEmptyNode(EmptyNode object) {
				return createEmptyNodeAdapter();
			}
			@Override
			public Adapter caseStandardNode(StandardNode object) {
				return createStandardNodeAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseCTEdge(CTEdge object) {
				return createCTEdgeAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseBehavior(Behavior object) {
				return createBehaviorAdapter();
			}
			@Override
			public Adapter caseComponentList(ComponentList object) {
				return createComponentListAdapter();
			}
			@Override
			public Adapter caseRequirementList(RequirementList object) {
				return createRequirementListAdapter();
			}
			@Override
			public Adapter caseFormulaList(FormulaList object) {
				return createFormulaListAdapter();
			}
			@Override
			public Adapter caseFormula(Formula object) {
				return createFormulaAdapter();
			}
			@Override
			public Adapter caseOperatorClass(OperatorClass object) {
				return createOperatorClassAdapter();
			}
			@Override
			public Adapter caseTraceabilityStatusClass(TraceabilityStatusClass object) {
				return createTraceabilityStatusClassAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter caseAlternativeClass(AlternativeClass object) {
				return createAlternativeClassAdapter();
			}
			@Override
			public Adapter caseMapInformation(MapInformation object) {
				return createMapInformationAdapter();
			}
			@Override
			public Adapter caseInformation(Information object) {
				return createInformationAdapter();
			}
			@Override
			public Adapter caseInputType(InputType object) {
				return createInputTypeAdapter();
			}
			@Override
			public Adapter caseOutputType(OutputType object) {
				return createOutputTypeAdapter();
			}
			@Override
			public Adapter caseGUIImplementable(GUIImplementable object) {
				return createGUIImplementableAdapter();
			}
			@Override
			public Adapter caseGUI(GUI object) {
				return createGUIAdapter();
			}
			@Override
			public Adapter caseInputGUI(InputGUI object) {
				return createInputGUIAdapter();
			}
			@Override
			public Adapter caseOutputGUI(OutputGUI object) {
				return createOutputGUIAdapter();
			}
			@Override
			public Adapter caseLibraries(Libraries object) {
				return createLibrariesAdapter();
			}
			@Override
			public Adapter caseMethodDeclaration(MethodDeclaration object) {
				return createMethodDeclarationAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseLayoutList(LayoutList object) {
				return createLayoutListAdapter();
			}
			@Override
			public Adapter caseLayout(Layout object) {
				return createLayoutAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.BEModel <em>BE Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.BEModel
	 * @generated
	 */
	public Adapter createBEModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.BehaviorTree <em>Behavior Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.BehaviorTree
	 * @generated
	 */
	public Adapter createBehaviorTreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.SpecialEdge <em>Special Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.SpecialEdge
	 * @generated
	 */
	public Adapter createSpecialEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.EmptyNode <em>Empty Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.EmptyNode
	 * @generated
	 */
	public Adapter createEmptyNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.StandardNode <em>Standard Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.StandardNode
	 * @generated
	 */
	public Adapter createStandardNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.CTEdge <em>CT Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.CTEdge
	 * @generated
	 */
	public Adapter createCTEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Behavior
	 * @generated
	 */
	public Adapter createBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.ComponentList <em>Component List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.ComponentList
	 * @generated
	 */
	public Adapter createComponentListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.RequirementList <em>Requirement List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.RequirementList
	 * @generated
	 */
	public Adapter createRequirementListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.FormulaList <em>Formula List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.FormulaList
	 * @generated
	 */
	public Adapter createFormulaListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Formula
	 * @generated
	 */
	public Adapter createFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.OperatorClass <em>Operator Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.OperatorClass
	 * @generated
	 */
	public Adapter createOperatorClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.TraceabilityStatusClass <em>Traceability Status Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.TraceabilityStatusClass
	 * @generated
	 */
	public Adapter createTraceabilityStatusClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.AlternativeClass <em>Alternative Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.AlternativeClass
	 * @generated
	 */
	public Adapter createAlternativeClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.MapInformation <em>Map Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.MapInformation
	 * @generated
	 */
	public Adapter createMapInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Information
	 * @generated
	 */
	public Adapter createInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.InputType <em>Input Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.InputType
	 * @generated
	 */
	public Adapter createInputTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.OutputType <em>Output Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.OutputType
	 * @generated
	 */
	public Adapter createOutputTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.GUIImplementable <em>GUI Implementable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.GUIImplementable
	 * @generated
	 */
	public Adapter createGUIImplementableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.GUI <em>GUI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.GUI
	 * @generated
	 */
	public Adapter createGUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.InputGUI <em>Input GUI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.InputGUI
	 * @generated
	 */
	public Adapter createInputGUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.OutputGUI <em>Output GUI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.OutputGUI
	 * @generated
	 */
	public Adapter createOutputGUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Libraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Libraries
	 * @generated
	 */
	public Adapter createLibrariesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.MethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.MethodDeclaration
	 * @generated
	 */
	public Adapter createMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.LayoutList <em>Layout List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.LayoutList
	 * @generated
	 */
	public Adapter createLayoutListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.be.graphbt.model.graphbt.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.be.graphbt.model.graphbt.Layout
	 * @generated
	 */
	public Adapter createLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GraphBTAdapterFactory
