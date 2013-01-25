package org.be.graphbt.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class ProjectDocumentation {
	public static void generate() throws FileNotFoundException, IOException
	{
		File docstr = ProjectUtil.getSharedResource("files/empty.doc");
		/*ClassLoader classloader = org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
		URL res = classloader.getResource("org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
		String path = res.getPath();
		System.out.println("Core POI came from " + path);

		System.out.println("Ini file empty docnya"+docstr);
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(docstr));
        HWPFDocument doc = new HWPFDocument(fs);

        // centered paragraph with large font size
        Range range = doc.getRange();
        Paragraph par1 = range.insertAfter(new ParagraphProperties(), 0);
        par1.setSpacingAfter(200);
        par1.setJustification((byte) 1);
        // justification: 0=left, 1=center, 2=right, 3=left and right

        CharacterRun run1 = par1.insertAfter("one");
        run1.setFontSize(2 * 18);
        // font size: twice the point size

        // paragraph with bold typeface
        Paragraph par2 = run1.insertAfter(new ParagraphProperties(), 0);
        par2.setSpacingAfter(200);
        CharacterRun run2 = par2.insertAfter("two two two two two two two two two two two two two");
        run2.setBold(true);

        // paragraph with italic typeface and a line indent in the first line
        Paragraph par3 = run2.insertAfter(new ParagraphProperties(), 0);
        par3.setFirstLineIndent(200);
        par3.setSpacingAfter(200);
        CharacterRun run3 = par3.insertAfter("three three three three three three three three three "
            + "three three three three three three three three three three three three three three "
            + "three three three three three three three three three three three three three three");
        run3.setItalic(true);

        // add a custom document property (needs POI 3.5; POI 3.2 doesn't save custom properties)
        DocumentSummaryInformation dsi = doc.getDocumentSummaryInformation();
        CustomProperties cp = dsi.getCustomProperties();
        if (cp == null)
            cp = new CustomProperties();
        cp.put("myProperty", "foo bar baz");
        dsi.setCustomProperties(cp);

        doc.write(new FileOutputStream("new-hwpf-file.doc"));*/
	}
}
