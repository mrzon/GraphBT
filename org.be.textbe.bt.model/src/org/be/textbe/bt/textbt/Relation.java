/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getQuestion <em>Question</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getPreposition <em>Preposition</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getLevel <em>Level</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getComponentLevel <em>Component Level</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.Relation#getMci <em>Mci</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends EObject
{

  /**
   * Returns the value of the '<em><b>Question</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Question</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Question</em>' attribute.
   * @see #setQuestion(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_Question()
   * @model required="true"
   * @generated
   */
  String getQuestion();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getQuestion <em>Question</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Question</em>' attribute.
   * @see #getQuestion()
   * @generated
   */
  void setQuestion(String value);

  /**
   * Returns the value of the '<em><b>Preposition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preposition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preposition</em>' attribute.
   * @see #setPreposition(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_Preposition()
   * @model
   * @generated
   */
  String getPreposition();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getPreposition <em>Preposition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Preposition</em>' attribute.
   * @see #getPreposition()
   * @generated
   */
  void setPreposition(String value);

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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_ComponentRef()
   * @model required="true"
   * @generated
   */
  String getComponentRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getComponentRef <em>Component Ref</em>}' attribute.
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_BehaviorRef()
   * @model
   * @generated
   */
  String getBehaviorRef();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getBehaviorRef <em>Behavior Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Ref</em>' attribute.
   * @see #getBehaviorRef()
   * @generated
   */
  void setBehaviorRef(String value);

  /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see #setLevel(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_Level()
   * @model
   * @generated
   */
  String getLevel();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getLevel <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see #getLevel()
   * @generated
   */
  void setLevel(String value);

  /**
   * Returns the value of the '<em><b>Component Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Level</em>' attribute.
   * @see #setComponentLevel(String)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_ComponentLevel()
   * @model
   * @generated
   */
  String getComponentLevel();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getComponentLevel <em>Component Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component Level</em>' attribute.
   * @see #getComponentLevel()
   * @generated
   */
  void setComponentLevel(String value);

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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_ComponentSet()
   * @model
   * @generated
   */
  String getComponentSet();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getComponentSet <em>Component Set</em>}' attribute.
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
   * @see org.be.textbe.bt.textbt.TextbtPackage#getRelation_Mci()
   * @model
   * @generated
   */
  String getMci();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Relation#getMci <em>Mci</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mci</em>' attribute.
   * @see #getMci()
   * @generated
   */
  void setMci(String value);
} // Relation
