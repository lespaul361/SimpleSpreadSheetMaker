package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOBorder extends GetOpenDocAttributes {
	enum BorderStyles {
		NONE, HIDDEN, DOTTED, DASHED, DOUBLE, SOLID, GROOVE, RIDGE, INSET, OUTSET;
		public long hashcode() {
			byte[] buffer = toString().getBytes();
			long ret = 0;
			int magNum = 3;
			for (byte b : buffer) {
				ret += b * magNum;
			}
			return ret;
		}
		
		public String toString() {
			return this.name().toLowerCase();
		}
		
		public boolean equals(BorderStyles style) {
			if(style.hashcode()!=style.hashcode()){
				return false;
			}
			return true;
		}
	}
	
	enum BorderLocations {
		BORDER, BORDER_LEFT, BORDER_RIGHT, BORDER_TOP, BORDER_BOTTOM;
		public long hashcode() {
			byte[] buffer = toString().getBytes();
			long ret = 0;
			int magNum = 89;
			for (byte b : buffer) {
				ret += b * magNum;
			}
			return ret;
		}
		
		public String toString() {
			String s=this.name();
			s=s.toLowerCase();
			s=s.replace("_", "-");
			return s;
		}
		
		public String toFOString() {
			return "fo:" + this.toString();
		}
		
		public boolean equals(BorderStyles style) {
			if(style.hashcode()!=style.hashcode()){
				return false;
			}
			return true;
		}
	}
	
	void setColor(Color color);
	
	Color getColor();
	
	void setWidth(Float width);
	
	Float getWidth();
	
	void setBorderStyle(BorderStyles style);
	
	BorderStyles getBorderStyle();
}
