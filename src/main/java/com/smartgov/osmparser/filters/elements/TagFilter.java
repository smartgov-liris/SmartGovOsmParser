package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.tags.TagMatcher;

public class TagFilter extends ElementFilter {

	private TagMatcher tagMatcher;
	
	public TagFilter(TagMatcher tagMatcher) {
		super();
		this.tagMatcher = tagMatcher;
	}

	@Override
	public boolean filter(OsmElement element) {
		return hasMatchingTag(element);
	}
	
	private boolean hasMatchingTag(OsmElement element) {
		boolean hasTag = false;
		int i = 0;
		while (i < element.getTags().size() && !hasTag) {
			if(tagMatcher.matches(element.getTags().get(i))){
				hasTag = true;
			}
			i++;
		}
		return hasTag;
	}

}
