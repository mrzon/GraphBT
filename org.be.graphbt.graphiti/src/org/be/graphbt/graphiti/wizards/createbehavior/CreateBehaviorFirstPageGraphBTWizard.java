package org.be.graphbt.graphiti.wizards.createbehavior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.State;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.wizards.addcode.AddCodeGraphBTWizard;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateBehaviorFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Combo behaviorNameText;
	private Text behaviorRefText;
	private Text behaviorDescText;
	private Combo behaviorTypeCombo;
	private Button addCodeButton; 
	private Behavior b;
	public CreateBehaviorFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c, Behavior b) {
		super("Create Behavior Wizard");
		setTitle("Create Behavior Wizard");
		if(c!=null) {
			setDescription("Fill in the form below to add new Behavior to component "+c.getComponentName());
		}
		this.map = map;
		this.c = c;
		this.b = b;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("Behavior Type:");
		
		behaviorTypeCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		behaviorTypeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(BehaviorType t : BehaviorType.VALUES) {
	    	behaviorTypeCombo.add(t.getName());
	    }
	    
	    final Label behaviorLabel = new Label(container, SWT.NULL);
		behaviorLabel.setText("Behavior Name:");

		behaviorNameText = new Combo(container, SWT.BORDER | SWT.SINGLE);
		behaviorNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		HashSet<String> arr = new HashSet<String>();
		for (State state : c.getState()) {
			arr.add(state.getName());
		}
		for (Attribute a : c.getAttributes()) {
			arr.add(a.getName());
		}
		for (Behavior b : c.getBehaviors()) {
			arr.add(b.getBehaviorName());
		}
		for (String string : arr) {
			behaviorNameText.add(string);
		}
		Arrays.sort(behaviorNameText.getItems());
		final Label behaviorRefLabel = new Label(container, SWT.NULL);
		behaviorRefLabel.setText("Behavior Ref:");
		
		behaviorRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorRefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Label behaviorDescLabel = new Label(container, SWT.NULL);
		behaviorDescLabel.setText("Description:");
					   
		behaviorDescText = new Text(container, SWT.WRAP
		          | SWT.MULTI
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.V_SCROLL);
		GridData gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 1;
			    gridData.grabExcessVerticalSpace = true;
			    
		behaviorDescText.setLayoutData(gridData);
			    
		behaviorNameText.setText("");
		
		behaviorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Combo t = (Combo) e.widget;
				map.put(Behavior.NAME_VALUE, t.getText());
				dialogChanged();
			}
	    });
		
		behaviorRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Behavior.REF_VALUE, t.getText());
				dialogChanged();
			}
	    });
		behaviorDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Behavior.DESC_VALUE, t.getText());
			}
	    });
		addCodeButton = new Button(container, SWT.NULL);
		//addCodeButton.setLayoutData(layout);
		addCodeButton.setText("Add Code");
		addCodeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {				
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						new AddCodeGraphBTWizard(map,c,b));
				if(wizardDialog.open() == Window.OK) {
					return;
				}
			}
		});
		addCodeButton.setVisible(false);
		if(b!=null) {
			behaviorTypeCombo.select(b.getBehaviorType().getValue());
			behaviorTypeCombo.setEnabled(false);
			behaviorNameText.setText(b.getBehaviorName());
			if(b.getBehaviorType().getValue()==BehaviorType.STATE_REALIZATION_VALUE || 
					b.getBehaviorType().getValue()==BehaviorType.GUARD_VALUE || 
					b.getBehaviorType().getValue()==BehaviorType.SELECTION_VALUE) {
	    		addCodeButton.setVisible(true);
	    	} else {
	    		addCodeButton.setVisible(false);
	    	}
			behaviorDescText.setText(b.getBehaviorDesc()==null?"":b.getBehaviorDesc());
			behaviorRefText.setText(b.getBehaviorRef());
			//behaviorRefText.setEnabled(false);
			dialogChanged();
		}
		
		behaviorTypeCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(Behavior.TYPE_VALUE, selected);
		    	if(combo.getSelectionIndex()==BehaviorType.STATE_REALIZATION_VALUE || 
		    			combo.getSelectionIndex()==BehaviorType.GUARD_VALUE || 
		    					combo.getSelectionIndex()==BehaviorType.SELECTION_VALUE) {
		    		addCodeButton.setVisible(true);
		    	} else {
		    		addCodeButton.setVisible(false);
		    	}
		    	dialogChanged();
		    }
	    });
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}
	
	private void dialogChanged() {
		
		if (behaviorNameText.getText().trim().length() == 0) {
			updateStatus("Behavior name must be specified");
			return;
		}
		if (behaviorNameText.getText().trim().contains(" ")) {
			updateStatus("Space character is illegal");
			return;
		}
		if (!behaviorNameText.getText().trim().matches("^[a-zA-Z].*")) {
			updateStatus("Behavior name is illegal");
			return;
		}
		if (behaviorRefText.getText().trim().length() == 0) {
			if(b==null)
			updateStatus("Behavior reference must be specified");
			return;
		}
		if (!behaviorRefText.getText().trim().matches("[0-9]+")) {
			updateStatus("Behavior reference must be integer");
			return;
		}
		if (GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefText.getText()) != null) {
			if(b==null) {
				updateStatus("Behavior reference is already exist");
				return;
			}
		}
		Behavior temp = GraphBTUtil.getBEFactory().createBehavior();
		temp.setBehaviorName(behaviorNameText.getText());
		temp.setBehaviorType(BehaviorType.get(behaviorTypeCombo.getSelectionIndex()));
		if (GraphBTUtil.getBehaviorFromComponent(c, temp.toString()) != null) {
			if(b==null || (b!=null&&!temp.toString().equals(b.toString())))
			updateStatus("Name with the same type is already exists");
			return;
		}
		if(map.get(Behavior.TYPE_VALUE)==null) {
			addCodeButton.setVisible(true);
		}
		else 
		{
			addCodeButton.setVisible(true);
			if(map.get(Behavior.TYPE_VALUE).equals("StateRealization")) {
				addCodeButton.setVisible(true);
			}
		}
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
}