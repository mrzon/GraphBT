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
import behaviortree.Formula;
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

	/**
	 * constructor.
	 * @param map
	 * @param d
	 */
	public AddFormulaFirstPage(HashMap<Integer,String> map, Diagram d) {
		super("Add Formula");
		setTitle("Add Formula");
		setDescription("Added LTL formula to check model of behavior tree.");
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
	    label.setText("Write your LTL Formula below:");
	    label = new Label(container, SWT.LEFT);
	    // text area
	    textField = new Text(container, SWT.MULTI | SWT.BORDER 
	    		| SWT.V_SCROLL | SWT.H_SCROLL);
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
	    gLayout.numColumns = 3;
	    composite.setLayout(gLayout);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    composite.setLayoutData(gridData);
	    
	    //
	    Label titleSelectComponent = new Label(composite, SWT.LEFT);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 3;
	    titleSelectComponent.setLayoutData(gridData);
	    titleSelectComponent.setText("Select component and its behavior:");
	    
	    Button btnPickComponent = new Button(composite, SWT.PUSH);
	    btnPickComponent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnPickComponent.setText("Pick variable");
	    new Label(composite, SWT.LEFT); new Label(composite, SWT.LEFT);
	    
	    Label titleFormulaOperator = new Label(composite, SWT.LEFT);
	    titleFormulaOperator.setLayoutData(gridData);
	    titleFormulaOperator.setText("Here is LTL operators:");
	    
	    // button ui
	    Button btnF = new Button(composite, SWT.PUSH);
	    btnF.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnF.setText("F");
	    Button btnG = new Button(composite, SWT.PUSH);
	    btnG.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnG.setText("G");
	    Button btnR = new Button(composite, SWT.PUSH);
	    btnR.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnR.setText("R");
	    Button btnW = new Button(composite, SWT.PUSH);
	    btnW.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnW.setText("W");
	    Button btnX = new Button(composite, SWT.PUSH);
	    btnX.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnX.setText("X");
	    Button btnU = new Button(composite, SWT.PUSH);
	    btnU.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnU.setText("U");
	    
	    Button btnAND = new Button(composite, SWT.PUSH);
	    btnAND.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnAND.setText("AND");
	    Button btnOR = new Button(composite, SWT.PUSH);
	    btnOR.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnOR.setText("OR");
	    Button btnArrow = new Button(composite, SWT.PUSH);
	    btnArrow.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnArrow.setText("=>");
	    
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
	    
	    btnArrow.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"=>" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
		});
	    
	    btnAND.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"AND" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
		});
	    
	    btnOR.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int indexOfCursor = textField.getCaretPosition();
				String text = textField.getText();
				textField.setText(
						text.substring(0, indexOfCursor) + 
						"OR" +
						text.substring(indexOfCursor));
				textField.setFocus();
			}
		});
	    
	    btnPickComponent.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new SearchComponentBehaviorWizard(map, d));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				//masterList.add(map.get(ConstantsOfVerifyModel.REF_ADD_FORMULA));
			}
		});
	    
		textField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t = (Text) e.widget;
				map.put(ConstantsOfVerifyModel.REF_ADD_FORMULA, t.getText());
			}
	    });
		
		setControl(container);
		
		
	}
}