/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class SheetTest {

	WorkBook workBook = WorkBook.getInstance(FileFormats.AllowedFileTypes.XLS);
	Sheet sheet = workBook.getInstanceSheet("Test");
	Column column = sheet.createColumnInstance(0);
	Row row = sheet.createRowInstance(0);

	List<Cell> cells = new ArrayList<>();

	{
		for (int i = 0; i < 10; i++) {
			cells.add(new BasicCell(sheet));
		}
		column.setCells(cells);

		cells = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			cells.add(new BasicCell(sheet));
		}
		row.setCells(cells);
	}

	public SheetTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of addRow method, of class Sheet.
	 */
	@Test
	public void testAddRow() {
		System.out.println("addRow");
		Row row = this.row;
		Sheet instance = sheet;
		boolean expResult = true;
		boolean result = instance.addRow(row);
		assertEquals(expResult, result);

	}

	/**
	 * Test of clearRow method, of class Sheet.
	 */
	@Test
	public void testClearRow_Row() {
		System.out.println("clearRow");
		Sheet instance = sheet;
		sheet.addRow(row);
		boolean expResult = true;
		boolean result = instance.clearRow(row);
		assertEquals(expResult, result);

	}

	/**
	 * Test of clearRow method, of class Sheet.
	 */
	@Test
	public void testClearRow_int() {
		System.out.println("clearRow");
		int rowNumber = 0;
		Sheet instance = sheet;
		sheet.addRow(row);
		Row result = instance.clearRow(rowNumber);
		Assert.assertNotNull(result);
	}

	/**
	 * Test of removeRow method, of class Sheet.
	 */
	@Test
	public void testRemoveRow_Row() {
		System.out.println("removeRow");
		Sheet instance = sheet;
		sheet.addRow(row);
		boolean expResult = true;
		boolean result = instance.removeRow(row);
		assertEquals(expResult, result);

	}

	/**
	 * Test of removeRow method, of class Sheet.
	 */
	@Test
	public void testRemoveRow_int() {
		System.out.println("removeRow");
		int rowNumber = 0;
		Sheet instance = sheet;
		sheet.addRow(row);
		Row result = instance.removeRow(rowNumber);
		Assert.assertNotNull(result);
	}

	/**
	 * Test of insertRow method, of class Sheet.
	 */
	@Test
	public void testInsertRow() {
		System.out.println("insertRow");
		Row row = null;
		int rowNumber = 0;
		Sheet instance = null;
		boolean expResult = false;
		boolean result = instance.insertRow(row, rowNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRow method, of class Sheet.
	 */
	@Test
	public void testSetRow() {
		System.out.println("setRow");
		Row row = this.row;
		int rowNumber = 0;
		Sheet instance = sheet;
		boolean expResult = true;
		boolean result = instance.setRow(row, rowNumber);
		assertEquals(expResult, result);

	}

	/**
	 * Test of getRow method, of class Sheet.
	 */
	@Test
	public void testGetRow() {
		System.out.println("getRow");
		int rowNumber = 0;
		Sheet instance = sheet;
		sheet.addRow(row);
		Row expResult = null;
		Row result = instance.getRow(rowNumber);
		assertNotEquals(expResult, result);

	}

	/**
	 * Test of addColumn method, of class Sheet.
	 */
	@Test
	public void testAddColumn() {
		System.out.println("addColumn");
		Column column = this.column;
		Sheet instance = sheet;
		boolean expResult = true;
		boolean result = instance.addColumn(column);
		assertEquals(expResult, result);

	}

	/**
	 * Test of removeColumn method, of class Sheet.
	 */
	@Test
	public void testRemoveColumn_Column() {
		System.out.println("removeColumn");
		Column column = this.column;
		Sheet instance = sheet;
		sheet.addColumn(column);
		boolean expResult = true;
		boolean result = instance.removeColumn(column);
		assertEquals(expResult, result);

	}

	/**
	 * Test of removeColumn method, of class Sheet.
	 */
	@Test
	public void testRemoveColumn_int() {
		System.out.println("removeColumn");
		int columnNumber = 0;
		Sheet instance = sheet;
		Column expResult = this.column;
		sheet.addColumn(column);
		Column result = instance.removeColumn(columnNumber);
		assertEquals(expResult, result);

	}

	/**
	 * Test of clearColumn method, of class Sheet.
	 */
	@Test
	public void testClearColumn_Column() {
		System.out.println("clearColumn");
		Column column = null;
		Sheet instance = null;
		boolean expResult = false;
		boolean result = instance.clearColumn(column);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clearColumn method, of class Sheet.
	 */
	@Test
	public void testClearColumn_int() {
		System.out.println("clearColumn");
		int columnNumber = 0;
		Sheet instance = null;
		Column expResult = null;
		Column result = instance.clearColumn(columnNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of insertColumn method, of class Sheet.
	 */
	@Test
	public void testInsertColumn() {
		System.out.println("insertColumn");
		Column column = null;
		int columnNumber = 0;
		Sheet instance = null;
		boolean expResult = false;
		boolean result = instance.insertColumn(column, columnNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setColumn method, of class Sheet.
	 */
	@Test
	public void testSetColumn() {
		System.out.println("setColumn");
		Column column = null;
		int columnNumber = 0;
		Sheet instance = null;
		boolean expResult = false;
		boolean result = instance.setColumn(column, columnNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getColumn method, of class Sheet.
	 */
	@Test
	public void testGetColumn() {
		System.out.println("getColumn");
		int index = 0;
		Sheet instance = null;
		Column expResult = null;
		Column result = instance.getColumn(index);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCell method, of class Sheet.
	 */
	@Test
	public void testGetCell() {
		System.out.println("getCell");
		int rowNumber = 0;
		int columnNumber = 0;
		Sheet instance = null;
		Cell expResult = null;
		Cell result = instance.getCell(rowNumber, columnNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCell method, of class Sheet.
	 */
	@Test
	public void testSetCell_3args() {
		System.out.println("setCell");
		int rowNumber = 0;
		int columnNumber = 0;
		Cell cell = null;
		Sheet instance = null;
		instance.setCell(rowNumber, columnNumber, cell);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCell method, of class Sheet.
	 */
	@Test
	public void testSetCell_4args() {
		System.out.println("setCell");
		int rowNumber = 0;
		int columnNumber = 0;
		Cell cell = null;
		boolean isOverWrite = false;
		Sheet instance = null;
		instance.setCell(rowNumber, columnNumber, cell, isOverWrite);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCellInstance method, of class Sheet.
	 */
	@Test
	public void testGetCellInstance_0args() {
		System.out.println("getCellInstance");
		Sheet instance = null;
		Cell expResult = null;
		Cell result = instance.getCellInstance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCellInstance method, of class Sheet.
	 */
	@Test
	public void testGetCellInstance_int_int() {
		System.out.println("getCellInstance");
		int x = 0;
		int y = 0;
		Sheet instance = null;
		Cell expResult = null;
		Cell result = instance.getCellInstance(x, y);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCellInstance method, of class Sheet.
	 */
	@Test
	public void testGetCellInstance_Point() {
		System.out.println("getCellInstance");
		Point location = null;
		Sheet instance = null;
		Cell expResult = null;
		Cell result = instance.getCellInstance(location);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getStyle method, of class Sheet.
	 */
	@Test
	public void testGetStyle() {
		System.out.println("getStyle");
		Sheet instance = null;
		ICellStyle expResult = null;
		ICellStyle result = instance.getStyle();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setStyle method, of class Sheet.
	 */
	@Test
	public void testSetStyle() {
		System.out.println("setStyle");
		ICellStyle style = null;
		Sheet instance = null;
		instance.setStyle(style);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addNotificationListener method, of class Sheet.
	 */
	@Test
	public void testAddNotificationListener_PropertyChangeListener() {
		System.out.println("addNotificationListener");
		PropertyChangeListener listener = null;
		Sheet instance = null;
		instance.addNotificationListener(listener);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addNotificationListener method, of class Sheet.
	 */
	@Test
	public void testAddNotificationListener_String_PropertyChangeListener() {
		System.out.println("addNotificationListener");
		String propertyName = "";
		PropertyChangeListener listener = null;
		Sheet instance = null;
		instance.addNotificationListener(propertyName, listener);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSheetName method, of class Sheet.
	 */
	@Test
	public void testGetSheetName() {
		System.out.println("getSheetName");
		Sheet instance = null;
		String expResult = "";
		String result = instance.getSheetName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setSheetName method, of class Sheet.
	 */
	@Test
	public void testSetSheetName() {
		System.out.println("setSheetName");
		String sheetName = "";
		Sheet instance = null;
		instance.setSheetName(sheetName);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSheetNumber method, of class Sheet.
	 */
	@Test
	public void testGetSheetNumber() {
		System.out.println("getSheetNumber");
		Sheet instance = null;
		int expResult = 0;
		int result = instance.getSheetNumber();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRowCount method, of class Sheet.
	 */
	@Test
	public void testGetRowCount() {
		System.out.println("getRowCount");
		Sheet instance = null;
		int expResult = 0;
		int result = instance.getRowCount();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getColumnCount method, of class Sheet.
	 */
	@Test
	public void testGetColumnCount() {
		System.out.println("getColumnCount");
		Sheet instance = null;
		int expResult = 0;
		int result = instance.getColumnCount();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createRowInstance method, of class Sheet.
	 */
	@Test
	public void testCreateRowInstance_0args() {
		System.out.println("createRowInstance");
		Sheet instance = null;
		Row expResult = null;
		Row result = instance.createRowInstance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createColumnInstance method, of class Sheet.
	 */
	@Test
	public void testCreateColumnInstance_0args() {
		System.out.println("createColumnInstance");
		Sheet instance = null;
		Column expResult = null;
		Column result = instance.createColumnInstance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createColumnInstance method, of class Sheet.
	 */
	@Test
	public void testCreateColumnInstance_int() {
		System.out.println("createColumnInstance");
		int columnNumber = 0;
		Sheet instance = null;
		Column expResult = null;
		Column result = instance.createColumnInstance(columnNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createRowInstance method, of class Sheet.
	 */
	@Test
	public void testCreateRowInstance_int() {
		System.out.println("createRowInstance");
		int rowNumber = 0;
		Sheet instance = null;
		Row expResult = null;
		Row result = instance.createRowInstance(rowNumber);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of equals method, of class Sheet.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Object obj = null;
		Sheet instance = null;
		boolean expResult = false;
		boolean result = instance.equals(obj);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of hashCode method, of class Sheet.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Sheet instance = null;
		int expResult = 0;
		int result = instance.hashCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
