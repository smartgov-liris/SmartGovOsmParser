package com.smartgov.osmparser;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.smartgov.osmparser.elements.Node;
import com.smartgov.osmparser.elements.Relation;
import com.smartgov.osmparser.elements.Way;

// @XmlRootElement(name = "osm")
public class Osm<Tnode extends Node, Tway extends Way, Trelation extends Relation> {

	@XmlElement(name = "node")
	private List<Tnode> nodes;

	@XmlElement(name = "way")
	private List<Tway> ways;
	
	@XmlElement(name = "relation")
	private List<Trelation> relations;
	
	
	public List<Tnode> getNodes() {
		return nodes;
	}

	public List<Tway> getWays() {
		return ways;
	}

	public List<Trelation> getRelations() {
		return relations;
	}
	
}
