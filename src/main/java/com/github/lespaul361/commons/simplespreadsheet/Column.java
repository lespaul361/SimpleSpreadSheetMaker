/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author David Hamilton
 */
public class Column implements Serializable {

    /**
     * The property name for column number changes
     */
    public static final String PROP_COLUMN_NUMBER = "PROP_COLUMN_NUMBER";
    /**
     * The property name for the change event when a cell is added or removed
     */
    public static final String PROP_CELLS = "PROP_CELLS";
    /**
     * The property name for the change event when the style of this row is
     * changed
     */
    public static final String PROP_STYLE = "PROP_STYLE";

    private int columnNumber = -1;
    private List<Cell> cells = new ArrayList<>();
    private ICellStyle style = new ColumnStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final Sheet sheet;
    private static final long serialVersionUID = -52755945069593L;

    private Column(Sheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Gets a new instance of the Column class
     *
     * @param sheet the sheet this column is attached to
     * @return a Column class
     */
    static Column getInstance(Sheet sheet) {
        return new Column(sheet);
    }

    /**
     * Gets the column number
     *
     * @return the columnNumber
     */
    protected int getColumnNumber() {
        return columnNumber;
    }

    public Cell getCellInstance() {
        Cell cell = new BasicCell(sheet);
        cell.setColumnNumber(columnNumber);
        return cell;
    }

    /**
     * Sets the column number
     *
     * @param columnNumber the columnNumber to set
     */
    protected void setColumnNumber(int columnNumber) {
        int oldColumnNumber = this.columnNumber;
        this.columnNumber = columnNumber;
        propertyChangeSupport.firePropertyChange(PROP_COLUMN_NUMBER, oldColumnNumber, columnNumber);
    }

    /**
     * Gets the cells
     *
     * @return a List of cells
     * @see List
     * @see Cell
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Gets the cells
     *
     * @param cells a List of cells
     * @see List
     * @see Cell
     */
    public void setCells(List<Cell> cells) {
        List<Cell> oldCells = this.cells;
        this.cells = cells;
        propertyChangeSupport.firePropertyChange(PROP_CELLS, oldCells, cells);
    }

    /**
     * Gets the style of this column
     *
     * @return the style
     */
    public ICellStyle getStyle() {
        return style;
    }

    /**
     * Sets the style of this column
     *
     * @param style the style to set
     */
    public void setStyle(ICellStyle style) {
        com.github.lespaul361.commons.simplespreadsheet.ICellStyle oldStyle = this.style;
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
        hash = 79 * hash + this.columnNumber;
        hash = 79 * hash + Objects.hashCode(this.cells);
        hash = 79 * hash + Objects.hashCode(this.style);
        hash = 79 * hash + Objects.hashCode(this.sheet);
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
        final Column other = (Column) obj;
        return other.hashCode() == obj.hashCode();
    }

}
