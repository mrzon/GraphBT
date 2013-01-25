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
 * A representation of the model object '<em><b>Formula List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.FormulaList#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getFormulaList()
 * @model extendedMetaData="name='formulaName'"
 * @generated
 */
public interface FormulaList extends EObject {
	/**
	 * Returns the value of the '<em><b>Formula</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Formula}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getFormulaList_Formula()
	 * @model extendedMetaData="name='formulaName'"
	 * @generated
	 */
	EList<Formula> getFormula();

} // FormulaList
