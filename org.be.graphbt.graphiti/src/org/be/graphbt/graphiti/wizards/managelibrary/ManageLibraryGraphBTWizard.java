package org.be.graphbt.graphiti.wizards.managelibrary;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.wizard.Wizard;

import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.StandardNode;

public class ManageLibraryGraphBTWizard extends Wizard {

	protected ManageLibraryFirstPageGraphBTWizard one;
	protected HashMap<Integer,String> map;
	protected DiagramEditor d;
	//protected CreateStandardNodeSecondPageGraphBTWizard two;

	public ManageLibraryGraphBTWizard(HashMap<Integer,String> map, DiagramEditor de) {
		super();
		setNeedsProgressMonitor(true);
		this.map = map;
		this.d = de;
	}

	@Override
	public void addPages() {
		//one = new CreateStandardNodeFirstPageGraphBTWizard(node);
		one = new ManageLibraryFirstPageGraphBTWizard(map,d);
		//two = new CreateStandardNodeSecondPageGraphBTWizard();
		addPage(one);
		//addPage(two);
	}

	@Override
	public boolean performFinish() {
		//menambahkan daftar behavior ke sana
		
		return true;
		
	}
}
