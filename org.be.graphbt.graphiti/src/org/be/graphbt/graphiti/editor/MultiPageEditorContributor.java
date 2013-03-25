package org.be.graphbt.graphiti.editor;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.be.graphbt.codegenerator.absmodel.ABSClass;
import org.be.graphbt.codegenerator.absmodel.ABSForeign;
import org.be.graphbt.codegenerator.absmodel.ABSMethodImplementation;
import org.be.graphbt.codegenerator.absmodel.ABSModule;
import org.be.graphbt.codegenerator.absmodel.ABSStatement;
import org.be.graphbt.codegenerator.absmodel.ABSStatementType;
import org.be.graphbt.codegenerator.absmodel.BTParser;
import org.be.graphbt.common.ProjectUtil;
//TODO import btdebuggertool.commandHandler.*;
import org.be.graphbt.saltranslator.bt2salmodel.Main;
import org.be.graphbt.simulator.commandHandler.StartPointParseXML;
import org.eclipse.core.internal.runtime.Log;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.osgi.framework.Bundle;



import org.be.graphbt.model.graphbt.AdditionalInformation;
import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.ComponentList;
import org.be.graphbt.model.graphbt.FormulaList;
import org.be.graphbt.model.graphbt.Libraries;
import org.be.graphbt.model.graphbt.MapInformation;
import org.be.graphbt.model.graphbt.RequirementList;
import org.be.graphbt.graphiti.Activator;
import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.model.graphbt.Information;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.graphiti.wizards.createcomponent.CreateComponentGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managecomponents.ManageComponentsGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managelibrary.ManageLibraryGraphBTWizard;
import org.be.graphbt.graphiti.wizards.managerequirements.ManageRequirementsGraphBTWizard;
import org.be.graphbt.graphiti.wizards.verifymodel.VerifyModelGraphBTWizard;


