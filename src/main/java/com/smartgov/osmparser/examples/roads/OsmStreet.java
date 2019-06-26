package com.smartgov.osmparser.examples.roads;

import javax.xml.bind.annotation.XmlRootElement;

import com.smartgov.osmparser.Osm;
import com.smartgov.osmparser.elements.Node;
import com.smartgov.osmparser.elements.Relation;

@XmlRootElement(name = "osm")
public class OsmStreet extends Osm<Node, Street, Relation>{

}
