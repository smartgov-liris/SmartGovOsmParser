package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;

public class NotFilter extends ElementFilter {
	
	private ElementFilter filter;

	public NotFilter(ElementFilter filter) {
		this.filter = filter;
	}

	@Override
	public boolean filter(OsmElement element) {
		return !filter.filter(element);
	}

}
