package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.tags.IncludeTagMatcher;

public abstract class ElementFilter {

	public abstract boolean filter(OsmElement element);
	
	public ElementFilter or(ElementFilter nodeFilter) {
		return new OrFilter(this, nodeFilter);
	}
	
	public static boolean hasTag(OsmElement element, IncludeTagMatcher matcher) {
		boolean hasTag = false;
		int i = 0;
		while (i < element.getTags().size() && !hasTag) {
			if(matcher.matches(element.getTags().get(i))){
				hasTag = true;
			}
			i++;
		}
		return hasTag;
	}
}
