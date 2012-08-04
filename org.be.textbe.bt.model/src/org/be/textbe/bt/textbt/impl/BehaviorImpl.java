/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import java.util.Collection;

import org.be.textbe.bt.textbt.Behavior;
import org.be.textbe.bt.textbt.Relation;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.BehaviorImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.BehaviorImpl#getVal <em>Val</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.BehaviorImpl#getRelations <em>Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehaviorImpl extends AbstractBehaviorImpl implements Behavior
{
  /**
   * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected static final String REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected String ref = REF_EDEFAULT;

  /**
   * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected static final String VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected String val = VAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelations()
   * @generated
   * @ordered
   */
  protected EList<Relation> relations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorImpl()
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
    return TextbtPackage.Literals.BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(String newRef)
  {
    String oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.BEHAVIOR__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal(String newVal)
  {
    String oldVal = val;
    val = newVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.BEHAVIOR__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Relation> getRelations()
  {
    if (relations == null)
    {
      relations = new EObjectContainmentEList<Relation>(Relation.class, this, TextbtPackage.BEHAVIOR__RELATIONS);
    }
    return relations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TextbtPackage.BEHAVIOR__RELATIONS:
        return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case TextbtPackage.BEHAVIOR__REF:
        return getRef();
      case TextbtPackage.BEHAVIOR__VAL:
        return getVal();
      case TextbtPackage.BEHAVIOR__RELATIONS:
        return getRelations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TextbtPackage.BEHAVIOR__REF:
        setRef((String)newValue);
        return;
      case TextbtPackage.BEHAVIOR__VAL:
        setVal((String)newValue);
        return;
      case TextbtPackage.BEHAVIOR__RELATIONS:
        getRelations().clear();
        getRelations().addAll((Collection<? extends Relation>)newValue);
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
      case TextbtPackage.BEHAVIOR__REF:
        setRef(REF_EDEFAULT);
        return;
      case TextbtPackage.BEHAVIOR__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case TextbtPackage.BEHAVIOR__RELATIONS:
        getRelations().clear();
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
      case TextbtPackage.BEHAVIOR__REF:
        return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
      case TextbtPackage.BEHAVIOR__VAL:
        return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
      case TextbtPackage.BEHAVIOR__RELATIONS:
        return relations != null && !relations.isEmpty();
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
    result.append(" (ref: ");
    result.append(ref);
    result.append(", val: ");
    result.append(val);
    result.append(')');
    return result.toString();
  }

} //BehaviorImpl
