package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface FOBorders extends GetOpenDocAttributes {
	
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
