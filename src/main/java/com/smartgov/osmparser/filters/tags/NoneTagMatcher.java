package com.smartgov.osmparser.filters.tags;

import com.smartgov.osmparser.elements.Tag;

public class NoneTagMatcher implements TagMatcher {

	@Override
	public boolean matches(Tag tag) {
		return false;
	}

	@Override
	public TagMatcher or(TagMatcher tagMatcher) {
		return tagMatcher;
	}

	@Override
	public TagMatcher or(String key, String value) {
		return new BaseTagMatcher(key, value);
	}

	@Override
	public TagMatcher and(TagMatcher tagMatcher) {
		return this;
	}

	@Override
	public TagMatcher and(String key, String value) {
		return this;
	}

}
