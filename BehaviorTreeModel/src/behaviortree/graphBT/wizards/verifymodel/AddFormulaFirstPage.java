package behaviortree.graphBT.wizards.verifymodel;

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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
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
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;


public class AddFormulaFirstPage extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	
	private Text textField;

	
	public AddFormulaFirstPage(HashMap<Integer,String> map, Diagram d) {
		super("Verify Model");
		setTitle("Verify Model");
		setDescription("Verify the model of behavior tree using LTL formula.");
		this.map = map;
		this.d=d;
	}

	/**
	 * implementation of user interface drawing.
	 */
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridData gridData;
	    GridLayout gLayout = new GridLayout();
	    gLayout.numColumns = 2;
	    container.setLayout(gLayout);
	    
	    // label ui
	    Label label = new Label(container, SWT.LEFT);
	    label.setText("Write your LTL Formula here:");
	    label = new Label(container, SWT.LEFT);
	    // text area
	    textField = new Text(container, SWT.MULTI | SWT.BORDER);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    textField.setLayoutData(gridData);
	    // container
	    Composite composite = new Composite(
	            container, SWT.NORMAL);
	    gLayout = new GridLayout();
	    gLayout.numColumns = 2;
	    composite.setLayout(gLayout);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    composite.setLayoutData(gridData);
	    // button ui
	    Button button;
	    Button btnF = new Button(composite, SWT.PUSH);
	    btnF.setText("F");
	    Button btnG = new Button(composite, SWT.PUSH);
	    btnG.setText("G");
	    Button btnR = new Button(composite, SWT.PUSH);
	    btnR.setText("R");
	    Button btnW = new Button(composite, SWT.PUSH);
	    btnW.setText("W");
	    Button btnX = new Button(composite, SWT.PUSH);
	    btnX.setText("X");
	    Button btnU = new Button(composite, SWT.PUSH);
	    btnU.setText("U");
	   /* Button btnC = new Button(composite, SWT.PUSH);
	    btnC.setText("C");*/
	    
	    // add listener
	    /*btnC.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new SearchComponentBehaviorWizard(map, d));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
			}
			
		});*/
	    
	    btnF.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"F()" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
	    btnG.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"G()" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
	    btnR.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"R( , )" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
	    btnW.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"W( , )" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
	    btnX.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"X()" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
	    btnU.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"U( , )" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
			
		});
	    
		textField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t = (Text) e.widget;
				map.put(0, t.getText());
			}
	    });
		
		setControl(container);
		
		
	}
}