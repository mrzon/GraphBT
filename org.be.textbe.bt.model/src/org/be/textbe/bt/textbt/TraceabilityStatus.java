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
 * A representation of the literals of the enumeration '<em><b>Traceability Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage#getTraceabilityStatus()
 * @model
 * @generated
 */
public enum TraceabilityStatus implements Enumerator
{
  /**
   * The '<em><b>Original</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ORIGINAL_VALUE
   * @generated
   * @ordered
   */
  ORIGINAL(0, "Original", "ORIGINAL"),

  /**
   * The '<em><b>Implied</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IMPLIED_VALUE
   * @generated
   * @ordered
   */
  IMPLIED(1, "Implied", "IMPLIED"),

  /**
   * The '<em><b>Missing</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MISSING_VALUE
   * @generated
   * @ordered
   */
  MISSING(2, "Missing", "MISSING"),

  /**
   * The '<em><b>Updated</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UPDATED_VALUE
   * @generated
   * @ordered
   */
  UPDATED(3, "Updated", "UPDATED"),

  /**
   * The '<em><b>Deleted</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DELETED_VALUE
   * @generated
   * @ordered
   */
  DELETED(4, "Deleted", "DELETED"),

  /**
   * The '<em><b>Refined</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REFINED_VALUE
   * @generated
   * @ordered
   */
  REFINED(5, "Refined", "REFINED");

  /**
   * The '<em><b>Original</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Original</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ORIGINAL
   * @model name="Original" literal="ORIGINAL"
   * @generated
   * @ordered
   */
  public static final int ORIGINAL_VALUE = 0;

  /**
   * The '<em><b>Implied</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Implied</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IMPLIED
   * @model name="Implied" literal="IMPLIED"
   * @generated
   * @ordered
   */
  public static final int IMPLIED_VALUE = 1;

  /**
   * The '<em><b>Missing</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Missing</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MISSING
   * @model name="Missing" literal="MISSING"
   * @generated
   * @ordered
   */
  public static final int MISSING_VALUE = 2;

  /**
   * The '<em><b>Updated</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Updated</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UPDATED
   * @model name="Updated" literal="UPDATED"
   * @generated
   * @ordered
   */
  public static final int UPDATED_VALUE = 3;

  /**
   * The '<em><b>Deleted</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Deleted</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DELETED
   * @model name="Deleted" literal="DELETED"
   * @generated
   * @ordered
   */
  public static final int DELETED_VALUE = 4;

  /**
   * The '<em><b>Refined</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Refined</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REFINED
   * @model name="Refined" literal="REFINED"
   * @generated
   * @ordered
   */
  public static final int REFINED_VALUE = 5;

  /**
   * An array of all the '<em><b>Traceability Status</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final TraceabilityStatus[] VALUES_ARRAY =
    new TraceabilityStatus[]
    {
      ORIGINAL,
      IMPLIED,
      MISSING,
      UPDATED,
      DELETED,
      REFINED,
    };

  /**
   * A public read-only list of all the '<em><b>Traceability Status</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<TraceabilityStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Traceability Status</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TraceabilityStatus get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TraceabilityStatus result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Traceability Status</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TraceabilityStatus getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TraceabilityStatus result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Traceability Status</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TraceabilityStatus get(int value)
  {
    switch (value)
    {
      case ORIGINAL_VALUE: return ORIGINAL;
      case IMPLIED_VALUE: return IMPLIED;
      case MISSING_VALUE: return MISSING;
      case UPDATED_VALUE: return UPDATED;
      case DELETED_VALUE: return DELETED;
      case REFINED_VALUE: return REFINED;
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
  private TraceabilityStatus(int value, String name, String literal)
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
  
} //TraceabilityStatus
