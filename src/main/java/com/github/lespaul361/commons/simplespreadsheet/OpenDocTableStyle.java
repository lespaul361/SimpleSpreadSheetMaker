package com.github.lespaul361.commons.simplespreadsheet;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import com.itextpdf.text.Font.FontFamily;

class OpenDocTableStyle extends AbstractOpenDocStyle {
	private boolean isDisplay = true;
	private Element thisElement = null;
	private final String STYLE_PROP = "style:table-properties";
	private final String TBL_DISPLAY = "table:display";
	
	public OpenDocTableStyle(String family, String name) {
		super(family, name, Properties.TABLE);
	}
	
	public OpenDocTableStyle(String family, String name, boolean isDisplay) {
		this(family, name);
		setDisplay(isDisplay);
	}
	
	public boolean isDisplay() {
		return isDisplay;
	}
	
	public void setDisplay(boolean isDisplay) {
		if(this.isDisplay != isDisplay) {
			this.isDisplay = isDisplay;
			createThisElement();
		}
	}
	
	@Override
	public void write(Element parentElement) {
		parentElement.addContent(thisElement);
	}
	
	@Override
	public String toString() {
		return thisElement.toString();
	}
	
	private void createThisElement() {
		Element element = new Element(super.STYLE_HEADER);
		List<Attribute> attributes = new ArrayList<>();
		attributes.add(new Attribute(STYLE_FAMILY, family));
		attributes.add(new Attribute(STYLE_NAME, name));
		element.setAttributes(attributes);
		Element subElement = new Element(STYLE_PROP);
		if(isDisplay) {
			subElement.setAttribute(new Attribute(TBL_DISPLAY, "true"));
		} else {
			subElement.setAttribute(new Attribute(TBL_DISPLAY, "false"));
		}
		element.addContent(subElement);
		this.thisElement = element;
	}
}
