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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.TextbtPackage
 * @generated
 */
public class TextbtSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TextbtPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextbtSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TextbtPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TextbtPackage.TEXT_BT:
      {
        TextBT textBT = (TextBT)theEObject;
        T result = caseTextBT(textBT);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.REQUIREMENT_LIST:
      {
        RequirementList requirementList = (RequirementList)theEObject;
        T result = caseRequirementList(requirementList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.REQUIREMENT:
      {
        Requirement requirement = (Requirement)theEObject;
        T result = caseRequirement(requirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.COMPONENT_LIST:
      {
        ComponentList componentList = (ComponentList)theEObject;
        T result = caseComponentList(componentList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.COMPONENT:
      {
        Component component = (Component)theEObject;
        T result = caseComponent(component);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.SYSTEM_COMPONENT:
      {
        SystemComponent systemComponent = (SystemComponent)theEObject;
        T result = caseSystemComponent(systemComponent);
        if (result == null) result = caseComponent(systemComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.OPTION_LIST:
      {
        OptionList optionList = (OptionList)theEObject;
        T result = caseOptionList(optionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.OPTION:
      {
        Option option = (Option)theEObject;
        T result = caseOption(option);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.BEHAVIOR_TREE:
      {
        BehaviorTree behaviorTree = (BehaviorTree)theEObject;
        T result = caseBehaviorTree(behaviorTree);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ABSTRACT_BEHAVIOR:
      {
        AbstractBehavior abstractBehavior = (AbstractBehavior)theEObject;
        T result = caseAbstractBehavior(abstractBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.RELATIONAL_BEHAVIOR:
      {
        RelationalBehavior relationalBehavior = (RelationalBehavior)theEObject;
        T result = caseRelationalBehavior(relationalBehavior);
        if (result == null) result = caseAbstractBehavior(relationalBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.RELATION:
      {
        Relation relation = (Relation)theEObject;
        T result = caseRelation(relation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.BEHAVIOR:
      {
        Behavior behavior = (Behavior)theEObject;
        T result = caseBehavior(behavior);
        if (result == null) result = caseAbstractBehavior(behavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.STATE:
      {
        State state = (State)theEObject;
        T result = caseState(state);
        if (result == null) result = caseBehavior(state);
        if (result == null) result = caseAbstractBehavior(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.SELECTION:
      {
        Selection selection = (Selection)theEObject;
        T result = caseSelection(selection);
        if (result == null) result = caseBehavior(selection);
        if (result == null) result = caseAbstractBehavior(selection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.EVENT:
      {
        Event event = (Event)theEObject;
        T result = caseEvent(event);
        if (result == null) result = caseBehavior(event);
        if (result == null) result = caseAbstractBehavior(event);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = caseBehavior(guard);
        if (result == null) result = caseAbstractBehavior(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.INTERNAL_INPUT:
      {
        InternalInput internalInput = (InternalInput)theEObject;
        T result = caseInternalInput(internalInput);
        if (result == null) result = caseBehavior(internalInput);
        if (result == null) result = caseAbstractBehavior(internalInput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.INTERNAL_OUTPUT:
      {
        InternalOutput internalOutput = (InternalOutput)theEObject;
        T result = caseInternalOutput(internalOutput);
        if (result == null) result = caseBehavior(internalOutput);
        if (result == null) result = caseAbstractBehavior(internalOutput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.EXTERNAL_INPUT:
      {
        ExternalInput externalInput = (ExternalInput)theEObject;
        T result = caseExternalInput(externalInput);
        if (result == null) result = caseBehavior(externalInput);
        if (result == null) result = caseAbstractBehavior(externalInput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.EXTERNAL_OUTPUT:
      {
        ExternalOutput externalOutput = (ExternalOutput)theEObject;
        T result = caseExternalOutput(externalOutput);
        if (result == null) result = caseBehavior(externalOutput);
        if (result == null) result = caseAbstractBehavior(externalOutput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ASSERTION:
      {
        Assertion assertion = (Assertion)theEObject;
        T result = caseAssertion(assertion);
        if (result == null) result = caseBehavior(assertion);
        if (result == null) result = caseAbstractBehavior(assertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ABSTRACT_BLOCK_OR_NODE:
      {
        AbstractBlockOrNode abstractBlockOrNode = (AbstractBlockOrNode)theEObject;
        T result = caseAbstractBlockOrNode(abstractBlockOrNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ABSTRACT_BLOCK:
      {
        AbstractBlock abstractBlock = (AbstractBlock)theEObject;
        T result = caseAbstractBlock(abstractBlock);
        if (result == null) result = caseAbstractBlockOrNode(abstractBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ABSTRACT_NODE:
      {
        AbstractNode abstractNode = (AbstractNode)theEObject;
        T result = caseAbstractNode(abstractNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.NODE:
      {
        Node node = (Node)theEObject;
        T result = caseNode(node);
        if (result == null) result = caseAbstractNode(node);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.SEQUENTIAL_NODE:
      {
        SequentialNode sequentialNode = (SequentialNode)theEObject;
        T result = caseSequentialNode(sequentialNode);
        if (result == null) result = caseAbstractNode(sequentialNode);
        if (result == null) result = caseAbstractBlockOrNode(sequentialNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ATOMIC_NODE:
      {
        AtomicNode atomicNode = (AtomicNode)theEObject;
        T result = caseAtomicNode(atomicNode);
        if (result == null) result = caseAbstractNode(atomicNode);
        if (result == null) result = caseAbstractBlockOrNode(atomicNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.PARALLEL_BLOCK:
      {
        ParallelBlock parallelBlock = (ParallelBlock)theEObject;
        T result = caseParallelBlock(parallelBlock);
        if (result == null) result = caseAbstractBlock(parallelBlock);
        if (result == null) result = caseAbstractBlockOrNode(parallelBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TextbtPackage.ALTERNATIVE_BLOCK:
      {
        AlternativeBlock alternativeBlock = (AlternativeBlock)theEObject;
        T result = caseAlternativeBlock(alternativeBlock);
        if (result == null) result = caseAbstractBlock(alternativeBlock);
        if (result == null) result = caseAbstractBlockOrNode(alternativeBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Text BT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text BT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTextBT(TextBT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementList(RequirementList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirement(Requirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentList(ComponentList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponent(Component object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehavior(Behavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseState(State object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelection(Selection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvent(Event object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Internal Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Internal Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInternalInput(InternalInput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Internal Output</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Internal Output</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInternalOutput(InternalOutput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalInput(ExternalInput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Output</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Output</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalOutput(ExternalOutput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNode(Node object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequential Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequential Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequentialNode(SequentialNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicNode(AtomicNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parallel Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parallel Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParallelBlock(ParallelBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternative Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternative Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternativeBlock(AlternativeBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Tree</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Tree</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorTree(BehaviorTree object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractBehavior(AbstractBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalBehavior(RelationalBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssertion(Assertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Block Or Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Block Or Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractBlockOrNode(AbstractBlockOrNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractBlock(AbstractBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractNode(AbstractNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelation(Relation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSystemComponent(SystemComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Option List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Option List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionList(OptionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Option</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Option</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOption(Option object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TextbtSwitch
