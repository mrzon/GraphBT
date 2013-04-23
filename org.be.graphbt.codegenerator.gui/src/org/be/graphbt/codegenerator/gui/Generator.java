package org.be.graphbt.codegenerator.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.be.graphbt.codegenerator.gui.template.GraphBTGuiTemplate;
import org.be.graphbt.model.graphbt.BEModel;
import org.be.graphbt.model.graphbt.GraphBTFactory;

public class Generator {
	public static void main(String[]args) throws IOException {
		GraphBTGuiTemplate template = new GraphBTGuiTemplate();
		BEModel model = GraphBTFactory.eINSTANCE.createBEModel();
		String str = template.generate(model);		
		File f = new File("src/Public.java");
		FileWriter fw = new FileWriter(f);
		fw.write(str);
		fw.flush();
		fw.close();
	}
}
