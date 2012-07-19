package behaviortree.graphBT.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;


public class CreateStandardNodeFirstPageGraphBTWizard extends WizardPage {
	private Text fieldNameText;
	private Text componentNameText;
	private Text behaviorNameText;
	private Combo operatorCombo;
	private Combo traceabilityStatusCombo;
	private Composite container;
	private String stringCarrier[];
	
	public CreateStandardNodeFirstPageGraphBTWizard(String stringCarrier[]) {
		super("Create Standard Node Wizard");
		setTitle("Create Standard Node Wizard");
		setDescription("Fill in the Behavior Tree node elements below.");
		this.stringCarrier = stringCarrier;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		Label fieldLabel = new Label(container, SWT.NULL);
		fieldLabel.setText("Field's Name");

		fieldNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
//		fieldNameText.setText("");

		Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("Component Name");

		componentNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentNameText.setText("");
		
		componentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				componentNameText = (Text) e.widget;
				stringCarrier[0] = componentNameText.getText();
			}
	    });
		
		
//		stringCarrier[1] = behaviorNameText.getText();
		
		Label behaviorLabel = new Label(container, SWT.NULL);
		behaviorLabel.setText("Behavior Name");

		behaviorNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorNameText.setText("");
		behaviorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				behaviorNameText = (Text) e.widget;
				stringCarrier[1] = behaviorNameText.getText();
			}
	    });
		
		Label operatorLabel = new Label(container, SWT.NULL);
		operatorLabel.setText("Operator Name");
		
//		Operator operator;
		
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
	    
	    traceabilityStatusCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
			     
		     }
	     });

//		componentNameText.addKeyListener(new KeyListener() {
//			@Override
//			public void keyPressed(KeyEvent e) {}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				if (!componentNameText.getText().isEmpty()) {
//					componentChecker = true;
//				}
//				else
//					componentChecker = false;
//			}
//		});

		behaviorNameText.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!behaviorNameText.getText().isEmpty()) {
					setPageComplete(true);
				}
			}
		});
			
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		fieldNameText.setLayoutData(gd);
		componentNameText.setLayoutData(gd);
		behaviorNameText.setLayoutData(gd);
		
		System.out.println("stringCarrier[0] " + stringCarrier[0]);
		System.out.println("stringCarrier[0].getText() " + componentNameText.getText());
		// Required to avoid an error in the system
		setControl(container);
		
	}

	public String getText1() {
		return fieldNameText.getText();
	}
}