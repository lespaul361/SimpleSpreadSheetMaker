/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains information about a row of cells
 *
 * @author David Hamilton
 */
public class Row implements Serializable, Cloneable {

    /**
     * The property name for the change event when a row number changes
     */
    public static final String PROP_ROW_NUMBER = "PROP_ROW_NUMBER";
    /**
     * The property name for the change event when a cell is added or removed
     */
    public static final String PROP_CELLS = "PROP_CELLS";
    /**
     * The property name for the change event when the style of this row is
     * changed
     */
    public static final String PROP_STYLE = "PROP_STYLE";
    private int rowNumber = -1;
    private List<Cell> cells = new ArrayList<>();
    private Style style = new RowStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private Sheet sheet;
    private static final long serialVersionUID = -5275594549593L;

    /**
     * Sets the sheet this row is a part of
     *
     * @param sheet the parent sheet
     * @see Sheet
     */
    protected void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    private Row(Sheet sheet) {
        this.sheet = sheet;
        addNotificationListener(sheet.rowPropertyChangeListener);
    }

    /**
     * Gets the row number for this row
     *
     * @return the rowNumber
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * Sets the row number for this row
     *
     * @param rowNumber the rowNumber to set
     */
    protected void setRowNumber(int rowNumber) {
        int oldRowNumber = this.rowNumber;
        this.rowNumber = rowNumber;
        propertyChangeSupport.firePropertyChange(PROP_ROW_NUMBER, oldRowNumber, rowNumber);
    }

    protected static Row getInstance(Sheet sheet) {
        return new Row(sheet);
    }

    public Cell getCellInstance() {
        Cell cell = new BasicCell(sheet);
        cell.setRowNumber(rowNumber);
        return cell;
    }

    /**
     * Gets the list of cells in the row. The order of the cells in the list is
     * the same as the column number, nulls are allowed
     *
     * @return the cells
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Sets the cells in the row. The order of the cells in the list is the same
     * as the column number, nulls are allowed
     *
     * @param cells the cells to set
     */
    public void setCells(List<Cell> cells) {
        try {
            List<Cell> oldCells = new ArrayList<>();
            for (Cell cell : cells) {
                oldCells.add((Cell) cell.clone());
            }
            this.cells = cells;
            propertyChangeSupport.firePropertyChange(PROP_CELLS, oldCells, cells);
        } catch (Exception e) {
        }

    }

    /**
     * Gets the style for this row
     *
     * @return the style
     */
    public Style getStyle() {
        return style;
    }

    /**
     * Sets the style for this row
     *
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
        if (listener == sheet.rowPropertyChangeListener) {
            return;
        }
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
        //hash = 83 * hash + Objects.hashCode(this.sheet);
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Row row = new Row(this.sheet);
        row.rowNumber = rowNumber;
        row.sheet = sheet;
        row.style = style;
        List<Cell> cells = new ArrayList<>();
        for (Cell cell : this.cells) {
            if (cell == null) {
                cells.add(null);
            } else if (cell instanceof Cloneable) {
                try {
                    Method m = cell.getClass().getDeclaredMethod("clone");
                    m.setAccessible(true);
                    cells.add((Cell) m.invoke(cell));
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }
        row.cells = cells;
        for (PropertyChangeListener l : this.propertyChangeSupport.getPropertyChangeListeners()) {
            row.propertyChangeSupport.addPropertyChangeListener(l);
        }
        return row;
    }

}
