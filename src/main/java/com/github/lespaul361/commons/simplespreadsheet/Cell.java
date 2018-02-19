/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

/**
 *
 * @author David Hamilton
 */
public interface Cell extends Style{

    public void setCellRow(int row);

    public void setCellColumn(int column);

    public void setCellText(String text);

    public void setCellFunction(String function);

    public int getCellRow();

    public int getetCellColumn();

    public String getCellText();

    public String getCellFunction();
}
