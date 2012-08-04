/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import org.be.textbe.bt.textbt.BehaviorTree;
import org.be.textbe.bt.textbt.Node;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.BehaviorTreeImpl#getRootNode <em>Root Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorTreeImpl extends EObjectImpl implements BehaviorTree
{
  /**
   * The cached value of the '{@link #getRootNode() <em>Root Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootNode()
   * @generated
   * @ordered
   */
  protected Node rootNode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorTreeImpl()
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
    return TextbtPackage.Literals.BEHAVIOR_TREE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getRootNode()
  {
    return rootNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRootNode(Node newRootNode, NotificationChain msgs)
  {
    Node oldRootNode = rootNode;
    rootNode = newRootNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.BEHAVIOR_TREE__ROOT_NODE, oldRootNode, newRootNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRootNode(Node newRootNode)
  {
    if (newRootNode != rootNode)
    {
      NotificationChain msgs = null;
      if (rootNode != null)
        msgs = ((InternalEObject)rootNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.BEHAVIOR_TREE__ROOT_NODE, null, msgs);
      if (newRootNode != null)
        msgs = ((InternalEObject)newRootNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.BEHAVIOR_TREE__ROOT_NODE, null, msgs);
      msgs = basicSetRootNode(newRootNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.BEHAVIOR_TREE__ROOT_NODE, newRootNode, newRootNode));
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
      case TextbtPackage.BEHAVIOR_TREE__ROOT_NODE:
        return basicSetRootNode(null, msgs);
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
      case TextbtPackage.BEHAVIOR_TREE__ROOT_NODE:
        return getRootNode();
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
      case TextbtPackage.BEHAVIOR_TREE__ROOT_NODE:
        setRootNode((Node)newValue);
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
      case TextbtPackage.BEHAVIOR_TREE__ROOT_NODE:
        setRootNode((Node)null);
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
      case TextbtPackage.BEHAVIOR_TREE__ROOT_NODE:
        return rootNode != null;
    }
    return super.eIsSet(featureID);
  }

} //BehaviorTreeImpl
