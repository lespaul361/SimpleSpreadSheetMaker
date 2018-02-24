/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Hamilton
 */
public class WorkBook implements FileFormats, Serializable {

    private List<Sheet> sheets = new ArrayList<>();
    private static final long serialVersionUID = -527556904949593L;

    /**
     * Constructs a new <code>WorkBook</code> object
     */
    public WorkBook() {
    }

    /**
     * Gets a new <code>Sheet</code> object
     *
     * @return a new Sheet
     * @see Sheet
     */
    public Sheet getInstaceSheet() {
        Sheet sheet = new Sheet(sheets.size() + 1);
        sheets.add(sheet);
        return sheet;
    }

    /**
     * Gets a List of Sheet objects that have been created
     *
     * @return a List of Sheet objects
     * @see Sheet
     * @see List
     */
    public List<Sheet> getSheets() {
        return sheets;
    }

    /**
     * Gets a Sheet object by the <code>sheet's name</code>
     *
     * @param name the name of the sheet
     * @return a Sheet with the same name or null
     */
    public Sheet getSheet(String name) {
        for (Sheet sheet : sheets) {
            if (sheet.getSheetName().equalsIgnoreCase(name)) {
                return sheet;
            }
        }
        return null;
    }

    /**
     * Gets a Sheet object at the specified index
     *
     * @param index the index of the Sheet object
     * @return the Sheet object
     * @throws ArrayIndexOutOfBoundsException thrown when the index in not in
     * the array range
     */
    public Sheet getSheet(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is less that 0");
        }
        if (index > sheets.size() - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is larger than the array size");
        }

        return sheets.get(index);
    }
}
