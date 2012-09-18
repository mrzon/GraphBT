package behaviortree.graphBT.wizards.managecomponents;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;

/**
 * Class to define the contents of manage component wizard
 * @author GraphBT Team
 *
 */
public class ManageComponentsFirstPageGraphBTWizard extends WizardPage {

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private String componentRefTemp;
	private String behaviorRefTemp;
	private Text editComponentNameText;
	private Button behaviorButton;
	private Button saveComponentButton;
//<<<<<<< HEAD
	private Button checkButton;
//=======
//>>>>>>> refs/remotes/origin/master3wizard
	private Text editBehaviorNameText; 
	private Text editComponentDescText;
	private Text componentDescText;
	private Text behaviorDescText;
	private Text editBehaviorDescText;
	
	private Combo typeCombo;
	private int index;
	private Button saveBehaviorButton;
	private Button cancelEditBehaviorButton;
	private Button cancelEditComponentButton;

	public ManageComponentsFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Manage Components Wizard");
		setTitle("Manage Components Wizard");
		setDescription("Manage components for the Behavior Tree.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(4, false);
		container.setLayout(layout);
		GridData gridData;
		
		final Label listRequirementLabel = new Label(container, SWT.NULL);
		listRequirementLabel.setText("List Components:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		listRequirementLabel.setLayoutData(gridData);
		

		final Label listBehaviorLabel = new Label(container, SWT.NULL);
		listBehaviorLabel .setText("List Behavior:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		listBehaviorLabel.setLayoutData(gridData);
		
		
		final List listComponents = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;		
		listComponents.setLayoutData(gridData);
		
		for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
			listComponents.add(component.getComponentName());
		}		
		
		Button componentButton = new Button(container, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;
		
		componentButton.setLayoutData(gridData);
		componentButton.setText("+");
		
		final List listBehaviors = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		
		listBehaviors.setLayoutData(gridData);
		
		behaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);		
		behaviorButton.setLayoutData(gridData);
		behaviorButton.setText("+");
		behaviorButton.setEnabled(false);
		
		Button deleteComponentButton = new Button(container, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;
		//gridData.grabExcessHorizontalSpace = true;	
		deleteComponentButton.setLayoutData(gridData);
		deleteComponentButton.setText("-");
		
		Button deleteBehaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		deleteBehaviorButton.setLayoutData(gridData);
		deleteBehaviorButton.setText("-");		
		
		Button editComponentButton = new Button(container, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;	
		gridData.verticalAlignment = GridData.BEGINNING;
		editComponentButton.setLayoutData(gridData);
		editComponentButton .setText("Edit");		
		
		Button editBehaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData();
		//gridData.grabExcessHorizontalSpace = true;	
		gridData.verticalAlignment = GridData.BEGINNING;
		editBehaviorButton.setLayoutData(gridData);
		editBehaviorButton.setText("Edit");

		
		/*
		 * Group Details Component
		 */
		final Group group = new Group(container, SWT.SHADOW_ETCHED_IN);
		group.setText("Details Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		//gridData.grabExcessHorizontalSpace = true;
		group.setLayoutData(gridData);
		GridLayout groupLayout = new GridLayout(1, false);
		group.setLayout(groupLayout);
		
		/*
		 * Inside Group Component
		 */
		final Label cNameLabel = new Label(group, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		cNameLabel.setLayoutData(gridData);		
		cNameLabel.setText("");
		
		final Label cRefLabel = new Label(group, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		cRefLabel.setLayoutData(gridData);		
		cRefLabel.setText("");
		
		final Label descComponentLabel = new Label(group, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		descComponentLabel.setLayoutData(gridData);	
		descComponentLabel.setText("Description:");
		descComponentLabel.setVisible(false);
		
		componentDescText = new Text(group, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		componentDescText.setLayoutData(gridData);
		componentDescText.setEditable(false);
		componentDescText.setVisible(false);
		
		
		/*
		 * Group Details Behavior
		 */
		final Group groupBehavior = new Group(container, SWT.SHADOW_ETCHED_IN);
		groupBehavior.setText("Details Behaviors");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 70;
		gridData.widthHint = 200;
		groupBehavior.setLayoutData(gridData);
		groupBehavior.setVisible(false);
		GridLayout groupBehaviorLayout = new GridLayout(1, false);
		groupBehavior.setLayout(groupBehaviorLayout);
		
		/*
		 * Inside Group Behavior
		 */
		final Label bNameLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bNameLabel.setLayoutData(gridData);		
		bNameLabel.setText("");
		
		final Label bRefLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bRefLabel.setLayoutData(gridData);		
		bRefLabel.setText("");
		
		final Label bTypeLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		bTypeLabel.setLayoutData(gridData);		
		bTypeLabel.setText("");
		
		final Label descBehaviorLabel = new Label(groupBehavior, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		descBehaviorLabel.setLayoutData(gridData);	
		descBehaviorLabel.setText("Description:");
		descBehaviorLabel.setVisible(false);
		
		behaviorDescText = new Text(groupBehavior, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		behaviorDescText.setLayoutData(gridData);
		behaviorDescText.setEditable(false);
		behaviorDescText.setVisible(false);
		
		/*
		 * Group Details Edit Component
		 */
		final Group editComponentGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
		editComponentGroup.setText("Edit Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 130;
		gridData.widthHint = 200;
		editComponentGroup.setLayoutData(gridData);
		GridLayout groupLayoutEditComponent = new GridLayout(2, false);
		editComponentGroup.setLayout(groupLayoutEditComponent);
		editComponentGroup.setVisible(false);
		
		/*
		 * Group Details Edit Behavior
		 */
		final Group editBehaviorGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
		editBehaviorGroup.setText("Edit Behavior");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		editBehaviorGroup.setLayoutData(gridData);
		GridLayout groupLayoutEditBehavior = new GridLayout(2, false);
		editBehaviorGroup.setLayout(groupLayoutEditBehavior );
		editBehaviorGroup.setVisible(false);
		
		/*
		 * Inside Group Edit Component
		 */		
		final Label editComponentLabel = new Label(editComponentGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		editComponentLabel.setLayoutData(gridData);	
		editComponentLabel.setText("Name:");
		editComponentLabel.setVisible(false);

		editComponentNameText = new Text(editComponentGroup, SWT.BORDER | SWT.SINGLE);
		editComponentNameText.setVisible(false);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		editComponentNameText.setLayoutData(gridData);	
		editComponentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});		
		
		final Label editDescComponentLabel = new Label(editComponentGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		editDescComponentLabel.setLayoutData(gridData);	
		editDescComponentLabel.setText("Description:");
		editDescComponentLabel.setVisible(false);
		
		editComponentDescText = new Text(editComponentGroup, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		editComponentDescText.setLayoutData(gridData);		
		editComponentDescText.setVisible(false);
		
//<<<<<<< HEAD
		checkButton = new Button(editComponentGroup, SWT.CHECK);
		checkButton.setText("Enumerate");
		checkButton.setVisible(false);

		checkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Called!" + checkButton.getSelection());
			}
		}); 
		
		final Label editAdditionalLabel = new Label(editComponentGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		editAdditionalLabel.setLayoutData(gridData);	
		editAdditionalLabel.setText("");
		editAdditionalLabel.setVisible(false);
//=======
		
		
		saveComponentButton = new Button(editComponentGroup, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		//gridData.horizontalAlignment = GridData.END;
		saveComponentButton.setLayoutData(gridData);
		saveComponentButton.setText("Save");
		saveComponentButton.setVisible(false);
		
		cancelEditComponentButton = new Button(editComponentGroup,SWT.NULL);
		cancelEditComponentButton.setText("Cancel");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		//gridData.horizontalAlignment = GridData.END;
		cancelEditComponentButton.setLayoutData(gridData);
		cancelEditComponentButton.setVisible(false);
		
		final Text componentRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentRefText.setVisible(false);

		editComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
			
				editComponentNameText.setText(c.getComponentName());
				componentRefText.setText(c.getComponentRef());
				editComponentDescText.setText(c.getComponentDesc());
				
				editComponentGroup.setVisible(true);				
				editComponentLabel.setVisible(true);
				editComponentNameText.setVisible(true);
				editDescComponentLabel.setVisible(true);
				editComponentDescText.setVisible(true);
				saveComponentButton.setVisible(true);
				cancelEditComponentButton.setVisible(true);
				editBehaviorGroup.setVisible(false);
				checkButton.setVisible(true);
			}

		});
		
		deleteComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete component", "Are you sure you want to delete component? It may affect your current design..");
				if(!delete)
					return;
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Component") {
					protected void doExecute() {
						GraphBTUtil.removeComponentByRef(be, componentRefTemp);
					}
				};

				ds.getEditingDomain().getCommandStack().execute(cmd);
				editComponentGroup.setVisible(false);
				editComponentLabel.setVisible(false);
				editComponentNameText.setVisible(false);
				editDescComponentLabel.setVisible(false);
				editComponentDescText.setVisible(false);

				cNameLabel.setVisible(false);
				cRefLabel.setVisible(false);
				descComponentLabel.setVisible(false);
				componentDescText.setVisible(false);
				
				listComponents.removeAll();
				listBehaviors.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}
			}
		});
		
		/*
		 * Action List
		 */
		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				System.out.println("awal= " + index);
				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				index = listComponents.getSelectionIndex();
				System.out.println("index= " + index);
				map.put(StandardNode.COMPONENT_VALUE, selected );
				listBehaviors.removeAll();
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
				if(c!=null) {
					for(Behavior behavior: c.getBehaviors()){
						listBehaviors.add(behavior.toString());
					}
					
					group.setVisible(true);
					groupBehavior.setVisible(false);
					editBehaviorGroup.setVisible(false);
					editComponentGroup.setVisible(false);
					cNameLabel.setVisible(true);
					cNameLabel.setText("Name: " + c.getComponentName());
					cRefLabel.setVisible(true);
					cRefLabel.setText("Reference: " +c.getComponentRef());
					descComponentLabel.setVisible(true);
					componentDescText.setVisible(true);
					componentDescText.setText(c.getComponentDesc());
					behaviorButton.setEnabled(true);
					
				}
				
				//editComponentNameText.setText(c.getComponentName());
				componentRefTemp = c.getComponentRef();
				System.out.println("test awal= " + componentRefTemp);
			}
		});
		
		listBehaviors.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listBehaviors.getItem(listBehaviors.getSelectionIndex());
				//map.put(StandardNode.STANDARDNODE_COMPONENT, selected );

				System.out.println("komponen = " + componentRefTemp);
				
				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selected);

