package org.be.graphbt.graphiti.preference;

import java.util.ArrayList;
import java.util.Enumeration;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;

public class ManageLibrary extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Composite container;
	private Text filterText;

	public ManageLibrary() {
		// TODO Auto-generated constructor stub
	}

	public ManageLibrary(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ManageLibrary(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
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
		GridLayout layout = new GridLayout(3, false);
		container.setLayout(layout);
		GridData gridData;
		final ArrayList<Library> availableLib = new ArrayList<Library>();
		final ArrayList<String> usedLib = new ArrayList<String>();
		Bundle bundle = Platform.getBundle("org.be.graphbt.common");
		Enumeration<String> listLib = bundle.getEntryPaths("/files/lib");
		/*
		 * Available Library
		 */
		final List listAvailable = new List(container, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;		
		listAvailable.setLayoutData(gridData);
		while(listLib.hasMoreElements())
		{
			String po = listLib.nextElement();
			if(!po.endsWith(".zip"))
			{
				continue;
			}
			Library l = GraphBTUtil.getBEFactory().createLibrary();
			l.setName(po.substring(po.lastIndexOf("/")+1));
			l.setLocation(po);
			availableLib.add(l);
			listAvailable.add(l.getName());
		}

		listAvailable.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				//selectedAdd = listAvailable.getItem(listAvailable.getSelectionIndex());
			}
		});
		return container;
	}

}
