package com.smartgov.osmparser.elements;


import javax.xml.bind.annotation.XmlAttribute;

/**
 * Class used to represent and un-marshal <a
 * href="https://wiki.openstreetmap.org/wiki/Node">osm nodes</a>.
 */
public class Node extends OsmElement {
	
	/**
	 * Node latitude
	 */
	@XmlAttribute
	public double lat;
	/**
	 * Node longitude
	 */
	@XmlAttribute
	public double lon;

	@Override
	public String toString() {
		return "Node [lat=" + lat + ", lon=" + lon + ", tags=" + getTags() + ", id=" + getId() + "]\n";
	}

}
