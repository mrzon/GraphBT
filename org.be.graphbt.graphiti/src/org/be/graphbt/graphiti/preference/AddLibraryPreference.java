package org.be.graphbt.graphiti.preference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.graphiti.Activator;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.*;
/**
 * Class to define the contents of manage component wizard
 * @author GraphBT Team
 *
 */
public class AddLibraryPreference extends PreferencePage implements
IWorkbenchPreferencePage{

	private Composite container;
	private Text filterText;
	private String selectedAdd;
	private BEModel model;
	private String selectedRemove;
	private Text nameText;
	private Text idText;
	private Text absText;
	private Text javaText;
	private Bundle bundle;
	public AddLibraryPreference() {
	}


	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		//super.noDefaultAndApplyButton();
		
	}

	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor)
        {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
		
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(2, true);
		container.setLayout(layout);
		GridData gridData;
		bundle = Platform.getBundle("org.be.graphbt.graphiti.codegenerator");
		//Enumeration<String> listLib = bundle.getEntryPaths("/lib");
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 200;
		gridData.widthHint = 200;
				

		final Label nameLabel = new Label(container, SWT.NULL);
		nameLabel.setText("Name: ");
		

		nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		
	    final Label idLabel = new Label(container, SWT.NULL);
		idLabel.setText("Password: ");
		
		idText = new Text(container, SWT.BORDER | SWT.SINGLE);
		idText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		idText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});		
		final Label javaLabel = new Label(container, SWT.NULL);
		javaLabel.setText("Name: ");
		

		javaText = new Text(container, SWT.BORDER | SWT.SINGLE);
		javaText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		javaText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		
	    final Label absLabel = new Label(container, SWT.NULL);
		absLabel.setText("Password: ");
		
		absText = new Text(container, SWT.BORDER | SWT.SINGLE );
		absText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		absText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		//super.getApplyButton().setText("Finish");
		return (container);
	}
	
	/**
	 * Performs special processing when this page's Restore Defaults button has been pressed.
	 * Sets the contents of the nameEntry field to
	 * be the default 
	 */
	protected void performDefaults() {
		String [] defaults = (Activator.getDefault().getGitAccountPreference());
		 //System.out.println("DefaultGitAccount "+Arrays.toString(defaults));

		if(defaults!=null){
			this.absText.setText("");
			this.idText.setText("");
			this.nameText.setText("");
			this.javaText.setText("");
		}
	}
	/** 
	 * Method declared on IPreferencePage. Save the
	 * author name to the preference store.
	 */
	public boolean performOk() {
		String [] defaults = new String[4];
		defaults[0] = this.nameText.getText();
		defaults[1] = this.idText.getText();
		defaults[2] = this.absText.getText();
		defaults[3] = this.javaText.getText();

		return super.performOk();
	}
	
}
