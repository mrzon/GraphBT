package org.be.graphbt.graphiti.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorTree;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.Node;
import org.be.graphbt.model.graphbt.Requirement;

public class GraphBTContentOutlinePage extends ContentOutlinePage {
	private DiagramEditor diagramEditor;
	public GraphBTContentOutlinePage(DiagramEditor diagramEditor) {
		// TODO Auto-generated constructor stub
		super();
		this.setEditor(diagramEditor);
	}

	public void createControl(Composite composite) {
		super.createControl(composite);

		TreeViewer viewer= getTreeViewer();
		viewer.setContentProvider(new GraphBTContentProvider());
		viewer.setLabelProvider(new GraphBTLabelProvider());
		//viewer.addSelectionChangedListener(this);
		viewer.setInput(this.diagramEditor);
	}

	public DiagramEditor getMultiPageEditor() {
		return diagramEditor;
	}

	public void setEditor(DiagramEditor diagramEditor2) {
		this.diagramEditor = diagramEditor2;
	}
	
	public void selectionChanged(SelectionChangedEvent event) {

		super.selectionChanged(event);

		ISelection selection= event.getSelection();
		System.out.println("The item is selected "+event.getSource());
	}
}

class GraphBTContentProvider implements ITreeContentProvider
{

	private static final Object[] EMPTY_ARRAY = new Object[0];

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		if (newInput != null && newInput instanceof GraphBTDiagramEditor) {
            // set the tree viewer as the outline viewer for new new input editor
            ((GraphBTDiagramEditor)newInput).setOutlineViewer((StructuredViewer)viewer);
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {

		try {
            // assume the input is our own editor
			if(inputElement instanceof DiagramEditor) {
				DiagramEditor editor = (DiagramEditor)inputElement;
	            // get the line coordinates as an array
	            Diagram d = editor.getDiagramTypeProvider().getDiagram();
	            BEModel be = GraphBTUtil.getBEModel(d,true);
	            Object[]ob = new Object[5];
	            
	            ob[0]=be.getLibraries().getImport();
	            ob[1]=be.getRequirementList().getRequirements();
	            ob[2]=be.getComponentList().getComponents();
	            ob[3]=be.getFormulaList();
	            ob[4]=be.getDbt();
	            
	            return ob;
			}
			else if(inputElement instanceof EList) {
				 return ((EList) inputElement).toArray();
			}
			return EMPTY_ARRAY;
	    } catch (ClassCastException e) {
	            return EMPTY_ARRAY;
	    }
		
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof EList) {
			return ((EList)parentElement).toArray();
		}
		if(parentElement instanceof BehaviorTree) {
			Object []dumm = new Object[1];
			dumm[0]=((BehaviorTree)parentElement).getRootNode();
			return dumm;
		}
		if(parentElement instanceof Node) {
			Node n = (Node)parentElement;
			if(n.getEdge()==null)
				return null;
			Object []c = new Object[n.getEdge().getChildNode().size()];
			if(c.length==0)
				return null;
			for(int i = 0; i < c.length; i++) {
				c[i] = n.getEdge().getChildNode().get(i);
			}
			return c;
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return (element instanceof EList||element instanceof BehaviorTree);
	}
}

class GraphBTLabelProvider extends LabelProvider
{
	public String getText(Object element) {
	     if (element instanceof Requirement) {
	       return ((Requirement) element).getKey();
	     } else
	     if (element instanceof Component) {
	       return ((Component) element).getComponentRef();
	     } else
	     if (element instanceof Behavior) {
	       return ((Behavior) element).toString();
	     }
	     return null;
	   }
}