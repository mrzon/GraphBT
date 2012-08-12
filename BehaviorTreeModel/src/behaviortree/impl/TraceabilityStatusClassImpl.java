/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BehaviortreePackage;
import behaviortree.TraceabilityStatusClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traceability Status Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behaviortree.impl.TraceabilityStatusClassImpl#getTraceabilityStatusLiteral <em>Traceability Status Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceabilityStatusClassImpl extends EObjectImpl implements TraceabilityStatusClass {
	/**
	 * The default value of the '{@link #getTraceabilityStatusLiteral() <em>Traceability Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityStatusLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACEABILITY_STATUS_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceabilityStatusLiteral() <em>Traceability Status Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityStatusLiteral()
	 * @generated
	 * @ordered
	 */
	protected String traceabilityStatusLiteral = TRACEABILITY_STATUS_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceabilityStatusClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviortreePackage.Literals.TRACEABILITY_STATUS_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceabilityStatusLiteral() {
		return traceabilityStatusLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceabilityStatusLiteral(String newTraceabilityStatusLiteral) {
		String oldTraceabilityStatusLiteral = traceabilityStatusLiteral;
		traceabilityStatusLiteral = newTraceabilityStatusLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL, oldTraceabilityStatusLiteral, traceabilityStatusLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviortreePackage.TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL:
				return getTraceabilityStatusLiteral();
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
			case BehaviortreePackage.TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL:
				setTraceabilityStatusLiteral((String)newValue);
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
			case BehaviortreePackage.TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL:
				setTraceabilityStatusLiteral(TRACEABILITY_STATUS_LITERAL_EDEFAULT);
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
			case BehaviortreePackage.TRACEABILITY_STATUS_CLASS__TRACEABILITY_STATUS_LITERAL:
				return TRACEABILITY_STATUS_LITERAL_EDEFAULT == null ? traceabilityStatusLiteral != null : !TRACEABILITY_STATUS_LITERAL_EDEFAULT.equals(traceabilityStatusLiteral);
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
		result.append(" (traceabilityStatusLiteral: ");
		result.append(traceabilityStatusLiteral);
		result.append(')');
		return result.toString();
	}

} //TraceabilityStatusClassImpl
