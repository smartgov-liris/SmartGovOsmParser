package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

/**
 * Interface that represents a tag matcher.
 */
public interface TagMatcher {

	/**
	 * Matching function that specifies the behaviour of this matcher.
	 *
	 * @param tag tag to check.
	 * @return true if and only if the matche matches the tag
	 */
	public boolean matches(Tag tag);

	/**
	 * Returns a new TagMatcher that matches when this matcher <i>or</i>
	 * the specified matcher matches.
	 *
	 * @param tagMatcher second matcher of the relation
	 * @return new tag matcher
	 */
	public TagMatcher or(TagMatcher tagMatcher);

	/**
	 * Returns a new TagMatcher that matches when the input tag matches
	 * this matcher <i>or</i> the specified key / value pair.
	 *
	 * @param key key to match
	 * @param value value to match
	 * @return new tag matcher
	 */
	public TagMatcher or(String key, String value);

	/**
	 * Returns a new TagMatcher that matches when this matcher <i>and</i>
	 * the specified matcher matches.
	 *
	 * @param tagMatcher second matcher of the relation
	 * @return new tag matcher
	 */
	public TagMatcher and(TagMatcher tagMatcher);

	/**
	 * Returns a new TagMatcher that matches when the input tag matches
	 * this matcher <i>and</i> the specified key / value pair.
	 *
	 * @param key key to match
	 * @param value value to match
	 * @return new tag matcher
	 */
	public TagMatcher and(String key, String value);
	
	/**
	 * Returns a matcher that matches if and only if the input tag does not
	 * match the specified key / value pair.
	 *
	 * @param key key to not match
	 * @param value value to not match
	 * @return negation tag matcher
	 */
	public static TagMatcher not(String key, String value) {
		return new NotTagMatcher(new BaseTagMatcher(key, value));
	}

	/**
	 * Returns a matcher that matches if and only if the input tag does not
	 * match with the specified tag matcher
	 *
	 * @param tagMatcher tag matcher to not match
	 * @return negation tag matcher
	 */
	public static TagMatcher not(TagMatcher tagMatcher) {
		return new NotTagMatcher(tagMatcher);
	}

}
