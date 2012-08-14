/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.model;

/**
 *
 * @author Emerson
 */
public enum BTBehaviorType {
	/**
	 * Textual Notation : <code>recv C.e</code><br/>
	 * Type : <code>Internal Input Event</code><br/>
	 * Explanation: Wait for event e (from system)<br/>
	 * <img src="../../../../docs-files/BTType/InternalInputEvent.PNG" width="300" />
	 */
    INTERNALINPUT,
    /**
	 * Textual Notation : <code>send C.e</code><br/>
	 * Type : <code>Internal Output Event</code><br/>
	 * Explanation: Generate event <code>e</code> internally to system<br/>
	 * <img src="../../../../docs-files/BTType/InternalOutputEvent.PNG" width="300" />
	 */
    INTERNALOUTPUT,
    /**
	 * Textual Notation : None <br/>
	 * Type : <code>External Input Event</code><br/>
	 * Explanation: Wait for event <code>e</code> to be received from environment<br/>
	 * <img src="../../../../docs-files/BTType/ExternalInputEvent.PNG" width="300" />
	 */
    EXTERNALINPUT,
    /**
	 * Textual Notation : None <br/>
	 * Type : <code>External Output Event</code><br/>
	 * Explanation: Generate event <code>e</code> and send to environment<br/>
	 * <img src="../../../../docs-files/BTType/ExternalOutputEvent.PNG" width="300" />
	 */
    EXTERNALOUTPUT,
    /**
	 * Textual Notation : <code>C[s]</code><br/>
	 * Type : <code>State Realisation</code><br/>
	 * Explanation: Component <code>C</code> realises state <code>s</code><br/>
	 * <img src="../../../../docs-files/BTType/StateRealisation.PNG" width="300" />
	 */
    STATE,
    /**
	 * Textual Notation : <code>C???s???</code><br/>
	 * Type : <code>Guard</code><br/>
	 * Explanation: Wait until <code>C</code> is in state <code>S</code><br/>
	 * <img src="../../../../docs-files/BTType/Guard.PNG" width="300" />
	 */
    GUARD,
    /**
	 * Textual Notation : <code>C?s?</code><br/>
	 * Type : <code>Selection</code><br/>
	 * Explanation: Special<br/>
	 * <img src="../../../../docs-files/BTType/Selection.PNG" width="300" />
	 */
    SELECTION;
}
