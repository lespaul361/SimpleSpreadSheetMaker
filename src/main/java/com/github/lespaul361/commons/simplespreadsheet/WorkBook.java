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
    private AllowedFileTypes fileType = null;

    private WorkBook(AllowedFileTypes fileType) {
        this.fileType = fileType;
    }

    public static WorkBook getInstance(AllowedFileTypes fileType) {
        WorkBook ret = new WorkBook(fileType);
        return ret;
    }

    /**
     * Gets a new <code>Sheet</code> object
     *
     * @return a new Sheet
     * @see Sheet
     */
    public Sheet getInstanceSheet() {
        Sheet sheet = new Sheet(this.sheets.size() + 1);
        this.sheets.add(sheet);
        return sheet;
    }

    /**
     * Gets a new {@link Sheet} object and sets the name
     *
     * @param name the name of the {@link Sheet}
     * @return a new Sheet
     * @see Sheet
     */
    public Sheet getInstanceSheet(String name) {
        Sheet sheet = new Sheet(this.sheets.size() + 1);
        this.sheets.add(sheet);
        sheet.setSheetName(name);
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
        return this.sheets;
    }

    /**
     * Gets a Sheet object by the <code>sheet's name</code>
     *
     * @param name the name of the sheet
     * @return a Sheet with the same name or null
     */
    public Sheet getSheet(String name) {
        for (Sheet sheet : this.sheets) {
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
     * @throws ArrayIndexOutOfBoundsException Thrown to indicate that an array
     * has been accessed with an illegal index. The index is either negative or
     * greater than or equal to the size of the array.
     */
    public Sheet getSheet(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is less that 0");
        }
        if (index > this.sheets.size() - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is larger than the array size");
        }

        return this.sheets.get(index);
    }

    /**
     * Removes a sheet from the workbook
     *
     * @param index the index of the sheet
     * @return the sheet being removed
     * @throws ArrayIndexOutOfBoundsException Thrown to indicate that an array
     * has been accessed with an illegal index. The index is either negative or
     * greater than or equal to the size of the array.
     * @see Sheet
     */
    public Sheet removeSheet(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is less that 0");
        }
        if (index > this.sheets.size() - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is larger than the array size");
        }
        Sheet ret = this.sheets.get(index);
        this.sheets.remove(index);
        return ret;
    }

    /**
     * Removes a sheet from the workbook
     *
     * @param sheetName the name of the sheet
     * @return true if the sheet was found and removed, otherwise false
     * @throwsArrayIndexOutOfBoundsException Thrown to indicate that an array *
     * has been accessed with an illegal index. The index is either negative or
     * * greater than or equal to the size of the array. * @throws
     * IllegalArgumentException
     * @see Sheet
     */
    public boolean removeSheet(String sheetName) {
        for (int i = 0; i < sheets.size(); i++) {
            if (this.sheets.get(i).getSheetName().equalsIgnoreCase(sheetName)) {
                this.sheets.remove(i);
                return true;
            }
        }
        return false;
    }
}
