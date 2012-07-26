package behaviortree.graphBT.wizards.managecomponents;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
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
import org.eclipse.ui.PlatformUI;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;


public class ManageComponentsFirstPageGraphBTWizard extends WizardPage {

	private Composite container;
	private Composite container2;
	private HashMap<Integer,String> map;
	private Diagram d;


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
		listComponents.setBounds(20, 20, 220, 100);

		for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
			listComponents.add(component.getComponentName());
		}

		final List listBehaviours = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		listBehaviours.setBounds(20, 20, 220, 100);

		

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
				String str = map.get(StandardNode.STANDARDNODE_COMPONENT);
				if(str == null || str.equals(""))
				{
					MessageDialog.openError(null, "Error Create Behavior", "Select existing component before adding behavior!"+map.get(StandardNode.STANDARDNODE_COMPONENT));
					return;
				}
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), map.get(StandardNode.STANDARDNODE_COMPONENT));
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
		
		/*	container2 = new Composite(parent, SWT.NULL);		

			GridLayout layout2 = new GridLayout();
			container2.setLayout(layout2);
			layout2.numColumns = 2;*/
		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				map.put(StandardNode.STANDARDNODE_COMPONENT, selected );
				listBehaviours.removeAll();
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
				if(c!=null)
					for(Behavior behavior: c.getBehaviors()){
						listBehaviours.add(behavior.toString());
					}
				editcomponentNameText.setText(c.getComponentName());
				componentRefText.setText(c.getComponentRef());

			}
		});
		saveComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefText.getText());


				c.setComponentName(editcomponentNameText.getText());
				
				editcomponentNameText.setVisible(false);
				saveComponentButton.setVisible(false);
								

				listComponents.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}
			}
		});
		
		editComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), map.get(StandardNode.STANDARDNODE_COMPONENT));


				editcomponentNameText.setText(c.getComponentName());
				componentRefText.setText(c.getComponentRef());

				editcomponentNameText.setVisible(true);
				saveComponentButton.setVisible(true);
				/*editcomponentNameText.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text t= (Text) e.widget;
							map.put(Component.COMPONENT_NAME, t.getText());
						}
				    });

					editcomponentNameText.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text t= (Text) e.widget;
							map.put(Component.COMPONENT_REF, t.getText());
						}
				    });*/

				
			}

		});
		setControl(container);
	}
}