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
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getBehaviorRef <em>Behavior Ref</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getTraceabilityLink <em>Traceability Link</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link behaviortree.impl.StandardNodeImpl#getParent <em>Parent</em>}</li>
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
	protected static final String TRACEABILITY_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceabilityStatus() <em>Traceability Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityStatus()
	 * @generated
	 * @ordered
	 */
	protected String traceabilityStatus = TRACEABILITY_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected String operator = OPERATOR_EDEFAULT;

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
	 * The default value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEAF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected boolean leaf = LEAF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected StandardNode parent;

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
	public boolean isLeaf() {
		return leaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeaf(boolean newLeaf) {
		boolean oldLeaf = leaf;
		leaf = newLeaf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__LEAF, oldLeaf, leaf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardNode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (StandardNode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.STANDARD_NODE__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardNode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(StandardNode newParent) {
		StandardNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__PARENT, oldParent, parent));
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
	public String getTraceabilityStatus() {
		return traceabilityStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceabilityStatus(String newTraceabilityStatus) {
		String oldTraceabilityStatus = traceabilityStatus;
		traceabilityStatus = newTraceabilityStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.STANDARD_NODE__TRACEABILITY_STATUS, oldTraceabilityStatus, traceabilityStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator) {
		String oldOperator = operator;
		operator = newOperator;
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
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				return getComponentRef();
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				return getBehaviorRef();
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return getTraceabilityLink();
			case BehaviortreePackage.STANDARD_NODE__LEAF:
				return isLeaf();
			case BehaviortreePackage.STANDARD_NODE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
				setTraceabilityStatus((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				setOperator((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				setLabel((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				setComponentRef((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				setBehaviorRef((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink((String)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__LEAF:
				setLeaf((Boolean)newValue);
				return;
			case BehaviortreePackage.STANDARD_NODE__PARENT:
				setParent((StandardNode)newValue);
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
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				setComponentRef(COMPONENT_REF_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				setBehaviorRef(BEHAVIOR_REF_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				setTraceabilityLink(TRACEABILITY_LINK_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__LEAF:
				setLeaf(LEAF_EDEFAULT);
				return;
			case BehaviortreePackage.STANDARD_NODE__PARENT:
				setParent((StandardNode)null);
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
				return TRACEABILITY_STATUS_EDEFAULT == null ? traceabilityStatus != null : !TRACEABILITY_STATUS_EDEFAULT.equals(traceabilityStatus);
			case BehaviortreePackage.STANDARD_NODE__OPERATOR:
				return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
			case BehaviortreePackage.STANDARD_NODE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case BehaviortreePackage.STANDARD_NODE__COMPONENT_REF:
				return COMPONENT_REF_EDEFAULT == null ? componentRef != null : !COMPONENT_REF_EDEFAULT.equals(componentRef);
			case BehaviortreePackage.STANDARD_NODE__BEHAVIOR_REF:
				return BEHAVIOR_REF_EDEFAULT == null ? behaviorRef != null : !BEHAVIOR_REF_EDEFAULT.equals(behaviorRef);
			case BehaviortreePackage.STANDARD_NODE__TRACEABILITY_LINK:
				return TRACEABILITY_LINK_EDEFAULT == null ? traceabilityLink != null : !TRACEABILITY_LINK_EDEFAULT.equals(traceabilityLink);
			case BehaviortreePackage.STANDARD_NODE__LEAF:
				return leaf != LEAF_EDEFAULT;
			case BehaviortreePackage.STANDARD_NODE__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (index: ");
		result.append(index);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public String toBTText() {
		StringBuffer result = new StringBuffer();
		result.append("#T ");
		result.append(toBTText(this));
		return result.toString();
	}
	
	public String toBTText(Node r)
	{
		if(r ==null)
			return "";

		if(!(r instanceof StandardNode))
		 return "";
		StandardNode root = (StandardNode)r;
		String str = "";
		if(root.getTraceabilityLink() != null)
		{
			str+=root.getTraceabilityLink()+" ";	
		}
		if(!root.getTraceabilityStatus().equals(TraceabilityStatus.ORIGINAL.getLiteral()))
		{
			str+=root.getTraceabilityStatus()+" ";
		}
		str+=root.getComponentRef()+" ";
		str+=root.getBehaviorRef();
		if(!root.getOperator().equals(Operator.NO_OPERATOR.getLiteral()))
		{
			str+=" "+root.getOperator();
		}
		
		if(root.getEdge()==null)
			return str;
		
		Edge e = root.getEdge();
		if(e.getChildNode().size()>1)
		{
			if(e.getBranch().getValue()==Branch.ALTERNATIVE_VALUE)
			{
				str += " #A{\n";
			}
			else
			{
				str += " #P{\n";
			}
			Iterator<Node> i = e.getChildNode().iterator();
			while(i.hasNext())
			{
				str+=toBTText(i.next())+"\n";
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
			return str+toBTText(e.getChildNode().get(0));
		}
		return null;
	}
	public boolean equals(Object o)
	{
		if (o instanceof StandardNode)
		{
			StandardNode node = (StandardNode)o;
			if(node.toString().equals(toString()))
			{
				return node.getLabel().equals(this.getLabel());
			}
		}
		return false;
	}
	/**
	 * 
	 */
	public int hashCode()
	{
		return getLabel().hashCode();
	}
} //StandardNodeImpl
