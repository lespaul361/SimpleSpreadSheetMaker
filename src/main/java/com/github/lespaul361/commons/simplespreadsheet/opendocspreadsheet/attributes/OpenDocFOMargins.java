package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class OpenDocFOMargins implements FOMargins, GetOpenDocAttributes {
	private float bottom = -1;
	private float top = -1;
	private float left = -1;
	private float right = -1;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if(bottom == top && top == left && left == right) {
			ret.add(new Attribute(MARGIN, String.valueOf(bottom)));
			return ret;
		}
		if(bottom > 0) {
			ret.add(new Attribute(MARGIN_BOTTOM, String.valueOf(bottom)));
		}
		if(top > 0) {
			ret.add(new Attribute(MARGIN_TOP, String.valueOf(top)));
		}
		if(left > 0) {
			ret.add(new Attribute(MARGIN_LEFT, String.valueOf(left)));
		}
		if(right > 0) {
			ret.add(new Attribute(MARGIN_RIGHT, String.valueOf(right)));
		}
		return ret;
	}
	
	@Override
	public void setMargin(float percent) {
		bottom = top = left = right = percent;
	}
	
	@Override
	public void setMarginBottom(float percent) {
		this.bottom = percent;
	}
	
	@Override
	public float getMarginBottom() {
		return bottom;
	}
	
	@Override
	public void setMarginTop(float percent) {
		top = percent;
		
	}
	
	@Override
	public float getMarginTop() {
		return top;
	}
	
	@Override
	public void setMarginLeft(float percent) {
		left = percent;
		
	}
	
	@Override
	public void setMarginRight(float percent) {
		right = percent;
		
	}
	
	@Override
	public float getMarginRight() {
		return right;
	}
	
	@Override
	public float getMarginLeft() {
		return left;
	}
	
	@Override
	public void setMarginBottom(int sz) {
		bottom = sz;
		
	}
	
	@Override
	public void setMarginTop(int sz) {
		top = sz;
	}
	
	@Override
	public void setMarginLeft(int sz) {
		left = sz;
	}
	
	@Override
	public void setMargineRight(int sz) {
		right = sz;
	}
	
}
