/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additional Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.AdditionalInformation#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getAdditionalInformation()
 * @model
 * @generated
 */
public interface AdditionalInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Info</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.Information}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' containment reference list.
	 * @see behaviortree.BehaviortreePackage#getAdditionalInformation_Info()
	 * @model containment="true"
	 * @generated
	 */
	EList<Information> getInfo();

} // AdditionalInformation
