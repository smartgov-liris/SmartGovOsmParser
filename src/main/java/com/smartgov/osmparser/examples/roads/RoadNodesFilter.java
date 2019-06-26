package com.smartgov.osmparser.examples.roads;

import java.util.List;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.elements.Way;
import com.smartgov.osmparser.filters.elements.ElementFilter;

public class RoadNodesFilter extends ElementFilter {

	private List<Way> ways;
	
	public RoadNodesFilter(List<Way> list) {
		this.ways = list;
	}

	@Override
	public boolean filter(OsmElement node) {
		boolean inRoad = false;
		int i = 0;
		while (i < this.ways.size() && !inRoad) {
			if (this.ways.get(i).getNodeRefs().contains(node.getId())) {
				inRoad = true;
			}
			i++;
		}
		
		return inRoad;
	}

}
