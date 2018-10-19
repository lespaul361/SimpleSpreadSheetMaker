package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class OpenDocStyleBorderLines implements StyleBorderLines {
	private StyleBorderLine top = null;
	private StyleBorderLine bottom = null;
	private StyleBorderLine left = null;
	private StyleBorderLine right = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		try {
			if(top.equals(bottom) && bottom.equals(left)
					&& left.equals(right)) {
				Attribute att = top.getAttributes().get(0);
				att.setName(BORDER_LINE_WIDTH);
				ret.add(att);
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(top!=null) {
			Attribute att = top.getAttributes().get(0);
			att.setName(BORDER_LINE_WIDTH_TOP);
			ret.add(att);
		}
		if(bottom!=null) {
			Attribute att = top.getAttributes().get(0);
			att.setName(BORDER_LINE_WIDTH_BOTTOM);
			ret.add(att);
		}
		if(left!=null) {
			Attribute att = top.getAttributes().get(0);
			att.setName(BORDER_LINE_WIDTH_LEFT);
			ret.add(att);
		}
		if(right!=null) {
			Attribute att = top.getAttributes().get(0);
			att.setName(BORDER_LINE_WIDTH_RIGHT);
			ret.add(att);
		}
		return ret;
	}
	
	@Override
	public void setBorderLineWidth(StyleBorderLine line) {
		top = bottom = left = right = line;
	}
	
	@Override
	public void setBorderLineWidthLeft(StyleBorderLine line) {
		this.left = line;
		
	}
	
	@Override
	public void setBorderLineWidthRight(StyleBorderLine line) {
		this.right = line;
	}
	
	@Override
	public void setBorderLineWidthTop(StyleBorderLine line) {
		this.top = line;
	}
	
	@Override
	public void setBorderLineWidthBottom(StyleBorderLine line) {
		this.bottom = line;
	}
	
	@Override
	public StyleBorderLine getLineWidthRight() {
		return right;
	}
	
	@Override
	public StyleBorderLine getLineWidthLeft() {
		return left;
	}
	
	@Override
	public StyleBorderLine getLineWidthTop() {
		return top;
	}
	
	@Override
	public StyleBorderLine getLineWidthBottom() {
		return bottom;
	}
	
}
