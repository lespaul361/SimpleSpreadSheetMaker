package com.github.lespaul361.commons.simplespreadsheet;

import java.util.List;

interface RowDelegateInterface {
	/**
	 * Adds a {@link Row} to the end of the sheet. Cell row number will be changed
	 * to match the new row.
	 *
	 * @param row
	 *            {@link Row} the row to add
	 * @return true if row is added
	 * @see Row
	 * @see List
	 */
	public boolean addRow(Row row);

	/**
	 * Clears a row by object
	 *
	 * @param row
	 *            the row to remove
	 * @return boolean saying if it is successful
	 * @see Row
	 */
	public boolean clearRow(Row row);

	/**
	 * Clears a row at an index
	 *
	 * @param rowNumber
	 *            the index of the row
	 * @return Row the row that was cleared
	 * @see Row
	 */
	public Row clearRow(int rowNumber);

	/**
	 * Removes a {@link Row} from the {@link Sheet} by the {@link Row} index and
	 * shifts the {@link Row}s after it up a {@link Row}
	 *
	 *
	 * @param row
	 *            the row to remove
	 * @return true if the operation is successful
	 * @see Row
	 * @see Sheet
	 */
	public boolean removeRow(Row row);

	/**
	 * Removes a {@link Row} from the {@link Sheet} by the {@link Row} shifts the
	 * {@link Row}s after it up a {@link Row}
	 *
	 * @param rowNumber
	 *            the number of the row to remove
	 * @return the Row being removed
	 * @see Row
	 * @see Sheet
	 */
	public Row removeRow(int rowNumber);

	/**
	 * Inserts a {@link Row} at the provided row number. If the insert is before the
	 * end of the current rows then the cells in the current row are shifted to that
	 * number and higher up one row.
	 *
	 * @param row
	 *            the row to insert
	 * @param rowNumber
	 *            the row number to insert the {@link Row} at. Zero based
	 * @return true if successful
	 * @see Row
	 *
	 */
	public boolean insertRow(Row row, int rowNumber);

	/**
	 * Over writes a row if it already exists in the spread sheet
	 *
	 * @param row
	 *            the row to use
	 * @param rowNumber
	 *            the row number where this row will be put. This will override the
	 *            row number set in the {@link Cell}s and the {#link Row}
	 * @return true if the operation works
	 */
	public boolean setRow(Row row, int rowNumber);

	/**
	 * Gets the row at the specified index
	 *
	 * @param rowNumber
	 *            the row index
	 * @return the Row
	 * @see Row
	 *
	 */
	public Row getRow(int rowNumber);

	/**
	 * Gets a list of all the rows
	 *
	 * @return a list of all the rows
	 * @see Row
	 *
	 */
	public List<Row> getRows();

}
