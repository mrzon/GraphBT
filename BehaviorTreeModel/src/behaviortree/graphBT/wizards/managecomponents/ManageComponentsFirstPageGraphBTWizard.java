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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;


public class ManageComponentsFirstPageGraphBTWizard extends WizardPage {

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private String componentRefTemp;
	private String behaviorRefTemp;
	private Text editComponentNameText;
	private Button saveComponentButton;
	private Text editBehaviorNameText;
	private Combo typeCombo;
	private int index;
	private Button saveBehaviorButton;

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
		gridData.heightHint = 200;
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
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		
		listBehaviors.setLayoutData(gridData);
		
		Button behaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);		
		behaviorButton.setLayoutData(gridData);
		behaviorButton.setText("+");				
		
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
		gridData.heightHint = 70;
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
		
		/*
		 * Action List
		 */
		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				index = listComponents.getSelectionIndex();
				System.out.println("index= " + index);
				map.put(StandardNode.COMPONENT_VALUE, selected );
				listBehaviors.removeAll();
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
				if(c!=null)
					for(Behavior behavior: c.getBehaviors()){
						listBehaviors.add(behavior.toString());
					}
				
				cNameLabel.setText("Name: " + c.getComponentName());
				cRefLabel.setText("Reference: " +c.getComponentRef());
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

				//editcomponentNameText.setText(c.getComponentName());
				bNameLabel.setText("Name: " + b.getBehaviorName());
				bRefLabel.setText("Reference: " + b.getBehaviorRef());
				bTypeLabel.setText("Type: " + b.getBehaviorType().getName());
				
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
		
		/*
		 * Group Details Edit Component
		 */
		final Group editComponentGroup = new Group(container, SWT.SHADOW_ETCHED_IN);
		editComponentGroup.setText("Edit Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 70;
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
		gridData.heightHint = 90;
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
		
		saveComponentButton = new Button(editComponentGroup, SWT.NULL);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		gridData.horizontalAlignment = GridData.END;
		saveComponentButton.setLayoutData(gridData);
		saveComponentButton.setText("Save");
		saveComponentButton.setVisible(false);
		
		final Text componentRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentRefText.setVisible(false);

		editComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);


				editComponentNameText.setText(c.getComponentName());
				componentRefText.setText(c.getComponentRef());
				
				editComponentGroup.setVisible(true);				
				editComponentLabel.setVisible(true);
				editComponentNameText.setVisible(true);
				saveComponentButton.setVisible(true);
			}

		});
		
		saveComponentButton.addSelectionListener(new SelectionAdapter() {
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


				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						c.setComponentName(editComponentNameText.getText());
						cNameLabel.setText("Name: " + editComponentNameText.getText());
					}
				};

				ds.getEditingDomain().getCommandStack().execute(cmd);
				//listComponents.setSelection(0);
				editComponentGroup.setVisible(false);
				editComponentLabel.setVisible(false);
				editComponentNameText.setVisible(false);
				saveComponentButton.setVisible(false);				
				
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

		final Button saveBehaviorButton = new Button(editBehaviorGroup, SWT.NULL);
		saveBehaviorButton.setText("Save");
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		gridData.horizontalAlignment = GridData.END;
		saveBehaviorButton.setLayoutData(gridData);
		saveBehaviorButton.setVisible(false);

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

				editBehaviorGroup.setVisible(true);
				typeLabel.setVisible(true);
				typeCombo.setVisible(true);
				editBehaviorLabel.setVisible(true);
				editBehaviorNameText.setVisible(true);
				saveBehaviorButton.setVisible(true);
				
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
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				editBehaviorGroup.setVisible(false);
				typeLabel.setVisible(false);
				typeCombo.setVisible(false);
				editBehaviorLabel.setVisible(false);
				editBehaviorNameText.setVisible(false);
				saveBehaviorButton.setVisible(false);
				bNameLabel.setText("Name: " + b.getBehaviorName());
				bRefLabel.setText("Reference: " + b.getBehaviorRef());
				bTypeLabel.setText("Type: " + b.getBehaviorType().getName());

				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
			}
		});

		/*
		

		

		

		

		
		
		

		
		

		
*/
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