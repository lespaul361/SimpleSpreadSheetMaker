/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class SheetTest {
    
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
    public void testAddRow_Row() {
        System.out.println("addRow");
        Row row = null;
        Sheet instance = null;
        instance.addRow(row);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRow method, of class Sheet.
     */
    @Test
    public void testAddRow_Row_int() {
        System.out.println("addRow");
        Row row = null;
        int rowNumber = 0;
        Sheet instance = null;
        instance.addRow(row, rowNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRow method, of class Sheet.
     */
    @Test
    public void testRemoveRow_Row() {
        System.out.println("removeRow");
        Row row = null;
        Sheet instance = null;
        boolean expResult = false;
        boolean result = instance.removeRow(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRow method, of class Sheet.
     */
    @Test
    public void testRemoveRow_int() {
        System.out.println("removeRow");
        int rowNumber = 0;
        Sheet instance = null;
        boolean expResult = false;
        boolean result = instance.removeRow(rowNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeColumn method, of class Sheet.
     */
    @Test
    public void testRemoveColumn() {
        System.out.println("removeColumn");
        Column column = null;
        Sheet instance = null;
        boolean expResult = false;
        boolean result = instance.removeColumn(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class Sheet.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int rowNumber = 0;
        Sheet instance = null;
        Row expResult = null;
        Row result = instance.getRow(rowNumber);
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
    public void testSetCell() {
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
     * Test of getStyle method, of class Sheet.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        Sheet instance = null;
        Style expResult = null;
        Style result = instance.getStyle();
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
        Style style = null;
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
    
}
