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
 * A representation of the model object '<em><b>Operator Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.OperatorClass#getOperatorLiteral <em>Operator Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getOperatorClass()
 * @model
 * @generated
 */
public interface OperatorClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Operator Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Literal</em>' attribute.
	 * @see #setOperatorLiteral(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getOperatorClass_OperatorLiteral()
	 * @model
	 * @generated
	 */
	String getOperatorLiteral();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.OperatorClass#getOperatorLiteral <em>Operator Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Literal</em>' attribute.
	 * @see #getOperatorLiteral()
	 * @generated
	 */
	void setOperatorLiteral(String value);

} // OperatorClass
