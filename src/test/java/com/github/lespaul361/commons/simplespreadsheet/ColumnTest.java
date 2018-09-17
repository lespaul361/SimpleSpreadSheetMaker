/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class ColumnTest {

    WorkBook workBook = WorkBook.getInstance(FileFormats.AllowedFileTypes.XLS);
    Sheet sheet = workBook.getInstanceSheet("Test");
    Column column = sheet.createColumnInstance();
    List<Cell> cells = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            cells.add(new BasicCell(sheet));
        }
        column.setCells(cells);
        sheet.addColumn(column);
    }

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
     * Test of getCellInstance method, of class Column.
     */
    @Test
    public void testGetCellInstance() {
        System.out.println("getCellInstance");
        Column instance = column;
        Cell expResult = null;
        Cell result = instance.getCellInstance();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getCells method, of class Column.
     */
    @Test
    public void testGetCells() {
        System.out.println("getCells");
        Column instance = column;
        List<Cell> expResult = null;
        List<Cell> result = instance.getCells();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of setCells method, of class Column.
     */
    @Test
    public void testSetCells() {
        System.out.println("setCells");
        List<Cell> cells = this.cells;
        Column instance = sheet.createColumnInstance();
        instance.setCells(cells);
        Assert.assertTrue(instance.getCells().size() > 0);
    }

    /**
     * Test of getStyle method, of class Column.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        Column instance = column;
        Style expResult = null;
        Style result = instance.getStyle();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of setStyle method, of class Column.
     */
    @Test
    public void testSetStyle() {
        System.out.println("setStyle");
        Style style = new CellStyle();
        Column instance = column;
        instance.setStyle(style);
        Assert.assertTrue(instance.getStyle() != null);
    }

}
