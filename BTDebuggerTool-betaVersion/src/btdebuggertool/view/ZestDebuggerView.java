package btdebuggertool.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.ISourceProviderService;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;

import bt.model.BTNode;
import bt.model.BTNodeType;
import bt.model.BTTree;
import btdebuggertool.figure.BTGraphNode;
import btdebuggertool.figure.IBTNodeFigure;
import btdebuggertool.simulator.BTSimulator;
import btdebuggertool.sourceProvider.DebugToolsCommandSourceProvider;
import btdebuggertool.zestprovider.BTNodeModelContentProvider;


public class ZestDebuggerView extends ViewPart implements IZoomableWorkbenchPart {
	private static ZestDebuggerView instance;
	public static final String ID = "btdebuggertool.perspective.DebuggerPerspective";
	
	private BTTree tree;

	private GraphViewer viewer;

	private Graph graph;
	private HashMap<BTNode, BTGraphNode> mapDataToGraph;
	private HashMap<BTGraphNode, BTNode> mapGraphToData;
	private BTSimulator simulator;
	public ZestDebuggerView(){
		instance = this;
	}
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		fillToolBar(parent);
		activateHandler();


	}

	private void activateHandler() {
		ISourceProviderService service = (ISourceProviderService) getSite().getService(ISourceProviderService.class);
		DebugToolsCommandSourceProvider sourceProvider = (DebugToolsCommandSourceProvider) service.getSourceProvider(DebugToolsCommandSourceProvider.PLAY_COMMAND_STATE);

		sourceProvider.setPlayState(true);
		sourceProvider.setStopState(false);
		sourceProvider.setPauseState(false);
		sourceProvider.setStepState(false);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void setInput(BTSimulator simulator) {
		this.simulator = simulator;
		this.tree = simulator.getBtTree();
		this.graph = this.viewer.getGraphControl();
		this.graph.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				if(!pause)
					return;
				Object selected = ((Graph)e.widget).getSelection().get(0);
				if(selected instanceof BTGraphNode){
					BTNode selectedNode = mapGraphToData.get(selected);
					IBTNodeFigure fig = (IBTNodeFigure)((BTGraphNode)selected).getFigure();
					if(selectedNode.isBreakPointed()){
						System.out.println("Black");
						((IBTNodeFigure)fig).setBorderColor(ColorConstants.black);
					}
					else{
						System.out.println("Red");
						((IBTNodeFigure)fig).setBorderColor(ColorConstants.red);
					}
					selectedNode.setBreakPointed(!selectedNode.isBreakPointed());
				
//					}else if(fig instanceof BTNodeFigureWithRelations){
//						if(selectedNode.isBreakPointed())
//							((BTNodeFigureWithRelations)fig).setBorderColor(ColorConstants.black);
//						else
//							((BTNodeFigureWithRelations)fig).setBorderColor(ColorConstants.red);
//						selectedNode.setBreakPointed(!selectedNode.isBreakPointed());
//					}else if()
				}
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		/*this.graph.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Object selected = ((Graph)e.widget).getSelection().get(0);
				if(selected instanceof BTGraphNode){
					BTNode selectedNode = mapGraphToData.get(selected);
					IFigure fig = ((BTGraphNode)selected).getFigure();
					if(fig instanceof BTNodeFigure){
						if(selectedNode.isBreakPointed())
							((BTNodeFigure)fig).setBorderColor(ColorConstants.black);
						else
							((BTNodeFigure)fig).setBorderColor(ColorConstants.red);
						selectedNode.setBreakPointed(!selectedNode.isBreakPointed());
					}else if(fig instanceof BTNodeFigureWithRelations){
						if(selectedNode.isBreakPointed())
							((BTNodeFigureWithRelations)fig).setBorderColor(ColorConstants.black);
						else
							((BTNodeFigureWithRelations)fig).setBorderColor(ColorConstants.red);
						selectedNode.setBreakPointed(!selectedNode.isBreakPointed());
					}
				}
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});*/
		//clear the nodes and connection
		clearGraph(this.graph);
		
		
		this.setMapDataAndGraph(ZestDebuggerView.buildGraphNodeAndTree(this.tree, this.graph));
		
		this.viewer.setLayoutAlgorithm(setLayout());
		this.viewer.applyLayout();
	}
	
	private void setToCenter(final BTNode node, final int animationDelay){
		BTGraphNode graphNode = this.mapDataToGraph.get(node);
		if(graphNode!=null){
			org.eclipse.swt.graphics.Rectangle rectParent = this.graph.getBounds();
			Rectangle rectNode = graphNode.getFigure().getBounds();
			int centerXNode = rectNode.x + rectNode.width / 2;
			int centerYNode = rectNode.y + rectNode.height / 2;

			int centerXParent = rectParent.x + rectParent.width / 2;
			int centerYParent = rectParent.y + rectParent.height / 2;

			final int selisihX = centerXNode - centerXParent;
			final int selisihY = centerYNode - centerYParent;
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					Animation.markBegin();
					List nodes = graph.getNodes();
					
					for (Object itemNode : nodes) {
						Point p = ((GraphNode)itemNode).getLocation();
						((GraphNode)itemNode).setLocation(p.x - selisihX, p.y - selisihY);
					}
					Animation.run(animationDelay);
					BTGraphNode awal = mapDataToGraph.get(startNode);
				}
				
			});
		}else{
			System.out.println("Set To Center is failed");
		}
		
	}
	
	private void setActiveNode(BTNode node, int animationDelay) {
		BTGraphNode graphNode = this.mapDataToGraph.get(node);
		if(graphNode!=null){
			graphNode.getFigure().setBackgroundColor(BTColorConstanta.CURRENT_ACTIVE);
		}
	}
	private void setInterleaveNodes(ArrayList<BTNode> nodes, int animationDelay) {
		for (BTNode node : nodes) {
			BTGraphNode graphNode = this.mapDataToGraph.get(node);
			if(graphNode!=null){
				graphNode.getFigure().setBackgroundColor(BTColorConstanta.INTERLEAVE_ACTIVE);
			}
		}
		
	}
	private void setNonActiveNode(BTNode node, int animationDelay) {
		BTGraphNode graphNode = this.mapDataToGraph.get(node);
		if(graphNode!=null){
			graphNode.getFigure().setBackgroundColor(BTColorConstanta.NOT_ACTIVE);
		}
	}
	
	private void fillToolBar(Composite parent) {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(
				this);
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager dropDownMenu = bars.getMenuManager();
		dropDownMenu.add(toolbarZoomContributionViewItem);
		
	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}

	private LayoutAlgorithm setLayout() {
		LayoutAlgorithm layout;
		int styles = LayoutStyles.NO_LAYOUT_NODE_RESIZING;
		layout = new CompositeLayoutAlgorithm(styles, new LayoutAlgorithm[]{new GXTreeLayoutAlgorithm(styles), new ShiftDiagramLayoutAlgorithm(styles)});

		//new CompositeLayoutAlgorithm(styles, new LayoutAlgorithm[] {new TreeLayoutAlgorithm(styles), new HorizontalShift(styles) });
		
		// layout = new
		// SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		// layout = new TreeLayoutAlgorithm(LayoutStyles.NONE);
		// layout = new
		// GridLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		// layout = new
		// HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		// layout = new
		// RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		return layout;

	}

	private static HashMap<BTNode, BTGraphNode> buildGraphNodeAndTree(
			BTTree tree, Graph graph) {
		HashMap<BTNode, BTGraphNode> result = new HashMap<BTNode, BTGraphNode>();

		BTNode root = tree.getRoot();
		if (root != null) {
			LinkedList<TempData> queue = new LinkedList<TempData>();
			TempData rootData = new TempData();
			rootData.data = root;
			rootData.figure = BTNodeModelContentProvider
					.getFigureDefinition(root);
			rootData.graphNode = new BTGraphNode(graph, SWT.NONE,
					rootData.figure);
			queue.add(rootData);

			while (queue.size() > 0) {
				TempData currentParentData = queue.poll();
				// add to arraylist
				result.put(currentParentData.data, currentParentData.graphNode);
				ArrayList<BTNode> childs = null;
				//jika dia punya anak parallel node
				if(currentParentData.data.hasParallelChild()){
					System.out.println("ADA YANG PUNYA ANAK PARALLEL : "+currentParentData.data.getBTComponent().getName());
					childs = currentParentData.data.getUndirectChildren();
				}else{
					BTNode tempNode = currentParentData.data;
					if(tempNode.getBTNodeType() == BTNodeType.ATOMICNODE){
	    				boolean hasAtomicChildToo = false;
	    				ArrayList<BTNode> nodes = null;
	    				do{
	    					hasAtomicChildToo = false;
	        				nodes = tempNode.getDirectChilds();
		    				for (BTNode btNode : nodes) {
								if(btNode.getBTNodeType() == BTNodeType.ATOMICNODE){
									hasAtomicChildToo = true;
									break;
								}
							}
		    				if(hasAtomicChildToo && nodes.size() > 1){
		    					throw new IllegalStateException("Atomic Child can't have more than 1 atomic childs 'A', which A has another sibling");
		    				}else if(hasAtomicChildToo && nodes.size() == 1){
		    					tempNode = nodes.get(0);
		    				}
	    				}while(hasAtomicChildToo);
	    				
	    				if(nodes!=null && nodes.size() > 0){
	    					childs = nodes;
	    				}
	    			}else{
	    				childs = tempNode.getDirectChilds();
	    			}
				}

				// setting up the connection 
				for (BTNode btNode : childs) {
					if(btNode.getBTNodeType() == BTNodeType.PARALLELBLOCK)
						continue;
					TempData childData = new TempData();
					childData.data = btNode;
					childData.figure = BTNodeModelContentProvider
							.getFigureDefinition(btNode);
					childData.graphNode = new BTGraphNode(graph, SWT.NONE,
							childData.figure);
					new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED,
							currentParentData.graphNode, childData.graphNode);
					queue.add(childData);
				}
			}
		}

		return result;
	}

	static class TempData {
		public BTGraphNode graphNode;
		public BTNode data;
		public IFigure figure;
	}
	
	private void clearGraph(Graph g) {

		// remove all the connections
		Object[] objects = g.getConnections().toArray();

		for (int x = 0; x < objects.length; x++) {
			((GraphConnection) objects[x]).dispose();
		}

		// remove all the nodes

		objects = g.getNodes().toArray();

		for (int x = 0; x < objects.length; x++) {
			((GraphNode) objects[x]).dispose();
		}

	}

	public HashMap<BTNode, BTGraphNode> getMapDataAndGraph() {
		return mapDataToGraph;
	}

	public void setMapDataAndGraph(HashMap<BTNode, BTGraphNode> mapDataAndGraph) {
		this.mapDataToGraph = mapDataAndGraph;
		this.mapGraphToData = new HashMap<BTGraphNode, BTNode>();
		Set<BTNode> set = this.mapDataToGraph.keySet();
		for (BTNode btNode : set) {
			BTGraphNode graphNode = this.mapDataToGraph.get(btNode);
			this.mapGraphToData.put(graphNode, btNode);
		}
	}
	private BTNode currentActiveNode;
	private Thread playThreadAnimation;
	public void play_Event(){
		pause = false;
		stop = false;
		System.out.println("Play");
		ISourceProviderService service = (ISourceProviderService) getSite().getService(ISourceProviderService.class);
		DebugToolsCommandSourceProvider sourceProvider = (DebugToolsCommandSourceProvider) service.getSourceProvider(DebugToolsCommandSourceProvider.PLAY_COMMAND_STATE);

		sourceProvider.setPlayState(false);
		sourceProvider.setStopState(true);
		sourceProvider.setPauseState(true);
		sourceProvider.setStepState(true);
		if(this.currentActiveNode == null){
			this.currentActiveNode = this.simulator.startExecute(this);
			this.startNode = currentActiveNode;
	
			setToCenter(currentActiveNode, ANIMATION_DELAY);
			setActiveNode(currentActiveNode, ANIMATION_DELAY);
		}
		if(playThreadAnimation == null || !playThreadAnimation.isAlive()){
		
			playThreadAnimation = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(!pause && !error){
						try {
							Thread.sleep(EXECUTION_DELAY);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Display.getDefault().syncExec(new Runnable() {
							
							@Override
							public void run() {
								try{
									if(currentActiveNode.isBreakPointed()){
										pause_Event();
										return;
									}
		
									setNonActiveNode(currentActiveNode, ANIMATION_DELAY);
									currentActiveNode = simulator.executeAndReturnNextNode(currentActiveNode, ZestDebuggerView.this);
									
									if(currentActiveNode == null){
										if(simulator.isEmpty()){
											if(MessageDialog.openQuestion(ZestDebuggerView.this.getSite().getShell(), "Finish", "The execution is finished. Do you want to save the animation into .btt (trace file) ?")){
												FileDialog fd = new FileDialog(ZestDebuggerView.this.getSite().getShell(), SWT.SAVE);
										        fd.setText("Save");
										        fd.setFilterPath("C:/");
										        String[] filterExt = { "*.btt", "*.*" };
										        fd.setFilterExtensions(filterExt);
										        String selected = fd.open();
										        System.out.println(selected);
										        
										        if(selected != null){
										        	if(simulator.saveTraceToFile(selected))
										        		MessageDialog.openInformation(ZestDebuggerView.this.getSite().getShell(), "Success", "The BT Trace has been saved successfully");
										        	else
										        		MessageDialog.openError(ZestDebuggerView.this.getSite().getShell(), "Failure", "The BT Trace can't be saved");
										        	
										        }
											}
											
											finish = true;
										}
										else{
											System.out.println("ANEH : ");
											System.out.println(currentActiveNode);
										}
									}
									if(currentActiveNode!=null){
										setToCenter(currentActiveNode, ANIMATION_DELAY);
										setActiveNode(currentActiveNode, ANIMATION_DELAY);
										ArrayList<BTNode> interleaveNodes = simulator.getInterleaveNodes(currentActiveNode);
										setInterleaveNodes(interleaveNodes, ANIMATION_DELAY);
									}
								}catch(Exception e){
									e.printStackTrace();
									MessageDialog.openError(ZestDebuggerView.this.getSite().getShell(), "Failure", e.getMessage());
									error = true;
								}
							}
								
						});
						if(finish || error){
							Display.getDefault().asyncExec(new Runnable() {
								
								@Override
								public void run() {
									stop_Event();
								}
							});
							
							break;
						}
					}
				}
			});
			playThreadAnimation.start();
		}
	}
	private BTNode startNode = null;
	

	@SuppressWarnings("deprecation")
	public void stop_Event(){
		System.out.println("Stop");
		stop = true;
		pause = true;
		if(playThreadAnimation != null && (playThreadAnimation.isAlive() || playThreadAnimation.isDaemon()) )
			playThreadAnimation.stop();
		ISourceProviderService service = (ISourceProviderService) getSite().getService(ISourceProviderService.class);
		DebugToolsCommandSourceProvider sourceProvider = (DebugToolsCommandSourceProvider) service.getSourceProvider(DebugToolsCommandSourceProvider.PLAY_COMMAND_STATE);

		sourceProvider.setPlayState(true);
		sourceProvider.setStopState(false);
		sourceProvider.setPauseState(false);
		sourceProvider.setStepState(false);
		IWorkbenchPage page = getSite().getPage();
		System.out.println("page:"+page);
		if(page!=null){
			IPerspectiveDescriptor perspective = page.getPerspective();
			if(perspective!=null){
				page.closePerspective(perspective, false, true);
			}
		}
		
	}
	
	public void pause_Event(){
		System.out.println("Pause");
		pause = true;
		
		ISourceProviderService service = (ISourceProviderService) getSite().getService(ISourceProviderService.class);
		DebugToolsCommandSourceProvider sourceProvider = (DebugToolsCommandSourceProvider) service.getSourceProvider(DebugToolsCommandSourceProvider.PLAY_COMMAND_STATE);

		sourceProvider.setPlayState(true);
		sourceProvider.setStopState(true);
		sourceProvider.setPauseState(false);
		sourceProvider.setStepState(true);
		
	}
	
	public void step_Event(){
		
		System.out.println("Step");
		ISourceProviderService service = (ISourceProviderService) getSite().getService(ISourceProviderService.class);
		DebugToolsCommandSourceProvider sourceProvider = (DebugToolsCommandSourceProvider) service.getSourceProvider(DebugToolsCommandSourceProvider.PLAY_COMMAND_STATE);

		sourceProvider.setPlayState(true);
		sourceProvider.setStopState(true);
		sourceProvider.setPauseState(false);
		sourceProvider.setStepState(true);

		setNonActiveNode(currentActiveNode, ANIMATION_DELAY);
		try{
			currentActiveNode = simulator.executeAndReturnNextNode(currentActiveNode, ZestDebuggerView.this);
		
			
			if(currentActiveNode == null){
				if(simulator.isEmpty()){
					if(MessageDialog.openQuestion(ZestDebuggerView.this.getSite().getShell(), "Finish", "The execution is finished. Do you want to save the animation into .btt (trace file) ?")){
						FileDialog fd = new FileDialog(ZestDebuggerView.this.getSite().getShell(), SWT.SAVE);
				        fd.setText("Save");
				        fd.setFilterPath("C:/");
				        String[] filterExt = { "*.btt", "*.*" };
				        fd.setFilterExtensions(filterExt);
				        String selected = fd.open();
				        System.out.println(selected);
				        
				        if(selected != null){
				        	if(simulator.saveTraceToFile(selected))
				        		MessageDialog.openInformation(ZestDebuggerView.this.getSite().getShell(), "Success", "The BT Trace has been saved successfully");
				        	else
				        		MessageDialog.openError(ZestDebuggerView.this.getSite().getShell(), "Failure", "The BT Trace can't be saved");
				        }
					}
					finish = true;
				}
				else{
					System.out.println("ANEH : ");
					System.out.println(currentActiveNode);
				}
			}
		
		
			if(currentActiveNode!=null){
				setToCenter(currentActiveNode, ANIMATION_DELAY);
				setActiveNode(currentActiveNode, ANIMATION_DELAY);
				ArrayList<BTNode> interleaveNodes = simulator.getInterleaveNodes(currentActiveNode);
				setInterleaveNodes(interleaveNodes, ANIMATION_DELAY);
			}
		}catch(Exception e){
			e.printStackTrace();
			MessageDialog.openError(ZestDebuggerView.this.getSite().getShell(), "Failure", e.getMessage());
			error = true;
		}
		if(error){

			sourceProvider.setPlayState(false);
			sourceProvider.setStopState(true);
			sourceProvider.setPauseState(false);
			sourceProvider.setStepState(false);
			return;
		}
		if(finish){
			sourceProvider.setPlayState(true);
			sourceProvider.setStopState(false);
			sourceProvider.setPauseState(false);
			sourceProvider.setStepState(false);
		}
//		
//		setNonActiveNode(this.currentActiveNode, 400);
//		this.currentActiveNode = this.simulator.executeAndReturnNextNode(this.currentActiveNode, this);
//		setToCenter(currentActiveNode, 400);
//		setActiveNode(currentActiveNode, 400);
	}
	
	public static ZestDebuggerView getInstance(){
		return instance;
	}
	
	public static class BTColorConstanta{
		public static Color NOT_ACTIVE = new Color(null, 179, 211, 69);
		public static Color CURRENT_ACTIVE = new Color(null, 251, 245, 173);
		public static Color INTERLEAVE_ACTIVE = new Color(null, 207, 250, 143);
	}
	
	private boolean pause = true;
	private boolean stop = false;
	private boolean finish = false;
	private boolean error = false;
	
	private static final int ANIMATION_DELAY = 100;
	private static final int EXECUTION_DELAY = 1000;
	
	public void save_Event() {
		FileDialog fd = new FileDialog(ZestDebuggerView.this.getSite().getShell(), SWT.SAVE);
        fd.setText("Save");
        fd.setFilterPath("C:/");
        String[] filterExt = { "*.jpg"};
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        System.out.println(selected);
        
        if(selected != null){
        	GC gc = new GC(viewer.getControl());
    		org.eclipse.swt.graphics.Rectangle bounds = viewer.getControl().getBounds();
    		
    		Image image = new Image(viewer.getControl().getDisplay(), bounds);
    		try {
    		    gc.copyArea(image, 0, 0);
    		    ImageLoader imageLoader = new ImageLoader();
    		    imageLoader.data = new ImageData[] { image.getImageData() };
    		    imageLoader.save(selected, SWT.IMAGE_JPEG);
    		    MessageDialog.openInformation(ZestDebuggerView.this.getSite().getShell(), "Success", "The image has been saved successfully");
    		}catch (Exception e) {
				e.printStackTrace();
				MessageDialog.openError(ZestDebuggerView.this.getSite().getShell(), "Failure", "The image can't be saved");
			} finally {
    		    image.dispose();
    		    gc.dispose();
    		}        		
        }
        
		
	}
}

