package behaviortree.graphBT.wizards.createattribute;

import java.util.HashMap;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import behaviortree.Attribute;
import behaviortree.Component;
import behaviortree.GraphBTUtil;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateAttributeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Text attributeNameText;
	private Text attributeValueText;
	private Text attributeDescText;
	private Combo typeCombo;
	
	public CreateAttributeFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c) {
		super("Create Attribute Wizard");
		setTitle("Create Attribute Wizard");
		setDescription("Fill in the form below to add new Attribute to component "+c.getComponentName());
		this.map = map;
		this.c=c;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("Attribute Type:");
		
		typeCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    typeCombo.add("String");
	    typeCombo.add("Int");
	    typeCombo.add("Bool");
	    
	    typeCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(Attribute.TYPE_VALUE, selected);
		     }
	    });
	    final Label attributeLabel = new Label(container, SWT.NULL);
		attributeLabel.setText("Attribute Name:");
		
		attributeNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		attributeNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		attributeNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		final Label attributeRefLabel = new Label(container, SWT.NULL);
		attributeRefLabel.setText("Value:");
		
		attributeValueText = new Text(container, SWT.BORDER | SWT.SINGLE);
		attributeValueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		attributeValueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		final Label attributeDescLabel = new Label(container, SWT.NULL);
		attributeDescLabel.setText("Description:");
					   
		attributeDescText = new Text(container, SWT.WRAP
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.V_SCROLL);
		GridData gridData =
			      new GridData(
			        GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
			    gridData.horizontalSpan = 1;
			    gridData.grabExcessVerticalSpace = true;
			    
		attributeDescText.setLayoutData(gridData);
			    
		attributeNameText.setText("");
		
		attributeNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.NAME_VALUE, t.getText());
			}
	    });
		
		attributeValueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.VAL_VALUE, t.getText());
			}
	    });
		attributeDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.DESC_VALUE, t.getText());
			}
	    });

		// Required to avoid an error in the system
		setControl(container);
	}
	
	private void dialogChanged() {
		if (attributeNameText.getText().trim().length() == 0) {
			updateStatus("Attribute name must be specified");
			return;
		}
		if (attributeNameText.getText().trim().contains(" ")) {
			updateStatus("Space character is illegal");
			return;
		}
		if (GraphBTUtil.getAttributeFromComponentByName(c, attributeNameText.getText()) != null) {
			updateStatus("Attribute name is already exist");
			return;
		}		
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
}