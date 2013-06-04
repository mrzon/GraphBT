package org.be.graphbt.graphiti.wizards.createstate;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
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

import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Information;
import org.be.graphbt.model.graphbt.MapInformation;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.State;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.common.ProjectUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.graphiti.wizards.addaffectedattribute.AddAffectedAttributeGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import org.be.graphbt.graphiti.wizards.createcomponent.CreateComponentGraphBTWizard;
import org.be.graphbt.graphiti.wizards.detailcomponent.DetailComponentGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managecomponents.ManageComponentsGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managerequirements.ManageRequirementsGraphBTWizard;

/**
 * Class to define the contents of create standard BT node wizard
 * @author GraphBT Team
 *
 */
public class CreateStateFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer, String> map;
	private Component c;
	private State s;
	private Text stateNameText;
	private Text stateDescText;
	private Text stateRefText;
	
	public CreateStateFirstPageGraphBTWizard(HashMap<Integer, String> map,
			Component c, State s) {
		super("Create State Wizard");
		setTitle("Create State Wizard");
		setDescription("Fill in the form below");
		this.map = map;
		this.c=c;
		this.s=s;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		if(s!=null) {
			Label pLabel = new Label(container,SWT.NULL);
			pLabel.setText("Image description:");
			Label pictureLabel = new Label(container,SWT.NULL);
			Image image = ProjectUtil.getStateImageDescription(c,s);
			if(image != null) {
			pictureLabel.setImage(image);
			} else {
				pictureLabel.setText("No state image available");
			}
		}
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		GridData gridData;		
		
		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("State Ref:");
		
		stateRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		stateRefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Label attributeLabel = new Label(container, SWT.NULL);
		attributeLabel.setText("State Name:");
		
		stateNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		stateNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Label stateDescLabel = new Label(container, SWT.NULL);
		stateDescLabel.setText("State Description:");
					   
		stateDescText = new Text(container, SWT.WRAP
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.V_SCROLL);
		gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 1;
			    gridData.grabExcessVerticalSpace = true;
			    
		stateDescText.setLayoutData(gridData);
		if(c.getState().contains(s)) {
			stateNameText.setText(s.getName());
			stateDescText.setText(s.getDesc()==null?"":s.getDesc());
			stateRefText.setText(s.getRef());
//			stateRefText.setEnabled(false);
			map.put(State.NAME_VALUE, s.getName());
			map.put(State.DESC_VALUE, stateDescText.getText());
			map.put(State.ID_VALUE, s.getRef());
			
			final Label property = new Label(container, SWT.NULL);
			property.setText("Affected attributes:");
			final List attributes = new List(container, SWT.BORDER | SWT.V_SCROLL);
			gridData =
					new GridData(
							GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			gridData.horizontalSpan = 1;
			gridData.verticalSpan = 3;
			gridData.heightHint = 150;
			gridData.widthHint = 200;
			for(Information info:s.getAttributes().getInfo()) {
				attributes.add(info.getKey());
			}
			attributes.setLayoutData(gridData);
			attributes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					String selected = attributes.getItem(attributes.getSelectionIndex());
					WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new AddAffectedAttributeGraphBTWizard(c,s,selected));
					if(wizardDialog.open() == Window.OK) {
						return;
					}
				}
			});
			gridData =
					new GridData(
							GridData.END);
			Button addAttributes = new Button(container, SWT.NULL);
			addAttributes.setText("+");
			addAttributes.setLayoutData(gridData);
			Button deleteAttributes = new Button(container, SWT.NULL);
			deleteAttributes.setText("-");
			deleteAttributes.setLayoutData(gridData);
			addAttributes.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					WizardDialog sWizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new AddAffectedAttributeGraphBTWizard(c,s,null));
					System.out.println("Jumlah state "+c.getState().size()+" "+s);
					if(sWizardDialog.open() == Window.OK) {
						attributes.removeAll();
						for(Information atts: s.getAttributes().getInfo()) {
							attributes.add(atts.getKey());
						}
					}
				}
			});
			deleteAttributes.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					final String selected = attributes.getItem(attributes.getSelectionIndex());
					IWorkbenchPage page=PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getActivePage();
			        DiagramEditor ds;
			        if(page.getActiveEditor() instanceof DiagramEditor) {
			        	 ds = (DiagramEditor)page.getActiveEditor();	
			        }
			        else {
			        	ds = ((MultiPageEditor)page.
			        			getActiveEditor()).getDiagramEditor();
			        }
			        Command cmd;
					cmd = new RecordingCommand(ds.getEditingDomain(), "Remove affected attribute") {
						protected void doExecute() {
							s.getAttributes().removeKey(selected);
					    }
					};
					TransactionalEditingDomain f = ds.getEditingDomain();
					f.getCommandStack().execute(cmd);
					
					
					attributes.removeAll();
					for(Information atts: s.getAttributes().getInfo()) {
						attributes.add(atts.getKey());
					}
				}
			});
			dialogChanged();
		} else  {
			setPageComplete(false);
		}
		stateNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(State.NAME_VALUE, t.getText());
				dialogChanged();
			}
	    });
		stateDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(State.DESC_VALUE, t.getText());
			}
	    });
		stateRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(State.ID_VALUE, t.getText());
				dialogChanged();
			}
	    });
		setControl(container);
	}
	private void dialogChanged() {
		if(stateNameText.getText().trim().length() == 0) {
    		changeDialog("Name can not be empty!");
    	} else if(stateRefText.getText().trim().length() == 0) {
    		changeDialog("State ref can not be empty!");
    	} else if(GraphBTUtil.getStateFromComponentByRef(c,stateRefText.getText().trim())!=null) {
    		if(GraphBTUtil.getStateFromComponentByRef(c,stateRefText.getText().trim())!=s) {
    			changeDialog("State is already exist!");
    		}
    	} else {
    		changeDialog(null);
    	}
	}
	private void changeDialog(String message) {
		setErrorMessage(message);
		setPageComplete(message==null);
	}
}
