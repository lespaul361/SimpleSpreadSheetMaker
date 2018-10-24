package com.github.lespaul361.commons.simplespreadsheet;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

class FontStyleImp implements FontStyle {
	private boolean isBold = false;
	private boolean isItalic = false;
	private boolean isUnderline = false;
	private Font font = new JLabel().getFont();

	@Override
	public boolean isBold() {
		return this.isBold;
	}

	@Override
	public void setBold(boolean bold) {
		this.isBold = bold;
	}

	@Override
	public boolean isItalic() {
		return this.isItalic;
	}

	@Override
	public void setItalic(boolean italic) {
		this.isItalic = italic;

	}

	@Override
	public boolean isUnderline() {
		return this.isUnderline;
	}

	@Override
	public void setUnderline(boolean underline) {
		this.isUnderline = underline;
	}

	@Override
	public Font getFont() {
		return this.font;
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public List<String> getAvailableFontFamilyNames() {
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		return Arrays.asList(fonts);
	}

}
