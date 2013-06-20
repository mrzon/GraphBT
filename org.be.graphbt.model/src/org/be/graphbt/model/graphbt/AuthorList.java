/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.graphbt.model.graphbt.AuthorList#getAuthors <em>Authors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthorList()
 * @model
 * @generated
 */
public interface AuthorList extends EObject {
	/**
	 * Returns the value of the '<em><b>Authors</b></em>' reference list.
	 * The list contents are of type {@link org.be.graphbt.model.graphbt.Author}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' reference list.
	 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getAuthorList_Authors()
	 * @model
	 * @generated
	 */
	EList<Author> getAuthors();

} // AuthorList
