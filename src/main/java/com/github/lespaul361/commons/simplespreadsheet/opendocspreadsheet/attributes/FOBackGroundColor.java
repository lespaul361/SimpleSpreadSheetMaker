package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOBackGroundColor extends GetOpenDocAttributes, FOColor {
	/**
	 * The open doc attribute name
	 */
	final String Back_Ground_Color = "fo:background-color";

	/**
	 * Gets the color of the background
	 * 
	 * @return the color
	 */
	Color getBackGroundColor();

	/**
	 * Sets the color of the background
	 * 
	 * @param c
	 *            the color to use
	 */
	void setBackGroundColor(Color c);

	/**
	 * Default method that uses {@link getBackGroundColor} to make a hex value. Null
	 * is possible
	 * 
	 * @return the hex value as string or null
	 */
	default String toHexString() {
		String s = getBackGroundColor() == null ? null : FOColor.toHex(getBackGroundColor());
		return s;
	}
}
