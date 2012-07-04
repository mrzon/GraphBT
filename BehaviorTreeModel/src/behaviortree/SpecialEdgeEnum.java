/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Special Edge Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviortreePackage#getSpecialEdgeEnum()
 * @model
 * @generated
 */
public enum SpecialEdgeEnum implements Enumerator {
	/**
	 * The '<em><b>Reference</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE(0, "Reference", "=>"),

	/**
	 * The '<em><b>Reversion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVERSION_VALUE
	 * @generated
	 * @ordered
	 */
	REVERSION(1, "Reversion", "^"),

	/**
	 * The '<em><b>Branch Kill</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRANCH_KILL_VALUE
	 * @generated
	 * @ordered
	 */
	BRANCH_KILL(2, "BranchKill", "--"),

	/**
	 * The '<em><b>Synchronize</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SYNCHRONIZE(4, "Synchronize", "@");

	/**
	 * The '<em><b>Reference</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reference</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE
	 * @model name="Reference" literal="=>"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_VALUE = 0;

	/**
	 * The '<em><b>Reversion</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reversion</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REVERSION
	 * @model name="Reversion" literal="^"
	 * @generated
	 * @ordered
	 */
	public static final int REVERSION_VALUE = 1;

	/**
	 * The '<em><b>Branch Kill</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Branch Kill</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRANCH_KILL
	 * @model name="BranchKill" literal="--"
	 * @generated
	 * @ordered
	 */
	public static final int BRANCH_KILL_VALUE = 2;

	/**
	 * The '<em><b>Synchronize</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Synchronize</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZE
	 * @model name="Synchronize" literal="@"
	 * @generated
	 * @ordered
	 */
	public static final int SYNCHRONIZE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Special Edge Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SpecialEdgeEnum[] VALUES_ARRAY =
		new SpecialEdgeEnum[] {
			REFERENCE,
			REVERSION,
			BRANCH_KILL,
			SYNCHRONIZE,
		};

	/**
	 * A public read-only list of all the '<em><b>Special Edge Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SpecialEdgeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Special Edge Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpecialEdgeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpecialEdgeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Special Edge Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpecialEdgeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpecialEdgeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Special Edge Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpecialEdgeEnum get(int value) {
		switch (value) {
			case REFERENCE_VALUE: return REFERENCE;
			case REVERSION_VALUE: return REVERSION;
			case BRANCH_KILL_VALUE: return BRANCH_KILL;
			case SYNCHRONIZE_VALUE: return SYNCHRONIZE;
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
	private SpecialEdgeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SpecialEdgeEnum
