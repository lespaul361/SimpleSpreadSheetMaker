package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBorder.BorderLocations;
import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOBorder.BorderStyles;

public class FOBorderImp implements FOBorder {
	private Color color = null;
	private Float width = null;
	private BorderStyles borderStyle = null;
	private final BorderLocations borderLocation;
	private boolean isPercent = false;

	// private final int WIDTH = 0;
	// private final int STYLE = 1;
	// private final int COLOR = 2;

	public FOBorderImp(BorderLocations borderLocation) {
		super();
		this.borderLocation = borderLocation;
	}

	public FOBorderImp(BorderStyles borderStyle, BorderLocations borderLocation) {
		super();
		this.borderStyle = borderStyle;
		this.borderLocation = borderLocation;
	}

	public FOBorderImp(Float width, BorderStyles borderStyle, BorderLocations borderLocation) {
		this(null, width, borderStyle, borderLocation);
	}

	public FOBorderImp(Integer width, BorderStyles borderStyle, BorderLocations borderLocation) {
		this(null, width, borderStyle, borderLocation);
	}

	public FOBorderImp(Color color, Float width, BorderStyles borderStyle, BorderLocations borderLocation) {
		super();
		this.color = color;
		this.width = width;
		this.borderStyle = borderStyle;
		this.borderLocation = borderLocation;
		this.isPercent = true;
	}

	public FOBorderImp(Color color, Integer width, BorderStyles borderStyle, BorderLocations borderLocation) {
		super();
		this.color = color;
		this.width = Float.parseFloat(width.toString());
		this.borderStyle = borderStyle;
		this.borderLocation = borderLocation;
		this.isPercent = false;
	}

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		String name = this.borderLocation.toFOString();
		StringBuilder sb = new StringBuilder(50);
		if (this.width != null) {
			this.width = Float.valueOf(1);
			this.isPercent = false;
		}
		sb.append(this.width.doubleValue());
		if (!this.isPercent) {
			sb.append("px ");
		}
		if (this.borderStyle != null) {
			sb.append(this.borderStyle.toString()).append(" ");
		}
		if (this.color == null) {
			color = Color.BLACK;
		}

		sb.append(FOColor.toHex(this.color)).append(" ");

		ret.add(new Attribute(name, sb.toString().trim()));
		return ret;
	}

	@Override
	public void setBorderColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getBorderColor() {
		return this.color;
	}

	@Override
	public void setBorderWidth(Float widthPercent) {
		this.isPercent = true;
		this.width = widthPercent;
	}

	@Override
	public void setBorderWidth(Integer width) {
		this.isPercent = false;
		this.width = Float.parseFloat(Integer.toString(width.intValue()));
	}

	@Override
	public Float getWidth() {
		return this.width;
	}

	@Override
	public boolean isBorderWidthPercent() {
		return this.isPercent;
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
