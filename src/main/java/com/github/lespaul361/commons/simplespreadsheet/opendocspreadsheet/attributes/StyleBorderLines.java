package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface StyleBorderLines extends GetOpenDocAttributes {
	final String BORDER_LINE_WIDTH = "style:border-line-width";
	final String BORDER_LINE_WIDTH_LEFT = "style:border-line-width-left";
	final String BORDER_LINE_WIDTH_RIGHT = "style:border-line-width-right";
	final String BORDER_LINE_WIDTH_TOP = "style:border-line-width-top";
	final String BORDER_LINE_WIDTH_BOTTOM = "style:border-line-width-bottom";
	
	void setBorderLineWidth(StyleBorderLine line);
	
	void setBorderLineWidthLeft(StyleBorderLine line);
	
	void setBorderLineWidthRight(StyleBorderLine line);
	
	void setBorderLineWidthTop(StyleBorderLine line);
	
	void setBorderLineWidthBottom(StyleBorderLine line);
	
	StyleBorderLine getLineWidthRight();
	
	StyleBorderLine getLineWidthLeft();
	
	StyleBorderLine getLineWidthTop();
	
	StyleBorderLine getLineWidthBottom();
}
