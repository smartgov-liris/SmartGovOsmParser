package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

/**
 * A matcher that doesn't match any tag. Because, by default, if no matcher is specified,
 * all the tags are kept, you should use this if you actually don't want to keep any tag.
 */
public class NoneTagMatcher implements TagMatcher {

	/**
	 * Doesn't match anything.
	 *
	 * @return always false
	 */
	@Override
	public boolean matches(Tag tag) {
		return false;
	}

	/**
	 * Return the specified matcher, because this one is always false.
	 *
	 * @param tagMatcher other tag matcher
	 * @return specified tag matcher
	 */
	@Override
	public TagMatcher or(TagMatcher tagMatcher) {
		return tagMatcher;
	}

	/**
	 * Returns a new BaseTagMatcher from the specified key / value pair.
	 *
	 * @param key key matcher
	 * @param value value matcher
	 * @return new BaseTagMatcher
	 */
	@Override
	public TagMatcher or(String key, String value) {
		return new BaseTagMatcher(key, value);
	}

	/**
	 * Returns this tag matcher, because an <i>and</i> with this matcher
	 * can't match anything.
	 *
	 * @param tagMatcher tag matcher (ignored)
	 * @return this NoneTagMatcher
	 */
	@Override
	public TagMatcher and(TagMatcher tagMatcher) {
		return this;
	}

	/**
	 * Returns this tag matcher, because an <i>and</i> with this matcher
	 * can't match anything.
	 *
	 * @param key key to match (ignored)
	 * @param value value to match (ignored)
	 * @return this NoneTagMatcher
	 */
	@Override
	public TagMatcher and(String key, String value) {
		return this;
	}

}
