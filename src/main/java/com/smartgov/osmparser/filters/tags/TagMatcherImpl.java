package com.smartgov.osmparser.filters.tags;

/**
 * Implemented TagMatcher
 */
public abstract class TagMatcherImpl implements TagMatcher {
	
	@Override
	public TagMatcher or(String key, String value) {
		return new OrTagMatcher(this, new BaseTagMatcher(key, value));
	}
	
	@Override
	public TagMatcher or(TagMatcher tagMatcher) {
		return new OrTagMatcher(this, tagMatcher);
	}
	
	@Override
	public TagMatcher and(String key, String value) {
		return new AndTagMatcher(this, new BaseTagMatcher(key, value));
	}
	
	@Override
	public TagMatcher and(TagMatcher tagMatcher) {
		return new AndTagMatcher(this, tagMatcher);
	}
}
