package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

/**
 * Break conditions are either break-before or break-after conditions. A
 * break-before condition is satisfied if the first area generated and returned
 * by the formatting object is leading within a context-area. A break-after
 * condition depends on the next formatting object in the flow; the condition is
 * satisfied if either there is no such next formatting object, or if the first
 * normal area generated and returned by that formatting object is leading in a
 * context-area.
 * 
 * @author David Hamilton
 *
 */
public interface FOBreaks extends GetOpenDocAttributes {
	final String BREAK_AFTER = "fo:break-after";
	final String BREAK_BEFORE = "fo:break-before";

	/**
	 * The available types of breaks
	 * 
	 * @author David Hamilton
	 *
	 */
	public enum BreakType {
		/**
		 * For a reference-area, this value is treated as if "block" had been specified.
		 * For any other area, this value is treated as if "line" had been specified.
		 */
		AUTO,
		/**
		 * Imposes a break-after condition with a context consisting of column-areas.
		 */
		COLUMN,
		/**
		 * Imposes a break-after condition with a context consisting of page-areas.
		 */
		PAGE;
	}

	/**
	 * The possible locations of the Break
	 * 
	 * @author David Hamilton
	 *
	 */
	public enum BreakLocation {
		/**
		 * A break-before condition is satisfied if the first area generated and
		 * returned by the formatting object is leading within a context-area.
		 */
		BEFORE,
		/**
		 * A break-after condition depends on the next formatting object in the flow;
		 * the condition is satisfied if either there is no such next formatting object,
		 * or if the first normal area generated and returned by that formatting object
		 * is leading in a context-area.
		 */
		AFTER;
	}

	/**
	 * Sets the break to be used
	 * 
	 * @param location
	 *            the break location
	 * @param breakType
	 *            the type of break
	 */
	public void setBreak(BreakLocation location, BreakType breakType);

	/**
	 * Gets the location of the break
	 * 
	 * @return the location of the break
	 */
	public BreakLocation getBreakLocation();

	/**
	 * Gets the break type used
	 * 
	 * @return the breaktype
	 */
	public BreakType getBreakType();
}