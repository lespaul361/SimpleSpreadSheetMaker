package com.github.lespaul361.commons.simplespreadsheet;

import org.junit.validator.PublicClassValidator;

interface FOMargins extends GetOpenDocAttributes{
	public void setMargin(float percent);
	
	public float getMargin();
	
	public void setMarginBottom(float percent);
	
	public float getMarginBottom();
	
	public void setMarginTop(float percent);
	
	public float getMarginTop();
	
	public void setMarginLeft(float percent);
	
	public float getMarginRight();
}
