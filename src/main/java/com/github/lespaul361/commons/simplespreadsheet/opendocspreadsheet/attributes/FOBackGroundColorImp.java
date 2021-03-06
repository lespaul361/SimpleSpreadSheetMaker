package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;

public class FOBackGroundColorImp implements FOBackGroundColor {
	private Color color = null;

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>(3);
		if (this.color != null) {
			ret.add(new Attribute(Back_Ground_Color, toHexString()));
		}
		return ret;
	}

	@Override
	public Color getBackGroundColor() {
		return this.color;
	}

	@Override
	public void setBackGroundColor(Color c) {
		this.color = c;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FOBackGroundColorImp other = (FOBackGroundColorImp) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

}
