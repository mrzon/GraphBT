package org.be.graphbt.graphiti.editor.pages;

import java.io.ByteArrayInputStream;

import org.be.graphbt.codegenerator.gui.template.GraphBTDocumentationTemplate;
import org.be.graphbt.common.ProjectUtil;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.BEModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

public class DocumentationPage extends Composite{

	private Browser browser;
	private Diagram d;
	public DocumentationPage(Composite parent, int style,Diagram d) {
		super(parent, style);
		this.d = d;
		init();
	}

	private void init() {
	      try {
	    	  this.setLayout(new FillLayout());
	    	  GridData gridData =
	  				new GridData(
	  						GridData.FILL_BOTH);
	         browser = new Browser(this, SWT.NONE);
	         browser.setData(gridData);
	         
	      } catch (SWTError e) {
	         MessageBox messageBox = new MessageBox(this.getShell(), SWT.ICON_ERROR | SWT.OK);
	         messageBox.setMessage("Documentation file not found, make sure that \"docs.html\" exists in your project folder");
	         messageBox.setText("Dismiss");
	         messageBox.open();
	      }
	      this.pack();
	}
	
	public void reload() {
		try {
			BEModel model = GraphBTUtil.getBEModel(d);
			GraphBTDocumentationTemplate template = new GraphBTDocumentationTemplate();
			IProject project = ProjectUtil.getActiveProject();
			IFile file = project.getFile("docs.html");
			if(!file.exists()) {
				file.create(new ByteArrayInputStream(template.generate(model).getBytes()), true, null);
			} else {
				file.setContents(new ByteArrayInputStream(template.generate(model).getBytes()), true, true, null);
			}
			browser.setUrl(file.getLocation().toOSString());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		this.pack();
	}
}
