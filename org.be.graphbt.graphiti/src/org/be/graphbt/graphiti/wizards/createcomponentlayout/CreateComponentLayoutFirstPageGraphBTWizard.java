package org.be.graphbt.graphiti.wizards.createcomponentlayout;

import java.util.HashMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.graphiti.GraphBTUtil;

/**
 * Class to define the contents of create behavior wizard
 * @author GraphBT Team
 *
 */
public class CreateComponentLayoutFirstPageGraphBTWizard extends WizardPage {
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Combo componentCombo;
	private Diagram d;
	public CreateComponentLayoutFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		super("Add component layout");
		setTitle("Add component layout to the diagram");
		setDescription("Choose component that want to be added");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		final BEModel model = GraphBTUtil.getBEModel(d);
		final Label componentLabel = new Label(container, SWT.NULL);
		componentLabel.setText("Select component:");
		//libraryLabel.setLayoutData(layout);
		componentCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		componentCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		EList<Component> components = model.getComponentList().getComponents();
		Assert.isNotNull(model.getLayoutList(), "Add Layout first before adding component layout");
		EList<Layout> aLibs = model.getLayoutList().getLayouts();
		
		for(int i = 0; i < components.size(); i++) {
			boolean exist = false;
			Image image = GraphBTUtil.getComponentImageDescription(components.get(i));
			if(image != null) {
				for(int j = 0; j < aLibs.size(); j++) {
					if(components.get(i).getComponentRef().equals(aLibs.get(j).getCRef())) {
						exist = true;
						break;
					}
				}
				if(!exist) {
					componentCombo.add(components.get(i).getComponentName());
				}
			}
		}
	    //map.put(0, "Int");
	    componentCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	Component c = GraphBTUtil.getComponent(model, selected);
		    	map.put(Component.REF_VALUE,c.getComponentRef());
		    	dialogChanged();
		     }
	    });
		// Required to avoid an error in the system
		setPageComplete(false);
		setControl(container);
	}
	
	private void dialogChanged() {
		if (map.get(Component.REF_VALUE) == null) {
			updateStatus("Select component");
			return;
		}
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
}