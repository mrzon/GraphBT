/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.util;

import org.be.textbe.bt.textbt.AbstractBehavior;
import org.be.textbe.bt.textbt.AbstractBlock;
import org.be.textbe.bt.textbt.AbstractBlockOrNode;
import org.be.textbe.bt.textbt.AbstractNode;
import org.be.textbe.bt.textbt.AlternativeBlock;
import org.be.textbe.bt.textbt.Assertion;
import org.be.textbe.bt.textbt.AtomicNode;
import org.be.textbe.bt.textbt.Behavior;
import org.be.textbe.bt.textbt.BehaviorTree;
import org.be.textbe.bt.textbt.Component;
import org.be.textbe.bt.textbt.ComponentList;
import org.be.textbe.bt.textbt.Event;
import org.be.textbe.bt.textbt.ExternalInput;
import org.be.textbe.bt.textbt.ExternalOutput;
import org.be.textbe.bt.textbt.Guard;
import org.be.textbe.bt.textbt.InternalInput;
import org.be.textbe.bt.textbt.InternalOutput;
import org.be.textbe.bt.textbt.Node;
import org.be.textbe.bt.textbt.Option;
import org.be.textbe.bt.textbt.OptionList;
import org.be.textbe.bt.textbt.ParallelBlock;
import org.be.textbe.bt.textbt.Relation;
import org.be.textbe.bt.textbt.RelationalBehavior;
import org.be.textbe.bt.textbt.Requirement;
import org.be.textbe.bt.textbt.RequirementList;
import org.be.textbe.bt.textbt.Selection;
import org.be.textbe.bt.textbt.SequentialNode;
import org.be.textbe.bt.textbt.State;
import org.be.textbe.bt.textbt.SystemComponent;
import org.be.textbe.bt.textbt.TextBT;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage
 * @generated
 */
