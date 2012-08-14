package btdebuggertool.simulator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.MessageConsoleStream;

import bt.model.BTBehaviorType;
import bt.model.BTComponent;
import bt.model.BTNode;
import bt.model.BTNodeOperator;
import bt.model.BTNodeType;
import bt.model.BTTree;
import btdebuggertool.view.ZestDebuggerView;


public class BTSimulator {
	/*
	 * Tree yang akan dieksekusi
	 */
	private BTTree btTree;
	
	/*
	 * Untuk menyimpan nilai state variable dari tiap component. Yaitu support untuk tipe data INT dan BOOL. Jika pada saat parsing tidak ditemukan tipe datanya, maka akan dimasukkan ke dalam undefine data type (string)
	 */
	private HashMap<String, HashMap<String, Integer>> mapComponentIntegerVar;
	private HashMap<String, HashMap<String, Boolean>> mapComponentBooleanVar;
	private HashMap<String, HashMap<String, String>> mapComponentUndefineVar;
	
	/*
	 * Untuk menyimpan data-data pada LIST dan SET
	 */
	private ArrayList<Object> listData;
	private HashSet<Object> setData;
	
	/**
	 * untuk menampilkan pesan ke console (ExternalOutput)
	 */
	private MessageConsoleStream out;
	

	/*
	 * Untuk Kebutuhan mencatat trace
	 */
	private ArrayList<String> externalInputTrace = new ArrayList<String>();
	private ArrayList<String> externalOutputTrace = new ArrayList<String>();
	private ArrayList<ExecutionNode> nodeTrace = new ArrayList<ExecutionNode>();
	
	/**
	 * Struktur Data untuk menyimpan nilai node number dari active node dan interleave node pada suatu waktu
	 * @author agung
	 *
	 */
	static class ExecutionNode{
		public int activeNode;
		public int[] interleaveNodes;
	}
	

	/**
	 * List node yang akan dieksekusi (secara random) 
	 */
	private ArrayList<BTNode> queue = new ArrayList<BTNode>();
	
	/**
	 * Untuk menampung process id yang sedang aktif
	 */
	private HashSet<Integer> processNumber = new HashSet<Integer>();
	
	/**
	 * Untuk monitor next process ID yang available (dilakukan secara incremental)
	 */
	private int counterProcessID = 0;
	
	private BTNode beforeNode = null;
	private int sameCounter = 0;
	

	/*
	 * UNTUK KEPERLUAN SCHEDULLING PROCESS
	 */
	private final static int MAX_QUANTUM_TIME = 10;
	private final static int MIN_QUANTUM_TIME = 5;
	private int quantumTime = -1;
	private int currentProcessID = -1;
	private Random random = new Random(System.currentTimeMillis());
	
	
	/*
	 * Untuk keperluan menampung input dan output ketika ada Node Behavior ExternalInput/Output, dan InternalInput/Output
	 * Jadi ada message passing di sini antar komponen
	 */
//	private LinkedList<InputOutputData> externalIOBuffer;
	private HashMap<String, InternalInputOutputData> internalIOBuffer;
	
	public BTSimulator(BTTree tree, MessageConsoleStream out){
		this.btTree = tree;
		this.out = out;
		this.mapComponentBooleanVar = new HashMap<String, HashMap<String,Boolean>>();
		this.mapComponentIntegerVar = new HashMap<String, HashMap<String,Integer>>();
		this.mapComponentUndefineVar = new HashMap<String, HashMap<String,String>>();
	}
	
	public BTTree getBtTree() {
		return btTree;
	}
	
	public void setBtTree(BTTree btTree) {
		this.btTree = btTree;
	}
	
	/**
	 * Method ini harus dipanggil setelah BTSimultor telah selesai di construct.
	 * Yang dilakukan adalah mengumpulkan/mengorganisasi nilai-nilai state variable pada masing-masing komponen ke dalam struktur data BTTree 
	 */
	public void init(){
		for (BTComponent component : btTree.getComponents()) {
			String compName = component.getName();
			for (String intVarname : component.getIntVar()) {
				addToLookupIntegerVariable(compName, intVarname);
			}
			for (String boolVarname : component.getBoolVar()) {
				addToLookupBooleanVariable(compName, boolVarname);
			}
			for (String undefVarname : component.getUndefVar()){
				addToLookupUndefineVariable(compName, undefVarname);
			}
		}
	}
	
	private void addToLookupIntegerVariable(String componentName, String variableName){
		if(this.mapComponentIntegerVar!=null){
			HashMap<String, Integer> lookup = this.mapComponentIntegerVar.get(componentName);
			if(lookup == null){
				lookup = new HashMap<String, Integer>();
				lookup.put(variableName, 0);
				this.mapComponentIntegerVar.put(componentName, lookup);
			}else{
				lookup.put(variableName, 0);
			}
		}
	}
	
	private void addToLookupBooleanVariable(String componentName, String variableName){
		if(this.mapComponentBooleanVar!=null){
			HashMap<String, Boolean> lookup = this.mapComponentBooleanVar.get(componentName);
			if(lookup == null){
				lookup = new HashMap<String, Boolean>();
				lookup.put(variableName, false);
				this.mapComponentBooleanVar.put(componentName, lookup);
			}else{
				lookup.put(variableName, false);
			}
		}
	}
	
	private void addToLookupUndefineVariable(String componentName, String variableName){
		if(this.mapComponentUndefineVar!=null){
			HashMap<String, String> lookup = this.mapComponentUndefineVar.get(componentName);
			if(lookup == null){
				lookup = new HashMap<String, String>();
				lookup.put(variableName, "N/A");
				this.mapComponentUndefineVar.put(componentName, lookup);
			}else{
				lookup.put(variableName, "N/A");
			}
		}
	}
	
	public int getIntegerVariableValue(String componentName, String variableName){
		if(this.mapComponentIntegerVar!=null){
			HashMap<String, Integer> lookup = this.mapComponentIntegerVar.get(componentName);
			if(lookup == null){
				return 0;
			}else{
				return lookup.get(variableName);
			}
		}
		return 0;
	}
	
