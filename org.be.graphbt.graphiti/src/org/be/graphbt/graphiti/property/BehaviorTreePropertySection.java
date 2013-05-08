package org.be.graphbt.graphiti.property;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import org.be.graphbt.model.graphbt.AlternativeClass;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.Branch;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.graphiti.AccessoryUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Operator;
import org.be.graphbt.model.graphbt.OperatorClass;
import org.be.graphbt.model.graphbt.Requirement;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.model.graphbt.TraceabilityStatus;
import org.be.graphbt.model.graphbt.TraceabilityStatusClass;
import org.be.graphbt.graphiti.wizards.managecomponents.ManageComponentsGraphBTWizard;
import org.be.graphbt.graphiti.editor.*;
/**
 * Class for managing the property section of BT node
 * @author GraphBT Team
 *
 */
public class BehaviorTreePropertySection extends GFPropertySection 
implements ITabbedPropertyConstants {
	private CCombo componentCombo;
	private CCombo behaviorCombo;
	private CCombo requirementCombo;
	private CCombo operatorCombo;
	private CCombo statusCombo;
	private CCombo branchCombo;
	private CLabel branchLabel;

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


		componentCombo = factory.createCCombo(composite);
		behaviorCombo = factory.createCCombo(composite);
		requirementCombo = factory.createCCombo(composite);
		operatorCombo = factory.createCCombo(composite);
		statusCombo = factory.createCCombo(composite);
		branchCombo = factory.createCCombo(composite);
		for(Branch branch : Branch.VALUES) {
			branchCombo.add(branch.getName());
		}



		for(TraceabilityStatus ts : TraceabilityStatus.VALUES) {
			statusCombo.add(ts.getName());
		}

		for(Operator ts : Operator.VALUES) {
			operatorCombo.add(ts.getName());
		}

		componentData = new FormData();
		componentData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH*2);
		componentData.right = new FormAttachment(100, 0);
		componentData.top = new FormAttachment(0, VSPACE);
		componentCombo.setLayoutData(componentData);

		CLabel valueLabel2 = factory.createCLabel(composite, "Component Name");
		componentData = new FormData();
		componentData.left = new FormAttachment(0, 0);
		componentData.right = new FormAttachment(componentCombo, -HSPACE);
		componentData.top = new FormAttachment(componentCombo, 0, SWT.CENTER);
		valueLabel2.setLayoutData(componentData);

		behaviorData = new FormData();
		behaviorData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		behaviorData.right = new FormAttachment(100, 0);
		behaviorData.top = new FormAttachment(componentCombo, VSPACE);
		behaviorCombo.setLayoutData(behaviorData);

		CLabel valueLabel3 = factory.createCLabel(composite, "Behavior Name");
		behaviorData = new FormData();
		behaviorData.left = new FormAttachment(0, 0);
		behaviorData.right = new FormAttachment(behaviorCombo, -HSPACE);
		behaviorData.top = new FormAttachment(behaviorCombo, 0, SWT.CENTER);
		valueLabel3.setLayoutData(behaviorData);

		requirementData = new FormData();
		requirementData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		requirementData.right = new FormAttachment(100, 0);
		requirementData.top = new FormAttachment(behaviorCombo, VSPACE);
		requirementCombo.setLayoutData(requirementData);

		CLabel valueLabelReq = factory.createCLabel(composite, "Traceability Link");
		requirementData = new FormData();
		requirementData.left = new FormAttachment(0, 0);
		requirementData.right = new FormAttachment(requirementCombo, -HSPACE);
		requirementData.top = new FormAttachment(requirementCombo, 0, SWT.CENTER);
		valueLabelReq.setLayoutData(requirementData);

		operatorData = new FormData();
		operatorData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		operatorData.right = new FormAttachment(100, 0);
		operatorData.top = new FormAttachment(requirementCombo, VSPACE);
		operatorCombo.setLayoutData(operatorData);

		CLabel valueLabel4 = factory.createCLabel(composite, "Operator Name");
		operatorData = new FormData();
		operatorData.left = new FormAttachment(0, 0);
		operatorData.right = new FormAttachment(operatorCombo, -HSPACE);
		operatorData.top = new FormAttachment(operatorCombo, 0, SWT.CENTER);
		valueLabel4.setLayoutData(operatorData);

		statusData = new FormData();
		statusData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		statusData.right = new FormAttachment(100, 0);
		statusData.top = new FormAttachment(operatorCombo, VSPACE);
		statusCombo.setLayoutData(statusData);

		CLabel valueLabel5 = factory.createCLabel(composite, "Traceability Status");
		statusData = new FormData();
		statusData.left = new FormAttachment(0, 0);
		statusData.right = new FormAttachment(statusCombo, -HSPACE);
		statusData.top = new FormAttachment(statusCombo, 0, SWT.CENTER);
		valueLabel5.setLayoutData(statusData);

		branchData = new FormData();
		branchData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		branchData.right = new FormAttachment(100, 0);
		branchData.top = new FormAttachment(statusCombo, VSPACE);
		branchCombo.setLayoutData(branchData);

		branchLabel = factory.createCLabel(composite, "Branch Type");
		branchData = new FormData();
		branchData.left = new FormAttachment(0, 0);
		branchData.right = new FormAttachment(branchCombo, -HSPACE);
		branchData.top = new FormAttachment(branchCombo, 0, SWT.CENTER);
		branchLabel.setLayoutData(branchData);

		/***/
		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {
			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);

			if (bo == null)
				return;

			if(!(bo instanceof StandardNode)) {
				return;
			}
		}

		componentCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PictogramElement pe = getSelectedPictogramElement();
				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
				if(!(ob instanceof StandardNode))
					return;
				final StandardNode node = (StandardNode) ob;

				CCombo combo = (CCombo)e.widget;
				final String selected = combo.getItem(combo.getSelectionIndex());

				final Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d,true), selected);

				Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						node.setComponentRef(c.getComponentRef());
						String beh = c.getBehaviors().size()>0?c.getBehaviors().get(0).getBehaviorRef():"";
						node.setBehaviorRef(beh);
						behaviorCombo.setText(beh);
						try{
							refresh();
						}
						catch(RuntimeException re)
						{

							WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
									getActiveWorkbenchWindow().getShell(),
									new ManageComponentsGraphBTWizard(d));
							if(wizardDialog.open() == Window.OK)
							{
								return;
							}
						}
					}
				};
				TransactionalEditingDomain f = ds.getEditingDomain();
				f.getCommandStack().execute(cmd);
				ContainerShape cs = (ContainerShape)pe;
				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();

					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof Component||bo instanceof Behavior)
						updatePictogramElement(n);
				}


				behaviorCombo.removeAll();

				if(c!=null) {
					for(Behavior behavior: c.getBehaviors()) {
						behaviorCombo.add(behavior.toString());
					}
					behaviorCombo.setText(behaviorCombo.getItem(0));
				}
			}
		});
		behaviorCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CCombo combo = (CCombo)e.widget;
				final String selected = combo.getItem(combo.getSelectionIndex());
				PictogramElement pe = getSelectedPictogramElement();
				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
				if(!(ob instanceof StandardNode))
					return;
				final StandardNode node = (StandardNode) ob;
				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change behavior") {
					protected void doExecute() {
						BEModel model = GraphBTUtil.getBEModel(d,true);
						Component c = GraphBTUtil.getComponentByRef(model, node.getComponentRef());
						Behavior b = GraphBTUtil.getBehaviorFromComponent(c,selected);
						node.setBehaviorRef(b.getBehaviorRef());
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				ContainerShape cs = (ContainerShape)pe;
				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();

					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof Behavior)
						updatePictogramElement(n);
				}
				refresh();
			}
		});
		requirementCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CCombo combo = (CCombo)e.widget;
				final String selected = combo.getItem(combo.getSelectionIndex());
				PictogramElement pe = getSelectedPictogramElement();
				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
				if(!(ob instanceof StandardNode))
					return;
				final StandardNode node = (StandardNode) ob;
				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						if(selected.trim().equals("")) {
							Requirement r = GraphBTUtil.getDefaultRequirement(d);
							node.setTraceabilityLink(r.getKey());
						}
						else {
							Requirement r = GraphBTUtil.getRequirement(d, selected);
							node.setTraceabilityLink(r.getKey());
						}
					}
				};

				ds.getEditingDomain().getCommandStack().execute(cmd);

				if(!(pe instanceof ContainerShape))
					return;

				ContainerShape cs = (ContainerShape)pe;
				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();

					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof Requirement)
						updatePictogramElement(n);
				}
				refresh();
			}
		});

		statusCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CCombo combo = (CCombo)e.widget;
				final String selected = combo.getItem(combo.getSelectionIndex());
				PictogramElement pe = getSelectedPictogramElement();
				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
				if(!(ob instanceof StandardNode))
					return;
				final StandardNode node = (StandardNode) ob;
				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						node.setTraceabilityStatus(TraceabilityStatus.getByName(selected).getLiteral());
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				if(!(pe instanceof ContainerShape))
					return;

				final ContainerShape cs = (ContainerShape) pe;

				final RecordingCommand cmd2 = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						final Rectangle rectangle = (Rectangle) cs.getGraphicsAlgorithm();

						Edge edge = node.getEdge();

						if(edge != null && node.getOperator().equals(Operator.REVERSION.getLiteral())) {
							rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.ERROR_COLOR));
							return;
						}
						rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.getNormalColor(node)));
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd2);

				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();

					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof TraceabilityStatusClass) {
						updatePictogramElement(n);
					}
				}
				refresh();
			}
		});

		branchCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CCombo combo = (CCombo)e.widget;

				final String selected = combo.getItem(combo.getSelectionIndex());
				PictogramElement pe = getSelectedPictogramElement();

				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);

				if(!(ob instanceof StandardNode))
					return;

				final StandardNode node = (StandardNode) ob;
				final Edge edge = node.getEdge();

				if(edge == null) {
					return;
				}

				if(!(pe instanceof ContainerShape))
					return;

				final ContainerShape cs = (ContainerShape)pe;

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Change Branch") {
					protected void doExecute() {
						edge.setBranch(Branch.getByName(selected));
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();

					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof AlternativeClass)
						updatePictogramElement(n);
				}
				refresh();
			}
		});

		operatorCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CCombo combo = (CCombo)e.widget;
				final String selected = combo.getItem(combo.getSelectionIndex());
				PictogramElement pe = getSelectedPictogramElement();
				if(!(pe instanceof ContainerShape))
					return;

				Object ob = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
				if(!(ob instanceof StandardNode))
					return;
				final StandardNode node = (StandardNode) ob;
				//GraphBTUtil.reversionNode.remove(node);
				final String literal = Operator.getByName(selected).getLiteral();

