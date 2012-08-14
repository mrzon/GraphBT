package bt.model;

/**
 * Defines the type of Node. 
 * @author agung
 *
 */
public enum BTNodeType{
	/**
	 * Definition:<br/>
	 * <img src="../../../../docs-files/BTNodeType/AtomicDefinition.PNG" width="150"/><br/>
	 * Example:<br/>
	 * <img src="../../../../docs-files/BTNodeType/AtomicExample.PNG" width="150"/><br/>
	 * Textual Notation: <code>N1;;(N2;T)</code><br/>
	 * Description:<pre>Execute N1 immediately followed by N2, passing control to tree T . The behaviour of concurrent BTs may not be interleaved between N1 and N2.</pre>
	 */
    ATOMICNODE,
    
    /**
	 * Definition:<br/>
	 * <img src="../../../../docs-files/BTNodeType/ParallelDefinition.PNG" width="150"/><br/>
	 * Example:<br/>
	 * <img src="../../../../docs-files/BTNodeType/ParallelExample.PNG" width="300"/><br/>
	 * Textual Notation: <code>N;(T1||T2)</code><br/>
	 * Description:<pre>Execute N, passing control to both T1
and T2.</pre>
	 */
    PARALLELBLOCK,
    
    /**
	 * Definition:<br/>
	 * <img src="../../../../docs-files/BTNodeType/SelectionDefinition.PNG" width="150"/><br/>
	 * Example:<br/>
	 * <img src="../../../../docs-files/BTNodeType/SelectionExample.PNG" width="300"/><br/>
	 * Textual Notation: <code>N;(T1[]T2)</code><br/>
	 * Description:<pre>A nondeterministic choice is made
between T1 and T2, depending on
which is ready to execute (not blocked)</pre>
	 */
    ALTERNATIVEBLOCK,
    
    /**
	 * Definition:<br/>
	 * <img src="../../../../docs-files/BTNodeType/SequentialDefinition.PNG" width="150"/><br/>
	 * Example:<br/>
	 * <img src="../../../../docs-files/BTNodeType/SequentialExample.PNG" width="150"/><br/>
	 * Textual Notation: <code>N;T</code><br/>
	 * Description:<pre>Execute N, passing control to tree T .
The behaviour of concurrent BTs may
be interleaved between N and T .</pre>
	 */
    SEQUENTIALNODE
}