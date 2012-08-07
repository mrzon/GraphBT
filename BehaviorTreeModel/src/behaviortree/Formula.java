/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.Formula#getFormulaName <em>Formula Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getFormula()
 * @model extendedMetaData="name='formulaName'"
 * @generated
 */
public interface Formula extends EObject {
	/**
	 * Returns the value of the '<em><b>Formula Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula Name</em>' attribute.
	 * @see #setFormulaName(String)
	 * @see behaviortree.BehaviortreePackage#getFormula_FormulaName()
	 * @model
	 * @generated
	 */
	String getFormulaName();

	/**
	 * Sets the value of the '{@link behaviortree.Formula#getFormulaName <em>Formula Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula Name</em>' attribute.
	 * @see #getFormulaName()
	 * @generated
	 */
	void setFormulaName(String value);

} // Formula
