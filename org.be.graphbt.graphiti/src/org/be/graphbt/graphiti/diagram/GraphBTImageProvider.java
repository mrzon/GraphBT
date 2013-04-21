package org.be.graphbt.graphiti.diagram;

import org.be.graphbt.graphiti.GraphBTUtil;
import org.eclipse.graphiti.internal.GraphitiPlugin;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.internal.GraphitiUIPlugin;
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class GraphBTImageProvider extends AbstractImageProvider {

	protected static final String PREFIX = 
            "org.eclipse.graphiti.examples.tutorial.";
	// The image identifier for an EReference.
	public static final String IMG_EREFERENCE= PREFIX + "ereference";
	public static final String VAL_EREFERENCE= PREFIX + "val";
	@Override
	protected void addAvailableImages() {
		// register the path for each image identifier
		addImageFilePath(IMG_EREFERENCE, "icons/sample.gif");
		addImageFilePath(VAL_EREFERENCE, "icons/validate.gif");
	}
	
	public void addImage(String ref,String path) {
		addImageFilePath(ref, path);
	}
}
