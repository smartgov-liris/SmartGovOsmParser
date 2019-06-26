package com.smartgov.osmparser.examples.shops;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.tags.IncludeTagMatcher;

public class ShopFilter extends ElementFilter {

	@Override
	public boolean filter(OsmElement node) {
		IncludeTagMatcher shopMatcher = new IncludeTagMatcher("shop", ".*");
		boolean isShop = false;
		int i = 0;
		while(i < node.getTags().size() && !isShop) {
			if (shopMatcher.matches(node.getTags().get(i))) {
				isShop = true;
			}
			i++;
		}
		return isShop;
	}

	
}
