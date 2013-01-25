package org.be.graphbt.graphiti.wizards.createattribute;

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
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;

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
	private Attribute a;
	public CreateAttributeFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c, Attribute a) {
		super("Create Attribute Wizard");
		setTitle("Create Attribute Wizard");
		setDescription("Fill in the form below to add new Attribute to component "+c.getComponentName());
		this.map = map;
		this.c=c;
		this.a=a;
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
		
	    typeCombo.add("Int");
	    typeCombo.add("String");
	    typeCombo.add("Bool");
	    typeCombo.select(0);
	    map.put(Attribute.TYPE_VALUE, "Int");
	    typeCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(Attribute.TYPE_VALUE, selected);
		    	dialogChanged();
		     }
	    });
	    final Label attributeLabel = new Label(container, SWT.NULL);
		attributeLabel.setText("Attribute Name:");
		
		attributeNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		attributeNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Label attributeRefLabel = new Label(container, SWT.NULL);
		attributeRefLabel.setText("Value:");
		
		attributeValueText = new Text(container, SWT.BORDER | SWT.SINGLE);
		attributeValueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
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
				dialogChanged();
			}
	    });
		
		attributeValueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.VAL_VALUE, t.getText());
				dialogChanged();
			}
	    });
		attributeDescText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.DESC_VALUE, t.getText());
			}
	    });
		if(a!=null) {
			attributeNameText.setText(a.getName());
			typeCombo.select(typeCombo.indexOf(a.getType()));
			attributeDescText.setText(a.getDesc()==null?"":a.getDesc());
			attributeValueText.setText(a.getValue()==null?"":a.getValue());
			System.out.println("A is not null");
			map.put(Attribute.TYPE_VALUE, a.getType());
			map.put(Attribute.NAME_VALUE, a.getName());
			map.put(Attribute.DESC_VALUE, attributeDescText.getText());
			map.put(Attribute.VAL_VALUE, attributeValueText.getText());
			dialogChanged();
		}
		else 
		{
			System.out.println("A is null");
		}
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
		if (!attributeNameText.getText().trim().matches("[a-z][0-9a-zA-Z]*")) {
			updateStatus("name is not valid");
			return;
		}
		Attribute a1 = GraphBTUtil.getAttributeFromComponentByName(c, attributeNameText.getText());
		if (a1 != null) {
			if(a==null||a!=null&&a!=a1) {
				updateStatus("Attribute name is already exist");
			return;}
		}
		String type = map.get(Attribute.TYPE_VALUE);
		if((attributeValueText.getText()!=null && !attributeValueText.getText().trim().equals(""))&&type!=null) {
			if(type.equals("Int")) {
				System.out.println();
				if (!attributeValueText.getText().trim().matches("\\-?[0-9]+")) {
					updateStatus("Value should be integer");
					return;
				}
			}
			else if(type.equals("Bool")) {
				if (!(attributeValueText.getText().trim().equals("True")||attributeValueText.getText().trim().equals("False"))) {
					updateStatus("Value should be either True or False");
					return;
				}
			}
		}
				
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
}