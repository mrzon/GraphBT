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
		super("Create Requirement Wizard");
		setTitle("Create RequirementWizard");
		setDescription("Fill in the requirement below.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		GridData gridData;
		
		final List listRequirements = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 2;
			    gridData.verticalSpan = 2;
			    gridData.minimumHeight = 200;
			    gridData.grabExcessVerticalSpace = true;

			    listRequirements.setLayoutData(gridData);
		
		listRequirements.removeAll();
		
		for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
			listRequirements.add(requirement.getKey());
		}
		
		Button createRequiermentButton = new Button(container, SWT.NULL);
		createRequiermentButton.setText("Add New Requirement");
		
		Button editRequiermentButton = new Button(container, SWT.NULL);
		editRequiermentButton.setText("EditRequirement");

		createRequiermentButton.addSelectionListener(new SelectionAdapter() {
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
		
		final Label editRequirementLabel = new Label(container, SWT.NULL);
		editRequirementLabel.setText("Requirement Name");
		editRequirementLabel.setVisible(false);

		final Text editRequirementNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		editRequirementNameText.setVisible(false);		

		final Label editRequirementDescLabel = new Label(container, SWT.NULL);
		editRequirementDescLabel.setText("Requirement Description");
		editRequirementDescLabel.setVisible(false);
		
		
		final Text editRequirementDescText = new Text(container, SWT.WRAP
		          | SWT.MULTI
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.V_SCROLL);
		gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 3;
			    gridData.grabExcessVerticalSpace = true;

			    editRequirementDescText.setLayoutData(gridData);
			    
		editRequirementDescText.setVisible(false);

		final Button saveRequirementButton = new Button(container, SWT.NULL);
		saveRequirementButton.setText("Save");
		saveRequirementButton.setVisible(false);
		
		final Text requirementRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		requirementRefText.setVisible(false);

		listRequirements.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selected = listRequirements.getItem(listRequirements.getSelectionIndex());
				map.put(Requirement.REQUIREMENT_KEY, selected );
				
				Requirement r = GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(d), selected);
		
				editRequirementNameText.setText(r.getRequirement());
				requirementRefText.setText(r.getKey());
				editRequirementDescText.setText(r.getDescription());
			}
		});
		
		saveRequirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				// Print the result to the console
				//System.out.println(one.getText1());
				//System.out.println(two.getText1());
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
				

				saveRequirementButton.setVisible(false);
				editRequirementLabel.setVisible(false);
				editRequirementDescLabel.setVisible(false);
				editRequirementNameText.setVisible(false);
				editRequirementDescText.setVisible(false);

				
				
				listRequirements.removeAll();
				for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
					listRequirements.add(requirement.getKey());
				}


			}
		});
		
		editRequiermentButton.addSelectionListener(new SelectionAdapter() {
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