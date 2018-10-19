package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

public interface Table extends GetOpenDocAttributes {
	final String DISPLAY = "table:display";
	final String ALIGN = "table:align";
	final String BORDER_MODEL = "table:border-model";
	
	enum TableAlignments {
		CENTER, MARGINS, LEFT, RIGHT
	}
	
	enum BorderModels {
		COLLAPSING, SEPERATING
	}
	
	void setAlign(TableAlignments align);
	
	TableAlignments getAlign();
	
	void setDisplay(Boolean b);
	
	Boolean isDisplay();
	
	void setBorderModel(BorderModels borderModel);
	
	BorderModels getBorderModel();
}
