package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class FOBreaksImp implements FOBreaks {
	private BreakType breakType = null;
	private BreakLocation breakLocation = null;

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if (breakLocation != null) {
			String name = "";
			String value = "";
			switch (breakLocation) {
				case AFTER:
					name = BREAK_AFTER;
					break;
				case BEFORE:
					name = BREAK_BEFORE;
					break;
			}
			if (breakType == null) {
				breakType = breakType.AUTO;
			}
			value = breakType.name().toLowerCase();
			Attribute att = new Attribute(name, value);
			ret.add(att);
		}
		return ret;

	}

	@Override
	public void setBreak(BreakLocation breakLocation, BreakType breakType) {
		this.breakType = breakType;
		this.breakLocation = breakLocation;
	}

	@Override
	public BreakLocation getBreakLocation() {
		return this.breakLocation;
	}

	@Override
	public BreakType getBreakType() {
		return this.breakType;
	}

}
