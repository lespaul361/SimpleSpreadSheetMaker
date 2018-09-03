/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class ColumnTest {
    
    public ColumnTest() {
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
     * Test of getCells method, of class Column.
     */
    @Test
    public void testGetCells() {
        System.out.println("getCells");
        Column instance = null;
        List<Cell> expResult = null;
        List<Cell> result = instance.getCells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCells method, of class Column.
     */
    @Test
    public void testSetCells() {
        System.out.println("setCells");
        List<Cell> cells = null;
        Column instance = null;
        instance.setCells(cells);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStyle method, of class Column.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        Column instance = null;
        Style expResult = null;
        Style result = instance.getStyle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStyle method, of class Column.
     */
    @Test
    public void testSetStyle() {
        System.out.println("setStyle");
        Style style = null;
        Column instance = null;
        instance.setStyle(style);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNotificationListener method, of class Column.
     */
    @Test
    public void testAddNotificationListener_PropertyChangeListener() {
        System.out.println("addNotificationListener");
        PropertyChangeListener listener = null;
        Column instance = null;
        instance.addNotificationListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNotificationListener method, of class Column.
     */
    @Test
    public void testAddNotificationListener_String_PropertyChangeListener() {
        System.out.println("addNotificationListener");
        String propertyName = "";
        PropertyChangeListener listener = null;
        Column instance = null;
        instance.addNotificationListener(propertyName, listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Column.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Column instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Column.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Column instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
