package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.styles;

import java.util.Collection;

import org.jdom.Element;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.properties.*;

public interface StyleStyle {
	enum Families{
		TABLE;
		public String toString() {
			switch(this) {
				case TABLE:
					return "table";
			}
			return "";
		}
	}
	void addProptery(Property property);
	
	void addProperties(Collection<Property> properties);
	
	void addProperties(Property[] properties);
	
	public Element getElement();
}
