package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.properties;

import java.awt.Color;
import java.util.List;

import org.jdom.Attribute;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBackGroundColor;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBackGroundColorImp;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.BreakLocation;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.BreakType;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.Breaks;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaksImp;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOMargins;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocTable;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.CellProtectionTypes;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.ShadowTypes;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.WritingModes;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Table;

public class OpenDocTableProperty extends AbstractOpenDocProperty {
	private final static String STYLE_PROP = "style:table-properties";
	private final FOBackGroundColor foBG = new FOBackGroundColorImp();
	private final FOBreaks foBreaks = new FOBreaksImp();

	public OpenDocTableProperty() {
		super(STYLE_PROP);
	}

	/**
	 * Gets the color of the background
	 * 
	 * @return the color
	 */
	public Color getBackGroundColor() {
		return foBG.getBackGroundColor();
	}

	/**
	 * Sets the color of the background
	 * 
	 * @param c
	 *            the color to use
	 */
	public void setBackGroundColor(Color c) {
		foBG.setBackGroundColor(c);
		createElement();
	}

	/**
	 * Sets the break to be used
	 * 
	 * @param location
	 *            the break location
	 * @param breakType
	 *            the type of break
	 */
	public void setBreak(BreakLocation location, BreakType breakType) {
		foBreaks.setBreak(location, breakType);
		createElement();
	}

	/**
	 * Gets the location of the break
	 * 
	 * @return the location of the break
	 */
	public BreakLocation getBreakLocation() {
		return foBreaks.getBreakLocation();
	}

	/**
	 * Gets the break type used
	 * 
	 * @return the breaktype
	 */
	public BreakType getBreakType() {
		return foBreaks.getBreakType();
	}

	@Override
	void refreshAttributeContainers() {
		addAttributes(this.foBG);
		addAttributes(this.foBreaks);
	}

}
