package org.be.graphbt.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.be.graphbt.model.graphbt.Attribute;
import org.be.graphbt.model.graphbt.Behavior;
import org.be.graphbt.model.graphbt.BehaviorType;
import org.be.graphbt.model.graphbt.Component;
import org.be.graphbt.model.graphbt.GraphBTFactory;
import org.be.graphbt.model.graphbt.Information;
import org.be.graphbt.model.graphbt.Libraries;
import org.be.graphbt.model.graphbt.Library;
import org.be.graphbt.model.graphbt.MapInformation;
import org.be.graphbt.model.graphbt.MethodDeclaration;
import org.be.graphbt.model.graphbt.Parameter;
import org.be.graphbt.model.graphbt.State;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProjectUtil {
	
	public static String RESOURCE_LOCATION = "resource";
	public static URL getFileLocator(String bundleId,String path) {
		final URL file = FileLocator.find(Platform.getBundle(bundleId), new Path(path),
				null);
		URL base = Platform.getBundle(bundleId).getEntry(path); 
		try {
			URL ul = FileLocator.toFileURL(base);
			return ul;
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File f = FileLocator.getBundleFile(Platform.getBundle(bundleId));
			URL ul = new URL(f.toURI().getPath()+file.getPath());
			return ul;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return file;
	}
	
	public static IProject getProject(Diagram d) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String project =  d.eResource().getURI().toPlatformString(true);
		IResource res = root.findMember(project);
		if(res==null)
			return null;
		return res.getProject();
	}
	
	/**
	 * get file that exists in the shared folder by giving the related path
	 * @param path the path relative to the shared resource
	 * @return
	 */
	public static File getSharedResource(String path) {
		return new File(getFileLocator("org.be.graphbt.common",path).getFile());
	}
	
	/**
	 * Using the parameter, return the resource instance
	 * @param str relative path from the workspace root
	 * @return the resource
	 */
	public static IResource getResource(String str) {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource file = workspaceRoot.findMember(str);
		return file;
				
	}
	
	/**
	 * Copy file from src to target
	 * @param src source file
	 * @param target target file
	 * @throws IOException
	 */
	public static void copy(File src, File target) throws IOException {
		if(!target.exists()) {
			target.createNewFile();
		}
	    InputStream inStream = new FileInputStream(src);
	    OutputStream outStream = new FileOutputStream(target);
	    byte[] buffer = new byte[1024];
	    int length;
	    //copy the file contents in bytes 
	    while ((length = inStream.read(buffer)) > 0) {
	    	outStream.write(buffer, 0, length);
	    }
	    inStream.close();
	    outStream.close();
	}
	
	public static IProject getActiveProject() {
		final IWorkbench iworkbench = PlatformUI.getWorkbench();
		if (iworkbench == null) return null;
		final IWorkbenchWindow iworkbenchwindow[] = new IWorkbenchWindow[1];
		iworkbench.getDisplay().syncExec(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 iworkbenchwindow[0]= iworkbench.getActiveWorkbenchWindow();
			}
		});
		if (iworkbenchwindow[0] == null) return null;
		IWorkbenchPage iworkbenchpage = iworkbenchwindow[0].getActivePage();
		if (iworkbenchpage == null) 
			return null;
		IEditorPart ieditorpart = iworkbenchpage.getActiveEditor();
		IEditorInput input = ieditorpart.getEditorInput();
	      if (!(input instanceof IFileEditorInput))
	         return null;
	      return ((IFileEditorInput)input).getFile().getProject();
	}
	
	public static Image getComponentImageDescription(Component c) {
		String path = ProjectUtil.RESOURCE_LOCATION+"/"+c.getComponentRef();
		Image image = getImageFromPathString(path);
		return image;
	}
	
	public static Image getStateImageDescription(Component c, State s) {
		String path = ProjectUtil.RESOURCE_LOCATION+"/"+c.getComponentRef()+"-"+s.getName();
		Image image = getImageFromPathString(path);
		return image;
	}
	
	/**
	 * This method can be used to get the absolute path of the relative path to the project
	 * @param str the relative path to the project, you should omit the image extension
	 * @return the absolute path of the image
	 */
	public static String getImageAbsolutePath(String str) {
		IProject project = getActiveProject();
		if(project==null) {
			return null;
		}
		IResource resource = project.findMember(str+".png");
		if(resource==null) {
			resource = project.findMember(str+".jpg");
		}
		if(resource==null) {
			return null;
		}
		return resource.getRawLocation().toPortableString();
	}
	
	/**
	 * This method can be used to get the image instance of the relative path to the project
	 * @param str the relative path to the project, you should omit the image extension
	 * @return the image instance, null if no image is corresponded to the given string
	 */
	private static Image getImageFromPathString(String str) {
		IProject project = getActiveProject();
		if(project==null) {
			return null;
		}
		IResource resource = project.findMember(str+".png");
		if(resource==null) {
			resource = project.findMember(str+".jpg");
		}
		if(resource==null) {
			return null;
		}
		Image image;
		try {
			image = new Image(null,
				    ((IFile)resource).getContents());
			return image;
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method can be used to get the available libraries that contained in the plugin
	 * @return the Libraries instance
	 */
	public static Libraries getAvailableLibraries() {
		Bundle bundle = Platform.getBundle("org.be.graphbt.common");
		Enumeration<String> listLib = bundle.getEntryPaths("files/lib/dist");
		Libraries libraries = GraphBTFactory.eINSTANCE.createLibraries();
		while(listLib.hasMoreElements()) {
			String po = listLib.nextElement();
			Library l = GraphBTFactory.eINSTANCE.createLibrary();
			File f = ProjectUtil.getSharedResource(po);
			String name = "";
			String desc = "";
			 //System.out.println(f+" "+f.isDirectory());
			if(f.isDirectory()) {
				File[] files = f.listFiles();
				
				for(int i = 0; i < files.length; i++) {
					if(files[i].getName().endsWith("info.lib")) { 
						try {
							File fXmlFile = files[i];
							DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
							Document doc = dBuilder.parse(fXmlFile);
							//optional, but recommended
							//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
							doc.getDocumentElement().normalize();
							name = doc.getElementsByTagName("name").item(0).getTextContent();
							desc = doc.getElementsByTagName("description").item(0).getTextContent();
							l.setId(f.getName());
							l.setLocation(po);
							l.setDesc(desc);
							l.setName(name);
							NodeList methods = doc.getElementsByTagName("method");
							for(int ii = 0; ii < methods.getLength(); ii++) {
								Node node = methods.item(ii);
								MethodDeclaration md = GraphBTFactory.eINSTANCE.createMethodDeclaration();
								if (node.getNodeType() == Node.ELEMENT_NODE) {
									Element el = (Element) node;
									String mName = el.getAttribute("name");
									String mType = el.getAttribute("type");
									md.setName(mName);
									md.setType(mType);
									l.getMethods().add(md);
									NodeList params = el.getElementsByTagName("param");
									for(int ij = 0; ij < params.getLength(); ij++) {
										Node temp = params.item(ij);
										if (temp.getNodeType() == Node.ELEMENT_NODE) {
											Element e = (Element)temp;
											Parameter param = GraphBTFactory.eINSTANCE.createParameter();
											String pName = e.getAttribute("name");
											String pType = e.getAttribute("type");
											param.setName(pName);
											param.setType(pType);
											md.getParameters().add(param);
										}
									}
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						break;
					} else if(files[i].getName().endsWith("bt.lib")) { 
						try {
							File fXmlFile = files[i];
							DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
							Document doc = dBuilder.parse(fXmlFile);
							doc.getDocumentElement().normalize();
							NodeList attributes = doc.getElementsByTagName("attributes");
							for(int ii = 0; ii < attributes.getLength(); ii++) {
								Node node = attributes.item(ii);
								if (node.getNodeType() == Node.ELEMENT_NODE) {
									Element el = (Element) node;
									NodeList stateNode = el.getElementsByTagName("attribute");
									for(int ij = 0; ij < stateNode.getLength(); ij++) {
										Node temp = stateNode.item(ij);
										if (temp.getNodeType() == Node.ELEMENT_NODE) {
											Element e = (Element)temp;
											Attribute attribute = GraphBTFactory.eINSTANCE.createAttribute();
											String aName = e.getElementsByTagName("name").item(0).getTextContent();
											String aType = e.getElementsByTagName("type").item(0).getTextContent();
											if(e.getElementsByTagName("value").getLength()> 0) {
												String value = e.getElementsByTagName("value").item(0).getTextContent();
												attribute.setValue(value);
											}
											if(e.getElementsByTagName("description").getLength()> 0) {
												String aDescription = e.getElementsByTagName("description").item(0).getTextContent();
												attribute.setDesc(aDescription);
											}
											attribute.setType(aType);
											attribute.setName(aName);
											l.getAttributes().add(attribute);
										}
									}
								}
							}
							NodeList behaviors = doc.getElementsByTagName("behaviors");
							for(int ii = 0; ii < behaviors.getLength(); ii++) {
								Node node = behaviors.item(ii);
								if (node.getNodeType() == Node.ELEMENT_NODE) {
									Element el = (Element) node;
									NodeList stateNode = el.getElementsByTagName("behavior");
									for(int ij = 0; ij < stateNode.getLength(); ij++) {
										Node temp = stateNode.item(ij);
										if (temp.getNodeType() == Node.ELEMENT_NODE) {
											Element e = (Element)temp;
											Behavior behavior = GraphBTFactory.eINSTANCE.createBehavior();
											String bName = e.getElementsByTagName("name").item(0).getTextContent();
											String bType = e.getElementsByTagName("type").item(0).getTextContent();
											if(e.getElementsByTagName("detail").getLength()> 0) {
												String bDetail = e.getElementsByTagName("detail").item(0).getTextContent();
												behavior.setTechnicalDetail(bDetail);
											}
											if(e.getElementsByTagName("description").getLength()> 0) {
												String bDescription = e.getElementsByTagName("description").item(0).getTextContent();
												behavior.setBehaviorDesc(bDescription);
											}
											behavior.setBehaviorType(BehaviorType.getByName(bType));
											behavior.setBehaviorName(bName);
											behavior.setBehaviorRef(ij+"");
											l.getBehaviors().add(behavior);
										}
									}
								}
							}
							
							NodeList states = doc.getElementsByTagName("states");
							for(int ii = 0; ii < states.getLength(); ii++) {
								Node node = states.item(ii);
								if (node.getNodeType() == Node.ELEMENT_NODE) {
									Element el = (Element) node;
									NodeList stateNode = el.getElementsByTagName("state");
									for(int ij = 0; ij < stateNode.getLength(); ij++) {
										Node temp = stateNode.item(ij);
										if (temp.getNodeType() == Node.ELEMENT_NODE) {
											Element e = (Element)temp;
											State state = GraphBTFactory.eINSTANCE.createState();
											String sName = e.getElementsByTagName("name").item(0).getTextContent();
											String sDesc = e.getElementsByTagName("description").item(0).getTextContent();
											state.setDesc(sDesc);
											state.setName(sName);
											state.setRef("S"+ij);
											NodeList attrs = e.getElementsByTagName("attribute");
											for(int ik = 0; ik < attrs.getLength(); ik++) {
												Element k = (Element)attrs.item(ik);
												String aName = e.getElementsByTagName("name").item(0).getTextContent();
												String aValue = e.getElementsByTagName("value").item(0).getTextContent();
												state.getAttributes().setValue(aName, aValue);
											}
											l.getStates().add(state);
										}
									}
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			libraries.getImport().add(l);
		}
		return libraries;
	}
}
