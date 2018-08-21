/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet.exceptions;

import java.awt.Point;

/**
 * An <code>Exception<code> class for when an add will interupt existing data.
 *
 * @author David Hamilton
 */
public class LocationExistsException extends Exception {

    private static final String MESSAGE = "location already has cell(s)";
    private final Point point;

    /**
     * Creates a new <code>LocationExistsException<code>
     *
     * @param Point the location of the first instance the new data interupts
     */
    public LocationExistsException(Point point) {
        super(MESSAGE);
        this.point = point;
    }

    /**
     * The cell coordinates that are being used
     *
     * @return the Point
     * @see Point
     */
    public Point getPoint() {
        return this.point;
    }

}
