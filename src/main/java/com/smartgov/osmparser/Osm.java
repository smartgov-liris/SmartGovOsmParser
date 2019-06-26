package com.smartgov.osmparser;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.smartgov.osmparser.elements.Node;
import com.smartgov.osmparser.elements.Relation;
import com.smartgov.osmparser.elements.Way;

/**
 * Base class to un-marshal osm root elements (nodes, ways and relations).
 * 
 * <p>
 * For more information, check the <a href="https://wiki.openstreetmap.org/wiki/OSM_XML"> official OSM wiki</a>
 * </p>
 * 
 * @author pbreugnot
 *
 */
@XmlRootElement(name = "osm")
public class Osm {

	@XmlElement(name = "node")
	private List<Node> nodes;

	@XmlElement(name = "way")
	private List<Way> ways;
	
	@XmlElement(name = "relation")
	private List<Relation> relations;
	
	
	/**
	 * Un-marshalled and eventually filtered osm nodes
	 *
	 * @return  Osm nodes
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * Un-marshalled and eventually filtered osm ways
	 *
	 * @return Osm ways
	 */
	public List<Way> getWays() {
		return ways;
	}

	/**
	 * Un-marshalled and eventually filtered osm relations
	 *
	 * @return Osm relations. 
	 */
	public List<Relation> getRelations() {
		return relations;
	}
	
}
