package com.smartgov.osmparser.elements;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Class used to represent and un-marshal <a
 * href="https://wiki.openstreetmap.org/wiki/Relation">osm relations</a>.
 */
public class Relation extends OsmElement {

	@XmlElement(name = "member")
	private List<Member> members;


	/**
	 * Relation's members
	 *
	 * @return un-marshalled members list from the osm file
	 */
	public List<Member> getMembers() {
		return members;
	}

}
