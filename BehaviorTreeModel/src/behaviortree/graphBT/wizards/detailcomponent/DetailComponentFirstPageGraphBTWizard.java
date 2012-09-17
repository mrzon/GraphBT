package behaviortree.graphBT.wizards.detailcomponent;

import java.util.HashMap;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class DetailComponentFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Text behaviorNameText;
	private Text behaviorRefText;
	private Text behaviorDescText;
	private Combo typeCombo;
	
	public DetailComponentFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c) {
		super("Detail Component Wizard");
		setTitle("Detail Component Wizard");
		setDescription("This is the details of Component "+c.getComponentName());
		this.map = map;
		this.c=c;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		GridData gridData = new GridData();

		final Label cNameLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		cNameLabel.setLayoutData(gridData);		
		cNameLabel.setText("Name: " + c.getComponentName());
		
		final Label cRefLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		cRefLabel.setLayoutData(gridData);		
		cRefLabel.setText("Reference: " + c.getComponentRef());
		
		final Label descComponentLabel = new Label(container, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 2;		
		descComponentLabel.setLayoutData(gridData);	
		descComponentLabel.setText("Description:");		
		
		final Text componentDescText = new Text(container, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		gridData.grabExcessVerticalSpace = true;
		componentDescText.setLayoutData(gridData);
		componentDescText.setEditable(false);
		componentDescText.setText("Description");
		
		final Label listBehaviorLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		listBehaviorLabel .setLayoutData(gridData);		
		listBehaviorLabel .setText("List Behaviors:");
		
		final List listBehaviors = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		
		listBehaviors.setLayoutData(gridData);
		for(Behavior behavior: c.getBehaviors()){
			listBehaviors.add(behavior.toString());
		}
		
		final Button behaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData();		
		behaviorButton.setLayoutData(gridData);
		behaviorButton.setText("Add Behavior");
									

		behaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateBehaviorGraphBTWizard(c));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
			}
		});
		// Required to avoid an error in the system
		setControl(container);
	}
	
	private void dialogChanged() {
		
		if (behaviorNameText.getText().length() == 0) {
			updateStatus("Behavior name must be specified");
			return;
		}
		
		if (behaviorRefText.getText().length() == 0) {
			updateStatus("Behavior reference must be specified");
			return;
		}
		
		if (GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefText.getText()) != null) {
			updateStatus("Behavior reference is already exist");
			return;
		}

		if (!(behaviorRefText.getText().matches("[0-9]+"))) {
			updateStatus("Format of behavior reference should be number");
			return;
		}
		
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
}