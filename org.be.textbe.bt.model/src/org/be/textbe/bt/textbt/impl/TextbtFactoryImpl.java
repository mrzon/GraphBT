/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

import org.be.textbe.bt.textbt.AlternativeBlock;
import org.be.textbe.bt.textbt.Assertion;
import org.be.textbe.bt.textbt.AtomicNode;
import org.be.textbe.bt.textbt.BehaviorTree;
import org.be.textbe.bt.textbt.Component;
import org.be.textbe.bt.textbt.ComponentList;
import org.be.textbe.bt.textbt.Event;
import org.be.textbe.bt.textbt.ExternalInput;
import org.be.textbe.bt.textbt.ExternalOutput;
import org.be.textbe.bt.textbt.FiveWs;
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
import org.be.textbe.bt.textbt.TextbtFactory;
import org.be.textbe.bt.textbt.TextbtPackage;
import org.be.textbe.bt.textbt.Validity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextbtFactoryImpl extends EFactoryImpl implements TextbtFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TextbtFactory init()
  {
    try
    {
      TextbtFactory theTextbtFactory = (TextbtFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.be.textbe/textbt"); 
      if (theTextbtFactory != null)
      {
        return theTextbtFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TextbtFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextbtFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TextbtPackage.TEXT_BT: return createTextBT();
      case TextbtPackage.REQUIREMENT_LIST: return createRequirementList();
      case TextbtPackage.REQUIREMENT: return createRequirement();
      case TextbtPackage.COMPONENT_LIST: return createComponentList();
      case TextbtPackage.COMPONENT: return createComponent();
      case TextbtPackage.SYSTEM_COMPONENT: return createSystemComponent();
      case TextbtPackage.OPTION_LIST: return createOptionList();
      case TextbtPackage.OPTION: return createOption();
      case TextbtPackage.BEHAVIOR_TREE: return createBehaviorTree();
      case TextbtPackage.RELATIONAL_BEHAVIOR: return createRelationalBehavior();
      case TextbtPackage.RELATION: return createRelation();
      case TextbtPackage.STATE: return createState();
      case TextbtPackage.SELECTION: return createSelection();
      case TextbtPackage.EVENT: return createEvent();
      case TextbtPackage.GUARD: return createGuard();
      case TextbtPackage.INTERNAL_INPUT: return createInternalInput();
      case TextbtPackage.INTERNAL_OUTPUT: return createInternalOutput();
      case TextbtPackage.EXTERNAL_INPUT: return createExternalInput();
      case TextbtPackage.EXTERNAL_OUTPUT: return createExternalOutput();
      case TextbtPackage.ASSERTION: return createAssertion();
      case TextbtPackage.NODE: return createNode();
      case TextbtPackage.SEQUENTIAL_NODE: return createSequentialNode();
      case TextbtPackage.ATOMIC_NODE: return createAtomicNode();
      case TextbtPackage.PARALLEL_BLOCK: return createParallelBlock();
      case TextbtPackage.ALTERNATIVE_BLOCK: return createAlternativeBlock();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TextbtPackage.FIVE_WS:
        return createFiveWsFromString(eDataType, initialValue);
      case TextbtPackage.VALIDITY:
        return createValidityFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TextbtPackage.FIVE_WS:
        return convertFiveWsToString(eDataType, instanceValue);
      case TextbtPackage.VALIDITY:
        return convertValidityToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextBT createTextBT()
  {
    TextBTImpl textBT = new TextBTImpl();
    return textBT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementList createRequirementList()
  {
    RequirementListImpl requirementList = new RequirementListImpl();
    return requirementList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement createRequirement()
  {
    RequirementImpl requirement = new RequirementImpl();
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentList createComponentList()
  {
    ComponentListImpl componentList = new ComponentListImpl();
    return componentList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Component createComponent()
  {
    ComponentImpl component = new ComponentImpl();
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemComponent createSystemComponent()
  {
    SystemComponentImpl systemComponent = new SystemComponentImpl();
    return systemComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionList createOptionList()
  {
    OptionListImpl optionList = new OptionListImpl();
    return optionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Option createOption()
  {
    OptionImpl option = new OptionImpl();
    return option;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorTree createBehaviorTree()
  {
    BehaviorTreeImpl behaviorTree = new BehaviorTreeImpl();
    return behaviorTree;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalBehavior createRelationalBehavior()
  {
    RelationalBehaviorImpl relationalBehavior = new RelationalBehaviorImpl();
    return relationalBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relation createRelation()
  {
    RelationImpl relation = new RelationImpl();
    return relation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selection createSelection()
  {
    SelectionImpl selection = new SelectionImpl();
    return selection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InternalInput createInternalInput()
  {
    InternalInputImpl internalInput = new InternalInputImpl();
    return internalInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InternalOutput createInternalOutput()
  {
    InternalOutputImpl internalOutput = new InternalOutputImpl();
    return internalOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalInput createExternalInput()
  {
    ExternalInputImpl externalInput = new ExternalInputImpl();
    return externalInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalOutput createExternalOutput()
  {
    ExternalOutputImpl externalOutput = new ExternalOutputImpl();
    return externalOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assertion createAssertion()
  {
    AssertionImpl assertion = new AssertionImpl();
    return assertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequentialNode createSequentialNode()
  {
    SequentialNodeImpl sequentialNode = new SequentialNodeImpl();
    return sequentialNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicNode createAtomicNode()
  {
    AtomicNodeImpl atomicNode = new AtomicNodeImpl();
    return atomicNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParallelBlock createParallelBlock()
  {
    ParallelBlockImpl parallelBlock = new ParallelBlockImpl();
    return parallelBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlternativeBlock createAlternativeBlock()
  {
    AlternativeBlockImpl alternativeBlock = new AlternativeBlockImpl();
    return alternativeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FiveWs createFiveWsFromString(EDataType eDataType, String initialValue)
  {
    FiveWs result = FiveWs.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFiveWsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Validity createValidityFromString(EDataType eDataType, String initialValue)
  {
    Validity result = Validity.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValidityToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextbtPackage getTextbtPackage()
  {
    return (TextbtPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TextbtPackage getPackage()
  {
    return TextbtPackage.eINSTANCE;
  }

} //TextbtFactoryImpl
