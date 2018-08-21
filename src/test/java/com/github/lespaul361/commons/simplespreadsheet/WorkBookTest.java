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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class WorkBookTest {

    public WorkBookTest() {
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
     * Test of getInstanceSheet method, of class WorkBook.
     */
    @Test
    public void testGetInstaceSheet() {
        System.out.println("getInstaceSheet");
        WorkBook instance = new WorkBook();
        Sheet expResult = null;
        Sheet result = instance.getInstaceSheet();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getSheets method, of class WorkBook.
     */
    @Test
    public void testGetSheets() {
        System.out.println("getSheets");
        WorkBook instance = new WorkBook();
        Sheet expResult = null;
        Sheet result = instance.getInstaceSheet();
        assertNotEquals(expResult, result);
        List<Sheet> expListResult = new ArrayList<>();
        List<Sheet> nullListResult=null;
        expListResult.add(result);
        assertNotEquals(expListResult, nullListResult);
        List<Sheet> sheets = instance.getSheets();
        assertEquals(expListResult, sheets);
        
    }

    /**
     * Test of getSheet method, of class WorkBook.
     */
    @Test
    public void testGetSheet_String() {
        System.out.println("getSheet");
        String name = "";
        WorkBook instance = new WorkBook();
        instance.getInstaceSheet();
        Sheet expResult = null;
        String sheetName="Sheet 1";
        Sheet result = instance.getSheet(sheetName);
        assertTrue(result!=null);
    }

    /**
     * Test of getSheet method, of class WorkBook.
     */
    @Test
    public void testGetSheet_int() {
        System.out.println("getSheet");
        int index = 0;
        WorkBook instance = new WorkBook();
        Sheet expResult =instance.getInstaceSheet();
        Sheet result=instance.getSheet(0);
        assertEquals(expResult, result);
        
    }

}
