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
	private Composite container2;
	private HashMap<Integer,String> map;
	private Diagram d;
	private String componentRefTemp;
	private String behaviorRefTemp;


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

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		Button componentButton = new Button(container, SWT.NULL);
		componentButton.setText("Add New Component");

		Button behaviorButton = new Button(container, SWT.NULL);
		behaviorButton.setText("Add New Behavior");

		Button editComponentButton = new Button(container, SWT.NULL);
		editComponentButton .setText("Edit Component");

		Button editBehaviorButton = new Button(container, SWT.NULL);
		editBehaviorButton .setText("Edit Behavior");

		final Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("List of Components:");

		Label behaviourLabel = new Label(container, SWT.NULL);
		behaviourLabel.setText("List of Behaviours:");

		final List listComponents = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		//listComponents.setBounds(100, 100, 400, 300);
		listComponents.setSize(500, 500);
		
		for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
			listComponents.add(component.getComponentName());
		}

		final List listBehaviours = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		//listBehaviours.setBounds(100, 100, 220, 100);

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
				listBehaviours.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviours.add(behavior.toString());
				}
			}

		});

		final Label editComponentLabel = new Label(container, SWT.NULL);
		editComponentLabel.setText("Component Name");
		editComponentLabel.setVisible(false);

		final Text editcomponentNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		editcomponentNameText.setVisible(false);		

		final Text componentRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentRefText.setVisible(false);

		final Button saveComponentButton = new Button(container, SWT.NULL);
		saveComponentButton.setText("Save");
		saveComponentButton.setVisible(false);

		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				map.put(StandardNode.COMPONENT_VALUE, selected );
				listBehaviours.removeAll();
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
				if(c!=null)
					for(Behavior behavior: c.getBehaviors()){
						listBehaviours.add(behavior.toString());
					}
				editcomponentNameText.setText(c.getComponentName());
				componentRefTemp = c.getComponentRef();
				System.out.println("test awal= " + componentRefTemp);
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
						c.setComponentName(editcomponentNameText.getText());

					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);


				editComponentLabel.setVisible(false);
				editcomponentNameText.setVisible(false);
				saveComponentButton.setVisible(false);


				listComponents.removeAll();
				listBehaviours.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}

			}
		});

		editComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);


				editcomponentNameText.setText(c.getComponentName());
				componentRefText.setText(c.getComponentRef());

				editComponentLabel.setVisible(true);
				editcomponentNameText.setVisible(true);
				saveComponentButton.setVisible(true);
			}

		});

		final Label editBehaviorLabel = new Label(container, SWT.NULL);
		editBehaviorLabel.setText("Behavior Name");
		editBehaviorLabel.setVisible(false);

		final Text editBehaviorNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		editBehaviorNameText.setVisible(false);		

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("Behavior Type");
		typeLabel.setVisible(false);

		final Combo typeCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		typeCombo.setVisible(false);
		
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

		final Button saveBehaviorButton = new Button(container, SWT.NULL);
		saveBehaviorButton.setText("Save");
		saveBehaviorButton.setVisible(false);

		final Text behaviorRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorRefText.setVisible(false);

		listBehaviours.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listBehaviours.getItem(listBehaviours.getSelectionIndex());
				//map.put(StandardNode.STANDARDNODE_COMPONENT, selected );

				System.out.println("komponen = " + componentRefTemp);
				
				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selected);

				//editcomponentNameText.setText(c.getComponentName());
				behaviorRefTemp = b.getBehaviorRef();
				//System.out.println("komponen = " + componentRefTemp);
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

				typeLabel.setVisible(false);
				typeCombo.setVisible(false);
				editBehaviorLabel.setVisible(false);
				editBehaviorNameText.setVisible(false);
				saveBehaviorButton.setVisible(false);


				listBehaviours.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviours.add(behavior.toString());
				}
			}
		});

		editBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				
				Behavior b = GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefTemp);				
				System.out.println("behavior temp: " + behaviorRefTemp);
				System.out.println("Component temp: " + componentRefTemp);
				
				editBehaviorNameText.setText(b.getBehaviorName());
				typeCombo.setText(b.getBehaviorType().getName());

				typeLabel.setVisible(true);
				typeCombo.setVisible(true);
				editBehaviorLabel.setVisible(true);
				editBehaviorNameText.setVisible(true);
				saveBehaviorButton.setVisible(true);
				
			}

		});

		setControl(container);
	}
}