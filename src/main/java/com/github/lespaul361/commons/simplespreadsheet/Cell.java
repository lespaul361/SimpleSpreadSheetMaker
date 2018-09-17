/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.beans.PropertyChangeListener;

/**
 *
 * @author David Hamilton
 */
public interface Cell extends Cloneable {

    public static final String PROP_ROW = "PROP_ROW";
    public static final String PROP_COLUMN = "PROP_COLUMN";
    public static final String PROP_TEXT = "PROP_TEXT";
    public static final String PROP_FUNCTION = "PROP_FUNCTION";
    public static final String PROP_STYLE = "PROP_STYLE";

    /**
     * Gets the row number. 0 based.
     *
     * @return the row number. 0 based
     */
    public int getRowNumber();

    /**
     * Sets the row number. 0 based.
     *
     * @param row the integer value of the row. 0 based
     */
    public void setRowNumber(int row);

    /**
     * Gets the column number. 0 based.
     *
     * @return the column number. 0 based
     */
    public int getColumnNumber();

    /**
     * Sets the column number. 0 based.
     *
     * @param column the integer value of the column. 0 based
     */
    public void setColumnNumber(int column);

    /**
     * Gets the text value of the cell
     *
     * @return a String with the cell value
     */
    public String getText();

    /**
     * Sets the text value of the cell
     *
     * @param text A String with the text
     */
    public void setText(String text);

    /**
     * Gets the {@link Function} function of the cell
     *
     * @return the {@link Function} function used in this cell;
     */
    public Function getFunction();

    /**
     * Sets the {@link Function} of this cell
     *
     * @param function the {@link Function} function to use for this cell
     */
    public void setFunction(Function function);

    /**
     * Add a PropertyChangeListener for property changes.
     *
     * @param listener the PropertyChangeListener to add
     * @see PropertyChangeListener
     * @see java.beans.PropertyChangeSupport
     */
    public void addNotificationListener(PropertyChangeListener listener);

    /**
     * Add a PropertyChangeListener for a specific property. The listener will
     * be invoked only when a call on firePropertyChange names that specific
     * property. The same listener object may be added more than once. For each
     * property, the listener will be invoked the number of times it was added
     * for that property. If propertyName or listener is null, no exception is
     * thrown and no action is taken.
     *
     * @param propertyName - The name of the property to listen on.
     * @param listener - The PropertyChangeListener to be added
     * @see PropertyChangeListener
     * @see java.beans.PropertyChangeSupport
     */
    public void addNotificationListener(String propertyName, PropertyChangeListener listener);

    /**
     * Remove a PropertyChangeListener property changes.
     *
     * @param listener the PropertyChangeListener to add
     * @see PropertyChangeListener
     * @see java.beans.PropertyChangeSupport
     */
    public void removeNotificationListener(PropertyChangeListener listener);

    /**
     * Remove a PropertyChangeListener for a specific property. If propertyName
     * or listener is null, no exception is thrown and no action is taken.
     *
     * @param propertyName - The name of the property to listen on.
     * @param listener - The PropertyChangeListener to be added
     * @see PropertyChangeListener
     * @see java.beans.PropertyChangeSupport
     */
    public void removeNotificationListener(String propertyName, PropertyChangeListener listener);

    /**
     * Gets the {@link Style} style of the cell
     *
     * @return the {@link Style} style
     */
    public Style getStyle();

    /**
     * Sets the {@link Style} style of the cell
     *
     * @param style the {@link Style} style to set for the cell
     */
    public void setStyle(Style style);

    public Object clone();
}
