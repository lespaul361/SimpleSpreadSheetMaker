/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import com.github.lespaul361.commons.simplespreadsheet.exceptions.LocationExistsException;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.event.EventListenerList;

/**
 *
 * @author David Hamilton
 */
public class Sheet implements Serializable {

    private static final long serialVersionUID = -5275594507204949593L;
    public static transient final String PROP_STYLE = "PROP_STYLE";
    public static transient final String PROP_SHEET_NAME = "PROP_SHEET_NAME";
    public static transient final String PROP_SHEET_NUMBER = "PROP_SHEET_NUMBER";
    public static transient final String PROP_SHEET_ROW = "PROP_SHEET_ROW";
    public static transient final String PROP_SHEET_COLUMN = "PROP_SHEET_COLUMN";
    public static transient final String PROP_CELL_LOCATION = "PROP_CELL_LOCATION";
    private String sheetName = "";
    private int sheetNumber = 0;
    //row is x and column is y
    private Map<Point, Cell> cellMap = new HashMap<>();
    private Map<Integer, Style> rowStyleMap = new HashMap<>();
    private Style style = new SheetStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private int rowCount = 0;
    private int columnCount = 0;
    private boolean isIgnorePropertyChange = false;
    EventListenerList eventList = new EventListenerList();
    PropertyChangeListener propertyChangeListener = (PropertyChangeEvent evt) -> {
        if (!isIgnorePropertyChange) {
            cellPropertyChanged(evt);
        }
    };

    Sheet(int sheetNumber) {
        this.sheetNumber = sheetNumber;
        this.sheetName = "Sheet " + this.sheetNumber;
    }

    /**
     * Adds a {@link Row} to the end of the sheet
     *
     * @param row {@link Row} the row to add
     * @return true if row is added
     * @see Row
     */
    public boolean addRow(Row row) {
        List<Cell> cells=row.getCells();
        int rowNum=row.getRowNumber();
        for(int c=0;c<cells.size();c++){
            Cell cell=cells.get(c);
            if(cell!=null){
                cell.setColumnNumber(c);
                cell.setRowNumber(rowNum);
                cell.addNotificationListener(propertyChangeListener);
            }
            this.cellMap.put(new Point(rowNum, c), cell);
        }
        firePropertyChange(PROP_SHEET_ROW, null, row);
        return true;
    }

    /**
     * Clears a row by object
     *
     * @param row the row to remove
     * @return boolean saying if it is successful
     * @see Row
     */
    public boolean clearRow(Row row) {
        if (row == null) {
            Exception e = new NullPointerException("row is null");
            e.printStackTrace(System.out);
            return false;
        }
        return clearRow(row.getRowNumber());
    }

    /**
     * Clears a row at an index
     *
     * @param rowNumber the index of the row
     * @return boolean saying if it is successful
     * @see Row
     */
    public boolean clearRow(int rowNumber) {
        if (rowNumber < 0 || rowNumber < 0) {
            Exception e = new ArrayIndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Lest Than 0");
            return false;
        } else if (rowNumber > getRowCount()) {
            Exception e = new ArrayIndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Greater Than The Number Of Rows " + getRowCount());
            return false;
        }
        isIgnorePropertyChange = true;
        Row retRow = new Row();
        List<Cell> removedCells = new ArrayList<>();
        Map<Point, Cell> ret = new HashMap<>();
        Iterator<Point> iterator = this.cellMap.keySet().iterator();
        Point curPoint = null;
        while (iterator.hasNext()) {
            curPoint = iterator.next();
            if (curPoint.x == rowNumber) {
                removedCells.add(this.cellMap.get(curPoint));
                continue;
            }
            ret.put(curPoint, this.cellMap.get(curPoint));
        }
        this.cellMap = ret;
        retRow.setCells(removedCells);
        firePropertyChange(PROP_SHEET_ROW, retRow, null);
        isIgnorePropertyChange = false;
        return true;
    }

    /**
     * Removes a {@link Row} object from the {@link Sheet} and shifts the
     * {@link Row}s after it up a {@link Row}
     *
     * @param row the {@link Row} to remove
     * @return true if the {@link Row} can be removed
     * @see Row
     * @see Sheet
     */
    public boolean removeRow(Row row) {
        if (row == null) {
            Exception e = new NullPointerException("row is null");
            e.printStackTrace(System.out);
            return false;
        }
        return removeRow(row.getCells().get(0).getRowNumber());
    }

