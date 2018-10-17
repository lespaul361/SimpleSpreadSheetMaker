package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

interface FOPaddings extends GetOpenDocAttributes{
	final String PADDING = "fo:padding";
	final String PADDING_BOTTOM = "fo:padding-bottom";
	final String PADDING_LEFT = "fo:padding-left";
	final String PADDING_RIGHT = "fo:padding-right";
	final String PADDING_TOP = "fo:padding-top";
	
	void setFloat(Float padding);
	
	void setTop(Float padding);
	
	Float getTop();
	
	void setBottom(Float padding);
	
	Float getBottom();
	
	void setLeft(Float padding);
	
	Float getLeft();
	
	void setRight(Float padding);
	
	Float getRight();
}
