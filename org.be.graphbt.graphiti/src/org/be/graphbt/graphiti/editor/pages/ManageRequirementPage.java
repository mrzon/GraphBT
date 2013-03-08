package org.be.graphbt.graphiti.editor.pages;

import java.util.HashMap;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.graphiti.wizards.createrequirement.CreateRequirementGraphBTWizard;
import org.be.graphbt.graphiti.wizards.requirementCompactView.RequirementCompactViewGraphBTWizard;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Requirement;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class ManageRequirementPage extends Composite{
	private HashMap<Integer,String> map;
	private Diagram d;
	private Text requirementNameText;
	private Text requirementRefText;
	private Text requirementDescText;
	Composite parent;
	public ManageRequirementPage(Composite parent, int style, Diagram d, HashMap<Integer, String> map) {
		super(parent, style);
		this.d = d;
		this.map = map;
		this.init();
		this.parent = parent;
		// TODO Auto-generated constructor stub
	}
	public void init() {
		GridLayout layout = new GridLayout(4, false);
		this.setLayout(layout);
		GridData gridData;

		Button createRequirementButton = new Button(this, SWT.NULL);
		createRequirementButton.setText("Add New Requirement");
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		createRequirementButton.setLayoutData(gridData);
		
//		Button removeRequirementButton = new Button(this, SWT.NULL);
//		removeRequirementButton.setText("Remove Requirement");
//		gridData = new GridData();
//		gridData.horizontalSpan = 4;
//		removeRequirementButton.setLayoutData(gridData);

		final Label listRequirementLabel = new Label(this, SWT.NULL);
		listRequirementLabel.setText("List Requirements:");
		gridData = new GridData();
		gridData.horizontalSpan = 4;
		listRequirementLabel.setLayoutData(gridData);

		/*
		 * List Requirements
		 */
		final List listRequirements = new List(this, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;		
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		gridData.grabExcessVerticalSpace = true;
		listRequirements.setLayoutData(gridData);

		listRequirements.removeAll();		
		for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
			listRequirements.add(requirement.getKey());
		}	

		/*
		 * Group
		 */
		final Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
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


		
		final Text descLabel = new Text(group, SWT.WRAP
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
		descLabel.setLayoutData(gridData);
		descLabel.setEditable(false);
		descLabel.setVisible(false);
		
		
		final Group innerGroup = new Group(group, SWT.SHADOW_ETCHED_IN);
		innerGroup.setText("");
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		innerGroup.setLayoutData(gridData);
		GridLayout innerGroupLayout = new GridLayout(2, false);
		innerGroup.setLayout(innerGroupLayout);
		
		final Button editRequirementButton = new Button(innerGroup, SWT.NULL);
		editRequirementButton.setText("Edit Requirement");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = GridData.END;
		editRequirementButton.setLayoutData(gridData);
		editRequirementButton.setVisible(false);
		
		final Button removeRequirementButton = new Button(innerGroup, SWT.NULL);
		removeRequirementButton.setText("Remove Requirement");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = GridData.BEGINNING;
		removeRequirementButton.setLayoutData(gridData);
		removeRequirementButton.setVisible(false);
		
		/*
		 * Requirement Compact View
		 */
		Button compactViewButton = new Button(this, SWT.NULL);
		compactViewButton.setText("Requirement Compact View");
		
		compactViewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new RequirementCompactViewGraphBTWizard(map, d));				
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				
			}
		});

		/*
		 * Edit Label
		 */
		final Group editLabel = new Group(this, SWT.SHADOW_ETCHED_IN);		
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

				if(wizardDialog.open() != Window.OK) {
					return;
				}
				listRequirements.removeAll();
				for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
					listRequirements.add(requirement.getKey());
				}
			}

		});

		final Text requirementRefText = new Text(this, SWT.BORDER | SWT.SINGLE);
		requirementRefText.setVisible(false);

		listRequirements.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listRequirements.getItem(listRequirements.getSelectionIndex());
				map.put(Requirement.REQUIREMENT_KEY, selected );

				Requirement r = GraphBTUtil.getRequirement(d, selected);

				if(r !=  null) {
					nameLabel.setText(r.getKey() + " " + r.getRequirement());
					descLabel.setText(r.getDescription());
					descLabel.setVisible(true);
					editRequirementNameText.setText(r.getRequirement());
					requirementRefText.setText(r.getKey());
					editRequirementDescText.setText(r.getDescription());
				}
				editRequirementButton.setVisible(true);
				removeRequirementButton.setVisible(true);
			}
		});

		saveRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				
				d = ds.getDiagramTypeProvider().getDiagram();
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Requirement r = GraphBTUtil.getRequirement(d, requirementRefText.getText());

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
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
				descLabel.setVisible(true);
				group.setVisible(true);
			}
		});
		
		removeRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						"Confirm delete requirement", "Are you sure you want to remove the requirement?");
				if(!delete)
					return;
	
				
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				final Requirement r = GraphBTUtil.getRequirement(d, requirementRefText.getText());

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						GraphBTUtil.removeRequirement(GraphBTUtil.getBEModel(d), requirementRefText.getText());
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				editLabel.setVisible(false);
				saveRequirementButton.setVisible(false);
				editRequirementLabel.setVisible(false);
				editRequirementDescLabel.setVisible(false);
				editRequirementNameText.setVisible(false);
				editRequirementDescText.setVisible(false);
				nameLabel.setText("");
				descLabel.setText("");
				descLabel.setVisible(false);
				group.setVisible(true);
				removeRequirementButton.setVisible(false);
				editRequirementButton.setVisible(false);
				listRequirements.removeAll();
				for(Requirement req : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
					listRequirements.add(req.getRequirement());
				}
			}
		});

		editRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				Requirement r = GraphBTUtil.getRequirement(d, requirementRefText.getText());

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

	}
	private void dialogChanged() {
		
		if (requirementNameText.getText().length() == 0) {
			updateStatus("Requirement name must be specified");
			return;
		}
		
		if (requirementRefText.getText().length() == 0) {
			updateStatus("Requirement key must be specified");
			return;
		}
		
		if (!GraphBTUtil.getRequirement(d, requirementRefText.getText()).getKey().trim().equals("")) {
			updateStatus("Requirement key already exist");
			return;
		}

		if (!(requirementRefText.getText().matches("R[0-9]+"))) {
			updateStatus("Format of requirement key should be 'R' followed by number (e.g.: R1)");
			return;
		}
		
		if (requirementDescText.getText().length() == 0) {
			updateStatus("Requirement description must be specified");
			return;
		}
	
		updateStatus(null);
	}
	
	private void updateStatus(String message) {

	}
}
