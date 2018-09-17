/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author David Hamilton
 */
public class BasicCellTest {

    WorkBook workBook = WorkBook.getInstance(FileFormats.AllowedFileTypes.XLS);
    Sheet sheet = workBook.getInstanceSheet("test");

    public BasicCellTest() {
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
     * Test of hashCode method, of class BasicCell.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        BasicCell instance = (BasicCell) sheet.getCellInstance();
        int result = instance.hashCode();
        Assert.assertNotEquals(result, 0);
    }

    /**
     * Test of equals method, of class BasicCell.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("not equals");
        Object obj = null;
        BasicCell instance = (BasicCell) sheet.getCellInstance();
        boolean expResult = true;
        boolean result = instance.equals((BasicCell) sheet.getCellInstance());
        assertEquals(expResult, result);

    }

}
