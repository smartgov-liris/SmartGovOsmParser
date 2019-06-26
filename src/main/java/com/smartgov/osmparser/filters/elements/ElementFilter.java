package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.tags.TagMatcher;

public abstract class ElementFilter {

	public abstract boolean filter(OsmElement element);
	
	public ElementFilter or(ElementFilter nodeFilter) {
		return new OrFilter(this, nodeFilter);
	}
	
	public ElementFilter and(ElementFilter nodeFilter) {
		return new AndFilter(this, nodeFilter);
	}
	
	public static ElementFilter not(ElementFilter nodeFilter) {
		return new NotFilter(nodeFilter);
	}
}
