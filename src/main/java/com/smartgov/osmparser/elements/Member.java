package com.smartgov.osmparser.elements;

import javax.xml.bind.annotation.XmlAttribute;

public class Member {
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute
	private String ref;
	
	@XmlAttribute
	private String role;

	public String getType() {
		return type;
	}

	public String getRef() {
		return ref;
	}

	public String getRole() {
		return role;
	}

}
