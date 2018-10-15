package com.github.lespaul361.commons.simplespreadsheet;

import java.io.WriteAbortedException;

import org.jdom.Element;

import com.google.common.collect.Table;
import com.opera.core.systems.scope.protos.Esdbg6Protos.BreakpointID;

abstract class AbstractOpenDocStyle {
	final String family;
	final String name;
	final Properties property;
	final String STYLE_HEADER = "style:style";
	final String STYLE_FAMILY="style:family";
	final String STYLE_NAME="style:name";
	
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
