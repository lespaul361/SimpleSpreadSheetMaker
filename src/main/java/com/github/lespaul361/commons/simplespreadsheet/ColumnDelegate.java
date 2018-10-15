package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ColumnDelegate extends AbstractDelegate implements ColumnDelegateInterface {

	public ColumnDelegate(Sheet sheet, Map<Integer, FontStyle> rowStyleMap, Map<Integer, FontStyle> columnStyleMap) {
		super(sheet, rowStyleMap, columnStyleMap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addColumn(Column column) {
		int count = sheet.getColumnCount();
		for (Cell cell : column.getCells()) {
			sheet.addCell(cell, new Point(cell.getRowNumber(), count), false);
		}
		columnStyleMap.put(count, column.getStyle());
		sheet.firePropertyChange(Sheet.PROP_SHEET_COLUMN_ADDED, null, column);
		return true;
	}

	@Override
	public boolean clearColumn(Column column) {
		for (Cell cell : column.getCells()) {
			sheet.removeCell(cell);
		}
		sheet.firePropertyChange(Sheet.PROP_SHEET_COLUMN_CLEARED, column, null);
		return true;
	}

	@Override
	public Column clearColumn(int columnNumber) {
		Column oldColumn = getColumn(columnNumber);
		clearColumn(oldColumn);
		return oldColumn;
	}

	@Override
	public Column removeColumn(int columnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeColumn(Column column) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertColumn(Column row, int columnNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setColumn(Column column, int columnNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Column getColumn(int columnNumber) {
		return getColumn(columnNumber, true);
	}

	@Override
	public List<Column> getColumns() {
		sheet.checkCounts();
		int columnCount = sheet.getColumnCount();
		List<Column> columns = new ArrayList<>(columnCount);
		for (int i = 0; i < columnCount; i++) {
			columns.add(getColumn(i));
		}
		return columns;
	}

	protected Column getColumn(int columnNumber, boolean checkCount) {
		if (checkCount) {
			sheet.checkCounts();
		}
		int rowCount = sheet.getRowCount();
		List<Cell> cells = new ArrayList<>(rowCount);
		for (int i = 0; i < rowCount; i++) {
			Cell cell = sheet.getCell(i, columnNumber);
			if (cell != null) {
				cells.add(cell);
			}
		}

		Column column = sheet.createColumnInstance(columnNumber);
		column.setCells(cells);
		column.setStyle(columnStyleMap.get(columnNumber));
		return column;

	}

	private void shiftColumns(int direction, int startIndex) {
		List<Column> columns = getColumns();
		Map<Integer, FontStyle> newColumnStyles = new HashMap<>(columnStyleMap.size());
		for (int i = 0; i < startIndex; i++) {
			newColumnStyles.put(i, newColumnStyles.get(i));
		}

		for (int i = startIndex; i < columns.size(); i++) {
			Column column = columns.get(i);
			for (Cell cell : column.getCells()) {
				Point oldPoint = new Point(cell.getRowNumber(), i);
				Point newPoint = new Point(oldPoint.y, i + direction);
				sheet.moveCell(oldPoint, newPoint, false);
			}
			sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_MOVED, i, i + direction);
			newColumnStyles.put(1 + direction, column.getStyle());
		}

		newColumnStyles.clear();
		Iterator<Entry<Integer, FontStyle>> entries = newColumnStyles.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, FontStyle> entry = entries.next();
			newColumnStyles.put(entry.getKey(), entry.getValue());
		}
	}

}
