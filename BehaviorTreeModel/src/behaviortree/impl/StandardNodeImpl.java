/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BehaviortreePackage;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import java.util.Iterator;

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
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityLink <em>Traceability Link</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getBehaviorRef <em>Behavior Ref</em>}</li>
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
	 * The cached value of the '{@link #getTraceabilityLink() <em>Traceability Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityLink()
	 * @generated
	 * @ordered
	 */
	protected Requirement traceabilityLink;

	/**
	 * The default value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRef()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRef()
	 * @generated
	 * @ordered
	 */
	protected String componentRef = COMPONENT_REF_EDEFAULT;

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
	public String getComponentRef() {
		return componentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentRef(String newComponentRef) {
		String oldComponentRef = componentRef;
		componentRef = newComponentRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__COMPONENT_REF, oldComponentRef, componentRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF, oldBehaviorRef, behaviorRef));
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
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return getOperator();
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return getLabel();
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				if (resolve) return getTraceabilityLink();
				return basicGetTraceabilityLink();
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				return getComponentRef();
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				return getBehaviorRef();
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
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				setLabel((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((Requirement)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				setComponentRef((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				setBehaviorRef((String)newValue);
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
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((Requirement)null);
				return;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				setComponentRef(COMPONENT_REF_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				setBehaviorRef(BEHAVIOR_REF_EDEFAULT);
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
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return traceabilityLink != null;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				return COMPONENT_REF_EDEFAULT == null ? componentRef != null : !COMPONENT_REF_EDEFAULT.equals(componentRef);
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				return BEHAVIOR_REF_EDEFAULT == null ? behaviorRef != null : !BEHAVIOR_REF_EDEFAULT.equals(behaviorRef);
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
		result.append("#T");
		result.append(toString(this));
		return result.toString();
	}
	
	public String toString(Node r)
	{
		if(r ==null)
			return "";

		if(!(r instanceof StandardNode))
		 return "";
		StandardNode root = (StandardNode)r;
		String str = "";
		if(root.getTraceabilityLink() != null)
		{
			str+=root.getTraceabilityLink().getKey()+" ";	
		}
		if(root.getTraceabilityStatus().getValue() != TraceabilityStatus.ORIGINAL_VALUE)
		{
			str+=root.getTraceabilityStatus().getLiteral()+" ";
		}
		str+=root.getComponentRef()+" ";
		str+=root.getBehaviorRef();
		if(root.getOperator().getValue()!=Operator.NO_OPERATOR_VALUE)
		{
			str+=" "+root.getOperator().getLiteral();
		}
		
		if(root.getEdge()==null)
			return str;
		
		Edge e = root.getEdge();
		if(e.getChildNode().size()>1)
		{
			if(e.getBranch().getValue()==Branch.ALTERNATIVE_VALUE)
			{
				str += "#A{\n";
			}
			else
			{
				str += "#P{\n";
			}
			Iterator<Node> i = e.getChildNode().iterator();
			while(i.hasNext())
			{
				str+=toString(i.next())+"\n";
			}
			str+="}\n";
			return str;
		}
		else if(e.getChildNode().size()>0)
		{
			if(e.getComposition().getValue() ==Composition.ATOMIC_VALUE)
			{
				str += ";;"; 
			}
			else
			{
				str+= ";";
			}
			return str+toString(e.getChildNode().get(0));
		}
		return null;
	}
} //StandardNodeImpl
