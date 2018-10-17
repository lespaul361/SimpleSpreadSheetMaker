package com.github.lespaul361.commons.simplespreadsheet.opendocwritter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

class OpenDocStyle implements Style {
	private Boolean isBreak = null;
	private Integer pageNumber = null;
	private Float relWidth = null;
	private String shadow = null;
	private Float width = null;
	private WritingModes writingMode = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if(isMayBreakBetweenRows() != null) {
			ret.add(new Attribute(IS_BREAK,
					isMayBreakBetweenRows().toString().toLowerCase()));
		}
		if(getPageNumber() != null) {
			ret.add(new Attribute(PAGE_NUMBER, getPageNumber().toString()));
		}
		if(getRelWidth() != null) {
			ret.add(new Attribute(REL_WIDTH, getRelWidth().toString()));
		}
		if(getWidth() != null) {
			ret.add(new Attribute(WIDTH, getWidth().toString()));
		}
		if(getShadow() != null) {
			ret.add(new Attribute(shadow, getShadow().toString()));
		}
		if(getWritingMode() != null) {
			ret.add(new Attribute(WRITING_MODE,
					getWritingMode().name().toLowerCase()));
		}
		
		return ret;
	}
	
	@Override
	public void setMayBreakBetweenRows(Boolean isBreak) {
		this.isBreak = isBreak;
		
	}
	
	@Override
	public Boolean isMayBreakBetweenRows() {
		return isBreak;
	}
	
	@Override
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@Override
	public Integer getPageNumber() {
		return this.pageNumber;
	}
	
	@Override
	public void setRelWidth(Float percent) {
		this.relWidth = percent;
	}
	
	@Override
	public Float getRelWidth() {
		return this.relWidth;
	}
	
	@Override
	public void setShadow(String shadow) {
		this.shadow = shadow;
	}
	
	@Override
	public String getShadow() {
		return this.shadow;
	}
	
	@Override
	public void setWidth(Float width) {
		this.width = width;
	}
	
	@Override
	public Float getWidth() {
		return this.width;
	}
	
	@Override
	public void setWritingMode(WritingModes writingMode) {
		this.writingMode = writingMode;
	}
	
	@Override
	public WritingModes getWritingMode() {
		return this.writingMode;
	}
	
}
