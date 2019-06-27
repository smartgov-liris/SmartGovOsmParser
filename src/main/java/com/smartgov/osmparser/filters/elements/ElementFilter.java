package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;

/**
 * An element filter that can be used to filter nodes, ways and relations.
 *
 */
public abstract class ElementFilter {

	/**
	 * Filter the given element.
	 *
	 * @return true if and only if the element should be kept
	 */
	public abstract boolean filter(OsmElement element);
	
	/**
	 * Returns a new filter that keep elements that are kept by this
	 * filter <i>or</i> the specified one.
	 *
	 * @param elementFilter other filter
	 * @return new or filter
	 */
	public ElementFilter or(ElementFilter elementFilter) {
		return new OrFilter(this, elementFilter);
	}
	
	/**
	 * Returns a new filter that keep elements that are kept by this
	 * this filter <i>and</i> the specified one.
	 *
	 * @param elementFilter other filter
	 * @return new or filter
	 */
	public ElementFilter and(ElementFilter elementFilter) {
		return new AndFilter(this, elementFilter);
	}
	
	/**
	 * Returns the negation of the specified filter, that keep elements
	 * only and only if they were deleted by the specified filter.
	 *
	 * @param elementFilter filter to negate
	 * @return filter negation
	 */
	public static ElementFilter not(ElementFilter elementFilter) {
		return new NotFilter(elementFilter);
	}
}
