/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BehaviorImpl#getBehaviorType <em>Behavior Type</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BehaviorImpl#getBehaviorName <em>Behavior Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BehaviorImpl#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BehaviorImpl#getBehaviorDesc <em>Behavior Desc</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BehaviorImpl#getTechnicalDetail <em>Technical Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorImpl extends EObjectImpl implements Behavior {
	/**
	 * The default value of the '{@link #getBehaviorType() <em>Behavior Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorType()
	 * @generated
	 * @ordered
	 */
	protected static final BehaviorType BEHAVIOR_TYPE_EDEFAULT = BehaviorType.STATE_REALIZATION;

	/**
	 * The cached value of the '{@link #getBehaviorType() <em>Behavior Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorType()
	 * @generated
	 * @ordered
	 */
	protected BehaviorType behaviorType = BEHAVIOR_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBehaviorName() <em>Behavior Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorName()
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBehaviorName() <em>Behavior Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorName()
	 * @generated
	 * @ordered
	 */
	protected String behaviorName = BEHAVIOR_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getBehaviorDesc() <em>Behavior Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBehaviorDesc() <em>Behavior Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorDesc()
	 * @generated
	 * @ordered
	 */
	protected String behaviorDesc = BEHAVIOR_DESC_EDEFAULT;

	/**
	 * The default value of the '{@link #getTechnicalDetail() <em>Technical Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalDetail()
	 * @generated
	 * @ordered
	 */
	protected static final String TECHNICAL_DETAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTechnicalDetail() <em>Technical Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalDetail()
	 * @generated
	 * @ordered
	 */
	protected String technicalDetail = TECHNICAL_DETAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorType getBehaviorType() {
		return behaviorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorType(BehaviorType newBehaviorType) {
		BehaviorType oldBehaviorType = behaviorType;
		behaviorType = newBehaviorType == null ? BEHAVIOR_TYPE_EDEFAULT : newBehaviorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BEHAVIOR__BEHAVIOR_TYPE, oldBehaviorType, behaviorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBehaviorName() {
		return behaviorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorName(String newBehaviorName) {
		String oldBehaviorName = behaviorName;
		behaviorName = newBehaviorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BEHAVIOR__BEHAVIOR_NAME, oldBehaviorName, behaviorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBehaviorRef() {
		return behaviorRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorRef(String newBehaviorRef) {
		String oldBehaviorRef = behaviorRef;
		behaviorRef = newBehaviorRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BEHAVIOR__BEHAVIOR_REF, oldBehaviorRef, behaviorRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBehaviorDesc() {
		return behaviorDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorDesc(String newBehaviorDesc) {
		String oldBehaviorDesc = behaviorDesc;
		behaviorDesc = newBehaviorDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BEHAVIOR__BEHAVIOR_DESC, oldBehaviorDesc, behaviorDesc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnicalDetail() {
		return technicalDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalDetail(String newTechnicalDetail) {
		String oldTechnicalDetail = technicalDetail;
		technicalDetail = newTechnicalDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BEHAVIOR__TECHNICAL_DETAIL, oldTechnicalDetail, technicalDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_TYPE:
				return getBehaviorType();
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_NAME:
				return getBehaviorName();
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_REF:
				return getBehaviorRef();
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_DESC:
				return getBehaviorDesc();
			case GraphBTPackage.BEHAVIOR__TECHNICAL_DETAIL:
				return getTechnicalDetail();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_TYPE:
				setBehaviorType((BehaviorType)newValue);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_NAME:
				setBehaviorName((String)newValue);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_REF:
				setBehaviorRef((String)newValue);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_DESC:
				setBehaviorDesc((String)newValue);
				return;
			case GraphBTPackage.BEHAVIOR__TECHNICAL_DETAIL:
				setTechnicalDetail((String)newValue);
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
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_TYPE:
				setBehaviorType(BEHAVIOR_TYPE_EDEFAULT);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_NAME:
				setBehaviorName(BEHAVIOR_NAME_EDEFAULT);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_REF:
				setBehaviorRef(BEHAVIOR_REF_EDEFAULT);
				return;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_DESC:
				setBehaviorDesc(BEHAVIOR_DESC_EDEFAULT);
				return;
			case GraphBTPackage.BEHAVIOR__TECHNICAL_DETAIL:
				setTechnicalDetail(TECHNICAL_DETAIL_EDEFAULT);
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
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_TYPE:
				return behaviorType != BEHAVIOR_TYPE_EDEFAULT;
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_NAME:
				return BEHAVIOR_NAME_EDEFAULT == null ? behaviorName != null : !BEHAVIOR_NAME_EDEFAULT.equals(behaviorName);
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_REF:
				return BEHAVIOR_REF_EDEFAULT == null ? behaviorRef != null : !BEHAVIOR_REF_EDEFAULT.equals(behaviorRef);
			case GraphBTPackage.BEHAVIOR__BEHAVIOR_DESC:
				return BEHAVIOR_DESC_EDEFAULT == null ? behaviorDesc != null : !BEHAVIOR_DESC_EDEFAULT.equals(behaviorDesc);
			case GraphBTPackage.BEHAVIOR__TECHNICAL_DETAIL:
				return TECHNICAL_DETAIL_EDEFAULT == null ? technicalDetail != null : !TECHNICAL_DETAIL_EDEFAULT.equals(technicalDetail);
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
		result.append(behaviorType.getOpenBracket());
		result.append(behaviorName);
		result.append(behaviorType.getCloseBracket());
		return result.toString();
	}

//	@Override
//	public String toString() {
//		if (eIsProxy()) return super.toString();
//
//		StringBuffer result = new StringBuffer(super.toString());
//		result.append(" (behaviorType: ");
//		result.append(behaviorType);
//		result.append(", behaviorName: ");
//		result.append(behaviorName);
//		result.append(", behaviorRef: ");
//		result.append(behaviorRef);
//		result.append(')');
//		return result.toString();
//	}
	
	
} //BehaviorImpl
