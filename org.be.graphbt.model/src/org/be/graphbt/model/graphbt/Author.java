/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.Author#getName <em>Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Author#getContact <em>Contact</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Author#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
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
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Contact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact</em>' attribute.
	 * @see #setContact(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthor_Contact()
	 * @model
	 * @generated
	 */
	String getContact();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Author#getContact <em>Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contact</em>' attribute.
	 * @see #getContact()
	 * @generated
	 */
	void setContact(String value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see #setRole(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthor_Role()
	 * @model
	 * @generated
	 */
	String getRole();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Author#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(String value);

} // Author
