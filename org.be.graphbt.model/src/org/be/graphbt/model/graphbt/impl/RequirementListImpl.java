/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import java.util.Collection;
import java.util.Iterator;

import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.RequirementList;

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
 * An implementation of the model object '<em><b>Requirement List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.RequirementListImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.RequirementListImpl#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementListImpl extends EObjectImpl implements RequirementList {
	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * The default value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected static final long PROJECT_ID_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected long projectId = PROJECT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.REQUIREMENT_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(long newProjectId) {
		long oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.REQUIREMENT_LIST__PROJECT_ID, oldProjectId, projectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
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
			case GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS:
				return getRequirements();
			case GraphBTPackage.REQUIREMENT_LIST__PROJECT_ID:
				return getProjectId();
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
			case GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case GraphBTPackage.REQUIREMENT_LIST__PROJECT_ID:
				setProjectId((Long)newValue);
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
			case GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS:
				getRequirements().clear();
				return;
			case GraphBTPackage.REQUIREMENT_LIST__PROJECT_ID:
				setProjectId(PROJECT_ID_EDEFAULT);
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
			case GraphBTPackage.REQUIREMENT_LIST__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case GraphBTPackage.REQUIREMENT_LIST__PROJECT_ID:
				return projectId != PROJECT_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		
		Iterator<Requirement> i = getRequirements().iterator();
		if(getRequirements().size()==0)
		{
			return "";
		}
		StringBuffer result = new StringBuffer("#RT");
		int j=1;
		while(i.hasNext())
		{
			result.append(" R"+j+" R"+j);
			j++;
			i.next();
		}
		result.append("\n");
		return result.toString();
	}

} //RequirementListImpl
