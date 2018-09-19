/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import com.github.lespaul361.commons.simplespreadsheet.exceptions.LocationExistsException;
import com.itextpdf.text.pdf.qrcode.Version.ECB;
import com.thoughtworks.selenium.webdriven.commands.RemoveAllSelections;

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
import java.util.Set;
import javax.swing.event.EventListenerList;

import org.jopendocument.dom.template.statements.If;

/**
 *
 * @author David Hamilton
 */
public class Sheet implements Serializable, RowDelegateInterface {

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
	 * Notification for row set
	 */
	public static transient final String PROP_SHEET_ROW_SET = "PROP_SHEET_ROW_SET";
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
	 * Notification for column cleared
	 */
	public static transient final String PROP_SHEET_COLUMN_CLEARED = "PROP_SHEET_COLUMN_CLEARED";
	/**
	 * Notification for cell added
	 */
	public static transient final String PROP_CELL_ADDED = "PROP_CELL_ADDED";
	/**
	 * Notification for cell location changed. Not fired on column or row insert or
	 * addition
	 */
	public static transient final String PROP_CELL_LOCATION = "PROP_CELL_LOCATION";
	/**
	 * Notification for cell location changed. Not fired on column or row insert or
	 * addition
	 */
	public static transient final String PROP_CELL_REMOVED = "PROP_CELL_REMOVED";

	/**
	 * Notification for cell set. Not fired on column or row insert or addition
	 */
	public static transient final String PROP_CELL_SET = "PROP_CELL_SET";

