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
 * A representation of the model object '<em><b>Traceability Status Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.TraceabilityStatusClass#getTraceabilityStatusLiteral <em>Traceability Status Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getTraceabilityStatusClass()
 * @model
 * @generated
 */
public interface TraceabilityStatusClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Traceability Status Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Status Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Status Literal</em>' attribute.
	 * @see #setTraceabilityStatusLiteral(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getTraceabilityStatusClass_TraceabilityStatusLiteral()
	 * @model
	 * @generated
	 */
	String getTraceabilityStatusLiteral();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.TraceabilityStatusClass#getTraceabilityStatusLiteral <em>Traceability Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traceability Status Literal</em>' attribute.
	 * @see #getTraceabilityStatusLiteral()
	 * @generated
	 */
	void setTraceabilityStatusLiteral(String value);

} // TraceabilityStatusClass
