package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;

/**
 * An <i>and</i> element filter.
 */
public class AndFilter extends ElementFilter {
	
	private ElementFilter filter1;
	private ElementFilter filter2;
	
	/**
	 * Build a filter that only keep elements that are valid for the two
	 * specified filters.
	 *
	 * @param filter1 first filter
	 * @param filter2 second filter
	 */
	public AndFilter(ElementFilter filter1, ElementFilter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	@Override
	public boolean filter(OsmElement node) {
		
		return filter1.filter(node) && filter2.filter(node);
	}

}
