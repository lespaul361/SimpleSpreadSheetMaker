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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author David Hamilton
 */
public class Sheet implements Serializable {

    private static final long serialVersionUID = -5275594507204949593L;
    public static final String PROP_STYLE = "PROP_STYLE";
    public static final String PROP_SHEETNAME = "PROP_SHEETNAME";
    public static final String PROP_SHEETNUMBER = "PROP_SHEETNUMBER";
    private String sheetName = "";
    private int sheetNumber = 0;
    List<Row> rows = new ArrayList<>();
    private Style style = new SheetStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    Sheet(int sheetNumber) {
        this.sheetNumber = sheetNumber;
        this.sheetName = "Sheet " + this.sheetNumber;
    }

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
     * Removes a row by object
     *
     * @param row the row to remove
     * @return boolean saying if it is successful
     */
    public boolean removeRow(Row row) {
        try {
            return removeRow(row.getRowNumber());
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }

    }

    /**
     * Removes a row at an index
     *
     * @param rowNumber the index of the row
     * @return boolean saying if it is successful
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the row array range
     */
    public boolean removeRow(int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Greater Than " + (rows.size() - 1));
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
        return true;
    }

    /**
     * Removes a column by object
     *
     * @param column the <code>Column</code> to remove
     * @return boolean saying if it is successful
     */
    public boolean removeColumn(Column column) {
        int index = column.getColumnNumber();
        try {
            removeColumn(index);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Removes a column by column number
     *
     * @param columnNumber the column number to remove
     * @return boolean saying if it is successful
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the column array range
     */
    private boolean removeColumn(int columnNumber) throws ArrayIndexOutOfBoundsException {
        if (columnNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");
        }
        boolean isLongEnough = false;
        for (Row row : rows) {
            if (row.getCells().size() >= columnNumber) {
                isLongEnough = true;
                break;
            }
        }
        if (!isLongEnough) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Outside The Range");
        }

        Iterator<Row> iterator = rows.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            List<Cell> updatedList = new ArrayList<>();
            List<Cell> currentList = row.getCells();
            for (int i = 0; i < currentList.size(); i++) {
                if (i != columnNumber) {
                    updatedList.add(currentList.get(i));
                }
            }
            row.setCells(currentList);

        }
        return true;
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
            Row r = Row.getInstance(this);
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

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * @param sheetName the sheetName to set
     */
    public void setSheetName(String sheetName) {
        java.lang.String oldSheetName = this.sheetName;
        this.sheetName = sheetName;
        propertyChangeSupport.firePropertyChange(PROP_SHEETNAME, oldSheetName, sheetName);
    }

    /**
     * @return the sheetNumber
     */
    public int getSheetNumber() {
        return sheetNumber;
    }

    /**
     * @param sheetNumber the sheetNumber to set
     */
    protected void setSheetNumber(int sheetNumber) {
        int oldSheetNumber = this.sheetNumber;
        this.sheetNumber = sheetNumber;
        propertyChangeSupport.firePropertyChange(PROP_SHEETNUMBER, oldSheetNumber, sheetNumber);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.sheetName);
        hash = 83 * hash + this.sheetNumber;
        hash = 83 * hash + Objects.hashCode(this.rows);
        hash = 83 * hash + Objects.hashCode(this.style);
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
        final Sheet other = (Sheet) obj;
        return (other.hashCode() == this.hashCode());
    }

}
