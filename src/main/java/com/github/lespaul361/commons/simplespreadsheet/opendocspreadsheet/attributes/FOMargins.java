package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOMargin.MarginLocations;

public interface FOMargins extends GetOpenDocAttributes {
	final String MARGIN = "fo:margin";
	final String MARGIN_BOTTOM = "fo:margin-bottom";
	final String MARGIN_TOP = "fo:margin-top";
	final String MARGIN_LEFT = "fo:margin-left";
	final String MARGIN_RIGHT = "fo:margin-right";

	/**
	 * Sets all margins to the percent provided
	 * 
	 * @param percent
	 *            the percent of the margin
	 */
	public void setMargin(FOMargin margin);

	/**
	 * Gets the Margin at the given location
	 * 
	 * @param location
	 *            the location of the margin
	 * @return the margin
	 */
	FOMargin getMargin(MarginLocations location);

}
