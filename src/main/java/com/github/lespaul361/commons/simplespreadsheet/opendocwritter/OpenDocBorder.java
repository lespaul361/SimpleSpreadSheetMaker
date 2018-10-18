package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Border;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((borderStyle == null) ? 0 : borderStyle.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof OpenDocBorder)) {
			return false;
		}
		OpenDocBorder other = (OpenDocBorder) obj;
		if(borderStyle != other.borderStyle) {
			return false;
		}
		if(color == null) {
			if(other.color != null) {
				return false;
			}
		} else if(!color.equals(other.color)) {
			return false;
		}
		if(width == null) {
			if(other.width != null) {
				return false;
			}
		} else if(!width.equals(other.width)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
	}
	
}
