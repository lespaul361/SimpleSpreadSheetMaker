package com.github.lespaul361.commons.simplespreadsheet;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

class OpenDocTableCellStyle extends AbstractOpenDocStyle {
	private Element thisElement = null;
	private final String styleParent;
	private final String CELL_PROP="style:table-cell-properties";
	private final String CELL_PARENT_PROP="style:parent-style-name";
	public OpenDocTableCellStyle(String family, String name, String parent) {
		super(family, name, Properties.CELL);
		this.styleParent=parent;
	}
	
	@Override
	public void write(Element parentElement) {
		parentElement.addContent(this.thisElement);
	}
	
	@Override
	public String toString() {
		return this.thisElement.toString();
	}
	
	private void createThisElement() {
		Element element = new Element(super.STYLE_HEADER);
		List<Attribute>attributes=new ArrayList<>();
		attributes.add(new Attribute(STYLE_FAMILY,family));
		attributes.add(new Attribute(STYLE_NAME, name));
		attributes.add(new Attribute(CELL_PARENT_PROP, styleParent));
		element.setAttributes(attributes);
	}
}