				if(b != null) {
				//editcomponentNameText.setText(c.getComponentName());
					groupBehavior.setVisible(true);
					bNameLabel.setVisible(true);
					bNameLabel.setText("Name: " + b.getBehaviorName());
					bRefLabel.setVisible(true);
					bRefLabel.setText("Reference: " + b.getBehaviorRef());
					bTypeLabel.setVisible(true);
					bTypeLabel.setText("Type: " + b.getBehaviorType().getName());
					descBehaviorLabel.setVisible(true);
					behaviorDescText.setVisible(true);
					behaviorDescText.setText(b.getBehaviorDesc());
				}
				behaviorRefTemp = b.getBehaviorRef();
				//System.out.println("komponen = " + componentRefTemp);
			}
		});
		
		componentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateComponentGraphBTWizard(map, d));				
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				listComponents.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}
			}
		});

		behaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String str = map.get(StandardNode.COMPONENT_VALUE);
				if(str == null || str.equals(""))
				{
					MessageDialog.openError(null, "Error Create Behavior", "Select existing component before adding behavior!"+map.get(StandardNode.COMPONENT_VALUE));
					return;
				}
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), map.get(StandardNode.COMPONENT_VALUE));
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateBehaviorGraphBTWizard(c));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
			}
		});
		
		saveComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);


				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						c.setComponentName(editComponentNameText.getText());
						c.setComponentDesc(editComponentDescText.getText());
						cNameLabel.setText("Name: " + editComponentNameText.getText());
					}
				};

				ds.getEditingDomain().getCommandStack().execute(cmd);
				//listComponents.setSelection(0);
				editComponentGroup.setVisible(false);
				editComponentLabel.setVisible(false);
				editComponentNameText.setVisible(false);
				saveComponentButton.setVisible(false);				
				group.setVisible(false);
				
				listComponents.removeAll();
				listBehaviors.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}
			}
		});
		
		/*
		 * Inside Group Edit Behavior
		 */
		final Label editBehaviorLabel = new Label(editBehaviorGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		editBehaviorLabel.setLayoutData(gridData);
		editBehaviorLabel.setText("Name:");
		editBehaviorLabel.setVisible(false);

		editBehaviorNameText = new Text(editBehaviorGroup, SWT.BORDER | SWT.SINGLE);
		editBehaviorNameText.setVisible(false);	
		editBehaviorNameText.setVisible(false);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		editBehaviorNameText.setLayoutData(gridData);	
		editBehaviorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChangedBehavior();
			}
		});
		
		final Label typeLabel = new Label(editBehaviorGroup, SWT.NULL);
		typeLabel.setText("Type:");
		gridData = new GridData();		
		gridData.horizontalSpan = 1;		
		typeLabel.setLayoutData(gridData);
		typeLabel.setVisible(false);

		typeCombo = new Combo(editBehaviorGroup, SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;		
		typeCombo.setLayoutData(gridData);
		typeCombo.setVisible(false);
		typeCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChangedBehavior();
			}
		});
		
		for(BehaviorType t : BehaviorType.VALUES) {
			typeCombo.add(t.getName());
		}
		typeCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Combo combo = (Combo)e.widget;
				String selected = combo.getItem(combo.getSelectionIndex());

				map.put(Behavior.TYPE_VALUE, selected);
			}
		});

		final Label editDescBehaviorLabel = new Label(editBehaviorGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		editDescBehaviorLabel.setLayoutData(gridData);
		editDescBehaviorLabel.setText("Description:");
		editDescBehaviorLabel.setVisible(false);

		editBehaviorDescText = new Text(editBehaviorGroup, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		editBehaviorDescText.setLayoutData(gridData);
		editBehaviorDescText.setVisible(false);
						
		
		final Button saveBehaviorButton = new Button(editBehaviorGroup, SWT.NULL);
		saveBehaviorButton.setText("Save");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		//gridData.horizontalAlignment = GridData.END;		
		saveBehaviorButton.setLayoutData(gridData);
		saveBehaviorButton.setVisible(false);
		
		cancelEditBehaviorButton = new Button(editBehaviorGroup,SWT.NULL);
		cancelEditBehaviorButton.setText("Cancel");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		//gridData.horizontalAlignment = GridData.END;
		cancelEditBehaviorButton.setLayoutData(gridData);
		cancelEditBehaviorButton.setVisible(false);
		
		final Text behaviorRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorRefText.setVisible(false);
		
		editBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				
				Behavior b = GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefTemp);				
				System.out.println("behavior temp: " + behaviorRefTemp);
				System.out.println("Component temp: " + componentRefTemp);
				
				editBehaviorNameText.setText(b.getBehaviorName());
				typeCombo.setText(b.getBehaviorType().getName());
				editBehaviorDescText.setText(b.getBehaviorDesc());
				
				editBehaviorGroup.setVisible(true);
				typeLabel.setVisible(true);
				typeCombo.setVisible(true);
				editBehaviorLabel.setVisible(true);
				editBehaviorNameText.setVisible(true);
				editBehaviorDescText.setVisible(true);
				editDescBehaviorLabel.setVisible(true);
				saveBehaviorButton.setVisible(true);
				cancelEditBehaviorButton.setVisible(true);
			}
		});
		
		deleteBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete behavior", "Are you sure you want to delete the behavior? It may affect your current design..");
				if(!delete)
					return;
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				final Behavior b = GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefTemp);

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						GraphBTUtil.removeBehaviorFromComponentByRef(c, behaviorRefTemp);
					}
				};

				ds.getEditingDomain().getCommandStack().execute(cmd);
				editBehaviorGroup.setVisible(false);
				typeLabel.setVisible(false);
				typeCombo.setVisible(false);
				editBehaviorLabel.setVisible(false);
				editBehaviorNameText.setVisible(false);
				
				bNameLabel.setVisible(false);
				bRefLabel.setVisible(false);
				bTypeLabel.setVisible(false);
				descBehaviorLabel.setVisible(false);
				behaviorDescText.setVisible(false);
				
				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
			}
		});
		
		saveBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor)
				{
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else
				{
					ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				final Behavior b = GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefTemp);

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						b.setBehaviorName(editBehaviorNameText.getText());
						b.setBehaviorType(BehaviorType.getByName(typeCombo.getItem(typeCombo.getSelectionIndex())));
						b.setBehaviorDesc(editBehaviorDescText.getText());
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				editBehaviorGroup.setVisible(false);
				typeLabel.setVisible(false);
				typeCombo.setVisible(false);
				editBehaviorLabel.setVisible(false);
				editBehaviorNameText.setVisible(false);
				saveBehaviorButton.setVisible(false);
				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
				
				groupBehavior.setVisible(false);
			}
		});
		
		cancelEditComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				editComponentGroup.setVisible(false);
				editComponentLabel.setVisible(false);
				editComponentNameText.setVisible(false);
				saveComponentButton.setVisible(false);
				cancelEditComponentButton.setVisible(false);
			}
		});
		
		cancelEditBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				editBehaviorGroup.setVisible(false);
				typeLabel.setVisible(false);
				typeCombo.setVisible(false);
				editBehaviorLabel.setVisible(false);
				editBehaviorNameText.setVisible(false);
				saveBehaviorButton.setVisible(false);
				cancelEditBehaviorButton.setVisible(false);
			}
		});
		
		setControl(container);
	}
	
	private void dialogChanged() {
		
		if (editComponentNameText.getText().length() == 0) {
			updateStatus("Component name must be specified");
			saveComponentButton.setEnabled(false);
			return;
		}	

		
			updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);		
		
		if (message == null)
		{
			saveComponentButton.setEnabled(true);
		}
			
	}
	
	private void dialogChangedBehavior() {
		
		if (typeCombo.getText().length() == 0) {
			updateStatus("Behavior type must be specified");
			return;
		}
		
		if (editBehaviorNameText.getText().length() == 0) {
			updateStatusBehavior("Behavior name must be specified");
			saveBehaviorButton.setEnabled(false);
			return;
		}	

		
			updateStatus(null);
	}
	
	private void updateStatusBehavior(String message) {
		setErrorMessage(message);		
		
		if (message == null)
		{
			saveBehaviorButton.setEnabled(true);
		}
			
	}
}
