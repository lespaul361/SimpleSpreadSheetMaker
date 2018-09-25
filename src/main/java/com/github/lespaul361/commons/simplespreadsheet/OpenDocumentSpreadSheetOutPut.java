package com.github.lespaul361.commons.simplespreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

class OpenDocumentSpreadSheetOutPut {
	private File manifestXML = null;
	private File metaXML = null;

	public void createSpreadSheet(OutputStream out) throws IOException {
		writeManifestFile();

	}

	public void createSpreadSheet(File file) throws FileNotFoundException, IOException {
		createSpreadSheet(new FileOutputStream(file));
	}

	public void createSpreadSheet(String path) throws IOException {
		try {
			createSpreadSheet(new File(path));
		} catch (FileNotFoundException e) {
			File newFile = new File(path);
			newFile.createNewFile();
			createSpreadSheet(new File(path));
		}

	}

	private void writeManifestFile() throws IOException {
		Element root = new Element("manifest:manifest");
		Document document = new Document(root);
		document.setRootElement(root);

		Element entry = new Element("manifest:file-entry");
		entry.setAttribute("manifest:media-type", "application/vnd.oasis.opendocument.spreadsheet");
		entry.setAttribute("manifest:full-path", "/");
		document.getRootElement().addContent(entry);

		entry = new Element("manifest:file-entry");
		entry.setAttribute("manifest:media-type", "text/xml");
		entry.setAttribute("manifest:full-path", "meta.xml");
		document.getRootElement().addContent(entry);

		entry = new Element("manifest:file-entry");
		entry.setAttribute("manifest:media-type", "text/xml");
		entry.setAttribute("manifest:full-path", "content.xml");
		document.getRootElement().addContent(entry);

		entry = new Element("manifest:file-entry");
		entry.setAttribute("manifest:media-type", "text/xml");
		entry.setAttribute("manifest:full-path", "styles.xml");
		document.getRootElement().addContent(entry);

		this.manifestXML = File.createTempFile("", "");

		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat());
		outputter.output(document, new FileWriter(this.manifestXML));

	}

	private void writeMetaXML() {
		Element root = new Element("office:document-meta");
		root.setAttribute("office:version", "1.2");
		Document document = new Document(root);
		document.setRootElement(root);

	}
}
