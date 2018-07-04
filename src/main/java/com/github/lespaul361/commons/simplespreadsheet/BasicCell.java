/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author David Hamilton
 */
public class BasicCell extends AbstractCell implements Serializable {

    private static final long serialVersionUID = -5294506904949593L;

    private BasicCell(Sheet sheet) {
        super.sheet = sheet;
    }

    @Override
    public BasicCell createInstance(Sheet sheet) {
        return new BasicCell(sheet);
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
        return (other.hashCode() == obj.hashCode());
    }

}
