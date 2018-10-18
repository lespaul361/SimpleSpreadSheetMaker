package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.Border;

class OpenDocBorder implements FOBorder {
	private Color color = null;
	private Float width = null;
	private BorderStyles borderStyle = null;
	//private final int WIDTH = 0;
	//private final int STYLE = 1;
	//private final int COLOR = 2;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		
	}
	
	private Attribute getAttribute() {
		
	}
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
	
	/*
	 * (non-Javadoc)
	 * 
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
	
	/*
	 * (non-Javadoc)
	 * 
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
	
}
