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
import java.util.Objects;

/**
 *
 * @author David Hamilton
 */
public class Row {

    public static final String PROP_ROWNUMBER = "PROP_ROWNUMBER";
    public static final String PROP_CELLS = "PROP_CELLS";
    public static final String PROP_STYLE = "PROP_STYLE";
    private int rowNumber = 0;
    private List<BasicCell> cells = new ArrayList<>();
    private Style style = new RowStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final Sheet sheet;

    private Row(Sheet sheet) {
        this.sheet = sheet;
    }

    public static Row getInstance(Sheet sheet) {
        return new Row(sheet);
    }

    /**
     * @return the rowNumber
     */
    protected int getRowNumber() {
        return rowNumber;
    }

    /**
     * @param rowNumber the rowNumber to set
     */
    protected void setRowNumber(int rowNumber) {
        int oldRowNumber = this.rowNumber;
        this.rowNumber = rowNumber;
        propertyChangeSupport.firePropertyChange(PROP_ROWNUMBER, oldRowNumber, rowNumber);
    }

    /**
     * @return the cells
     */
    public List<BasicCell> getCells() {
        return cells;
    }

    /**
     * @param cells the cells to set
     */
    public void setCells(List<BasicCell> cells) {
        java.util.List<com.github.lespaul361.commons.simplespreadsheet.BasicCell> oldCells = this.cells;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.rowNumber;
        hash = 83 * hash + Objects.hashCode(this.cells);
        hash = 83 * hash + Objects.hashCode(this.style);
        hash = 83 * hash + Objects.hashCode(this.sheet);
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
        final Row other = (Row) obj;
        return other.hashCode() == this.hashCode();
    }

}
