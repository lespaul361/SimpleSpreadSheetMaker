package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Point;
import java.util.List;
import java.util.Map;

class ColumnDelegate extends AbstractDelegate implements ColumnDelegateInterface {

	public ColumnDelegate(Sheet sheet, Map<Integer, Style> rowStyleMap, Map<Integer, Style> columnStyleMap) {
		super(sheet, rowStyleMap, columnStyleMap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addColumn(Column column) {
		int count=sheet.getColumnCount();
		for(Cell cell:column.getCells()) {
			sheet.addCell(cell, new Point(cell.getRowNumber(),count), false);			
		}
		columnStyleMap.put(count, column.getStyle());
		sheet.firePropertyChange(Sheet.PROP_SHEET_COLUMN_ADDED, null, column);
		return true;
	}

	@Override
	public boolean clearColumn(Column column) {
		for(Cell cell:column.getCells()) {
			sheet.removeCell(cell);
		}
		sheet.firePropertyChange(Sheet.PROP_SHEET_COLUMN_CLEARED, column, null);
		return true;
	}

	@Override
	public Column clearColumn(int columnNumber) {
		Column oldColumn=getColumn(columnNumber);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Column> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

}
