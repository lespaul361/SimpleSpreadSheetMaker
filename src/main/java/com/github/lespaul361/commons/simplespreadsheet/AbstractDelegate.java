package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

class AbstractDelegate {
	final Sheet sheet;
	final  Map<Integer, Style> rowStyleMap;
	final Map<Integer, Style> columnStyleMap;
	public AbstractDelegate(Sheet sheet,Map<Integer, Style> rowStyleMap, Map<Integer, Style> columnStyleMap) {
		this.sheet = sheet;
		this.rowStyleMap=rowStyleMap;
		this.columnStyleMap=columnStyleMap;
	}
}