//				if(literal.equals(Operator.REVERSION.getLiteral()))
//				{
//					GraphBTUtil.reversionNode.add(node);
//				}
				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						node.setOperator(literal);
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);

				
				final ContainerShape cs = (ContainerShape)pe;
				final Command cmd2 = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						final Rectangle rectangle = (Rectangle) cs.getGraphicsAlgorithm();

						Edge edge = node.getEdge();

						if(edge != null && node.getOperator().equals(Operator.REVERSION.getLiteral())) {
							rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.ERROR_COLOR));
							return;
						}
						rectangle.setBackground(Graphiti.getGaService().manageColor(d, AccessoryUtil.getNormalColor(node)));
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd2);

				Iterator<Shape> s = cs.getChildren().iterator();
				while(s.hasNext()) {
					Shape n = s.next();
					Object bo = Graphiti.getLinkService()
							.getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
					if(bo instanceof OperatorClass)
						updatePictogramElement(n);
				}
				refresh();
			}
		});
	}

	/**
	 * Updates the given pictogram element. This implementation asks the feature
	 * provider for available update features and processes the first one.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void updatePictogramElement(PictogramElement pe) {
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		DiagramEditor ds;
		if(page.getActiveEditor() instanceof DiagramEditor) {
			ds = (DiagramEditor)page.getActiveEditor();	
		}
		else {
			ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
		}
		UpdateContext context = new UpdateContext(pe);
		ds.getDiagramTypeProvider().getFeatureProvider().updateIfPossible(context);

	}

	@Override
	public synchronized void  refresh() throws RuntimeException{
		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {
			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;
			if(!(bo instanceof StandardNode)) {
				return;
			}
			final StandardNode node = (StandardNode) bo;
			StandardNode sn = (StandardNode) bo;
			Edge edge = sn.getEdge();
			if(edge == null) {
				branchCombo.setVisible(false);
				branchLabel.setVisible(false);
			}
			else {
				Branch branch = edge.getBranch(); 
				if(branch != null && edge.getChildNode().size()>1) {
					branchCombo.setVisible(true);
					branchLabel.setVisible(true);
				}
				else {
					branchCombo.setVisible(false);
					branchLabel.setVisible(false);
				}
			}

			IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			final GraphBTDiagramEditor ds;

			if(page.getActiveEditor() instanceof GraphBTDiagramEditor) {
				ds = (GraphBTDiagramEditor)page.getActiveEditor();	
			}
			else {
				ds = (GraphBTDiagramEditor)((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
			}

			final Diagram d = ds.getDiagramTypeProvider().getDiagram();

			componentCombo.removeAll();
			for(Component component : GraphBTUtil.getBEModel(d,true).getComponentList().getComponents()) {
				componentCombo.add(component.getComponentName());
			}

			requirementCombo.removeAll();
			for(Requirement requirement : GraphBTUtil.getBEModel(d,true).getRequirementList().getRequirements()) {
				requirementCombo.add(requirement.getKey());
			}
			requirementCombo.add(" ");

			BEModel model = GraphBTUtil.getBEModel(d,true);

			Component com = GraphBTUtil.getComponentByRef(model, node.getComponentRef());
			if(com!=null) {
				behaviorCombo.removeAll();
				for(Behavior behavior: com.getBehaviors()) {
					behaviorCombo.add(behavior.toString());
				}
				String componentString = com.getComponentName(); 
				Behavior behavior = GraphBTUtil.getBehaviorFromComponentByRef(com, node.getBehaviorRef());
				String behaviorString = behavior==null?"":behavior.toString();

				Requirement rr = GraphBTUtil.getRequirement(d, node.getTraceabilityLink());
				if(rr != null) {
					String requirementString = GraphBTUtil.getRequirement(d, node.getTraceabilityLink()).getKey();
					requirementCombo.setText(requirementString);
				}
				else
					rr = GraphBTUtil.getDefaultRequirement(d);

				String operatorString = GraphBTUtil.getOperator(d, node.getOperator()).getOperatorLiteral();
				String statusString = GraphBTUtil.getTraceabilityStatus(d, node.getTraceabilityStatus()).getTraceabilityStatusLiteral();

				componentCombo.setText(componentString);
				behaviorCombo.setText(behaviorString);
				statusCombo.setText(statusString);
				operatorCombo.setText(operatorString);
				int sizeBefore = ds.reversionNode.size();
				if(operatorString.equals("^"))
				{
				//	GraphBTUtil.reversionNode.add(node);
				//	GraphBTUtil.updateReversionNode(ds);
				}
				int sizeAfter = ds.reversionNode.size();
				//if(sizeBefore != sizeAfter) {
				
				if(operatorString.equals("^")) {
					if(!ds.reversionNode.contains(node)) {
						ds.reversionNode.add(node);
					}
					edge = node.getEdge();
					if(edge != null || GraphBTUtil.getAncestor(node)==null) {
						ds.errorReversionNode.add(node);
					}
					else {
						ds.errorReversionNode.remove(node);
					}
				} else {
					ds.reversionNode.remove(node);
					ds.errorReversionNode.remove(node);
				}

				final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
					protected void doExecute() {
						GraphBTUtil.updateReversionNode(ds);
					}
				};
				ds.getEditingDomain().getCommandStack().execute(cmd);
			}
		}
	}
}
