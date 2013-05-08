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
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.Requirement#getKey <em>Key</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Requirement#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Requirement#getTraceabilityLink <em>Traceability Link</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Requirement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.Requirement#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement()
 * @model
 * @generated NOT
 */
public interface Requirement extends EObject, Comparable<Requirement>{
	Integer REQUIREMENT_NAME = 0x44;
	Integer REQUIREMENT_KEY = 0x45;
	Integer REQUIREMENT_DESC = 0x46;

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Requirement#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' attribute.
	 * @see #setRequirement(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement_Requirement()
	 * @model
	 * @generated
	 */
	String getRequirement();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Requirement#getRequirement <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' attribute.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(String value);

	/**
	 * Returns the value of the '<em><b>Traceability Link</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.StandardNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Link</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement_TraceabilityLink()
	 * @model
	 * @generated
	 */
	EList<StandardNode> getTraceabilityLink();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Requirement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getRequirement_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.Requirement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	//void setRequirementDesc(String string);

} // Requirement
