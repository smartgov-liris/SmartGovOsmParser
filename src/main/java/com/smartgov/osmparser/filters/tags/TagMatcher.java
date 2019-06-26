package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

public abstract class TagMatcher {

	protected String keyMatcher;
	protected String valueMatcher;
	
	public TagMatcher(String keyMatcher, String valueMatcher) {
		this.keyMatcher = keyMatcher;
		this.valueMatcher = valueMatcher;
	}
	
	public abstract boolean matches(Tag tag);

}
