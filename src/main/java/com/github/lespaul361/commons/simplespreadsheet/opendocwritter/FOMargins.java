package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import org.junit.validator.PublicClassValidator;

interface FOMargins extends GetOpenDocAttributes {
	final String MARGIN = "fo:margin";
	final String MARGIN_BOTTOM = "fo:margin-bottom";
	final String MARGIN_TOP = "fo:margin-top";
	final String MARGIN_LEFT = "fo:margin-left";
	final String MARGIN_RIGHT = "fo:margin-right";
	
	public void setMargin(float percent);
	
	public void setMarginBottom(float percent);
	
	public float getMarginBottom();
	
	public void setMarginTop(float percent);
	
	public float getMarginTop();
	
	public void setMarginLeft(float percent);
	
	public void setMarginRight(float percent);
	
	public float getMarginRight();
	
	public float getMarginLeft();
	
	public void setMarginBottom(int sz);
	
	public void setMarginTop(int sz);
	
	public void setMarginLeft(int sz);
	
	public void setMargineRight(int sz);
}
