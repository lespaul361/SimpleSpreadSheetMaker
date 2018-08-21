/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import com.github.lespaul361.commons.simplespreadsheet.exceptions.LocationExistsException;
import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author David Hamilton
 */
public class Sheet implements Serializable {

    private static final long serialVersionUID = -5275594507204949593L;
    public static final String PROP_STYLE = "PROP_STYLE";
    public static final String PROP_SHEET_NAME = "PROP_SHEET_NAME";
    public static final String PROP_SHEET_NUMBER = "PROP_SHEET_NUMBER";
    public static final String PROP_SHEET_ROW = "PROP_SHEET_ROW";
    public static final String PROP_SHEET_COLUMN = "PROP_SHEET_COLUMN";
    private String sheetName = "";
    private int sheetNumber = 0;
    //row is x and column is y
    private Map<Point, Cell> cellMap = new HashMap<>();
    private Style style = new SheetStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private int rowCount = 0;
    private int columnCount = 0;
    private boolean isIgnorePropertyChange=false;

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
        try {
            addRow(row, rowCount);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Adds a row to the specified index.If cells are already in use in the row
     * then a {@link LocationExistsException} will be thrown
     *
     * @param row the Row to add
     * @param rowNumber the index of the row
     * @throws ArrayIndexOutOfBoundsException thrown when <code>rownumber</code>
     * is less than 0
     * @throws LocationExistsException
     * @throw ArrayIndexOutOfBoundsException
     * @see Row
     */
    public void addRow(Row row, int rowNumber)
            throws ArrayIndexOutOfBoundsException, LocationExistsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }

        if (rowNumber < rowCount) {
            int c = rowInUse(rowNumber);
            if (c < 0) {
                throw new LocationExistsException(new Point(rowNumber, c));
            }
        }

