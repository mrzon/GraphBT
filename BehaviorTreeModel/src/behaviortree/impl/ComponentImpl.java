/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree.impl;

import behaviortree.Attribute;
import behaviortree.Behavior;
import behaviortree.BehaviortreePackage;
import behaviortree.Component;
import behaviortree.State;

import java.util.Collection;

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
 *   <li>{@link behaviortree.impl.ComponentImpl#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getState <em>State</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getRelatedTo <em>Related To</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link behaviortree.impl.ComponentImpl#getComponentRef <em>Component Ref</em>}</li>
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
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
		return BehaviortreePackage.Literals.COMPONENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.COMPONENT__COMPONENT_NAME, oldComponentName, componentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<Attribute>(Attribute.class, this, BehaviortreePackage.COMPONENT__ATTRIBUTES);
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
			state = new EObjectContainmentEList<State>(State.class, this, BehaviortreePackage.COMPONENT__STATE);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviortreePackage.COMPONENT__INITIAL_STATE, oldInitialState, initialState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.COMPONENT__INITIAL_STATE, oldInitialState, initialState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.COMPONENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getRelatedTo() {
		if (relatedTo == null) {
			relatedTo = new EObjectResolvingEList<Component>(Component.class, this, BehaviortreePackage.COMPONENT__RELATED_TO);
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
			behaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, BehaviortreePackage.COMPONENT__BEHAVIORS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviortreePackage.COMPONENT__COMPONENT_REF, oldComponentRef, componentRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BehaviortreePackage.COMPONENT__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case BehaviortreePackage.COMPONENT__BEHAVIORS:
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
			case BehaviortreePackage.COMPONENT__COMPONENT_NAME:
				return getComponentName();
			case BehaviortreePackage.COMPONENT__ATTRIBUTES:
				return getAttributes();
			case BehaviortreePackage.COMPONENT__STATE:
				return getState();
			case BehaviortreePackage.COMPONENT__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case BehaviortreePackage.COMPONENT__ID:
				return getId();
			case BehaviortreePackage.COMPONENT__RELATED_TO:
				return getRelatedTo();
			case BehaviortreePackage.COMPONENT__BEHAVIORS:
				return getBehaviors();
			case BehaviortreePackage.COMPONENT__COMPONENT_REF:
				return getComponentRef();
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
			case BehaviortreePackage.COMPONENT__COMPONENT_NAME:
				setComponentName((String)newValue);
				return;
			case BehaviortreePackage.COMPONENT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case BehaviortreePackage.COMPONENT__STATE:
				getState().clear();
				getState().addAll((Collection<? extends State>)newValue);
				return;
			case BehaviortreePackage.COMPONENT__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case BehaviortreePackage.COMPONENT__ID:
				setId((Integer)newValue);
				return;
			case BehaviortreePackage.COMPONENT__RELATED_TO:
				getRelatedTo().clear();
				getRelatedTo().addAll((Collection<? extends Component>)newValue);
				return;
			case BehaviortreePackage.COMPONENT__BEHAVIORS:
				getBehaviors().clear();
				getBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case BehaviortreePackage.COMPONENT__COMPONENT_REF:
				setComponentRef((String)newValue);
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
			case BehaviortreePackage.COMPONENT__COMPONENT_NAME:
				setComponentName(COMPONENT_NAME_EDEFAULT);
				return;
			case BehaviortreePackage.COMPONENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case BehaviortreePackage.COMPONENT__STATE:
				getState().clear();
				return;
			case BehaviortreePackage.COMPONENT__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case BehaviortreePackage.COMPONENT__ID:
				setId(ID_EDEFAULT);
				return;
			case BehaviortreePackage.COMPONENT__RELATED_TO:
				getRelatedTo().clear();
				return;
			case BehaviortreePackage.COMPONENT__BEHAVIORS:
				getBehaviors().clear();
				return;
			case BehaviortreePackage.COMPONENT__COMPONENT_REF:
				setComponentRef(COMPONENT_REF_EDEFAULT);
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
			case BehaviortreePackage.COMPONENT__COMPONENT_NAME:
				return COMPONENT_NAME_EDEFAULT == null ? componentName != null : !COMPONENT_NAME_EDEFAULT.equals(componentName);
			case BehaviortreePackage.COMPONENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case BehaviortreePackage.COMPONENT__STATE:
				return state != null && !state.isEmpty();
			case BehaviortreePackage.COMPONENT__INITIAL_STATE:
				return initialState != null;
			case BehaviortreePackage.COMPONENT__ID:
				return id != ID_EDEFAULT;
			case BehaviortreePackage.COMPONENT__RELATED_TO:
				return relatedTo != null && !relatedTo.isEmpty();
			case BehaviortreePackage.COMPONENT__BEHAVIORS:
				return behaviors != null && !behaviors.isEmpty();
			case BehaviortreePackage.COMPONENT__COMPONENT_REF:
				return COMPONENT_REF_EDEFAULT == null ? componentRef != null : !COMPONENT_REF_EDEFAULT.equals(componentRef);
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
		result.append(" (componentName: ");
		result.append(componentName);
		result.append(", id: ");
		result.append(id);
		result.append(", componentRef: ");
		result.append(componentRef);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
