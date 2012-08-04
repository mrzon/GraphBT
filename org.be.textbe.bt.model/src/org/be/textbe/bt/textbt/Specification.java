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
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Specification#getComponents <em>Components</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Specification#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Specification#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject
{
  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.Component}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getSpecification_Components()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Component> getComponents();

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.bt.textbt.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference list.
   * @see org.be.textbe.bt.textbt.TextbtPackage#getSpecification_Requirements()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Requirement> getRequirements();

  /**
   * Returns the value of the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' containment reference.
   * @see #setRoot(Sequence)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getSpecification_Root()
   * @model containment="true"
   * @generated
   */
  Sequence getRoot();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Specification#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(Sequence value);

} // Specification
