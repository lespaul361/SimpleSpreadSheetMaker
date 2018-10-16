package com.github.lespaul361.commons.simplespreadsheet;

import org.ini4j.BasicProfile;

interface Style extends GetOpenDocAttributes{
	public enum WritingModes{lrtb, rltb, tbrl, tblr, lr, rl,
		tb,page, Null;}
	
	public void setMayBreakBetweenRows(boolean isBreak);
	
	public boolean isMayBreakBetweenRows();
	
	/**
	 * -1 is auto. -2 is null
	 * 
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber);
	
	/**
	 * 
	 * @return -1 is auto. -2 is null
	 */
	public int getPageNumber();
	
	public void setRelWidth(float percent);
	
	public float getRelWidth();
	
	public void setShadow(String shadow);
	
	public String getShadow();
	
	public void setWidth(float width);
	
	public float getWidth();
	
	public void setWritingMode(WritingModes writingMode);
	
	public WritingModes getWritingMode();
}
