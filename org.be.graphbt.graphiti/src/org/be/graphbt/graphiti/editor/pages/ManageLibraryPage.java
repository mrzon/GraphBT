package org.be.graphbt.graphiti.editor.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.be.graphbt.common.ProjectUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.MethodDeclaration;
import org.be.graphbt.model.graphbt.Parameter;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ManageLibraryPage extends Composite{

	private Composite container;
	private HashMap<Integer,String> map;
	private Diagram d;
	private Text filterText;
	private String selectedAdd;
	private BEModel model;
	private String selectedRemove;
	private DiagramEditor ds;
	public ManageLibraryPage(Composite parent, int style, DiagramEditor d2) {
		super(parent, style);
		this.ds = d2;
		init();
	}

	public void init() {
		model = GraphBTUtil.getBEModel(ds.getDiagramTypeProvider().getDiagram(),false);
		GridLayout layout = new GridLayout(3, false);
		this.setLayout(layout);
		GridData gridData;
		final EList<Library> availableLib = GraphBTUtil.availableLibraries.getImport();
		final ArrayList<String> usedLib = new ArrayList<String>();
		Bundle bundle = Platform.getBundle("org.be.graphbt.common");
		Enumeration<String> listLib = bundle.getEntryPaths("files/lib/dist");


		/*
		 * Filter
		 */

		final Label filterLabel = new Label(this, SWT.NULL);
		filterLabel.setText("Filter:");
		gridData = new GridData();
		gridData.horizontalSpan = 3;
		filterLabel.setLayoutData(gridData);

		filterText = new Text(this, SWT.BORDER | SWT.SINGLE);
		gridData = new GridData();
		gridData.widthHint = 200;
		gridData.horizontalSpan = 3;
		filterText.setLayoutData(gridData);		


		/*
		 * Available Library
		 */
		final List listAvailable = new List(this, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;		
		listAvailable.setLayoutData(gridData);
		
		for(Library l:availableLib) {
			if(l.getId()!=null) {
				listAvailable.add(l.getId());
			}
		}
		listAvailable.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(listAvailable.getSelectionIndex()>=0&&listAvailable.getSelectionIndex()<listAvailable.getItemCount()) {
					selectedAdd = listAvailable.getItem(listAvailable.getSelectionIndex());
				}
			}
		});

		/*
		 * Right Button: ->
		 */
		Button rightButton = new Button(this, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;

		rightButton.setLayoutData(gridData);
		rightButton.setText("->");


		/*
		 * Selected Library
		 */
		final List listSelected = new List(this, SWT.BORDER | SWT.V_SCROLL);
		gridData =
				new GridData(
						GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
		gridData.horizontalSpan = 1;
		gridData.verticalSpan = 3;
		gridData.heightHint = 200;
		gridData.widthHint = 200;
		//gridData.grabExcessVerticalSpace = true;

		listSelected.setLayoutData(gridData);
		listSelected.removeAll();
		if(model!=null && model.getLibraries()!=null) {
		for(Library r:model.getLibraries().getImport()) {
			listSelected.add(r.getId());
		}
		}
		listSelected.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if(listSelected.getSelectionIndex() > listSelected.getSelectionCount()) {
					selectedRemove = null;
					return;
				}
				selectedRemove = listSelected.getItem(listSelected.getSelectionIndex());
			}
		});

		/*
		 * Left Button: <-			
		 */

		Button leftButton = new Button(this, SWT.NULL);
		gridData = new GridData();
		gridData.widthHint = 35;
		//gridData.grabExcessHorizontalSpace = true;	
		leftButton.setLayoutData(gridData);
		leftButton.setText("<-");


		/*
		 * Action List
		 */		

		filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String text = ((Text)e.widget).getText();
				listAvailable.removeAll();
				for(int i = 0; i < availableLib.size(); i++) {
					if(availableLib.get(i).getId().contains(text)) {
						listAvailable.add(availableLib.get(i).getId());
					}
				}
			}
		});

		leftButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int index = listSelected.getSelectionIndex();
				if(index > listSelected.getItemCount()) {
					return;
				}
				selectedRemove = listSelected.getItem(index);
				if(model==null)
					return;
				for(int i = 0; i < model.getLibraries().getImport().size(); i++) {
					if(selectedRemove.equals(model.getLibraries().getImport().get(i).getId())) {
						listSelected.remove(selectedRemove);
						final Library sel = model.getLibraries().getImport().get(i);
						final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Remove Import") {
							protected void doExecute() {
								model.getLibraries().getImport().remove(sel);
							}
						};
						ds.getEditingDomain().getCommandStack().execute(cmd);
						selectedRemove = null;
						break;
					}
				}
			}
		});
		rightButton.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("restriction")
			public void widgetSelected(SelectionEvent event) {
				if(selectedAdd==null) {
					return;
				}
				for(int i = 0; i < availableLib.size(); i++) {
					if(selectedAdd.equals(availableLib.get(i).getId())){
						String included[] = listSelected.getItems();
						for(int j = 0; j < included.length; j++) {
							if(selectedAdd.equals(included[j])) {
								return;
							}
						}
						Log.info(1, "ManageLibrary, new import is inserted");
						listSelected.add(selectedAdd);
						final Library sel = EcoreUtil.copy(availableLib.get(i));
						final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Add Import") {
							protected void doExecute() {
								model.getLibraries().getImport().add(sel);
							}
						};
						ds.getEditingDomain().getCommandStack().execute(cmd);
						break;
					}

				}
			}
		});
	}

}
