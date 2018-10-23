package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOBreaks extends GetOpenDocAttributes {
	final String BACKGROUND_COLOR = "fo:background-color";
	final String BREAK_AFTER = "fo:break-after";
	final String BREAK_BEFORE = "fo:break-before";
	
	public enum Breaks {
		AUTO, COLUMN, PAGE;
	
	}
	
	public Color getBackGroundColor();
	
	public void setBackGroundColor(Color color);
	
	public void setBreakBefore(Breaks breakBefore);
	
	public Breaks getBreakBefore();
	
	public void setBreakAfter(Breaks breakAfter);
	
	public Breaks getBreakAfter();
}
