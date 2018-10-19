package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class StyleBorderLine implements GetOpenDocAttributes {
	private Float innerLineWidth = null;
	private Float distanceBetween = null;
	private Float outerLineWidth = null;
	
	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		String inner = innerLineWidth == null ? "0"
				: String.valueOf(innerLineWidth);
		String outer = outerLineWidth == null ? "0"
				: String.valueOf(outerLineWidth);
		String between = distanceBetween == null ? "0"
				: String.valueOf(distanceBetween);
		StringBuilder sBuilder = new StringBuilder(30);
		sBuilder.append(inner).append(" ").append(between).append(" ")
				.append(outer);
		if(innerLineWidth != null || distanceBetween != null
				|| outerLineWidth != null) {
			ret.add(new Attribute("style:border-line-width",
					sBuilder.toString()));
		}
		return ret;
	}
	
	public void setInnerLineWidth(Float f) {
		this.innerLineWidth = f;
	}
	
	public void setOuterLineWidth(Float f) {
		this.outerLineWidth = f;
	}
	
	public void setDistanceBetween(Float f) {
		this.distanceBetween = f;
	}
	
	public Float getInnerLineWidth() {
		return this.innerLineWidth;
	}
	
	public Float getOuterLineWidth() {
		return this.outerLineWidth;
	}
	
	public Float getDistanceBetween() {
		return this.distanceBetween;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distanceBetween == null) ? 0 : distanceBetween.hashCode());
		result = prime * result
				+ ((innerLineWidth == null) ? 0 : innerLineWidth.hashCode());
		result = prime * result
				+ ((outerLineWidth == null) ? 0 : outerLineWidth.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof StyleBorderLine)) {
			return false;
		}
		StyleBorderLine other = (StyleBorderLine) obj;
		if(distanceBetween == null) {
			if(other.distanceBetween != null) {
				return false;
			}
		} else if(!distanceBetween.equals(other.distanceBetween)) {
			return false;
		}
		if(innerLineWidth == null) {
			if(other.innerLineWidth != null) {
				return false;
			}
		} else if(!innerLineWidth.equals(other.innerLineWidth)) {
			return false;
		}
		if(outerLineWidth == null) {
			if(other.outerLineWidth != null) {
				return false;
			}
		} else if(!outerLineWidth.equals(other.outerLineWidth)) {
			return false;
		}
		return true;
	}
}
