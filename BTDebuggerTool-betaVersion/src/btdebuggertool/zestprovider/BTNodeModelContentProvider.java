package btdebuggertool.zestprovider;

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;

import bt.model.BTBehavior;
import bt.model.BTBehaviorType;
import bt.model.BTNode;
import bt.model.BTNodeType;
import bt.model.BTTree;
import btdebuggertool.figure.BTNodeAtomicFigure;
import btdebuggertool.figure.BTNodeFigure;
import btdebuggertool.figure.BTNodeFigureWithRelations;


public class BTNodeModelContentProvider {
	private ArrayList<BTNode> listNodes;
	
	public ArrayList<BTNode> getListNodes() {
		return listNodes;
	}

	public BTNodeModelContentProvider(BTTree btTree){
		if(btTree == null){
			return;
		}
		listNodes = new ArrayList<BTNode>();
		BTNode root = btTree.getRoot();
		if(root!=null){
			LinkedList<BTNode> queue = new LinkedList<BTNode>();
			queue.add(root);
			while(queue.size() > 0){
				BTNode currentRoot = queue.poll();
				listNodes.add(currentRoot);
				ArrayList<BTNode> childs = currentRoot.getDirectChilds();
				for (BTNode btNode : childs) {
					queue.add(btNode);
				}
			}
		}else{
			return;
		}
		
	}
	
	/**
	 * 
	 * @param node, that is node PARALLEL NODE, because parallel node is not intended to be rendered in Zest View
	 * @throws IllegalArgumentException if <code>node</code> is Parallel Node
	 * @return
	 */
	public static IFigure getFigureDefinition(BTNode node) throws IllegalArgumentException{
		
		if(node!=null && node.getBTNodeType() == BTNodeType.PARALLELBLOCK)
			throw new IllegalArgumentException("Can't passing BTNodeType.PARALLELBLOCK here");
		if(node!=null && node.getBTNodeType() == BTNodeType.ALTERNATIVEBLOCK)
			return new BTNodeFigure("", "[ ]", "", "", "", "");
		if(node.getBTNodeType() == BTNodeType.ATOMICNODE){
			ArrayList<BTNode> atomicNode = new ArrayList<BTNode>();
			BTNode temp = node;
			
			boolean hasAtomicChildToo = false;
			ArrayList<BTNode> nodes = null;
			do{
				hasAtomicChildToo = false;
				atomicNode.add(temp);
				nodes = temp.getDirectChilds();
				for (BTNode btNode : nodes) {
					if(btNode.getBTNodeType() == BTNodeType.ATOMICNODE){
						hasAtomicChildToo = true;
						break;
					}
				}
				if(hasAtomicChildToo && nodes.size() > 1){
					throw new IllegalStateException("Atomic Child can't have more than 1 atomic childs 'A', which A has another sibling");
				}else if(hasAtomicChildToo && nodes.size() == 1){
					temp = nodes.get(0);
				}
//				System.out.println("ADA TERUS : "+node);
			}while(hasAtomicChildToo);
			return new BTNodeAtomicFigure(atomicNode);
		}
		String componentName = "",
				behaviorName = "",
				operator = " ",
				label = " ",
				traceabilityLink = " ",
				traceabilityStatus = " ";
		if(node.getBTComponent()!=null)
			componentName = node.getBTComponent().getName();
		
		if(node.getBTNodeOperator()!= null){
			operator = node.getBTNodeOperator().getOperator();
			label = "";
			System.out.println("NODE OPERATOR:"+operator);
		}else{
			System.out.println("NODE OPERATOR:"+null);
		}
		boolean isSimpleNode = true;
		if(node.getBehavior()!=null){
			behaviorName = node.getBehavior().getName();
			BTBehavior behavior = node.getBehavior();
			if(behavior.getRelations()!=null && behavior.getRelations().size()>0){
				isSimpleNode = false;
			}else
				isSimpleNode = true;
			BTBehaviorType behaviorType = node.getBehavior().getType();
			if(behaviorType == BTBehaviorType.STATE){
				behaviorName = "[ "+behaviorName+" ]";
			}else if(behaviorType == BTBehaviorType.SELECTION){
				behaviorName = "? "+behaviorName+" ?";
			}else if(behaviorType == BTBehaviorType.GUARD){
				behaviorName = "??? "+behaviorName+" ???";
			}else if(behaviorType == BTBehaviorType.INTERNALOUTPUT){
				behaviorName = "< "+behaviorName+" >";
			}else if(behaviorType == BTBehaviorType.INTERNALINPUT){
				behaviorName = "> "+behaviorName+" <";
			}else if(behaviorType == BTBehaviorType.EXTERNALOUTPUT){
				behaviorName = "<< "+behaviorName+" >>";
			}else if(behaviorType == BTBehaviorType.EXTERNALINPUT){
				behaviorName = ">> "+behaviorName+" <<";
			}
		}else{
			System.out.println("Behavior-nya kosong coy di COMPONENT ");//+node.getBTComponent().getName()+", behavior ref:"+node.getBehavior().getReferenceNumber());
		}
		if(isSimpleNode){
			return new BTNodeFigure(componentName,behaviorName,operator,label,traceabilityLink, traceabilityStatus);
		}else{
			return new BTNodeFigureWithRelations(componentName, behaviorName, operator, label, traceabilityLink, traceabilityStatus, node.getBehavior().getRelations());
		}
	}
}
