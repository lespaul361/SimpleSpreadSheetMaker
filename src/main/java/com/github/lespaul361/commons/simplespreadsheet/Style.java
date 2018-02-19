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
public interface Style {

    public void setBold(boolean b);

    public void setItalic(boolean b);

    public boolean isBold();

    public boolean isItalic();
}
