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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.swing.event.EventListenerList;

/**
 *
 * @author David Hamilton
 */
public class Sheet implements Serializable {

    private static final long serialVersionUID = -5275594507204949593L;
    /**
     * Notification for sheet style change
     */
    public static transient final String PROP_STYLE = "PROP_STYLE";
    /**
     * Notification for sheet name change
     */
    public static transient final String PROP_SHEET_NAME = "PROP_SHEET_NAME";
    /**
     * Notification for sheet number change
     */
    public static transient final String PROP_SHEET_NUMBER = "PROP_SHEET_NUMBER";
    /**
     * Notification for row added
     */
    public static transient final String PROP_SHEET_ROW_ADDED = "PROP_SHEET_ROW_ADDED";
    /**
     * Notification for row removed
     */
    public static transient final String PROP_SHEET_ROW_REMOVED = "PROP_SHEET_ROW_REMOVED";
    /**
     * Notification for row moved
     */
    public static transient final String PROP_SHEET_ROW_MOVED = "PROP_SHEET_ROW_MOVED";
    /**
     * Notification for row cleared
     */
    public static transient final String PROP_SHEET_ROW_CLEARED = "PROP_SHEET_ROW_CLEARED";
    /**
     * Notification for column added
     */
    public static transient final String PROP_SHEET_COLUMN_ADDED = "PROP_SHEET_COLUMN_ADDED";
    /**
     * Notification for column added
     */
    public static transient final String PROP_SHEET_COLUMN_REMOVED = "PROP_SHEET_COLUMN_REMOVED";
    /**
     * Notification for column added
     */
    public static transient final String PROP_SHEET_COLUMN_MOVED = "PROP_SHEET_COLUMN_MOVED";
    /**
     * Notification for cell location changed. Not fired on column or row insert
     * or addition
     */
    public static transient final String PROP_CELL_LOCATION = "PROP_CELL_LOCATION";

    private String sheetName = "";
    private int sheetNumber = 0;
    //row is x and column is y
    private Map<Point, Cell> cellMap = new HashMap<>();
    private Map<Integer, Style> rowStyleMap = new HashMap<>();
    private Map<Integer, Style> columnStyleMap = new HashMap<>();
    private Style style = new SheetStyle();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private int rowCount = 0;
    private int columnCount = 0;
    private boolean isIgnorePropertyChange = false;
    EventListenerList eventList = new EventListenerList();
    PropertyChangeListener cellPropertyChangeListener = (PropertyChangeEvent evt) -> {
        if (!isIgnorePropertyChange) {
            cellPropertyChanged(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
        }
    };
    PropertyChangeListener rowPropertyChangeListener = (PropertyChangeEvent evt) -> {
        if (!isIgnorePropertyChange) {
            rowPropertyChanged(evt.getPropertyName(), (Row) evt.getOldValue(), (Row) evt.getNewValue());
        }
    };

    Sheet(int sheetNumber) {
        this.sheetNumber = sheetNumber;
        this.sheetName = "Sheet " + this.sheetNumber;
    }

    /**
     * Adds a {@link Row} to the end of the sheet. Cell row number will be
     * changed and column number will be the order in the list. Nulls are
     * allowed in the list
     *
     * @param row {@link Row} the row to add
     * @return true if row is added
     * @see Row
     * @see List
     */
    public boolean addRow(Row row) {
        List<Cell> cells = row.getCells();
        int rowNum = row.getRowNumber();
        for (int c = 0; c < cells.size(); c++) {
            Cell cell = cells.get(c);
            if (cell != null) {
                cell.setColumnNumber(c);
                cell.setRowNumber(rowNum);
                cell.addNotificationListener(cellPropertyChangeListener);
            }
            this.cellMap.put(new Point(rowNum, c), cell);
        }
        rowStyleMap.put(rowNum, row.getStyle());
        firePropertyChange(PROP_SHEET_ROW_ADDED, null, row);
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
            RuntimeException e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Lest Than 0");
            e.printStackTrace(System.err);
            throw e;
        } else if (rowNumber > getRowCount()) {
            RuntimeException e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Greater Than The Number Of Rows " + getRowCount());
            e.printStackTrace(System.err);
            throw e;
        }
        isIgnorePropertyChange = true;
        Row retRow = this.createRowInstance();
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
        checkCounts();
        retRow.setCells(removedCells);
        firePropertyChange(PROP_SHEET_ROW_CLEARED, retRow, null);
        isIgnorePropertyChange = false;
        return true;
    }

