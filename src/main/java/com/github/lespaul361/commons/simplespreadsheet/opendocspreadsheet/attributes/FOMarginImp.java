package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public class FOMarginImp implements FOMargin {
	private Float size = null;
	private boolean isPercent = false;
	private MarginLocations location = null;

	@Override
	public void setMargin(MarginLocations location, Float size) {
		this.location = location;
		this.size = size;
		this.isPercent = true;
	}

	@Override
	public void setMargin(MarginLocations location, Integer size) {
		this.location = location;
		this.size = Float.valueOf(size);
		this.isPercent = false;
	}

	@Override
	public MarginLocations getLocation() {
		return this.location;
	}

	@Override
	public Float getSize() {
		return this.size;
	}

	@Override
	public boolean isMarginPercentage() {
		return this.isPercent;
	}

}
