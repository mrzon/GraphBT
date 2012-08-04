package behaviortree.graphBT.wizards.managerequirements;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
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

import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.Requirement;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.createrequirement.CreateRequirementGraphBTWizard;


public class ManageRequirementsFirstPageGraphBTWizard extends WizardPage {

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;


	public ManageRequirementsFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Create Requirement Wizard");
		setTitle("Create RequirementWizard");
		setDescription("Fill in the requirement below.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final List listRequirements = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		listRequirements.setBounds(0, 0, 220, 220);

		Button createRequiermentButton = new Button(container, SWT.NULL);
		createRequiermentButton .setText("Add New Requirement");


		createRequiermentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateRequirementGraphBTWizard(map, d));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				/*listComponents.removeAll();
				for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
					listComponents.add(component.getComponentName());
				}*/
			}

		});

		setControl(container);
	}
}