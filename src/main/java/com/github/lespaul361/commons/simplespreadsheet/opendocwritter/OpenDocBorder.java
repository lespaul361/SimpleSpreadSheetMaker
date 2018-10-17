package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;

class OpenDocBorder implements Border {
	private Color color = null;
	private Float width = null;
	private BorderStyles borderStyle = null;
	
	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}
	
	@Override
	public Color getColor() {
		return this.color;
	}
	
	@Override
	public void setWidth(Float width) {
		this.width = width;
	}
	
	@Override
	public Float getWidth() {
		return this.width;
	}
	
	@Override
	public void setBorderStyle(BorderStyles style) {
		this.borderStyle = style;
		
	}
	
	@Override
	public BorderStyles getBorderStyle() {
		return this.borderStyle;
		
	}
	
}
