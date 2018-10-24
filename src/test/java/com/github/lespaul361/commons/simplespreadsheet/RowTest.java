/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
public class RowTest {

    WorkBook workBook = WorkBook.getInstance(FileFormats.AllowedFileTypes.XLS);
    Sheet sheet = workBook.getInstanceSheet("Test");
    Row row = sheet.createRowInstance();
    List<Cell> cells = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
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
        Row r = sheet.createRowInstance();
        assertNotNull(r);
    }

    /**
     * Test of getRowNumber method, of class Row.
     */
    @Test
    public void testGetRowNumber() {
        System.out.println("getRowNumber");
        Row r = sheet.createRowInstance();
        r.setRowNumber(3);
        int exp = 3;
        assertEquals(exp, r.getRowNumber());

    }

    /**
     * Test of getCells method, of class Row.
     */
    @Test
    public void testGetCells() {
        System.out.println("getCells");
        List<Cell> cells = row.getCells();
        assertNotNull(cells);
        assertTrue(cells.size() > 0);
    }

    /**
     * Test of setCells method, of class Row.
     */
    @Test
    public void testSetCells() {
        System.out.println("setCells");
        Row r = sheet.createRowInstance();
        r.setCells(cells);
        assertTrue(r.getCells() != null);
    }

    /**
     * Test of getStyle method, of class Row.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        Row r = sheet.createRowInstance();
        assertTrue(r.getStyle() != null);
    }

    /**
     * Test of setStyle method, of class Row.
     */
    @Test
    public void testSetStyle() {
        System.out.println("setStyle");
        //TODO: write test
    }

    /**
     * Test of hashCode method, of class Row.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertTrue(row.hashCode() > 0);
    }

    /**
     * Test of equals method, of class Row.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        //TODO: write test
    }

    /**
     * Test clone method, of class Row.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        try {
            Row row2 = (Row) row.clone();
            assertEquals(row, row2);
        } catch (Exception e) {
        }

    }

}