        Map<Point, Cell> ret = new HashMap<>();
        row.getCells().forEach((cell) -> {
            Point loc = new Point(cell.getRow(), cell.getRow());
            ret.put(loc, cell);
        });
        this.cellMap = ret;
        checkCounts();
        firePropertyChange(PROP_SHEET_ROW, null, row);
    }

    /**
     * Removes a row by object
     *
     * @param row the row to remove
     * @return boolean saying if it is successful
     * @see Row
     */
    public boolean removeRow(Row row) {
        return removeRow(row.getRowNumber());
    }

    /**
     * Removes a row at an index
     *
     * @param rowNumber the index of the row
     * @return boolean saying if it is successful
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the row array range
     * @see Row
     */
    public boolean removeRow(int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (rowNumber < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Greater Than " + (this.rowCount - 1));
        }
        Map<Point, Cell> ret = new HashMap<>();
        Iterator<Point> iterator = this.cellMap.keySet().iterator();
        Point curPoint = null;
        while (iterator.hasNext()) {
            curPoint = iterator.next();
            if (curPoint.x < rowNumber) {
                ret.put(curPoint, this.cellMap.get(curPoint));
                continue;
            }
            if (curPoint.x == rowNumber) {
                continue;
            }
            Point newPoint=new Point(curPoint.x - 1, curPoint.y);
            Cell cell=this.cellMap.get(curPoint);
            cell.setRow(newPoint.x);
            ret.put(newPoint,cell);
        }
        this.cellMap = ret;
        checkCounts();
        return true;
    }

    /**
     * Inserts a {@link Row} at the provided row number and shifts the cells at
     * that number and higher up one
     *
     * @param row the row to insert
     * @param rowNumber the row number to insert the {@link Row} at. Zero based
     * @see Row
     *
     */
    public void insertRow(Row row, int rowNumber) {

    }

    /**
     * Gets the row at the specified index
     *
     * @param rowNumber the row index
     * @return the Row
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the row array range
     */
    public Row
            getRow(int rowNumber
            ) throws ArrayIndexOutOfBoundsException {
        return null;

    }

    public void addColumn(Column column
    ) {

    }

    public void addColumn(Column column,
             int columnNumber
    ) {

    }

    /**
     * Removes a column by object
     *
     * @param column the <code>Column</code> to remove
     * @return boolean saying if it is successful
     * @see Column
     */
    public boolean removeColumn(Column column
    ) {
        return removeColumn(column
                .getColumnNumber());

    }

    /**
     * Removes a column by column number
     *
     * @param columnNumber the column number to remove
     * @return boolean saying if it is successful
     * @throws ArrayIndexOutOfBoundsException thrown when the index is outside
     * of the column array range
     * @see Column
     */
    public boolean removeColumn(int columnNumber
    ) throws ArrayIndexOutOfBoundsException {
        return true;

    }

    public Column
            getColumn(int index
            ) throws ArrayIndexOutOfBoundsException {
        if (index
                < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");

        }
        return null;

    }

    /**
     * Gets the BasicCell at the specified location
     *
     * @param rowNumber the row number for the cell
     * @param columnNumber the column number for the cell
     * @return the cell at the desired location
     * @throws ArrayIndexOutOfBoundsException thrown when the indexes are out of
     * range
     */
    public Cell
            getCell(int rowNumber,
                     int columnNumber
            ) throws ArrayIndexOutOfBoundsException {
        if (rowNumber
                < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");

        }
        return null;

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
    public void setCell(int rowNumber,
             int columnNumber,
             Cell cell
    ) throws ArrayIndexOutOfBoundsException {
        if (rowNumber
                < 0) {
            throw new ArrayIndexOutOfBoundsException("Row Number Is Less Than 0");

        }
        if (columnNumber
                < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");

        }

    }

    /**
     * @return the style
     */
    public Style
            getStyle() {
        return style;

    }

    /**
     * @param style the style to set
     */
    public void setStyle(Style style
    ) {
        com.github.lespaul361.commons.simplespreadsheet.Style oldStyle
                = this.style;

        this.style
                = style;

        propertyChangeSupport
                .firePropertyChange(PROP_STYLE,
                         oldStyle,
                         style
                );

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
    public void addNotificationListener(PropertyChangeListener listener
    ) {
        propertyChangeSupport
                .addPropertyChangeListener(listener
                );

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
    public void addNotificationListener(String propertyName,
             PropertyChangeListener listener
    ) {
        propertyChangeSupport
                .addPropertyChangeListener(propertyName,
                         listener
                );

    }

    /**
     * @return the sheetName
     */
    public String
            getSheetName() {
        return sheetName;

    }

    /**
     * @param sheetName the sheetName to set
     */
    public void setSheetName(String sheetName
    ) {
        java.lang.String oldSheetName
                = this.sheetName;

        this.sheetName
                = sheetName;

        propertyChangeSupport
                .firePropertyChange(PROP_SHEET_NAME,
                         oldSheetName,
                         sheetName
                );

    }

    /**
     * @return the sheetNumber
     */
    public int getSheetNumber() {
        return sheetNumber;

    }

    /**
     * Gets the number of rows in this sheet
     *
     * @return <code>int</code> with the number of rows
     * @see Row
     */
    public int getRowCount() {
        return rowCount;

    }

    /**
     * Creates a new {@link Row} in the sheet with the row number being -1. The
     * row is not added to the sheet until
     * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row)} or
     * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row, int)}
     * is used.
     *
     * @return a Row
     * @see Row
     * @see Sheet
     */
    public Row
            createRowInstance() {
        return createRowInstance(-1);

    }

    /**
     * Creates a new {@link Row} in the sheet with the supplied row number. The
     * row is not added to the sheet until
     * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row)} or
     * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row, int)}
     * is used.
     *
     * @param rowNumber
     * @return a Row
     * @see Row
     * @see Sheet
     */
    public Row
            createRowInstance(int rowNumber
            ) throws ArrayIndexOutOfBoundsException {
        return null;

    }

    private boolean isCellInUse(Point location,
             Cell cell
    ) {
        return (cell
                .getRow() == location
                        .getX() && cell
                        .getColumn() == location
                        .getY());

    }

    private int rowInUse(int index
    ) {
        return -1;

    }

    private void checkCounts() {

    }

    /**
     * @param sheetNumber the sheetNumber to set
     */
    protected void setSheetNumber(int sheetNumber
    ) {
        int oldSheetNumber
                = this.sheetNumber;

        this.sheetNumber
                = sheetNumber;

        propertyChangeSupport
                .firePropertyChange(PROP_SHEET_NUMBER,
                         oldSheetNumber,
                         sheetNumber
                );

    }

    /**
     * Fires the listeners for property changes
     *
     * @param property the name of the property
     * @param oldValue the old value
     * @param newValue the new value
     */
    protected void firePropertyChange(String property,
             Object oldValue,
             Object newValue
    ) {
        this.propertyChangeSupport
                .firePropertyChange(property,
                         oldValue,
                         newValue
                );

    }

    @Override
    public boolean equals(Object obj
    ) {
        if (obj
                == null) {
            return false;

        }
        if (getClass() != obj
                .getClass()) {
            return false;

        }
        final Sheet other
                = (Sheet) obj;

        return (other
                .hashCode() == this.hashCode());
    }
}
