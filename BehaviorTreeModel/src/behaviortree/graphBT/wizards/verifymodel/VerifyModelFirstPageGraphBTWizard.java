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
import org.eclipse.swt.widgets.List;
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


public class VerifyModelFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;

	private List masterList;
	private List currentList;
	
	public VerifyModelFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
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
		Label label;
	    GridData gridData;
	    
	    GridLayout gLayout = new GridLayout();
	    gLayout.numColumns = 3;
	    container.setLayout(gLayout);
	    
	    // master container
	    Composite masterC = new Composite(
	            container, SWT.NORMAL);
	    gLayout = new GridLayout();
	    masterC.setLayout(gLayout);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    masterC.setLayoutData(gridData);
	    
	    label = new Label(masterC, SWT.LEFT);
	    label.setText("Master formula list:");
	    
	    masterList = new List(masterC, SWT.V_SCROLL | SWT.BORDER);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    masterList.setLayoutData(gridData);
	    
	    // button container
	    Composite buttonC = new Composite(
	            container, SWT.NORMAL);
	    gLayout = new GridLayout();
	    buttonC.setLayout(gLayout);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    buttonC.setLayoutData(gridData);
	    Button button;
	    Button btnCopy = new Button(buttonC, SWT.PUSH);
	    btnCopy.setText("Copy >>");
	    Button btnDelete= new Button(buttonC, SWT.PUSH);
	    btnDelete.setText("Delete");
	    button = new Button(buttonC, SWT.PUSH);
	    button.setText("Edit...");
	    Button btnAdd = new Button(buttonC, SWT.PUSH);
	    btnAdd.setText("Add...");
	    
	    // current container
	    Composite currentC = new Composite(
	            container, SWT.NORMAL);
	    gLayout = new GridLayout();
	    currentC.setLayout(gLayout);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    currentC.setLayoutData(gridData);
	    
	    label = new Label(currentC, SWT.LEFT);
	    label.setText("Current formula list:");
	    
	    currentList = new List(currentC, SWT.V_SCROLL | SWT.BORDER);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    currentList.setLayoutData(gridData);
	    
	    Group group = new Group(container, SWT.NONE);
		group.setText("Option");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 3;
		group.setLayoutData(gridData);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		button = new Button(group, SWT.CHECK);
		button.setText("Animate trace error");
		button = new Button(group, SWT.CHECK);
		button.setText("Generate code");
		
		// add listener
		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new AddFormulaWizard(map, d));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				masterList.add(map.get(0));
			}
			
		});
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int selectedIndex = masterList.getSelectionIndex();
				if(selectedIndex != -1) {
					masterList.remove(selectedIndex);
				}
				
			}
			
		});
		
		btnCopy.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int selectedIndex = masterList.getSelectionIndex();
				if(selectedIndex != -1) {
					String masterText = masterList.getItem(selectedIndex); 
					currentList.add(masterText, 0);
				}
				
			}
			
		});
		
		setControl(container);
		
		
	}
}