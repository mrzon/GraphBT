/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.EmptyNode#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getEmptyNode()
 * @model
 * @generated
 */
public interface EmptyNode extends Node {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see behaviortree.BehaviortreePackage#getEmptyNode_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link behaviortree.EmptyNode#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // EmptyNode
