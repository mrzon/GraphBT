/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import java.util.Collection;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.Library;

import org.be.graphbt.model.graphbt.MethodDeclaration;
import org.be.graphbt.model.graphbt.State;
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
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.LibraryImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends EObjectImpl implements Library {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected String desc = DESC_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodDeclaration> methods;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviors()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> behaviors;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.LIBRARY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.LIBRARY__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesc(String newDesc) {
		String oldDesc = desc;
		desc = newDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.LIBRARY__DESC, oldDesc, desc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.LIBRARY__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.LIBRARY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodDeclaration> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<MethodDeclaration>(MethodDeclaration.class, this, GraphBTPackage.LIBRARY__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, GraphBTPackage.LIBRARY__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Behavior> getBehaviors() {
		if (behaviors == null) {
			behaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, GraphBTPackage.LIBRARY__BEHAVIORS);
		}
		return behaviors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, GraphBTPackage.LIBRARY__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphBTPackage.LIBRARY__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case GraphBTPackage.LIBRARY__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case GraphBTPackage.LIBRARY__BEHAVIORS:
				return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
			case GraphBTPackage.LIBRARY__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case GraphBTPackage.LIBRARY__NAME:
				return getName();
			case GraphBTPackage.LIBRARY__TEXT:
				return getText();
			case GraphBTPackage.LIBRARY__DESC:
				return getDesc();
			case GraphBTPackage.LIBRARY__LOCATION:
				return getLocation();
			case GraphBTPackage.LIBRARY__ID:
				return getId();
			case GraphBTPackage.LIBRARY__METHODS:
				return getMethods();
			case GraphBTPackage.LIBRARY__STATES:
				return getStates();
			case GraphBTPackage.LIBRARY__BEHAVIORS:
				return getBehaviors();
			case GraphBTPackage.LIBRARY__ATTRIBUTES:
				return getAttributes();
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
			case GraphBTPackage.LIBRARY__NAME:
				setName((String)newValue);
				return;
			case GraphBTPackage.LIBRARY__TEXT:
				setText((String)newValue);
				return;
			case GraphBTPackage.LIBRARY__DESC:
				setDesc((String)newValue);
				return;
			case GraphBTPackage.LIBRARY__LOCATION:
				setLocation((String)newValue);
				return;
			case GraphBTPackage.LIBRARY__ID:
				setId((String)newValue);
				return;
			case GraphBTPackage.LIBRARY__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends MethodDeclaration>)newValue);
				return;
			case GraphBTPackage.LIBRARY__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case GraphBTPackage.LIBRARY__BEHAVIORS:
				getBehaviors().clear();
				getBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case GraphBTPackage.LIBRARY__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
			case GraphBTPackage.LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphBTPackage.LIBRARY__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case GraphBTPackage.LIBRARY__DESC:
				setDesc(DESC_EDEFAULT);
				return;
			case GraphBTPackage.LIBRARY__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case GraphBTPackage.LIBRARY__ID:
				setId(ID_EDEFAULT);
				return;
			case GraphBTPackage.LIBRARY__METHODS:
				getMethods().clear();
				return;
			case GraphBTPackage.LIBRARY__STATES:
				getStates().clear();
				return;
			case GraphBTPackage.LIBRARY__BEHAVIORS:
				getBehaviors().clear();
				return;
			case GraphBTPackage.LIBRARY__ATTRIBUTES:
				getAttributes().clear();
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
			case GraphBTPackage.LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphBTPackage.LIBRARY__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case GraphBTPackage.LIBRARY__DESC:
				return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals(desc);
			case GraphBTPackage.LIBRARY__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case GraphBTPackage.LIBRARY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case GraphBTPackage.LIBRARY__METHODS:
				return methods != null && !methods.isEmpty();
			case GraphBTPackage.LIBRARY__STATES:
				return states != null && !states.isEmpty();
			case GraphBTPackage.LIBRARY__BEHAVIORS:
				return behaviors != null && !behaviors.isEmpty();
			case GraphBTPackage.LIBRARY__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public boolean equals(Object o) {
		if(o instanceof Library) {
			Library l = (Library) o;
			return l.getId().equals(getId());
		}
		return false;
		
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
		result.append(" (name: ");
		result.append(name);
		result.append(", text: ");
		result.append(text);
		result.append(", desc: ");
		result.append(desc);
		result.append(", location: ");
		result.append(location);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
