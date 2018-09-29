package com.github.lespaul361.commons.simplespreadsheet;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

class OpenDocContentXMLBuilder {
	private final WorkBook workBook;

	public OpenDocContentXMLBuilder(WorkBook workBook) {
		this.workBook = workBook;
	}

	public Document getDocument() {
		Element root = new Element("office:document-meta");
		List<Attribute> attributes = new ArrayList<>();

		root.setAttributes(OpenDocumentSpreadSheetOutPut.getCommonAttributes());
		Element eleStyles = new Element("office:automatic-styles");
		Element eleStyle = new Element("style:style");

		// default table style
		attributes.add(new Attribute("style:family", "table"));
		attributes.add(new Attribute("style:name", "ta0"));
		eleStyle.setAttributes(attributes);
		Element eleProperties = new Element("style:table-properties");
		eleProperties.setAttribute(new Attribute("table:display", "true"));
		eleStyle.addContent(eleProperties);
		eleStyles.addContent(eleStyle);

		// default cell style
		eleStyle = new Element("style:style");
		attributes = new ArrayList<>();
		attributes.add(new Attribute("style:family", "table-cell"));
		attributes.add(new Attribute("style:name", "bl1"));
		attributes.add(new Attribute("style:parent-style-name", "Default"));
		eleStyle.setAttributes(attributes);
		eleProperties = new Element("style:table-cell-properties");
		attributes = new ArrayList<>();
		attributes.add(new Attribute("style:text-align-source", "fix"));
		attributes.add(new Attribute("style:repeat-content", "false"));
		attributes.add(new Attribute("fo:border", "0.06pt solid #000000"));
		//attributes.add(new Attribute("", ""));
		eleProperties.setAttributes(attributes);
		eleStyle.addContent(eleProperties);
		eleProperties=new Element("style:paragraph-properties");
		attributes=new ArrayList<>();
		attributes.add(new Attribute("fo:text-align", "center"));
		attributes.add(new Attribute("fo:margin-left", "Opt"));		
		eleProperties.setAttributes(attributes);
		eleStyle.addContent(eleProperties);
		eleProperties=new Element("style:text-properties");
		attributes=new ArrayList<>();
		attributes.add(new Attribute("fo:font-weight", "bold"));
		attributes.add(new Attribute("style:font-weight-asian", "bold"));
		attributes.add(new Attribute("style:font-weight-complex", "bold"));
		eleProperties.setAttributes(attributes);
		eleStyle.addContent(eleProperties);
		eleStyles.addContent(eleStyle);
		
		
		
		eleStyle.addContent(eleProperties);
		eleStyles.addContent(eleStyle);

	}
}
