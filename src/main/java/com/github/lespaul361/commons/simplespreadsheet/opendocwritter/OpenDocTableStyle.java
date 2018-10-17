package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.AbstractOpenDocStyle.Properties;
import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.FOBreaks.Breaks;
import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Style.WritingModes;
import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Table.BorderModels;
import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Table.TableAlignments;
import com.itextpdf.text.Font.FontFamily;

class OpenDocTableStyle extends AbstractOpenDocStyle {
	private Element thisElement = null;
	private final String STYLE_PROP = "style:table-properties";
	private final String TBL_DISPLAY = "table:display";
	private final OpenDocFOBreaks foBreaks = new OpenDocFOBreaks();
	private final OpenDocFOMargin foMargin = new OpenDocFOMargin();
	private final OpenDocStyle style = new OpenDocStyle();
	private final OpenDocTable table = new OpenDocTable();
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#getBackGroundColor()
	 */
	public Color getBackGroundColor() {
		return foBreaks.getBackGroundColor();
	}
	
	/**
	 * @param color
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#setBackGroundColor(java.awt.Color)
	 */
	public void setBackGroundColor(Color color) {
		foBreaks.setBackGroundColor(color);
		createThisElement();
	}
	
	/**
	 * @param breakBefore
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#setBreakBefore(com.github.lespaul361.commons.simplespreadsheet.opendocwritter.FOBreaks.Breaks)
	 */
	public void setBreakBefore(Breaks breakBefore) {
		foBreaks.setBreakBefore(breakBefore);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#getBreakBefore()
	 */
	public Breaks getBreakBefore() {
		return foBreaks.getBreakBefore();
	}
	
	/**
	 * @param breakAfter
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#setBreakAfter(com.github.lespaul361.commons.simplespreadsheet.opendocwritter.FOBreaks.Breaks)
	 */
	public void setBreakAfter(Breaks breakAfter) {
		foBreaks.setBreakAfter(breakAfter);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOBreaks#getBreakAfter()
	 */
	public Breaks getBreakAfter() {
		return foBreaks.getBreakAfter();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMargin(float)
	 */
	public void setMargin(float percent) {
		foMargin.setMargin(percent);
		createThisElement();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginBottom(float)
	 */
	public void setMarginBottom(float percent) {
		foMargin.setMarginBottom(percent);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#getMarginBottom()
	 */
	public float getMarginBottom() {
		return foMargin.getMarginBottom();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginTop(float)
	 */
	public void setMarginTop(float percent) {
		foMargin.setMarginTop(percent);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#getMarginTop()
	 */
	public float getMarginTop() {
		return foMargin.getMarginTop();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginLeft(float)
	 */
	public void setMarginLeft(float percent) {
		foMargin.setMarginLeft(percent);
		createThisElement();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginRight(float)
	 */
	public void setMarginRight(float percent) {
		foMargin.setMarginRight(percent);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#getMarginRight()
	 */
	public float getMarginRight() {
		return foMargin.getMarginRight();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#getMarginLeft()
	 */
	public float getMarginLeft() {
		return foMargin.getMarginLeft();
	}
	
	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginBottom(int)
	 */
	public void setMarginBottom(int sz) {
		foMargin.setMarginBottom(sz);
		createThisElement();
	}
	
	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginTop(int)
	 */
	public void setMarginTop(int sz) {
		foMargin.setMarginTop(sz);
		createThisElement();
	}
	
	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMarginLeft(int)
	 */
	public void setMarginLeft(int sz) {
		foMargin.setMarginLeft(sz);
		createThisElement();
	}
	
	/**
	 * @param sz
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocFOMargin#setMargineRight(int)
	 */
	public void setMargineRight(int sz) {
		foMargin.setMargineRight(sz);
		createThisElement();
	}
	
	/**
	 * @param isBreak
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setMayBreakBetweenRows(java.lang.Boolean)
	 */
	public void setMayBreakBetweenRows(Boolean isBreak) {
		style.setMayBreakBetweenRows(isBreak);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#isMayBreakBetweenRows()
	 */
	public Boolean isMayBreakBetweenRows() {
		return style.isMayBreakBetweenRows();
	}
	
	/**
	 * @param pageNumber
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setPageNumber(java.lang.Integer)
	 */
	public void setPageNumber(Integer pageNumber) {
		style.setPageNumber(pageNumber);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#getPageNumber()
	 */
	public Integer getPageNumber() {
		return style.getPageNumber();
	}
	
	/**
	 * @param percent
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setRelWidth(java.lang.Float)
	 */
	public void setRelWidth(Float percent) {
		style.setRelWidth(percent);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#getRelWidth()
	 */
	public Float getRelWidth() {
		return style.getRelWidth();
	}
	
	/**
	 * @param shadow
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setShadow(java.lang.String)
	 */
	public void setShadow(String shadow) {
		style.setShadow(shadow);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#getShadow()
	 */
	public String getShadow() {
		return style.getShadow();
	}
	
	/**
	 * @param width
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setWidth(java.lang.Float)
	 */
	public void setWidth(Float width) {
		style.setWidth(width);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#getWidth()
	 */
	public Float getWidth() {
		return style.getWidth();
	}
	
	/**
	 * @param writingMode
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#setWritingMode(com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Style.WritingModes)
	 */
	public void setWritingMode(WritingModes writingMode) {
		style.setWritingMode(writingMode);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocStyle#getWritingMode()
	 */
	public WritingModes getWritingMode() {
		return style.getWritingMode();
	}
	
	/**
	 * @param align
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#setAlign(com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Table.TableAlignments)
	 */
	public void setAlign(TableAlignments align) {
		table.setAlign(align);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#getAlign()
	 */
	public TableAlignments getAlign() {
		return table.getAlign();
	}
	
	/**
	 * @param b
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#setDisplay(java.lang.Boolean)
	 */
	public void setDisplay(Boolean b) {
		table.setDisplay(b);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#isDisplay()
	 */
	public Boolean isDisplay() {
		return table.isDisplay();
	}
	
	/**
	 * @param borderModel
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#setBorderModel(com.github.lespaul361.commons.simplespreadsheet.opendocwritter.Table.BorderModels)
	 */
	public void setBorderModel(BorderModels borderModel) {
		table.setBorderModel(borderModel);
		createThisElement();
	}
	
	/**
	 * @return
	 * @see com.github.lespaul361.commons.simplespreadsheet.opendocwritter.OpenDocTable#getBorderModel()
	 */
	public BorderModels getBorderModel() {
		return table.getBorderModel();
	}
	
	@Override
	public void write(Element parentElement) {
		createThisElement();
		parentElement.addContent(thisElement);
	}
	
	@Override
	public String toString() {
		return thisElement.toString();
	}
	
	private void createThisElement() {
		Element element = new Element(super.STYLE_HEADER);
		List<Attribute> attributes = new ArrayList<>();
		attributes.add(new Attribute(STYLE_FAMILY, family));
		attributes.add(new Attribute(STYLE_NAME, name));
		element.setAttributes(attributes);
		Element subElement = new Element(STYLE_PROP);
		attributes = new ArrayList<>();
		attributes.addAll(this.foBreaks.getAttributes());
		attributes.addAll(this.foMargin.getAttributes());
		attributes.addAll(this.style.getAttributes());
		attributes.addAll(this.table.getAttributes());
		subElement.setAttributes(attributes);
		element.addContent(subElement);
		this.thisElement = element;
	}
}
