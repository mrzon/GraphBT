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
 * A representation of the model object '<em><b>Special Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.SpecialEdge#getType <em>Type</em>}</li>
 *   <li>{@link behaviortree.SpecialEdge#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getSpecialEdge()
 * @model
 * @generated
 */
public interface SpecialEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link behaviortree.SpecialEdgeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see behaviortree.SpecialEdgeEnum
	 * @see #setType(SpecialEdgeEnum)
	 * @see behaviortree.BehaviortreePackage#getSpecialEdge_Type()
	 * @model
	 * @generated
	 */
	SpecialEdgeEnum getType();

	/**
	 * Sets the value of the '{@link behaviortree.SpecialEdge#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see behaviortree.SpecialEdgeEnum
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
	 * @see behaviortree.BehaviortreePackage#getSpecialEdge_Destination()
	 * @model
	 * @generated
	 */
	int getDestination();

	/**
	 * Sets the value of the '{@link behaviortree.SpecialEdge#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(int value);

} // SpecialEdge
