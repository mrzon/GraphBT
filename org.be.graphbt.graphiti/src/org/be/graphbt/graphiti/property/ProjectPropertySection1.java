package org.be.graphbt.graphiti.property;

import java.util.Iterator;

import org.be.graphbt.graphiti.AccessoryUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.GraphBTDiagramEditor;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.graphiti.wizards.managecomponents.ManageComponentsGraphBTWizard;
import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Branch;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.OperatorClass;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.model.graphbt.TraceabilityStatusClass;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class ProjectPropertySection1 extends GFPropertySection 
implements ITabbedPropertyConstants  {

	public ProjectPropertySection1() {
		// TODO Auto-generated constructor stub
	}
	private Text nameText;
	private Text subtitleText;
	private Text versionText;
	private Text authorText;

	@Override
	public void createControls(Composite parent, 
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData componentData;
		FormData behaviorData;
		FormData requirementData;
		FormData operatorData;
		FormData statusData;
		FormData branchData;

		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final DiagramEditor ds;
		if(page.getActiveEditor() instanceof DiagramEditor) {
			ds = (DiagramEditor)page.getActiveEditor();	
		}
		else {
			ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
		}

		final Diagram d = ds.getDiagramTypeProvider().getDiagram();
		final BEModel model = GraphBTUtil.getBEModel(d);

		nameText = factory.createText(composite,"");
		subtitleText = factory.createText(composite,"");
		versionText = factory.createText(composite,"");
		authorText = factory.createText(composite,"");

		componentData = new FormData();
		componentData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH*2);
		componentData.right = new FormAttachment(100, 0);
		componentData.top = new FormAttachment(0, VSPACE);
		nameText.setLayoutData(componentData);

		CLabel valueLabel2 = factory.createCLabel(composite, "Project Name");
		componentData = new FormData();
		componentData.left = new FormAttachment(0, 0);
		componentData.right = new FormAttachment(nameText, -HSPACE);
		componentData.top = new FormAttachment(nameText, 0, SWT.CENTER);
		valueLabel2.setLayoutData(componentData);

		behaviorData = new FormData();
		behaviorData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		behaviorData.right = new FormAttachment(100, 0);
		behaviorData.top = new FormAttachment(nameText, VSPACE);
		behaviorData.height = CENTER_SPACE *4;
		subtitleText.setLayoutData(behaviorData);

		CLabel valueLabel3 = factory.createCLabel(composite, "Project Description");
		behaviorData = new FormData();
		behaviorData.left = new FormAttachment(0, 0);
		behaviorData.right = new FormAttachment(subtitleText, -HSPACE);
		behaviorData.top = new FormAttachment(subtitleText, 0, SWT.CENTER);
		valueLabel3.setLayoutData(behaviorData);

		requirementData = new FormData();
		requirementData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		requirementData.right = new FormAttachment(100, 0);
		requirementData.top = new FormAttachment(subtitleText, VSPACE);
		versionText.setLayoutData(requirementData);

		CLabel valueLabelReq = factory.createCLabel(composite, "Version");
		requirementData = new FormData();
		requirementData.left = new FormAttachment(0, 0);
		requirementData.right = new FormAttachment(versionText, -HSPACE);
		requirementData.top = new FormAttachment(versionText, 0, SWT.CENTER);
		valueLabelReq.setLayoutData(requirementData);

		operatorData = new FormData();
		operatorData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		operatorData.right = new FormAttachment(100, 0);
		operatorData.top = new FormAttachment(versionText, VSPACE);
		authorText.setLayoutData(operatorData);

		CLabel valueLabel4 = factory.createCLabel(composite, "Author");
		operatorData = new FormData();
		operatorData.left = new FormAttachment(0, 0);
		operatorData.right = new FormAttachment(authorText, -HSPACE);
		operatorData.top = new FormAttachment(authorText, 0, SWT.CENTER);
		valueLabel4.setLayoutData(operatorData);

		nameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				if(!nameText.getText().equals(model.getName())) {
					Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change project name") {
						protected void doExecute() {
							model.setName(nameText.getText());
						}
					};
					TransactionalEditingDomain f = ds.getEditingDomain();
					f.getCommandStack().execute(cmd);
				}
			}
		});
		subtitleText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				if(!subtitleText.getText().equals(model.getSubtitle())) {
					Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change project subtitle") {
						protected void doExecute() {
							model.setSubtitle(subtitleText.getText());
						}
					};
					TransactionalEditingDomain f = ds.getEditingDomain();
					f.getCommandStack().execute(cmd);
				}
			}
		});
		versionText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				if(!versionText.getText().equals(model.getVersion())) {
					Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change project version") {
						protected void doExecute() {
							model.setVersion(versionText.getText());
						}
					};
					TransactionalEditingDomain f = ds.getEditingDomain();
					f.getCommandStack().execute(cmd);
				}
			}
		});

		authorText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change project authors") {
					protected void doExecute() {
						//model.setAauthorText.getText());
					}
				};
				TransactionalEditingDomain f = ds.getEditingDomain();
				f.getCommandStack().execute(cmd);
			}
		});
	}


	@Override
	public synchronized void  refresh() throws RuntimeException{		PictogramElement pe = getSelectedPictogramElement();
		if(pe instanceof Diagram) {
			Diagram d = (Diagram)pe;
			BEModel model = GraphBTUtil.getBEModel(d);
			nameText.setText(model.getName()==null?"":model.getName());
			subtitleText.setText(model.getSubtitle()==null?"":model.getSubtitle());
			versionText.setText(model.getVersion()==null?"":model.getVersion());
			//			authorText.setText(model.getName()==null?"":model.getName());
		}
	}
}
