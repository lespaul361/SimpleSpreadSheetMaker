package com.github.lespaul361.commons.simplespreadsheet;

import java.security.AlgorithmParameterGeneratorSpi;

import javax.swing.border.Border;

import com.github.lespaul361.commons.simplespreadsheet.opendocwritter.GetOpenDocAttributes;

interface Table extends GetOpenDocAttributes {
	public enum Aligns {
		left, center, right, margins;
	}
	
	public enum BorderModels {
		Collapsing, Seperating, Null;
	}
	
	public Aligns getAlign();
	
	public void setAlign(Aligns align);
	
	public void setDisplay(boolean display);
	
	public boolean isDisplay();
	
	public void setBorderModel(BorderModels, borderModel);
	
	public BorderModels getBorderModel();
}
