package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface FOPaddings extends GetOpenDocAttributes{
	final String PADDING = "fo:padding";
	final String PADDING_BOTTOM = "fo:padding-bottom";
	final String PADDING_LEFT = "fo:padding-left";
	final String PADDING_RIGHT = "fo:padding-right";
	final String PADDING_TOP = "fo:padding-top";
	
	void setFloat(Float padding);
	
	void setTopPadding(Float padding);
	
	Float getTopPadding();
	
	void setBottomPadding(Float padding);
	
	Float getBottomPadding();
	
	void setLeftPadding(Float padding);
	
	Float getLeftPadding();
	
	void setRightPadding(Float padding);
	
	Float getRightPadding();
}
