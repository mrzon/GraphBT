package behaviortree.graphBT.diagram;

/*******************************************************************************
 * <copyright>
*
* Copyright (c) 2011, 2012 SAP AG.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    SAP AG - initial API, implementation and documentation
*    mwenz - Bug 358255 - Add Border/Background decorators
*
* </copyright>
*
*******************************************************************************/

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;

public class GraphBTToolBehaviorProvider  extends DefaultToolBehaviorProvider {

	//private List<Square> allowedSquaresForMove = new ArrayList<Square>();

	public GraphBTToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public boolean isShowGuides() {
		return false;
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		Object object = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		// Check if the business object of the given pictogram element (the
		// square) is one of the allowed squares (see CreateChessMoveFeature)
		// for a move in progress
		return super.getDecorators(pe);
	}

	/**
	 * Adds the given {@link List} of {@link Square}s to the list of allowed
	 * squares for a move, see {@link CreateChessMoveFeature}.
	 * 
	 * @param squares
	 *            the squares to add
	
	public void addToAllowedSquaresForMove(List<Square> squares) {
		allowedSquaresForMove.addAll(squares);
	}
 */
	/**
	 * Clears the {@link List} of allowed {@link Square}s for a move, see
	 * {@link CreateChessMoveFeature}.
	
	public void clearAllowedSquaresForMove() {
		allowedSquaresForMove.clear();
	} */
}
