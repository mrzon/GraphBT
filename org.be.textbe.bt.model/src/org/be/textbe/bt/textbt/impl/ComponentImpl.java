/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import java.util.Collection;

import org.be.textbe.bt.textbt.AbstractBehavior;
import org.be.textbe.bt.textbt.Component;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.ComponentImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.ComponentImpl#getVal <em>Val</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.ComponentImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.ComponentImpl#getQuantifier <em>Quantifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends EObjectImpl implements Component
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
   * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviors()
   * @generated
   * @ordered
   */
  protected EList<AbstractBehavior> behaviors;

  /**
   * The default value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected static final String QUANTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected String quantifier = QUANTIFIER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentImpl()
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
    return TextbtPackage.Literals.COMPONENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.COMPONENT__REF, oldRef, ref));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.COMPONENT__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractBehavior> getBehaviors()
  {
    if (behaviors == null)
    {
      behaviors = new EObjectContainmentEList<AbstractBehavior>(AbstractBehavior.class, this, TextbtPackage.COMPONENT__BEHAVIORS);
    }
    return behaviors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQuantifier()
  {
    return quantifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuantifier(String newQuantifier)
  {
    String oldQuantifier = quantifier;
    quantifier = newQuantifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.COMPONENT__QUANTIFIER, oldQuantifier, quantifier));
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
      case TextbtPackage.COMPONENT__BEHAVIORS:
        return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
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
      case TextbtPackage.COMPONENT__REF:
        return getRef();
      case TextbtPackage.COMPONENT__VAL:
        return getVal();
      case TextbtPackage.COMPONENT__BEHAVIORS:
        return getBehaviors();
      case TextbtPackage.COMPONENT__QUANTIFIER:
        return getQuantifier();
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
      case TextbtPackage.COMPONENT__REF:
        setRef((String)newValue);
        return;
      case TextbtPackage.COMPONENT__VAL:
        setVal((String)newValue);
        return;
      case TextbtPackage.COMPONENT__BEHAVIORS:
        getBehaviors().clear();
        getBehaviors().addAll((Collection<? extends AbstractBehavior>)newValue);
        return;
      case TextbtPackage.COMPONENT__QUANTIFIER:
        setQuantifier((String)newValue);
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
      case TextbtPackage.COMPONENT__REF:
        setRef(REF_EDEFAULT);
        return;
      case TextbtPackage.COMPONENT__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case TextbtPackage.COMPONENT__BEHAVIORS:
        getBehaviors().clear();
        return;
      case TextbtPackage.COMPONENT__QUANTIFIER:
        setQuantifier(QUANTIFIER_EDEFAULT);
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
      case TextbtPackage.COMPONENT__REF:
        return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
      case TextbtPackage.COMPONENT__VAL:
        return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
      case TextbtPackage.COMPONENT__BEHAVIORS:
        return behaviors != null && !behaviors.isEmpty();
      case TextbtPackage.COMPONENT__QUANTIFIER:
        return QUANTIFIER_EDEFAULT == null ? quantifier != null : !QUANTIFIER_EDEFAULT.equals(quantifier);
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
    result.append(", quantifier: ");
    result.append(quantifier);
    result.append(')');
    return result.toString();
  }

} //ComponentImpl
