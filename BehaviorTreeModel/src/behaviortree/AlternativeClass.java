/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behaviortree.AlternativeClass#getAlternativeAttribute <em>Alternative Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see behaviortree.BehaviortreePackage#getAlternativeClass()
 * @model
 * @generated
 */
public interface AlternativeClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Alternative Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Attribute</em>' attribute.
	 * @see #setAlternativeAttribute(String)
	 * @see behaviortree.BehaviortreePackage#getAlternativeClass_AlternativeAttribute()
	 * @model
	 * @generated
	 */
	String getAlternativeAttribute();

	/**
	 * Sets the value of the '{@link behaviortree.AlternativeClass#getAlternativeAttribute <em>Alternative Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternative Attribute</em>' attribute.
	 * @see #getAlternativeAttribute()
	 * @generated
	 */
	void setAlternativeAttribute(String value);

} // AlternativeClass
