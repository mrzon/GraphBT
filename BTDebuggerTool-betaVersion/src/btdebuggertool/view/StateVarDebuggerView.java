package btdebuggertool.view;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import bt.model.BTComponent;
import btdebuggertool.simulator.BTSimulator;
import btdebuggertool.simulator.BTSimulator.DataListener;


public class StateVarDebuggerView extends ViewPart {
	public static final String ID = "btdebuggertool.view.StateVarDebuggerView";
	private Tree tree;
	private HashMap<String, HashMap<String, TreeItem>> mapVariableTreeValue;
	
	public StateVarDebuggerView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		this.tree = new Tree(parent, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		this.tree.setHeaderVisible(true);
		this.tree.setLinesVisible(true);
		
		TreeColumn nameColumn = new TreeColumn(tree, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(100);
		
		
		TreeColumn valueColumn = new TreeColumn(tree, SWT.RIGHT);
		valueColumn.setText("Value");
		valueColumn.setWidth(100);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void setInput(final BTSimulator simulator){
		TreeItem[] items = this.tree.getItems();
		for (TreeItem treeItem : items) {
			treeItem.dispose();
		}
		this.mapVariableTreeValue = new HashMap<String, HashMap<String,TreeItem>>();
		
		Set<BTComponent> comp = simulator.getBtTree().getComponents();
		for (BTComponent btComponent : comp) {
			if(btComponent!=null){
				HashMap<String, TreeItem> mapTreeItem = new HashMap<String, TreeItem>();
				
				String compName = btComponent.getName();
				TreeItem componentItem = new TreeItem(tree, SWT.BORDER);
				componentItem.setText(compName);
				
				Set<String> intVar = simulator.getAllIntegerVar(compName);
				if(intVar!=null)
				for (String string : intVar) {
					TreeItem subItem = new TreeItem(componentItem, SWT.BORDER);
					subItem.setText(new String[]{string, ""+simulator.getIntegerVariableValue(compName, string)});
					mapTreeItem.put(string, subItem);
				}
				Set<String> boolVar = simulator.getAllBooleanVar(compName);
				if(boolVar!=null)
				for (String string : boolVar) {
					TreeItem subItem = new TreeItem(componentItem, SWT.BORDER);
					subItem.setText(new String[]{string, ""+simulator.getBooleanVariableValue(compName, string)});
					mapTreeItem.put(string, subItem);
				}
				Set<String> undefVar = simulator.getAllUndefineVar(compName);
				if(undefVar!=null)
				for (String string : undefVar) {
					TreeItem subItem = new TreeItem(componentItem, SWT.BORDER);
					subItem.setText(new String[]{string, "N/A"});
					mapTreeItem.put(string, subItem);
				}
				this.mapVariableTreeValue.put(btComponent.getName(), mapTreeItem);
				componentItem.setExpanded(true);
				
			}
		}
		
//		this.tree.pack();
		
		
		//set listener if data changed
		simulator.setOnDataChangedListener(new DataListener() {
			
			@Override
			public void onDataChanged(String componentName, String variableName, String value) {
				final TreeItem item = mapVariableTreeValue.get(componentName).get(variableName);
				
				item.setText(new String[]{variableName, value});
				item.setForeground(ColorConstants.red);
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Display.getDefault().syncExec(new Runnable() {
							
							@Override
							public void run() {
								item.setForeground(ColorConstants.black);
							}
						});
						
						
						
					}
				}).start();
				
			}
		});
	}

}
