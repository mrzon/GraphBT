package behaviortree.graphBT.wizards;

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
import org.eclipse.ui.PlatformUI;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;


public class CreateStandardNodeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer, String> map;
	private Diagram d;

	
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
	    
	
	    Label traceabilityStatusLabel = new Label(container, SWT.NULL);
	    traceabilityStatusLabel.setText("Traceability Status Name");
		
	    traceabilityStatusCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    traceabilityStatusCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(TraceabilityStatus ts : TraceabilityStatus.VALUES) {
	    	traceabilityStatusCombo.add(ts.getName());
	    }
	    
	    Label componentComboLabel = new Label(container, SWT.NULL);
	    componentComboLabel.setText("Component Name");
		
	    final Combo componentCombo= new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    componentCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
	    	componentCombo.add(component.getComponentName());
	    }
	    
	    Label behaviorComboLabel = new Label(container, SWT.NULL);
	    behaviorComboLabel.setText("Behavior Name");
		
	    final Combo behaviorCombo= new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    componentCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    componentCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.STANDARDNODE_COMPONENT, selected );
		    	behaviorCombo.removeAll();
		    	Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
		    	if(c!=null)
		    	for(Behavior behavior: c.getBehaviors()){
			    	behaviorCombo.add(behavior.toString());
			    }
		     }
	     });
	    behaviorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(StandardNode.STANDARDNODE_BEHAVIOR, selected);
		     }
	     });
	     
	    Button componentButton = new Button(container, SWT.NULL);
	    componentButton.setText("Add New Component");
	    Button behaviorButton = new Button(container, SWT.NULL);
	    behaviorButton.setText("Add New Behavior");
	    Button manageComponentsButton = new Button(container, SWT.NULL);
	    manageComponentsButton.setText("Manage Components");

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
				behaviorCombo.removeAll();
				for(Behavior behavior: c.getBehaviors()){
			    	behaviorCombo.add(behavior.toString());
			    }
			}
			
		});
		
	    operatorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(StandardNode.STANDARDNODE_OPERATOR, selected);
		     }
	    });
	    
	    traceabilityStatusCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(StandardNode.STANDARDNODE_TRACEABILITYSTATUS, selected );
		    	
		     }
	     });

		//System.out.println("stringCarrier[0] " + stringCarrier[0]);
		setControl(container);
	}
}