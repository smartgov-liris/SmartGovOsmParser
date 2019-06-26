package com.smartgov.osmparser.elements;


import javax.xml.bind.annotation.XmlAttribute;

public class Node extends OsmElement {
	
	@XmlAttribute
	public double lat;
	@XmlAttribute
	public double lon;
	@Override
	public String toString() {
		return "Node [lat=" + lat + ", lon=" + lon + ", tags=" + getTags() + ", id=" + getId() + "]\n";
	}

}