	public boolean getBooleanVariableValue(String componentName, String variableName){
		if(this.mapComponentBooleanVar!=null){
			HashMap<String, Boolean> lookup = this.mapComponentBooleanVar.get(componentName);
			if(lookup == null){
				return false;
			}else{
				return lookup.get(variableName);
			}
		}
		return false;
	}

	public HashMap<String, HashMap<String, String>> getMapComponentUndefineVar() {
		return mapComponentUndefineVar;
	}

	public void setMapComponentUndefineVar(HashMap<String, HashMap<String, String>> mapComponentUndefineVar) {
		this.mapComponentUndefineVar = mapComponentUndefineVar;
	}
	
	
	public Set<String> getAllIntegerVar(String componentName){
		HashMap<String, Integer> map = this.mapComponentIntegerVar.get(componentName);
		if(map!=null){
			return map.keySet();
		}else{
			return null;
		}
		
	}
	public Set<String> getAllBooleanVar(String componentName){
		HashMap<String, Boolean> map = this.mapComponentBooleanVar.get(componentName);
		if(map!=null){
			return map.keySet();
		}else{
			return null;
		}
	}
	public Set<String> getAllUndefineVar(String componentName){
		HashMap<String, String> map = this.mapComponentUndefineVar.get(componentName);
		if(map!=null){
			return map.keySet();
		}else{
			return null;
		}
	}
	
	
	/*
	static class BTBehaviorTypeComparator implements Comparator<BTBehaviorType>{

		@Override
		public int compare(BTBehaviorType arg0, BTBehaviorType arg1) {
			
			int score1 = getScore(arg0);
			int score2 = getScore(arg1);
			
			return score1 - score2;
		}
		
		private int getScore(BTBehaviorType arg0){
			int score1 = 0;
			if(arg0.equals(BTBehaviorType.INTERNALINPUT) || arg0.equals(BTBehaviorType.INTERNALOUTPUT))
				score1 = 0;
			else if(arg0.equals(BTBehaviorType.SELECTION) || arg0.equals(BTBehaviorType.STATE) ||
					arg0.equals(BTBehaviorType.GUARD))
				score1 = 1;
			else if(arg0.equals(BTBehaviorType.EXTERNALINPUT) || arg0.equals(BTBehaviorType.EXTERNALINPUT))
				score1 = 2;
			return score1;
		}
		
	}
	*/
	
	/**
	 * Method ini harus dipanggil untuk inisialisasi jalannya simulasi.
	 * @param view
	 * @return root dari BTTree
	 */
	public BTNode startExecute(ZestDebuggerView view){
//		this.externalIOBuffer = new LinkedList<BTSimulator.InputOutputData>();
		this.internalIOBuffer = new HashMap<String, BTSimulator.InternalInputOutputData>();
		this.btTree.getRoot().setProcessID(counterProcessID);
		this.processNumber.add(counterProcessID);
		counterProcessID++;
		
		//save to btt
		ExecutionNode executionNode = new ExecutionNode();
		executionNode.activeNode = this.btTree.getRoot().getNodeNumberForBTT();
		this.nodeTrace.add(executionNode);
		
		return this.btTree.getRoot();
	}
	
