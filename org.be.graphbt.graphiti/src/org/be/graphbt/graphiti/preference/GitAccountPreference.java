package org.be.graphbt.graphiti.preference;

import java.util.Arrays;

import org.be.graphbt.graphiti.Activator;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class GitAccountPreference extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Composite container;
	private Text usernameText;
	private Text passwordText;

	public GitAccountPreference() {
		// TODO Auto-generated constructor stub
	}

	public GitAccountPreference(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public GitAccountPreference(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
				
	}

	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label usernameLabel = new Label(container, SWT.NULL);
		usernameLabel.setText("Username: ");
		

		usernameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		usernameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		
	    final Label passwordLabel = new Label(container, SWT.NULL);
		passwordLabel.setText("Password: ");
		
		passwordText = new Text(container, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		passwordText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		String [] defaults = (Activator.getDefault().getGitAccountPreference());

		if(defaults!=null){
			this.passwordText.setText(defaults[1]);
			this.usernameText.setText(defaults[0]);
		}
		return container;
	}

	/**
	 * Performs special processing when this page's Restore Defaults button has been pressed.
	 * Sets the contents of the nameEntry field to
	 * be the default 
	 */
	protected void performDefaults() {
		String [] defaults = (Activator.getDefault().getGitAccountPreference());
		System.out.println("DefaultGitAccount "+Arrays.toString(defaults));

		if(defaults!=null){
		this.passwordText.setText(defaults[1]);
		this.usernameText.setText(defaults[0]);
		}
	}
	/** 
	 * Method declared on IPreferencePage. Save the
	 * author name to the preference store.
	 */
	public boolean performOk() {
		String [] defaults = new String[2];
		defaults[1] = this.passwordText.getText();
		defaults[0] = this.usernameText.getText();
		Activator.getDefault().setGitAccountPreference(defaults);
		return super.performOk();
	}
}
