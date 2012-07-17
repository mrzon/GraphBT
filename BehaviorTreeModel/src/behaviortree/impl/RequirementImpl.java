/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BehaviortreePackage;
import behaviortree.Requirement;
import behaviortree.StandardNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behaviortree.impl.RequirementImpl#getKey <em>Key</em>}</li>
 *   <li>{@link behaviortree.impl.RequirementImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link behaviortree.impl.RequirementImpl#getTraceabilityLink <em>Traceability Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends EObjectImpl implements Requirement {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirement() <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected String requirement = REQUIREMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTraceabilityLink() <em>Traceability Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityLink()
	 * @generated
	 * @ordered
	 */
	protected EList<StandardNode> traceabilityLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviortreePackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.REQUIREMENT__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(String newRequirement) {
		String oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.REQUIREMENT__REQUIREMENT, oldRequirement, requirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StandardNode> getTraceabilityLink() {
		if (traceabilityLink == null) {
			traceabilityLink = new EObjectResolvingEList<StandardNode>(StandardNode.class, this, BehaviortreePackage.REQUIREMENT__TRACEABILITY_LINK);
		}
		return traceabilityLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviortreePackage.REQUIREMENT__KEY:
				return getKey();
			case BehaviortreePackage.REQUIREMENT__REQUIREMENT:
				return getRequirement();
			case BehaviortreePackage.REQUIREMENT__TRACEABILITY_LINK:
				return getTraceabilityLink();
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
			case BehaviortreePackage.REQUIREMENT__KEY:
				setKey((String)newValue);
				return;
			case BehaviortreePackage.REQUIREMENT__REQUIREMENT:
				setRequirement((String)newValue);
				return;
			case BehaviortreePackage.REQUIREMENT__TRACEABILITY_LINK:
				getTraceabilityLink().clear();
				getTraceabilityLink().addAll((Collection<? extends StandardNode>)newValue);
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
			case BehaviortreePackage.REQUIREMENT__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case BehaviortreePackage.REQUIREMENT__REQUIREMENT:
				setRequirement(REQUIREMENT_EDEFAULT);
				return;
			case BehaviortreePackage.REQUIREMENT__TRACEABILITY_LINK:
				getTraceabilityLink().clear();
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
			case BehaviortreePackage.REQUIREMENT__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case BehaviortreePackage.REQUIREMENT__REQUIREMENT:
				return REQUIREMENT_EDEFAULT == null ? requirement != null : !REQUIREMENT_EDEFAULT.equals(requirement);
			case BehaviortreePackage.REQUIREMENT__TRACEABILITY_LINK:
				return traceabilityLink != null && !traceabilityLink.isEmpty();
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
		result.append(" (Key: ");
		result.append(key);
		result.append(", Requirement: ");
		result.append(requirement);
		result.append(')');
		return result.toString();
	}

} //RequirementImpl
