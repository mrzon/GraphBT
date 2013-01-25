/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.GraphBTPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.AlternativeClassImpl#getAlternativeAttribute <em>Alternative Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeClassImpl extends EObjectImpl implements AlternativeClass {
	/**
	 * The default value of the '{@link #getAlternativeAttribute() <em>Alternative Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativeAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ALTERNATIVE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlternativeAttribute() <em>Alternative Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativeAttribute()
	 * @generated
	 * @ordered
	 */
	protected String alternativeAttribute = ALTERNATIVE_ATTRIBUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlternativeClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.ALTERNATIVE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlternativeAttribute() {
		return alternativeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlternativeAttribute(String newAlternativeAttribute) {
		String oldAlternativeAttribute = alternativeAttribute;
		alternativeAttribute = newAlternativeAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE, oldAlternativeAttribute, alternativeAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphBTPackage.ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE:
				return getAlternativeAttribute();
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
			case GraphBTPackage.ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE:
				setAlternativeAttribute((String)newValue);
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
			case GraphBTPackage.ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE:
				setAlternativeAttribute(ALTERNATIVE_ATTRIBUTE_EDEFAULT);
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
			case GraphBTPackage.ALTERNATIVE_CLASS__ALTERNATIVE_ATTRIBUTE:
				return ALTERNATIVE_ATTRIBUTE_EDEFAULT == null ? alternativeAttribute != null : !ALTERNATIVE_ATTRIBUTE_EDEFAULT.equals(alternativeAttribute);
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
		result.append(" (alternativeAttribute: ");
		result.append(alternativeAttribute);
		result.append(')');
		return result.toString();
	}

} //AlternativeClassImpl
