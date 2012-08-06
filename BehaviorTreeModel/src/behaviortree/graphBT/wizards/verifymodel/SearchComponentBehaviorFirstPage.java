package behaviortree.graphBT.wizards.verifymodel;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.graphBT.wizards.createbehavior.CreateBehaviorGraphBTWizard;
import behaviortree.graphBT.wizards.managecomponents.ManageComponentsGraphBTWizard;


public class SearchComponentBehaviorFirstPage extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;

	
	public SearchComponentBehaviorFirstPage(HashMap<Integer,String> map, Diagram d) {
		super("Verify Model");
		setTitle("Verify Model");
		setDescription("Verify the model of behavior tree using LTL formula.");
		this.map = map;
		this.d=d;
	}

	/**
	 * implementation of user interface drawing.
	 */
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		//---ui1---------------------------------------
	    GridData gridData;
	    
	    GridLayout gLayout = new GridLayout();
	    container.setLayout(gLayout);
	    
	    // label ui components
	    Label label = new Label(container, SWT.CENTER);
	    label.setText("Please select component:");
	    // single text field
	    Text textField;
	    textField = new Text(container, SWT.SINGLE | SWT.BORDER);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    textField.setLayoutData(gridData);
	    
	    // list
	    List list = new List(container, SWT.V_SCROLL | SWT.BORDER | SWT.H_SCROLL);
	    gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    list.setLayoutData(gridData);
	    
	    list.select(list.getItemCount()-1);
	    list.showSelection();
		
		setControl(container);
		
		
	}
}