package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.util.ArrayList;
import java.util.List;

import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;
import org.jdom.Attribute;
import org.junit.platform.commons.util.PreconditionViolationException;

public class OpenDocFOBorders implements FOBorders {
	private FOBorder top = null;
	private FOBorder bottom = null;
	private FOBorder left = null;
	private FOBorder right = null;

	@Override
	public List<Attribute> getAttributes() {
		List<Attribute> ret = new ArrayList<>();
		if (top.equals(bottom) && bottom.equals(left) && left.equals(right)) {
			Attribute attribute = top.getAttributes().get(0);
			ret.add(attribute);
			return ret;
		}
		if (top != null) {
			ret.addAll(top.getAttributes());
		}
		if (left != null) {
			ret.addAll(left.getAttributes());
		}
		if (right != null) {
			ret.addAll(right.getAttributes());
		}
		if (bottom != null) {
			ret.addAll(bottom.getAttributes());
		}

		return ret;
	}

	@Override
	public void setBorder(FOBorder border) {
		this.top = this.bottom = this.left = this.right = border;

	}

	@Override
	public void setTop(FOBorder border) {
		this.top = border;
	}

	@Override
	public FOBorder getTop() {
		return this.top;
	}

	@Override
	public void setBottom(FOBorder border) {
		this.bottom = border;

	}

	@Override
	public FOBorder getBottom() {
		return this.bottom;
	}

	@Override
	public void setLeft(FOBorder border) {
		this.left = border;
	}

	@Override
	public FOBorder getLeft() {
		return this.left;
	}

	@Override
	public void setRight(FOBorder border) {
		this.right = border;

	}

	@Override
	public FOBorder getRight() {
		return this.right;
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
		result = prime * result + ((bottom == null) ? 0 : bottom.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OpenDocFOBorders)) {
			return false;
		}
		OpenDocFOBorders other = (OpenDocFOBorders) obj;
		if (bottom == null) {
			if (other.bottom != null) {
				return false;
			}
		} else if (!bottom.equals(other.bottom)) {
			return false;
		}
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		}
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right)) {
			return false;
		}
		if (top == null) {
			if (other.top != null) {
				return false;
			}
		} else if (!top.equals(other.top)) {
			return false;
		}
		return true;
	}

}
