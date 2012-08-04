/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import org.be.textbe.bt.textbt.BehaviorTree;
import org.be.textbe.bt.textbt.ComponentList;
import org.be.textbe.bt.textbt.OptionList;
import org.be.textbe.bt.textbt.RequirementList;
import org.be.textbe.bt.textbt.TextBT;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text BT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.impl.TextBTImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.TextBTImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.TextBTImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.be.textbe.bt.textbt.impl.TextBTImpl#getBehaviorTree <em>Behavior Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextBTImpl extends EObjectImpl implements TextBT
{
  /**
   * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptions()
   * @generated
   * @ordered
   */
  protected OptionList options;

  /**
   * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirements()
   * @generated
   * @ordered
   */
  protected RequirementList requirements;

  /**
   * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponents()
   * @generated
   * @ordered
   */
  protected ComponentList components;

  /**
   * The cached value of the '{@link #getBehaviorTree() <em>Behavior Tree</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorTree()
   * @generated
   * @ordered
   */
  protected BehaviorTree behaviorTree;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TextBTImpl()
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
    return TextbtPackage.Literals.TEXT_BT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionList getOptions()
  {
    return options;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOptions(OptionList newOptions, NotificationChain msgs)
  {
    OptionList oldOptions = options;
    options = newOptions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__OPTIONS, oldOptions, newOptions);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptions(OptionList newOptions)
  {
    if (newOptions != options)
    {
      NotificationChain msgs = null;
      if (options != null)
        msgs = ((InternalEObject)options).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__OPTIONS, null, msgs);
      if (newOptions != null)
        msgs = ((InternalEObject)newOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__OPTIONS, null, msgs);
      msgs = basicSetOptions(newOptions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__OPTIONS, newOptions, newOptions));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementList getRequirements()
  {
    return requirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRequirements(RequirementList newRequirements, NotificationChain msgs)
  {
    RequirementList oldRequirements = requirements;
    requirements = newRequirements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__REQUIREMENTS, oldRequirements, newRequirements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirements(RequirementList newRequirements)
  {
    if (newRequirements != requirements)
    {
      NotificationChain msgs = null;
      if (requirements != null)
        msgs = ((InternalEObject)requirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__REQUIREMENTS, null, msgs);
      if (newRequirements != null)
        msgs = ((InternalEObject)newRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__REQUIREMENTS, null, msgs);
      msgs = basicSetRequirements(newRequirements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__REQUIREMENTS, newRequirements, newRequirements));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentList getComponents()
  {
    return components;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComponents(ComponentList newComponents, NotificationChain msgs)
  {
    ComponentList oldComponents = components;
    components = newComponents;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__COMPONENTS, oldComponents, newComponents);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponents(ComponentList newComponents)
  {
    if (newComponents != components)
    {
      NotificationChain msgs = null;
      if (components != null)
        msgs = ((InternalEObject)components).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__COMPONENTS, null, msgs);
      if (newComponents != null)
        msgs = ((InternalEObject)newComponents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__COMPONENTS, null, msgs);
      msgs = basicSetComponents(newComponents, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__COMPONENTS, newComponents, newComponents));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorTree getBehaviorTree()
  {
    return behaviorTree;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorTree(BehaviorTree newBehaviorTree, NotificationChain msgs)
  {
    BehaviorTree oldBehaviorTree = behaviorTree;
    behaviorTree = newBehaviorTree;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__BEHAVIOR_TREE, oldBehaviorTree, newBehaviorTree);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviorTree(BehaviorTree newBehaviorTree)
  {
    if (newBehaviorTree != behaviorTree)
    {
      NotificationChain msgs = null;
      if (behaviorTree != null)
        msgs = ((InternalEObject)behaviorTree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__BEHAVIOR_TREE, null, msgs);
      if (newBehaviorTree != null)
        msgs = ((InternalEObject)newBehaviorTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TextbtPackage.TEXT_BT__BEHAVIOR_TREE, null, msgs);
      msgs = basicSetBehaviorTree(newBehaviorTree, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TextbtPackage.TEXT_BT__BEHAVIOR_TREE, newBehaviorTree, newBehaviorTree));
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
      case TextbtPackage.TEXT_BT__OPTIONS:
        return basicSetOptions(null, msgs);
      case TextbtPackage.TEXT_BT__REQUIREMENTS:
        return basicSetRequirements(null, msgs);
      case TextbtPackage.TEXT_BT__COMPONENTS:
        return basicSetComponents(null, msgs);
      case TextbtPackage.TEXT_BT__BEHAVIOR_TREE:
        return basicSetBehaviorTree(null, msgs);
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
      case TextbtPackage.TEXT_BT__OPTIONS:
        return getOptions();
      case TextbtPackage.TEXT_BT__REQUIREMENTS:
        return getRequirements();
      case TextbtPackage.TEXT_BT__COMPONENTS:
        return getComponents();
      case TextbtPackage.TEXT_BT__BEHAVIOR_TREE:
        return getBehaviorTree();
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
      case TextbtPackage.TEXT_BT__OPTIONS:
        setOptions((OptionList)newValue);
        return;
      case TextbtPackage.TEXT_BT__REQUIREMENTS:
        setRequirements((RequirementList)newValue);
        return;
      case TextbtPackage.TEXT_BT__COMPONENTS:
        setComponents((ComponentList)newValue);
        return;
      case TextbtPackage.TEXT_BT__BEHAVIOR_TREE:
        setBehaviorTree((BehaviorTree)newValue);
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
      case TextbtPackage.TEXT_BT__OPTIONS:
        setOptions((OptionList)null);
        return;
      case TextbtPackage.TEXT_BT__REQUIREMENTS:
        setRequirements((RequirementList)null);
        return;
      case TextbtPackage.TEXT_BT__COMPONENTS:
        setComponents((ComponentList)null);
        return;
      case TextbtPackage.TEXT_BT__BEHAVIOR_TREE:
        setBehaviorTree((BehaviorTree)null);
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
      case TextbtPackage.TEXT_BT__OPTIONS:
        return options != null;
      case TextbtPackage.TEXT_BT__REQUIREMENTS:
        return requirements != null;
      case TextbtPackage.TEXT_BT__COMPONENTS:
        return components != null;
      case TextbtPackage.TEXT_BT__BEHAVIOR_TREE:
        return behaviorTree != null;
    }
    return super.eIsSet(featureID);
  }

} //TextBTImpl
