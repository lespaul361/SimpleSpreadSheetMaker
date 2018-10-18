package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;
import org.jdom.Attribute;
import org.junit.platform.commons.util.PreconditionViolationException;

public class OpenDocFOBorders implements FOBorders {
	private Border top = null;
	private Border bottom = null;
	private Border left = null;
	private Border right = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute>ret=new ArrayList<>();
		if(top.equals(bottom)&&bottom.equals(left)&&left.equals(right)) {
			Attribute attribute=top.get
		}
	}
	
	@Override
	public void setBorder(Border border) {
		this.top = this.bottom = this.left = this.right = border;
		
	}
	
	@Override
	public void setTop(Border border) {
		this.top = border;
	}
	
	@Override
	public Border getTop() {
		return this.top;
	}
	
	@Override
	public void setBottom(Border border) {
		this.bottom = border;
		
	}
	
	@Override
	public Border getBottom() {
		return this.bottom;
	}
	
	@Override
	public void setLeft(Border border) {
		this.left = border;
	}
	
	@Override
	public Border getLeft() {
		return this.left;
	}
	
	@Override
	public void setRight(Border border) {
		this.right = border;
		
	}
	
	@Override
	public Border getRight() {
		return this.right;
	}
	
}
