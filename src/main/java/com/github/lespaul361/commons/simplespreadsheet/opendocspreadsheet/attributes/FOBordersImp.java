package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class FOBordersImp implements FOBorders {
	private FOBorder top = null;
	private FOBorder bottom = null;
	private FOBorder left = null;
	private FOBorder right = null;
	private static String FO_BORDER = "fo:border";
	private static String FO_BORDER_TOP = "fo:border-top";
	private static String FO_BORDER_BOTTOM = "fo:border-bottom";
	private static String FO_BORDER_RIGHT = "fo:border-right";
	private static String FO_BORDER_LEFT = "fo:border-left";

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if (top.equals(bottom) && left.equals(right) && top.equals(left)) {
			Attribute att = new Attribute(FO_BORDER, top.getAttributes().get(0).getValue());
			ret.add(att);
			return ret;
		}
		if (top != null) {
			Attribute att = new Attribute(FO_BORDER_TOP, top.getAttributes().get(0).getValue());
			ret.add(att);
		}
		if (bottom != null) {
			Attribute att = new Attribute(FO_BORDER_BOTTOM, top.getAttributes().get(0).getValue());
			ret.add(att);
		}
		if (left != null) {
			Attribute att = new Attribute(FO_BORDER_LEFT, top.getAttributes().get(0).getValue());
			ret.add(att);
		}
		if (right != null) {
			Attribute att = new Attribute(FO_BORDER_RIGHT, top.getAttributes().get(0).getValue());
			ret.add(att);
		}
		return ret;
	}

	@Override
	public void setBorder(FOBorder border) {
		this.top = this.bottom = this.left = this.right = border;
	}

	@Override
	public void setTopBorder(FOBorder border) {
		this.top = border;

	}

	@Override
	public FOBorder getTopBorder() {
		return this.top;
	}

	@Override
	public void setBottomBorder(FOBorder border) {
		this.bottom = border;
	}

	@Override
	public FOBorder getBottomBorder() {
		return this.bottom;
	}

	@Override
	public void setLeftBorder(FOBorder border) {
		this.left = border;
	}

	@Override
	public FOBorder getLeftBorder() {
		return this.left;
	}

	@Override
	public void setRightBorder(FOBorder border) {
		this.right = border;
	}

	@Override
	public FOBorder getRightBorder() {
		return this.right;
	}

}
