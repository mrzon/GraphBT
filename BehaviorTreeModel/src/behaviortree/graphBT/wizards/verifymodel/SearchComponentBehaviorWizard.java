package behaviortree.graphBT.wizards.verifymodel;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import behaviortree.BEModel;
import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

public class SearchComponentBehaviorWizard extends Wizard {

	protected SearchComponentBehaviorFirstPage one;
	protected HashMap<Integer,String> map;
	protected Diagram d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public SearchComponentBehaviorWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new SearchComponentBehaviorFirstPage(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		//System.out.println(one.getText1());
		//System.out.println(two.getText1());
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor)
        {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((behaviortree.editor.MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        d = ds.getDiagramTypeProvider().getDiagram();
		final BEModel be = GraphBTUtil.getBEModel(d);
		
		
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				System.out.println("jumlah komponen so far: "+be.getComponentList().getComponents().size());
				Component c = GraphBTUtil.getBEFactory().createComponent();
				//if(map.get(Component.COMPONENT_NAME)!=null||map.get(Component.COMPONENT_NAME)!="")
				c.setComponentName(map.get(Component.COMPONENT_NAME));
				c.setComponentRef(map.get(Component.COMPONENT_REF));
				be.getComponentList().getComponents().add(c);		
				//if(!c.getComponentName().equals("")&&c.getComponentName()!=null)
				try {
					GraphBTUtil.saveToModelFile(c, d);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		//String name = GraphBTUtil.getBehaviorFromComponentByRef(c, node.getBehaviorRef()).toString();
		    }
		};
		ds.getEditingDomain().getCommandStack().execute(cmd);
		return true;
		
	}
}
