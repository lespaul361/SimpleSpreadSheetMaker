/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 * The base for cell on the spread sheet. 
 *
 * @author David Hamilton
 */
public abstract class AbstractCell implements Cell {

	protected int row = 0;
	protected int column = 0;
	protected String text = "";
	protected Function function = null;
	protected ICellStyle style = new CellStyle();
	protected final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
	protected Sheet sheet;

	@Override
	public int getRowNumber() {
		return row;
	}

	@Override
	public void setRowNumber(int row) {
		int oldRow = this.row;
		this.row = row;
		propertyChangeSupport.firePropertyChange(PROP_ROW, oldRow, row);
	}

	@Override
	public int getColumnNumber() {
		return column;
	}

	@Override
	public void setColumnNumber(int column) {
		int oldColumn = this.column;
		this.column = column;
		propertyChangeSupport.firePropertyChange(PROP_COLUMN, oldColumn, column);
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		java.lang.String oldText = this.text;
		this.text = text;
		propertyChangeSupport.firePropertyChange(PROP_TEXT, oldText, text);
	}

	@Override
	public Function getFunction() {
		return function;
	}

	@Override
	public void setFunction(Function function) {
		com.github.lespaul361.commons.simplespreadsheet.Function oldFunction = this.function;
		this.function = function;
		propertyChangeSupport.firePropertyChange(PROP_FUNCTION, oldFunction, function);
	}

	@Override
	public void addNotificationListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	@Override
	public void addNotificationListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@Override
	public ICellStyle getStyle() {
		return style;
	}

	@Override
	public void setStyle(ICellStyle style) {
		com.github.lespaul361.commons.simplespreadsheet.ICellStyle oldStyle = this.style;
		this.style = style;
		propertyChangeSupport.firePropertyChange(PROP_STYLE, oldStyle, style);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + this.row;
		hash = 97 * hash + this.column;
		hash = 97 * hash + Objects.hashCode(this.text);
		hash = 97 * hash + Objects.hashCode(this.function);
		hash = 97 * hash + Objects.hashCode(this.style);
		// hash = 97 * hash + Objects.hashCode(this.sheet);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BasicCell other = (BasicCell) obj;
		return (other.hashCode() == obj.hashCode());
	}

	@Override
	public void removeNotificationListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void removeNotificationListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}

	/**
	 * Used to clone a cell. This will return null and should be an override in
	 * inherited classes
	 *
	 * @return null
	 */
	@Override
	public Object clone() {
		return null;
	}
}
