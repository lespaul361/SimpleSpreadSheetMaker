package com.github.lespaul361.commons.simplespreadsheet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

class OpenDocumentSpreadSheetOutPut {
	private File manifestXML = null;
	private File metaXML = null;
	private File stylesXML = null;
	private File mimeType = null;
	private File contentXML = null;
	private OutputStream outputStream = null;

	public void createSpreadSheet(OutputStream out) throws IOException {
		this.outputStream = out;
		writeManifestFile();
		writeMetaXML();
		writeStylesXMP();
		writeMimeType();
	}

	public void createSpreadSheet(File file) throws IOException {
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

	private void writeMetaXML() throws IOException {
		Element root = new Element("office:document-meta");
		List<Attribute> attributes = new ArrayList<>();

		root.setAttributes(getCommonAttributes());

		Element elementO = new Element("office:meta");
		Element elementM = new Element("meta:generator");
		elementM.setText("jOpenDocument/1.3");
		elementO.addContent(elementM);
		root.addContent(elementO);

		Document document = new Document(root);
		document.setRootElement(root);

		this.metaXML = File.createTempFile("", "");

		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat());
		outputter.output(document, new FileWriter(this.metaXML));

	}

	private void writeStylesXMP() throws IOException {

		Element root = new Element("office:document-styles");
		
		root.setAttributes(getCommonAttributes(););

		Element elementO = new Element("office:styles");
		Element elementA = new Element("office:automatic-styles");
		Element elementM = new Element("office:master-styles");
		root.addContent(elementO);
		root.addContent(elementA);
		root.addContent(elementM);

		Document document = new Document(root);
		document.setRootElement(root);

		this.stylesXML = File.createTempFile("", "");

		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat().setExpandEmptyElements(false));
		outputter.output(document, new FileWriter(this.stylesXML));

	}

	private void writeMimeType() throws IOException {
		String content = "application/vnd.oasis.opendocument.spreadsheet";
		this.mimeType = File.createTempFile("", "");
		FileWriter fWriter = new FileWriter(this.mimeType);
		fWriter.write(content);
		fWriter.flush();
		fWriter.close();
	}

	private byte[] getFileBytes(File file) throws FileNotFoundException, IOException {
		try {
			Path filePath = Paths.get(file.getAbsolutePath());
			return Files.readAllBytes(filePath);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private List<Attribute> getCommonAttributes() {
		List<Attribute> attributes = new ArrayList<>();
		attributes.add(new Attribute("xmlns:office", "urn:oasis:names:tc:opendocument:xmlns:office:1.0"));
		attributes.add(new Attribute("xmlns:svg", "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"));
		attributes.add(new Attribute("xmlns:fo", "urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"));
		attributes.add(new Attribute("xmlns:draw", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"));
		attributes.add(new Attribute("xmlns:script", "urn:oasis:names:tc:opendocument:xmlns:script:1.0"));
		attributes.add(new Attribute("xmlns:ooo", "http://openoffice.org/2004/office"));
		attributes.add(new Attribute("xmlns:number", "urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0"));
		attributes.add(new Attribute("xmlns:form", "urn:oasis:names:tc:opendocument:xmlns:form:1.0"));
		attributes.add(new Attribute("xmlns:meta", "urn:oasis:names:tc:opendocument:xmlns:meta:1.0"));
		attributes.add(new Attribute("xmlns:style", "urn:oasis:names:tc:opendocument:xmlns:style:1.0"));
		attributes.add(new Attribute("xmlns:text", "urn:oasis:names:tc:opendocument:xmlns:text:1.0"));
		attributes.add(new Attribute("xmlns:config", "urn:oasis:names:tc:opendocument:xmlns:config:1.0"));
		attributes.add(new Attribute("xmlns:table", "urn:oasis:names:tc:opendocument:xmlns:table:1.0"));
		attributes.add(new Attribute("xmlns:xlink", "http://www.w3.org/1999/xlink"));
		attributes.add(new Attribute("xmlns:dc", "http://purl.org/dc/elements/1.1/"));
		attributes.add(new Attribute("office:version", "1.2"));

		return attributes;

	}

	private void writeToZip() throws IOException {
		ZipOutputStream zOut = new ZipOutputStream(this.outputStream);

		ZipEntry zipEntry = new ZipEntry("META_INF/manifest.xml");
		zOut.putNextEntry(zipEntry);
		zOut.write(getFileBytes(this.manifestXML));
		zOut.closeEntry();

		zipEntry = new ZipEntry("mimetype");
		zOut.putNextEntry(zipEntry);
		zOut.write(getFileBytes(this.mimeType));
		zOut.closeEntry();

		zipEntry = new ZipEntry("styles.xml");
		zOut.putNextEntry(zipEntry);
		zOut.write(getFileBytes(this.stylesXML));
		zOut.closeEntry();

		zipEntry = new ZipEntry("meta.xml");
		zOut.putNextEntry(zipEntry);
		zOut.write(getFileBytes(this.metaXML));
		zOut.closeEntry();

		zipEntry = new ZipEntry("content.xml");
		zOut.putNextEntry(zipEntry);
		zOut.write(getFileBytes(this.contentXML));
		zOut.closeEntry();

		zOut.flush();
		zOut.close();

	}
}