public class TextbtAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TextbtPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextbtAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TextbtPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TextbtSwitch<Adapter> modelSwitch =
    new TextbtSwitch<Adapter>()
    {
      @Override
      public Adapter caseTextBT(TextBT object)
      {
        return createTextBTAdapter();
      }
      @Override
      public Adapter caseRequirementList(RequirementList object)
      {
        return createRequirementListAdapter();
      }
      @Override
      public Adapter caseRequirement(Requirement object)
      {
        return createRequirementAdapter();
      }
      @Override
      public Adapter caseComponentList(ComponentList object)
      {
        return createComponentListAdapter();
      }
      @Override
      public Adapter caseComponent(Component object)
      {
        return createComponentAdapter();
      }
      @Override
      public Adapter caseSystemComponent(SystemComponent object)
      {
        return createSystemComponentAdapter();
      }
      @Override
      public Adapter caseOptionList(OptionList object)
      {
        return createOptionListAdapter();
      }
      @Override
      public Adapter caseOption(Option object)
      {
        return createOptionAdapter();
      }
      @Override
      public Adapter caseBehaviorTree(BehaviorTree object)
      {
        return createBehaviorTreeAdapter();
      }
      @Override
      public Adapter caseAbstractBehavior(AbstractBehavior object)
      {
        return createAbstractBehaviorAdapter();
      }
      @Override
      public Adapter caseRelationalBehavior(RelationalBehavior object)
      {
        return createRelationalBehaviorAdapter();
      }
      @Override
      public Adapter caseRelation(Relation object)
      {
        return createRelationAdapter();
      }
      @Override
      public Adapter caseBehavior(Behavior object)
      {
        return createBehaviorAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseSelection(Selection object)
      {
        return createSelectionAdapter();
      }
      @Override
      public Adapter caseEvent(Event object)
      {
        return createEventAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseInternalInput(InternalInput object)
      {
        return createInternalInputAdapter();
      }
      @Override
      public Adapter caseInternalOutput(InternalOutput object)
      {
        return createInternalOutputAdapter();
      }
      @Override
      public Adapter caseExternalInput(ExternalInput object)
      {
        return createExternalInputAdapter();
      }
      @Override
      public Adapter caseExternalOutput(ExternalOutput object)
      {
        return createExternalOutputAdapter();
      }
      @Override
      public Adapter caseAssertion(Assertion object)
      {
        return createAssertionAdapter();
      }
      @Override
      public Adapter caseAbstractBlockOrNode(AbstractBlockOrNode object)
      {
        return createAbstractBlockOrNodeAdapter();
      }
      @Override
      public Adapter caseAbstractBlock(AbstractBlock object)
      {
        return createAbstractBlockAdapter();
      }
      @Override
      public Adapter caseAbstractNode(AbstractNode object)
      {
        return createAbstractNodeAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseSequentialNode(SequentialNode object)
      {
        return createSequentialNodeAdapter();
      }
      @Override
      public Adapter caseAtomicNode(AtomicNode object)
      {
        return createAtomicNodeAdapter();
      }
      @Override
      public Adapter caseParallelBlock(ParallelBlock object)
      {
        return createParallelBlockAdapter();
      }
      @Override
      public Adapter caseAlternativeBlock(AlternativeBlock object)
      {
        return createAlternativeBlockAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.TextBT <em>Text BT</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.TextBT
   * @generated
   */
  public Adapter createTextBTAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.RequirementList <em>Requirement List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.RequirementList
   * @generated
   */
  public Adapter createRequirementListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Requirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Requirement
   * @generated
   */
  public Adapter createRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.ComponentList <em>Component List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.ComponentList
   * @generated
   */
  public Adapter createComponentListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Component
   * @generated
   */
  public Adapter createComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Behavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Behavior
   * @generated
   */
  public Adapter createBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Selection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Selection
   * @generated
   */
  public Adapter createSelectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Event
   * @generated
   */
  public Adapter createEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.InternalInput <em>Internal Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.InternalInput
   * @generated
   */
  public Adapter createInternalInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.InternalOutput <em>Internal Output</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.InternalOutput
   * @generated
   */
  public Adapter createInternalOutputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.ExternalInput <em>External Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.ExternalInput
   * @generated
   */
  public Adapter createExternalInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.ExternalOutput <em>External Output</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.ExternalOutput
   * @generated
   */
  public Adapter createExternalOutputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.SequentialNode <em>Sequential Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.SequentialNode
   * @generated
   */
  public Adapter createSequentialNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AtomicNode <em>Atomic Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AtomicNode
   * @generated
   */
  public Adapter createAtomicNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.ParallelBlock <em>Parallel Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.ParallelBlock
   * @generated
   */
  public Adapter createParallelBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AlternativeBlock <em>Alternative Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AlternativeBlock
   * @generated
   */
  public Adapter createAlternativeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.BehaviorTree <em>Behavior Tree</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.BehaviorTree
   * @generated
   */
  public Adapter createBehaviorTreeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AbstractBehavior <em>Abstract Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AbstractBehavior
   * @generated
   */
  public Adapter createAbstractBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.RelationalBehavior <em>Relational Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.RelationalBehavior
   * @generated
   */
  public Adapter createRelationalBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Assertion
   * @generated
   */
  public Adapter createAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AbstractBlockOrNode <em>Abstract Block Or Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AbstractBlockOrNode
   * @generated
   */
  public Adapter createAbstractBlockOrNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AbstractBlock <em>Abstract Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AbstractBlock
   * @generated
   */
  public Adapter createAbstractBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.AbstractNode <em>Abstract Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.AbstractNode
   * @generated
   */
  public Adapter createAbstractNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Relation
   * @generated
   */
  public Adapter createRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.SystemComponent <em>System Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.SystemComponent
   * @generated
   */
  public Adapter createSystemComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.OptionList <em>Option List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.OptionList
   * @generated
   */
  public Adapter createOptionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.be.textbe.bt.textbt.Option <em>Option</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.be.textbe.bt.textbt.Option
   * @generated
   */
  public Adapter createOptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TextbtAdapterFactory
