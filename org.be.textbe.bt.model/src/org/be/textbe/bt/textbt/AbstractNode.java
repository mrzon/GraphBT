/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getRequirementRef <em>Requirement Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getTraceabilityStatus <em>Traceability Status</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getLabel <em>Label</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.AbstractNode#getMci <em>Mci</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNode extends EObject
{
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_ComponentRef()
   * @model
   * @generated
   */
  String getComponentRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getComponentRef <em>Component Ref</em>}' attribute.
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_BehaviorRef()
   * @model
   * @generated
   */
  String getBehaviorRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getBehaviorRef <em>Behavior Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Ref</em>' attribute.
   * @see #getBehaviorRef()
   * @generated
   */
  void setBehaviorRef(String value);

  /**
   * Returns the value of the '<em><b>Requirement Ref</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Ref</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Ref</em>' attribute list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_RequirementRef()
   * @model
   * @generated
   */
  EList<String> getRequirementRef();

  /**
   * Returns the value of the '<em><b>Traceability Status</b></em>' attribute.
   * The literals are from the enumeration {@link org.be.textbe.bt.textbt.Validity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Traceability Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Traceability Status</em>' attribute.
   * @see org.be.textbe.bt.textbt.Validity
   * @see #setTraceabilityStatus(Validity)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_TraceabilityStatus()
   * @model
   * @generated
   */
  Validity getTraceabilityStatus();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getTraceabilityStatus <em>Traceability Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Traceability Status</em>' attribute.
   * @see org.be.textbe.bt.textbt.Validity
   * @see #getTraceabilityStatus()
   * @generated
   */
  void setTraceabilityStatus(Validity value);

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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_Operator()
   * @model
   * @generated
   */
  String getOperator();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see #getOperator()
   * @generated
   */
  void setOperator(String value);

  /**
   * Returns the value of the '<em><b>Component Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Set</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Set</em>' attribute.
   * @see #setComponentSet(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_ComponentSet()
   * @model
   * @generated
   */
  String getComponentSet();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getComponentSet <em>Component Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component Set</em>' attribute.
   * @see #getComponentSet()
   * @generated
   */
  void setComponentSet(String value);

  /**
   * Returns the value of the '<em><b>Mci</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mci</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mci</em>' attribute.
   * @see #setMci(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getAbstractNode_Mci()
   * @model
   * @generated
   */
  String getMci();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.AbstractNode#getMci <em>Mci</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mci</em>' attribute.
   * @see #getMci()
   * @generated
   */
  void setMci(String value);

} // AbstractNode
