package com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.styles;

import java.util.Collection;

import org.openqa.selenium.remote.html5.AddApplicationCache;

import com.github.lespaul361.commons.simplespreadsheet.opendocspreadsheet.properties.*;

public interface StyleStyle {
	void addProptery(Property property); 
	void addProperties(Collection<Property> properties);
	void addProperties(Property[] properties);
}
