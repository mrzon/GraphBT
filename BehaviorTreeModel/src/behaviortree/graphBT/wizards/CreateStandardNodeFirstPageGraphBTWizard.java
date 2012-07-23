package behaviortree.graphBT.wizards;

import org.eclipse.graphiti.mm.pictograms.Diagram;
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

import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.TraceabilityStatus;


public class CreateStandardNodeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private String stringCarrier[];
	private Diagram d;

	
	public CreateStandardNodeFirstPageGraphBTWizard(String stringCarrier[], Diagram d) {
		super("Create Standard Node Wizard");
		setTitle("Create Standard Node Wizard");
		setDescription("Fill in the Behavior Tree node elements below.");
		this.stringCarrier = stringCarrier;
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
	    
	    operatorCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
			     
		     }
	     });
	    
	    Label traceabilityStatusLabel = new Label(container, SWT.NULL);
	    traceabilityStatusLabel.setText("Traceability Status Name");
		
	    traceabilityStatusCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    traceabilityStatusCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(TraceabilityStatus ts : TraceabilityStatus.VALUES) {
	    	traceabilityStatusCombo.add(ts.getName());
	    }
	    
	    Label componentComboLabel = new Label(container, SWT.NULL);
	    componentComboLabel.setText("Component Name");
		
	    Combo componentCombo= new Combo(container, SWT.BORDER | SWT.READ_ONLY);
	    componentCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
	    	componentCombo.add(component.getComponentName());
	    }
	    
	    final Label componentButtonLabel = new Label(container, SWT.NULL);
	    componentButtonLabel.setText("Add Component");
	    
	    Button componentButton = new Button(container, SWT.NULL);
	    componentButton.setText("Add New Component");


	    final Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("Component Name");
		componentLabel.setVisible(false);
		
		final Text componentNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentNameText.setVisible(false);
		
		final Label behaviorLabel = new Label(container, SWT.NULL);
		behaviorLabel.setText("Behavior Name");
		behaviorLabel.setVisible(false);
		
		final Text behaviorText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorText.setVisible(false);
		
	    componentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(componentLabel.isVisible())
				{
					componentLabel.setVisible(false);
					componentNameText.setVisible(false);
					behaviorLabel.setVisible(false);
					behaviorText.setVisible(false);
				}
				else
				{
					componentLabel.setVisible(true);
					componentNameText.setVisible(true);
					behaviorLabel.setVisible(true);
					behaviorText.setVisible(true);
				}
			}
		});

		
		componentNameText.setText("");
		
		componentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				stringCarrier[0] = t.getText();
			}
	    });
		
		behaviorText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				stringCarrier[1] = t.getText();
			}
	    });

	    traceabilityStatusCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
			     
		     }
	     });
	    componentCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
			     
		     }
	     });

		System.out.println("stringCarrier[0] " + stringCarrier[0]);
		System.out.println("stringCarrier[0].getText() " + componentNameText.getText());
		// Required to avoid an error in the system
		setControl(container);
	}
}