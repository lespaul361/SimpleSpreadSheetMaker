package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface FOBorders extends GetOpenDocAttributes {
	/**
	 * Sets a value for all the borders
	 * 
	 * @param border
	 *            value for all borders
	 */
	void setBorder(FOBorder border);

	/**
	 * Sets a value for the top border
	 * 
	 * @param border
	 *            the border to use
	 */
	void setTopBorder(FOBorder border);

	/**
	 * Gets the top border
	 * 
	 * @return the border
	 */
	FOBorder getTopBorder();

	/**
	 * Sets a value for the bottom border
	 * 
	 * @param border
	 *            the border to use
	 */
	void setBottomBorder(FOBorder border);

	/**
	 * Gets the bottom border
	 * 
	 * @return the border
	 */
	FOBorder getBottomBorder();

	/**
	 * Sets a value for the left border
	 * 
	 * @param border
	 *            the border to use
	 */
	void setLeftBorder(FOBorder border);

	/**
	 * Gets the left border
	 * 
	 * @return the border
	 */
	FOBorder getLeftBorder();

	/**
	 * Sets a value for the right border
	 * 
	 * @param border
	 *            the border to use
	 */
	void setRightBorder(FOBorder border);

	/**
	 * Gets the right border
	 * 
	 * @return the border
	 */
	FOBorder getRightBorder();

}
