package behaviortree.graphBT.wizards.createcomponent;

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

import behaviortree.Component;
import behaviortree.GraphBTUtil;

/**
 * Class to define the contents of create component wizard
 * @author GraphBT Team
 *
 */
public class CreateComponentFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private Text componentNameText;
	private Text componentRefText;
	private Text componentDescText;

	  
	public CreateComponentFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Create Component Wizard");		
		setTitle("Create Component Wizard");
		setDescription("Fill in the Component elements below.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

	    final Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("Component Name:");
		
		componentNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		componentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		final Label componentRefLabel = new Label(container, SWT.NULL);
		componentRefLabel.setText("Component Ref:");		
		
		componentRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		componentRefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		componentRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		componentNameText.setText("");
		
		componentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Component.NAME_VALUE, t.getText());
			}
	    });
		
		componentRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Component.REF_VALUE, t.getText());
			}
	    });
		
		final Label componentDescLabel = new Label(container, SWT.NULL);
		componentDescLabel.setText("Description:");
					   
		componentDescText = new Text(container, SWT.WRAP
		          | SWT.MULTI
		          | SWT.BORDER
		          | SWT.V_SCROLL);
		GridData gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 1;
			    gridData.grabExcessVerticalSpace = true;
			    
		componentDescText.setLayoutData(gridData);
		componentDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Component.DESC_VALUE, t.getText());
			}
	    });

		//System.out.println("stringCarrier[0] " + stringCarrier[0]);
		System.out.println("stringCarrier[0].getText() " + componentNameText.getText());
		// Required to avoid an error in the system
		setControl(container);
	}
	
	private void dialogChanged() {
		
		if (componentNameText.getText().length() == 0) {
			updateStatus("Component name must be specified");
			return;
		}
		
		if (componentRefText.getText().length() == 0) {
			updateStatus("Component reference must be specified");
			return;
		}
		
		if (GraphBTUtil.getComponentByRef(GraphBTUtil.getBEModel(d), componentRefText.getText()) != null) {
			updateStatus("Component reference is already exist");
			return;
		}

		if (!(componentRefText.getText().matches("C[a-zA-Z0-9]+"))) {
			updateStatus("Format of component should be start with 'C'");
			return;
		}			

		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
}