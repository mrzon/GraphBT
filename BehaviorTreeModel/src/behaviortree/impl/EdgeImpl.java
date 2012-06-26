/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.BehaviortreePackage;
import behaviortree.Branch;
import behaviortree.Composition;
import behaviortree.Edge;
import behaviortree.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behaviortree.impl.EdgeImpl#getChildNode <em>Child Node</em>}</li>
 *   <li>{@link behaviortree.impl.EdgeImpl#getBranch <em>Branch</em>}</li>
 *   <li>{@link behaviortree.impl.EdgeImpl#getComposition <em>Composition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends EObjectImpl implements Edge {
	/**
	 * The cached value of the '{@link #getChildNode() <em>Child Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildNode()
	 * @generated
	 * @ordered
	 */
	protected Node childNode;

	/**
	 * The default value of the '{@link #getBranch() <em>Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch()
	 * @generated
	 * @ordered
	 */
	protected static final Branch BRANCH_EDEFAULT = Branch.PARALLEL;

	/**
	 * The cached value of the '{@link #getBranch() <em>Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch()
	 * @generated
	 * @ordered
	 */
	protected Branch branch = BRANCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getComposition() <em>Composition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposition()
	 * @generated
	 * @ordered
	 */
	protected static final Composition COMPOSITION_EDEFAULT = Composition.SEQUENTIAL;

	/**
	 * The cached value of the '{@link #getComposition() <em>Composition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposition()
	 * @generated
	 * @ordered
	 */
	protected Composition composition = COMPOSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviortreePackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getChildNode() {
		return childNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildNode(Node newChildNode, NotificationChain msgs) {
		Node oldChildNode = childNode;
		childNode = newChildNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviortreePackage.EDGE__CHILD_NODE, oldChildNode, newChildNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildNode(Node newChildNode) {
		if (newChildNode != childNode) {
			NotificationChain msgs = null;
			if (childNode != null)
				msgs = ((InternalEObject)childNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.EDGE__CHILD_NODE, null, msgs);
			if (newChildNode != null)
				msgs = ((InternalEObject)newChildNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviortreePackage.EDGE__CHILD_NODE, null, msgs);
			msgs = basicSetChildNode(newChildNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.EDGE__CHILD_NODE, newChildNode, newChildNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranch(Branch newBranch) {
		Branch oldBranch = branch;
		branch = newBranch == null ? BRANCH_EDEFAULT : newBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.EDGE__BRANCH, oldBranch, branch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composition getComposition() {
		return composition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposition(Composition newComposition) {
		Composition oldComposition = composition;
		composition = newComposition == null ? COMPOSITION_EDEFAULT : newComposition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.EDGE__COMPOSITION, oldComposition, composition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BehaviortreePackage.EDGE__CHILD_NODE:
				return basicSetChildNode(null, msgs);
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
			case BehaviortreePackage.EDGE__CHILD_NODE:
				return getChildNode();
			case BehaviortreePackage.EDGE__BRANCH:
				return getBranch();
			case BehaviortreePackage.EDGE__COMPOSITION:
				return getComposition();
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
			case BehaviortreePackage.EDGE__CHILD_NODE:
				setChildNode((Node)newValue);
				return;
			case BehaviortreePackage.EDGE__BRANCH:
				setBranch((Branch)newValue);
				return;
			case BehaviortreePackage.EDGE__COMPOSITION:
				setComposition((Composition)newValue);
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
			case BehaviortreePackage.EDGE__CHILD_NODE:
				setChildNode((Node)null);
				return;
			case BehaviortreePackage.EDGE__BRANCH:
				setBranch(BRANCH_EDEFAULT);
				return;
			case BehaviortreePackage.EDGE__COMPOSITION:
				setComposition(COMPOSITION_EDEFAULT);
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
			case BehaviortreePackage.EDGE__CHILD_NODE:
				return childNode != null;
			case BehaviortreePackage.EDGE__BRANCH:
				return branch != BRANCH_EDEFAULT;
			case BehaviortreePackage.EDGE__COMPOSITION:
				return composition != COMPOSITION_EDEFAULT;
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
		result.append(" (branch: ");
		result.append(branch);
		result.append(", composition: ");
		result.append(composition);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
