package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

class AbstractDelegate {
	final Sheet sheet;
	final  Map<Integer, FontStyle> rowStyleMap;
	final Map<Integer, FontStyle> columnStyleMap;
	public AbstractDelegate(Sheet sheet,Map<Integer, FontStyle> rowStyleMap, Map<Integer, FontStyle> columnStyleMap) {
		this.sheet = sheet;
		this.rowStyleMap=rowStyleMap;
		this.columnStyleMap=columnStyleMap;
	}
}
