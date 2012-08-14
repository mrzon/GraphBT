package btdebuggertool.figure;

import java.util.ArrayList;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;


import bt.model.BTBehavior;
import bt.model.BTBehaviorRelation;
import bt.model.BTBehaviorType;
import bt.model.BTNode;
import bt.model.BTNodeType;

public class BTNodeAtomicFigure extends IBTNodeFigure{
	private Color borderColor = ColorConstants.black;
	public static final int BORDER_WIDTH = 3;
	public static Color greenColor = new Color(null, 179, 211, 69);
	
	private ArrayList<ArrayList<Figure>> topLeftFigures; 
	
	public BTNodeAtomicFigure(ArrayList<BTNode> atomicNodes){
		GridLayout gridLayoutNode = new GridLayout(1, false);
		setLayoutManager(gridLayoutNode);
		setBorder(new LineBorder(borderColor, BORDER_WIDTH));
		setBackgroundColor(greenColor);
		setOpaque(true);
//		this.atomicNode = atomicNodes;
		this.topLeftFigures = new ArrayList<ArrayList<Figure>>();
		for(int i = 0;i < atomicNodes.size(); ++i){
			IFigure fig = getFigureDefinition(atomicNodes.get(i), i);
			add(fig);
		}
		
	}
	
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		this.setBorder(new LineBorder(borderColor, BORDER_WIDTH));
//		for (IBTNodeFigure fig : atomicNodeFigures) {
//			fig.setBorderColor(borderColor);
//		}
	}
	
	private Figure getFigureDefinition(BTNode node, int index) throws IllegalArgumentException{
		
		if(node!=null && node.getBTNodeType() == BTNodeType.PARALLELBLOCK)
			throw new IllegalArgumentException("Can't passing BTNodeType.PARALLELBLOCK here");
		if(node!=null && node.getBTNodeType() == BTNodeType.ALTERNATIVEBLOCK)
			return getBTNodeFigure("", "[ ]", "", "", "", "");
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
			return this.getBTNodeFigure(componentName,behaviorName,operator,label,traceabilityLink, traceabilityStatus);
		}else{
			return this.getBTNodeFigureWithRelations(componentName, behaviorName, operator, label, traceabilityLink, traceabilityStatus, node.getBehavior().getRelations());
		}
	}
	
	private Figure getBTNodeFigure(String componentName, String behavior, String operator, String label, String traceabilityLink, String traceabilityStatus) {

		Figure fig = new Figure();
		GridLayout gridLayoutNode = new GridLayout(3, false);
		fig.setLayoutManager(gridLayoutNode);
//		fig.setBorder(new LineBorder(ColorConstants.black, BORDER_WIDTH));
//		fig.setBackgroundColor(ZestDebuggerView.BTColorConstanta.NOT_ACTIVE);
		fig.setOpaque(false);
		
		Figure leftFigure = new Figure();
		Figure middleFigure = new Figure();
		Figure rightFigure = new Figure();
		
		ArrayList<Figure> temp = new ArrayList<Figure>();
		temp.add(leftFigure);
		this.topLeftFigures.add(temp);

		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridLayoutNode.setConstraint(leftFigure, gridData);
		gridData.widthHint = 50;
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.widthHint = 150;
		gridLayoutNode.setConstraint(middleFigure, gridData);
		gridData = new GridData(GridData.END, GridData.BEGINNING, false, false);
		gridData.widthHint = 40;
		gridLayoutNode.setConstraint(rightFigure, gridData);
		
		fig.add(leftFigure);
		fig.add(middleFigure);
		fig.add(rightFigure);
		
		//adding left figure child
		Label labelTraceabilityLink = new Label(traceabilityLink);
		Label labelTraceabilityStatus = new Label(traceabilityStatus);
		
		GridLayout leftLayout = new GridLayout(1, false);
		leftFigure.setLayoutManager(leftLayout);
		
		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityLink, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityStatus, gridData);
		
		leftFigure.add(labelTraceabilityLink);
		leftFigure.add(labelTraceabilityStatus);
		
		//adding middle figure child
		Label labelComponentName = new Label(componentName);
		Label labelBehavior = new Label(behavior);
		
		GridLayout middleLayout = new GridLayout(1, false);
		middleFigure.setLayoutManager(middleLayout);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelComponentName, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelBehavior, gridData);
		
		middleFigure.add(labelComponentName);
		middleFigure.add(labelBehavior);
		
		//adding right figure child
		Label labelOperator = new Label(operator);
		Label labelLabel = new Label(label);
		
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
		return fig;
	}
	
	private Figure getBTNodeFigureWithRelations(String componentName, String behavior, String operator, String label, String traceabilityLink, String traceabilityStatus, ArrayList<BTBehaviorRelation> relations) {
		Figure fig = new Figure();
		GridLayout gridLayoutNode = new GridLayout(3, false);
		fig.setLayoutManager(gridLayoutNode);
//		fig.setBorder(new LineBorder(ColorConstants.black, BORDER_WIDTH));
//		fig.setBackgroundColor(greenColor);
		fig.setOpaque(false);
		
		ArrayList<Figure> figureListBorder = new ArrayList<Figure>();
		
		Figure leftFigure = new Figure();
		Figure middleFigure = new Figure();
		Figure rightFigure = new Figure();
		
		figureListBorder.add(leftFigure);
		this.topLeftFigures.add(figureListBorder);

		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.widthHint = 50;
		gridLayoutNode.setConstraint(leftFigure, gridData);
		
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.widthHint = 150;
		gridLayoutNode.setConstraint(middleFigure, gridData);
		
		gridData = new GridData(GridData.END, GridData.BEGINNING, false, false);
		gridData.widthHint = 40;
		gridLayoutNode.setConstraint(rightFigure, gridData);

		fig.add(leftFigure);
		fig.add(middleFigure);
		fig.add(rightFigure);
		
		//adding left figure child
		Label labelTraceabilityLink = new Label(traceabilityLink);
		Label labelTraceabilityStatus = new Label(traceabilityStatus);
		
		GridLayout leftLayout = new GridLayout(1, false);
		leftFigure.setLayoutManager(leftLayout);
		
		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityLink, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		leftLayout.setConstraint(labelTraceabilityStatus, gridData);
		
		leftFigure.add(labelTraceabilityLink);
		leftFigure.add(labelTraceabilityStatus);
		
		//adding middle figure child
		Label labelComponentName = new Label(componentName);
		Label labelBehavior = new Label(behavior);
		
		GridLayout middleLayout = new GridLayout(1, false);
		middleFigure.setLayoutManager(middleLayout);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelComponentName, gridData);

		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		middleLayout.setConstraint(labelBehavior, gridData);
		
		middleFigure.add(labelComponentName);
		middleFigure.add(labelBehavior);
		
		//adding right figure child
		Label labelOperator = new Label(operator);
		Label labelLabel = new Label(label);
		
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
			
			fig.add(left);
			fig.add(right);
			
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
		return fig;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle bound = super.getBounds().getCopy();
		Dimension dimension = super.getPreferredSize();
		bound.setWidth(dimension.width());
		bound.setHeight(dimension.height());
		return bound;
	}
	
	@Override
	protected void paintBorder(Graphics graphics) {
		super.paintBorder(graphics);
		
		Rectangle bound = topLeftFigures.get(0).get(0).getBounds().getCopy();
		Rectangle boundParent = getBounds().getCopy();
		
		graphics.setLineWidth(BORDER_WIDTH);
		graphics.setForegroundColor(borderColor);
		
		//paint R|Behavior
		graphics.drawLine(bound.getRight().x , boundParent.getTop().y, bound.getRight().x , boundParent.getBottom().y);
		
		for(int i = 0;i < topLeftFigures.size();++i){
			for(int j = 0; j < topLeftFigures.get(i).size();++j){
				if(i == 0 && j == 0)
					continue;
				else if(j == 0)
					graphics.setLineWidth(BORDER_WIDTH);
				else
					graphics.setLineWidth(BORDER_WIDTH-1);
				bound = topLeftFigures.get(i).get(j).getBounds();
				graphics.drawLine(boundParent.getTopLeft().x, bound.getTop().y,  boundParent.getTopRight().x, bound.getTop().y);
			}
		}
		
		
	}
	
}
