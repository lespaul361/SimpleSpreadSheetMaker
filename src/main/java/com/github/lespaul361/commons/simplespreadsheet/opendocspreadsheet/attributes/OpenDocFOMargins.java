package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class OpenDocFOMargins implements FOMargins, GetOpenDocAttributes {
	private Float top = null;
	private Float bottom = null;
	private Float left = null;
	private Float right = null;
	private boolean isPercentage = false;

	@Override
	public List<Attribute> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMargin(Float percent) {
		top=bottom=left=right=percent;
		this.isPercentage=true;
	}

	@Override
	public void setMarginBottom(Float percent) {
		bottom=percent;
		
	}

	@Override
	public Float getMarginBottom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMarginTop(Float percent) {
		// TODO Auto-generated method stub

	}

	@Override
	public Float getMargintTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMarginLeft(Float percent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMarginRight(Float percent) {
		// TODO Auto-generated method stub

	}

	@Override
	public Float getMarginRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getMarginLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMarginBottom(Integer sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMargIntegerop(Integer sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMarginLeft(Integer sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMargineRight(Integer sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean isMarginPercent() {
		// TODO Auto-generated method stub
		return null;
	}

}
