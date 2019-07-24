package com.smartgov.osmparser.examples.roads;

import java.util.TreeSet;

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

	private TreeSet<String> wayNodes;
	
	/**
	 * Build a new element filter that will keep elements that belong to at
	 * least one way in the specified list.
	 * 
	 * @param list list of ways to check
	 */
	public WayNodesFilter(TreeSet<Way> ways) {
		wayNodes = new TreeSet<>();
		for(Way way : ways) {
			for(String nodeId : way.getNodeRefs()) {
				wayNodes.add(nodeId);
			}
		}
	}
	
	@Override
	public boolean filter(OsmElement element) {
		if(!wayNodes.contains(element.getId()))
			return false;
		wayNodes.remove(element.getId());
		return true;
	}

}
