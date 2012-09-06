package behaviortree.graphBT.features;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

import behaviortree.GraphBTUtil;
import behaviortree.StandardNode;

/**
 * Class for specifying paste feature for a standard BT node
 * @author GraphBT Team
 *
 */
public class PasteNodeGraphBtFeature extends AbstractPasteFeature {

	public PasteNodeGraphBtFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void paste(IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Diagram diagram = (Diagram) pes[0];

		Object[] objects = getFromClipboard();
		for (Object object : objects) {
			AddContext ac = new AddContext();
			ac.setLocation(context.getX(), context.getY()); 
			ac.setTargetContainer(diagram);
			if(object instanceof StandardNode)
			{
				object = copyNode((StandardNode)object);
				//link(pe, bos[i]);

				try {
					GraphBTUtil.saveToModelFile((EObject) object, getDiagram());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addGraphicalRepresentation(ac, object);
			}
		}
	}

	public boolean canPaste(IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 1 || !(pes[0] instanceof Diagram)) {
			return false;
		}

		Object[] fromClipboard = getFromClipboard();
		if (fromClipboard == null || fromClipboard.length == 0) {
			return false;
		}
		for (Object object : fromClipboard) {
			if (!(object instanceof StandardNode)) {
				return false;
			}
		}
		return true;
	}
	private StandardNode copyNode(StandardNode nd)
	{
		StandardNode cnd = GraphBTUtil.getBEFactory().createStandardNode();
		cnd.setBehaviorRef(nd.getBehaviorRef());
		cnd.setComponentRef(nd.getComponentRef());
		cnd.setLabel(""+System.currentTimeMillis());
		cnd.setTraceabilityLink(nd.getTraceabilityLink());
		cnd.setOperator(nd.getOperator());
		cnd.setTraceabilityStatus(nd.getTraceabilityStatus());
		return cnd;
	}
}
