package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

class AbstractDelegate {
	final Sheet sheet;
	final  Map<Integer, ICellStyle> rowStyleMap;
	final Map<Integer, ICellStyle> columnStyleMap;
	public AbstractDelegate(Sheet sheet,Map<Integer, ICellStyle> rowStyleMap, Map<Integer, ICellStyle> columnStyleMap) {
		this.sheet = sheet;
		this.rowStyleMap=rowStyleMap;
		this.columnStyleMap=columnStyleMap;
	}
}
