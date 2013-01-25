package org.be.graphbt.graphiti.wizards.verifymodel;

import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Formula;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;

/**
 * this class handles add LTL formula page.
 * @author alh
 *
 */
public class AddFormulaWizard extends Wizard {

	/**	add formula page */
	protected AddFormulaFirstPage one;
	
	protected HashMap<Integer,String> map;
	protected Diagram d;

	/**
	 * 
	 * @param map
	 * @param d
	 */
	public AddFormulaWizard(HashMap<Integer,String> map, Diagram d) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = d;
	}

	/**
	 * add formula page.
	 */
	@Override
	public void addPages() {
		one = new AddFormulaFirstPage(map,d);
		addPage(one);
	}

	/**
	 * do this when finish button is executed.
	 */
	@Override
	public boolean performFinish() {
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        final DiagramEditor ds;
        if(page.getActiveEditor() instanceof DiagramEditor) {
        	 ds = (DiagramEditor)page.getActiveEditor();	
        }
        else
        {
        	ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
        }
        d = ds.getDiagramTypeProvider().getDiagram();
		final BEModel be = GraphBTUtil.getBEModel(d);
		
		// set to transaction
		final Command cmd = new RecordingCommand(ds.getEditingDomain(), "Nope") {
			protected void doExecute() {
				// create formula instance
				Formula f = GraphBTUtil.getBEFactory().createFormula();
				// set formula list
				if(be.getFormulaList() == null) {
					be.setFormulaList(GraphBTUtil.getBEFactory().createFormulaList());
				}
				// set formula name
				f.setFormulaName(map.get(ConstantsOfVerifyModel.REF_ADD_FORMULA));
				// add formula instance to list
				be.getFormulaList().getFormula().add(f);
		    }
		};
		ds.getEditingDomain().getCommandStack().execute(cmd);
		
		return true;
	}
}
