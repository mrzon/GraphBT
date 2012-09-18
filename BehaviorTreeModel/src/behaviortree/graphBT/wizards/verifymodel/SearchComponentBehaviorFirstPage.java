package behaviortree.graphBT.wizards.verifymodel;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.createcomponent.CreateComponentGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;


public class SearchComponentBehaviorFirstPage extends WizardPage {

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;

	private String componentRefTemp;
	private String behaviorRefTemp;
	private int index;


	public SearchComponentBehaviorFirstPage(HashMap<Integer,String> map, Diagram d) {
		super("Pick LTL Variable");
		setTitle("Pick LTL Variable");
		setDescription("Select the component and its behavior to form LTL variable.");
		this.map = map;
		this.d=d;
	}

	/**
	 * implementation of user interface drawing.
	 */
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(4, false);
		container.setLayout(layout);
		GridData gridData;

		final Label listRequirementLabel = new Label(container, SWT.NULL);
		listRequirementLabel.setText("List Components:");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		listRequirementLabel.setLayoutData(gridData);


		final Label listBehaviorLabel = new Label(container, SWT.NULL);
		listBehaviorLabel .setText("List Behavior:");
		gridData = new GridData();
		gridData.horizontalSpan = 3;
		listBehaviorLabel.setLayoutData(gridData);


		final List listComponents = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData = new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 2;
		gridData.heightHint = 100;
		gridData.widthHint = 130;
		//gridData.grabExcessVerticalSpace = true;		
		listComponents.setLayoutData(gridData);

		for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()){
			if(component!=null&&component.getComponentName()!=null)
			{
				listComponents.add(component.getComponentName());
			}
		}		

		final List listBehaviors = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData = new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 2;
		gridData.heightHint = 100;
		gridData.widthHint = 130;
		//gridData.grabExcessVerticalSpace = true;
		listBehaviors.setLayoutData(gridData);


		/*
		 * Group Details Component
		 */
		final Group group = new Group(container, SWT.SHADOW_ETCHED_IN);
		group.setText("Details Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 70;
		gridData.widthHint = 100;
		//gridData.grabExcessVerticalSpace = true;
		//gridData.grabExcessHorizontalSpace = true;
		group.setLayoutData(gridData);
		GridLayout groupLayout = new GridLayout(1, false);
		group.setLayout(groupLayout);

		/*
		 * Inside Group Component
		 */
		final Label cNameLabel = new Label(group, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		cNameLabel.setLayoutData(gridData);		
		cNameLabel.setText("");

		final Label cRefLabel = new Label(group, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		cRefLabel.setLayoutData(gridData);		
		cRefLabel.setText("");

		/*
		 * Group Details Behavior
		 */
		final Group groupBehavior = new Group(container, SWT.SHADOW_ETCHED_IN);
		groupBehavior.setText("Details Behaviors");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 70;
		gridData.widthHint = 200;
		groupBehavior.setLayoutData(gridData);
		groupBehavior.setVisible(true);
		GridLayout groupBehaviorLayout = new GridLayout(1, false);
		groupBehavior.setLayout(groupBehaviorLayout);

		/*
		 * Inside Group Behavior
		 */
		final Label bNameLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bNameLabel.setLayoutData(gridData);		
		bNameLabel.setText("");

		final Label bRefLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bRefLabel.setLayoutData(gridData);		
		bRefLabel.setText("");

		final Label bTypeLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		bTypeLabel.setLayoutData(gridData);		
		bTypeLabel.setText("");

		/*
		 * Action List
		 */
		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				System.out.println("awal= " + index);
				String selectedItem = listComponents.getItem(listComponents.getSelectionIndex());
				index = listComponents.getSelectionIndex();
				System.out.println("index= " + index);
				map.put(StandardNode.COMPONENT_VALUE, selectedItem );
				listBehaviors.removeAll();
				Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selectedItem);
				if(c!=null) {
					for(Behavior behavior: c.getBehaviors()){
						listBehaviors.add(behavior.toString());
					}

					cNameLabel.setVisible(true);
					cNameLabel.setText("Name: " + c.getComponentName());
					cRefLabel.setVisible(true);
					cRefLabel.setText("Reference: " +c.getComponentRef());
				}

				//editComponentNameText.setText(c.getComponentName());
				componentRefTemp = c.getComponentRef();

				// put to map
				map.put(ConstantsOfVerifyModel.REF_PICK_LTL_VARIABLE_COMPONENT,
						selectedItem);
			}
		});

		listBehaviors.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				String selectedItem = listBehaviors.getItem(listBehaviors.getSelectionIndex());
				//map.put(StandardNode.STANDARDNODE_COMPONENT, selected );

				System.out.println("komponen = " + componentRefTemp);

				Component c = GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefTemp);
				Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selectedItem);

				if(b != null) {
				//editcomponentNameText.setText(c.getComponentName());
					bNameLabel.setVisible(true);
					bNameLabel.setText("Name: " + b.getBehaviorName());
					bRefLabel.setVisible(true);
					bRefLabel.setText("Reference: " + b.getBehaviorRef());
					bTypeLabel.setVisible(true);
					bTypeLabel.setText("Type: " + b.getBehaviorType().getName());
				}
				behaviorRefTemp = b.getBehaviorRef();

				// put to map
				map.put(ConstantsOfVerifyModel.REF_PICK_LTL_VARIABLE_BEHAVIOR,
						b.getBehaviorName());

			}
		});

		setControl(container);
	}
}