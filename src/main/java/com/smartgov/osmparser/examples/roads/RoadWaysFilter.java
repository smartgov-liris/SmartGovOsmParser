package com.smartgov.osmparser.examples.roads;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.tags.IncludeTagMatcher;

public class RoadWaysFilter extends ElementFilter {

	@Override
	public boolean filter(OsmElement element) {
		return hasTag(element, new IncludeTagMatcher("highway", ".*"));
	}

}
