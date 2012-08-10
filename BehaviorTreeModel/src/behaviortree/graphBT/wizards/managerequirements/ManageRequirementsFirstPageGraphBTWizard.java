package behaviortree.graphBT.wizards.managerequirements;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
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
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.createrequirement.CreateRequirementGraphBTWizard;


public class ManageRequirementsFirstPageGraphBTWizard extends WizardPage {

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;


	public ManageRequirementsFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Manage Requirement Wizard");
		setTitle("Manage Requirement Wizard");
		setDescription("Manage the requirement elements.");		
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(4, false);
		container.setLayout(layout);
		GridData gridData;

		Button createRequirementButton = new Button(container, SWT.NULL);
		createRequirementButton.setText("Add New Requirement");
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		createRequirementButton.setLayoutData(gridData);

		final Label listRequirementLabel = new Label(container, SWT.NULL);
		listRequirementLabel.setText("List Requirements:");
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		listRequirementLabel.setLayoutData(gridData);

		/*
		 * List Requirements
		 */
		final List listRequirements = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;		
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		gridData.grabExcessVerticalSpace = true;
		listRequirements.setLayoutData(gridData);

		listRequirements.removeAll();		
		for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
			listRequirements.add(requirement.getKey());
		}	

		/*
		 * Group
		 */
		final Group group = new Group(container, SWT.SHADOW_ETCHED_IN);
		group.setText("Details");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.minimumHeight = 200;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		group.setLayoutData(gridData);
		GridLayout groupLayout = new GridLayout(1, false);
		group.setLayout(groupLayout);
		
		/*
		 * Inside Group
		 */
		final Label nameLabel = new Label(group, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		nameLabel.setLayoutData(gridData);		
		nameLabel.setText("");

		final Label descLabel = new Label(group, SWT.NULL);		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 1;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.BEGINNING;
		descLabel.setLayoutData(gridData);
		descLabel.setText("");

		final Button editRequirementButton = new Button(group, SWT.NULL);
		editRequirementButton.setText("Edit Requirement");
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = GridData.END;
		gridData.verticalAlignment = GridData.END;
		editRequirementButton.setLayoutData(gridData);
		editRequirementButton.setVisible(false);


		/*
		 * Edit Label
		 */
		final Group editLabel = new Group(container, SWT.SHADOW_ETCHED_IN);		
		editLabel.setText("Edit Requirement");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );		
		gridData.grabExcessVerticalSpace = true;	
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 4;
		editLabel.setLayoutData(gridData);
		
		GridLayout groupLayoutEdit = new GridLayout(4, false);
		editLabel.setLayout(groupLayoutEdit);
		editLabel.setVisible(false);

		final Label editRequirementLabel = new Label(editLabel, SWT.NULL);
		editRequirementLabel.setText("Name:");
		editRequirementLabel.setVisible(false);

		final Text editRequirementNameText = new Text(editLabel, SWT.BORDER | SWT.SINGLE);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		editRequirementNameText.setLayoutData(gridData);
		editRequirementNameText.setVisible(false);

		final Label editRequirementDescLabel = new Label(editLabel, SWT.NULL);
		editRequirementDescLabel.setText("Description:");
		editRequirementDescLabel.setVisible(false);

		final Text editRequirementDescText = new Text(editLabel, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		gridData.minimumHeight = 100;
		gridData.grabExcessVerticalSpace = true;
		editRequirementDescText.setLayoutData(gridData);
		editRequirementDescText.setVisible(false);		

		final Button saveRequirementButton = new Button(editLabel, SWT.NULL);
		saveRequirementButton.setText("Save");
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		gridData.horizontalAlignment = GridData.END;
		saveRequirementButton.setLayoutData(gridData);
		saveRequirementButton.setVisible(false);				

		/*
		 * Action
		 */
		createRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateRequirementGraphBTWizard(map, d));

				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				listRequirements.removeAll();
				for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
					listRequirements.add(requirement.getKey());
				}
			}

		});

		final Text requirementRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		requirementRefText.setVisible(false);

		listRequirements.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listRequirements.getItem(listRequirements.getSelectionIndex());
				map.put(Requirement.REQUIREMENT_KEY, selected );

				Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(d), selected);

				nameLabel.setText(r.getKey() + " " + r.getRequirement());
				descLabel.setText(r.getDescription());
				editRequirementNameText.setText(r.getRequirement());
				requirementRefText.setText(r.getKey());
				editRequirementDescText.setText(r.getDescription());
				editRequirementButton.setVisible(true);
			}
		});

		saveRequirementButton.addSelectionListener(new SelectionAdapter() {
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
				final Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(d), requirementRefText.getText());


				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						//System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
						r.setRequirement(editRequirementNameText.getText());
						r.setDescription(editRequirementDescText.getText());		
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				editLabel.setVisible(false);
				saveRequirementButton.setVisible(false);
				editRequirementLabel.setVisible(false);
				editRequirementDescLabel.setVisible(false);
				editRequirementNameText.setVisible(false);
				editRequirementDescText.setVisible(false);
				nameLabel.setText(r.getKey() + " " + r.getRequirement());
				descLabel.setText(r.getDescription());
				group.setVisible(true);
			

				/*listRequirements.removeAll();
				for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
					listRequirements.add(requirement.getKey());
				}*/


			}
		});

		editRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(d), requirementRefText.getText());

				editRequirementNameText.setText(r.getRequirement());
				requirementRefText.setText(r.getKey());
				editRequirementDescText.setText(r.getDescription());

				saveRequirementButton.setVisible(true);
				editRequirementLabel.setVisible(true);
				editRequirementDescLabel.setVisible(true);
				editRequirementNameText.setVisible(true);
				editRequirementDescText.setVisible(true);
				editLabel.setVisible(true);
				group.setVisible(false);

				editRequirementNameText.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						Text t= (Text) e.widget;
						map.put(Requirement.REQUIREMENT_NAME, t.getText());
					}
				});

				editRequirementDescText.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						Text t= (Text) e.widget;
						map.put(Requirement.REQUIREMENT_DESC, t.getText());
					}
				});			
			}

		});

		setControl(container);
	}
}