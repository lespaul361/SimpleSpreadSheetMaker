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

	default String toHexString() {
		return FOColor.toHex(getBackGroundColor());
	}
}
