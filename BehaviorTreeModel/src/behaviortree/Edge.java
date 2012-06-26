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
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.Edge#getChildNode <em>Child Node</em>}</li>
 *   <li>{@link behaviortree.Edge#getBranch <em>Branch</em>}</li>
 *   <li>{@link behaviortree.Edge#getComposition <em>Composition</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Child Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Node</em>' containment reference.
	 * @see #setChildNode(Node)
	 * @see behaviortree.BehaviortreePackage#getEdge_ChildNode()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Node getChildNode();

	/**
	 * Sets the value of the '{@link behaviortree.Edge#getChildNode <em>Child Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Node</em>' containment reference.
	 * @see #getChildNode()
	 * @generated
	 */
	void setChildNode(Node value);

	/**
	 * Returns the value of the '<em><b>Branch</b></em>' attribute.
	 * The literals are from the enumeration {@link behaviortree.Branch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch</em>' attribute.
	 * @see behaviortree.Branch
	 * @see #setBranch(Branch)
	 * @see behaviortree.BehaviortreePackage#getEdge_Branch()
	 * @model
	 * @generated
	 */
	Branch getBranch();

	/**
	 * Sets the value of the '{@link behaviortree.Edge#getBranch <em>Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch</em>' attribute.
	 * @see behaviortree.Branch
	 * @see #getBranch()
	 * @generated
	 */
	void setBranch(Branch value);

	/**
	 * Returns the value of the '<em><b>Composition</b></em>' attribute.
	 * The literals are from the enumeration {@link behaviortree.Composition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition</em>' attribute.
	 * @see behaviortree.Composition
	 * @see #setComposition(Composition)
	 * @see behaviortree.BehaviortreePackage#getEdge_Composition()
	 * @model
	 * @generated
	 */
	Composition getComposition();

	/**
	 * Sets the value of the '{@link behaviortree.Edge#getComposition <em>Composition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition</em>' attribute.
	 * @see behaviortree.Composition
	 * @see #getComposition()
	 * @generated
	 */
	void setComposition(Composition value);

} // Edge
