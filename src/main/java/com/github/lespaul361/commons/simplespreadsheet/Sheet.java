/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author David Hamilton
 */
public class Sheet {

    public static final String PROP_STYLE = "PROP_STYLE";

    List<Row> rows = new ArrayList<>();
    private Style style = new Style();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * Adds a row to the end of the sheet
     *
     * @param row the Row to add
     * @see Row
     */
    public void addRow(Row row) {
        rows.add(row);
        row.setRowNumber(rows.size() - 1);
    }

    /**
     * Adds a row to the specified index. If it is before the end then the other
     * rows get shifted up
     *
     * @param row the Row to add
     * @param rowNumber the index of the row
     * @throws ArrayIndexOutOfBoundsException thrown when <code>rownumber</code>
     * is less than 0
     * @see Row
     */
    public void addRow(Row row, int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (rowNumber == rows.size()) {
            addRow(row);
            return;
        }
        for (int i = rows.size(); i < rowNumber; i++) {
            rows.add(null);
        }
        addRow(row);
    }

    /**
     * Removes a row by object reference
     *
     * @param row the row object to remove
     */
    public boolean removeRow(Row row) {
        Iterator<Row> iterator = rows.iterator();
        int counter = 0;
        boolean found = false;
        while (iterator.hasNext()) {
            Row r = iterator.next();
            if (r == row) {
                iterator.remove();
                found = true;
            }
            if (found) {
                row.setRowNumber(row.getRowNumber() - 1);
            }
        }
        return found;
    }

    /**
     * Removes a row at an index
     *
     * @param rowNumber the index of the row
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the row array range
     */
    public void removeRow(int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        Iterator<Row> iterator = rows.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNumber() < rowNumber) {
                continue;
            }
            if (row.getRowNumber() == rowNumber) {
                iterator.remove();
            }
            row.setRowNumber(row.getRowNumber() - 1);
        }
    }

    /**
     * Gets the row at the specified index
     *
     * @param rowNumber the row index
     * @return the Row
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the row array range
     */
    public Row getRow(int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (rowNumber > rows.size()) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Greater Than "
                    + "Row Count");
        }
        return rows.get(rowNumber);
    }

    /**
     * Gets the Cell at the specified location
     *
     * @param rowNumber the row number for the cell
     * @param columnNumber the column number for the cell
     * @return the cell at the desired location
     * @throws ArrayIndexOutOfBoundsException thrown when the indexes are out of
     * range
     */
    public Cell getCell(int rowNumber, int columnNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (rowNumber >= rows.size()) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Greater Than "
                    + "The Row Array");
        }
        Row row = rows.get(rowNumber);
        if (columnNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");
        }
        if (row.getCells().size() < columnNumber) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Larger Than "
                    + "The Column Count");
        }
        return row.getCells().get(columnNumber);
    }

    /**
     * Inserts the cell at the specified position. Rows and Columns will expand
     * if needed
     *
     * @param rowNumber the row number
     * @param columnNumber the column number
     * @param cell the cell to place
     * @throws ArrayIndexOutOfBoundsException thrown with rowNumber or
     * columnNumber are less than 0
     */
    public void setCell(int rowNumber, int columnNumber, Cell cell) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (columnNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");
        }
        if (rowNumber > rows.size()) {
            for (int i = rows.size(); i < rowNumber; i++) {
                rows.add(null);
            }
            Row r = new Row();
            for (int colNum = 0; colNum < columnNumber; colNum++) {
                r.getCells().add(null);
            }
            r.getCells().add(cell);
            return;
        }
        Row r = rows.get(rowNumber);
        r.getCells().set(columnNumber, cell);
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
