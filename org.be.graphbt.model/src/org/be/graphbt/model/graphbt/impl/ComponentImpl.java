/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.State;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getState <em>State</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getRelatedTo <em>Related To</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getComponentDesc <em>Component Desc</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#isEnumerated <em>Enumerated</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.ComponentImpl#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends EObjectImpl implements Component {
	/**
	 * The default value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentName()
	 * @generated
	 * @ordered
	 */
	protected String componentName = COMPONENT_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<State> state;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedTo() <em>Related To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> relatedTo;

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
	 * The default value of the '{@link #getComponentDesc() <em>Component Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentDesc() <em>Component Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentDesc()
	 * @generated
	 * @ordered
	 */
	protected String componentDesc = COMPONENT_DESC_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnumerated() <em>Enumerated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENUMERATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnumerated() <em>Enumerated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumerated()
	 * @generated
	 * @ordered
	 */
	protected boolean enumerated = ENUMERATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<Library> uses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentName(String newComponentName) {
		String oldComponentName = componentName;
		componentName = newComponentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__COMPONENT_NAME, oldComponentName, componentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, GraphBTPackage.COMPONENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getState() {
		if (state == null) {
			state = new EObjectContainmentEList<State>(State.class, this, GraphBTPackage.COMPONENT__STATE);
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphBTPackage.COMPONENT__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getRelatedTo() {
		if (relatedTo == null) {
			relatedTo = new EObjectResolvingEList<Component>(Component.class, this, GraphBTPackage.COMPONENT__RELATED_TO);
		}
		return relatedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Behavior> getBehaviors() {
		if (behaviors == null) {
			behaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, GraphBTPackage.COMPONENT__BEHAVIORS);
		}
		return behaviors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__COMPONENT_REF, oldComponentRef, componentRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentDesc() {
		return componentDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentDesc(String newComponentDesc) {
		String oldComponentDesc = componentDesc;
		componentDesc = newComponentDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__COMPONENT_DESC, oldComponentDesc, componentDesc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumerated() {
		return enumerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumerated(boolean newEnumerated) {
		boolean oldEnumerated = enumerated;
		enumerated = newEnumerated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.COMPONENT__ENUMERATED, oldEnumerated, enumerated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Library> getUses() {
		if (uses == null) {
			uses = new EObjectResolvingEList<Library>(Library.class, this, GraphBTPackage.COMPONENT__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttribute(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphBTPackage.COMPONENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case GraphBTPackage.COMPONENT__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case GraphBTPackage.COMPONENT__BEHAVIORS:
				return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
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
			case GraphBTPackage.COMPONENT__COMPONENT_NAME:
				return getComponentName();
			case GraphBTPackage.COMPONENT__ATTRIBUTES:
				return getAttributes();
			case GraphBTPackage.COMPONENT__STATE:
				return getState();
			case GraphBTPackage.COMPONENT__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case GraphBTPackage.COMPONENT__ID:
				return getId();
			case GraphBTPackage.COMPONENT__RELATED_TO:
				return getRelatedTo();
			case GraphBTPackage.COMPONENT__BEHAVIORS:
				return getBehaviors();
			case GraphBTPackage.COMPONENT__COMPONENT_REF:
				return getComponentRef();
			case GraphBTPackage.COMPONENT__COMPONENT_DESC:
				return getComponentDesc();
			case GraphBTPackage.COMPONENT__ENUMERATED:
				return isEnumerated();
			case GraphBTPackage.COMPONENT__USES:
				return getUses();
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
			case GraphBTPackage.COMPONENT__COMPONENT_NAME:
				setComponentName((String)newValue);
				return;
			case GraphBTPackage.COMPONENT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case GraphBTPackage.COMPONENT__STATE:
				getState().clear();
				getState().addAll((Collection<? extends State>)newValue);
				return;
			case GraphBTPackage.COMPONENT__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case GraphBTPackage.COMPONENT__ID:
				setId((Integer)newValue);
				return;
			case GraphBTPackage.COMPONENT__RELATED_TO:
				getRelatedTo().clear();
				getRelatedTo().addAll((Collection<? extends Component>)newValue);
				return;
			case GraphBTPackage.COMPONENT__BEHAVIORS:
				getBehaviors().clear();
				getBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case GraphBTPackage.COMPONENT__COMPONENT_REF:
				setComponentRef((String)newValue);
				return;
			case GraphBTPackage.COMPONENT__COMPONENT_DESC:
				setComponentDesc((String)newValue);
				return;
			case GraphBTPackage.COMPONENT__ENUMERATED:
				setEnumerated((Boolean)newValue);
				return;
			case GraphBTPackage.COMPONENT__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends Library>)newValue);
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
			case GraphBTPackage.COMPONENT__COMPONENT_NAME:
				setComponentName(COMPONENT_NAME_EDEFAULT);
				return;
			case GraphBTPackage.COMPONENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case GraphBTPackage.COMPONENT__STATE:
				getState().clear();
				return;
			case GraphBTPackage.COMPONENT__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case GraphBTPackage.COMPONENT__ID:
				setId(ID_EDEFAULT);
				return;
			case GraphBTPackage.COMPONENT__RELATED_TO:
				getRelatedTo().clear();
				return;
			case GraphBTPackage.COMPONENT__BEHAVIORS:
				getBehaviors().clear();
				return;
			case GraphBTPackage.COMPONENT__COMPONENT_REF:
				setComponentRef(COMPONENT_REF_EDEFAULT);
				return;
			case GraphBTPackage.COMPONENT__COMPONENT_DESC:
				setComponentDesc(COMPONENT_DESC_EDEFAULT);
				return;
			case GraphBTPackage.COMPONENT__ENUMERATED:
				setEnumerated(ENUMERATED_EDEFAULT);
				return;
			case GraphBTPackage.COMPONENT__USES:
				getUses().clear();
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
			case GraphBTPackage.COMPONENT__COMPONENT_NAME:
				return COMPONENT_NAME_EDEFAULT == null ? componentName != null : !COMPONENT_NAME_EDEFAULT.equals(componentName);
			case GraphBTPackage.COMPONENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case GraphBTPackage.COMPONENT__STATE:
				return state != null && !state.isEmpty();
			case GraphBTPackage.COMPONENT__INITIAL_STATE:
				return initialState != null;
			case GraphBTPackage.COMPONENT__ID:
				return id != ID_EDEFAULT;
			case GraphBTPackage.COMPONENT__RELATED_TO:
				return relatedTo != null && !relatedTo.isEmpty();
			case GraphBTPackage.COMPONENT__BEHAVIORS:
				return behaviors != null && !behaviors.isEmpty();
			case GraphBTPackage.COMPONENT__COMPONENT_REF:
				return COMPONENT_REF_EDEFAULT == null ? componentRef != null : !COMPONENT_REF_EDEFAULT.equals(componentRef);
			case GraphBTPackage.COMPONENT__COMPONENT_DESC:
				return COMPONENT_DESC_EDEFAULT == null ? componentDesc != null : !COMPONENT_DESC_EDEFAULT.equals(componentDesc);
			case GraphBTPackage.COMPONENT__ENUMERATED:
				return enumerated != ENUMERATED_EDEFAULT;
			case GraphBTPackage.COMPONENT__USES:
				return uses != null && !uses.isEmpty();
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
		result.append("#C "+componentRef+" "+componentName+"\n");
		Iterator<Behavior> i = getBehaviors().iterator();
		int j=0;
		while(i.hasNext())
		{
			Behavior b = i.next();
			String t = "";
			j++;
			switch(b.getBehaviorType().getValue())
			{
				case BehaviorType.STATE_REALIZATION_VALUE: t="#S"; break;
				case BehaviorType.SELECTION_VALUE:  t="#L"; break;
				case BehaviorType.GUARD_VALUE: t="#G"; break;
				case BehaviorType.INTERNAL_INPUT_VALUE:  t="#II"; break;
				case BehaviorType.INTERNAL_OUTPUT_VALUE:  t="#IO"; break;
				case BehaviorType.EXTERNAL_OUTPUT_VALUE: t="#EO"; break;
				case BehaviorType.EXTERNAL_INPUT_VALUE:  t="#EI"; break;
			}
			result.append(t+" "+b.getBehaviorRef()+" "+b.getBehaviorName()+"\n");
		}
		result.append("\n");
		return result.toString();
	}

} //ComponentImpl
