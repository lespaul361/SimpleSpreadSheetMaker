package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public class OpenDocColor extends Color {
	public OpenDocColor(Color c) {
		super(c.getRed(), c.getGreen(), c.getBlue());
	}
	
	public OpenDocColor(int r, int g, int b) {
		super(r, g, b);
	}
	
	public OpenDocColor(int rgb) {
		super(rgb);
	}
	
	public static String toHex(Color color) {
		Integer r = color.getRed();
		Integer g = color.getGreen();
		Integer b = color.getBlue();
		Color hC;
		hC = new Color(r, g, b);
		String hex = Integer.toHexString(hC.getRGB() & 0xffffff);
		while (hex.length() < 6) {
			hex = "0" + hex;
		}
		hex = "Hex Code: #" + hex;
		return hex;
	}
	
	public String toHex() {
		return OpenDocColor.toHex(this);
	}
}
