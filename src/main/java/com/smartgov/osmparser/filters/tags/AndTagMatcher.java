package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

/**
 * An <i>and</i> tag matcher.
 */
public class AndTagMatcher extends TagMatcherImpl {
	
	private TagMatcher matcher1;
	private TagMatcher matcher2;


	/**
	 * This matcher will match if and only if the two
	 * specified matchers match.
	 *
	 * @param matcher1 first tag matcher
	 * @param matcher2 second tag matcher
	 */
	public AndTagMatcher(TagMatcher matcher1, TagMatcher matcher2) {
		super();
		this.matcher1 = matcher1;
		this.matcher2 = matcher2;
	}


	@Override
	public boolean matches(Tag tag) {
		return matcher1.matches(tag) && matcher2.matches(tag);
	}
}
