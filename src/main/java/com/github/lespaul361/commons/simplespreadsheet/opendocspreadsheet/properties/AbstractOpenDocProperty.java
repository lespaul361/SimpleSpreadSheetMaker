package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.properties;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.GetOpenDocAttributes;

public abstract class AbstractOpenDocProperty implements Property {
	List<Attribute> attributes = new ArrayList<>(20);
	final String propertyName;
	Element element = null;
	
	public AbstractOpenDocProperty(String name) {
		this.propertyName = name;
	}
	
	void createElement() {
		clearAttributes();
		refreshAttributeContainers();
		Element element = new Element(this.propertyName);
		element.setAttributes(attributes);
		this.element = element;
	}
	
	void clearAttributes() {
		attributes.clear();
	}
	
	void addAttributes(GetOpenDocAttributes container) {
		this.attributes.addAll(container.getAttributes());
	}
	
	public String toString() {
		return this.getElement().toString();
	}
	
	public Element getElement() {
		return this.element;
	}
	
	abstract void refreshAttributeContainers();
}
