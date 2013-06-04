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
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getName <em>Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getText <em>Text</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getLocation <em>Location</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getId <em>Id</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getStates <em>States</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Library#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Library#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desc</em>' attribute.
	 * @see #setDesc(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Desc()
	 * @model
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Library#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Library#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Library#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.MethodDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodDeclaration> getMethods();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviors</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviors</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Behaviors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behavior> getBehaviors();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getLibrary_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

} // Library
