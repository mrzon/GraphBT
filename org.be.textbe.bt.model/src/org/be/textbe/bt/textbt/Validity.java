/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Validity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage#getValidity()
 * @model
 * @generated
 */
public enum Validity implements Enumerator
{
  /**
   * The '<em><b>Valid</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALID_VALUE
   * @generated
   * @ordered
   */
  VALID(0, "Valid", ""),

  /**
   * The '<em><b>Implied</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IMPLIED_VALUE
   * @generated
   * @ordered
   */
  IMPLIED(1, "Implied", "+"),

  /**
   * The '<em><b>Invalid</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INVALID_VALUE
   * @generated
   * @ordered
   */
  INVALID(2, "Invalid", "-"),

  /**
   * The '<em><b>Deleted</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DELETED_VALUE
   * @generated
   * @ordered
   */
  DELETED(3, "Deleted", "--"),

  /**
   * The '<em><b>Refined</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REFINED_VALUE
   * @generated
   * @ordered
   */
  REFINED(4, "Refined", "+-"),

  /**
   * The '<em><b>Updated</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UPDATED_VALUE
   * @generated
   * @ordered
   */
  UPDATED(5, "Updated", "++");

  /**
   * The '<em><b>Valid</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Valid</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VALID
   * @model name="Valid" literal=""
   * @generated
   * @ordered
   */
  public static final int VALID_VALUE = 0;

  /**
   * The '<em><b>Implied</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Implied</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IMPLIED
   * @model name="Implied" literal="+"
   * @generated
   * @ordered
   */
  public static final int IMPLIED_VALUE = 1;

  /**
   * The '<em><b>Invalid</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Invalid</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INVALID
   * @model name="Invalid" literal="-"
   * @generated
   * @ordered
   */
  public static final int INVALID_VALUE = 2;

  /**
   * The '<em><b>Deleted</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Deleted</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DELETED
   * @model name="Deleted" literal="--"
   * @generated
   * @ordered
   */
  public static final int DELETED_VALUE = 3;

  /**
   * The '<em><b>Refined</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Refined</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REFINED
   * @model name="Refined" literal="+-"
   * @generated
   * @ordered
   */
  public static final int REFINED_VALUE = 4;

  /**
   * The '<em><b>Updated</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Updated</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UPDATED
   * @model name="Updated" literal="++"
   * @generated
   * @ordered
   */
  public static final int UPDATED_VALUE = 5;

  /**
   * An array of all the '<em><b>Validity</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Validity[] VALUES_ARRAY =
    new Validity[]
    {
      VALID,
      IMPLIED,
      INVALID,
      DELETED,
      REFINED,
      UPDATED,
    };

  /**
   * A public read-only list of all the '<em><b>Validity</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Validity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Validity</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Validity get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Validity result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Validity</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Validity getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Validity result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Validity</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Validity get(int value)
  {
    switch (value)
    {
      case VALID_VALUE: return VALID;
      case IMPLIED_VALUE: return IMPLIED;
      case INVALID_VALUE: return INVALID;
      case DELETED_VALUE: return DELETED;
      case REFINED_VALUE: return REFINED;
      case UPDATED_VALUE: return UPDATED;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private Validity(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //Validity
