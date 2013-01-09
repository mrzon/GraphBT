package behaviortree.graphBT.wizards.detailcomponent;

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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.Attribute;
import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;
import behaviortree.graphBT.editors.MultiPageEditor;
import behaviortree.graphBT.wizards.createattribute.CreateAttributeGraphBTWizard;
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
	private Text attributeNameText;
	private String behaviorRefTemp;
	private String attributeRefTemp;
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
		cNameLabel.setText("Name: " + c.getComponentName()==null?"":c.getComponentName());
		
		final Label cRefLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		cRefLabel.setLayoutData(gridData);		
		cRefLabel.setText("Reference: " + c.getComponentRef()==null?"":c.getComponentRef());
		
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
		componentDescText.setLayoutData(gridData);
		
		componentDescText.setText(c.getComponentDesc()==null?"":c.getComponentDesc());
		map.put(Component.DESC_VALUE,componentDescText.getText());
		componentDescText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				String text = ((Text)e.widget).getText();
				map.put(Component.DESC_VALUE,text);
			}
			
		});
		final Label listBehaviorLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		listBehaviorLabel .setLayoutData(gridData);		
		listBehaviorLabel .setText("List Behaviors:");
		
		final List listBehaviors = new List(container, SWT.BORDER | SWT.V_SCROLL);
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
		behaviorButton.setText("+");
		final Button removeBehaviorButton = new Button(container, SWT.NULL);
		gridData = new GridData();		
		removeBehaviorButton.setLayoutData(gridData);
		removeBehaviorButton.setText("-");
		removeBehaviorButton.setEnabled(false);
		
		final Label listAttributeLabel = new Label(container, SWT.NULL);				
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		gridData.horizontalSpan = 2;
		gridData.verticalAlignment = GridData.BEGINNING;
		listAttributeLabel .setLayoutData(gridData);		
		listAttributeLabel .setText("List Attributes:");
		
		final List listAttributes = new List(container, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;
		behaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateBehaviorGraphBTWizard(c));
				if(wizardDialog.open() == Window.OK)
				{
					listBehaviors.removeAll();
					for(Behavior behavior: c.getBehaviors()){
						listBehaviors.add(behavior.toString());
					}
					return;
				}
			}
		});
		removeBehaviorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				int s = listBehaviors.getSelectionIndex();
				String selected = listBehaviors.getItem(s);
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete behavior", "Are you sure you want to delete the behavior? It may affect your current design..");
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
				Diagram d = ds.getDiagramTypeProvider().getDiagram();
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Behavior b = GraphBTUtil.getBehaviorFromComponent(c, selected);
				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Behavior"+b.toString()) {
					protected void doExecute() {
						c.getBehaviors().remove(b);
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);
				listBehaviors.removeAll();
				for(Behavior behavior: c.getBehaviors()){
					listBehaviors.add(behavior.toString());
				}
			}
		});
		listAttributes.setLayoutData(gridData);
		for(Attribute att: c.getAttributes()){
			listAttributes.add(att.toString());
		}
		
		
		listAttributes.addMouseListener(new MouseListener(){
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int s = listAttributes.getSelectionIndex();
				String selected = listAttributes.getItem(s);
				System.out.println("Attribute "+selected+" is selected");
				Attribute b = GraphBTUtil.getAttributeFromComponent(c, selected);
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateAttributeGraphBTWizard(c,b));
				if(wizardDialog.open() == Window.OK)
				{
					listAttributes.removeAll();
					for(Attribute a: c.getAttributes()){
						listAttributes.add(a.toString());
					}
					listAttributes.select(s);
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
			}
		});
		final Button addAttributeButton = new Button(container, SWT.NULL);
		gridData = new GridData();		
		addAttributeButton.setLayoutData(gridData);
		addAttributeButton.setText("+");
		final Button removeAttributeButton = new Button(container, SWT.NULL);
		gridData = new GridData();		
		removeAttributeButton.setLayoutData(gridData);
		removeAttributeButton.setText("-");
		removeAttributeButton.setEnabled(false);
		addAttributeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new CreateAttributeGraphBTWizard(c));
				if(wizardDialog.open() != Window.OK)
				{
					return;
				}
				listAttributes.removeAll();
				for(Attribute att: c.getAttributes()){
					listAttributes.add(att.toString());
				}
			}
		});
		removeAttributeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				int s = listAttributes.getSelectionIndex();
				String selected = listAttributes.getItem(s);
				boolean delete = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm delete behavior", "Are you sure you want to delete the attribute? It may affect your current design..");
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
				Diagram d = ds.getDiagramTypeProvider().getDiagram();
				
				final BEModel be = GraphBTUtil.getBEModel(d);
				final Attribute a = GraphBTUtil.getAttributeFromComponent(c, selected);

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Delete Attribute") {
					protected void doExecute() {
						c.getAttributes().remove(a);
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);
				listAttributes.removeAll();
				for(Attribute att: c.getAttributes()){
					listAttributes.add(att.toString());
				}
			}
		});
		listAttributes.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeAttributeButton.setEnabled(true);
			}
		});
		listBehaviors.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeBehaviorButton.setEnabled(true);
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