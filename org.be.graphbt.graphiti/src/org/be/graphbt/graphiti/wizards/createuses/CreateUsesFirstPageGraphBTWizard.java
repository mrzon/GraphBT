package org.be.graphbt.graphiti.wizards.createuses;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Diagram;
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
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.graphiti.GraphBTUtil;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateUsesFirstPageGraphBTWizard extends WizardPage {
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Combo libraryCombo;
	private Diagram d;
	public CreateUsesFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c,Diagram d) {
		super("Add Use Library Wizard");
		setTitle("Add use library wizard");
		setDescription("Choose library to be used by component "+c.getComponentName());
		this.map = map;
		this.c=c;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label libraryLabel = new Label(container, SWT.NULL);
		libraryLabel.setText("Select library that you want to use:");
		//libraryLabel.setLayoutData(layout);
		libraryCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		libraryCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		EList<Library> libs = GraphBTUtil.getBEModel(d).getLibraries().getImport();
		EList<Library> aLibs = c.getUses();
		
		for(int i = 0; i < libs.size(); i++) {
			boolean exist = false;
			for(int j = 0; j < aLibs.size(); j++) {
				if(libs.get(i).getId().equals(aLibs.get(j).getId())) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				libraryCombo.add(libs.get(i).getId());
			}
		}
	    //map.put(0, "Int");
	    libraryCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	map.put(0, selected);
		    	dialogChanged();
		     }
	    });
		// Required to avoid an error in the system
		setPageComplete(false);
		setControl(container);
	}
	
	private void dialogChanged() {
		if (map.get(0) == null) {
			updateStatus("Select library");
			return;
		}
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
}