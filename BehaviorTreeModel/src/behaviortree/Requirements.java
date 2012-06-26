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
 * A representation of the model object '<em><b>Requirements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.Requirements#getKey <em>Key</em>}</li>
 *   <li>{@link behaviortree.Requirements#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getRequirements()
 * @model
 * @generated
 */
public interface Requirements extends EObject {
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
	 * @see behaviortree.BehaviortreePackage#getRequirements_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link behaviortree.Requirements#getKey <em>Key</em>}' attribute.
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
	 * @see behaviortree.BehaviortreePackage#getRequirements_Requirement()
	 * @model
	 * @generated
	 */
	String getRequirement();

	/**
	 * Sets the value of the '{@link behaviortree.Requirements#getRequirement <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' attribute.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(String value);

} // Requirements
