package org.be.graphbt.graphiti.wizards.addcode;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class AddCodeFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private List varList;
	private Text absCodeText;
	private Behavior b;
	public AddCodeFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c, Behavior b) {
		super("Create Attribute Wizard");
		setTitle("Create Attribute Wizard");
		setDescription("Fill in the form below to add new Attribute to component "+c.getComponentName());
		this.map = map;
		this.c=c;
		this.b=b;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("List of available atributes:");
	    final Label attributeLabel = new Label(container, SWT.NULL);
		attributeLabel.setText("ABS Code:");
		
		varList = new List(container, SWT.BORDER | SWT.V_SCROLL);
		for(Attribute att: c.getAttributes()) {
			varList.add(att.toString());
		}
		

		absCodeText = new Text(container, SWT.WRAP
		          | SWT.BORDER
		          | SWT.H_SCROLL
		          | SWT.MULTI
		          | SWT.V_SCROLL);

		GridData gridData =
				new GridData(GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		gridData.heightHint = 150;
		gridData.widthHint = 200;
		absCodeText.setLayoutData(gridData);	    
		absCodeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Behavior.DETAIL_VALUE, t.getText());
			}
	    });
		if(b!=null) {
			absCodeText.setText(b.getTechnicalDetail()==null?"":b.getTechnicalDetail());
		}
		// Required to avoid an error in the system
		setControl(container);
	}
	
	private void dialogChanged() {
		/**
		 * the code in add code area is need to be parsed here
		 */
		/*if (attributeNameText.getText().trim().length() == 0) {
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
		}*/		
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
}