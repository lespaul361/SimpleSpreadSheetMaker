/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class RowTest {
    WorkBook workBook=WorkBook.getInstance(FileFormats.AllowedFileTypes.XLS);
    Sheet sheet=workBook.getInstanceSheet("Test");
    Row row=new Row();
    {
        List<Cell> cells=new ArrayList<>();
        for(int i=0;i<10;i++){
            cells.add(new BasicCell(sheet));
        }
        row.setCells(cells);
        sheet.addRow(row);
    }
    
    
    public RowTest() {
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
     * Test of getInstance method, of class Row.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Sheet sheet = null;
        Row expResult = null;
        Row result = Row.getInstance(sheet);
        assertNotNull(result);
    }

    /**
     * Test of getRowNumber method, of class Row.
     */
    @Test
    public void testGetRowNumber() {
        System.out.println("getRowNumber");
        Row instance = sheet.getRow(0);
        int expResult = 0;
        int result = instance.getRowNumber();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCells method, of class Row.
     */
    @Test
    public void testGetCells() {
        System.out.println("getCells");
        Row instance = new Row();
        List<Cell> expResult = null;
        List<Cell> result = instance.getCells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCells method, of class Row.
     */
    @Test
    public void testSetCells() {
        System.out.println("setCells");
        List<Cell> cells = null;
        Row instance = new Row();
        instance.setCells(cells);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStyle method, of class Row.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        Row instance = new Row();
        Style expResult = null;
        Style result = instance.getStyle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStyle method, of class Row.
     */
    @Test
    public void testSetStyle() {
        System.out.println("setStyle");
        Style style = null;
        Row instance = new Row();
        instance.setStyle(style);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNotificationListener method, of class Row.
     */
    @Test
    public void testAddNotificationListener_PropertyChangeListener() {
        System.out.println("addNotificationListener");
        PropertyChangeListener listener = null;
        Row instance = new Row();
        instance.addNotificationListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNotificationListener method, of class Row.
     */
    @Test
    public void testAddNotificationListener_String_PropertyChangeListener() {
        System.out.println("addNotificationListener");
        String propertyName = "";
        PropertyChangeListener listener = null;
        Row instance = new Row();
        instance.addNotificationListener(propertyName, listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Row.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Row instance = new Row();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Row.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Row instance = new Row();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
