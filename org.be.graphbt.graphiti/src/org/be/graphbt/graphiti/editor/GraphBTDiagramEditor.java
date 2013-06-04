package org.be.graphbt.graphiti.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.be.graphbt.common.ProjectUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.diagram.GraphBTImageProvider;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Layout;
import org.be.graphbt.model.graphbt.StandardNode;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.graphiti.internal.GraphitiPlugin;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.GraphitiUIPlugin;
import org.eclipse.graphiti.ui.internal.platform.ExtensionManager;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
public class GraphBTDiagramEditor extends DiagramEditor implements IPartListener2 {
	private StructuredViewer outlineViewer;
	public final Set<StandardNode> errorReversionNode = new HashSet<StandardNode>();
	public final List<StandardNode> reversionNode = new ArrayList<StandardNode>();

	public GraphBTDiagramEditor() {
		super();
	}

	@Override 
	public void init(IEditorSite s, IEditorInput i) {
		try {
			super.init(s,i);
			//GraphBTUtil.getDefaultBEModel(getDiagramTypeProvider().getDiagram());

			this.loadReversion();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doSave(IProgressMonitor i) {
		saveReversion();
		super.doSave(i);
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		updateActions(getSelectionActions());
	}

	@Override
	public void commandStackChanged(EventObject e) {
		super.commandStackChanged(e);
		//outlineViewer.refresh();
	}
	/**
	 * Sets the given viewer as the current outline viewer.
	 * 
	 * @param viewer the viewer to be stored
	 */
	public void setOutlineViewer(StructuredViewer viewer) {
		outlineViewer = viewer;
	}

	public void saveReversion() {
		final Diagram d = getDiagramTypeProvider().getDiagram();
		getEditingDomain().getCommandStack().execute(new RecordingCommand (getEditingDomain(),"Save reversion node Information") {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				BEModel model = GraphBTUtil.getBEModel(d,true);
				model.getReversionNode().clear();
				model.getErrorReversionNode().clear();
				model.setReversionNode(reversionNode);
				model.setErrorReversionNode(errorReversionNode);
			}

		});
	}

	@SuppressWarnings("restriction")
	public void loadReversion() {
		/*RecordingCommand cmd = new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
		 */	
		BEModel model = GraphBTUtil.getBEModel(getDiagramTypeProvider().getDiagram(),false);
		if(model == null)
			return;

		errorReversionNode.clear();
		reversionNode.clear();
		reversionNode.addAll(model.getReversionNode());
		errorReversionNode.addAll(model.getErrorReversionNode());
	}
	
	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
				System.out.println(partRef.getPage()+" is activated");
				final BEModel model = GraphBTUtil.getBEModel(getDiagramTypeProvider().getDiagram(),false);
				if(model == null)
					return;
				if(model.getLayoutList()!=null) {
					this.getEditDomain().getCommandStack().execute(new Command() {
						@SuppressWarnings("restriction")
						@Override
						public void execute() {
							EList<Layout>list = model.getLayoutList().getLayouts();
							for(Layout l:list) {
								Component c = GraphBTUtil.getComponentByRef(model, l.getCRef());
								org.eclipse.swt.graphics.Image im = ProjectUtil.getComponentImageDescription(c);
								if(im==null)
									continue;
								String path = ProjectUtil.getImageAbsolutePath(ProjectUtil.RESOURCE_LOCATION+"/"+c.getComponentRef());

								if(GraphitiUIPlugin.getDefault().getImageRegistry().get(path)!=null) {
						    		GraphitiUIPlugin.getDefault().getImageRegistry().remove(path);
						    	}
								GraphitiUIPlugin.getDefault().getImageRegistry().put(path, im);
								PictogramElement pe = Graphiti.getLinkService().getPictogramElements(getDiagramTypeProvider().getDiagram(), l).get(0);
								Image image = Graphiti.getGaCreateService().createImage(pe, path);
								image.setHeight(l.getHeight());
								image.setWidth(l.getWidth());
								image.setProportional(true);
								image.setStretchH(true);
								image.setStretchV(true);
								Graphiti.getGaService().setLocationAndSize(image, l.getX(), l.getY(), l.getWidth(), l.getHeight());
							}
						}
					});
					
				}
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}
}
