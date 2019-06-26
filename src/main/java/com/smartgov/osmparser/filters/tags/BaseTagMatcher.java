package com.smartgov.osmparser.filters.tags;

import java.util.regex.Pattern;

import com.smartgov.osmparser.elements.Tag;

/**
 * A basic tag matcher, that matches when the specified key / value pair
 * matches the input tag.
 */
public class BaseTagMatcher extends TagMatcherImpl {

	protected String keyMatcher;
	protected String valueMatcher;
	
	/**
	 * This matcher will match if and only if the specified key / value
	 * pair matches the input tag.
	 *
	 * <p>
	 * Matches are performed thanks to Java regular expressions. For more
	 * details, check the <a
	 * href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html">
	 * official Javadoc</a>.
	 * </p>
	 *
	 * @param keyMatcher key regular expression to match
	 * @param valueMatcher value regular expression to match
	 */
	public BaseTagMatcher(String keyMatcher, String valueMatcher) {
		this.keyMatcher = keyMatcher;
		this.valueMatcher = valueMatcher;
	}

	@Override
	public boolean matches(Tag tag) {
		return Pattern.matches(keyMatcher, tag.getKey()) && Pattern.matches(valueMatcher, tag.getValue());
	}

}
