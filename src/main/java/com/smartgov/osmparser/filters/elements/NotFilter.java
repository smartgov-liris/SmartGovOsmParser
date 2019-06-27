package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;

/**
 * A <i>not</i> element filter.
 */
public class NotFilter extends ElementFilter {
	
	private ElementFilter filter;

	/**
	 * Build a negation that keep only elements
	 * invalid for the specified filter.
	 *
	 * @param filter filter to negate
	 */
	public NotFilter(ElementFilter filter) {
		this.filter = filter;
	}

	@Override
	public boolean filter(OsmElement element) {
		return !filter.filter(element);
	}

}