	private String sheetName = "";
	private int sheetNumber = 0;
	// row is x and column is y
	private Map<Point, Cell> cellMap = new HashMap<>();
	private Map<Integer, Style> rowStyleMap = new HashMap<>();
	private Map<Integer, Style> columnStyleMap = new HashMap<>();
	private Style style = new SheetStyle();
	private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
	private int rowCount = 0;
	private int columnCount = 0;
	private boolean isIgnorePropertyChange = false;
	private RowDelegate rowDelegate = new RowDelegate(this, rowStyleMap, columnStyleMap);
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
	 * Gets the {@link Cell} at the specified location
	 *
	 * @param rowNumber
	 *            the row number for the cell
	 * @param columnNumber
	 *            the column number for the cell
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
	 * @param rowNumber
	 *            the row number
	 * @param columnNumber
	 *            the column number
	 * @param cell
	 *            the cell to place
	 * @throws LocationExistsException
	 *             is thrown if a cell is already in that * position
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
	 * @param rowNumber
	 *            the row number
	 * @param columnNumber
	 *            the column number
	 * @param cell
	 *            the cell to place
	 * @param isOverWrite
	 *            if true it will over write the existing cell
	 * @throws LocationExistsException
	 *             is thrown if a cell is already in that * position and
	 *             <code>isOverWrite</code> is false
	 */
	public void setCell(int rowNumber, int columnNumber, Cell cell, boolean isOverWrite)
			throws LocationExistsException {
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
	 * @param x
	 *            the row number. 0 based
	 * @param y
	 *            the column number. 0 based
	 * @return a new cell
	 */
	public Cell getCellInstance(int x, int y) {
		return getCellInstance(new Point(x, y));
	}

	/**
	 * Creates a new {@link Cell} set at the position requested
	 *
	 * @param location
	 *            the location of the cell. X is row and Y is column. Both are 0
	 *            based.
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
	 * @param style
	 *            the style to set
	 */
	public void setStyle(Style style) {
		com.github.lespaul361.commons.simplespreadsheet.Style oldStyle = this.style;

		this.style = style;

		propertyChangeSupport.firePropertyChange(PROP_STYLE, oldStyle, style);

	}

	/**
	 * Add a PropertyChangeListener for a specific property. The listener will be
	 * invoked only when a call on firePropertyChange names that specific property.
	 * The same listener object may be added more than once. For each property, the
	 * listener will be invoked the number of times it was added for that property.
	 * If propertyName or listener is null, no exception is thrown and no action is
	 * taken.
	 *
	 * @param listener
	 *            the PropertyChangeListener to add
	 * @see PropertyChangeListener
	 * @see PropertyChangeSupport
	 */
	public void addNotificationListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);

	}

	/**
	 * Add a PropertyChangeListener for a specific property. The listener will be
	 * invoked only when a call on firePropertyChange names that specific property.
	 * The same listener object may be added more than once. For each property, the
	 * listener will be invoked the number of times it was added for that property.
	 * If propertyName or listener is null, no exception is thrown and no action is
	 * taken.
	 *
	 * @param propertyName
	 *            - The name of the property to listen on.
	 * @param listener
	 *            - The PropertyChangeListener to be added
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
	 * @param sheetName
	 *            the sheetName to set
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
	 * Creates a new row in the sheet with the row number being -1. The row is not
	 * added to the sheet until
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
	 * @param columnNumber
	 *            the number of the column
	 * @return a new column
	 * @see Column
	 */
	public Column createColumnInstance(int columnNumber) {
		Column c = Column.getInstance(this);
		c.setColumnNumber(columnNumber);
		return c;
	}

	/**
	 * Creates a new {@link Row} in the sheet with the supplied row number. The row
	 * is not added to the sheet until
	 * {@link #addRow(com.github.lespaul361.commons.simplespreadsheet.Row)} is used.
	 *
	 * @param rowNumber
	 *            the index of the row
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
		return (cell.getRowNumber() == location.getX() && cell.getColumnNumber() == location.getY());

	}

	void checkCounts() {
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
	 * @param sheetNumber
	 *            the sheetNumber to set
	 */
	protected void setSheetNumber(int sheetNumber) {
		int oldSheetNumber = this.sheetNumber;
		this.sheetNumber = sheetNumber;

		propertyChangeSupport.firePropertyChange(PROP_SHEET_NUMBER, oldSheetNumber, sheetNumber);

	}

	/**
	 * Moves the cell to another location
	 * 
	 * @param loc
	 *            the original location
	 * @param dest
	 *            the destination location
	 * @return the {@link Cell} being moved
	 */
	public Cell moveCell(Point loc, Point dest) {
		return moveCell(loc, dest, true);
	}

	Cell moveCell(Point loc, Point dest, boolean fireChange) {
		checkLocationLessThan0(loc);
		checkLocationLessThan0(dest);
		Cell cell = cellMap.get(loc);
		if (cell == null) {
			System.err.println("Cell is null");
		} else {
			cell.setRowNumber(loc.x);
			cell.setColumnNumber(loc.y);
			cellMap.remove(loc);
			cellMap.put(dest, cell);
		}
		if (fireChange) {
			firePropertyChange(PROP_CELL_LOCATION, loc, dest);
		}
		return cell;

	}

	/**
	 * Adds a cell to the spreadsheet. The cell must have the column number and row
	 * number set
	 * 
	 * @param cell
	 *            the cell to add
	 * @return if the operation is successful
	 */
	public boolean addCell(Cell cell) {
		return addCell(cell, cell.getRowNumber(), cell.getColumnNumber());
	}

	/**
	 * Adds a cell to the spreadsheet.
	 * 
	 * @param cell
	 *            the cell to add
	 * @param row
	 *            the row to add it too. Row can not be less that 0
	 * @param column
	 *            the column to add it too. column can not be less that 0
	 * @return true if the operation is successful
	 */
	public boolean addCell(Cell cell, int row, int column) {
		return addCell(cell, row, column, true);
	}

	/**
	 * Adds a cell to the spreadsheet.
	 * 
	 * @param cell
	 *            the cell to add
	 * @param location
	 *            the location of the cell as a {@link Point}. Point.x is the row
	 *            and Point.y is the column.
	 * @return true if the operation is successful
	 */
	public boolean addCell(Cell cell, Point location) {
		return addCell(cell, location, true);
	}

	boolean addCell(Cell cell, int row, int column, boolean fireChange) {
		return addCell(cell, new Point(row, column), fireChange);
	}

	boolean addCell(Cell cell, Point location, boolean fireChange) {
		if(cell==null) {
			RuntimeException e = new NullPointerException("Cell Can Not Be Null");
			e.printStackTrace(System.err);
			return false;
		}
		checkLocationLessThan0(location);
		
		if (isCellInUse(location, cell)) {
			RuntimeException e = new LocationExistsException(location);
			e.printStackTrace(System.err);
			return false;
		}

		cellMap.put(location, cell);
		if (fireChange) {
			firePropertyChange(PROP_CELL_ADDED, null, cell);
		}
		checkCounts();
		return true;

	}

	/**
	 * Removes a cell to the spreadsheet. The row and column must be set and have a
	 * value of 0 or greater
	 * 
	 * @param cell
	 *            the cell to remove
	 * @return the cell being removed
	 */
	public Cell removeCell(Cell cell) {
		return removeCell(new Point(cell.getRowNumber(), cell.getColumnNumber()));
	}

	/**
	 * Removes a cell to the spreadsheet. The row and column must be set and have a
	 * value of 0 or greater
	 * 
	 * @param row
	 *            the row value
	 * @param column
	 *            the column value
	 * @return the cell being removed
	 */
	public Cell removeCell(int row, int column) {
		return removeCell(new Point(row, column), false);
	}

	/**
	 * Removes a cell to the spreadsheet.
	 * 
	 * @param location
	 *            the location of the cell to be removed
	 * @return the cell being removed
	 */
	public Cell removeCell(Point location) {
		return removeCell(location, true);
	}

	Cell removeCell(Cell cell, boolean fireChange) {
		return removeCell(new Point(cell.getRowNumber(), cell.getColumnNumber()), fireChange);
	}

	Cell removeCell(Point location, boolean fireChange) {
		checkLocationLessThan0(location);
		Cell oldCell = cellMap.get(location);
		cellMap.remove(location);
		if (fireChange) {
			firePropertyChange(PROP_CELL_REMOVED, oldCell, null);
		}
		checkCounts();
		return oldCell;

	}

	/**
	 * Sets a cell in the location provided. If there is a cell at that location it is  overwriten.
	 * @param cell the cell to set
	 * @param row the row number
	 * @param column the column number
	 * @return the cell that was originally in that location. Maybe null.
	 */
	public Cell setCell(Cell cell, int row, int column) {
		return (setCell(cell, new Point(row,column)));		
	}

	public Cell setCell(Cell cell, Point loc) {
		return (setCell(cell, loc, true));
	}

	Cell setCell(Cell cell, Point loc, boolean fireChange) {
		Cell oldCell = cellMap.get(loc);
		cell.setRowNumber(loc.x);
		cell.setColumnNumber(loc.y);
		cellMap.put(loc, cell);
		if (fireChange) {
			firePropertyChange(PROP_CELL_SET, oldCell, cell);
		}
		checkCounts();
		return oldCell;

	}
	
	/**
	 * Fires the listeners for property changes
	 *
	 * @param property
	 *            the name of the property
	 * @param oldValue
	 *            the old value
	 * @param newValue
	 *            the new value
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

	private void checkLocationLessThan0(Point point) {
		if (point.x < 0) {
			RuntimeException exception = new IndexOutOfBoundsException("Row Can Not Be Less Than 0");
			exception.printStackTrace(System.err);
			throw exception;
		}

		if (point.y < 0) {
			RuntimeException exception = new IndexOutOfBoundsException("Column Can Not Be Less Than 0");
			exception.printStackTrace(System.err);
			throw exception;
		}

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

	@Override
	public boolean addRow(Row row) {
		return rowDelegate.addRow(row);
	}

	@Override
	public boolean clearRow(Row row) {
		return rowDelegate.clearRow(row);
	}

	@Override
	public Row clearRow(int rowNumber) {
		return rowDelegate.clearRow(rowNumber);
	}

	@Override
	public Row removeRow(int rowNumber) {
		return rowDelegate.removeRow(rowNumber);
	}

	@Override
	public boolean removeRow(Row row) {
		return rowDelegate.removeRow(row);
	}

	@Override
	public boolean insertRow(Row row, int rowNumber) {
		return rowDelegate.insertRow(row, rowNumber);
	}

	@Override
	public boolean setRow(Row row, int rowNumber) {
		return rowDelegate.setRow(row, rowNumber);
	}

	@Override
	public Row getRow(int rowNumber) {
		return rowDelegate.getRow(rowNumber);
	}

	@Override
	public List<Row> getRows() {
		return rowDelegate.getRows();
	}

}
