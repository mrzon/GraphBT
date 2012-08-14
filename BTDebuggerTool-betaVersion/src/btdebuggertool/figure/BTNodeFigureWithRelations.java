package btdebuggertool.figure;

import java.util.ArrayList;

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

import bt.model.BTBehaviorRelation;

public class BTNodeFigureWithRelations extends IBTNodeFigure {
	public static final int BORDER_WIDTH = 3;
	
	public static Color greenColor = new Color(null, 179, 211, 69);
	
	private Figure leftFigure, middleFigure, rightFigure;
	private ArrayList<Figure> figureListBorder;
	private Label labelComponentName, labelBehavior, labelOperator, labelLabel;
	private Label labelTraceabilityLink, labelTraceabilityStatus;
	private Color borderColor = ColorConstants.black;
	

	public BTNodeFigureWithRelations(String componentName, String behavior, String operator, String label, String traceabilityLink, String traceabilityStatus, ArrayList<BTBehaviorRelation> relations) {
		GridLayout gridLayoutNode = new GridLayout(3, false);
		setLayoutManager(gridLayoutNode);
		setBorder(new LineBorder(ColorConstants.black, BORDER_WIDTH));
		setBackgroundColor(greenColor);
		setOpaque(true);
		
		figureListBorder = new ArrayList<Figure>();
		
		leftFigure = new Figure();
		middleFigure = new Figure();
		rightFigure = new Figure();

		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.widthHint = 50;
		gridLayoutNode.setConstraint(leftFigure, gridData);
		
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
		
		
		//adding relations
		for (BTBehaviorRelation btBehaviorRelation : relations) {
			String question = btBehaviorRelation.getRelationType().toString();
			String preposition = btBehaviorRelation.getComplement()  == null ? "" : btBehaviorRelation.getComplement();
			String componentRef = btBehaviorRelation.getComponentRef();
			
			Figure left = new Figure();
			Figure right = new Figure();
			
			gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
			gridData.widthHint = 50;
			gridLayoutNode.setConstraint(left, gridData);
			
			gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
			gridData.widthHint = 150 + 40;
			gridData.horizontalSpan = 2;
			gridLayoutNode.setConstraint(right, gridData);
			
			add(left);
			add(right);
			
			//adding just left figure
			figureListBorder.add(left);
			
			//left 
			Label questionLabel = new Label(question);
			Label prepositionLabel = new Label("("+preposition+")");
			
			leftLayout = new GridLayout(1, false);
			left.setLayoutManager(leftLayout);
			
			gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
			leftLayout.setConstraint(questionLabel, gridData);

			gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
			leftLayout.setConstraint(prepositionLabel, gridData);
			
			left.add(questionLabel);
			left.add(prepositionLabel);
			
			//right
			Label componentRefLabel = new Label(componentRef);
			
			rightLayout = new GridLayout(1, false);
			right.setLayoutManager(rightLayout);
			
			gridData = new GridData(GridData.CENTER, GridData.CENTER, true, true);
			rightLayout.setConstraint(componentRefLabel, gridData);
			
			right.add(componentRefLabel);
//
//			setMinimumSize(new Dimension(230, 0));
//			setMaximumSize(new Dimension(230, Integer.MAX_VALUE));
			
		}
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
		
		for (Figure leftFigure : figureListBorder) {
			bound = leftFigure.getBounds().getCopy();
			graphics.drawLine(boundParent.getLeft().x, bound.getTop().y, boundParent.getRight().x, bound.getTop().y);
			
		}
	}
	
	@Override
	public void setBackgroundColor(Color bg) {
		
		super.setBackgroundColor(bg);
	}
	

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		this.setBorder(new LineBorder(borderColor, BORDER_WIDTH));
	}
}
