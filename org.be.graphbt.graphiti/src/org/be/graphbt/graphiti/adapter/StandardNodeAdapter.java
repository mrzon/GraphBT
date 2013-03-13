package org.be.graphbt.graphiti.adapter;

import java.util.ArrayList;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.be.graphbt.graphiti.editor.MultiPageEditor;
import org.be.graphbt.model.graphbt.Edge;
import org.be.graphbt.model.graphbt.GraphBTPackage;
import org.be.graphbt.model.graphbt.StandardNode;
import org.be.graphbt.saltranslator.bt2salmodel.ReversionPcProcessing;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class StandardNodeAdapter extends AdapterImpl{
	public void notifyChanged(Notification notification) {
		StandardNode node = (StandardNode)notification.getNotifier();
		
		//** 
		System.out.println("StandardNode is changed, changed id:"+notification.getFeatureID(StandardNode.class));
		String operatorType = node.getOperator();
		int featureChanged = notification.getFeatureID(StandardNode.class);
		IWorkbenchPage page=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final DiagramEditor ds;

		if(page.getActiveEditor() instanceof DiagramEditor) {
			ds = (DiagramEditor)page.getActiveEditor();	
		}
		else {
			ds = ((MultiPageEditor)page.getActiveEditor()).getDiagramEditor();
		}
		switch (featureChanged) {
		case GraphBTPackage.STANDARD_NODE__OPERATOR:
			if(notification.getNewStringValue().equalsIgnoreCase("^") && !notification.getOldStringValue().equalsIgnoreCase("^")) {
				GraphBTUtil.reversionNode.add(node);
				Edge edge = node.getEdge();
				if(edge != null || GraphBTUtil.getAncestor(node)==null) {
					GraphBTUtil.errorReversionNode.add(node);
				}
			} else if(notification.getOldStringValue().equalsIgnoreCase("^") && !notification.getNewStringValue().equalsIgnoreCase("^")) {
				System.out.println("Berubah dari reversion ke node biasa nue");
				GraphBTUtil.reversionNode.remove(node);
				GraphBTUtil.errorReversionNode.remove(node);
			}
			break;
//		case GraphBTPackage.STANDARD_NODE__COMPONENT_REF:
		case GraphBTPackage.STANDARD_NODE__BEHAVIOR_REF:
		case GraphBTPackage.STANDARD_NODE__EDGE:
		case GraphBTPackage.STANDARD_NODE__PARENT:
			if(GraphBTUtil.reversionNode.size() > 0) {
				for(int i = 0 ; i < GraphBTUtil.reversionNode.size(); i++) {
					StandardNode n = GraphBTUtil.reversionNode.get(i);
					Edge edge = n.getEdge();
					if(edge != null || GraphBTUtil.getAncestor(n)==null) {
						GraphBTUtil.errorReversionNode.add(n);
					}
				}
			}			
			break;
		default:
			break;
		}

		System.out.println("di standardnode adapter: "+GraphBTUtil.errorReversionNode.size()+" "+GraphBTUtil.reversionNode.size());
		GraphBTUtil.updateReversionNode(ds);
	}
}
