package behaviortree.graphBT.wizards.createrequirement;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import behaviortree.GraphBTUtil;
import behaviortree.Requirement;

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
		requirementNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		final Label componentRefLabel = new Label(container, SWT.NULL);
		componentRefLabel.setText("Requirement Ref:");

		requirementRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		requirementRefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));		
		requirementRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
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
		requirementDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		requirementNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_NAME, t.getText());
			}
	    });
		
		requirementRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_KEY, t.getText());
			}
	    });
		

		requirementDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Requirement.REQUIREMENT_DESC, t.getText());
			}
	    });

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
		
		if (GraphBTUtil.getRequirement(GraphBTUtil.getBEModel(d), requirementRefText.getText()) != null) {
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