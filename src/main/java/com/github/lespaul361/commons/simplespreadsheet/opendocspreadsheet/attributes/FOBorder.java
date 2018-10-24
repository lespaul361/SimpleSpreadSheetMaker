package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOBorder extends GetOpenDocAttributes {
	/**
	 * the line styles available for open document borders
	 * 
	 * @author David Hamilton
	 *
	 */
	enum BorderStyles {
		/**
		 * No border; the computed border width is zero.
		 */
		NONE,
		/**
		 * Same as 'none', except in terms of border conflict resolution for table
		 * elements.
		 */
		HIDDEN,
		/**
		 * The border is a series of dots.
		 */
		DOTTED,
		/**
		 * The border is a series of short line segments.
		 */
		DASHED,
		/**
		 * The border is two solid lines. The sum of the two lines and the space between
		 * them equals the value of 'border-width'.
		 */
		DOUBLE,
		/**
		 * The border is a single line segment.
		 */
		SOLID,
		/**
		 * The border looks as though it were carved into the canvas.
		 */
		GROOVE,
		/**
		 * The opposite of 'groove': the border looks as though it were coming out of
		 * the canvas.
		 */
		RIDGE,
		/**
		 * The border makes the box look as though it were embedded in the canvas.
		 */
		INSET,
		/**
		 * The opposite of 'inset': the border makes the box look as though it were
		 * coming out of the canvas.
		 */
		OUTSET;
		/**
		 * Gets the hashcode for this enumerator
		 * 
		 * @return a long with the hashcode
		 */
		public long hashcode() {
			byte[] buffer = toString().getBytes();
			long ret = 0;
			int magNum = 3;
			for (byte b : buffer) {
				ret += b * magNum;
			}
			return ret;
		}

		/**
		 * Gets the name as used in the attribute
		 */
		public String toString() {
			return this.name().toLowerCase();
		}

		/**
		 * Uses the hashcode to check if this is equal to the given style
		 * 
		 * @param style
		 *            the style to check against
		 * @return true if they are equal otherwise false
		 */
		public boolean equals(BorderStyles style) {
			if (style.hashcode() != style.hashcode()) {
				return false;
			}
			return true;
		}
	}

	/**
	 * The possible location of the border
	 * 
	 * @author David Hamilton
	 *
	 */
	enum BorderLocations {
		/**
		 * Use for all borders
		 */
		BORDER,
		/**
		 * The left border
		 */
		BORDER_LEFT,
		/**
		 * The right border
		 */
		BORDER_RIGHT,
		/**
		 * The top border
		 */
		BORDER_TOP,
		/**
		 * The bottom border
		 */
		BORDER_BOTTOM;

		/**
		 * The hashcode for this enum generated by the name selected
		 * 
		 * @return a long with the hashcode
		 */
		public long hashcode() {
			byte[] buffer = toString().getBytes();
			long ret = 0;
			int magNum = 89;
			for (byte b : buffer) {
				ret += b * magNum;
			}
			return ret;
		}

		/**
		 * Gets the name in attribute form
		 */
		public String toString() {
			String s = this.name();
			s = s.toLowerCase();
			s = s.replace("_", "-");
			return s;
		}

		/**
		 * Gets the FO tag name
		 * 
		 * @return the FO tag name
		 */
		public String toFOString() {
			return "fo:" + this.toString();
		}

		/**
		 * Checks if this is equal to the provided
		 * 
		 * @param location
		 *            the location to check against
		 * @return true if they are equal and false if they are not.
		 */
		public boolean equals(BorderLocations location) {
			if (location.hashcode() != location.hashcode()) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Sets the color of the border
	 * 
	 * @param color
	 *            the color
	 */
	void setBorderColor(Color color);

	/**
	 * Gets the color of the border
	 * 
	 * @return the color
	 */
	Color getBorderColor();

	/**
	 * Sets the width as a percent
	 * 
	 * @param widthPercent
	 *            the percent
	 */
	void setBorderWidth(Float widthPercent);

	/**
	 * Sets the width in pixels
	 * 
	 * @param width
	 *            the pixel width
	 */
	void setBorderWidth(Integer width);

	/**
	 * Gets the width. Check with {@link isborderWidthPercent} to see if it is a
	 * percentage value
	 * 
	 * @return the width
	 */
	Float getWidth();

	/**
	 * Checks if the boader width is stored as a percentage
	 * 
	 * @return true if it is a percentage and false if it is in pixels
	 */
	boolean isborderWidthPercent();

	/**
	 * Sets the way the border line should be drawn
	 * 
	 * @param style
	 *            the style of the border
	 */
	void setBorderStyle(BorderStyles style);

	/**
	 * Gets the style of the border
	 * 
	 * @return the border style
	 */
	BorderStyles getBorderStyle();
}
