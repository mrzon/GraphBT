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
 * A representation of the model object '<em><b>Requirement List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.RequirementList#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.RequirementList#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirementList()
 * @model
 * @generated
 */
public interface RequirementList extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirementList_Requirements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Requirement> getRequirements();

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' attribute.
	 * @see #setProjectId(long)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirementList_ProjectId()
	 * @model
	 * @generated
	 */
	long getProjectId();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.RequirementList#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(long value);

} // RequirementList
