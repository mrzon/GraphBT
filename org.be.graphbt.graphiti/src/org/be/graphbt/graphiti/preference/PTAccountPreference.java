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


public class PTAccountPreference extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Composite container;
	private Text tokenText;

	public PTAccountPreference() {
		// TODO Auto-generated constructor stub
	}

	public PTAccountPreference(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public PTAccountPreference(String title, ImageDescriptor image) {
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

		final Label tokenLabel = new Label(container, SWT.NULL);
		tokenLabel.setText("Pivotal Tracker Token: ");
		

		tokenText = new Text(container, SWT.BORDER | SWT.SINGLE);
		tokenText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		tokenText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			//	dialogChanged();
			}
		});
		String [] defaults = (Activator.getDefault().getGitAccountPreference());

		if(defaults!=null){
			this.tokenText.setText(defaults[0]);
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
		if(defaults!=null){
		this.tokenText.setText(defaults[0]);
		}
	}
	/** 
	 * Method declared on IPreferencePage. Save the
	 * author name to the preference store.
	 */
	public boolean performOk() {
		String [] defaults = new String[2];
		defaults[0] = this.tokenText.getText();
		Activator.getDefault().setGitAccountPreference(defaults);
		return super.performOk();
	}
}
