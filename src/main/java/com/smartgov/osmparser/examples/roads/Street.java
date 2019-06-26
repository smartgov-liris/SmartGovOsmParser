package com.smartgov.osmparser.examples.roads;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.smartgov.osmparser.elements.Way;

public class Street extends Way {
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String ref;

}
