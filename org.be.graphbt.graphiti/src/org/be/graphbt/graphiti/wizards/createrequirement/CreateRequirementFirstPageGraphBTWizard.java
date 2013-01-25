package org.be.graphbt.graphiti.wizards.createrequirement;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Requirement;

/**
 * Class to define the contents of create requirement wizard
 * @author GraphBT Team
 *
 */
public class CreateRequirementFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private Text requirementNameText;
	private Text requirementRefText;
	private Text requirementDescText;
	
	public CreateRequirementFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		
		super("Create Requirement Wizard");		
		setTitle("Create Requirement Wizard");
		setDescription("Fill in the requirement elements below.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);	

	    final Label requirementLabel = new Label(container, SWT.NULL);
	    requirementLabel.setText("Requirement Name:");
		
	    requirementNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
	    requirementNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));		
		final Label componentRefLabel = new Label(container, SWT.NULL);
		componentRefLabel.setText("Requirement Ref:");

		requirementRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		requirementRefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));		
		
		final Label requirementDescLabel = new Label(container, SWT.NULL);
		requirementDescLabel.setText("Requirement Description:");
			    
		requirementDescText = new Text(container, SWT.WRAP
		          | SWT.MULTI
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.V_SCROLL);
		GridData gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 1;
			    gridData.grabExcessVerticalSpace = true;
			    
		requirementDescText.setLayoutData(gridData);
		
		requirementNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_NAME, t.getText());
				dialogChanged();
			}
	    });
		
		requirementRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_KEY, t.getText());
				dialogChanged();
			}
	    });
		

		requirementDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_DESC, t.getText());
				dialogChanged();
			}
	    });

		
		
		dialogChanged();
		setControl(container);
	}
	
	private void dialogChanged() {
	
		if (requirementNameText.getText().length() == 0) {
			updateStatus("Requirement name must be specified");
			return;
		}
		
		if (requirementRefText.getText().length() == 0) {
			updateStatus("Requirement key must be specified");
			return;
		}
		
		if (GraphBTUtil.getRequirement(d, requirementRefText.getText()) != null) {
			updateStatus("Requirement key already exist");
			return;
		}

		if (!(requirementRefText.getText().matches("R[0-9]+"))) {
			updateStatus("Format of requirement key should be 'R' followed by number (e.g.: R1)");
			return;
		}
		
		if (requirementDescText.getText().length() == 0) {
			updateStatus("Requirement description must be specified");
			return;
		}
	
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
}