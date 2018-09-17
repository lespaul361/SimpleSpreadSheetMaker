/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Font;

/**
 *
 * @author David Hamilton
 */
public interface Style {

    /**
     * @return the bold
     */
    public boolean isBold();

    /**
     * @param bold the bold to set
     */
    public void setBold(boolean bold);

    /**
     * @return the italic
     */
    public boolean isItalic();

    /**
     * @param italic the italic to set
     */
    public void setItalic(boolean italic);

    /**
     * @return the underline
     */
    public boolean isUnderline();

    /**
     * @param underline the underline to set
     */
    public void setUnderline(boolean underline);

    /**
     * @return the font
     */
    public Font getFont();

    /**
     * @param font the font to set
     */
    public void setFont(Font font);
}
