/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import java.util.Collection;

import org.be.graphbt.model.graphbt.GraphBTFactory;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.Information;
import org.be.graphbt.model.graphbt.MapInformation;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.MapInformationImpl#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapInformationImpl extends EObjectImpl implements MapInformation {
	/**
	 * The cached value of the '{@link #getInfo() <em>Info</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfo()
	 * @generated
	 * @ordered
	 */
	protected EList<Information> info;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.MAP_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Information> getInfo() {
		if (info == null) {
			info = new EObjectContainmentEList<Information>(Information.class, this, GraphBTPackage.MAP_INFORMATION__INFO);
		}
		return info;
	}

	/**
	 * get Value is used to get the value of the specified key
	 * 
	 * 
	 */
	public String getValue(String key) {
		EList<Information> info = this.getInfo();
		for(int i = 0; i < info.size(); i++) {
			if(info.get(i).getKey().equals(key)) {
				return info.get(i).getValue();
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public void setValue(String key, String value) {
		EList<Information> info = this.getInfo();
		for(int i = 0; i < info.size(); i++) {
			if(info.get(i).getKey().equals(key)) {
				info.get(i).setValue(value);
				return;
			}
		}
		Information i = GraphBTFactory.eINSTANCE.createInformation();
		i.setKey(key);
		i.setValue(value);
		info.add(i);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphBTPackage.MAP_INFORMATION__INFO:
				return ((InternalEList<?>)getInfo()).basicRemove(otherEnd, msgs);
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
			case GraphBTPackage.MAP_INFORMATION__INFO:
				return getInfo();
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
			case GraphBTPackage.MAP_INFORMATION__INFO:
				getInfo().clear();
				getInfo().addAll((Collection<? extends Information>)newValue);
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
			case GraphBTPackage.MAP_INFORMATION__INFO:
				getInfo().clear();
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
			case GraphBTPackage.MAP_INFORMATION__INFO:
				return info != null && !info.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void removeKey(String name) {
		EList<Information> info = this.getInfo();
		int deleteIndex = -1;
		for(int i = 0; i < info.size(); i++) {
			if(info.get(i).getKey().equals(name)) {
				deleteIndex = i;
				break;
			}
		}
		if(deleteIndex != -1) {
			info.remove(deleteIndex);
		}
	}

} //MapInformationImpl
