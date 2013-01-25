/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.graphbt.model.graphbt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Behavior Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.be.graphbt.model.graphbt.GraphBTPackage#getBehaviorType()
 * @model
 * @generated
 */
public enum BehaviorType implements Enumerator {
	/**
	 * The '<em><b>State Realization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_REALIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_REALIZATION(0, "StateRealization", "StateRealization"),

	/**
	 * The '<em><b>Selection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	SELECTION(1, "Selection", "Selection"),

	/**
	 * The '<em><b>Guard</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUARD_VALUE
	 * @generated
	 * @ordered
	 */
	GUARD(2, "Guard", "Guard"),

	/**
	 * The '<em><b>Internal Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNAL_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	INTERNAL_INPUT(3, "InternalInput", "InternalInput"),

	/**
	 * The '<em><b>Interna Output</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNA_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	INTERNA_OUTPUT(4, "InternaOutput", "InternaOutput"),

	/**
	 * The '<em><b>External Output</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERNAL_OUTPUT(5, "ExternalOutput", "ExternalOutput"),

	/**
	 * The '<em><b>External Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERNAL_INPUT(6, "ExternalInput", "ExternalInput");

	/**
	 * The '<em><b>State Realization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>State Realization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE_REALIZATION
	 * @model name="StateRealization"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_REALIZATION_VALUE = 0;

	/**
	 * The '<em><b>Selection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Selection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELECTION
	 * @model name="Selection"
	 * @generated
	 * @ordered
	 */
	public static final int SELECTION_VALUE = 1;

	/**
	 * The '<em><b>Guard</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Guard</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUARD
	 * @model name="Guard"
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_VALUE = 2;

	/**
	 * The '<em><b>Internal Input</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Internal Input</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERNAL_INPUT
	 * @model name="InternalInput"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_INPUT_VALUE = 3;

	/**
	 * The '<em><b>Interna Output</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interna Output</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERNA_OUTPUT
	 * @model name="InternaOutput"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNA_OUTPUT_VALUE = 4;

	/**
	 * The '<em><b>External Output</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>External Output</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_OUTPUT
	 * @model name="ExternalOutput"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNAL_OUTPUT_VALUE = 5;

	/**
	 * The '<em><b>External Input</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>External Input</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_INPUT
	 * @model name="ExternalInput"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNAL_INPUT_VALUE = 6;

	/**
	 * An array of all the '<em><b>Behavior Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BehaviorType[] VALUES_ARRAY =
		new BehaviorType[] {
			STATE_REALIZATION,
			SELECTION,
			GUARD,
			INTERNAL_INPUT,
			INTERNA_OUTPUT,
			EXTERNAL_OUTPUT,
			EXTERNAL_INPUT,
		};

	/**
	 * A public read-only list of all the '<em><b>Behavior Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BehaviorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Behavior Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BehaviorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BehaviorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Behavior Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BehaviorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BehaviorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Behavior Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BehaviorType get(int value) {
		switch (value) {
			case STATE_REALIZATION_VALUE: return STATE_REALIZATION;
			case SELECTION_VALUE: return SELECTION;
			case GUARD_VALUE: return GUARD;
			case INTERNAL_INPUT_VALUE: return INTERNAL_INPUT;
			case INTERNA_OUTPUT_VALUE: return INTERNA_OUTPUT;
			case EXTERNAL_OUTPUT_VALUE: return EXTERNAL_OUTPUT;
			case EXTERNAL_INPUT_VALUE: return EXTERNAL_INPUT;
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
	private BehaviorType(int value, String name, String literal) {
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
	
	public String getOpenBracket() {
		switch (value) {
		case STATE_REALIZATION_VALUE: return "[";
		case SELECTION_VALUE: return "?";
		case GUARD_VALUE: return "???";
		case INTERNAL_INPUT_VALUE: return ">";
		case INTERNA_OUTPUT_VALUE: return "<";
		case EXTERNAL_OUTPUT_VALUE: return "<<";
		case EXTERNAL_INPUT_VALUE: return ">>";
	}

		return null;
	}
	
	public String getCloseBracket() {
		switch (value) {
			case STATE_REALIZATION_VALUE: return "]";
			case SELECTION_VALUE: return "?";
			case GUARD_VALUE: return "???";
			case INTERNAL_INPUT_VALUE: return "<";
			case INTERNA_OUTPUT_VALUE: return ">";
			case EXTERNAL_OUTPUT_VALUE: return ">>";
			case EXTERNAL_INPUT_VALUE: return "<<";
		}
		return null;
	}
} //BehaviorType
