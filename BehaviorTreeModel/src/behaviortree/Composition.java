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
 * A representation of the literals of the enumeration '<em><b>Composition</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviortreePackage#getComposition()
 * @model
 * @generated
 */
public enum Composition implements Enumerator {
	/**
	 * The '<em><b>Sequential</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENTIAL_VALUE
	 * @generated
	 * @ordered
	 */
	SEQUENTIAL(0, "Sequential", "Sequential"),

	/**
	 * The '<em><b>Atomic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATOMIC_VALUE
	 * @generated
	 * @ordered
	 */
	ATOMIC(1, "Atomic", "Atomic");

	/**
	 * The '<em><b>Sequential</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sequential</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENTIAL
	 * @model name="Sequential"
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENTIAL_VALUE = 0;

	/**
	 * The '<em><b>Atomic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Atomic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATOMIC
	 * @model name="Atomic"
	 * @generated
	 * @ordered
	 */
	public static final int ATOMIC_VALUE = 1;

	/**
	 * An array of all the '<em><b>Composition</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Composition[] VALUES_ARRAY =
		new Composition[] {
			SEQUENTIAL,
			ATOMIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Composition</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Composition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Composition</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Composition get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Composition result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Composition</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Composition getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Composition result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Composition</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Composition get(int value) {
		switch (value) {
			case SEQUENTIAL_VALUE: return SEQUENTIAL;
			case ATOMIC_VALUE: return ATOMIC;
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
	private Composition(int value, String name, String literal) {
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
	
} //Composition
