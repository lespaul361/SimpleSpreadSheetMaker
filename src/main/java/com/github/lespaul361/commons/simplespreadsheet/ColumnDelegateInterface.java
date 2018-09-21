package com.github.lespaul361.commons.simplespreadsheet;
import java.util.List;

interface ColumnDelegateInterface {
	/**
	 * Adds a {@link Column} to the end of the sheet. Cell column number will be
	 * changed to match the new column
	 *
	 * @param Column
	 *            {@link Column} the row to add
	 * @return true if column is added
	 * @see Column
	 * @see List
	 */
	public boolean addColumn(Column column);

	/**
	 * Clears a column by object
	 *
	 * @param column
	 *            the column to remove
	 * @return boolean saying if it is successful
	 * @see Column
	 */
	public boolean clearColumn(Column column);

	/**
	 * Clears a column at an index
	 *
	 * @param columnNumber
	 *            the index of the column
	 * @return The column that was cleared
	 * @see Column
	 */
	public Column clearColumn(int columnNumber);

	/**
	 * Removes a {@link Column} from the {@link Sheet} by the {@link Column} index
	 * and shifts the {@link Column}s after it up a {@link Column}
	 *
	 * @param columnNumber
	 *            the number of the column to remove
	 * @return true if the column can be removed
	 * @see Column
	 * @see Sheet
	 */
	public Column removeColumn(int columnNumber);

	/**
	 * Removes a {@link Row} from the {@link Sheet} by the {@link Column} index and
	 * shifts the {@link Row}s after it up a {@link Column}
	 *
	 * @param columnNumber
	 *            the number of the column to remove
	 * @return true if the column can be removed
	 * @see Column
	 * @see Sheet
	 */
	public boolean removeColumn(Column column);

	/**
	 * Inserts a {@link Column} at the provided column number. If the insert is
	 * before the end of the current column then the cells in the current column are
	 * shifted to that number and higher up one column.
	 *
	 * @param column
	 *            the column to insert
	 * @param columnNumber
	 *            the column number to insert the {@link Column} at. Zero based
	 * @return true if successful
	 * @see Column
	 *
	 */
	public boolean insertColumn(Column row, int columnNumber);

	/**
	 * Over writes a column if it already exists in the spread sheet
	 *
	 * @param column
	 *            the column to use
	 * @param rowNumber
	 *            the column number where this column will be put. This will
	 *            override the column number set in the {@link Cell}s and the {#link
	 *            Column}
	 * @return true if the operation works
	 */
	public boolean setColumn(Column column, int columnNumber);

	/**
	 * Gets the column at the specified index
	 *
	 * @param columnNumber
	 *            the column index
	 * @return the column
	 * @see Column
	 *
	 */
	public Column getColumn(int columnNumber);

	/**
	 * Gets a list of all the columns
	 *
	 * @return a list of all the columns
	 * @see Column
	 *
	 */
	public List<Column> getColumns();
}
