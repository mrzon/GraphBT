/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.*;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityStatus <em>Traceability Status</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityLink <em>Traceability Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardNodeImpl extends NodeImpl implements StandardNode {
	/**
	 * The default value of the '{@link #getTraceabilityStatus() <em>Traceability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityStatus()
	 * @generated
	 * @ordered
	 */
	protected static final TraceabilityStatus TRACEABILITY_STATUS_EDEFAULT = TraceabilityStatus.ORIGINAL;

	/**
	 * The cached value of the '{@link #getTraceabilityStatus() <em>Traceability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityStatus()
	 * @generated
	 * @ordered
	 */
	protected TraceabilityStatus traceabilityStatus = TRACEABILITY_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final Operator OPERATOR_EDEFAULT = Operator.REFERENCE;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator = OPERATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior behavior;

	/**
	 * The cached value of the '{@link #getTraceabilityLink() <em>Traceability Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityLink()
	 * @generated
	 * @ordered
	 */
	protected Requirement traceabilityLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviortreePackage.Literals.STANDARD_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBehavior() {
		if (behavior != null && behavior.eIsProxy()) {
			InternalEObject oldBehavior = (InternalEObject)behavior;
			behavior = (Behavior)eResolveProxy(oldBehavior);
			if (behavior != oldBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.STANDARD_NODE__BEHAVIOR, oldBehavior, behavior));
			}
		}
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(Behavior newBehavior) {
		Behavior oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__BEHAVIOR, oldBehavior, behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getTraceabilityLink() {
		if (traceabilityLink != null && traceabilityLink.eIsProxy()) {
			InternalEObject oldTraceabilityLink = (InternalEObject)traceabilityLink;
			traceabilityLink = (Requirement)eResolveProxy(oldTraceabilityLink);
			if (traceabilityLink != oldTraceabilityLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK, oldTraceabilityLink, traceabilityLink));
			}
		}
		return traceabilityLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetTraceabilityLink() {
		return traceabilityLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceabilityLink(Requirement newTraceabilityLink) {
		Requirement oldTraceabilityLink = traceabilityLink;
		traceabilityLink = newTraceabilityLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK, oldTraceabilityLink, traceabilityLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityStatus getTraceabilityStatus() {
		return traceabilityStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceabilityStatus(TraceabilityStatus newTraceabilityStatus) {
		TraceabilityStatus oldTraceabilityStatus = traceabilityStatus;
		traceabilityStatus = newTraceabilityStatus == null ? TRACEABILITY_STATUS_EDEFAULT : newTraceabilityStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS, oldTraceabilityStatus, traceabilityStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.STANDARD_NODE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		Operator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				return getTraceabilityStatus();
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return getOperator();
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return getLabel();
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				if (resolve) return getBehavior();
				return basicGetBehavior();
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				if (resolve) return getTraceabilityLink();
				return basicGetTraceabilityLink();
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
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				setTraceabilityStatus((TraceabilityStatus)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				setLabel((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				setBehavior((Behavior)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((Requirement)newValue);
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
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				setTraceabilityStatus(TRACEABILITY_STATUS_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				setComponent((Component)null);
				return;
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				setBehavior((Behavior)null);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((Requirement)null);
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
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				return traceabilityStatus != TRACEABILITY_STATUS_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				return component != null;
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				return behavior != null;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return traceabilityLink != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append("Component");
		result.append(component);
		result.append(", behavior:");
		result.append(behavior);
		result.append(", (traceabilityStatus: ");
		result.append(traceabilityStatus);
		result.append(", operator: ");
		result.append(operator);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getComponentName() {
		if(this.getComponent()==null)
			return "Component";
		else
			return this.getComponent().getComponentName();
	}

} //StandardNodeImpl
