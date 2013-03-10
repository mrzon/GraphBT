/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

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
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getState <em>State</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getId <em>Id</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getRelatedTo <em>Related To</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getComponentDesc <em>Component Desc</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#isEnumerated <em>Enumerated</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Component#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent()
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
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_ComponentName()
	 * @model
	 * @generated
	 */
	String getComponentName();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#getComponentName <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Name</em>' attribute.
	 * @see #getComponentName()
	 * @generated
	 */
	void setComponentName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_State()
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
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_InitialState()
	 * @model
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#getInitialState <em>Initial State</em>}' reference.
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
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Related To</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related To</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_RelatedTo()
	 * @model
	 * @generated
	 */
	EList<Component> getRelatedTo();

	/**
	 * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviors</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_Behaviors()
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
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_ComponentRef()
	 * @model
	 * @generated
	 */
	String getComponentRef();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' attribute.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(String value);

	/**
	 * Returns the value of the '<em><b>Component Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Desc</em>' attribute.
	 * @see #setComponentDesc(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_ComponentDesc()
	 * @model
	 * @generated
	 */
	String getComponentDesc();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#getComponentDesc <em>Component Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Desc</em>' attribute.
	 * @see #getComponentDesc()
	 * @generated
	 */
	void setComponentDesc(String value);

	/**
	 * Returns the value of the '<em><b>Enumerated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerated</em>' attribute.
	 * @see #setEnumerated(boolean)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_Enumerated()
	 * @model
	 * @generated
	 */
	boolean isEnumerated();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Component#isEnumerated <em>Enumerated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumerated</em>' attribute.
	 * @see #isEnumerated()
	 * @generated
	 */
	void setEnumerated(boolean value);

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Library}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getComponent_Uses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Library> getUses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Attribute getAttribute(String name);

	static final int NAME_VALUE = 0x12;
	static final int REF_VALUE = 0x13;
	static final int DESC_VALUE = 0x14;
	static final int ENUM_VALUE = 0x15;
	
} // Component