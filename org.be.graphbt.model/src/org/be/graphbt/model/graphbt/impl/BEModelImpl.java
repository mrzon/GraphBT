/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt.impl;

import java.util.Collection;
import org.be.graphbt.model.graphbt.AuthorList;
import java.util.List;
import java.util.Set;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.BehaviorTree;
import org.be.graphbt.model.graphbt.ComponentList;
import org.be.graphbt.model.graphbt.FormulaList;
import org.be.graphbt.model.graphbt.GraphBTFactory;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.LayoutList;
import org.be.graphbt.model.graphbt.Libraries;
import org.be.graphbt.model.graphbt.RequirementList;
import org.be.graphbt.model.graphbt.StandardNode;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BE Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getDbt <em>Dbt</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getComponentList <em>Component List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getRequirementList <em>Requirement List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getFormulaList <em>Formula List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getReversionNode <em>Reversion Node</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getErrorReversionNode <em>Error Reversion Node</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getLayoutList <em>Layout List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getSubtitle <em>Subtitle</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.impl.BEModelImpl#getAuthorList <em>Author List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BEModelImpl extends EObjectImpl implements BEModel {
	/**
	 * The cached value of the '{@link #getDbt() <em>Dbt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbt()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTree dbt;

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
	 * The cached value of the '{@link #getComponentList() <em>Component List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentList()
	 * @generated
	 * @ordered
	 */
	protected ComponentList componentList;

	/**
	 * The cached value of the '{@link #getRequirementList() <em>Requirement List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementList()
	 * @generated
	 * @ordered
	 */
	protected RequirementList requirementList;

	/**
	 * The cached value of the '{@link #getFormulaList() <em>Formula List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaList()
	 * @generated
	 * @ordered
	 */
	protected FormulaList formulaList;

	/**
	 * The cached value of the '{@link #getLibraries() <em>Libraries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected Libraries libraries;

	/**
	 * The cached value of the '{@link #getReversionNode() <em>Reversion Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReversionNode()
	 * @generated
	 * @ordered
	 */
	protected EList<StandardNode> reversionNode;

	/**
	 * The cached value of the '{@link #getErrorReversionNode() <em>Error Reversion Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorReversionNode()
	 * @generated
	 * @ordered
	 */
	protected EList<StandardNode> errorReversionNode;

	/**
	 * The cached value of the '{@link #getLayoutList() <em>Layout List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutList()
	 * @generated
	 * @ordered
	 */
	protected LayoutList layoutList;

	/**
	 * The default value of the '{@link #getSubtitle() <em>Subtitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtitle()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBTITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubtitle() <em>Subtitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtitle()
	 * @generated
	 * @ordered
	 */
	protected String subtitle = SUBTITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthorList() <em>Author List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorList()
	 * @generated
	 * @ordered
	 */
	protected AuthorList authorList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BEModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphBTPackage.Literals.BE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public BehaviorTree getDbt() {
		
		return dbt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDbt(BehaviorTree newDbt, NotificationChain msgs) {
		BehaviorTree oldDbt = dbt;
		dbt = newDbt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__DBT, oldDbt, newDbt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbt(BehaviorTree newDbt) {
		if (newDbt != dbt) {
			NotificationChain msgs = null;
			if (dbt != null)
				msgs = ((InternalEObject)dbt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__DBT, null, msgs);
			if (newDbt != null)
				msgs = ((InternalEObject)newDbt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__DBT, null, msgs);
			msgs = basicSetDbt(newDbt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__DBT, newDbt, newDbt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ComponentList getComponentList() {
		return componentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentList(ComponentList newComponentList, NotificationChain msgs) {
		ComponentList oldComponentList = componentList;
		componentList = newComponentList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__COMPONENT_LIST, oldComponentList, newComponentList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentList(ComponentList newComponentList) {
		if (newComponentList != componentList) {
			NotificationChain msgs = null;
			if (componentList != null)
				msgs = ((InternalEObject)componentList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__COMPONENT_LIST, null, msgs);
			if (newComponentList != null)
				msgs = ((InternalEObject)newComponentList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__COMPONENT_LIST, null, msgs);
			msgs = basicSetComponentList(newComponentList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__COMPONENT_LIST, newComponentList, newComponentList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public RequirementList getRequirementList() {
		return requirementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirementList(RequirementList newRequirementList, NotificationChain msgs) {
		RequirementList oldRequirementList = requirementList;
		requirementList = newRequirementList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__REQUIREMENT_LIST, oldRequirementList, newRequirementList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementList(RequirementList newRequirementList) {
		if (newRequirementList != requirementList) {
			NotificationChain msgs = null;
			if (requirementList != null)
				msgs = ((InternalEObject)requirementList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__REQUIREMENT_LIST, null, msgs);
			if (newRequirementList != null)
				msgs = ((InternalEObject)newRequirementList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__REQUIREMENT_LIST, null, msgs);
			msgs = basicSetRequirementList(newRequirementList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__REQUIREMENT_LIST, newRequirementList, newRequirementList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public FormulaList getFormulaList() {
		if (formulaList != null && formulaList.eIsProxy()) {
			InternalEObject oldFormulaList = (InternalEObject)formulaList;
			formulaList = (FormulaList)eResolveProxy(oldFormulaList);
			if (formulaList != oldFormulaList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphBTPackage.BE_MODEL__FORMULA_LIST, oldFormulaList, formulaList));
			}
		}
		return formulaList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormulaList(FormulaList newFormulaList, NotificationChain msgs) {
		FormulaList oldFormulaList = formulaList;
		formulaList = newFormulaList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__FORMULA_LIST, oldFormulaList, newFormulaList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaList(FormulaList newFormulaList) {
		if (newFormulaList != formulaList) {
			NotificationChain msgs = null;
			if (formulaList != null)
				msgs = ((InternalEObject)formulaList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__FORMULA_LIST, null, msgs);
			if (newFormulaList != null)
				msgs = ((InternalEObject)newFormulaList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__FORMULA_LIST, null, msgs);
			msgs = basicSetFormulaList(newFormulaList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__FORMULA_LIST, newFormulaList, newFormulaList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Libraries getLibraries() {
		
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLibraries(Libraries newLibraries, NotificationChain msgs) {
		Libraries oldLibraries = libraries;
		libraries = newLibraries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__LIBRARIES, oldLibraries, newLibraries);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibraries(Libraries newLibraries) {
		if (newLibraries != libraries) {
			NotificationChain msgs = null;
			if (libraries != null)
				msgs = ((InternalEObject)libraries).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__LIBRARIES, null, msgs);
			if (newLibraries != null)
				msgs = ((InternalEObject)newLibraries).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__LIBRARIES, null, msgs);
			msgs = basicSetLibraries(newLibraries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__LIBRARIES, newLibraries, newLibraries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StandardNode> getReversionNode() {
		if (reversionNode == null) {
			reversionNode = new EObjectResolvingEList<StandardNode>(StandardNode.class, this, GraphBTPackage.BE_MODEL__REVERSION_NODE);
		}
		return reversionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StandardNode> getErrorReversionNode() {
		if (errorReversionNode == null) {
			errorReversionNode = new EObjectResolvingEList<StandardNode>(StandardNode.class, this, GraphBTPackage.BE_MODEL__ERROR_REVERSION_NODE);
		}
		return errorReversionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutList getLayoutList() {
		return layoutList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutList(LayoutList newLayoutList, NotificationChain msgs) {
		LayoutList oldLayoutList = layoutList;
		layoutList = newLayoutList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__LAYOUT_LIST, oldLayoutList, newLayoutList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutList(LayoutList newLayoutList) {
		if (newLayoutList != layoutList) {
			NotificationChain msgs = null;
			if (layoutList != null)
				msgs = ((InternalEObject)layoutList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__LAYOUT_LIST, null, msgs);
			if (newLayoutList != null)
				msgs = ((InternalEObject)newLayoutList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__LAYOUT_LIST, null, msgs);
			msgs = basicSetLayoutList(newLayoutList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__LAYOUT_LIST, newLayoutList, newLayoutList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubtitle(String newSubtitle) {
		String oldSubtitle = subtitle;
		subtitle = newSubtitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__SUBTITLE, oldSubtitle, subtitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorList getAuthorList() {
		return authorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthorList(AuthorList newAuthorList, NotificationChain msgs) {
		AuthorList oldAuthorList = authorList;
		authorList = newAuthorList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__AUTHOR_LIST, oldAuthorList, newAuthorList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorList(AuthorList newAuthorList) {
		if (newAuthorList != authorList) {
			NotificationChain msgs = null;
			if (authorList != null)
				msgs = ((InternalEObject)authorList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__AUTHOR_LIST, null, msgs);
			if (newAuthorList != null)
				msgs = ((InternalEObject)newAuthorList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphBTPackage.BE_MODEL__AUTHOR_LIST, null, msgs);
			msgs = basicSetAuthorList(newAuthorList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphBTPackage.BE_MODEL__AUTHOR_LIST, newAuthorList, newAuthorList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphBTPackage.BE_MODEL__DBT:
				return basicSetDbt(null, msgs);
			case GraphBTPackage.BE_MODEL__COMPONENT_LIST:
				return basicSetComponentList(null, msgs);
			case GraphBTPackage.BE_MODEL__REQUIREMENT_LIST:
				return basicSetRequirementList(null, msgs);
			case GraphBTPackage.BE_MODEL__FORMULA_LIST:
				return basicSetFormulaList(null, msgs);
			case GraphBTPackage.BE_MODEL__LIBRARIES:
				return basicSetLibraries(null, msgs);
			case GraphBTPackage.BE_MODEL__LAYOUT_LIST:
				return basicSetLayoutList(null, msgs);
			case GraphBTPackage.BE_MODEL__AUTHOR_LIST:
				return basicSetAuthorList(null, msgs);
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
			case GraphBTPackage.BE_MODEL__DBT:
				return getDbt();
			case GraphBTPackage.BE_MODEL__NAME:
				return getName();
			case GraphBTPackage.BE_MODEL__COMPONENT_LIST:
				return getComponentList();
			case GraphBTPackage.BE_MODEL__REQUIREMENT_LIST:
				return getRequirementList();
			case GraphBTPackage.BE_MODEL__FORMULA_LIST:
				return getFormulaList();
			case GraphBTPackage.BE_MODEL__LIBRARIES:
				return getLibraries();
			case GraphBTPackage.BE_MODEL__REVERSION_NODE:
				return getReversionNode();
			case GraphBTPackage.BE_MODEL__ERROR_REVERSION_NODE:
				return getErrorReversionNode();
			case GraphBTPackage.BE_MODEL__LAYOUT_LIST:
				return getLayoutList();
			case GraphBTPackage.BE_MODEL__SUBTITLE:
				return getSubtitle();
			case GraphBTPackage.BE_MODEL__VERSION:
				return getVersion();
			case GraphBTPackage.BE_MODEL__AUTHOR_LIST:
				return getAuthorList();
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
			case GraphBTPackage.BE_MODEL__DBT:
				setDbt((BehaviorTree)newValue);
				return;
			case GraphBTPackage.BE_MODEL__NAME:
				setName((String)newValue);
				return;
			case GraphBTPackage.BE_MODEL__COMPONENT_LIST:
				setComponentList((ComponentList)newValue);
				return;
			case GraphBTPackage.BE_MODEL__REQUIREMENT_LIST:
				setRequirementList((RequirementList)newValue);
				return;
			case GraphBTPackage.BE_MODEL__FORMULA_LIST:
				setFormulaList((FormulaList)newValue);
				return;
			case GraphBTPackage.BE_MODEL__LIBRARIES:
				setLibraries((Libraries)newValue);
				return;
			case GraphBTPackage.BE_MODEL__REVERSION_NODE:
				getReversionNode().clear();
				getReversionNode().addAll((Collection<? extends StandardNode>)newValue);
				return;
			case GraphBTPackage.BE_MODEL__ERROR_REVERSION_NODE:
				getErrorReversionNode().clear();
				getErrorReversionNode().addAll((Collection<? extends StandardNode>)newValue);
				return;
			case GraphBTPackage.BE_MODEL__LAYOUT_LIST:
				setLayoutList((LayoutList)newValue);
				return;
			case GraphBTPackage.BE_MODEL__SUBTITLE:
				setSubtitle((String)newValue);
				return;
			case GraphBTPackage.BE_MODEL__VERSION:
				setVersion((String)newValue);
				return;
			case GraphBTPackage.BE_MODEL__AUTHOR_LIST:
				setAuthorList((AuthorList)newValue);
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
			case GraphBTPackage.BE_MODEL__DBT:
				setDbt((BehaviorTree)null);
				return;
			case GraphBTPackage.BE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphBTPackage.BE_MODEL__COMPONENT_LIST:
				setComponentList((ComponentList)null);
				return;
			case GraphBTPackage.BE_MODEL__REQUIREMENT_LIST:
				setRequirementList((RequirementList)null);
				return;
			case GraphBTPackage.BE_MODEL__FORMULA_LIST:
				setFormulaList((FormulaList)null);
				return;
			case GraphBTPackage.BE_MODEL__LIBRARIES:
				setLibraries((Libraries)null);
				return;
			case GraphBTPackage.BE_MODEL__REVERSION_NODE:
				getReversionNode().clear();
				return;
			case GraphBTPackage.BE_MODEL__ERROR_REVERSION_NODE:
				getErrorReversionNode().clear();
				return;
			case GraphBTPackage.BE_MODEL__LAYOUT_LIST:
				setLayoutList((LayoutList)null);
				return;
			case GraphBTPackage.BE_MODEL__SUBTITLE:
				setSubtitle(SUBTITLE_EDEFAULT);
				return;
			case GraphBTPackage.BE_MODEL__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case GraphBTPackage.BE_MODEL__AUTHOR_LIST:
				setAuthorList((AuthorList)null);
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
			case GraphBTPackage.BE_MODEL__DBT:
				return dbt != null;
			case GraphBTPackage.BE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphBTPackage.BE_MODEL__COMPONENT_LIST:
				return componentList != null;
			case GraphBTPackage.BE_MODEL__REQUIREMENT_LIST:
				return requirementList != null;
			case GraphBTPackage.BE_MODEL__FORMULA_LIST:
				return formulaList != null;
			case GraphBTPackage.BE_MODEL__LIBRARIES:
				return libraries != null;
			case GraphBTPackage.BE_MODEL__REVERSION_NODE:
				return reversionNode != null && !reversionNode.isEmpty();
			case GraphBTPackage.BE_MODEL__ERROR_REVERSION_NODE:
				return errorReversionNode != null && !errorReversionNode.isEmpty();
			case GraphBTPackage.BE_MODEL__LAYOUT_LIST:
				return layoutList != null;
			case GraphBTPackage.BE_MODEL__SUBTITLE:
				return SUBTITLE_EDEFAULT == null ? subtitle != null : !SUBTITLE_EDEFAULT.equals(subtitle);
			case GraphBTPackage.BE_MODEL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case GraphBTPackage.BE_MODEL__AUTHOR_LIST:
				return authorList != null;
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
		//result.append(super.toString());
		if(this.requirementList!=null)
		result.append(this.requirementList.toString());
		if(this.componentList!=null)
		result.append(this.componentList.toString());
		
		return result.toString();
	}

	@Override
	public void setReversionNode(List<StandardNode> reversionnode) {
		this.getReversionNode().addAll(reversionnode);
	}

	@Override
	public void setErrorReversionNode(Set<StandardNode> errorReversionNode) {
		this.getErrorReversionNode().addAll(errorReversionNode);
	}

} //BEModelImpl
