/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Hamilton
 */
public class Column {

    public static final String PROP_COLUMNNUMBER = "PROP_COLUMNNUMBER";
    public static final String PROP_CELLS = "PROP_CELLS";
    public static final String PROP_STYLE = "PROP_STYLE";
    private int columnNumber = 0;
    private List<Cell> cells = new ArrayList<>();
    private Style style = new Style();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * @return the columnNumber
     */
    protected int getColumnNumber() {
        return columnNumber;
    }

    /**
     * @param columnNumber the columnNumber to set
     */
    protected void setColumnNumber(int columnNumber) {
        int oldColumnNumber = this.columnNumber;
        this.columnNumber = columnNumber;
        propertyChangeSupport.firePropertyChange(PROP_COLUMNNUMBER, oldColumnNumber, columnNumber);
    }

    /**
     * @return the cells
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * @param cells the cells to set
     */
    public void setCells(List<Cell> cells) {
        java.util.List<com.github.lespaul361.commons.simplespreadsheet.Cell> oldCells = this.cells;
        this.cells = cells;
        propertyChangeSupport.firePropertyChange(PROP_CELLS, oldCells, cells);
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
}
