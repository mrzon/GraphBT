package org.be.graphbt.graphiti.wizards.createstandardnode;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.graphiti.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createcomponent.CreateComponentGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managecomponents.ManageComponentsGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managerequirements.ManageRequirementsGraphBTWizard;

/**
 * Class to define the contents of create standard BT node wizard
 * @author GraphBT Team
 *
 */
public class CreateStandardNodeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer, String> map;
	private Diagram d;
	private Button behaviorButton;
	Combo componentCombo;
	Combo behaviorCombo;
	Combo traceabilityLinkCombo;
	
	public CreateStandardNodeFirstPageGraphBTWizard(HashMap<Integer, String> map, Diagram d) {
		super("Create Standard Node Wizard");
		setTitle("Create Standard Node Wizard");
		setDescription("Fill in the Behavior Tree node elements below.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 4;
		GridData gridData;		
		
	    
	    Button componentButton = new Button(container, SWT.NULL);
	    componentButton.setText("Add New Component");
	    
	    final Button behaviorButton = new Button(container, SWT.NULL);
	    behaviorButton.setText("Add New Behavior");
	    behaviorButton.setEnabled(false);
	    
	    
	    Button manageComponentsButton = new Button(container, SWT.NULL);
	    manageComponentsButton.setText("Manage Components");	 
	    
	    Button requirementButton = new Button(container, SWT.NULL);
	    requirementButton.setText("Add Requirement");

			
		Combo operatorCombo;
		Combo traceabilityStatusCombo;
		
		Label operatorLabel = new Label(container, SWT.NULL);
		operatorLabel.setText("Operator Name:");
		
	    operatorCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;		
	    operatorCombo.setLayoutData(gridData);
	    		
	    for(Operator op : Operator.VALUES) {
		    operatorCombo.add(op.getName());
	    }
	    
	    Label traceabilityLinkLabel = new Label(container, SWT.NULL);
	    traceabilityLinkLabel.setText("Traceability Link Name:");
		
	    traceabilityLinkCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;		
		traceabilityLinkCombo.setLayoutData(gridData);
	  
		for(Requirement ts : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
	    	traceabilityLinkCombo.add(ts.getKey());
	    }
	
	    Label traceabilityStatusLabel = new Label(container, SWT.NULL);
	    traceabilityStatusLabel.setText("Traceability Status Name:");
		
	    traceabilityStatusCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;		
		traceabilityStatusCombo.setLayoutData(gridData);	    

	    for(TraceabilityStatus ts : TraceabilityStatus.VALUES) {
	    	traceabilityStatusCombo.add(ts.getName());
	    }
	    
	    Label componentComboLabel = new Label(container, SWT.NULL);
	    componentComboLabel.setText("Component Name:");
		
	    componentCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;		
		componentCombo.setLayoutData(gridData);	
	    
	    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()) {
	    	componentCombo.add(component.getComponentName());
	    }
	    
	    Label behaviorComboLabel = new Label(container, SWT.NULL);
	    behaviorComboLabel.setText("Behavior Name:");
		
		behaviorCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;		
		behaviorCombo.setLayoutData(gridData);	
		
		operatorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(StandardNode.OPERATOR_VALUE, selected);
		    	changeDialog();
		     }
	    });
		operatorCombo.setText("NoOperator");
		operatorCombo.setEnabled(false);
	    traceabilityStatusCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.TRACEABILITYSTATUS_VALUE, selected);
		    	changeDialog();
		     }
	     });
	    
		componentCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	behaviorButton.setEnabled(true);
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.COMPONENT_VALUE, selected );
		    	behaviorCombo.removeAll();
		    	Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
		    	if(c != null)
		    	for(Behavior behavior: c.getBehaviors()) {
			    	behaviorCombo.add(behavior.toString());
			    }
		    	changeDialog();
		     }
	     });
		
	    behaviorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(StandardNode.BEHAVIOR_VALUE, selected);
		    	changeDialog();
		     }
		    
	     });
	    
	    traceabilityLinkCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.TRACEABILITYLINK_VALUE, selected);
		    	changeDialog();
		     }
	     });


	    manageComponentsButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new ManageComponentsGraphBTWizard(d));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				componentCombo.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()) {
			    	componentCombo.add(component.getComponentName());
			    }
			}
		});
	    
	    requirementButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new ManageRequirementsGraphBTWizard(map, d));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				traceabilityLinkCombo.removeAll();
				for(Requirement r : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
					traceabilityLinkCombo.add(r.getKey());
			    }
				
			}
		});
	    
	    componentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new CreateComponentGraphBTWizard(map, d));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				componentCombo.removeAll();
			    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()) {
			    	componentCombo.add(component.getComponentName());
			    }
			    //tesComplete();
			}
			
		});
	    
	    behaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String str = map.get(StandardNode.COMPONENT_VALUE);
				if(str == null || str.equals("")) {
					MessageDialog.openError(null, "Error Create Behavior", "Select existing component before adding behavior!"+map.get(StandardNode.COMPONENT_VALUE));
					return;
				}
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), map.get(StandardNode.COMPONENT_VALUE));
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new CreateBehaviorGraphBTWizard(c));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				behaviorCombo.removeAll();
				for(Behavior behavior: c.getBehaviors()) {
			    	behaviorCombo.add(behavior.toString());
			    }
				//tesComplete();
			}
			
		});
	    map.put(StandardNode.OPERATOR_VALUE, Operator.NO_OPERATOR.getName());
	    map.put(StandardNode.TRACEABILITYSTATUS_VALUE, TraceabilityStatus.ORIGINAL.getName());
	    map.put(StandardNode.TRACEABILITYLINK_VALUE, "DEFAULT");
	    setPageComplete(false);
	    //changeDialog();
		setControl(container);
	}
	private void changeDialog() {
		if(componentCombo.getSelectionIndex()==-1 && behaviorCombo.getSelectionIndex()==-1) {
    		changeDialog("Component & Behavior are empty!");
    		
    	}else if(componentCombo.getSelectionIndex()==-1) {
    		changeDialog("Component is empty!");
       	}else if(behaviorCombo.getSelectionIndex()==-1) {
       		changeDialog("Behavior is empty!");
    	}/*else if(traceabilityLinkCombo.getSelectionIndex()==-1) {
       		changeDialog("Requitement is empty!");
    	}*/
       	else{
    		changeDialog(null);
    	}

	}
	private void changeDialog(String message) {
		setErrorMessage(message);
		setPageComplete(message==null);
	}
}
