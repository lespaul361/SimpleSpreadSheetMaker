package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.styles;

import org.jdom.Element;

abstract class AbstractOpenDocStyle implements StyleStyle{
	final String family;
	final String name;
	final Properties property;
	final String STYLE_HEADER = "style:style";
	final String STYLE_FAMILY = "style:family";
	final String STYLE_NAME = "style:name";
	
	public enum Properties {
		TABLE, ROW, COLUMN, CELL;
	}
	
	public AbstractOpenDocStyle(String family, String name,
			Properties property) {
		this.family = family;
		this.name = name;
		this.property = property;
	}
	
	public abstract void write(Element parentElement);
	
	public abstract String toString();
}
