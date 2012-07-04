/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BehaviorType;
import behaviortree.BehaviortreePackage;
import behaviortree.Component;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;

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
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getBehaviorType <em>Behavior Type</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityLink <em>Traceability Link</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityStatus <em>Traceability Status</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardNodeImpl extends NodeImpl implements StandardNode {
	/**
	 * The default value of the '{@link #getBehavior() <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected String behavior = BEHAVIOR_EDEFAULT;

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
	 * The default value of the '{@link #getTraceabilityLink() <em>Traceability Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityLink()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACEABILITY_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceabilityLink() <em>Traceability Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityLink()
	 * @generated
	 * @ordered
	 */
	protected String traceabilityLink = TRACEABILITY_LINK_EDEFAULT;

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
	public String getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(String newBehavior) {
		String oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__BEHAVIOR, oldBehavior, behavior));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__BEHAVIOR_TYPE, oldBehaviorType, behaviorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceabilityLink() {
		return traceabilityLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceabilityLink(String newTraceabilityLink) {
		String oldTraceabilityLink = traceabilityLink;
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
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				return getBehavior();
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_TYPE:
				return getBehaviorType();
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return getTraceabilityLink();
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				return getTraceabilityStatus();
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return getOperator();
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return getLabel();
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
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				setBehavior((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_TYPE:
				setBehaviorType((BehaviorType)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((String)newValue);
				return;
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
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				setBehavior(BEHAVIOR_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_TYPE:
				setBehaviorType(BEHAVIOR_TYPE_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink(TRACEABILITY_LINK_EDEFAULT);
				return;
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
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR:
				return BEHAVIOR_EDEFAULT == null ? behavior != null : !BEHAVIOR_EDEFAULT.equals(behavior);
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_TYPE:
				return behaviorType != BEHAVIOR_TYPE_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return TRACEABILITY_LINK_EDEFAULT == null ? traceabilityLink != null : !TRACEABILITY_LINK_EDEFAULT.equals(traceabilityLink);
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS:
				return traceabilityStatus != TRACEABILITY_STATUS_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT:
				return component != null;
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
		result.append(" (behavior: ");
		result.append(behavior);
		result.append(", behaviorType: ");
		result.append(behaviorType);
		result.append(", traceabilityLink: ");
		result.append(traceabilityLink);
		result.append(", traceabilityStatus: ");
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
			return this.getComponent().getName();
	}

} //StandardNodeImpl
