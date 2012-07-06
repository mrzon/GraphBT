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
 * A representation of the model object '<em><b>BE Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.BEModel#getDbt <em>Dbt</em>}</li>
 *   <li>{@link behaviortree.BEModel#getName <em>Name</em>}</li>
 *   <li>{@link behaviortree.BEModel#getComponents <em>Components</em>}</li>
 *   <li>{@link behaviortree.BEModel#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getBEModel()
 * @model
 * @generated
 */
public interface BEModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Dbt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dbt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dbt</em>' containment reference.
	 * @see #setDbt(BehaviorTree)
	 * @see behaviortree.BehaviortreePackage#getBEModel_Dbt()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorTree getDbt();

	/**
	 * Sets the value of the '{@link behaviortree.BEModel#getDbt <em>Dbt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dbt</em>' containment reference.
	 * @see #getDbt()
	 * @generated
	 */
	void setDbt(BehaviorTree value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see behaviortree.BehaviortreePackage#getBEModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link behaviortree.BEModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link behaviortree.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see behaviortree.BehaviortreePackage#getBEModel_Components()
	 * @model
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.Requirements}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see behaviortree.BehaviortreePackage#getBEModel_Requirements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Requirements> getRequirements();

} // BEModel
