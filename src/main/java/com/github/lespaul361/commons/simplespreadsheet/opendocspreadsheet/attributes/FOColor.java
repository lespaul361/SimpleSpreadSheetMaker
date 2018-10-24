package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.attributes;

import java.awt.Color;

public interface FOColor {
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
		hex = "#" + hex;
		return hex;
	}
}
