package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

class OpenDocTable implements Table {
	private TableAlignments alignment = null;
	private Boolean isDisplay = null;
	private BorderModels borderModel = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if(getAlign() != null) {
			ret.add(new Attribute(ALIGN, getAlign().name().toLowerCase()));
		}
		if(getBorderModel() != null) {
			ret.add(new Attribute(BORDER_MODEL,
					getBorderModel().name().toLowerCase()));
		}
		if(isDisplay != null) {
			ret.add(new Attribute(DISPLAY, isDisplay.toString().toLowerCase()));
		}
		return ret;
	}
	
	@Override
	public void setAlign(TableAlignments align) {
		this.alignment = align;
	}
	
	@Override
	public TableAlignments getAlign() {
		return this.alignment;
	}
	
	@Override
	public void setDisplay(Boolean b) {
		this.isDisplay = b;
	}
	
	@Override
	public Boolean isDisplay() {
		return this.isDisplay;
	}
	
	@Override
	public void setBorderModel(BorderModels borderModel) {
		this.borderModel = borderModel;
	}
	
	@Override
	public BorderModels getBorderModel() {
		return this.borderModel;
	}
	
}
