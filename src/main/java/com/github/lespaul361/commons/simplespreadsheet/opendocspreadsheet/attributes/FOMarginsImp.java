package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes.FOMargin.MarginLocations;

public class FOMarginsImp implements FOMargins {
	private FOMargin top = null;
	private FOMargin bottom = null;
	private FOMargin left = null;
	private FOMargin right = null;

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if (top.equals(bottom) && bottom.equals(left) && left.equals(right)) {
			StringBuilder sb = new StringBuilder(20);
			sb.append(top.getSize());
			if (!top.isMarginPercentage()) {
				sb.append("px");
			}
			Attribute att = new Attribute(FOMargins.MARGIN.toString(), sb.toString().trim());
			ret.add(att);
			return ret;
		}
		Attribute att = getAttribute(top);
		if (att != null) {
			ret.add(att);
		}

		att = getAttribute(bottom);
		if (att != null) {
			ret.add(att);
		}

		att = getAttribute(left);
		if (att != null) {
			ret.add(att);
		}

		att = getAttribute(right);
		if (att != null) {
			ret.add(att);
		}
		return ret;
	}

	private Attribute getAttribute(FOMargin margin) {
		if (margin == null) {
			return null;
		}
		if (margin.getSize() == null || margin.getSize() == 0f) {
			return null;
		}
		StringBuilder sb = new StringBuilder(20);
		sb.append(margin.getSize());
		if (!margin.isMarginPercentage()) {
			sb.append("px");
		}
		Attribute att = new Attribute(margin.getLocation().toFOString(), sb.toString().trim());
		return att;
	}

	@Override
	public void setMargin(FOMargin margin) {
		if (margin == null) {
			return;
		}
		if (margin.getLocation() == null) {
			return;
		}
		Float value = margin.getSize();

		switch (margin.getLocation()) {
			case MARGIN:
				if (value == null) {
					top = bottom = left = right = null;
					break;
				}
				top = bottom = left = right = margin;
				break;
			case MARGIN_BOTTOM:
				if (value == null) {
					bottom = null;
					break;
				}
				bottom = margin;
				break;
			case MARGIN_TOP:
				if (value == null) {
					top = null;
					break;
				}
				top = margin;
				break;
			case MARGIN_LEFT:
				if (value == null) {
					left = null;
					break;
				}
				left = margin;
				break;
			case MARGIN_RIGHT:
				if (value == null) {
					right = null;
					break;
				}
				right = margin;
				break;
		}
	}

	@Override
	public FOMargin getMargin(MarginLocations location) {
		if (location.equals(MarginLocations.MARGIN)) {
			if (top.equals(left) && left.equals(right) && top.equals(bottom)) {
				return left;
			} else {
				return null;
			}
		}
		switch (location) {
			case MARGIN_BOTTOM:
				return bottom;
			case MARGIN_TOP:
				return top;
			case MARGIN_LEFT:
				return left;
			case MARGIN_RIGHT:
				return right;
		}
		return null;
	}

}
