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
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.Node#getIndex <em>Index</em>}</li>
 *   <li>{@link behaviortree.Node#getId <em>Id</em>}</li>
 *   <li>{@link behaviortree.Node#getEdge <em>Edge</em>}</li>
 *   <li>{@link behaviortree.Node#getSpecialE <em>Special E</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see behaviortree.BehaviortreePackage#getNode_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link behaviortree.Node#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see behaviortree.BehaviortreePackage#getNode_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link behaviortree.Node#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference.
	 * @see #setEdge(Edge)
	 * @see behaviortree.BehaviortreePackage#getNode_Edge()
	 * @model containment="true"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link behaviortree.Node#getEdge <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' containment reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

	/**
	 * Returns the value of the '<em><b>Special E</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special E</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special E</em>' reference.
	 * @see #setSpecialE(SpecialEdge)
	 * @see behaviortree.BehaviortreePackage#getNode_SpecialE()
	 * @model
	 * @generated
	 */
	SpecialEdge getSpecialE();

	/**
	 * Sets the value of the '{@link behaviortree.Node#getSpecialE <em>Special E</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Special E</em>' reference.
	 * @see #getSpecialE()
	 * @generated
	 */
	void setSpecialE(SpecialEdge value);

} // Node
