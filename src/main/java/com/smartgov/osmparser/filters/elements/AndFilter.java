package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;

public class AndFilter extends ElementFilter {
	
	private ElementFilter filter1;
	private ElementFilter filter2;
	
	public AndFilter(ElementFilter filter1, ElementFilter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	@Override
	public boolean filter(OsmElement node) {
		
		return filter1.filter(node) && filter2.filter(node);
	}

}
