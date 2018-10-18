package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import org.apache.bcel.generic.FLOAD;

import com.google.common.base.FinalizablePhantomReference;

interface FOBorders extends GetOpenDocAttributes {
	final String BORDER = "fo:border";
	final String BORDER_BOTTOM = "fo:border-bottom";
	final String BORDER_LEFT = "fo:border-left";
	final String BORDER_RIGHT = "fo:border-right";
	final String BORDER_TOP = "fo:border-top";
	
	void setBorder(Border border);
	
	void setTop(Border border);
	
	Border getTop();
	
	void setBottom(Border border);
	
	Border getBottom();
	
	void setLeft(Border border);
	
	Border getLeft();
	
	void setRight(Border border);
	
	Border getRight();
	
}
