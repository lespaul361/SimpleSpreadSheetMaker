package com.github.lespaul361.commons.simplespreadsheet;

public class HeaderRow extends Row {
	protected HeaderRow(Sheet sheet) {
		super(sheet);
		RowStyle style=super.getStyle();
	}
}