    /**
     * Removes a {@link Row} from the {@link Sheet} by the {@link Row} index and
     * shifts the {@link Row}s after it up a {@link Row}
     *
     * @param row the {@link Row} to remove
     * @return true if the {@link Row} can be removed
     * @see Row
     * @see Sheet
     */
    public boolean removeRow(int rowNumber) {
        if (rowNumber < 0) {
            Exception e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Lest Than 0");
            e.printStackTrace(System.out);
            return false;
        } else if (rowNumber >= getRowCount()) {
            Exception e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Greater Than The Number Of Rows " + getRowCount());
            return false;
        }
        Row retRow = new Row();
        List<Cell> removedCells = new ArrayList<>();
        Map<Point, Cell> ret = new HashMap<>();
        Iterator<Point> iterator = this.cellMap.keySet().iterator();
        Point curPoint = null;
        isIgnorePropertyChange = true;
        while (iterator.hasNext()) {
            curPoint = iterator.next();
            if (curPoint.x < rowNumber) {
                ret.put(curPoint, this.cellMap.get(curPoint));
                continue;
            } else if (curPoint.x == rowNumber) {
                ret.put(curPoint, this.cellMap.get(ret));
                continue;
            }
            Cell cell = ((AbstractCell) this.cellMap.get(curPoint)).makeClone();
            removedCells.add(this.cellMap.get(curPoint));
            ret.put(curPoint, this.cellMap.get(curPoint));
        }
        this.cellMap = ret;
        retRow.setCells(removedCells);
        firePropertyChange(PROP_SHEET_ROW, retRow, null);
        isIgnorePropertyChange = false;
        return true;
    }

    /**
     * Inserts a {@link Row} at the provided row number and shifts the cells at
     * that number and higher up one
     *
     * @param row the row to insert
     * @param rowNumber the row number to insert the {@link Row} at. Zero based
     * @return true if successful
     * @see Row
     *
     */
    public boolean insertRow(Row row, int rowNumber) {
        return false;
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
        return null;

    }

    /**
     * Adds a {@link Column} to this sheet
     *
     * @param column the {@link Column} to add
     */
    public void addColumn(Column column) {

    }

    public void addColumn(Column column, int columnNumber) {

    }

    /**
     * Removes a column by object
     *
     * @param column the <code>Column</code> to remove
     * @return boolean saying if it is successful
     * @see Column
     */
    public boolean removeColumn(Column column) {
        return removeColumn(column.getColumnNumber());

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
    public boolean removeColumn(int columnNumber) throws ArrayIndexOutOfBoundsException {
        return true;

    }

    public Column getColumn(int index) throws ArrayIndexOutOfBoundsException {
        if (index
                < 0) {
            throw new ArrayIndexOutOfBoundsException("Column Number Is Less Than 0");

        }
        return null;

    }

    /**
     * Gets the {@link Cell} at the specified location
     *
     * @param rowNumber the row number for the cell
     * @param columnNumber the column number for the cell
     * @return the cell at the desired location
     * @throws ArrayIndexOutOfBoundsException thrown when the indexes are out of
     * range
     */
    public Cell getCell(int rowNumber, int columnNumber) throws ArrayIndexOutOfBoundsException {
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
    public void setCell(int rowNumber, int columnNumber, Cell cell) throws ArrayIndexOutOfBoundsException {
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
     * Creates a new {@link Cell} with the location set to -1,-1
     *
     * @return a new cell
     */
    public Cell getCellInstance() {
        return getCellInstance(-1, -1);
    }

    /**
     * Creates a new {@link Cell} set at the position requested
     *
     * @param x the row number. 0 based
     * @param y the column number. 0 based
     * @return a new cell
     */
    public Cell getCellInstance(int x, int y) {
        return getCellInstance(new Point(x, y));
    }

    /**
     * Creates a new {@link Cell} set at the position requested
     *
     * @param location the location of the cell. X is row and Y is column. Both
     * are 0 based.
     *
     * @return a new cell
     */
    public Cell getCellInstance(Point location) {
        Cell test = this.cellMap.get(location);
        if (test != null) {
            throw new LocationExistsException(location);
        }
        Cell cell = new BasicCell(this);
        return cell;
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
    public void addNotificationListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport
                .addPropertyChangeListener(propertyName,
                        listener
                );

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
    public Row createRowInstance() {
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
    public Row createRowInstance(int rowNumber) throws ArrayIndexOutOfBoundsException {
        return null;

    }

    private boolean isCellInUse(Point location, Cell cell) {
        return (cell
                .getRowNumber() == location
                        .getX() && cell
                        .getColumnNumber() == location
                        .getY());

    }

    private int rowInUse(int index) {
        return -1;

    }

    private void checkCounts() {

    }

    /**
     * @param sheetNumber the sheetNumber to set
     */
    protected void setSheetNumber(int sheetNumber) {
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
    protected void firePropertyChange(String property, Object oldValue, Object newValue) {
        this.propertyChangeSupport.firePropertyChange(property, oldValue, newValue);
    }

    private void cellPropertyChanged(PropertyChangeEvent ev) {

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.sheetName);
        hash = 83 * hash + this.sheetNumber;
        hash = 83 * hash + Objects.hashCode(this.cellMap);
        hash = 83 * hash + Objects.hashCode(this.style);
        hash = 83 * hash + Objects.hashCode(this.propertyChangeSupport);
        hash = 83 * hash + this.rowCount;
        hash = 83 * hash + this.columnCount;
        hash = 83 * hash + (this.isIgnorePropertyChange ? 1 : 0);
        return hash;
    }

}
