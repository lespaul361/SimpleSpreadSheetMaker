package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface Style extends GetOpenDocAttributes {
	final String IS_BREAK = "style:may-break-between-rows";
	final String PAGE_NUMBER = "style:page-number";
	final String REL_WIDTH = "style:rel-width";
	final String WIDTH = "style:width";
	final String SHADOW = "style:shadow";
	final String WRITING_MODE = "style:writing-mode";
	final String CELL_PROTECT = "style:cell-protect";
	
	public enum WritingModes {
		lrtb, rltb, tbrl, tblr, lr, rl, tb, page;
	}
	
	public enum ShadowTypes {
		CONSIDER_SHIFTS, DISREGARD_SHIFTS;
		public String toString() {
			switch (this) {
				case CONSIDER_SHIFTS:
					return "consider-shifts";
				case DISREGARD_SHIFTS:
					return "disregard-shifts";
			}
			return "";
		}
	}
	
	public enum CellProtectionTypes {
		FORMULA_HIDDEN, HIDDEN_AND_PROTECTED, NONE, PROTECTED;
		public String toString() {
			switch (this) {
				case FORMULA_HIDDEN:
					return "formual-hidden";
				case HIDDEN_AND_PROTECTED:
					return "hidden-and-preotected";
				case PROTECTED:
					return "protected";
				default:
					return "none";
			}
		}
	}
	
	public void setMayBreakBetweenRows(Boolean isBreak);
	
	public Boolean isMayBreakBetweenRows();
	
	public void setPageNumber(Integer pageNumber);
	
	public Integer getPageNumber();
	
	public void setRelWidth(Float percent);
	
	public Float getRelWidth();
	
	public void setShadow(ShadowTypes shadow);
	
	public ShadowTypes getShadow();
	
	public void setWidth(Float width);
	
	public Float getWidth();
	
	public void setWritingMode(WritingModes writingMode);
	
	public WritingModes getWritingMode();
	
	public void setCellProtection(CellProtectionTypes type);
	
	public CellProtectionTypes getCellProtection();
}
