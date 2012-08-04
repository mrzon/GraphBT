/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import org.be.textbe.bt.textbt.Relation;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getQuestion <em>Question</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getPreposition <em>Preposition</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getComponentLevel <em>Component Level</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.RelationImpl#getMci <em>Mci</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends EObjectImpl implements Relation
{
  /**
   * The default value of the '{@link #getQuestion() <em>Question</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuestion()
   * @generated
   * @ordered
   */
  protected static final String QUESTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQuestion() <em>Question</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuestion()
   * @generated
   * @ordered
   */
  protected String question = QUESTION_EDEFAULT;

  /**
   * The default value of the '{@link #getPreposition() <em>Preposition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreposition()
   * @generated
   * @ordered
   */
  protected static final String PREPOSITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPreposition() <em>Preposition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreposition()
   * @generated
   * @ordered
   */
  protected String preposition = PREPOSITION_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentRef()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentRef()
   * @generated
   * @ordered
   */
  protected String componentRef = COMPONENT_REF_EDEFAULT;

  /**
   * The default value of the '{@link #getBehaviorRef() <em>Behavior Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorRef()
   * @generated
   * @ordered
   */
  protected static final String BEHAVIOR_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBehaviorRef() <em>Behavior Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorRef()
   * @generated
   * @ordered
   */
  protected String behaviorRef = BEHAVIOR_REF_EDEFAULT;

  /**
   * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final String LEVEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected String level = LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentLevel() <em>Component Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentLevel()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_LEVEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentLevel() <em>Component Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentLevel()
   * @generated
   * @ordered
   */
  protected String componentLevel = COMPONENT_LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentSet() <em>Component Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentSet()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_SET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentSet() <em>Component Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentSet()
   * @generated
   * @ordered
   */
  protected String componentSet = COMPONENT_SET_EDEFAULT;

  /**
   * The default value of the '{@link #getMci() <em>Mci</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMci()
   * @generated
   * @ordered
   */
  protected static final String MCI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMci() <em>Mci</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMci()
   * @generated
   * @ordered
   */
  protected String mci = MCI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TextbtPackage.Literals.RELATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQuestion()
  {
    return question;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuestion(String newQuestion)
  {
    String oldQuestion = question;
    question = newQuestion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__QUESTION, oldQuestion, question));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPreposition()
  {
    return preposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreposition(String newPreposition)
  {
    String oldPreposition = preposition;
    preposition = newPreposition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__PREPOSITION, oldPreposition, preposition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComponentRef()
  {
    return componentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentRef(String newComponentRef)
  {
    String oldComponentRef = componentRef;
    componentRef = newComponentRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__COMPONENT_REF, oldComponentRef, componentRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBehaviorRef()
  {
    return behaviorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviorRef(String newBehaviorRef)
  {
    String oldBehaviorRef = behaviorRef;
    behaviorRef = newBehaviorRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__BEHAVIOR_REF, oldBehaviorRef, behaviorRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLevel()
  {
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLevel(String newLevel)
  {
    String oldLevel = level;
    level = newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__LEVEL, oldLevel, level));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComponentLevel()
  {
    return componentLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentLevel(String newComponentLevel)
  {
    String oldComponentLevel = componentLevel;
    componentLevel = newComponentLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__COMPONENT_LEVEL, oldComponentLevel, componentLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComponentSet()
  {
    return componentSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentSet(String newComponentSet)
  {
    String oldComponentSet = componentSet;
    componentSet = newComponentSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__COMPONENT_SET, oldComponentSet, componentSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMci()
  {
    return mci;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMci(String newMci)
  {
    String oldMci = mci;
    mci = newMci;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.RELATION__MCI, oldMci, mci));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TextbtPackage.RELATION__QUESTION:
        return getQuestion();
      case TextbtPackage.RELATION__PREPOSITION:
        return getPreposition();
      case TextbtPackage.RELATION__COMPONENT_REF:
        return getComponentRef();
      case TextbtPackage.RELATION__BEHAVIOR_REF:
        return getBehaviorRef();
      case TextbtPackage.RELATION__LEVEL:
        return getLevel();
      case TextbtPackage.RELATION__COMPONENT_LEVEL:
        return getComponentLevel();
      case TextbtPackage.RELATION__COMPONENT_SET:
        return getComponentSet();
      case TextbtPackage.RELATION__MCI:
        return getMci();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TextbtPackage.RELATION__QUESTION:
        setQuestion((String)newValue);
        return;
      case TextbtPackage.RELATION__PREPOSITION:
        setPreposition((String)newValue);
        return;
      case TextbtPackage.RELATION__COMPONENT_REF:
        setComponentRef((String)newValue);
        return;
      case TextbtPackage.RELATION__BEHAVIOR_REF:
        setBehaviorRef((String)newValue);
        return;
      case TextbtPackage.RELATION__LEVEL:
        setLevel((String)newValue);
        return;
      case TextbtPackage.RELATION__COMPONENT_LEVEL:
        setComponentLevel((String)newValue);
        return;
      case TextbtPackage.RELATION__COMPONENT_SET:
        setComponentSet((String)newValue);
        return;
      case TextbtPackage.RELATION__MCI:
        setMci((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TextbtPackage.RELATION__QUESTION:
        setQuestion(QUESTION_EDEFAULT);
        return;
      case TextbtPackage.RELATION__PREPOSITION:
        setPreposition(PREPOSITION_EDEFAULT);
        return;
      case TextbtPackage.RELATION__COMPONENT_REF:
        setComponentRef(COMPONENT_REF_EDEFAULT);
        return;
      case TextbtPackage.RELATION__BEHAVIOR_REF:
        setBehaviorRef(BEHAVIOR_REF_EDEFAULT);
        return;
      case TextbtPackage.RELATION__LEVEL:
        setLevel(LEVEL_EDEFAULT);
        return;
      case TextbtPackage.RELATION__COMPONENT_LEVEL:
        setComponentLevel(COMPONENT_LEVEL_EDEFAULT);
        return;
      case TextbtPackage.RELATION__COMPONENT_SET:
        setComponentSet(COMPONENT_SET_EDEFAULT);
        return;
      case TextbtPackage.RELATION__MCI:
        setMci(MCI_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TextbtPackage.RELATION__QUESTION:
        return QUESTION_EDEFAULT == null ? question != null : !QUESTION_EDEFAULT.equals(question);
      case TextbtPackage.RELATION__PREPOSITION:
        return PREPOSITION_EDEFAULT == null ? preposition != null : !PREPOSITION_EDEFAULT.equals(preposition);
      case TextbtPackage.RELATION__COMPONENT_REF:
        return COMPONENT_REF_EDEFAULT == null ? componentRef != null : !COMPONENT_REF_EDEFAULT.equals(componentRef);
      case TextbtPackage.RELATION__BEHAVIOR_REF:
        return BEHAVIOR_REF_EDEFAULT == null ? behaviorRef != null : !BEHAVIOR_REF_EDEFAULT.equals(behaviorRef);
      case TextbtPackage.RELATION__LEVEL:
        return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
      case TextbtPackage.RELATION__COMPONENT_LEVEL:
        return COMPONENT_LEVEL_EDEFAULT == null ? componentLevel != null : !COMPONENT_LEVEL_EDEFAULT.equals(componentLevel);
      case TextbtPackage.RELATION__COMPONENT_SET:
        return COMPONENT_SET_EDEFAULT == null ? componentSet != null : !COMPONENT_SET_EDEFAULT.equals(componentSet);
      case TextbtPackage.RELATION__MCI:
        return MCI_EDEFAULT == null ? mci != null : !MCI_EDEFAULT.equals(mci);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (question: ");
    result.append(question);
    result.append(", preposition: ");
    result.append(preposition);
    result.append(", componentRef: ");
    result.append(componentRef);
    result.append(", behaviorRef: ");
    result.append(behaviorRef);
    result.append(", level: ");
    result.append(level);
    result.append(", componentLevel: ");
    result.append(componentLevel);
    result.append(", componentSet: ");
    result.append(componentSet);
    result.append(", mci: ");
    result.append(mci);
    result.append(')');
    return result.toString();
  }

} //RelationImpl
