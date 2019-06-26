package com.smartgov.osmparser.elements;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.smartgov.osmparser.adapters.WayNdAdapter;

public class Way extends OsmElement {
	
	@XmlJavaTypeAdapter(WayNdAdapter.class)
	@XmlElement(name = "nd")
	private List<String> nodeRefs;


	public List<String> getNodeRefs() {
		return nodeRefs;
	}

}
