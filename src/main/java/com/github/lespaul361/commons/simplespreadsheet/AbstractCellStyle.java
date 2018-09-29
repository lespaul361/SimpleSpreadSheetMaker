/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * An abstract class with the basics of setting up a cell's style. The default
 * font is Arial size 10
 * 
 * @author David Hamilton
 */
public abstract class AbstractCellStyle implements ICellStyle {

	public static final String PROP_BOLD = "PROP_BOLD";
	public static final String PROP_ITALIC = "PROP_ITALIC";
	public static final String PROP_UNDERLINE = "PROP_UNDERLINE";
	public static final String PROP_FONT = "PROP_FONT";
	protected Font font;
	private boolean isUnderlined = false;
	private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

	/**
	 * Creates a new instance of the class
	 *
	 */
	public AbstractCellStyle() {
		Font font = new Font("Arial", Font.PLAIN, 10);
	}

	/**
	 * @return the bold
	 */
	public boolean isBold() {
		return font.isBold();
	}

	/**
	 * @param bold
	 *            the bold to set
	 */
	public void setBold(boolean bold) {
		if (font.isBold() == bold) {
			return;
		}
		propertyChangeSupport.firePropertyChange(PROP_BOLD, font.isBold(), bold);
	}

	/**
	 * @return the italic
	 */
	public boolean isItalic() {
		return font.isItalic();
	}

	/**
	 * @param italic
	 *            the italic to set
	 */
	public void setItalic(boolean italic) {
		if (font.isItalic() == italic) {
			return;
		}
		propertyChangeSupport.firePropertyChange(PROP_ITALIC, font.isItalic(), italic);
	}

	/**
	 * @return the underline
	 */
	public boolean isUnderline() {
		return this.isUnderlined;
	}

	/**
	 * @param underline
	 *            the underline to set
	 */
	public void setUnderline(boolean underline) {
		if (underline == this.isUnderlined) {
			return;
		}
		this.isUnderlined = underline;
		propertyChangeSupport.firePropertyChange(PROP_UNDERLINE, this.isUnderlined, underline);
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font
	 *            the font to set
	 */
	public void setFont(Font font) {
		java.awt.Font oldFont = this.font;
		this.font = font;
		propertyChangeSupport.firePropertyChange(PROP_FONT, oldFont, font);
	}

	/**
	 * Add a PropertyChangeListener for a specific property. The listener will be
	 * invoked only when a call on firePropertyChange names that specific property.
	 * The same listener object may be added more than once. For each property, the
	 * listener will be invoked the number of times it was added for that property.
	 * If propertyName or listener is null, no exception is thrown and no action is
	 * taken.
	 *
	 * @param listener
	 *            the PropertyChangeListener to add
	 * @see PropertyChangeListener
	 * @see PropertyChangeSupport
	 */
	public void addNotificationListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Add a PropertyChangeListener for a specific property. The listener will be
	 * invoked only when a call on firePropertyChange names that specific property.
	 * The same listener object may be added more than once. For each property, the
	 * listener will be invoked the number of times it was added for that property.
	 * If propertyName or listener is null, no exception is thrown and no action is
	 * taken.
	 *
	 * @param propertyName
	 *            - The name of the property to listen on.
	 * @param listener
	 *            - The PropertyChangeListener to be added
	 * @see PropertyChangeListener
	 * @see PropertyChangeSupport
	 */
	public void addNotificationListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@Override
	public List<String> getAvailableFontFamilyNames() {
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		return Arrays.asList(fonts);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + (this.isUnderlined ? 1 : 0);
		hash = 83 * hash + Objects.hashCode(this.font);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ICellStyle)) {
			return false;
		}
		return this.equals((ICellStyle) obj);
	}

}
