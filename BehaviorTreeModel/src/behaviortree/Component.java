/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.Component#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link behaviortree.Component#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link behaviortree.Component#getState <em>State</em>}</li>
 *   <li>{@link behaviortree.Component#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link behaviortree.Component#getId <em>Id</em>}</li>
 *   <li>{@link behaviortree.Component#getRelatedTo <em>Related To</em>}</li>
 *   <li>{@link behaviortree.Component#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link behaviortree.Component#getComponentRef <em>Component Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Name</em>' attribute.
	 * @see #setComponentName(String)
	 * @see behaviortree.BehaviortreePackage#getComponent_ComponentName()
	 * @model
	 * @generated
	 */
	String getComponentName();

	/**
	 * Sets the value of the '{@link behaviortree.Component#getComponentName <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Name</em>' attribute.
	 * @see #getComponentName()
	 * @generated
	 */
	void setComponentName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link behaviortree.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see behaviortree.BehaviortreePackage#getComponent_Attributes()
	 * @model
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see behaviortree.BehaviortreePackage#getComponent_State()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see behaviortree.BehaviortreePackage#getComponent_InitialState()
	 * @model
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link behaviortree.Component#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see behaviortree.BehaviortreePackage#getComponent_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link behaviortree.Component#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Related To</b></em>' reference list.
	 * The list contents are of type {@link behaviortree.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related To</em>' reference list.
	 * @see behaviortree.BehaviortreePackage#getComponent_RelatedTo()
	 * @model
	 * @generated
	 */
	EList<Component> getRelatedTo();

	/**
	 * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviors</em>' containment reference list.
	 * @see behaviortree.BehaviortreePackage#getComponent_Behaviors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behavior> getBehaviors();

	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Ref</em>' attribute.
	 * @see #setComponentRef(String)
	 * @see behaviortree.BehaviortreePackage#getComponent_ComponentRef()
	 * @model
	 * @generated
	 */
	String getComponentRef();

	/**
	 * Sets the value of the '{@link behaviortree.Component#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' attribute.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(String value);

} // Component
