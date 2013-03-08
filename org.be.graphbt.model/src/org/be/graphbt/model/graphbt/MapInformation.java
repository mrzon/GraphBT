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
 * A representation of the model object '<em><b>Map Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.MapInformation#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getMapInformation()
 * @model
 * @generated
 */
public interface MapInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Info</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Information}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getMapInformation_Info()
	 * @model containment="true"
	 * @generated
	 */
	EList<Information> getInfo();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getValue(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(String key, String value);

	void removeKey(String name);

} // MapInformation
