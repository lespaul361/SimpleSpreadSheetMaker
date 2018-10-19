package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface FOBorders extends GetOpenDocAttributes {
	final String BORDER = "fo:border";
	final String BORDER_BOTTOM = "fo:border-bottom";
	final String BORDER_LEFT = "fo:border-left";
	final String BORDER_RIGHT = "fo:border-right";
	final String BORDER_TOP = "fo:border-top";
	
	void setBorder(FOBorder border);
	
	void setTop(FOBorder border);
	
	FOBorder getTop();
	
	void setBottom(FOBorder border);
	
	FOBorder getBottom();
	
	void setLeft(FOBorder border);
	
	FOBorder getLeft();
	
	void setRight(FOBorder border);
	
	FOBorder getRight();
	
}
