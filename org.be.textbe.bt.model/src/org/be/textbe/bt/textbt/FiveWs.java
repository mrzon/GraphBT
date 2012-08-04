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
 * A representation of the literals of the enumeration '<em><b>Five Ws</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage#getFiveWs()
 * @model
 * @generated
 */
public enum FiveWs implements Enumerator
{
  /**
   * The '<em><b>Who</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WHO_VALUE
   * @generated
   * @ordered
   */
  WHO(0, "Who", "Who"),

  /**
   * The '<em><b>What</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WHAT_VALUE
   * @generated
   * @ordered
   */
  WHAT(1, "What", "What"),

  /**
   * The '<em><b>Where</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WHERE_VALUE
   * @generated
   * @ordered
   */
  WHERE(2, "Where", "Where"),

  /**
   * The '<em><b>When</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WHEN_VALUE
   * @generated
   * @ordered
   */
  WHEN(3, "When", "When"),

  /**
   * The '<em><b>Why</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WHY_VALUE
   * @generated
   * @ordered
   */
  WHY(4, "Why", "Why"),

  /**
   * The '<em><b>How</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HOW_VALUE
   * @generated
   * @ordered
   */
  HOW(5, "How", "How");

  /**
   * The '<em><b>Who</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Who</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WHO
   * @model name="Who"
   * @generated
   * @ordered
   */
  public static final int WHO_VALUE = 0;

  /**
   * The '<em><b>What</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>What</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WHAT
   * @model name="What"
   * @generated
   * @ordered
   */
  public static final int WHAT_VALUE = 1;

  /**
   * The '<em><b>Where</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Where</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WHERE
   * @model name="Where"
   * @generated
   * @ordered
   */
  public static final int WHERE_VALUE = 2;

  /**
   * The '<em><b>When</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>When</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WHEN
   * @model name="When"
   * @generated
   * @ordered
   */
  public static final int WHEN_VALUE = 3;

  /**
   * The '<em><b>Why</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Why</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WHY
   * @model name="Why"
   * @generated
   * @ordered
   */
  public static final int WHY_VALUE = 4;

  /**
   * The '<em><b>How</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>How</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HOW
   * @model name="How"
   * @generated
   * @ordered
   */
  public static final int HOW_VALUE = 5;

  /**
   * An array of all the '<em><b>Five Ws</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final FiveWs[] VALUES_ARRAY =
    new FiveWs[]
    {
      WHO,
      WHAT,
      WHERE,
      WHEN,
      WHY,
      HOW,
    };

  /**
   * A public read-only list of all the '<em><b>Five Ws</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<FiveWs> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Five Ws</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FiveWs get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FiveWs result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Five Ws</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FiveWs getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FiveWs result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Five Ws</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FiveWs get(int value)
  {
    switch (value)
    {
      case WHO_VALUE: return WHO;
      case WHAT_VALUE: return WHAT;
      case WHERE_VALUE: return WHERE;
      case WHEN_VALUE: return WHEN;
      case WHY_VALUE: return WHY;
      case HOW_VALUE: return HOW;
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
  private FiveWs(int value, String name, String literal)
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
  
} //FiveWs