/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class MultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	private IEditorPart activeEditorPart;
	private Action generateBTCode;
	private Action addNewComponent;
	private Action manageComponents;
	private Action manageRequirements;
	private Action manageLibrary;
	private Action validateBT;
	private Action debugBT;
	private Action generateJavaCode;
	private Action verifyModel;
	private Action correctLayout;
	private Action importBT;
	private IFile btIFile;
	private Action clearDiagram;
	private Action generateSALCode;
	private Action runCode;
	private Action generateDocument;
	private Action exportBT;

	/**
	 * Creates a multi-page contributor.
	 */
	public MultiPageEditorContributor() {
		super();
		createActions();
	}
	/**
	 * Returns the action registed with the given text editor.
	 * @return IAction or null if editor is null.
	 */
	protected IAction getAction(ITextEditor editor, String actionID) {
		return (editor == null ? null : editor.getAction(actionID));
	}
	/* (non-JavaDoc)
	 * Method declared in AbstractMultiPageEditorActionBarContributor.
	 */

	public IEditorPart getActivePage() {
		return activeEditorPart;
	}
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		activeEditorPart = part;

		IActionBars actionBars = getActionBars();
		if (actionBars != null) {

			ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

			actionBars.setGlobalActionHandler(
					ActionFactory.DELETE.getId(),
					getAction(editor, ITextEditorActionConstants.DELETE));
			actionBars.setGlobalActionHandler(
					ActionFactory.UNDO.getId(),
					getAction(editor, ITextEditorActionConstants.UNDO));
			actionBars.setGlobalActionHandler(
					ActionFactory.REDO.getId(),
					getAction(editor, ITextEditorActionConstants.REDO));
			actionBars.setGlobalActionHandler(
					ActionFactory.CUT.getId(),
					getAction(editor, ITextEditorActionConstants.CUT));
			actionBars.setGlobalActionHandler(
					ActionFactory.COPY.getId(),
					getAction(editor, ITextEditorActionConstants.COPY));
			actionBars.setGlobalActionHandler(
					ActionFactory.PASTE.getId(),
					getAction(editor, ITextEditorActionConstants.PASTE));
			actionBars.setGlobalActionHandler(
					ActionFactory.SELECT_ALL.getId(),
					getAction(editor, ITextEditorActionConstants.SELECT_ALL));
			actionBars.setGlobalActionHandler(
					ActionFactory.FIND.getId(),
					getAction(editor, ITextEditorActionConstants.FIND));
			actionBars.setGlobalActionHandler(
					IDEActionFactory.BOOKMARK.getId(),
					getAction(editor, IDEActionFactory.BOOKMARK.getId()));
			actionBars.updateActionBars();
		}
	}

	private void createActions() {
		exportBT = new Action() {
			public void run() {
				final Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
				if(GraphBTUtil.isValid(d)>0) {
					MessageDialog.openError(null, "BT generation error", "The model is not valid, validate the model first to check error");
					return;
				}
				generateBTCode.run();
				URI uri = d.eResource().getURI();
				uri = uri.trimFragment();
				uri = uri.trimFileExtension();
				uri = uri.appendFileExtension("bt");
				final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				URI uri2 = uri.trimFragment();
				uri2 = uri2.trimFileExtension();
				uri2 = uri2.appendFileExtension("info");
				Shell shell = activeEditorPart.getSite().getShell();
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				dialog
				.setFilterNames(new String[] { "BT Files \"*.btinfo\"", "*.btinfo" });
				dialog.setFilterExtensions(new String[] { "*.btinfo" }); // Windows
				// wild
				// cards
				dialog.setFilterPath("c:\\"); // Windows path
				dialog.setFileName("RBT.btinfo");
				String path = dialog.open();
				if(path==null) {
					return;
				}
				System.out.println("Save to: " + path);
				FileOutputStream fos;
				try {
					
					fos = new FileOutputStream(path);

					ZipOutputStream zos = new ZipOutputStream(fos);

					String file1Name = btIFile.getRawLocation().toOSString();
					String file2Name = workspaceRoot.getFile(new Path(uri2.toPlatformString(true))).getRawLocation().toOSString();

					addToZipFile(file1Name, zos);
					addToZipFile(file2Name, zos);

					zos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		exportBT.setText("Export Model");
		exportBT.setToolTipText("Export the model so it can be reused");
		exportBT.setImageDescriptor(getImageDescriptor("icons/export.gif"));

		generateBTCode = new Action() {
			public void run() {
				if(activeEditorPart instanceof DiagramEditor) {
					final Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
					if(GraphBTUtil.isValid(d)>0) {
						MessageDialog.openError(null, "BT generation error", "The model is not valid, validate the model first to check error");
						return;
					}
					String content = GraphBTUtil.getBTText(d);
					URI uri = d.eResource().getURI();
					uri = uri.trimFragment();
					uri = uri.trimFileExtension();
					uri = uri.appendFileExtension("bt");
					final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
					//extract the .bt text
					IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
					{
						Path path = new Path(uri.toPlatformString(true));
						btIFile = workspaceRoot.getFile(path);
						InputStream in = new ByteArrayInputStream(content.getBytes());
						try {
							if (file == null || !file.exists()) {
								btIFile.create(in,false,null);
							}	
							else
							{
								btIFile.setContents(in, false, false, null);
							}	
						} catch (CoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					//extract additional info
					URI uri2 = uri.trimFragment();
					uri2 = uri2.trimFileExtension();
					uri2 = uri2.appendFileExtension("info");	
					//System.out.println(uri2);
					file = workspaceRoot.findMember(uri2.toPlatformString(true));
					{
						final ResourceSet rset = new ResourceSetImpl();
						final Resource poResource = rset.createResource(uri2);
						final BEModel bem = GraphBTUtil.getBEModel(d,true);
					
						final MapInformation info = GraphBTUtil.getBEFactory().createMapInformation();//new EMap<String,String> ();
						//if(bem.getRequirementList()!=null)
						for(int i = 0; i < bem.getRequirementList().getRequirements().size(); i++) {
							org.be.graphbt.model.graphbt.Requirement r = bem.getRequirementList().getRequirements().get(i);
							//System.out.println(r.getKey());
							if(r.getRequirement()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(r.getKey()+".name");
								inf.setValue(r.getRequirement());
								info.getInfo().add(inf);
							}
							if(r.getDescription()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(r.getKey()+".desc");
								inf.setValue(r.getDescription());
								info.getInfo().add(inf);
							}
						}
						ComponentList cpl = bem.getComponentList();
						//if(cpl!=null)
						for(int i = 0; i < cpl.getComponents().size(); i++) {
							org.be.graphbt.model.graphbt.Component c = cpl.getComponents().get(i);
							//System.out.println(c.getComponentRef());
							if(c.getComponentDesc()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(c.getComponentRef()+".desc");
								inf.setValue(c.getComponentDesc());
								info.getInfo().add(inf);
							}
							for(int j = 0; j < c.getBehaviors().size(); j++) {
								org.be.graphbt.model.graphbt.Behavior b = c.getBehaviors().get(j);
								if(b.getBehaviorDesc()!=null) {
									Information inf = GraphBTUtil.getBEFactory().createInformation();
									inf.setKey(c.getComponentRef()+"."+b.getBehaviorRef()+".desc");
									inf.setValue(b.getBehaviorDesc());
									info.getInfo().add(inf);
								}
							}
						}
						EList<Library> libs = bem.getLibraries().getImport();
						for(int i = 0; i < libs.size(); i++) {
							org.be.graphbt.model.graphbt.Library c = libs.get(i);
							//System.out.println(c.getComponentRef());
							if(c.getDesc()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(c.getName()+".desc");
								inf.setValue(c.getDesc());
								info.getInfo().add(inf);
							}
							if(c.getLocation()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(c.getName()+".loc");
								inf.setValue(c.getLocation());
								info.getInfo().add(inf);
							}
							if(c.getText()!=null) {
								Information inf = GraphBTUtil.getBEFactory().createInformation();
								inf.setKey(c.getName()+".text");
								inf.setValue(c.getText());
								info.getInfo().add(inf);
							}
						}

						((DiagramEditor)activeEditorPart).getEditingDomain().getCommandStack().execute(new RecordingCommand(((DiagramEditor)activeEditorPart).getEditingDomain(),"clear diagram editor") {
							@Override
							protected void doExecute() {
								//poResource.getContents().add();
								poResource.getContents().add(EcoreUtil.copy(bem.getRequirementList()));
								poResource.getContents().add(EcoreUtil.copy(bem.getLibraries()));
								poResource.getContents().add(EcoreUtil.copy(bem.getComponentList()));
								poResource.getContents().add(EcoreUtil.copy(bem.getFormulaList()));

							}
						});
						try {
							poResource.save(null);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}



					}
				}}
			// Get the currently selected file from the editor
		};	

		generateBTCode.setText("Generate BT Code");
		generateBTCode.setToolTipText("Generate the corresponding BT Code of the BE model");
		generateBTCode.setImageDescriptor(getImageDescriptor("icons/generateBTCode.gif"));

		addNewComponent = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";

					WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
							getActiveWorkbenchWindow().getShell(),
							new CreateComponentGraphBTWizard(map, d));
					if(wizardDialog.open() != Window.OK) {
						return;
					}
				}
			}
		};

		addNewComponent.setText("Add new Component");
		addNewComponent.setToolTipText("Add new component to the model");
		addNewComponent.setImageDescriptor(getImageDescriptor("icons/newComponent.gif"));

		manageComponents = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					//String ketemu="";
					if(d!=null) {
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
								getActiveWorkbenchWindow().getShell(),
								new ManageComponentsGraphBTWizard(d));
						if(wizardDialog.open() == Window.OK) {
							return;
						}
					}
				}
			}
		};

		manageComponents.setText("Manage Components");
		manageComponents.setToolTipText("Manage components of the model");
		manageComponents.setImageDescriptor(getImageDescriptor("icons/component.gif"));

		manageRequirements = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";
					if(d!=null) {
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
								getActiveWorkbenchWindow().getShell(),
								new ManageRequirementsGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK) {
							return;
						}
						GraphBTUtil.getBEModel(d,true);
					}
				}
			}
		};
		manageRequirements.setText("Manage Requirements");
		manageRequirements.setToolTipText("Manage Requirements of The Model");
		manageRequirements.setImageDescriptor(getImageDescriptor("icons/requirement.gif"));

		manageLibrary = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					//String ketemu="";
					if(d!=null) {
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
								getActiveWorkbenchWindow().getShell(),
								new ManageLibraryGraphBTWizard(map, de));
						if(wizardDialog.open() != Window.OK) {
							return;
						}
						GraphBTUtil.getBEModel(d,true);
					}
				}
			}
		};

		manageLibrary.setText("Manage Library");
		manageLibrary.setToolTipText("Manage library");
		manageLibrary.setImageDescriptor(getImageDescriptor("icons/manageLibrary.gif"));

		verifyModel = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					HashMap <Integer,String> map = new HashMap<Integer, String>();
					generateSALCode.run();
					if(d!=null) {
						WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().
								getActiveWorkbenchWindow().getShell(),
								new VerifyModelGraphBTWizard(map, d));
						if(wizardDialog.open() != Window.OK) {
							return;
						}
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};

		verifyModel.setText("Verify Model");
		verifyModel.setToolTipText("Verify model");
		verifyModel.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(IDE.SharedImages.IMG_OPEN_MARKER));

		validateBT = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();

					int isValid = GraphBTUtil.isValid(d);

					if(isValid == 1) {
						MessageDialog.openError(null, "Error in validate BT", "The model should contain only one root!");
					}
					else if(isValid == 2) {
						MessageDialog.openError(null, "Error in validate BT", "The model contain invalid reversion node!");
					}
					else
					{
						MessageDialog.openInformation(null, "Validation info", "The model is valid");
					}
				}
			}
		};
		validateBT.setText("Validate BT");
		validateBT.setToolTipText("Validate BT");
		validateBT.setImageDescriptor(getImageDescriptor("icons/validate.gif"));

		this.debugBT = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
					if(GraphBTUtil.isValid(d)>0) {
						MessageDialog.openError(null, "Debug error", "The model is not valid, validate the model first to check error");
						return;
					}
					StartPointParseXML debugger = new StartPointParseXML ();
					generateBTCode.run(); //generate the bt code first
					debugger.showDebugger(btIFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		debugBT.setText("BT Debugger");
		debugBT.setToolTipText("Debug and simulate the model");
		debugBT.setImageDescriptor(getImageDescriptor("icons/debug.gif"));

		this.generateJavaCode = new Action() {
			public void run() {
				generateJavaCode();
			}
		};
		generateJavaCode.setText("BT Code Generator");
		generateJavaCode.setToolTipText("Generate the Java Code");
		generateJavaCode.setImageDescriptor(getImageDescriptor("icons/generateCode.gif"));
		correctLayout = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					DiagramEditor de = (DiagramEditor)activeEditorPart;
					// Get the currently selected file from the editor
					Diagram d = de.getDiagramTypeProvider().getDiagram();
					GraphBTUtil.applyTreeLayout(d);

					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		correctLayout.setText("Apply Layout");
		correctLayout.setToolTipText("Apply layout to the graphical model");
		correctLayout.setImageDescriptor(getImageDescriptor("icons/layout.gif"));
		importBT = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					String filePath = handleBrowse();
					if(filePath==null)
						return;
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IPath path = Path.fromOSString(filePath);

					IFile file = root.getFileForLocation(path);
					final GraphBTDiagramEditor d = ((GraphBTDiagramEditor)activeEditorPart);
					URI uri = d.getDiagramTypeProvider().getDiagram().eResource().getURI();
					uri.trimFragment();
					uri.trimFileExtension();
					uri.appendFileExtension("model");
					IResource res = root.findMember(uri.toPlatformString(true));

					if(filePath == null)
						return;


					BEModel mod = GraphBTUtil.getBEModel(d.getDiagramTypeProvider().getDiagram(),true);
					if(d.getDiagramTypeProvider().getDiagram().getChildren().size() > 0 || mod.getComponentList().getComponents().size() > 0 || mod.getRequirementList().getRequirements().size() > 0) {
						boolean overide=MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Extract confirmation", "Diagram is not empty, are you sure you want to overide current diagram");
						if(!overide) {
							return;
						}
					}

					//TODO ///
					if(filePath.endsWith(".btinfo")){
						ZipFile zip;
						try {
							zip = new ZipFile(filePath);
							File dirs = new File(File.createTempFile("btinfo", "zip").getParentFile()+"/GraphBTTemp");
							if(!dirs.exists())
								dirs.mkdir();
							unzipMyZip(filePath,dirs.getAbsolutePath());
							File newPath = new File(new Path(uri.toPlatformString(true)).toOSString());
							File oldPath = new File(dirs.getAbsolutePath());
							for(int i = 0; i < dirs.listFiles().length; i++)
							{
								File sFile = oldPath.listFiles()[i];
								if(sFile.getAbsolutePath().endsWith(".bt")) {
									filePath = sFile.getAbsolutePath();
								}
								IPath copy = Path.fromPortableString("/"+res.getProject().getName()+"/rbt/"+sFile.getName());
								IFile fi = root.getFile(copy);
								File tFile = new File(fi.getRawLocation().toOSString());
								ProjectUtil.copy(sFile, tFile);
								
							}
							///
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					File f = new File(filePath);
					if(file==null) {
						IPath copy = Path.fromPortableString("/"+res.getProject().getName()+"/rbt/"+f.getName());
						
						file = root.getFile(copy);
						System.out.println(file);
						if(!file.exists()) {
							try {
								file.create(new java.io.FileInputStream(f), true, null);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (CoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(filePath.endsWith(".bt")) {
						final IFile ffTemp = file;
						System.out.println("XXUI "+filePath);
						final String filePathTemp = filePath;
						
						d.getEditingDomain().getCommandStack().execute(new RecordingCommand(d.getEditingDomain(),"clear diagram editor") {
							@Override
							protected void doExecute() {
								
								d.reversionNode.clear();
								d.errorReversionNode.clear();
								Diagram diag = d.getDiagramTypeProvider().getDiagram(); 
								diag.getChildren().clear();
								diag.getConnections().clear();
								diag.getAnchors().clear();
								diag.getPictogramLinks().clear();
								diag.getProperties().clear();
								URI uri = d.getDiagramTypeProvider().getDiagram().eResource().getURI();
								uri = uri.trimFragment();
								uri = uri.trimFileExtension();
								uri = uri.appendFileExtension("model");
								diag.eResource().getResourceSet().getResource(uri, true).getContents().clear();
								GraphBTUtil.generateFromBTFile(ffTemp, d);
								String infoName = filePathTemp.substring(0,filePathTemp.lastIndexOf("."))+".info";
								//System.out.println("AdditionalInfo file name: "+infoName);
								File fTemp = new File(infoName);
								//apply additional information
								if(fTemp.exists()) {
									//System.out.println("AdditionalInformation do existed");

									URI ur = URI.createFileURI(fTemp.getAbsolutePath());
									ResourceSet rs = new ResourceSetImpl();
									Resource resource = rs.getResource(ur, true);
									Iterator<EObject> i = resource.getContents().iterator();
									AdditionalInformation temp = null;
									RequirementList rList = null;
									ComponentList cList = null;
									Libraries rLib = null;
									final BEModel mod1 = GraphBTUtil.getBEModel(d.getDiagramTypeProvider().getDiagram(),true);
									while(i.hasNext()) {
										EObject e = i.next();
										if(e instanceof AdditionalInformation) {
											temp = (AdditionalInformation) e;
										} else if(e instanceof RequirementList) {
											rList = (RequirementList) e;
											mod1.getRequirementList().getRequirements().clear();
											mod1.getRequirementList().getRequirements().addAll(EcoreUtil.copyAll(rList.getRequirements()));
										} else if(e instanceof ComponentList) {
											cList = (ComponentList) e;
											mod1.getComponentList().getComponents().clear();
											mod1.getComponentList().getComponents().addAll(EcoreUtil.copyAll(cList.getComponents()));
										} else if(e instanceof Libraries) {
											rLib = (Libraries) e;
											mod1.getLibraries().getImport().addAll(EcoreUtil.copyAll(rLib.getImport()));
										} else if(e instanceof FormulaList) {
											FormulaList fList = (FormulaList)e;
											mod1.getFormulaList().getFormula().addAll(EcoreUtil.copyAll(fList.getFormula()));
										}
									}
									/*
									if(temp==null)
										return;
									for(int ik = 0; ik < temp.getInfo().size(); ik++) {
										information.put(temp.getInfo().get(ik).getKey(), temp.getInfo().get(ik).getValue());
									}
									//assert the sum of the requirements in the model and in the temp is the same
									for(int i1 = 0; i1 < model.getRequirementList().getRequirements().size(); i1++) {
										//System.out.println("AdditionalInformation extracting: Requirement");
										org.be.graphbt.model.graphbt.Requirement r = model.getRequirementList().getRequirements().get(i1);
										if(information.get(r.getKey()+".desc")!=null) {	
											r.setDescription(information.get(r.getKey()+".desc"));
										}
										if(information.get(r.getKey()+".name")!=null) {	
											r.setDescription(information.get(r.getKey()+".name"));
										}

									}
									//assert the sum of the components in the model and in the temp is the same
									for(int i1 = 0; i1 < model.getComponentList().getComponents().size(); i1++) {
										//System.out.println("AdditionalInformation extracting: Components");
										org.be.graphbt.model.graphbt.Component c = model.getComponentList().getComponents().get(i1);
										if(information.get(c.getComponentRef()+".desc")!=null) {	
											c.setComponentDesc(information.get(c.getComponentRef()+".desc"));
										}
										for(int j = 0; j < c.getBehaviors().size();j++) {
											//System.out.println("AdditionalInformation extracting: Behavior");
											org.be.graphbt.model.graphbt.Behavior b = c.getBehaviors().get(j);
											if(information.get(c.getComponentRef()+b.getBehaviorRef()+".desc")!=null) {
												information.get(c.getComponentRef()+b.getBehaviorRef()+".desc");
											}
										}

									}*/
								}
							}
						});
					}
					else if(!(filePath.endsWith(".bt")||filePath.endsWith(".btinfo"))) {
						MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error reading file", "Only bt file is supported");
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		importBT.setText("Import BT Model");
		importBT.setToolTipText("Import model from BT File");
		importBT.setImageDescriptor(getImageDescriptor("icons/import.gif"));

		clearDiagram = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();

					if(GraphBTUtil.getRoots(d.eResource().getResourceSet()).size() !=0 ) {
						boolean overide=MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Clear confirmation", "Are you sure you want to clear the current diagram? Components and requirements will not be cleared too.");
						if(!overide) {
							return;
						}

					}
					clearDiagram((GraphBTDiagramEditor)activeEditorPart);	
				}

			}
		};
		clearDiagram.setText("Clear editor");
		clearDiagram.setToolTipText("Clear the diagram editor");
		clearDiagram.setImageDescriptor(getImageDescriptor("icons/clear.gif"));

		generateSALCode = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
					if(GraphBTUtil.isValid(d)>0) {
						MessageDialog.openError(null, "SAL generation error", "The model is not valid, validate the model first to check error");
						return;
					}
					generateBTCode.run(); //generate the bt code first
					URI uri = d.eResource().getURI();
					uri = uri.trimFragment();
					uri = uri.trimFileExtension();
					uri = uri.appendFileExtension("sal");

					final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
					IFile file = (IFile) workspaceRoot.findMember(uri.toPlatformString(true));
					{
						Path path = new Path(uri.toPlatformString(true));
						file = workspaceRoot.getFile(path);
						Main.run(GraphBTUtil.getXMLFromBT(btIFile), file);
					}

					try {
						workspaceRoot.refreshLocal(IResource.DEPTH_ONE, null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		generateSALCode.setText("BT to SAL Translator");
		generateSALCode.setToolTipText("Generate the SAL Code");
		generateSALCode.setImageDescriptor(getImageDescriptor("icons/generateSALCode.gif"));

		runCode = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
					if(GraphBTUtil.isValid(d)>0) {
						MessageDialog.openError(null, "Run error", "The model is not valid, validate the model first to check error");
						return;
					}

					try {

						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
						String project =  d.eResource().getURI().toPlatformString(true);
						IResource res = root.findMember(project);
						File absfrontendurl = ProjectUtil.getSharedResource("files/lib/absfrontend.jar");
						String path=root.getRawLocation().toOSString()+res.getProject().getFullPath().toOSString();

						String runCommand = "cmd /c start cmd.exe /k \"c: && " +
								"java -cp "+path+"/src/;"+absfrontendurl+" "+res.getProject().getName()+".Main";
						System.out.println(runCommand);
						Runtime.getRuntime().exec(runCommand);

					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		runCode.setText("Run the code");
		runCode.setToolTipText("Run the generated Code");
		runCode.setImageDescriptor(getImageDescriptor("icons/run.gif"));

		generateDocument = new Action() {
			public void run() {
				//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "Sample Action Executed");
				if(activeEditorPart instanceof DiagramEditor) {
					Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
					if(GraphBTUtil.isValid(d)>0) {
						MessageDialog.openError(null, "Generate document error", "The model is not valid, validate the model first to check error");
						return;
					}

					try {
						//ProjectDocumentation.generate("doc.html");
						throw new IOException();
					}catch (IOException e) {
						e.printStackTrace();
					}
					//MessageDialog.openInformation(null, "Graphiti Sample Sketch (Incubation)", "path: " + path+"\n"+ketemu);
				}
			}
		};
		generateDocument.setText("Generate document");
		generateDocument.setToolTipText("Generate a word document for this project");
		generateDocument.setImageDescriptor(getImageDescriptor("icons/generateDocument.gif"));
	}

	private String handleBrowse() {
		FileDialog dialog = new FileDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.setFilterExtensions(new String [] {"*.btinfo","*.bt"});
		dialog.setFilterPath("C://");

		String path = dialog.open();

		return path;
	}

	private ImageDescriptor getImageDescriptor(String imgPath) {
		Bundle bundle = Activator.getDefault().getBundle();
		IPath path = new Path(imgPath);

		URL fileURL = FileLocator.find(bundle, path, null);
		try {
			fileURL = FileLocator.resolve(fileURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageData im = new ImageData(fileURL.getPath());
		ImageDescriptor imd = ImageDescriptor.createFromImageData(im);
		return imd;
	}

	public void contributeToMenu(IMenuManager manager) {
		IMenuManager menu = new MenuManager("Editor &Menu");
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		menu.add(clearDiagram);
		menu.add(generateBTCode);
		menu.add(addNewComponent);
		menu.add(manageComponents);
		menu.add(manageRequirements);
		menu.add(manageLibrary);
		menu.add(verifyModel);
		menu.add(validateBT);
		menu.add(debugBT);
		menu.add(generateJavaCode);
		menu.add(generateSALCode);
		menu.add(new Separator());
		menu.add(correctLayout);
		menu.add(importBT);
		menu.add(generateDocument);
		menu.add(runCode);
		menu.add(exportBT);
	}

	public void contributeToToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(clearDiagram);
		manager.add(importBT);
		manager.add(exportBT);
		manager.add(new Separator());
		manager.add(addNewComponent);
		manager.add(manageComponents);
		manager.add(manageRequirements);
		manager.add(manageLibrary);
		manager.add(new Separator());
		manager.add(generateBTCode);
		manager.add(generateJavaCode);
		manager.add(generateSALCode);
		manager.add(generateDocument);
		manager.add(new Separator());
		manager.add(correctLayout);
		manager.add(validateBT);
		manager.add(verifyModel);
		manager.add(runCode);
		manager.add(debugBT);
		manager.add(new Separator());
		//manager.add(getAction(GEFActionConstants.ZOOM_OUT));
		//manager.add(getAction(GEFActionConstants.ZOOM_IN));
		ZoomComboContributionItem zoomCombo = new ZoomComboContributionItem(getPage());
		manager.add(zoomCombo);
	}

	private void clearDiagram(final GraphBTDiagramEditor d) {
		d.getEditingDomain().getCommandStack().execute(new RecordingCommand(d.getEditingDomain(),"clear diagram editor") {
			@Override
			protected void doExecute() {
				Diagram diag = d.getDiagramTypeProvider().getDiagram(); 
				diag.getChildren().clear();
				diag.getConnections().clear();
				diag.getAnchors().clear();
				diag.getPictogramLinks().clear();
				diag.getProperties().clear();
				URI uri = d.getDiagramTypeProvider().getDiagram().eResource().getURI();
				uri = uri.trimFragment();
				uri = uri.trimFileExtension();
				uri = uri.appendFileExtension("model");
				Resource res = GraphBTUtil.getResource(diag.eResource().getResourceSet(), uri);
				List<StandardNode> list = GraphBTUtil.getRoots(diag.eResource().getResourceSet());
				for(int i = 0; i < list.size(); i++) {
					EcoreUtil.delete(list.get(i), true);
				}
				d.errorReversionNode.clear();
				d.reversionNode.clear();
			}
		});
	}

	/**
	 * ACTIONS
	 */
	/**
	 * Generate Java Code
	 */
	private void generateJavaCode() {
		if(!(activeEditorPart instanceof DiagramEditor)) {
			return;
		}
		final Diagram d = ((DiagramEditor)activeEditorPart).getDiagramTypeProvider().getDiagram();
		if(GraphBTUtil.isValid(d)>0) {
			MessageDialog.openError(null, "Code generation error", "The model is not valid, validate the model first to check error");
			return;
		}
		//codegenerator.commandHandler.StartPointParseXML debugger = new codegenerator.commandHandler.StartPointParseXML ();
		generateBTCode.run(); //generate the bt code first
		IFile bt = this.btIFile;
		try {
			final File file = GraphBTUtil.getXMLFromBT(bt);
			IWorkspace workspace= ResourcesPlugin.getWorkspace();
			IPath location= Path.fromOSString(file.getAbsolutePath()); 
			IFile xml= workspace.getRoot().getFileForLocation(location);
			System.out.println(xml);
			final IProject ip = bt.getProject();
			String modName = ip.getName();
			StringBuffer strB = new StringBuffer(modName);
			strB.setCharAt(0,(modName.substring(0, 1).toUpperCase().charAt(0)));
			modName = strB.toString();
			final String moduleName = modName; 

			File f = new File(bt.getRawLocation().toOSString());
			final String folder = f.getParentFile().getAbsolutePath();
			System.out.println("nama workspacenya "+folder);

			Job gen = new Job("Generating Java Code...") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						BEModel model = GraphBTUtil.getBEModel(d,true);
						SAXParserFactory factory = SAXParserFactory.newInstance();
						SAXParser saxParser = factory.newSAXParser();

						BTParser bp = new BTParser(moduleName,folder,false);
						saxParser.parse(file, bp);
						ABSModule mod = bp.getABSModule();
						ArrayList<Library> libs = new ArrayList<Library>(model.getLibraries().getImport());
						boolean isCIO = false;
						for(int i = 0; i < libs.size(); i++) {
							if(libs.get(i).getId().contains(".io")){
								isCIO = true;
							}
						}
						if(!isCIO) {
							Library io = GraphBTUtil.getBEFactory().createLibrary();
							io.setId("com.util.pc.io");
							io.setName("IOImpl");
							libs.add(io);
						}
						for(int i = 0; i < libs.size(); i++) {
							ABSForeign f = new ABSForeign();
							mod.addForeign(f);
							f.setName(libs.get(i).getName());
							File []fi = ProjectUtil.getSharedResource("files/lib/dist/"+libs.get(i).getId()).listFiles();
							int j = 0;
							while(j < fi.length) {
								File entry = fi[j];
								j++;
								String entryName = entry.getName();

								BufferedReader in = new BufferedReader(new FileReader(entry));
								String str ;
								StringBuffer buffer = new StringBuffer();
								while((str = in.readLine())!=null) {
									buffer.append(str+"\n");
								}
								if(entryName.endsWith("java.lib")) {
									f.setJavaCode(buffer.toString().trim());
								}
								else if(entryName.endsWith("abs.lib")) {
									f.setABSCode(buffer.toString().trim());
								}
								else if(entryName.endsWith("bt.lib")) {
									//TODO
								}
							}
						}
						for(int i = 0; i < model.getComponentList().getComponents().size(); i++) {
							Component c = model.getComponentList().getComponents().get(i);
							ABSClass absClass = mod.getClass(c.getComponentName()+"_Class");

							for(Library l:c.getUses()) {
								if(l.getName().equals("IOImpl")) {
									continue;
								}
								String type = l.getName()+"_";
								String var = l.getName().toLowerCase()+"_var";
								absClass.addStatement(new ABSStatement(ABSStatementType.DECLARATION, type+" "+var+";"));
								absClass.getMethodImplementation("run").addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT, var+" = new "+l.getName()+"()"));	
							}
							for(Behavior b:c.getBehaviors()) {
								switch(b.getBehaviorType().getValue()) {
								case BehaviorType.STATE_REALIZATION_VALUE:
									String statements = b.getTechnicalDetail();
									ABSMethodImplementation mi = absClass.getMethodImplementation("method"+b.getBehaviorRef());
									mi.addStatement(new ABSStatement(ABSStatementType.BLOCK, statements));
								}
							}
						}
						mod.writeToFile();
						mod.check();
						mod.generate();
						ip.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					} catch (Exception e) {
						// TODO Auto-generated catch block`
						e.printStackTrace();
					}
					return Status.OK_STATUS;
				}
			};
			gen.schedule();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateBTCode() {

	}

	private void validateBTModel() {

	}
	public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);

		ZipEntry zipEntry = new ZipEntry(file.getName());
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
	/**
	 * This method
	 * --Reads an input stream
	 * --Writes the value to the output stream
	 * --Uses 1KB buffer.
	 */
	public static final void writeFile(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len;

		while ((len = in.read(buffer)) > 0)
			out.write(buffer, 0, len);

		in.close();
		out.close();
	}

	public static void unzipMyZip(String zipFileName,
			String directoryToExtractTo) {
		Enumeration entriesEnum;
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(zipFileName);
			entriesEnum = zipFile.entries();

			File directory= new File(directoryToExtractTo);

			/**
			 * Check if the directory to extract to exists
			 */
			if(!directory.exists())
			{
				/**
				 * If not, create a new one.
				 */
				new File(directoryToExtractTo).mkdir();
				System.err.println("...Directory Created -"+directoryToExtractTo);
			}
			while (entriesEnum.hasMoreElements()) {
				try {
					ZipEntry entry = (ZipEntry) entriesEnum.nextElement();

					if (entry.isDirectory()) {
						/**
						 * Currently not unzipping the directory structure.
						 * All the files will be unzipped in a Directory
						 *
						 **/
					} else {

						System.err.println("Extracting file: "
								+ entry.getName());
						/**
						 * The following logic will just extract the file name
						 * and discard the directory
						 */
						int index = 0;
						String name = entry.getName();
						index = entry.getName().lastIndexOf("/");
						if (index > 0 && index != name.length())
							name = entry.getName().substring(index + 1);

						System.out.println(name);

						writeFile(zipFile.getInputStream(entry),
								new BufferedOutputStream(new FileOutputStream(
										directoryToExtractTo +"/"+ name)));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			zipFile.close();
		} catch (IOException ioe) {
			System.err.println("Some Exception Occurred:");
			ioe.printStackTrace();
			return;
		}
	}
}
