package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class OpenDocFOBreaks implements FOBreaks {
	private Color backGroundColor = null;
	private Breaks beforeBreak = null;
	private Breaks afterBreak = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if(getBackGroundColor() != null) {
			ret.add(new Attribute(BACKGROUND_COLOR,
					toHex(getBackGroundColor())));
		}
		if(getBreakAfter() != null) {
			ret.add(new Attribute(BREAK_AFTER,
					getBreakAfter().name().toLowerCase()));
		}
		if(getBreakBefore() != null) {
			ret.add(new Attribute(BREAK_BEFORE,
					getBreakBefore().name().toLowerCase()));
		}
		
		return ret;
	}
	
	@Override
	public Color getBackGroundColor() {
		return backGroundColor;
	}
	
	@Override
	public void setBackGroundColor(Color color) {
		this.backGroundColor = color;
	}
	
	@Override
	public void setBreakBefore(Breaks breakBefore) {
		this.beforeBreak = breakBefore;
	}
	
	@Override
	public Breaks getBreakBefore() {
		return this.beforeBreak;
	}
	
	@Override
	public void setBreakAfter(Breaks breakAfter) {
		this.afterBreak = breakAfter;
	}
	
	@Override
	public Breaks getBreakAfter() {
		return this.afterBreak;
	}
	
	public static String toHex(Color color) {
		Integer r = color.getRed();
		Integer g = color.getGreen();
		Integer b = color.getBlue();
		Color hC;
		hC = new Color(r, g, b);
		String hex = Integer.toHexString(hC.getRGB() & 0xffffff);
		while (hex.length() < 6) {
			hex = "0" + hex;
		}
		hex = "Hex Code: #" + hex;
		return hex;
	}
	
}
