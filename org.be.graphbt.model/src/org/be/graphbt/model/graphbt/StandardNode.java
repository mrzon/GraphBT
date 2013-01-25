/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.StandardNode#getTraceabilityStatus <em>Traceability Status</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getOperator <em>Operator</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getLabel <em>Label</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getTraceabilityLink <em>Traceability Link</em>}</li>
 *   <li>{@link behaviortree.StandardNode#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link behaviortree.StandardNode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getStandardNode()
 * @model
 * @generated
 */
public interface StandardNode extends Node {
	/**
	 * Returns the value of the '<em><b>Traceability Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Link</em>' attribute.
	 * @see #setTraceabilityLink(String)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_TraceabilityLink()
	 * @model
	 * @generated
	 */
	String getTraceabilityLink();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getTraceabilityLink <em>Traceability Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traceability Link</em>' attribute.
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	void setTraceabilityLink(String value);

	/**
	 * Returns the value of the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf</em>' attribute.
	 * @see #setLeaf(boolean)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_Leaf()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#isLeaf <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf</em>' attribute.
	 * @see #isLeaf()
	 * @generated
	 */
	void setLeaf(boolean value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(StandardNode)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_Parent()
	 * @model
	 * @generated
	 */
	StandardNode getParent();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(StandardNode value);

	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Ref</em>' attribute.
	 * @see #setComponentRef(String)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_ComponentRef()
	 * @model required="true"
	 * @generated
	 */
	String getComponentRef();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' attribute.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(String value);

	/**
	 * Returns the value of the '<em><b>Behavior Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Ref</em>' attribute.
	 * @see #setBehaviorRef(String)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_BehaviorRef()
	 * @model required="true"
	 * @generated
	 */
	String getBehaviorRef();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getBehaviorRef <em>Behavior Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Ref</em>' attribute.
	 * @see #getBehaviorRef()
	 * @generated
	 */
	void setBehaviorRef(String value);

	/**
	 * Returns the value of the '<em><b>Traceability Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Status</em>' attribute.
	 * @see #setTraceabilityStatus(String)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_TraceabilityStatus()
	 * @model
	 * @generated
	 */
	String getTraceabilityStatus();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getTraceabilityStatus <em>Traceability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traceability Status</em>' attribute.
	 * @see #getTraceabilityStatus()
	 * @generated
	 */
	void setTraceabilityStatus(String value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see behaviortree.BehaviortreePackage#getStandardNode_Operator()
	 * @model
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

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
	 * @see behaviortree.BehaviortreePackage#getStandardNode_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link behaviortree.StandardNode#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	
	static final int COMPONENT_VALUE = 0x16;
	static final int BEHAVIOR_VALUE = 0x17;
	static final int TRACEABILITYLINK_VALUE = 0x18;
	static final int TRACEABILITYSTATUS_VALUE = 0x15;
	static final int OPERATOR_VALUE = 0x19;
	String toBTText();
	
	
} // StandardNode
