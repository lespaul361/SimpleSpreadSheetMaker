package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Color;

interface FOBreaks extends GetOpenDocAttributes {
	public enum Breaks {
		AUTO, COLUMN, PAGE, NONE;
	}
	
	public Color getBackGroundColor(Color color);
	
	public void setBackGroundColor();
	
	public void setBreakBefore(Breaks breakBefore);
	
	public Breaks getBreakBefore();
	
	public void setBreakAfter(Breaks breakBefore);
	
	public Breaks getBreakAfter();
}
