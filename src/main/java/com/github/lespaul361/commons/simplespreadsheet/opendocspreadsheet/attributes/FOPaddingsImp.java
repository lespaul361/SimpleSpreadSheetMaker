package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class FOPaddingsImp implements FOPaddings {
	private Float top = null;
	private Float bottom = null;
	private Float left = null;
	private Float right = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if(bottom == top && top == left && left == right) {
			String v = String.valueOf(top);
			v += "px";
			ret.add(new Attribute(PADDING, v));
			return ret;
		}
		if(top != null) {
			String v = String.valueOf(top);
			v += "px";
			ret.add(new Attribute(PADDING_TOP, v));
		}
		if(bottom != null) {
			String v = String.valueOf(bottom);
			v += "px";
			ret.add(new Attribute(PADDING_BOTTOM, v));
		}
		if(left != null) {
			String v = String.valueOf(left);
			v += "px";
			ret.add(new Attribute(PADDING_LEFT, v));
		}
		if(right != null) {
			String v = String.valueOf(right);
			v += "px";
			ret.add(new Attribute(PADDING_RIGHT, v));
		}
		return ret;
	}
	
	@Override
	public void setFloat(Float padding) {
		top = bottom = left = right = padding;
	}
	
	@Override
	public void setTopPadding(Float padding) {
		this.top = padding;
	}
	
	@Override
	public Float getTopPadding() {
		return this.top;
	}
	
	@Override
	public void setBottomPadding(Float padding) {
		this.bottom = padding;
	}
	
	@Override
	public Float getBottomPadding() {
		return this.bottom;
		
	}
	
	@Override
	public void setLeftPadding(Float padding) {
		this.left = padding;
	}
	
	@Override
	public Float getLeftPadding() {
		return this.left;
		
	}
	
	@Override
	public void setRightPadding(Float padding) {
		this.right = padding;
	}
	
	@Override
	public Float getRightPadding() {
		return this.right;
		
	}
	
}
