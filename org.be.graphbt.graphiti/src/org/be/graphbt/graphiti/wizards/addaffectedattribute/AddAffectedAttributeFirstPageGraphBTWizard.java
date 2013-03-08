package org.be.graphbt.graphiti.wizards.addaffectedattribute;

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
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.State;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class AddAffectedAttributeFirstPageGraphBTWizard extends WizardPage {
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Text attributeNameText;
	private Text attributeValueText;
	private Combo attributesCombo;
	private State s;
	private String attributeName;
	public AddAffectedAttributeFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c, State s, String a) {
		super("Choose affected attribute Wizard");
		setTitle("Choose Attribute Wizard");
		setDescription("Fill in the form below to add new affected attribute to state \""+s.getName()+"\"");
		this.map = map;
		this.c=c;
		this.s=s;
		attributeName = a;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("Attribute name:");
		
		attributesCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		attributesCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final Label tLabel = new Label(container, SWT.NULL);
		tLabel.setText("Attribute type:");
		final Text typeText = attributeValueText = new Text(container, SWT.BORDER | SWT.SINGLE);
		typeText.setEnabled(false);
		typeText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		for(Attribute att : c.getAttributes()) {
			if(s.getAttributes().getValue(att.getName())==null) {
				attributesCombo.add(att.getName());	
			}
		}
		Attribute at = GraphBTUtil.getAttributeFromComponentByName(c, attributesCombo.getItem(0));
    	map.put(Attribute.TYPE_VALUE, at.getType());
    	typeText.setText(at.getType());
	    attributesCombo.select(0);
	    attributesCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	Attribute a = GraphBTUtil.getAttributeFromComponentByName(c, selected);
		    	map.put(Attribute.TYPE_VALUE, a.getType());
		    	typeText.setText(a.getType());
			    map.put(Attribute.NAME_VALUE, a.getName());
		    	dialogChanged();
		     }
	    });
		final Label attributeRefLabel = new Label(container, SWT.NULL);
		attributeRefLabel.setText("Value:");
		attributeValueText = new Text(container, SWT.BORDER | SWT.SINGLE);
		attributeValueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		attributeValueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Attribute.VAL_VALUE, t.getText());
				dialogChanged();
			}
	    });
		if(attributeName!=null) {
			Attribute a = GraphBTUtil.getAttributeFromComponentByName(c, attributeName);
	    	System.out.println(a);
	    	attributesCombo.removeAll();
	    	attributesCombo.add(attributeName);
			attributesCombo.setText(attributeName);
			
			typeText.setText(a.getType());
			attributeValueText.setText(s.getAttributes().getValue(attributeName));
			map.put(Attribute.NAME_VALUE, a.getName());
			map.put(Attribute.VAL_VALUE, attributeValueText.getText());
			map.put(Attribute.TYPE_VALUE, a.getType());
			attributesCombo.setEnabled(false);
		}
		setControl(container);
	}
	
	private void dialogChanged() {
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