package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

/**
 * A negation tag matcher.
 */
public class NotTagMatcher extends TagMatcherImpl {

	private TagMatcher tagMatcher;
	
	/**
	 * This matcher will match if and only if the specified matcher does
	 * not match.
	 *
	 * @param tagMatcher tag matcher to negate
	 */
	public NotTagMatcher(TagMatcher tagMatcher) {
		this.tagMatcher = tagMatcher;
	}
	
	@Override
	public boolean matches(Tag tag) {
		return !tagMatcher.matches(tag);
	}

}
