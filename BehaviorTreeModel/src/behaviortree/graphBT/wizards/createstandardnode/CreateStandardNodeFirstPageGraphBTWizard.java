package behaviortree.graphBT.wizards.createstandardnode;

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

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;
import behaviortree.graphBT.wizards.managerequirements.ManageRequirementsGraphBTWizard;


public class CreateStandardNodeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer, String> map;
	private Diagram d;
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
		layout.numColumns = 2;
		
		Combo operatorCombo;
		Combo traceabilityStatusCombo;
		
			
		Label operatorLabel = new Label(container, SWT.NULL);
		operatorLabel.setText("Operator Name");
		
	    operatorCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    operatorCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(Operator op : Operator.VALUES) {
		    operatorCombo.add(op.getName());
	    }
	    
	    Label traceabilityLinkLabel = new Label(container, SWT.NULL);
	    traceabilityLinkLabel.setText("Traceability Link Name");
		
	    traceabilityLinkCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    traceabilityLinkCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(Requirement ts : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
	    	traceabilityLinkCombo.add(ts.getKey());
	    }
	
	    Label traceabilityStatusLabel = new Label(container, SWT.NULL);
	    traceabilityStatusLabel.setText("Traceability Status Name");
		
	    traceabilityStatusCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    traceabilityStatusCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(TraceabilityStatus ts : TraceabilityStatus.VALUES) {
	    	traceabilityStatusCombo.add(ts.getName());
	    }
	    
	    Label componentComboLabel = new Label(container, SWT.NULL);
	    componentComboLabel.setText("Component Name");
		
	    componentCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    componentCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
	    	componentCombo.add(component.getComponentName());
	    }
	    
	    Label behaviorComboLabel = new Label(container, SWT.NULL);
	    behaviorComboLabel.setText("Behavior Name");
		
		behaviorCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		behaviorCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		operatorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(StandardNode.OPERATOR_VALUE, selected);
		    	changeDialog();
		     }
	    });
	    
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
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.COMPONENT_VALUE, selected );
		    	behaviorCombo.removeAll();
		    	Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
		    	if(c != null)
		    	for(Behavior behavior: c.getBehaviors()){
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

	    Label fillerLabel1 = new Label(container, SWT.NULL);
	    fillerLabel1.setText(" ");
	    
	    Button componentButton = new Button(container, SWT.NULL);
	    componentButton.setText("Add New Component");
	    
	    Label fillerLabel2 = new Label(container, SWT.NULL);
	    fillerLabel2.setText(" ");
	    
	    Button behaviorButton = new Button(container, SWT.NULL);
	    behaviorButton.setText("Add New Behavior");
	    
	    Label fillerLabel3 = new Label(container, SWT.NULL);
	    fillerLabel3.setText(" ");
	    
	    Button manageComponentsButton = new Button(container, SWT.NULL);
	    manageComponentsButton.setText("Manage Components");
	    
	    Label fillerLabel4 = new Label(container, SWT.NULL);
	    fillerLabel4.setText(" ");
	    
	    Button requirementButton = new Button(container, SWT.NULL);
	    requirementButton.setText("Add Requirement");

	    manageComponentsButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new ManageComponentsGraphBTWizard(map, d));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				componentCombo.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
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
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				traceabilityLinkCombo.removeAll();
				for(Requirement r : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
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
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				componentCombo.removeAll();
			    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
			    	componentCombo.add(component.getComponentName());
			    }
			    //tesComplete();
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
				behaviorCombo.removeAll();
				for(Behavior behavior: c.getBehaviors()){
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
	private void changeDialog()
	{
		if(componentCombo.getSelectionIndex()==-1 && behaviorCombo.getSelectionIndex()==-1){
    		changeDialog("Component & Behavior are empty!");
    		
    	}else if(componentCombo.getSelectionIndex()==-1){
    		changeDialog("Component is empty!");
       	}else if(behaviorCombo.getSelectionIndex()==-1){
       		changeDialog("Behavior is empty!");
    	}/*else if(traceabilityLinkCombo.getSelectionIndex()==-1){
       		changeDialog("Requitement is empty!");
    	}else*/{
    		changeDialog(null);
    	}

	}
	private void changeDialog(String message) {
		setErrorMessage(message);
		setPageComplete(message==null);
	}
}
