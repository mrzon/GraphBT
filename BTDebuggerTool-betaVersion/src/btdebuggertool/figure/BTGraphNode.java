package btdebuggertool.figure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.IContainer;

public class BTGraphNode extends CGraphNode {
	private IFigure btNodeFigure;
	
	public BTGraphNode(IContainer graphModel, int style, IFigure figure) {
		super(graphModel, style, figure);
		this.btNodeFigure = figure;
	}

	public IFigure getBtNodeFigure() {
		return btNodeFigure;
	}
	
}
