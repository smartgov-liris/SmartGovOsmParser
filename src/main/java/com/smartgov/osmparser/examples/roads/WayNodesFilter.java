package com.smartgov.osmparser.examples.roads;

import java.util.List;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.elements.Way;
import com.smartgov.osmparser.filters.elements.ElementFilter;

/**
 * Filters nodes that belong to ways.
 *
 * <p>
 * Can be used to build a road graph or extract buildings for example.
 * </p>
 * 
 */
public class WayNodesFilter extends ElementFilter {

	private List<Way> ways;
	
	/**
	 * Build a new element filter that will keep elements that belong to at
	 * least one way in the specified list.
	 * 
	 * @param list list of ways to check
	 */
	public WayNodesFilter(List<Way> list) {
		this.ways = list;
	}

	@Override
	public boolean filter(OsmElement node) {
		boolean inWay = false;
		int i = 0;
		while (i < this.ways.size() && !inWay) {
			if (this.ways.get(i).getNodeRefs().contains(node.getId())) {
				inWay = true;
			}
			i++;
		}
		
		return inWay;
	}

}
