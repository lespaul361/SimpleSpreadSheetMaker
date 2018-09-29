package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class RowDelegate extends AbstractDelegate implements RowDelegateInterface {

	public RowDelegate(Sheet sheet, Map<Integer, ICellStyle> rowStyleMap, Map<Integer, ICellStyle> columnStyleMap) {
		super(sheet, rowStyleMap, columnStyleMap);
	}

	@Override
	public boolean addRow(Row row) {
		int rowCount=sheet.getRowCount();
		for (Cell cell : row.getCells()) {
			Point point = new Point(rowCount, cell.getColumnNumber());
			if (!sheet.addCell(cell, point, false)) {
				return false;
			}
		}
		rowStyleMap.put(sheet.getRowCount(), row.getStyle());
		sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_ADDED, null, getRow(sheet.getRowCount()));
		sheet.checkCounts();
		return true;
	}

	@Override
	public boolean clearRow(Row row) {
		for (Cell cell : row.getCells()) {
			Point point = new Point(row.getRowNumber(), cell.getColumnNumber());
			sheet.removeCell(point, false);
		}

		rowStyleMap.remove(row.getRowNumber());
		sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_CLEARED, row, null);
		sheet.checkCounts();
		return true;
	}

	@Override
	public Row clearRow(int rowNumber) {
		Row row = getRow(rowNumber);
		if (clearRow(row)) {
			return row;
		}
		return null;
	}

	@Override
	public boolean removeRow(Row row) {
		for (Cell cell : row.getCells()) {
			Point point = new Point(row.getRowNumber(), cell.getColumnNumber());
			sheet.removeCell(point, false);
		}

		sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_REMOVED, row, null);
		shiftRows(-1, row.getRowNumber() + 1);
		sheet.checkCounts();
		return true;
	}

	@Override
	public Row removeRow(int rowNumber) {
		Row row = getRow(rowNumber);
		if (removeRow(row)) {
			return row;
		}
		return null;
	}

	@Override
	public boolean insertRow(Row row, int rowNumber) {
		Row oldRow = getRow(rowNumber);
		shiftRows(1, rowNumber);
		for (Cell cell : row.getCells()) {
			sheet.addCell(cell, rowNumber, cell.getColumnNumber(), false);
		}
		sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_ADDED, oldRow, row);
		sheet.checkCounts();
		return true;
	}

	@Override
	public boolean setRow(Row row, int rowNumber) {
		Row oldRow=getRow(rowNumber);
		for(Cell cell:row.getCells()) {
			sheet.setCell(cell, new Point(rowNumber,cell.getColumnNumber()));			
		}
		sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_SET, oldRow, row);
		return true;
	}

	@Override
	public Row getRow(int rowNumber) {
		sheet.checkCounts();
		Row curRow = null;
		Cell curCell = null;
		curRow = sheet.createRowInstance(rowNumber);
		for (int c = 0; c < sheet.getColumnCount(); c++) {
			curCell = sheet.getCell(rowNumber, c);
			if (curCell != null) {
				curRow.getCells().add(curCell);
			}
		}
		curRow.setStyle(rowStyleMap.get(rowNumber));
		return curRow;
	}

	@Override
	public List<Row> getRows() {
		sheet.checkCounts();
		List<Row> rows = new ArrayList<>(sheet.getRowCount());
		for (int r = 0; r < sheet.getRowCount(); r++) {
			rows.add(getRow(r));
		}
		return rows;
	}

	private void shiftRows(int direction, int startIndex) {
		List<Row> rows = getRows();
		Map<Integer, ICellStyle> newRowStyles = new HashMap<>(rowStyleMap.size());
		for (int i = 0; i < startIndex; i++) {
			newRowStyles.put(i, rowStyleMap.get(i));
		}

		for (int i = startIndex; i < rows.size(); i++) {
			Row row = rows.get(i);
			for (Cell cell : row.getCells()) {
				Point oldPoint = new Point(i, cell.getColumnNumber());
				Point newPoint = new Point(i + direction, oldPoint.y);
				sheet.moveCell(oldPoint, newPoint, false);
			}
			sheet.firePropertyChange(Sheet.PROP_SHEET_ROW_MOVED, i, i + direction);
			newRowStyles.put(1 + direction, row.getStyle());
		}

		rowStyleMap.clear();
		Iterator<Entry<Integer, ICellStyle>> entries = newRowStyles.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, ICellStyle> entry = entries.next();
			rowStyleMap.put(entry.getKey(), entry.getValue());
		}
	}

}
