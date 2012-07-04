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
 * A representation of the literals of the enumeration '<em><b>Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviortreePackage#getOperator()
 * @model
 * @generated
 */
public enum Operator implements Enumerator {
	/**
	 * The '<em><b>Reference</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_VALUE
	 * 
	 * @ordered
	 */
	REFERENCE(0, "Reference", "=>"),

	/**
	 * The '<em><b>Reversion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVERSION_VALUE
	 * 
	 * @ordered
	 */
	REVERSION(1, "Reversion", "^"),

	/**
	 * The '<em><b>Branch Kill</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRANCH_KILL_VALUE
	 * 
	 * @ordered
	 */
	BRANCH_KILL(2, "BranchKill", "--"),

	/**
	 * The '<em><b>Synchronize</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZE_VALUE
	 * 
	 * @ordered
	 */
	SYNCHRONIZE(3, "Synchronize", "@"),

	/**
	 * The '<em><b>Conjunction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONJUNCTION_VALUE
	 * 
	 * @ordered
	 */
	CONJUNCTION(4, "Conjunction", "&&"),

	/**
	 * The '<em><b>Disjunction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISJUNCTION_VALUE
	 * 
	 * @ordered
	 */
	DISJUNCTION(5, "Disjunction", "||"),

	/**
	 * The '<em><b>Exclusive OR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXCLUSIVE_OR_VALUE
	 * @
	 * @ordered
	 */
	EXCLUSIVE_OR(6, "ExclusiveOR", "^^"), /**
	 * The '<em><b>No Operator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_OPERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	NO_OPERATOR(7, "NoOperator", "");

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
	public static final int SYNCHRONIZE_VALUE = 3;

	/**
	 * The '<em><b>Conjunction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Conjunction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONJUNCTION
	 * @model name="Conjunction" literal="&&"
	 * @generated
	 * @ordered
	 */
	public static final int CONJUNCTION_VALUE = 4;

	/**
	 * The '<em><b>Disjunction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disjunction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISJUNCTION
	 * @model name="Disjunction" literal="||"
	 * @generated
	 * @ordered
	 */
	public static final int DISJUNCTION_VALUE = 5;

	/**
	 * The '<em><b>Exclusive OR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exclusive OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXCLUSIVE_OR
	 * @model name="ExclusiveOR" literal="^^"
	 * @generated
	 * @ordered
	 */
	public static final int EXCLUSIVE_OR_VALUE = 6;

	/**
	 * The '<em><b>No Operator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No Operator</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_OPERATOR
	 * @model name="NoOperator" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int NO_OPERATOR_VALUE = 7;

	/**
	 * An array of all the '<em><b>Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Operator[] VALUES_ARRAY =
		new Operator[] {
			REFERENCE,
			REVERSION,
			BRANCH_KILL,
			SYNCHRONIZE,
			CONJUNCTION,
			DISJUNCTION,
			EXCLUSIVE_OR,
			NO_OPERATOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Operator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operator get(int value) {
		switch (value) {
			case REFERENCE_VALUE: return REFERENCE;
			case REVERSION_VALUE: return REVERSION;
			case BRANCH_KILL_VALUE: return BRANCH_KILL;
			case SYNCHRONIZE_VALUE: return SYNCHRONIZE;
			case CONJUNCTION_VALUE: return CONJUNCTION;
			case DISJUNCTION_VALUE: return DISJUNCTION;
			case EXCLUSIVE_OR_VALUE: return EXCLUSIVE_OR;
			case NO_OPERATOR_VALUE: return NO_OPERATOR;
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
	private Operator(int value, String name, String literal) {
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
	
} //Operator
