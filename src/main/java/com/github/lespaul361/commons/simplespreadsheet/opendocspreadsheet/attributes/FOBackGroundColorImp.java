package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class FOBackGroundColorImp implements FOBackGroundColor {
	private Color color = null;

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>(3);
		if (this.color != null) {
			ret.add(new Attribute(Back_Ground_Color, toHexString()));
		}
		return ret;
	}

	@Override
	public Color getBackGroundColor() {
		return this.color;
	}

	@Override
	public void setBackGroundColor(Color c) {
		this.color = c;
	}

}
