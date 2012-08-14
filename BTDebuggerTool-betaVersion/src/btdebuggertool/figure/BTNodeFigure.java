package btdebuggertool.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import btdebuggertool.view.ZestDebuggerView;

public class BTNodeFigure extends IBTNodeFigure{
	public static final int BORDER_WIDTH = 3;
	
	private Figure leftFigure, middleFigure, rightFigure;
	
	private Label labelComponentName, labelBehavior, labelOperator, labelLabel;
	private Label labelTraceabilityLink, labelTraceabilityStatus;
	
	private Color borderColor = ColorConstants.black;
	
	public BTNodeFigure(String componentName, String behavior, String operator, String label, String traceabilityLink, String traceabilityStatus) {
		GridLayout gridLayoutNode = new GridLayout(3, false);
		setLayoutManager(gridLayoutNode);
		setBorder(new LineBorder(ColorConstants.black, BORDER_WIDTH));
		setBackgroundColor(ZestDebuggerView.BTColorConstanta.NOT_ACTIVE);
		setOpaque(true);
		
		
		leftFigure = new Figure();
		middleFigure = new Figure();
		rightFigure = new Figure();

		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridLayoutNode.setConstraint(leftFigure, gridData);
		gridData.widthHint = 50;
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.widthHint = 150;
		gridLayoutNode.setConstraint(middleFigure, gridData);
		gridData = new GridData(GridData.END, GridData.BEGINNING, false, false);
		gridData.widthHint = 40;
		gridLayoutNode.setConstraint(rightFigure, gridData);
		
		add(leftFigure);
		add(middleFigure);
		add(rightFigure);
		
		//adding left figure child
		labelTraceabilityLink = new Label(traceabilityLink);
		labelTraceabilityStatus = new Label(traceabilityStatus);
		
		GridLayout leftLayout = new GridLayout(1, false);
		leftFigure.setLayoutManager(leftLayout);
		
		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityLink, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityStatus, gridData);
		
		leftFigure.add(labelTraceabilityLink);
		leftFigure.add(labelTraceabilityStatus);
		
		//adding middle figure child
		labelComponentName = new Label(componentName);
		labelBehavior = new Label(behavior);
		
		GridLayout middleLayout = new GridLayout(1, false);
		middleFigure.setLayoutManager(middleLayout);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelComponentName, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelBehavior, gridData);
		
		middleFigure.add(labelComponentName);
		middleFigure.add(labelBehavior);
		
		//adding right figure child
		labelOperator = new Label(operator);
		labelLabel = new Label(label);
		
		GridLayout rightLayout = new GridLayout(1, false);
		rightFigure.setLayoutManager(rightLayout);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		rightLayout.setConstraint(labelOperator, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		rightLayout.setConstraint(labelLabel, gridData);
		
		rightFigure.add(labelOperator);
		rightFigure.add(labelLabel);
//		
//		setMinimumSize(new Dimension(230, 0));
//		setMaximumSize(new Dimension(230, Integer.MAX_VALUE));
		
	}
	
	@Override
	public Rectangle getBounds() {
		Rectangle bound = super.getBounds().getCopy();
		Dimension dimension = getPreferredSize();
		bound.setWidth(dimension.width());
		bound.setHeight(dimension.height());
		return bound;
	}
	
	@Override
	protected void paintBorder(Graphics graphics) {
		super.paintBorder(graphics);
		Rectangle bound = leftFigure.getBounds().getCopy();
		Rectangle boundParent = getBounds().getCopy();
		
		graphics.setLineWidth(BORDER_WIDTH);
		graphics.setForegroundColor(borderColor);
		graphics.drawLine(bound.getRight().x , boundParent.getTop().y, bound.getRight().x , boundParent.getBottom().y);
		
	
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		this.setBorder(new LineBorder(borderColor, BORDER_WIDTH));
	}
}
