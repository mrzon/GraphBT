package behaviortree.graphBT.wizards.requirementCompactView;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
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
public class RequirementCompactViewFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private StyledText requirementText;
	private String text = "";
	
	public RequirementCompactViewFirstPageGraphBTWizard(HashMap<Integer,String> map, Diagram d) {
		
		super("Requirement Compact View Wizard");		
		setTitle("Requirement Compact View Wizard");
		setDescription("List all of requirements.");
		this.map = map;
		this.d=d;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(1, false);
		container.setLayout(layout);
		GridData gridData;	   	    
	    
		requirementText = new StyledText(container, SWT.WRAP
				| SWT.MULTI
				| SWT.BORDER
				| SWT.H_SCROLL
				| SWT.V_SCROLL);
		//requirementText.setBounds(10, 10, 200, 200);
		gridData = new GridData ( GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL);
		gridData.heightHint = 200;
		gridData.widthHint = 400;
		requirementText.setLayoutData(gridData);
		requirementText.setEditable(false);
		
		 StyleRange style = new StyleRange();
		 style.foreground = container.getDisplay().getSystemColor(SWT.COLOR_RED);
		 requirementText.setStyleRange(style);
		    
//		StyleRange style = new StyleRange();
//	    style.background = getShell().getDisplay().getSystemColor(SWT.COLOR_RED);
//	    requirementText.setStyleRange(style);
	    
		for(Requirement requirement: GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()){
			
			//text += requirement.getKey() + " " + requirement.getDescription() + "\n\n";
			
			requirementText.setText(requirementText.getText() + requirement.getKey() + " " + requirement.getDescription() + "\n\n");					
		}		
		
		
//		requirementText.setText(text);

		setControl(container);
	}
	
	
}