    /**
     * Removes a row object from the sheet and shifts the {@link Row}s after it
     * up a {@link Row}
     *
     * @param row the {@link Row} to remove
     * @return true if the row can be removed
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
     * @param rowNumber the number of the row to remove
     * @return true if the row can be removed
     * @see Row
     * @see Sheet
     */
    public boolean removeRow(int rowNumber) {
        //TODO: rewrite to grab rows and change the ones past rowNumber to lower 
        //number then fire notification
        if (rowNumber < 0) {
            RuntimeException e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Lest Than 0");
            e.printStackTrace(System.out);
            throw e;
        } else if (rowNumber >= getRowCount()) {
            RuntimeException e = new IndexOutOfBoundsException("Row NumberCan Not "
                    + "Be Greater Than The Number Of Rows " + getRowCount());
            e.printStackTrace(System.out);
            throw e;
        }
        Row retRow = this.createRowInstance();
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
                continue;
            }
            Cell cell = null;
            try {
                if (this.cellMap.get(curPoint) instanceof Cloneable) {
                    Method m = cell.getClass().getDeclaredMethod("clone");
                    m.setAccessible(true);
                    cell = ((Cell) m.invoke(cell));
                }
            } catch (Exception e) {
            }
            removedCells.add(this.cellMap.get(curPoint));
            Point newPoint = new Point(curPoint.x, curPoint.y - 1);
            ret.put(curPoint, this.cellMap.get(curPoint));
        }
        this.cellMap = ret;
        retRow.setCells(removedCells);
        firePropertyChange(PROP_SHEET_ROW_ADDED, retRow, null);
        isIgnorePropertyChange = false;
        return true;
    }

    /**
     * Inserts a {@link Row} at the provided row number. If the insert is before
     * the end of the current rows then the cells in the current row are shifted
     * to that number and higher up one row.
     *
     * @param row the row to insert
     * @param rowNumber the row number to insert the {@link Row} at. Zero based
     * @return true if successful
     * @see Row
     *
     */
    public boolean insertRow(Row row, int rowNumber) {
        Map<Point, Cell> tmpHashMap = new HashMap<>();
        Map<Integer, Style> newRowStyles = new HashMap<>();

        if (rowNumber < 0) {
            RuntimeException e = new IndexOutOfBoundsException("Row Number Can Not "
                    + "Be Less Than 0");
            e.printStackTrace(System.out);
            throw e;
        } else if (rowNumber == rowCount) {
            return addRow(row);
        }

        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            rows.add(getRow(i));
        }

        for (int i = 0; i < rowNumber; i++) {
            rows.get(i).getCells().forEach((cell) -> {
                if (cell != null) {
                    tmpHashMap.put(
                            new Point(cell.getRowNumber(),
                                    cell.getColumnNumber()), cell);
                }
            });
            newRowStyles.put(i, rows.get(i).getStyle());

        }

        row.getCells().forEach((cell) -> {
            tmpHashMap.put(
                    new Point(cell.getRowNumber(),
                            cell.getColumnNumber()), cell);
        });
        newRowStyles.put(rowNumber, row.getStyle());
        firePropertyChange(PROP_SHEET_ROW_ADDED, null, row);

        for (int i = rowNumber + 1; i < rows.size(); i++) {
            rows.get(i).getCells().forEach((cell) -> {
                if (cell != null) {
                    final Point oldPoint = new Point(cell.getRowNumber(), cell.getColumnNumber());
                    tmpHashMap.put(
                            new Point(cell.getRowNumber(),
                                    cell.getColumnNumber()), cell);
                    final Point newPoint = new Point(cell.getRowNumber(), cell.getColumnNumber());
                    firePropertyChange(PROP_CELL_LOCATION, oldPoint, newPoint);
                }
            });
            newRowStyles.put(i, rows.get(i).getStyle());
            firePropertyChange(PROP_SHEET_ROW_MOVED, i, i + 1);
        }

        rowStyleMap = newRowStyles;
        this.cellMap = tmpHashMap;
        checkCounts();
        return true;
    }

    /**
     * Gets the row at the specified index
     *
     * @param rowNumber the row index
     * @return the Row
     * @see Row
     *
     */
    public Row getRow(int rowNumber) {
        if (rowNumber < 0 || rowNumber >= rowCount) {
            RuntimeException e = new ArrayIndexOutOfBoundsException(rowNumber + " is out of bounds");
            e.printStackTrace(System.out);
            throw e;
        }
        Iterator<Point> iterator = this.cellMap.keySet().iterator();
        List<Cell> cells = new ArrayList<>();
        Point curPoint = null;
        while (iterator.hasNext()) {
            curPoint = iterator.next();
            if (curPoint.x == rowNumber) {
                cells.add(this.cellMap.get(curPoint));
            }
        }

        cells.sort((Cell c1, Cell c2) -> {
            return Integer.compare(c1.getColumnNumber(), c2.getColumnNumber());
        });

        Row row = createRowInstance();
        row.setCells(cells);
        row.addNotificationListener(this.rowPropertyChangeListener);
        return row;
    }

    /**
     * Adds a {@link Column} to this sheet after the other columns. Cell colum
     * numbers are set and the row numbers are set by their placement in the
     * list. Null entries are allowed
     *
     * @param column the {@link Column} to add
     * @see Column
     * @see List
     */
    public void addColumn(Column column) {

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
        if (index < 0) {
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
     *
     */
    public Cell getCell(int rowNumber, int columnNumber) {
        if (rowNumber < 0) {
            throw new IndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (columnNumber < 0) {
            throw new IndexOutOfBoundsException("Column Number Is Less Than 0");
        }
        if (rowNumber > this.rowCount) {
            throw new IndexOutOfBoundsException("Row Number Is Outside Range");
        }
        if (columnNumber > this.columnCount) {
            throw new IndexOutOfBoundsException("Column Number Is Outside Range");
        }

        Cell cell = cellMap.get(new Point(rowNumber, columnNumber));
        return cell;

    }

    /**
     * Inserts the cell at the specified position.
     *
     * @param rowNumber the row number
     * @param columnNumber the column number
     * @param cell the cell to place
     * @throws LocationExistsException is thrown if a cell is already in that
     * position
     */
    public void setCell(int rowNumber, int columnNumber, Cell cell) throws LocationExistsException {
        try {
            setCell(rowNumber, columnNumber, cell, false);
        } catch (LocationExistsException e) {
            throw e;
        }
    }

    /**
     * Inserts the cell at the specified position.
     *
     * @param rowNumber the row number
     * @param columnNumber the column number
     * @param cell the cell to place
     * @param isOverWrite if true it will over write the existing cell
     * @throws LocationExistsException is thrown if a cell is already in that
     * position and <code>isOverWrite</code> is false
     */
    public void setCell(int rowNumber, int columnNumber, Cell cell, boolean isOverWrite) throws LocationExistsException {
        if (rowNumber < 0) {
            throw new IndexOutOfBoundsException("Row Number Is Less Than 0");
        }
        if (columnNumber < 0) {
            throw new IndexOutOfBoundsException("Column Number Is Less Than 0");
        }
        if (!isOverWrite) {
            if (isCellInUse(new Point(rowNumber, columnNumber), cell)) {
                Exception e = new LocationExistsException(new Point(rowNumber, columnNumber));
                e.printStackTrace(System.err);
                throw (LocationExistsException) e;
            }
        }

        this.cellMap.put(new Point(rowNumber, columnNumber), cell);
        checkCounts();
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
        cell.addNotificationListener(cellPropertyChangeListener);
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
        propertyChangeSupport.firePropertyChange(PROP_SHEET_NAME, oldSheetName, sheetName);
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
     * Gets the number of columns in this sheet
     *
     * @return <code>int</code> with the number of rows
     * @see Column
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * Creates a new row in the sheet with the row number being -1. The row is
     * not added to the sheet until
     * {@link com.github.lespaul361.commons.simplespreadsheet.Sheet#addRow(com.github.lespaul361.commons.simplespreadsheet.Row)}
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
     * Creates a new column instance set at -1
     *
     * @return a new column
     * @see Column
     */
    public Column createColumnInstance() {
        return createColumnInstance(-1);
    }

    /**
     * Creates a new column instance set at the provided column number
     *
     * @param columnNumber the number of the column
     * @return a new column
     * @see Column
     */
    public Column createColumnInstance(int columnNumber) {
        Column c = Column.getInstance(this);
        c.setColumnNumber(columnNumber);
        return c;
    }

    /**
     * Creates a new {@link Row} in the sheet with the supplied row number. The
     * row is not added to the sheet until
     * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row)} is
     * used.
     *
     * @param rowNumber the index of the row
     * @return a Row
     * @see Row
     * @see Sheet
     */
    public Row createRowInstance(int rowNumber) throws ArrayIndexOutOfBoundsException {
        Row r = Row.getInstance(this);
        r.setRowNumber(rowNumber);
        return r;
    }

    private boolean isCellInUse(Point location, Cell cell) {
        return (cell.getRowNumber() == location.getX()
                && cell.getColumnNumber() == location.getY());

    }

    private void checkCounts() {
        int row = 0, col = 0;
        Set<Point> points = this.cellMap.keySet();
        for (Point point : points) {
            row = row > point.x ? row : point.x;
            col = col > point.y ? col : point.y;
        }
        this.columnCount = col + 1;
        this.rowCount = row + 1;
    }

    /**
     * @param sheetNumber the sheetNumber to set
     */
    protected void setSheetNumber(int sheetNumber) {
        int oldSheetNumber = this.sheetNumber;
        this.sheetNumber = sheetNumber;

        propertyChangeSupport.firePropertyChange(PROP_SHEET_NUMBER, oldSheetNumber, sheetNumber);

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

    protected void cellPropertyChanged(String property, Object oldValue, Object newValue) {
        this.propertyChangeSupport.firePropertyChange(property, oldValue, newValue);
    }

    protected void rowPropertyChanged(String property, Row oldValue, Row newValue) {
        firePropertyChange(property, oldValue, newValue);
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
