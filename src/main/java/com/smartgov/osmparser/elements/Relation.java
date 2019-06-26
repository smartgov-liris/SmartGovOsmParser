package com.smartgov.osmparser.elements;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Relation extends OsmElement {

	@XmlElement(name = "member")
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

}
