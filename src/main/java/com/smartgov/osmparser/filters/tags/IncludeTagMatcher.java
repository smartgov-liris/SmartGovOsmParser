package com.smartgov.osmparser.filters.tags;

import java.util.regex.Pattern;

import com.smartgov.osmparser.elements.Tag;

public class IncludeTagMatcher extends TagMatcher {

	public IncludeTagMatcher(String keyMatcher, String valueMatcher) {
		super(keyMatcher, valueMatcher);
	}

	public boolean matches(Tag tag) {
		return Pattern.matches(keyMatcher, tag.getKey()) && Pattern.matches(valueMatcher, tag.getValue());
	}
	
}
