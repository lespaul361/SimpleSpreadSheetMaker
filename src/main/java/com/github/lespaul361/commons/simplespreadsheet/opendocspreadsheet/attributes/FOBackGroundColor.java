package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOBackGroundColor extends GetOpenDocAttributes {
	final String Back_Ground_Color="fo:background-color";
	Color getBackGroundColor();
	void setBackGroundColor(Color c);
}
