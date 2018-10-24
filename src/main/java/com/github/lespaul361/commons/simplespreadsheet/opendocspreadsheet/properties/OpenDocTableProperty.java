package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.properties;

import java.awt.Color;
import java.util.List;

import org.jdom.Attribute;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.Breaks;
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
	private final String STYLE_PROP = "style:table-properties";
	private final FOBreaks foBreaks = new OpenDocFOBreaks();
	private final FOMargins foMargins = new OpenDocFOMargins();
	private final Style style = new OpenDocStyle();
	private final Table table = new OpenDocTable();

	public OpenDocTableProperty() {
		super("style:table-properties");
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#getBackGroundColor()
	 */
	public Color getBackGroundColor() {
		return foBreaks.getBackGroundColor();
	}

	/**
	 * @param color
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#setBackGroundColor(java.awt.Color)
	 */
	public void setBackGroundColor(Color color) {
		foBreaks.setBackGroundColor(color);
		createElement();
	}

	/**
	 * @param breakBefore
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#setBreakBefore(com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.Breaks)
	 */
	public void setBreakBefore(Breaks breakBefore) {
		foBreaks.setBreakBefore(breakBefore);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#getBreakBefore()
	 */
	public Breaks getBreakBefore() {
		return foBreaks.getBreakBefore();
	}

	/**
	 * @param breakAfter
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#setBreakAfter(com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBreaks.Breaks)
	 */
	public void setBreakAfter(Breaks breakAfter) {
		foBreaks.setBreakAfter(breakAfter);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOBreaks#getBreakAfter()
	 */
	public Breaks getBreakAfter() {
		return foBreaks.getBreakAfter();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMargin(float)
	 */
	public void setMargin(float percent) {
		foMargins.setMargin(percent);
		createElement();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginBottom(float)
	 */
	public void setMarginBottom(float percent) {
		foMargins.setMarginBottom(percent);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#getMarginBottom()
	 */
	public float getMarginBottom() {
		return foMargins.getMarginBottom();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginTop(float)
	 */
	public void setMarginTop(float percent) {
		foMargins.setMarginTop(percent);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#getMarginTop()
	 */
	public float getMarginTop() {
		return foMargins.getMarginTop();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginLeft(float)
	 */
	public void setMarginLeft(float percent) {
		foMargins.setMarginLeft(percent);
		createElement();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginRight(float)
	 */
	public void setMarginRight(float percent) {
		foMargins.setMarginRight(percent);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#getMarginRight()
	 */
	public float getMarginRight() {
		return foMargins.getMarginRight();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#getMarginLeft()
	 */
	public float getMarginLeft() {
		return foMargins.getMarginLeft();
	}

	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginBottom(int)
	 */
	public void setMarginBottom(int sz) {
		foMargins.setMarginBottom(sz);
		createElement();
	}

	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginTop(int)
	 */
	public void setMarginTop(int sz) {
		foMargins.setMarginTop(sz);
		createElement();
	}

	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMarginLeft(int)
	 */
	public void setMarginLeft(int sz) {
		foMargins.setMarginLeft(sz);
		createElement();
	}

	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocFOMargins#setMargineRight(int)
	 */
	public void setMargineRight(int sz) {
		foMargins.setMargineRight(sz);
		createElement();
	}

	/**
	 * @param isBreak
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setMayBreakBetweenRows(java.lang.Boolean)
	 */
	public void setMayBreakBetweenRows(Boolean isBreak) {
		style.setMayBreakBetweenRows(isBreak);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#isMayBreakBetweenRows()
	 */
	public Boolean isMayBreakBetweenRows() {
		return style.isMayBreakBetweenRows();
	}

	/**
	 * @param pageNumber
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setPageNumber(java.lang.Integer)
	 */
	public void setPageNumber(Integer pageNumber) {
		style.setPageNumber(pageNumber);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#getPageNumber()
	 */
	public Integer getPageNumber() {
		return style.getPageNumber();
	}

	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setRelWidth(java.lang.Float)
	 */
	public void setRelWidth(Float percent) {
		style.setRelWidth(percent);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#getRelWidth()
	 */
	public Float getRelWidth() {
		return style.getRelWidth();
	}

	/**
	 * @param type
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style#setCellProtection(com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.CellProtectionTypes)
	 */
	public void setCellProtection(CellProtectionTypes type) {
		style.setCellProtection(type);
		createElement();
	}

	/**
	 * @param shadow
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setShadow(com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.ShadowTypes)
	 */
	public void setShadow(ShadowTypes shadow) {
		style.setShadow(shadow);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style#getCellProtection()
	 */
	public CellProtectionTypes getCellProtection() {
		return style.getCellProtection();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#getShadow()
	 */
	public ShadowTypes getShadow() {
		return style.getShadow();
	}

	/**
	 * @param width
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setWidth(java.lang.Float)
	 */
	public void setWidth(Float width) {
		style.setWidth(width);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#getWidth()
	 */
	public Float getWidth() {
		return style.getWidth();
	}

	/**
	 * @param writingMode
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#setWritingMode(com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Style.WritingModes)
	 */
	public void setWritingMode(WritingModes writingMode) {
		style.setWritingMode(writingMode);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocStyle#getWritingMode()
	 */
	public WritingModes getWritingMode() {
		return style.getWritingMode();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocTable#getAttributes()
	 */
	public List<Attribute> getAttributes() {
		return table.getAttributes();
	}

	/**
	 * @param b
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocTable#setDisplay(java.lang.Boolean)
	 */
	public void setDisplay(Boolean b) {
		table.setDisplay(b);
		createElement();
	}

	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.OpenDocTable#isDisplay()
	 */
	public Boolean isDisplay() {
		return table.isDisplay();
	}

	@Override
	void refreshAttributeContainers() {
		addAttributes(foBreaks);
		addAttributes(foMargins);
		addAttributes(style);
		addAttributes(table);

	}

}
