/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt.impl;

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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextbtPackageImpl extends EPackageImpl implements TextbtPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textBTEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass systemComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorTreeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass internalInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass internalOutputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalOutputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractBlockOrNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequentialNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parallelBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alternativeBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum fiveWsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum validityEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.be.textbe.bt.textbt.TextbtPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TextbtPackageImpl()
  {
    super(eNS_URI, TextbtFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TextbtPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TextbtPackage init()
  {
    if (isInited) return (TextbtPackage)EPackage.Registry.INSTANCE.getEPackage(TextbtPackage.eNS_URI);

    // Obtain or create and register package
    TextbtPackageImpl theTextbtPackage = (TextbtPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextbtPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextbtPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTextbtPackage.createPackageContents();

    // Initialize created meta-data
    theTextbtPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTextbtPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TextbtPackage.eNS_URI, theTextbtPackage);
    return theTextbtPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTextBT()
  {
    return textBTEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTextBT_Options()
  {
    return (EReference)textBTEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTextBT_Requirements()
  {
    return (EReference)textBTEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTextBT_Components()
  {
    return (EReference)textBTEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTextBT_BehaviorTree()
  {
    return (EReference)textBTEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirementList()
  {
    return requirementListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirementList_Requirements()
  {
    return (EReference)requirementListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirement()
  {
    return requirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequirement_Ref()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequirement_Val()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentList()
  {
    return componentListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentList_Components()
  {
    return (EReference)componentListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponent()
  {
    return componentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Ref()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Val()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponent_Behaviors()
  {
    return (EReference)componentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Quantifier()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSystemComponent()
  {
    return systemComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionList()
  {
    return optionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptionList_Options()
  {
    return (EReference)optionListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOption()
  {
    return optionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOption_Name()
  {
    return (EAttribute)optionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOption_Value()
  {
    return (EAttribute)optionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehaviorTree()
  {
    return behaviorTreeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorTree_RootNode()
  {
    return (EReference)behaviorTreeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractBehavior()
  {
    return abstractBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalBehavior()
  {
    return relationalBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalBehavior_Behavior()
  {
    return (EReference)relationalBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalBehavior_Relations()
  {
    return (EReference)relationalBehaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelation()
  {
    return relationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_Question()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_Preposition()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_ComponentRef()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_BehaviorRef()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_Level()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_ComponentLevel()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_ComponentSet()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_Mci()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehavior()
  {
    return behaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBehavior_Ref()
  {
    return (EAttribute)behaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBehavior_Val()
  {
    return (EAttribute)behaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehavior_Relations()
  {
    return (EReference)behaviorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelection()
  {
    return selectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard()
  {
    return guardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInternalInput()
  {
    return internalInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInternalOutput()
  {
    return internalOutputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalInput()
  {
    return externalInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalOutput()
  {
    return externalOutputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssertion()
  {
    return assertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractBlockOrNode()
  {
    return abstractBlockOrNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractBlock()
  {
    return abstractBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractBlock_ChildNode()
  {
    return (EReference)abstractBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractNode()
  {
    return abstractNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_ComponentRef()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_BehaviorRef()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_RequirementRef()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_TraceabilityStatus()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_Label()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_Operator()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_ComponentSet()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractNode_Mci()
  {
    return (EAttribute)abstractNodeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNode()
  {
    return nodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_ChildNode()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequentialNode()
  {
    return sequentialNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequentialNode_ChildNode()
  {
    return (EReference)sequentialNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicNode()
  {
    return atomicNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicNode_ChildNode()
  {
    return (EReference)atomicNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParallelBlock()
  {
    return parallelBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlternativeBlock()
  {
    return alternativeBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFiveWs()
  {
    return fiveWsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getValidity()
  {
    return validityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextbtFactory getTextbtFactory()
  {
    return (TextbtFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    textBTEClass = createEClass(TEXT_BT);
    createEReference(textBTEClass, TEXT_BT__OPTIONS);
    createEReference(textBTEClass, TEXT_BT__REQUIREMENTS);
    createEReference(textBTEClass, TEXT_BT__COMPONENTS);
    createEReference(textBTEClass, TEXT_BT__BEHAVIOR_TREE);

    requirementListEClass = createEClass(REQUIREMENT_LIST);
    createEReference(requirementListEClass, REQUIREMENT_LIST__REQUIREMENTS);

    requirementEClass = createEClass(REQUIREMENT);
    createEAttribute(requirementEClass, REQUIREMENT__REF);
    createEAttribute(requirementEClass, REQUIREMENT__VAL);

    componentListEClass = createEClass(COMPONENT_LIST);
    createEReference(componentListEClass, COMPONENT_LIST__COMPONENTS);

    componentEClass = createEClass(COMPONENT);
    createEAttribute(componentEClass, COMPONENT__REF);
    createEAttribute(componentEClass, COMPONENT__VAL);
    createEReference(componentEClass, COMPONENT__BEHAVIORS);
    createEAttribute(componentEClass, COMPONENT__QUANTIFIER);

    systemComponentEClass = createEClass(SYSTEM_COMPONENT);

    optionListEClass = createEClass(OPTION_LIST);
    createEReference(optionListEClass, OPTION_LIST__OPTIONS);

    optionEClass = createEClass(OPTION);
    createEAttribute(optionEClass, OPTION__NAME);
    createEAttribute(optionEClass, OPTION__VALUE);

    behaviorTreeEClass = createEClass(BEHAVIOR_TREE);
    createEReference(behaviorTreeEClass, BEHAVIOR_TREE__ROOT_NODE);

    abstractBehaviorEClass = createEClass(ABSTRACT_BEHAVIOR);

    relationalBehaviorEClass = createEClass(RELATIONAL_BEHAVIOR);
    createEReference(relationalBehaviorEClass, RELATIONAL_BEHAVIOR__BEHAVIOR);
    createEReference(relationalBehaviorEClass, RELATIONAL_BEHAVIOR__RELATIONS);

    relationEClass = createEClass(RELATION);
    createEAttribute(relationEClass, RELATION__QUESTION);
    createEAttribute(relationEClass, RELATION__PREPOSITION);
    createEAttribute(relationEClass, RELATION__COMPONENT_REF);
    createEAttribute(relationEClass, RELATION__BEHAVIOR_REF);
    createEAttribute(relationEClass, RELATION__LEVEL);
    createEAttribute(relationEClass, RELATION__COMPONENT_LEVEL);
    createEAttribute(relationEClass, RELATION__COMPONENT_SET);
    createEAttribute(relationEClass, RELATION__MCI);

    behaviorEClass = createEClass(BEHAVIOR);
    createEAttribute(behaviorEClass, BEHAVIOR__REF);
    createEAttribute(behaviorEClass, BEHAVIOR__VAL);
    createEReference(behaviorEClass, BEHAVIOR__RELATIONS);

    stateEClass = createEClass(STATE);

    selectionEClass = createEClass(SELECTION);

    eventEClass = createEClass(EVENT);

    guardEClass = createEClass(GUARD);

    internalInputEClass = createEClass(INTERNAL_INPUT);

    internalOutputEClass = createEClass(INTERNAL_OUTPUT);

    externalInputEClass = createEClass(EXTERNAL_INPUT);

    externalOutputEClass = createEClass(EXTERNAL_OUTPUT);

    assertionEClass = createEClass(ASSERTION);

    abstractBlockOrNodeEClass = createEClass(ABSTRACT_BLOCK_OR_NODE);

    abstractBlockEClass = createEClass(ABSTRACT_BLOCK);
    createEReference(abstractBlockEClass, ABSTRACT_BLOCK__CHILD_NODE);

    abstractNodeEClass = createEClass(ABSTRACT_NODE);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__COMPONENT_REF);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__BEHAVIOR_REF);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__REQUIREMENT_REF);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__TRACEABILITY_STATUS);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__LABEL);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__OPERATOR);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__COMPONENT_SET);
    createEAttribute(abstractNodeEClass, ABSTRACT_NODE__MCI);

    nodeEClass = createEClass(NODE);
    createEReference(nodeEClass, NODE__CHILD_NODE);

    sequentialNodeEClass = createEClass(SEQUENTIAL_NODE);
    createEReference(sequentialNodeEClass, SEQUENTIAL_NODE__CHILD_NODE);

    atomicNodeEClass = createEClass(ATOMIC_NODE);
    createEReference(atomicNodeEClass, ATOMIC_NODE__CHILD_NODE);

    parallelBlockEClass = createEClass(PARALLEL_BLOCK);

    alternativeBlockEClass = createEClass(ALTERNATIVE_BLOCK);

    // Create enums
    fiveWsEEnum = createEEnum(FIVE_WS);
    validityEEnum = createEEnum(VALIDITY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    systemComponentEClass.getESuperTypes().add(this.getComponent());
    relationalBehaviorEClass.getESuperTypes().add(this.getAbstractBehavior());
    behaviorEClass.getESuperTypes().add(this.getAbstractBehavior());
    stateEClass.getESuperTypes().add(this.getBehavior());
    selectionEClass.getESuperTypes().add(this.getBehavior());
    eventEClass.getESuperTypes().add(this.getBehavior());
    guardEClass.getESuperTypes().add(this.getBehavior());
    internalInputEClass.getESuperTypes().add(this.getBehavior());
    internalOutputEClass.getESuperTypes().add(this.getBehavior());
    externalInputEClass.getESuperTypes().add(this.getBehavior());
    externalOutputEClass.getESuperTypes().add(this.getBehavior());
    assertionEClass.getESuperTypes().add(this.getBehavior());
    abstractBlockEClass.getESuperTypes().add(this.getAbstractBlockOrNode());
    nodeEClass.getESuperTypes().add(this.getAbstractNode());
    sequentialNodeEClass.getESuperTypes().add(this.getAbstractNode());
    sequentialNodeEClass.getESuperTypes().add(this.getAbstractBlockOrNode());
    atomicNodeEClass.getESuperTypes().add(this.getAbstractNode());
    atomicNodeEClass.getESuperTypes().add(this.getAbstractBlockOrNode());
    parallelBlockEClass.getESuperTypes().add(this.getAbstractBlock());
    alternativeBlockEClass.getESuperTypes().add(this.getAbstractBlock());

    // Initialize classes and features; add operations and parameters
    initEClass(textBTEClass, TextBT.class, "TextBT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTextBT_Options(), this.getOptionList(), null, "options", null, 0, 1, TextBT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTextBT_Requirements(), this.getRequirementList(), null, "requirements", null, 0, 1, TextBT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTextBT_Components(), this.getComponentList(), null, "components", null, 1, 1, TextBT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTextBT_BehaviorTree(), this.getBehaviorTree(), null, "behaviorTree", null, 1, 1, TextBT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementListEClass, RequirementList.class, "RequirementList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementList_Requirements(), this.getRequirement(), null, "requirements", null, 1, -1, RequirementList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRequirement_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_Val(), ecorePackage.getEString(), "val", null, 1, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentListEClass, ComponentList.class, "ComponentList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentList_Components(), this.getComponent(), null, "components", null, 1, -1, ComponentList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComponent_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Val(), ecorePackage.getEString(), "val", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponent_Behaviors(), this.getAbstractBehavior(), null, "behaviors", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Quantifier(), ecorePackage.getEString(), "quantifier", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(systemComponentEClass, SystemComponent.class, "SystemComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(optionListEClass, OptionList.class, "OptionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptionList_Options(), this.getOption(), null, "options", null, 0, -1, OptionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOption_Name(), ecorePackage.getEString(), "name", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOption_Value(), ecorePackage.getEString(), "value", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorTreeEClass, BehaviorTree.class, "BehaviorTree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorTree_RootNode(), this.getNode(), null, "rootNode", null, 1, 1, BehaviorTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractBehaviorEClass, AbstractBehavior.class, "AbstractBehavior", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(relationalBehaviorEClass, RelationalBehavior.class, "RelationalBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalBehavior_Behavior(), this.getBehavior(), null, "behavior", null, 1, 1, RelationalBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalBehavior_Relations(), this.getRelation(), null, "relations", null, 1, -1, RelationalBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRelation_Question(), ecorePackage.getEString(), "question", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_Preposition(), ecorePackage.getEString(), "preposition", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_ComponentRef(), ecorePackage.getEString(), "componentRef", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_BehaviorRef(), ecorePackage.getEString(), "behaviorRef", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_Level(), ecorePackage.getEString(), "level", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_ComponentLevel(), ecorePackage.getEString(), "componentLevel", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_ComponentSet(), ecorePackage.getEString(), "componentSet", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_Mci(), ecorePackage.getEString(), "mci", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorEClass, Behavior.class, "Behavior", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehavior_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehavior_Val(), ecorePackage.getEString(), "val", null, 1, 1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehavior_Relations(), this.getRelation(), null, "relations", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(selectionEClass, Selection.class, "Selection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(internalInputEClass, InternalInput.class, "InternalInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(internalOutputEClass, InternalOutput.class, "InternalOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(externalInputEClass, ExternalInput.class, "ExternalInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(externalOutputEClass, ExternalOutput.class, "ExternalOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractBlockOrNodeEClass, AbstractBlockOrNode.class, "AbstractBlockOrNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractBlockEClass, AbstractBlock.class, "AbstractBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractBlock_ChildNode(), this.getNode(), null, "childNode", null, 2, -1, AbstractBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractNodeEClass, AbstractNode.class, "AbstractNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractNode_ComponentRef(), ecorePackage.getEString(), "componentRef", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_BehaviorRef(), ecorePackage.getEString(), "behaviorRef", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_RequirementRef(), ecorePackage.getEString(), "requirementRef", null, 0, -1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_TraceabilityStatus(), this.getValidity(), "traceabilityStatus", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_Label(), ecorePackage.getEString(), "label", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_ComponentSet(), ecorePackage.getEString(), "componentSet", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractNode_Mci(), ecorePackage.getEString(), "mci", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNode_ChildNode(), this.getAbstractBlockOrNode(), null, "childNode", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequentialNodeEClass, SequentialNode.class, "SequentialNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequentialNode_ChildNode(), this.getAbstractBlockOrNode(), null, "childNode", null, 0, 1, SequentialNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicNodeEClass, AtomicNode.class, "AtomicNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicNode_ChildNode(), this.getAbstractBlockOrNode(), null, "childNode", null, 0, 1, AtomicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parallelBlockEClass, ParallelBlock.class, "ParallelBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(alternativeBlockEClass, AlternativeBlock.class, "AlternativeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(fiveWsEEnum, FiveWs.class, "FiveWs");
    addEEnumLiteral(fiveWsEEnum, FiveWs.WHO);
    addEEnumLiteral(fiveWsEEnum, FiveWs.WHAT);
    addEEnumLiteral(fiveWsEEnum, FiveWs.WHERE);
    addEEnumLiteral(fiveWsEEnum, FiveWs.WHEN);
    addEEnumLiteral(fiveWsEEnum, FiveWs.WHY);
    addEEnumLiteral(fiveWsEEnum, FiveWs.HOW);

    initEEnum(validityEEnum, Validity.class, "Validity");
    addEEnumLiteral(validityEEnum, Validity.VALID);
    addEEnumLiteral(validityEEnum, Validity.IMPLIED);
    addEEnumLiteral(validityEEnum, Validity.INVALID);
    addEEnumLiteral(validityEEnum, Validity.DELETED);
    addEEnumLiteral(validityEEnum, Validity.REFINED);
    addEEnumLiteral(validityEEnum, Validity.UPDATED);

    // Create resource
    createResource(eNS_URI);
  }

} //TextbtPackageImpl
