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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getChildNode() <em>Child Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildNode()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> childNode;

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
	public EList<Node> getChildNode() {
		if (childNode == null) {
			childNode = new EObjectContainmentEList<Node>(Node.class, this, BehaviortreePackage.EDGE__CHILD_NODE);
		}
		return childNode;
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
				return ((InternalEList<?>)getChildNode()).basicRemove(otherEnd, msgs);
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviortreePackage.EDGE__CHILD_NODE:
				getChildNode().clear();
				getChildNode().addAll((Collection<? extends Node>)newValue);
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
				getChildNode().clear();
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
				return childNode != null && !childNode.isEmpty();
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
