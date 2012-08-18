package behaviortree.graphBT.property;

import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.OperatorClass;
import behaviortree.Requirement;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;
import behaviortree.TraceabilityStatusClass;

public class BehaviorTreePropertySection extends GFPropertySection 
	implements ITabbedPropertyConstants {
	private CCombo componentCombo;
	private CCombo behaviorCombo;
	private CCombo requirementCombo;
	private CCombo operatorCombo;
	private CCombo statusCombo;

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
        IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else {
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        
        final Diagram d = ds.getDiagramTypeProvider().getDiagram();
        
        componentCombo = factory.createCCombo(composite);
        behaviorCombo = factory.createCCombo(composite);
        requirementCombo = factory.createCCombo(composite);
        operatorCombo = factory.createCCombo(composite);
        statusCombo = factory.createCCombo(composite);
        
        refresh();        
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
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }

		UpdateContext context = new UpdateContext(pe);
		ds.getDiagramTypeProvider().getFeatureProvider().updateIfPossible(context);
		
	}
    
    @Override
    public void refresh() {
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
            IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            final DiagramEditor ds;
            
            if(page.getActiveEditor() instanceof DiagramEditor) {
            	 ds = (DiagramEditor)page.getActiveEditor();	
            }
            else {
            	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
            }
            
            final Diagram d = ds.getDiagramTypeProvider().getDiagram();
            componentCombo.removeAll();
            for(Component component : GraphBTUtil.getBEModel(d).getComponentList().getComponents()) {
    	    	componentCombo.add(component.getComponentName());
    	    }
            
            requirementCombo.removeAll();
            for(Requirement requirement : GraphBTUtil.getBEModel(d).getRequirementList().getRequirements()) {
            	requirementCombo.add(requirement.getKey());
            }

            componentCombo.addSelectionListener(new SelectionAdapter() {
    		    public void widgetSelected(SelectionEvent e) {
    		    	CCombo combo = (CCombo)e.widget;
    		    	final String selected = combo.getItem(combo.getSelectionIndex());
    		    	final Component c = GraphBTUtil.getComponent(GraphBTUtil.getBEModel(d), selected);
    		    	
    		    	Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
    	    			protected void doExecute() {
    	    				node.setComponentRef(c.getComponentRef());
    	    				Behavior beh = c.getBehaviors().size()>0?c.getBehaviors().get(0):null;
    	    				node.setBehaviorRef(beh.getBehaviorRef());
    	    				behaviorCombo.setText(beh.getBehaviorName());
    	    		    }
    	    		};
    	    		
					PictogramElement pe = getSelectedPictogramElement();
					if(!(pe instanceof ContainerShape))
						return;
					ContainerShape cs = (ContainerShape)pe;
					Iterator<Shape> s = cs.getChildren().iterator();
					while(s.hasNext())
					{
						Shape n = s.next();
						
						Object bo = Graphiti.getLinkService()
				                 .getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
						if(bo instanceof Component||bo instanceof Behavior)
							updatePictogramElement(n);
					}
    	    		
    	    		TransactionalEditingDomain f = ds.getEditingDomain();
    	    		f.getCommandStack().execute(cmd);
    		    	behaviorCombo.removeAll();
    		    	
    		    	if(c!=null)
    		    	for(Behavior behavior: c.getBehaviors()) {
    			    	behaviorCombo.add(behavior.toString());
    			    }
    		    	
    		     }
    	     });
            
            behaviorCombo.addSelectionListener(new SelectionAdapter() {
    		    public void widgetSelected(SelectionEvent e) {
    		    	CCombo combo = (CCombo)e.widget;
    		    	final String selected = combo.getItem(combo.getSelectionIndex());
    		    	
    		    	final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
    	    			protected void doExecute() {
    	    		    	BEModel model = GraphBTUtil.getBEModel(d);
    	        			Component c = GraphBTUtil.getComponentByRef(model, node.getComponentRef());
    	        			Behavior b = GraphBTUtil.getBehaviorFromComponent(c,selected);
    	        			node.setBehaviorRef(b.getBehaviorRef());
    	    		    }
    	    		};
    	    		ds.getEditingDomain().getCommandStack().execute(cmd);
    	    		PictogramElement pe = getSelectedPictogramElement();
					if(!(pe instanceof ContainerShape))
						return;
					ContainerShape cs = (ContainerShape)pe;
					Iterator<Shape> s = cs.getChildren().iterator();
					while(s.hasNext())
					{
						Shape n = s.next();
						
						Object bo = Graphiti.getLinkService()
				                 .getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
						if(bo instanceof Behavior)
							updatePictogramElement(n);
					}
    		     }
    	     });
            
            requirementCombo.addSelectionListener(new SelectionAdapter() {
    		    public void widgetSelected(SelectionEvent e) {
    		    	CCombo combo = (CCombo)e.widget;
    		    	final String selected = combo.getItem(combo.getSelectionIndex());
    		    	
    		    	final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
    	    			protected void doExecute() {
    	    		    	BEModel model = GraphBTUtil.getBEModel(d);
    	        			Requirement r = GraphBTUtil.getRequirement(model, selected);
    	        			node.setTraceabilityLink(r.getKey());
    	    		    }
    	    		};
    	    		
    	    		ds.getEditingDomain().getCommandStack().execute(cmd);
    	    		PictogramElement pe = getSelectedPictogramElement();

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
    		     }
    	     });
            
            statusCombo.addSelectionListener(new SelectionAdapter() {
    		    public void widgetSelected(SelectionEvent e) {
    		    	CCombo combo = (CCombo)e.widget;
    		    	final String selected = combo.getItem(combo.getSelectionIndex());
    		    	
    		    	System.out.println("TraceabilityStatus.get(selected) " + TraceabilityStatus.getByName(selected).getLiteral());
    		    	
    		    	final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
    	    			protected void doExecute() {
    	    				BEModel model = GraphBTUtil.getBEModel(d);
    	    				System.out.println("Selected on TraceabilityStatus " + selected);
    	        			
    	    				node.setTraceabilityStatus(TraceabilityStatus.getByName(selected).getLiteral());
    	    		    }
    	    		};
    	    		
    	    		ds.getEditingDomain().getCommandStack().execute(cmd);
    	    		PictogramElement pe = getSelectedPictogramElement();

    	    		if(!(pe instanceof ContainerShape))
						return;
					
    	    		ContainerShape cs = (ContainerShape)pe;
					Iterator<Shape> s = cs.getChildren().iterator();
					while(s.hasNext()) {
						Shape n = s.next();
						
						Object bo = Graphiti.getLinkService()
				                 .getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
						if(bo instanceof TraceabilityStatusClass) {
							System.out.println("update on TraceabilityStatus from property: " + selected);
							updatePictogramElement(n);
						}
					}
    		     }
    	     });
            
            operatorCombo.addSelectionListener(new SelectionAdapter() {
    		    public void widgetSelected(SelectionEvent e) {
    		    	CCombo combo = (CCombo)e.widget;
    		    	final String selected = combo.getItem(combo.getSelectionIndex());
    		    	
    		    	final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
    	    			protected void doExecute() {
    	    				BEModel model = GraphBTUtil.getBEModel(d);
    	    				
    	        			node.setOperator(Operator.getByName(selected).getLiteral());
    	    		    }
    	    		};
    	    		
    	    		ds.getEditingDomain().getCommandStack().execute(cmd);
    	    		PictogramElement pe = getSelectedPictogramElement();

    	    		if(!(pe instanceof ContainerShape))
						return;
					
    	    		ContainerShape cs = (ContainerShape)pe;
					Iterator<Shape> s = cs.getChildren().iterator();
					while(s.hasNext()) {
						Shape n = s.next();
						
						Object bo = Graphiti.getLinkService()
				                 .getBusinessObjectForLinkedPictogramElement((PictogramElement)n);
						if(bo instanceof OperatorClass)
							updatePictogramElement(n);
					}
    		     }
    	     });
        }
    }
}