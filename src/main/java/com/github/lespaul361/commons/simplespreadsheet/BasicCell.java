/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.Objects;

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
        int hash = 3;
        hash = 97 * hash + super.row;
        hash = 97 * hash + super.column;
        hash = 97 * hash + Objects.hashCode(super.text);
        hash = 97 * hash + Objects.hashCode(super.function);
        hash = 97 * hash + Objects.hashCode(super.style);
        hash = 97 * hash + Objects.hashCode(super.sheet);
        return hash;
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

    @Override
    Cell makeClone() {
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
