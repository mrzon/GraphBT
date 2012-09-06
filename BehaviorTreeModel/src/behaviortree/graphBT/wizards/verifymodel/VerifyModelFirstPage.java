package behaviortree.graphBT.wizards.verifymodel;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Formula;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;
import behaviortree.util.Log;


public class VerifyModelFirstPage extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;

	private List masterList;
	private List currentList;
	
	public VerifyModelFirstPage(HashMap<Integer,String> map, Diagram d) {
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
	    gridData.horizontalAlignment = SWT.CENTER;
	    gridData.grabExcessHorizontalSpace = true;
	    buttonC.setLayoutData(gridData);
	    
	    Button btnCopy = new Button(buttonC, SWT.PUSH);
	    btnCopy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnCopy.setText("Copy >>");
	    Button btnDelete= new Button(buttonC, SWT.PUSH);
	    btnDelete.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnDelete.setText("Delete");
	    Button btnEdit = new Button(buttonC, SWT.PUSH);
	    btnEdit.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    btnEdit.setText("Edit...");
	    Button btnAdd = new Button(buttonC, SWT.PUSH);
	    btnAdd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
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
		
		final Button btnSaveFile = new Button(group, SWT.CHECK);
		btnSaveFile.setText("Save formula to file");
		final Button btnSaveVerRes= new Button(group, SWT.CHECK);
		btnSaveVerRes.setText("Save verification result to file");
		
		btnSaveFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				map.put(ConstantsOfVerifyModel.REF_SELECTION_SAVE_FORMULA, 
						btnSaveFile.getSelection() ? "true" : "false");
			}
		});
		btnSaveVerRes.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				map.put(ConstantsOfVerifyModel.REF_SELECTION_SAVE_VERIFICATION_RESULT, 
						btnSaveVerRes.getSelection() ? "true" : "false");
			}
		});
		
		final BEModel be = GraphBTUtil.getBEModel(d);
		
		// INIT LIST
		if(be.getFormulaList() != null) {
			for(Formula formula : be.getFormulaList().getFormula()){
				masterList.add(formula.getFormulaName());
				Log.d(formula.getFormulaName());
			}
		}
		
		// BUTTON LISTENER
		// show add formula dialog
		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
		                getActiveWorkbenchWindow().getShell(),
		    		new AddFormulaWizard(map, d));
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				masterList.add(map.get(ConstantsOfVerifyModel.REF_ADD_FORMULA));
			}
			
		});
		
		btnEdit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// no implementation
			}
			
		});
		
		// delete current content of list
		btnDelete.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int masterSelectedIndex = masterList.getSelectionIndex();
				int currentSelectedIndex = currentList.getSelectionIndex();
				
				if(masterSelectedIndex != -1) {
					masterList.remove(masterSelectedIndex);
					// beside removing data in list, it must delete data in transaction
					if(be.getFormulaList() != null) {
						be.getFormulaList().getFormula()
							.remove(masterSelectedIndex);
					}
				}
				if(currentSelectedIndex != -1) {
					currentList.remove(currentSelectedIndex);
				}
				
			}
			
		});
		
		btnCopy.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int selectedIndex = masterList.getSelectionIndex();
				if(selectedIndex != -1) {
					String masterText = masterList.getItem(selectedIndex); 
					currentList.add(masterText);
				}
				
			}
			
		});
		
		masterList.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				List l = currentList;
				for(int i=0; i<l.getItemCount(); i++) {
					l.deselect(i);
				}
			}
			
		});
		
		currentList.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				List l = masterList;
				for(int i=0; i<l.getItemCount(); i++) {
					l.deselect(i);
				}
			}
			
		});
		
		setControl(container);
		
		
	}
}