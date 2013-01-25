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
 * A representation of the model object '<em><b>Special Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.SpecialEdge#getType <em>Type</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.SpecialEdge#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getSpecialEdge()
 * @model
 * @generated
 */
public interface SpecialEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.be.graphbt.model.graphbt.SpecialEdgeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.be.graphbt.model.graphbt.SpecialEdgeEnum
	 * @see #setType(SpecialEdgeEnum)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getSpecialEdge_Type()
	 * @model
	 * @generated
	 */
	SpecialEdgeEnum getType();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.SpecialEdge#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.be.graphbt.model.graphbt.SpecialEdgeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(SpecialEdgeEnum value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(int)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getSpecialEdge_Destination()
	 * @model
	 * @generated
	 */
	int getDestination();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.SpecialEdge#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(int value);

} // SpecialEdge
