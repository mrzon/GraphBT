/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.OperatorClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.OperatorClassImpl#getOperatorLiteral <em>Operator Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorClassImpl extends EObjectImpl implements OperatorClass {
	/**
	 * The default value of the '{@link #getOperatorLiteral() <em>Operator Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperatorLiteral() <em>Operator Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorLiteral()
	 * @generated
	 * @ordered
	 */
	protected String operatorLiteral = OPERATOR_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.OPERATOR_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatorLiteral() {
		return operatorLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorLiteral(String newOperatorLiteral) {
		String oldOperatorLiteral = operatorLiteral;
		operatorLiteral = newOperatorLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.OPERATOR_CLASS__OPERATOR_LITERAL, oldOperatorLiteral, operatorLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphBTPackage.OPERATOR_CLASS__OPERATOR_LITERAL:
				return getOperatorLiteral();
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
			case GraphBTPackage.OPERATOR_CLASS__OPERATOR_LITERAL:
				setOperatorLiteral((String)newValue);
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
			case GraphBTPackage.OPERATOR_CLASS__OPERATOR_LITERAL:
				setOperatorLiteral(OPERATOR_LITERAL_EDEFAULT);
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
			case GraphBTPackage.OPERATOR_CLASS__OPERATOR_LITERAL:
				return OPERATOR_LITERAL_EDEFAULT == null ? operatorLiteral != null : !OPERATOR_LITERAL_EDEFAULT.equals(operatorLiteral);
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
		result.append(" (operatorLiteral: ");
		result.append(operatorLiteral);
		result.append(')');
		return result.toString();
	}

} //OperatorClassImpl