	/**
	 * Method ini dapat dipanggil setelah method <code>startExecute</code> selesai dieksekusi
	 * @param current
	 * @param view
	 * @return
	 */
	public BTNode executeAndReturnNextNode(BTNode current, final ZestDebuggerView view){

		System.out.println("Current Process :" +current.getProcessID());
		System.out.println(current);
		
		boolean isDone = false;
		if(current.getBTNodeType() != BTNodeType.ATOMICNODE)
			isDone = executeBTNode(current, view);
		else
			isDone = executeBTAtomicNode(current, view);
		
		if(current.getBTNodeOperator() == BTNodeOperator.REVERSION){
			BTNode destionationNode = this.btTree.getDestinationReversionNode(current);
			destionationNode.setProcessID(current.getProcessID());
			queue.add(destionationNode);
		}else if(current.getBTNodeType() == BTNodeType.ATOMICNODE){
			if(isDone){
				BTNode tempNode = current;
				boolean hasAtomicChildToo = false;
				ArrayList<BTNode> nodes = null;
				do{
					hasAtomicChildToo = false;
					if(tempNode.hasParallelChild())
						break;
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
				if(tempNode.hasParallelChild()){
					Display.getDefault().syncExec(new Runnable() {
						
						@Override
						public void run() {
							MessageDialog.openInformation(view.getSite().getShell(), "Notification", 
									"You will enter the parallel node. Please keep in mind that," +
									" this Debugger Tools will simulate the parallel execution to " +
									"be interleaved rather than parallel one");
						}
					});
					ArrayList<BTNode> childs = tempNode.getUndirectChildren();
					int parentProcID = current.getProcessID();
					if(childs!=null && childs.size()>0){
						for(int i = 0;i < childs.size(); ++i){
							BTNode node = childs.get(i);
							if(i == 0){
								node.setProcessID(parentProcID);
							}else{
								node.setProcessID(counterProcessID);
								processNumber.add(counterProcessID);
								counterProcessID++;
							}
							queue.add(node);
						}
					}else{
						processNumber.remove(current.getProcessID());
					}
				}else{
					ArrayList<BTNode> childs = tempNode.getDirectChilds();
					if(childs!=null && childs.size() > 0){
						for (BTNode btNode : childs) {
							btNode.setProcessID(current.getProcessID());
							queue.add(btNode);
						}
					}else{
						processNumber.remove(current.getProcessID());
					}
				}
			}else{
				queue.add(current);
			}
		}
		else if(current.getBehavior()!=null && current.getBehavior().getType() == BTBehaviorType.SELECTION){
			if(isDone){
				if(current.getParentAlternativeNodeNumber() != -1){
					int parentId = current.getParentAlternativeNodeNumber();
					for (int ii = 0;ii<queue.size();++ii) {
						BTNode sibling = queue.get(ii);
						if(sibling.getParentAlternativeNodeNumber() == parentId &&
								sibling.getNodeNumberForBTT()!=current.getNodeNumberForBTT()){
							queue.remove(ii);
						}
					}
					current.setParentAlternativeNodeNumber(-1);
				}
				if(!current.hasParallelChild()){
					ArrayList<BTNode> childs = current.getDirectChilds();
					if(childs!=null && childs.size() > 0){
						for (BTNode btNode : childs) {
							btNode.setProcessID(current.getProcessID());
							queue.add(btNode);
						}
					}else{
						processNumber.remove(current.getProcessID());
					}
				}
				else{
					Display.getDefault().syncExec(new Runnable() {
						
						@Override
						public void run() {
							MessageDialog.openInformation(view.getSite().getShell(), "Notification", 
									"You will enter the parallel node. Please keep in mind that," +
									" this Debugger Tools will simulate the parallel execution to " +
									"be interleaved rather than parallel one");
						}
					});
					ArrayList<BTNode> childs = current.getUndirectChildren();
					int parentProcID = current.getProcessID();
					if(childs!=null && childs.size()>0){
						for(int i = 0;i < childs.size(); ++i){
							BTNode node = childs.get(i);
							if(i == 0){
								node.setProcessID(parentProcID);
							}else{
								node.setProcessID(counterProcessID);
								processNumber.add(counterProcessID);
								counterProcessID++;
							}
							queue.add(node);
						}
					}else{
						processNumber.remove(current.getProcessID());
					}
				
				}
			}else{
				processNumber.remove(current.getProcessID());
			}
		}
		else if(isDone){
			if(!current.hasParallelChild()){
				boolean isAlternativeBlock = current.getBTNodeType() == BTNodeType.ALTERNATIVEBLOCK;
				
				ArrayList<BTNode> childs = current.getDirectChilds();
				if(childs!=null && childs.size() > 0){
					for (BTNode btNode : childs) {
						if(isAlternativeBlock)
							btNode.setParentAlternativeNodeNumber(current.getNodeNumberForBTT());
						btNode.setProcessID(current.getProcessID());
						queue.add(btNode);
					}
				}else{
					processNumber.remove(current.getProcessID());
				}
			}
			else{
				Display.getDefault().syncExec(new Runnable() {
					
					@Override
					public void run() {
						MessageDialog.openInformation(view.getSite().getShell(), "Notification", 
								"You will enter the parallel node. Please keep in mind that," +
								" this Debugger Tools will simulate the parallel execution to " +
								"be interleaved rather than parallel one");
					}
				});
				ArrayList<BTNode> childs = current.getUndirectChildren();
				int parentProcID = current.getProcessID();
				if(childs!=null && childs.size()>0){
					for(int i = 0;i < childs.size(); ++i){
						BTNode node = childs.get(i);
						if(i == 0){
							node.setProcessID(parentProcID);
						}else{
							node.setProcessID(counterProcessID);
							processNumber.add(counterProcessID);
							counterProcessID++;
						}
						queue.add(node);
					}
				}else{
					processNumber.remove(current.getProcessID());
				}
			
			}
		}else{
			queue.add(current);
		}
		
//		if(beforeNode == null || !beforeNode.equals(current)){
//			beforeNode = current;
//			sameCounter = 1;
//			System.out.println("SAME COUNTER : "+sameCounter);
//		}else if(beforeNode.equals(current)){
//			sameCounter++;
//			System.out.println("SAME COUNTER : "+sameCounter);
//		}
		
		if(queue.size() == 0){
			return null;
		}else{
			int nextProcessID = -1;
//			if(sameCounter < 2)
				nextProcessID = nextProcessID();
//			else{
//				int temp = -1;
//				quantumTime = -1;
//				sameCounter = 0;
//				beforeNode = null;
//				do{
//					temp = nextProcessID();
//					System.out.println("temp :"+temp +" "+current.getProcessID());
//				}while(temp == current.getProcessID());
//				
//			}
			
			System.out.println("Next Process ID :"+nextProcessID);
			BTNode nextNode = null;
			for(int i = 0;i < queue.size(); ++i){
				if(queue.get(i).getProcessID() == nextProcessID){
					nextNode = queue.remove(i);
					break;
				}
			}
			if(nextNode == null)
				nextNode = queue.get(random.nextInt(queue.size()));
			//save to btt
			if(nextNode!= null){
				ExecutionNode executionNode = new ExecutionNode();
				executionNode.activeNode = nextNode.getNodeNumberForBTT();
				ArrayList<BTNode> interleaveNodes = getInterleaveNodes(nextNode);
				if(interleaveNodes!=null && interleaveNodes.size()>0){
					executionNode.interleaveNodes = new int[interleaveNodes.size()];
					for (int ii = 0;ii<interleaveNodes.size();++ii) {
						executionNode.interleaveNodes[ii] = interleaveNodes.get(ii).getNodeNumberForBTT();
					}
				}
				this.nodeTrace.add(executionNode);
			}
				
			return nextNode;
		}
	}
	
	/**
	 * mengecek apakah list node yang akan dieksekusi telah empty atau belum
	 * @return
	 */
	public boolean isEmpty(){
		return this.queue == null || this.queue.size() == 0;
	}
	
	/**
	 * Method untuk menentukan process id yang akan dieksekusi berikutnya
	 * @return
	 */
	private int nextProcessID(){
		System.out.println("Many Process:"+processNumber.size()+"-->");
		System.out.println(Arrays.toString(processNumber.toArray()));
		if(quantumTime == -1 || (currentProcessID >= 0 && !processNumber.contains(currentProcessID))){
			quantumTime = MIN_QUANTUM_TIME + random.nextInt(MAX_QUANTUM_TIME-MIN_QUANTUM_TIME+1);
			int size = processNumber.size();
			currentProcessID = (Integer) processNumber.toArray()[random.nextInt(size)];
			System.out.println("QUANTUM TIME : "+ quantumTime + " FOR PC ID :"+currentProcessID);
		}
		quantumTime--;
		System.out.println("quantumTime : "+quantumTime);
		return currentProcessID;
	}
	
	private boolean executeBTAtomicNode(BTNode node, ZestDebuggerView view){
		if(node.getBTNodeType() != BTNodeType.ATOMICNODE)
			throw new IllegalArgumentException();
		BTNode tempNode = node;
		boolean hasAtomicChildToo = false;
		ArrayList<BTNode> nodes = null;
		boolean isDone = true;
		do{
			hasAtomicChildToo = false;
			isDone&=executeBTNode(tempNode, view);
			if(tempNode.hasParallelChild())
				break;
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
		return isDone;
	}
	
	/**
	 * Method untuk mengeksekusi node, dan apakah hasil evaluasi benar atau tidak, memiliki aturan semantic yang telah ditetapkan
	 * @param node
	 * @param view
	 * @return
	 */
	private boolean executeBTNode(BTNode node, ZestDebuggerView view){
		if(node.getBTNodeType() == BTNodeType.ALTERNATIVEBLOCK){
			return true;
		}
		BTBehaviorType behaviorType = node.getBehavior().getType();
		HashMap<String, Integer> integerVariable = mapComponentIntegerVar.get(node.getBTComponent().getName());
		HashMap<String, Boolean> booleanVariable = mapComponentBooleanVar.get(node.getBTComponent().getName());
		HashMap<String, String> undefineVariable = mapComponentUndefineVar.get(node.getBTComponent().getName());
		boolean isDone = false;
		if(node.getBTComponent().getName().equalsIgnoreCase("LIST")){
			if(node.getBehavior().getType() == BTBehaviorType.STATE){
				String behaviorName = node.getBehavior().getName().toLowerCase().trim();
				if(behaviorName.equals("add")){
					if(listData == null)
						listData = new ArrayList<Object>();
					this.listData.add(this.mapComponentIntegerVar.get("DATA").get("cdata"));
					this.dataChangedListener.notifyDataChanged("LIST", "size", this.listData.size()+"");
					this.dataChangedListener.notifyDataChanged("LIST", "value", Arrays.toString(listData.toArray()));
				}else if(behaviorName.equals("remove")){
					if(listData == null)
						listData = new ArrayList<Object>();
					Integer removedData = null;
					if((removedData = (Integer)listData.remove(0))!=null){
						this.mapComponentIntegerVar.get("DATA").put("cdata", removedData);
						this.dataChangedListener.notifyDataChanged("DATA", "cdata", removedData+"");
						this.dataChangedListener.notifyDataChanged("LIST", "value", Arrays.toString(listData.toArray()));
						this.dataChangedListener.notifyDataChanged("LIST", "size", this.listData.size()+"");
					}
					else{
						throw new IllegalStateException("Error: Buffer doesn't have the item to be removed/consumed");
					}
				}
				return true;
			}else{
				throw new UnsupportedOperationException();
			}
		}else if(node.getBTComponent().getName().equalsIgnoreCase("SET")){
			if(node.getBehavior().getType() == BTBehaviorType.STATE){
				String behaviorName = node.getBehavior().getName().toLowerCase().trim();
				if(behaviorName.equals("add")){
					if(setData == null)
						setData = new HashSet<Object>();
					this.setData.add(this.mapComponentIntegerVar.get("DATA").get("cdata"));
					this.dataChangedListener.notifyDataChanged("SET", "value", Arrays.toString(setData.toArray()));
					this.dataChangedListener.notifyDataChanged("SET", "size", setData.size()+"");
				}else if(behaviorName.equals("remove")){
					if(setData == null)
						setData = new HashSet<Object>();
					if(setData.remove(this.mapComponentIntegerVar.get("DATA").get("cdata"))){
						this.dataChangedListener.notifyDataChanged("SET", "value", Arrays.toString(setData.toArray()));
						this.dataChangedListener.notifyDataChanged("SET", "size", setData.size()+"");
					}
					else
						out.println("Error: list doesn't have the item to be removed");
				}
				return true;
			}else{
				throw new UnsupportedOperationException();
			}
		}
		
		if(node.getBTNodeOperator() == BTNodeOperator.REVERSION){
			
			return true;
		}
		
		if(behaviorType == BTBehaviorType.EXTERNALINPUT){
			IInputValidator inputValidator = null;
			int type = INTEGER;
			String varName = node.getBehavior().getName().toLowerCase().trim();

			String message = "";
			if(varName.equalsIgnoreCase("CDATA")){
				//TODO
				inputValidator = integerInputValidator;
				type = INTEGER;
				message = "Enter the integer value for "+varName;
			}
			
			else if(integerVariable!=null && integerVariable.containsKey(varName)){
				inputValidator = integerInputValidator;
				type = INTEGER;
				message = "Enter the integer value for "+varName;
			}else if(booleanVariable!=null && booleanVariable.containsKey(varName)){
				inputValidator = booleanInputValidator;
				type = BOOLEAN;
				message = "Enter the boolean value, either true or false for "+varName;
			}else if(undefineVariable!=null && undefineVariable.containsKey(varName)){
				inputValidator = null;
				type = UNDEFINE;
				message = "Enter the value for "+varName;
			}else{
				throw new IllegalStateException("Variable name : "+varName+" is not included on memory");
			}
			
//			InputDialog dialog = new InputDialog(view.getSite().getShell(), "Input dialog", message, "", inputValidator);
//			dialog.setBlockOnOpen(true);
//			int status = dialog.open();
//			while(status != Window.OK){
//				status = dialog.open();
//			}
			String input = null;
			if((input = getExternalInput(view.getSite().getShell(), "Input dialog", message, "", inputValidator))!=null){
//				String input = dialog.getValue();
				
				if(varName.equalsIgnoreCase("CDATA")){
					mapComponentIntegerVar.get("DATA").put("cdata", Integer.parseInt(input));
					if(dataChangedListener!=null)
						dataChangedListener.notifyDataChanged("DATA", "cdata", input);
				}
				else if(type == INTEGER){
					integerVariable.put(varName, Integer.parseInt(input));
					if(dataChangedListener!=null)
						dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input);
				}else if(type == BOOLEAN){
					booleanVariable.put(varName, Boolean.parseBoolean(input));
					if(dataChangedListener!=null)
						dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input);
				}else if(type == UNDEFINE){
					undefineVariable.put(varName, input);
					if(dataChangedListener!=null)
						dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input);
				}
//				dialog.close();
				isDone = true;
			}
		}else if(behaviorType == BTBehaviorType.EXTERNALOUTPUT){
			String varName = node.getBehavior().getName().toLowerCase().trim();
			String value = "";
			if(varName.equalsIgnoreCase("CDATA")){
				value = this.mapComponentIntegerVar.get("DATA").get("cdata") +"";
			}else if(varName.contains("string_")){
				String temp[] = varName.split("\\+");
				for(int i = 0;i < temp.length;++i){
					if(temp[i].contains("string_")){
						temp[i] = temp[i].replace("string_", "");
						temp[i] = temp[i].replace('_', ' ');
						
					}else{
						temp[i] = getVariableValueAsString(node.getBTComponent().getName(), temp[i]);
					}
					if(i == 0)
						value+=temp[i];
					else
						value+= " "+temp[i];
				}
				
			}
			else if(integerVariable!=null && integerVariable.containsKey(varName)){
				value = integerVariable.get(varName)+"";
			}else if(booleanVariable!=null && booleanVariable.containsKey(varName)){
				value = booleanVariable.get(varName)+"";
			}else if(undefineVariable!=null && undefineVariable.containsKey(varName)){
				value = undefineVariable.get(varName);
			}else{
				throw new IllegalStateException("Variable name : "+varName+" is not included on memory");
			}
			setExternalOutput(value);
			isDone = true;
		}else if(behaviorType == BTBehaviorType.INTERNALINPUT){
			String behaviorName = node.getBehavior().getName().toLowerCase().trim();
			String temp[] = behaviorName.split("[\\(\\)]");
			String methodKey = temp[0];
			String varName = temp[1];
			int varType = getVariableType(node.getBTComponent().getName(), varName);
			InternalInputOutputData input = this.internalIOBuffer.get(methodKey);
			if(input!=null && input.variableName.equals(varName)){
				if(varName.equalsIgnoreCase("CDATA")){
					this.mapComponentIntegerVar.get("DATA").put("cdata", Integer.parseInt(input.variableValue));
					this.dataChangedListener.notifyDataChanged("DATA", varName, input.variableValue);
				}
				else if(varType == UNDEFINE){ //promote this vartype to be the type on the input var type
					if(input.variableType == INTEGER){
						if(integerVariable == null){
							integerVariable = new HashMap<String, Integer>();
							this.mapComponentIntegerVar.put(node.getBTComponent().getName(), integerVariable);
						}
						integerVariable.put(varName, Integer.parseInt(input.variableValue));
						undefineVariable.remove(varName);
					}else if(input.variableType == BOOLEAN){
						if(booleanVariable == null){
							booleanVariable = new HashMap<String, Boolean>();
							this.mapComponentBooleanVar.put(node.getBTComponent().getName(), booleanVariable);
						}
						booleanVariable.put(varName, Boolean.parseBoolean(input.variableValue));
						undefineVariable.remove(varName);
					}else{
						undefineVariable.put(varName, input.variableValue);
					}
					this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input.variableValue);
				}else if(input.variableType == UNDEFINE){ //promote the source variable type to be the destination variable type

					HashMap<String, Integer> integerVariableSource = mapComponentIntegerVar.get(input.componentOutputName);
					HashMap<String, Boolean> booleanVariableSource = mapComponentBooleanVar.get(input.componentOutputName);
					HashMap<String, String> undefineVariableSource = mapComponentUndefineVar.get(input.componentOutputName);
					
					if(varType == INTEGER){
						integerVariable.put(varName, Integer.parseInt(input.variableValue));
						if(integerVariableSource == null){
							integerVariableSource = new HashMap<String, Integer>();
							this.mapComponentIntegerVar.put(input.componentOutputName, integerVariableSource);
						}
						integerVariableSource.put(input.variableName, Integer.parseInt(input.variableValue));
						undefineVariableSource.remove(input.variableName);
						
					}else if(varType == BOOLEAN){
						booleanVariable.put(varName, Boolean.parseBoolean(input.variableValue));
						if(booleanVariableSource == null){
							booleanVariableSource = new HashMap<String, Boolean>();
							this.mapComponentBooleanVar.put(input.componentOutputName, booleanVariableSource);
						}
						booleanVariableSource.put(input.variableName, Boolean.parseBoolean(input.variableValue));
						undefineVariableSource.remove(input.variableName);
					}else{
						undefineVariable.put(varName, input.variableValue);
					}
					this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input.variableValue);
				}else if(input.variableType == varType){
					if(varType == INTEGER){
						integerVariable.put(varName, Integer.parseInt(input.variableValue));
					}else if(varType == BOOLEAN){
						booleanVariable.put(varName, Boolean.parseBoolean(input.variableValue));
					}else{
						undefineVariable.put(varName, input.variableValue);
					}
					this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, input.variableValue);
				}else{
					throw new IllegalStateException();
				}
				this.internalIOBuffer.remove(methodKey);
			}else{
				throw new IllegalStateException();
			}
			isDone = true;
			
		}else if(behaviorType == BTBehaviorType.INTERNALOUTPUT){
			String behaviorName = node.getBehavior().getName().toLowerCase().trim();
			String temp[] = behaviorName.split("[\\(\\)]");
			String methodKey = temp[0];
			String varName = temp[1];
			
			int varType = getVariableType(node.getBTComponent().getName(), varName);
			String variableValue = getVariableValueAsString(node.getBTComponent().getName(), varName);
			System.out.println("componentName:"+node.getBTComponent().getName());
			System.out.println("varName:"+varName);
			System.out.println("varType:"+varType);
			System.out.println("value:"+variableValue);
			this.internalIOBuffer.put(methodKey, new InternalInputOutputData(node.getBTComponent().getName(), varName, variableValue, varType));
			isDone = true;
		}else if(behaviorType == BTBehaviorType.SELECTION){
			String behaviorName = node.getBehavior().getName().toLowerCase().trim();
			String statement = null;
			if(behaviorName.startsWith("not")){
				String statements[] = behaviorName.split("[\\(\\)]");
				statement = statements[1];
			}else{
				statement = behaviorName;
			}
			if(statement.contains("=")){
				String temp[] = statement.split("=");
				String leftVar = temp[0];
				String rightVar = temp[1];
				if(leftVar.matches("[0-9]+")){
					int leftValue = Integer.parseInt(leftVar);
					int rightValue = -1;
					if(rightVar.matches("[0-9]+")){
						rightValue = Integer.parseInt(rightVar);
					}else{
						rightValue = getVariableValueAsInteger(node.getBTComponent().getName(), rightVar);
					}
					isDone = leftValue == rightValue;
				}else if(rightVar.matches("[0-9]+")){
					int rightValue = Integer.parseInt(rightVar);
					int leftValue = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
					isDone = leftValue == rightValue;
				}else{
					int leftType = getVariableType(node.getBTComponent().getName(), leftVar);
					int rightType = getVariableType(node.getBTComponent().getName(), rightVar);
					if(leftType == INTEGER){
						int leftValue = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
						int rightValue = getVariableValueAsInteger(node.getBTComponent().getName(), rightVar);
						isDone = leftValue == rightValue;
					}else if(leftType == BOOLEAN){
						boolean leftValue = booleanVariable.get(leftVar);
						boolean rightValue = booleanVariable.get(rightVar);
						isDone = leftValue == rightValue;
					}else if(leftType == UNDEFINE){
						String leftValue = undefineVariable.get(leftVar);
						String rightValue = undefineVariable.get(rightVar);
						isDone = leftValue.equals(rightValue);
					}else{
						throw new IllegalStateException();
					}
				}
			}else{
				String varName = statement;
				boolean value = booleanVariable.get(varName);
				isDone = value;
			}
			
			if(behaviorName.startsWith("not"))
				isDone = !isDone;
		}else if(behaviorType == BTBehaviorType.STATE){
			String behaviorName = node.getBehavior().getName().toLowerCase().trim();
			if(behaviorName.contains(":=")){
				String assignment[] = behaviorName.split(":=");
				String leftVar = assignment[0].trim();
				int leftVarType = getVariableType(node.getBTComponent().getName(), leftVar);
				
				String rightOperation = assignment[1].trim();
				int index = -1;
				// jika ada operasi aritmatika atau boolean operator
				if( (index = rightOperation.indexOf('+')) != -1 ||
						(index = rightOperation.indexOf('-'))!=-1 ||
						(index = rightOperation.indexOf('*'))!=-1 ||
						(index = rightOperation.indexOf('/'))!=-1 ||
						(index = rightOperation.indexOf('%'))!=-1 ||
						(index = rightOperation.indexOf("&&"))!=-1 ||
						(index = rightOperation.indexOf("||"))!=-1 ||
						(index = rightOperation.indexOf("^"))!=-1 ){
					String rightVar[] = rightOperation.split("[\\+\\-\\*\\/\\%]|&&|(\\|\\|)|\\^");
					rightVar[0] = rightVar[0].trim();
					rightVar[1] = rightVar[1].trim();
					int operand1Type = getVariableType(node.getBTComponent().getName(), rightVar[0]);
					int operand2Type = getVariableType(node.getBTComponent().getName(), rightVar[1]);
					
					if(leftVarType == INTEGER){
						int valueAssignment = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
						int value1 = getVariableValueAsInteger(node.getBTComponent().getName(),	rightVar[0]);
						int value2 = getVariableValueAsInteger(node.getBTComponent().getName(),	rightVar[1]);
						if(rightOperation.charAt(index) == '+')
							valueAssignment = value1 + value2;
						else if(rightOperation.charAt(index) == '-')
							valueAssignment = value1 - value2;
						else if(rightOperation.charAt(index) == '*')
							valueAssignment = value1 * value2;
						else if(rightOperation.charAt(index) == '/')
							valueAssignment = value1 / value2;
						else if(rightOperation.charAt(index) == '%')
							valueAssignment = value1 % value2;
						integerVariable.put(leftVar, valueAssignment);
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment+"");
					}else if(leftVarType == BOOLEAN){
						boolean valueAssignment = getVariableValueAsBoolean(node.getBTComponent().getName(), leftVar);
						boolean value1 = getVariableValueAsBoolean(node.getBTComponent().getName(),	rightVar[0]);
						boolean value2 = getVariableValueAsBoolean(node.getBTComponent().getName(),	rightVar[1]);
						if(rightOperation.contains("&&"))
							valueAssignment = value1 && value2;
						else if(rightOperation.contains("||"))
							valueAssignment = value1 || value2;
						else if(rightOperation.contains("^"))
							valueAssignment = value1 ^ value2;
						booleanVariable.put(leftVar, valueAssignment);
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment+"");
					}else if(leftVarType == UNDEFINE){
						String valueAssignment = undefineVariable.get(leftVar);
						String value1 = undefineVariable.get(rightVar[0]);
						String value2 = undefineVariable.get(rightVar[1]);
						if(rightOperation.charAt(index) == '+')
							valueAssignment = value1 + value2;
						else
							throw new UnsupportedOperationException("Other operation except + is not supported on string operation");
						undefineVariable.put(leftVar, valueAssignment);
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment);
					}else{
						throw new IllegalStateException();
					}
					
				}else{ //asignment operation
					String rightVar = rightOperation;
					if(leftVarType == INTEGER){
						int valueAssignment = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
						int value1 = getVariableValueAsInteger(node.getBTComponent().getName(),	rightVar);
						valueAssignment = value1;
						integerVariable.put(leftVar, valueAssignment);
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment+"");
						
					}else if(leftVarType == BOOLEAN){
						boolean valueAssignment = getVariableValueAsBoolean(node.getBTComponent().getName(), leftVar);
						boolean value1 = getVariableValueAsBoolean(node.getBTComponent().getName(),	rightVar);
						valueAssignment = value1;
						booleanVariable.put(leftVar, valueAssignment);
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment+"");
						
					}else if(leftVarType == UNDEFINE){
						String valueAssignment = undefineVariable.get(leftVar);
						int rightVarType = getVariableType(node.getBTComponent().getName(), rightVar);
						String value1 = getVariableValueAsString(node.getBTComponent().getName(), rightVar);
						valueAssignment = value1;
						if(rightVarType == INTEGER){
							integerVariable.put(leftVar, Integer.parseInt(valueAssignment));
							undefineVariable.remove(leftVar);
						}else if(rightVarType == BOOLEAN){
							booleanVariable.put(leftVar, Boolean.parseBoolean(valueAssignment));
							undefineVariable.remove(leftVar);
						}else{
							undefineVariable.put(leftVar, valueAssignment);
						}	
						
						this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), leftVar, valueAssignment+"");
						
					}else{
						throw new IllegalStateException();
					}
				}

				isDone = true;
				String vars[] = behaviorName.split(":=|[\\+\\-\\*\\/\\%]");
				
			}else{ // boolean operation state realization
				String varName = null;
				boolean startWithNot = false;
				if(behaviorName.startsWith("not")){
					startWithNot = true;
					String temp[] = behaviorName.split("[\\(\\)]");
					varName = temp[1];
				}else{
					startWithNot = false;
					varName = behaviorName;
				}
				
				if(booleanVariable!=null && booleanVariable.containsKey(varName)){
					booleanVariable.put(varName, !startWithNot);
					this.dataChangedListener.notifyDataChanged(node.getBTComponent().getName(), varName, ""+!startWithNot);
				}else{
					throw new IllegalStateException();
				}
				isDone = true;
			}
		}else if(behaviorType == BTBehaviorType.GUARD){
			String behaviorName = node.getBehavior().getName().toLowerCase().trim();
			String statement = null;
			if(behaviorName.startsWith("not")){
				String statements[] = behaviorName.split("[\\(\\)]");
				statement = statements[1];
			}else{
				statement = behaviorName;
			}
			if(statement.contains("=")){
				String temp[] = statement.split("=");
				String leftVar = temp[0];
				String rightVar = temp[1];
				if(leftVar.matches("[0-9]+")){
					int leftValue = Integer.parseInt(leftVar);
					int rightValue = -1;
					if(rightVar.matches("[0-9]+")){
						rightValue = Integer.parseInt(rightVar);
					}else{
						rightValue = getVariableValueAsInteger(node.getBTComponent().getName(), rightVar);
					}
					isDone = leftValue == rightValue;
				}else if(rightVar.matches("[0-9]+")){
					int rightValue = Integer.parseInt(rightVar);
					int leftValue = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
					isDone = leftValue == rightValue;
				}else{
					int leftType = getVariableType(node.getBTComponent().getName(), leftVar);
					int rightType = getVariableType(node.getBTComponent().getName(), rightVar);
					if(leftType == INTEGER){
						int leftValue = getVariableValueAsInteger(node.getBTComponent().getName(), leftVar);
						int rightValue = getVariableValueAsInteger(node.getBTComponent().getName(), rightVar);
						isDone = leftValue == rightValue;
					}else if(leftType == BOOLEAN){
						boolean leftValue = booleanVariable.get(leftVar);
						boolean rightValue = booleanVariable.get(rightVar);
						isDone = leftValue == rightValue;
					}else if(leftType == UNDEFINE){
						String leftValue = undefineVariable.get(leftVar);
						String rightValue = undefineVariable.get(rightVar);
						isDone = leftValue.equals(rightValue);
					}else{
						throw new IllegalStateException();
					}
				}
			}else{
				String varName = statement;
				boolean value = booleanVariable.get(varName);
				isDone = value;
			}
			
			if(behaviorName.startsWith("not"))
				isDone = !isDone;
		}else{
			throw new IllegalStateException("The Behavior isn't supported");
		}
		
		return isDone;
	}
	
	/**
	 * 
	 * @param dataChangedListener listener untuk notifikasi jika terjadi perubahan data ketika proses simulasi berjalan
	 */
	public void setOnDataChangedListener(DataListener dataChangedListener) {
		this.dataChangedListener = dataChangedListener;
	}

	
	/**
	 * Struktur data yang mengenkapsulasi data yang diterima dari InternalInputOutputData
	 * @author agung
	 *
	 */
	static class InternalInputOutputData{
		public String variableValue;
		public String variableName;
		public int variableType;
		public String componentOutputName;
		
		public InternalInputOutputData(String componentOutputName, String variableName, String variableValue, int variableType){
			this.componentOutputName = componentOutputName;
			this.variableName = variableName;
			this.variableValue = variableValue;
			this.variableType = variableType;
		}
	}
	
	
	private static IInputValidator integerInputValidator = new IInputValidator(){

		@Override
		public String isValid(String newText) {
			try{
				Integer.parseInt(newText);
			}catch(Exception e){
				return "The input must be integer value";
			}
			return null;
		}
		
	};
	
	private static IInputValidator booleanInputValidator = new IInputValidator(){

		@Override
		public String isValid(String newText) {
			try{
				Boolean.parseBoolean(newText);
			}catch(Exception e){
				return "The input must be either \"false\" or \"true\"";
			}
			return null;
		}
		
	};
	
	private static final int INTEGER = 0, BOOLEAN = 1, UNDEFINE = 2;
	
	/**
	 * Listener untuk mengakomodasi fungsi monitoring terhadap perubahan data ketika simulasi berjalan
	 * @author agung
	 *
	 */
	public static abstract class DataListener{
		public abstract void onDataChanged(String componentName, String variableName, String value);
		public void notifyDataChanged(String componentName, String variableName, String value){
			if(variableName.equalsIgnoreCase("cdata"))
				this.onDataChanged("DATA", variableName, value);
			else
				this.onDataChanged(componentName, variableName, value);
		}
	}
	
	private int getVariableType(String componentName, String variableName){
		HashMap<String, Integer> integerVariable = mapComponentIntegerVar.get(componentName);
		if(integerVariable!=null && integerVariable.containsKey(variableName))
			return INTEGER;
		HashMap<String, Boolean> booleanVariable = mapComponentBooleanVar.get(componentName);
		if(booleanVariable!=null && booleanVariable.containsKey(variableName))
			return BOOLEAN;
		HashMap<String, String> undefineVariable = mapComponentUndefineVar.get(componentName);
		if(undefineVariable!=null && undefineVariable.containsKey(variableName))
			return UNDEFINE;
		if(variableName.equalsIgnoreCase("CDATA"))
			return INTEGER;
		if(variableName.matches("[0-9]+"))
			return INTEGER;
		if(variableName.equalsIgnoreCase("true") || variableName.equalsIgnoreCase("false"))
			return BOOLEAN;
		throw new IllegalStateException();
		
	}
	
	private DataListener dataChangedListener;
	
	private int getVariableValueAsInteger(String componentName, String variableName){
		HashMap<String, Integer> integerVariable = mapComponentIntegerVar.get(componentName);
		if(integerVariable!=null && integerVariable.containsKey(variableName))
			return integerVariable.get(variableName);
		HashMap<String, Boolean> booleanVariable = mapComponentBooleanVar.get(componentName);
		if(booleanVariable!=null && booleanVariable.containsKey(variableName)){
			return booleanVariable.get(variableName) ? 1 : 0;
		}
		HashMap<String, String> undefineVariable = mapComponentUndefineVar.get(componentName);
		if(undefineVariable!=null && undefineVariable.containsKey(variableName)){
			return Integer.parseInt(undefineVariable.get(variableName));
		}
		
		if(variableName.matches("[0-9]+"))
			return Integer.parseInt(variableName);
		if(variableName.equals("random()"))
			return (int) (101*Math.random());
		if(variableName.equalsIgnoreCase("CDATA"))
			return mapComponentIntegerVar.get("DATA").get("cdata");
		throw new IllegalStateException("componentName:"+componentName+";varName:"+variableName);
	}
	private boolean getVariableValueAsBoolean(String componentName, String variableName){
		HashMap<String, Integer> integerVariable = mapComponentIntegerVar.get(componentName);
		if(integerVariable!=null && integerVariable.containsKey(variableName))
			return integerVariable.get(variableName) == 1;
		HashMap<String, Boolean> booleanVariable = mapComponentBooleanVar.get(componentName);
		if(booleanVariable!=null && booleanVariable.containsKey(variableName)){
			return booleanVariable.get(variableName);
		}
		HashMap<String, String> undefineVariable = mapComponentUndefineVar.get(componentName);
		if(undefineVariable!=null && undefineVariable.containsKey(variableName)){
			String value = undefineVariable.get(variableName);
			if(value.equals("1"))
				return true;
			else if(value.equals("0"))
				return false;
			return Boolean.parseBoolean(value);
		}
		
		if(variableName.equals("random()"))
			return (int)(2*Math.random()) == 1;
		return Boolean.parseBoolean(variableName);
	}
	private String getVariableValueAsString(String componentName, String variableName){
		HashMap<String, Integer> integerVariable = mapComponentIntegerVar.get(componentName);
		if(integerVariable!=null && integerVariable.containsKey(variableName))
			return integerVariable.get(variableName) + "";
		HashMap<String, Boolean> booleanVariable = mapComponentBooleanVar.get(componentName);
		if(booleanVariable!=null && booleanVariable.containsKey(variableName)){
			return booleanVariable.get(variableName) +"";
		}
		HashMap<String, String> undefineVariable = mapComponentUndefineVar.get(componentName);
		if(undefineVariable!=null && undefineVariable.containsKey(variableName)){
			return undefineVariable.get(variableName);
		}
		if(variableName.equalsIgnoreCase("CDATA"))
			return mapComponentIntegerVar.get("DATA").get("cdata")+"";
		throw new IllegalStateException();
	}

	/**
	 * 
	 * @param activeNode
	 * @return List node yang berada pada interleave status ketika <code>activeNode</code> sedang aktif. 
	 */
	public ArrayList<BTNode> getInterleaveNodes(BTNode activeNode) {
		if(activeNode==null)
			throw new IllegalArgumentException();
		ArrayList<BTNode> res = new ArrayList<BTNode>();
//		System.out.println("===============================");
//		System.out.println(activeNode);
//		System.out.println("===============================");
		for (BTNode btNode : queue) {
//			System.out.println(btNode.getProcessID());
//			System.out.println(btNode);
			if(!activeNode.equals(btNode) && activeNode.getProcessID() != btNode.getProcessID())
				res.add(btNode);
		}
//		System.out.println("===============================");
		return res;
	}
	
	/**
	 * Untuk menyimpan btt file ke path file pada argumen
	 * @param pathToFile
	 * @return
	 */
	public boolean saveTraceToFile(String pathToFile){
		try{
			File file = new File(pathToFile);
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			out.write(("INPUT "+externalInputTrace.size()).getBytes());
			out.write("\n".getBytes());
			for (String inputElement : externalInputTrace) {
				out.write(inputElement.getBytes());
				out.write("\n".getBytes());
			}
			out.write(("OUTPUT "+externalOutputTrace.size()).getBytes());
			out.write("\n".getBytes());
			for (String outputElement : externalOutputTrace) {
				out.write(outputElement.getBytes());
				out.write("\n".getBytes());
			}
			out.write("TRACE ".getBytes());
			for (ExecutionNode execNode : nodeTrace) {
				int activeNode = execNode.activeNode;
				int[] interleaveNode = execNode.interleaveNodes;
				StringBuffer buf = new StringBuffer();
				buf.append("["+activeNode);
				if(interleaveNode!=null && interleaveNode.length>0){
					for(int ii = 0;ii<interleaveNode.length;++ii){
						buf.append(", "+interleaveNode[ii]);
					}
				}
				buf.append("] ");
				out.write(buf.toString().getBytes());
			}
			
			out.flush();
			out.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Method yang mengenkapsulasi kebutuhan untuk menerima input dari User
	 * @param shell
	 * @param title
	 * @param message
	 * @param initialValue
	 * @param inputValidator
	 * @return
	 */
	private String getExternalInput(Shell shell, String title, String message, String initialValue, IInputValidator inputValidator){
		
		InputDialog dialog = new InputDialog(shell, title, message, initialValue, inputValidator);
		dialog.setBlockOnOpen(true);
		int status = dialog.open();
		while(status != Window.OK){
			status = dialog.open();
		}
		String res = dialog.getValue();
		dialog.close();
		externalInputTrace.add(res);
		return res;
	}
	
	/**
	 * Method yang mengenkapsulasi kebutuhan untuk menampilkan output ke console
	 * @param output
	 */
	private void setExternalOutput(String output){
		out.println(output);
		externalOutputTrace.add(output);
	}
	
}


