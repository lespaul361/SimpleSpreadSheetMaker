package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.Set;

interface Border {
	enum BorderStyles{NONE,HIDDEN,DOTTED,DASHED,DOUBLE,SOLID,GROOVE,RIDGE,INSET,OUTSET}
	void setColor(Color color);
	Color getColor();
	void setWidth(Float width);
	Float getWidth();
	void setBorderStyle(BorderStyles style)
	BorderStyles getBorderStyle();
}
