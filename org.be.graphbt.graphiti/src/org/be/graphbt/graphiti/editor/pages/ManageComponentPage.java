package org.be.graphbt.graphiti.editor.pages;

import java.beans.MethodDescriptor;
import java.util.HashMap;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.graphiti.wizards.createattribute.CreateAttributeGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createcomponent.CreateComponentGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createstate.CreateStateGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createuses.CreateUsesGraphBTWizard;
import org.be.graphbt.graphiti.wizards.detailcomponent.DetailComponentGraphBTWizard;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.MethodDeclaration;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.State;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


public class ManageComponentPage extends Composite {
	private HashMap<Integer,String> map;
	private Diagram d;
	private String componentRefTemp;
	private String behaviorRefTemp;
	private Button behaviorButton;
	private Button checkButton;
	private Text componentDescText;
	private Text behaviorDescText;
	private Combo typeCombo;
	private int index;
	private Group groupBehavior;
	private Label bNameLabel;
	private Label bRefLabel;
	private Label bTypeLabel;
	public ManageComponentPage(Composite parent, int style, Diagram d2, HashMap<Integer,String> map) {
		super(parent, style);
		this.setMap(map);
		this.setDiagram(d2);
		init();
	}
	public void init() {
		GridLayout layout = new GridLayout(4, false);
		setLayout(layout);
		GridData gridData;

		final Label listComponentLabel = new Label(this, SWT.NULL);
		listComponentLabel.setText("List Components:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		listComponentLabel.setLayoutData(gridData);


		final Label listBehaviorLabel = new Label(this, SWT.NULL);
		listBehaviorLabel .setText("Select View:");
		gridData = new GridData();
		gridData.horizontalSpan = 1;
		listBehaviorLabel.setLayoutData(gridData);
		final Combo listView = new Combo(this, SWT.BORDER);
		listView.add("Behavior");
		listView.add("Attribute");
		listView.add("State");
		listView.add("Uses");

		listView.select(0);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		listView.setLayoutData(gridData);

		final List listComponents = new List(this, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;		
		listComponents.setLayoutData(gridData);
		final BEModel model = GraphBTUtil.getBEModel(d,false);
		if(model!=null) {
			for(Component component : model.getComponentList().getComponents()) {
				listComponents.add(component.getComponentName());
			}		
		}
		//listComponents.select(0);
		Button componentButton = new Button(this, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;

		componentButton.setLayoutData(gridData);
		componentButton.setText("+");

		final List listBehaviors = new List(this, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;

		listBehaviors.setLayoutData(gridData);

		behaviorButton = new Button(this, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);		
		behaviorButton.setLayoutData(gridData);
		behaviorButton.setText("+");
		//behaviorButton.setEnabled(false);

		Button deleteComponentButton = new Button(this, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;
		//gridData.grabExcessHorizontalSpace = true;	
		deleteComponentButton.setLayoutData(gridData);
		deleteComponentButton.setText("-");

		final Button deleteBehaviorButton = new Button(this, SWT.NULL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		deleteBehaviorButton.setLayoutData(gridData);
		deleteBehaviorButton.setText("-");		
		deleteBehaviorButton.setEnabled(false);


		/*
		 * Group Details Component
		 */
		final Group componentDetailsGroup = new Group(this, SWT.SHADOW_ETCHED_IN);
		componentDetailsGroup.setText("Details Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		//gridData.grabExcessHorizontalSpace = true;
		componentDetailsGroup.setLayoutData(gridData);
		GridLayout groupLayout = new GridLayout(1, false);
		componentDetailsGroup.setLayout(groupLayout);

		/*
		 * Inside Group Component
		 */
		final Label cNameLabel = new Label(componentDetailsGroup, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		cNameLabel.setLayoutData(gridData);		
		cNameLabel.setText("");

		final Label cRefLabel = new Label(componentDetailsGroup, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		cRefLabel.setLayoutData(gridData);		
		cRefLabel.setText("");

		final Label descComponentLabel = new Label(componentDetailsGroup, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		descComponentLabel.setLayoutData(gridData);	
		descComponentLabel.setText("Description:");
		descComponentLabel.setVisible(false);

		componentDescText = new Text(componentDetailsGroup, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		componentDescText.setLayoutData(gridData);
		componentDescText.setEditable(false);
		componentDescText.setVisible(false);
		/**
		 * Group Details Behavior
		 */
		final Group groupBehavior = new Group(this, SWT.SHADOW_ETCHED_IN);
		groupBehavior.setText("Details Behaviors");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 70;
		gridData.widthHint = 200;
		groupBehavior.setLayoutData(gridData);
		groupBehavior.setVisible(false);
		GridLayout groupBehaviorLayout = new GridLayout(1, false);
		groupBehavior.setLayout(groupBehaviorLayout);

		/*
		 * Inside Group Behavior
		 */
		bNameLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bNameLabel.setLayoutData(gridData);		
		bNameLabel.setText("");

		bRefLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		bRefLabel.setLayoutData(gridData);		
		bRefLabel.setText("");

		bTypeLabel = new Label(groupBehavior, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.BEGINNING;
		bTypeLabel.setLayoutData(gridData);		
		bTypeLabel.setText("");

		final Label descBehaviorLabel = new Label(groupBehavior, SWT.NULL);
		gridData = new GridData();		
		gridData.horizontalSpan = 1;
		descBehaviorLabel.setLayoutData(gridData);	
		descBehaviorLabel.setText("Description:");

		behaviorDescText = new Text(groupBehavior, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.minimumHeight = 50;
		gridData.grabExcessVerticalSpace = true;
		behaviorDescText.setLayoutData(gridData);
		behaviorDescText.setEditable(false);

		/*
		 * Group Details Edit Component
		 */
		final Group editComponentGroup = new Group(this, SWT.SHADOW_ETCHED_IN);
		editComponentGroup.setText("Edit Components");				
		gridData =
				new GridData( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL );
		gridData.horizontalSpan = 2;
		gridData.heightHint = 130;
		gridData.widthHint = 200;
		editComponentGroup.setLayoutData(gridData);
		GridLayout groupLayoutEditComponent = new GridLayout(2, false);
		editComponentGroup.setLayout(groupLayoutEditComponent);
		editComponentGroup.setVisible(false);

		final Text componentRefText = new Text(this, SWT.BORDER | SWT.SINGLE);
		componentRefText.setVisible(false);


		Component c = null; 
		if(model!=null&&listComponents.getItemCount()>0) { 
			c = GraphBTUtil.getComponent(model, listComponents.getItem(0));
		}
		deleteComponentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete component", "Are you sure you want to delete component? It may affect your current design..");
				if(!delete)
					return;
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();
				if(model!=null) {
					final Component c = GraphBTUtil.getComponentByRef(model, componentRefTemp);

					final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Component") {
						protected void doExecute() {
							GraphBTUtil.removeComponentByRef(model, componentRefTemp);
						}
					};

					ds.getEditingDomain().getCommandStack().execute(cmd);
				}
				editComponentGroup.setVisible(false);
				//	editComponentLabel.setVisible(false);
				//editComponentNameText.setVisible(false);
				//editDescComponentLabel.setVisible(false);
				//editComponentDescText.setVisible(false);

				cNameLabel.setVisible(false);
				cRefLabel.setVisible(false);
				descComponentLabel.setVisible(false);
				componentDescText.setVisible(false);

				listComponents.removeAll();
				listBehaviors.removeAll();
				if(model!=null) {
					for(Component component : model.getComponentList().getComponents()) {
						listComponents.add(component.getComponentName());
					}
				}
			}
		});

		/*
		 * Action List
		 */
		listComponents.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				//System.out.println("awal= " + index);
				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				index = listComponents.getSelectionIndex();
				//System.out.println("index= " + index);
				map.put(StandardNode.COMPONENT_VALUE, selected );
				if(model==null)
					return;
				Component c = GraphBTUtil.getComponent(model, selected);

				if(c!=null) {
					listBehaviors.removeAll();
					switch(listView.getSelectionIndex()) {
					case 0: 
						for(Behavior behavior: c.getBehaviors()) {
							listBehaviors.add(behavior.toString());
						}
						break;
					case 1:
						for(Attribute att: c.getAttributes()) {
							listBehaviors.add(att.toString());
						}
						break;
					case 2:
						for(State state: c.getState()) {
							listBehaviors.add(state.toString());
						}
						break;
					case 3:
						for(Library lib: c.getUses()) {
							listBehaviors.add(lib.getId());
						}
					}

					componentDetailsGroup.setVisible(true);
					groupBehavior.setVisible(false);
					//editBehaviorGroup.setVisible(false);
					//editComponentGroup.setVisible(false);
					cNameLabel.setVisible(true);
					cNameLabel.setText("Name: " + c.getComponentName());
					cRefLabel.setVisible(true);
					cRefLabel.setText("Reference: " +c.getComponentRef());
					descComponentLabel.setVisible(true);
					componentDescText.setVisible(true);
					componentDescText.setText(c.getComponentDesc()==null?"":c.getComponentDesc());
					behaviorButton.setEnabled(true);

				}

				//editComponentNameText.setText(c.getComponentName());
				componentRefTemp = c.getComponentRef();
				//System.out.println("test awal= " + componentRefTemp);
			}
		});
		listView.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(listComponents.getSelectionIndex()==-1)
					return;
				if(model==null)
					return;
				Component c = GraphBTUtil.getComponent(model, listComponents.getItem(listComponents.getSelectionIndex()));
				if(c==null)
					return;
				listBehaviors.removeAll();
				switch(listView.getSelectionIndex()) {
				case 0: 
					for(Behavior behavior: c.getBehaviors()) {
						listBehaviors.add(behavior.toString());
					}
					break;
				case 1:
					for(Attribute att: c.getAttributes()) {
						listBehaviors.add(att.toString());
					}
					break;
				case 2:
					for(State state: c.getState()) {
						listBehaviors.add(state.toString());
					}
					break;
				case 3:
					for(Library lib: c.getUses()) {
						listBehaviors.add(lib.getId());
					}
				}

			}
		});
		listComponents.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if(model==null)
					return;
				String selected = listComponents.getItem(listComponents.getSelectionIndex());
				index = listComponents.getSelectionIndex();
				//System.out.println("index= " + index);
				map.put(StandardNode.COMPONENT_VALUE, selected );
				listBehaviors.removeAll();
				Component c = GraphBTUtil.getComponent(model, selected);
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new DetailComponentGraphBTWizard(c));
				if(wizardDialog.open() == Window.OK) {
					return;
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub

			}}
				);
		listBehaviors.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(listBehaviors.getSelectionIndex() > listBehaviors.getItemCount())
					return;
				if(model==null)
					return;
				String selected = listBehaviors.getItem(listBehaviors.getSelectionIndex());
				Component c = GraphBTUtil.getComponentByRef(model, componentRefTemp);
				deleteBehaviorButton.setEnabled(true);
				groupBehavior.setVisible(true);
				switch(listView.getSelectionIndex())
				{
				case 0:
					Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selected);
					updateBehaviorDetail(b);
					break;
				case 1:
					Attribute a = GraphBTUtil.getAttributeFromComponent(c, selected);
					updateAttributeDetail(a);
					break;
				case 2:
					State s = GraphBTUtil.getStateFromComponent(c, selected);
					updateStateDetail(s);
					break;
				case 3:
					Library l = GraphBTUtil.getLibraryFromComponent(c, selected);
					updateLibraryDetail(l);
					break;
				}

			}
		});
		listBehaviors.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int s = listBehaviors.getSelectionIndex();
				String selected = listBehaviors.getItem(s);
				if(model==null)
					return;
				Component c = GraphBTUtil.getComponentByRef(model, componentRefTemp);
				switch(listView.getSelectionIndex())
				{
				case 0:
					Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selected);
					WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateBehaviorGraphBTWizard(c,b));
					if(wizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(Behavior behavior: c.getBehaviors()) {
							listBehaviors.add(behavior.toString());
						}
						listBehaviors.select(s);
						updateBehaviorDetail(b);
					}
					break;
				case 1:
					Attribute att = GraphBTUtil.getAttributeFromComponent(c, selected);
					WizardDialog attWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateAttributeGraphBTWizard(c,att));
					if(attWizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(Attribute atts: c.getAttributes()) {
							listBehaviors.add(atts.toString());
						}
						listBehaviors.select(s);
					}
					break;
				case 2:
					State state = GraphBTUtil.getStateFromComponent(c, selected);
					//System.out.println("Selected state "+state);
					WizardDialog sWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateStateGraphBTWizard(c,state));
					if(sWizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(State atts: c.getState()) {
							listBehaviors.add(atts.toString());
						}
						listBehaviors.select(s);
					}
				}


			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseUp(MouseEvent e) {
			}
		}
				);
		componentButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(model==null)
					return;
				HashMap <Integer,String> map = new HashMap<Integer, String>();
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateComponentGraphBTWizard(map, d));				
				if(wizardDialog.open() != Window.OK) {
					return;
				}
				listComponents.removeAll();
				for(Component component : model.getComponentList().getComponents()) {
					listComponents.add(component.getComponentName());
				}
			}
		});

		behaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(listComponents.getSelectionIndex()==-1)
					return;
				Component c = GraphBTUtil.getComponent(model, listComponents.getItem(listComponents.getSelectionIndex()));
				switch(listView.getSelectionIndex())
				{
				case 0:
					WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateBehaviorGraphBTWizard(c));
					if(wizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(Behavior behavior: c.getBehaviors()) {
							listBehaviors.add(behavior.toString());
						}
					}
					break;
				case 1:
					WizardDialog attWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateAttributeGraphBTWizard(c));
					if(attWizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(Attribute atts: c.getAttributes()) {
							listBehaviors.add(atts.toString());
						}
					}
					break;
				case 2:
					WizardDialog sWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateStateGraphBTWizard(c));
					if(sWizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(State atts: c.getState()) {
							listBehaviors.add(atts.toString());
						}
					}
					break;
				case 3:
					WizardDialog uWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							//							new CreateStateGraphBTWizard(c));
							new CreateUsesGraphBTWizard(c,d));
					if(uWizardDialog!= null && uWizardDialog.open() == Window.OK) {
						listBehaviors.removeAll();
						for(Library atts: c.getUses()) {
							listBehaviors.add(atts.getId());
						}
					}
					break;
				}
			}
		});

		final Text behaviorRefText = new Text(this, SWT.BORDER | SWT.SINGLE);
		behaviorRefText.setVisible(false);

		deleteBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(model==null)
					return;
				IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final DiagramEditor ds;
				if(page.getActiveEditor() instanceof DiagramEditor) {
					ds = (DiagramEditor)page.getActiveEditor();	
				}
				else {
					ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
				}
				d = ds.getDiagramTypeProvider().getDiagram();

				if(listComponents.getSelectionIndex()==-1)
					return;
				final Component c = GraphBTUtil.getComponent(model, listComponents.getItem(listComponents.getSelectionIndex()));
				if(listBehaviors.getSelectionIndex()==-1)
					return;

				String bSelection = listBehaviors.getItem(listBehaviors.getSelectionIndex());
				switch(listView.getSelectionIndex())
				{
				case 0:
					boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete behavior", "Are you sure you want to delete the behavior? It may affect your current design..");
					if(!delete)
						return;
					final Behavior b = GraphBTUtil.getBehaviorFromComponent(c, bSelection);
					RecordingCommand cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Behavior") {
						protected void doExecute() {
							GraphBTUtil.removeBehaviorFromComponentByRef(c, b.getBehaviorRef());
						}
					};
					ds.getEditingDomain().getCommandStack().execute(cmd);
					listBehaviors.removeAll();
					for(Behavior behavior: c.getBehaviors()) {
						listBehaviors.add(behavior.toString());
					}
					break;
				case 1:
					delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete attribute", "Are you sure you want to delete the attribute? It may affect your current design..");
					if(!delete)
						return;
					final Attribute a = GraphBTUtil.getAttributeFromComponent(c, bSelection);
					cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Attribute") {
						protected void doExecute() {
							GraphBTUtil.removeAttributeFromComponentByName(c, a.getName());
						}
					};
					ds.getEditingDomain().getCommandStack().execute(cmd);
					listBehaviors.removeAll();
					for(Attribute attribute: c.getAttributes()) {
						listBehaviors.add(attribute.toString());
					}
					break;
				case 2:
					delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete state", "Are you sure you want to delete the state? It may affect your current design..");
					if(!delete)
						return;
					final State s = GraphBTUtil.getStateFromComponent(c, bSelection);
					cmd = new RecordingCommand(ds.getEditingDomain(), "Delete State") {
						protected void doExecute() {
							GraphBTUtil.removeStateFromComponent(c, s);
						}
					};
					ds.getEditingDomain().getCommandStack().execute(cmd);
					listBehaviors.removeAll();
					for(State attribute: c.getState()) {
						listBehaviors.add(attribute.toString());
					}
					break;
				case 3:
					delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete uses library", "Are you sure you want to delete the uses library? It may affect your current design..");
					if(!delete)
						return;
					final Library l = GraphBTUtil.getLibraryFromComponent(c, bSelection);
					cmd = new RecordingCommand(ds.getEditingDomain(), "Delete State") {
						protected void doExecute() {
							c.getUses().remove(l);
						}
					};
					ds.getEditingDomain().getCommandStack().execute(cmd);
					listBehaviors.removeAll();
					for(Library attr: c.getUses()) {
						listBehaviors.add(attr.getId());
					}
					break;
				}

				bNameLabel.setVisible(false);
				bRefLabel.setVisible(false);
				bTypeLabel.setVisible(false);
				descBehaviorLabel.setVisible(false);
				behaviorDescText.setVisible(false);


			}
		});
	}

	protected void updateLibraryDetail(Library l) {
		if(l != null) {
			//editcomponentNameText.setText(c.getComponentName());
			bNameLabel.setText("Name: " + l.getName());
			bRefLabel.setText("Reference: " + l.getId());
			//bTypeLabel.setText("Type: " + b.getType());
			behaviorDescText.setVisible(true);
			StringBuffer desc = new StringBuffer(l.getDesc()==null?"":l.getDesc());
			desc.append('\n');
			if(l.getMethods().size()>0) {
				desc.append("Method declaration:\n");
				for(MethodDeclaration md:l.getMethods()) {
					desc.append(md.toString());
					desc.append('\n');
				}
			}
			behaviorDescText.setText(desc.toString());
		}
	}
	protected void updateStateDetail(State s) {
		bNameLabel.setText("Name: " + s.getName());
		bRefLabel.setText("Reference: " + s.getRef());
		behaviorDescText.setVisible(true);
		behaviorDescText.setText(s.getDesc()==null?"":s.getDesc());
	}
	private void updateBehaviorDetail(Behavior b) {
		if(b != null) {
			//editcomponentNameText.setText(c.getComponentName());
			bNameLabel.setText("Name: " + b.getBehaviorName());
			bRefLabel.setText("Reference: " + b.getBehaviorRef());
			bTypeLabel.setText("Type: " + b.getBehaviorType().getName());
			behaviorDescText.setVisible(true);
			behaviorDescText.setText((b.getBehaviorDesc()==null?"":b.getBehaviorDesc()+"\n")
					+(b.getBehaviorType().getValue()==BehaviorType.STATE_REALIZATION_VALUE
					&&b.getTechnicalDetail()!=null&&b.getTechnicalDetail().length()!=0
					? "Implementation {\n"+b.getTechnicalDetail()+"\n}" : ""));
			behaviorRefTemp = b.getBehaviorRef();
		}

	}
	private void updateAttributeDetail(Attribute b) {
		if(b != null) {
			//editcomponentNameText.setText(c.getComponentName());
			bNameLabel.setText("Name: " + b.getName());
			bRefLabel.setText("Reference: " + b.getName());
			bTypeLabel.setText("Type: " + b.getType());
			behaviorDescText.setVisible(true);
			behaviorDescText.setText(b.getDesc()==null?"":b.getDesc());
		}
	}
	private void updateComponentDetail() {
		//TODO add updateComponentImplementation
	}

	public void setDiagram(Diagram d2) {
		this.d = d2;
	}
	public void setMap(HashMap<Integer, String> map2) {
		this.map = map2;
	}
}
