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

import behaviortree.Component;
import behaviortree.Requirements;
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
 *   <li>{@link behaviortree.impl.BEModelImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link behaviortree.impl.BEModelImpl#getRequirements <em>Requirements</em>}</li>
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
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirements> requirements;

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
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectResolvingEList<Component>(Component.class, this, BehaviortreePackage.BE_MODEL__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirements> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirements>(Requirements.class, this, BehaviortreePackage.BE_MODEL__REQUIREMENTS);
		}
		return requirements;
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
			case BehaviortreePackage.BE_MODEL__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
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
			case BehaviortreePackage.BE_MODEL__COMPONENTS:
				return getComponents();
			case BehaviortreePackage.BE_MODEL__REQUIREMENTS:
				return getRequirements();
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
			case BehaviortreePackage.BE_MODEL__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case BehaviortreePackage.BE_MODEL__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirements>)newValue);
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
			case BehaviortreePackage.BE_MODEL__COMPONENTS:
				getComponents().clear();
				return;
			case BehaviortreePackage.BE_MODEL__REQUIREMENTS:
				getRequirements().clear();
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
			case BehaviortreePackage.BE_MODEL__COMPONENTS:
				return components != null && !components.isEmpty();
			case BehaviortreePackage.BE_MODEL__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BEModelImpl
