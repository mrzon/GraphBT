/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BEModel;
import behaviortree.BehaviorTree;
import behaviortree.BehaviortreePackage;
import behaviortree.ComponentList;
import behaviortree.FormulaList;
import behaviortree.RequirementList;
import behaviortree.*;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BE Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behaviortree.impl.BEModelImpl#getDbt <em>Dbt</em>}</li>
 *   <li>{@link behaviortree.impl.BEModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link behaviortree.impl.BEModelImpl#getComponentList <em>Component List</em>}</li>
 *   <li>{@link behaviortree.impl.BEModelImpl#getRequirementList <em>Requirement List</em>}</li>
 *   <li>{@link behaviortree.impl.BEModelImpl#getFormulaList <em>Formula List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BEModelImpl extends EObjectImpl implements BEModel {
	/**
	 * The cached value of the '{@link #getDbt() <em>Dbt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbt()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTree dbt;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponentList() <em>Component List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentList()
	 * @generated
	 * @ordered
	 */
	protected ComponentList componentList;

	/**
	 * The cached value of the '{@link #getRequirementList() <em>Requirement List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementList()
	 * @generated
	 * @ordered
	 */
	protected RequirementList requirementList;

	/**
	 * The cached value of the '{@link #getFormulaList() <em>Formula List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaList()
	 * @generated
	 * @ordered
	 */
	protected FormulaList formulaList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BEModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviortreePackage.Literals.BE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree getDbt() {
		return dbt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDbt(BehaviorTree newDbt, NotificationChain msgs) {
		BehaviorTree oldDbt = dbt;
		dbt = newDbt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__DBT, oldDbt, newDbt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbt(BehaviorTree newDbt) {
		if (newDbt != dbt) {
			NotificationChain msgs = null;
			if (dbt != null)
				msgs = ((InternalEObject)dbt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__DBT, null, msgs);
			if (newDbt != null)
				msgs = ((InternalEObject)newDbt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__DBT, null, msgs);
			msgs = basicSetDbt(newDbt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__DBT, newDbt, newDbt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentList getComponentList() {
		return componentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentList(ComponentList newComponentList, NotificationChain msgs) {
		ComponentList oldComponentList = componentList;
		componentList = newComponentList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__COMPONENT_LIST, oldComponentList, newComponentList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentList(ComponentList newComponentList) {
		if (newComponentList != componentList) {
			NotificationChain msgs = null;
			if (componentList != null)
				msgs = ((InternalEObject)componentList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__COMPONENT_LIST, null, msgs);
			if (newComponentList != null)
				msgs = ((InternalEObject)newComponentList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__COMPONENT_LIST, null, msgs);
			msgs = basicSetComponentList(newComponentList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__COMPONENT_LIST, newComponentList, newComponentList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementList getRequirementList() {
		return requirementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirementList(RequirementList newRequirementList, NotificationChain msgs) {
		RequirementList oldRequirementList = requirementList;
		requirementList = newRequirementList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST, oldRequirementList, newRequirementList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementList(RequirementList newRequirementList) {
		if (newRequirementList != requirementList) {
			NotificationChain msgs = null;
			if (requirementList != null)
				msgs = ((InternalEObject)requirementList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST, null, msgs);
			if (newRequirementList != null)
				msgs = ((InternalEObject)newRequirementList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST, null, msgs);
			msgs = basicSetRequirementList(newRequirementList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST, newRequirementList, newRequirementList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaList getFormulaList() {
		if (formulaList != null && formulaList.eIsProxy()) {
			InternalEObject oldFormulaList = (InternalEObject)formulaList;
			formulaList = (FormulaList)eResolveProxy(oldFormulaList);
			if (formulaList != oldFormulaList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.BE_MODEL__FORMULA_LIST, oldFormulaList, formulaList));
			}
		}
		return formulaList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaList basicGetFormulaList() {
		return formulaList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaList(FormulaList newFormulaList) {
		FormulaList oldFormulaList = formulaList;
		formulaList = newFormulaList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.BE_MODEL__FORMULA_LIST, oldFormulaList, formulaList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BehaviortreePackage.BE_MODEL__DBT:
				return basicSetDbt(null, msgs);
			case BehaviortreePackage.BE_MODEL__COMPONENT_LIST:
				return basicSetComponentList(null, msgs);
			case BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST:
				return basicSetRequirementList(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviortreePackage.BE_MODEL__DBT:
				return getDbt();
			case BehaviortreePackage.BE_MODEL__NAME:
				return getName();
			case BehaviortreePackage.BE_MODEL__COMPONENT_LIST:
				return getComponentList();
			case BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST:
				return getRequirementList();
			case BehaviortreePackage.BE_MODEL__FORMULA_LIST:
				if (resolve) return getFormulaList();
				return basicGetFormulaList();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviortreePackage.BE_MODEL__DBT:
				setDbt((BehaviorTree)newValue);
				return;
			case BehaviortreePackage.BE_MODEL__NAME:
				setName((String)newValue);
				return;
			case BehaviortreePackage.BE_MODEL__COMPONENT_LIST:
				setComponentList((ComponentList)newValue);
				return;
			case BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST:
				setRequirementList((RequirementList)newValue);
				return;
			case BehaviortreePackage.BE_MODEL__FORMULA_LIST:
				setFormulaList((FormulaList)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case BehaviortreePackage.BE_MODEL__DBT:
				setDbt((BehaviorTree)null);
				return;
			case BehaviortreePackage.BE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BehaviortreePackage.BE_MODEL__COMPONENT_LIST:
				setComponentList((ComponentList)null);
				return;
			case BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST:
				setRequirementList((RequirementList)null);
				return;
			case BehaviortreePackage.BE_MODEL__FORMULA_LIST:
				setFormulaList((FormulaList)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BehaviortreePackage.BE_MODEL__DBT:
				return dbt != null;
			case BehaviortreePackage.BE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BehaviortreePackage.BE_MODEL__COMPONENT_LIST:
				return componentList != null;
			case BehaviortreePackage.BE_MODEL__REQUIREMENT_LIST:
				return requirementList != null;
			case BehaviortreePackage.BE_MODEL__FORMULA_LIST:
				return formulaList != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(this.requirementList.toString());
		result.append(this.componentList.toString());
		
		return result.toString();
	}

} //BEModelImpl
