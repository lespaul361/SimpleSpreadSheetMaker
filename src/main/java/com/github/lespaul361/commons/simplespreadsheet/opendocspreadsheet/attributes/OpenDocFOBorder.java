package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class OpenDocFOBorder implements FOBorder {
	private Color color = null;
	private Float width = null;
	private BorderStyles borderStyle = null;
	private final BorderLocations borderLocation;
	// private final int WIDTH = 0;
	// private final int STYLE = 1;
	// private final int COLOR = 2;

	public OpenDocFOBorder(BorderLocations location) {
		this.borderLocation = location;
	}

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		Attribute att = getAttribute();
		if (att == null) {
			return ret;
		}
		ret.add(att);
		return ret;
	}

	private Attribute getAttribute() {
		if (color == null & width == null && borderStyle == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(30);
		if (width != null) {
			sb.append(width).append("px").append(" ");
		}
		if (borderStyle != null) {
			sb.append(borderStyle.toString()).append(" ");
		}
		if (color != null) {
			sb.append(OpenDocColor.toHex(color));
		}
		String retString = sb.toString();
		retString = retString.trim();
		Attribute att = new Attribute(borderLocation.toFOString(), retString);
		return att;
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
		result = prime * result + ((borderStyle == null) ? 0 : borderStyle.hashCode());
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OpenDocFOBorder)) {
			return false;
		}
		OpenDocFOBorder other = (OpenDocFOBorder) obj;
		if (borderStyle != other.borderStyle) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (width == null) {
			if (other.width != null) {
				return false;
			}
		} else if (!width.equals(other.width)) {
			return false;
		}
		return true;
	}

}
