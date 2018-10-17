package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

interface Style extends GetOpenDocAttributes {
	final String IS_BREAK = "style:may-break-between-rows";
	final String PAGE_NUMBER = "style:page-number";
	final String REL_WIDTH = "style:rel-width";
	final String WIDTH = "style:width";
	final String SHADOW = "style:shadow";
	final String WRITING_MODE = "style:writing-mode";
	
	public enum WritingModes {
		lrtb, rltb, tbrl, tblr, lr, rl, tb, page;
	}
	
	public void setMayBreakBetweenRows(Boolean isBreak);
	
	public Boolean isMayBreakBetweenRows();
	
	/**
	 * -1 is auto. -2 is null
	 * 
	 * @param pageNumber
	 */
	public void setPageNumber(Integer pageNumber);
	
	/**
	 * 
	 * @return -1 is auto. -2 is null
	 */
	public Integer getPageNumber();
	
	public void setRelWidth(Float percent);
	
	public Float getRelWidth();
	
	public void setShadow(String shadow);
	
	public String getShadow();
	
	public void setWidth(Float width);
	
	public Float getWidth();
	
	public void setWritingMode(WritingModes writingMode);
	
	public WritingModes getWritingMode();
}
