/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

import org.eclipse.emf.common.util.EList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BE Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getDbt <em>Dbt</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getName <em>Name</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getComponentList <em>Component List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getRequirementList <em>Requirement List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getFormulaList <em>Formula List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getReversionNode <em>Reversion Node</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getErrorReversionNode <em>Error Reversion Node</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getLayoutList <em>Layout List</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getSubtitle <em>Subtitle</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getVersion <em>Version</em>}</li>
 *   <li>{@link org.be.graphbt.model.graphbt.BEModel#getAuthorList <em>Author List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel()
 * @model
 * @generated
 */
public interface BEModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Dbt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dbt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dbt</em>' containment reference.
	 * @see #setDbt(BehaviorTree)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_Dbt()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorTree getDbt();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getDbt <em>Dbt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dbt</em>' containment reference.
	 * @see #getDbt()
	 * @generated
	 */
	void setDbt(BehaviorTree value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Component List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component List</em>' containment reference.
	 * @see #setComponentList(ComponentList)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_ComponentList()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComponentList getComponentList();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getComponentList <em>Component List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component List</em>' containment reference.
	 * @see #getComponentList()
	 * @generated
	 */
	void setComponentList(ComponentList value);

	/**
	 * Returns the value of the '<em><b>Requirement List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement List</em>' containment reference.
	 * @see #setRequirementList(RequirementList)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_RequirementList()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RequirementList getRequirementList();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getRequirementList <em>Requirement List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement List</em>' containment reference.
	 * @see #getRequirementList()
	 * @generated
	 */
	void setRequirementList(RequirementList value);

	/**
	 * Returns the value of the '<em><b>Formula List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula List</em>' containment reference.
	 * @see #setFormulaList(FormulaList)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_FormulaList()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FormulaList getFormulaList();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getFormulaList <em>Formula List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula List</em>' containment reference.
	 * @see #getFormulaList()
	 * @generated
	 */
	void setFormulaList(FormulaList value);

	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference.
	 * @see #setLibraries(Libraries)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_Libraries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Libraries getLibraries();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getLibraries <em>Libraries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Libraries</em>' containment reference.
	 * @see #getLibraries()
	 * @generated
	 */
	void setLibraries(Libraries value);

	/**
	 * Returns the value of the '<em><b>Reversion Node</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.StandardNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reversion Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reversion Node</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_ReversionNode()
	 * @model
	 * @generated
	 */
	EList<StandardNode> getReversionNode();

	/**
	 * Returns the value of the '<em><b>Error Reversion Node</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.StandardNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Reversion Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Reversion Node</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_ErrorReversionNode()
	 * @model
	 * @generated
	 */
	EList<StandardNode> getErrorReversionNode();

	/**
	 * Returns the value of the '<em><b>Layout List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout List</em>' containment reference.
	 * @see #setLayoutList(LayoutList)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_LayoutList()
	 * @model containment="true"
	 * @generated
	 */
	LayoutList getLayoutList();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getLayoutList <em>Layout List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout List</em>' containment reference.
	 * @see #getLayoutList()
	 * @generated
	 */
	void setLayoutList(LayoutList value);

	/**
	 * Returns the value of the '<em><b>Subtitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtitle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtitle</em>' attribute.
	 * @see #setSubtitle(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_Subtitle()
	 * @model
	 * @generated
	 */
	String getSubtitle();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getSubtitle <em>Subtitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subtitle</em>' attribute.
	 * @see #getSubtitle()
	 * @generated
	 */
	void setSubtitle(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Author List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author List</em>' containment reference.
	 * @see #setAuthorList(AuthorList)
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBEModel_AuthorList()
	 * @model containment="true"
	 * @generated
	 */
	AuthorList getAuthorList();

	/**
	 * Sets the value of the '{@link org.be.graphbt.model.graphbt.BEModel#getAuthorList <em>Author List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author List</em>' containment reference.
	 * @see #getAuthorList()
	 * @generated
	 */
	void setAuthorList(AuthorList value);

	void setReversionNode(List<StandardNode> reversionnode);

	void setErrorReversionNode(Set<StandardNode> errorReversionNode);

} // BEModel
