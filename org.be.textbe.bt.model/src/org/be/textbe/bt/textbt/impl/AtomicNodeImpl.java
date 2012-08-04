/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import org.be.textbe.bt.textbt.AbstractBlockOrNode;
import org.be.textbe.bt.textbt.AtomicNode;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.AtomicNodeImpl#getChildNode <em>Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicNodeImpl extends AbstractNodeImpl implements AtomicNode
{
  /**
   * The cached value of the '{@link #getChildNode() <em>Child Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildNode()
   * @generated
   * @ordered
   */
  protected AbstractBlockOrNode childNode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicNodeImpl()
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
    return TextbtPackage.Literals.ATOMIC_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractBlockOrNode getChildNode()
  {
    return childNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildNode(AbstractBlockOrNode newChildNode, NotificationChain msgs)
  {
    AbstractBlockOrNode oldChildNode = childNode;
    childNode = newChildNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.ATOMIC_NODE__CHILD_NODE, oldChildNode, newChildNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChildNode(AbstractBlockOrNode newChildNode)
  {
    if (newChildNode != childNode)
    {
      NotificationChain msgs = null;
      if (childNode != null)
        msgs = ((InternalEObject)childNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.ATOMIC_NODE__CHILD_NODE, null, msgs);
      if (newChildNode != null)
        msgs = ((InternalEObject)newChildNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.ATOMIC_NODE__CHILD_NODE, null, msgs);
      msgs = basicSetChildNode(newChildNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.ATOMIC_NODE__CHILD_NODE, newChildNode, newChildNode));
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
      case TextbtPackage.ATOMIC_NODE__CHILD_NODE:
        return basicSetChildNode(null, msgs);
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
      case TextbtPackage.ATOMIC_NODE__CHILD_NODE:
        return getChildNode();
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
      case TextbtPackage.ATOMIC_NODE__CHILD_NODE:
        setChildNode((AbstractBlockOrNode)newValue);
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
      case TextbtPackage.ATOMIC_NODE__CHILD_NODE:
        setChildNode((AbstractBlockOrNode)null);
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
      case TextbtPackage.ATOMIC_NODE__CHILD_NODE:
        return childNode != null;
    }
    return super.eIsSet(featureID);
  }

} //AtomicNodeImpl
