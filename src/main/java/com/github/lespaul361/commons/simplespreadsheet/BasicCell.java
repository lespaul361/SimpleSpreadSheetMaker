/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import static java.util.Arrays.asList;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 *
 * @author David Hamilton
 */
public class BasicCell extends AbstractCell implements Serializable {

    private static final long serialVersionUID = -5294506904949593L;

    BasicCell(Sheet sheet) {
        super();
        this.sheet = sheet;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BasicCell other = (BasicCell) obj;
        return (other.hashCode() == hashCode());
    }

    /**
     * Creates a copy of this cell
     *
     * @return a Cell that is a copy of this cell with the notifications
     * included
     */
    @Override
    public Cell clone() {
        BasicCell cell = new BasicCell(sheet);
        cell.function = super.function;
        cell.row = row;
        cell.column = column;
        cell.style = style;
        cell.text = text;
        for (PropertyChangeListener l : asList(propertyChangeSupport.getPropertyChangeListeners())) {
            cell.addNotificationListener(l);
        }
        return cell;
    }
}
