/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author David Hamilton
 */
public class Cell implements Serializable {

    public static final String PROP_ROW = "PROP_ROW";
    public static final String PROP_COLUMN = "PROP_COLUMN";
    public static final String PROP_TEXT = "PROP_TEXT";
    public static final String PROP_FUNCTION = "PROP_FUNCTION";
    public static final String PROP_STYLE = "PROP_STYLE";
    private int row = 0;
    private int column = 0;
    private String text = "";
    private Function function = null;
    private Style style = new Style();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private static final long serialVersionUID = -5294506904949593L;
    private final Sheet sheet;

    private Cell(Sheet sheet) {
        this.sheet = sheet;
    }

    public Cell createInstance(Sheet sheet) {
        return new Cell(sheet);
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        int oldRow = this.row;
        this.row = row;
        propertyChangeSupport.firePropertyChange(PROP_ROW, oldRow, row);
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        int oldColumn = this.column;
        this.column = column;
        propertyChangeSupport.firePropertyChange(PROP_COLUMN, oldColumn, column);
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        java.lang.String oldText = this.text;
        this.text = text;
        propertyChangeSupport.firePropertyChange(PROP_TEXT, oldText, text);
    }

    /**
     * @return the function
     */
    public Function getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(Function function) {
        com.github.lespaul361.commons.simplespreadsheet.Function oldFunction = this.function;
        this.function = function;
        propertyChangeSupport.firePropertyChange(PROP_FUNCTION, oldFunction, function);
    }

    /**
     * Add a PropertyChangeListener for a specific property. The listener will
     * be invoked only when a call on firePropertyChange names that specific
     * property. The same listener object may be added more than once. For each
     * property, the listener will be invoked the number of times it was added
     * for that property. If propertyName or listener is null, no exception is
     * thrown and no action is taken.
     *
     * @param listener the PropertyChangeListener to add
     * @see PropertyChangeListener
     * @see PropertyChangeSupport
     */
    public void addNotificationListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Add a PropertyChangeListener for a specific property. The listener will
     * be invoked only when a call on firePropertyChange names that specific
     * property. The same listener object may be added more than once. For each
     * property, the listener will be invoked the number of times it was added
     * for that property. If propertyName or listener is null, no exception is
     * thrown and no action is taken.
     *
     * @param propertyName - The name of the property to listen on.
     * @param listener - The PropertyChangeListener to be added
     * @see PropertyChangeListener
     * @see PropertyChangeSupport
     */
    public void addNotificationListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    /**
     * @return the style
     */
    public Style getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(Style style) {
        com.github.lespaul361.commons.simplespreadsheet.Style oldStyle = this.style;
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
        hash = 97 * hash + Objects.hashCode(this.sheet);
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
        final Cell other = (Cell) obj;
        return (other.hashCode() == obj.hashCode());
    }

}
