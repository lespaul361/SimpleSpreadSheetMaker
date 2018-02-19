/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.simplespreadsheet;

/**
 *
 * @author David Hamilton
 */
public interface Cell {

    public void setCellRow(int row);

    public void setCellColumn(int column);

    public void setCellBold(boolean b);

    public void setCellItalic(boolean b);

    public void setCellText(String text);

    public void setCellFunction(String function);

    public int getCellRow();

    public int getetCellColumn();

    public boolean isCellBold();

    public boolean isCellItalic();

    public String getCellText();

    public String getCellFunction();
}
