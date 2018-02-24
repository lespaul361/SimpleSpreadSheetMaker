/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.swing.JLabel;

/**
 *
 * @author David Hamilton
 */
public abstract class AbstractStyle implements Serializable,Style {

    public static final String PROP_BOLD = "PROP_BOLD";
    public static final String PROP_ITALIC = "PROP_ITALIC";
    public static final String PROP_UNDERLINE = "PROP_UNDERLINE";
    public static final String PROP_FONT = "PROP_FONT";
    private boolean bold = false;
    private boolean italic = false;
    private boolean underline = false;
    private Font font = new JLabel().getFont();
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private static final long serialVersionUID = -527559450690L;

    /**
     * Creates a new instance of the class
     *
     */
    public AbstractStyle() {
    }

    /**
     * @return the bold
     */
    public boolean isBold() {
        return bold;
    }

    /**
     * @param bold the bold to set
     */
    public void setBold(boolean bold) {
        boolean oldBold = this.bold;
        this.bold = bold;
        propertyChangeSupport.firePropertyChange(PROP_BOLD, oldBold, bold);
    }

    /**
     * @return the italic
     */
    public boolean isItalic() {
        return italic;
    }

    /**
     * @param italic the italic to set
     */
    public void setItalic(boolean italic) {
        boolean oldItalic = this.italic;
        this.italic = italic;
        propertyChangeSupport.firePropertyChange(PROP_ITALIC, oldItalic, italic);
    }

    /**
     * @return the underline
     */
    public boolean isUnderline() {
        return underline;
    }

    /**
     * @param underline the underline to set
     */
    public void setUnderline(boolean underline) {
        boolean oldUnderline = this.underline;
        this.underline = underline;
        propertyChangeSupport.firePropertyChange(PROP_UNDERLINE, oldUnderline, underline);
    }

    /**
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(Font font) {
        java.awt.Font oldFont = this.font;
        this.font = font;
        propertyChangeSupport.firePropertyChange(PROP_FONT, oldFont, font);
    }

    /**
     * Add a PropertyChangeListener for a specific property. The listener will
     * be invoked only when a call on firePropertyChange names that specific
     * property. The same listener object may be added more than once. For each
     * property, the listener will be invoked the number of times it was added
     * for that property. If propertyName or listener is null, no exception is
     * thrown and no action is taken.
     *
     * @param listener the PropertyChangeListener to add
     * @see PropertyChangeListener
     * @see PropertyChangeSupport
     */
    public void addNotificationListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

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
     * @see PropertyChangeSupport
     */
    public void addNotificationListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.bold ? 1 : 0);
        hash = 83 * hash + (this.italic ? 1 : 0);
        hash = 83 * hash + (this.underline ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.font);
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
        final Style other = (Style) obj;
        return true;
    }

}
