package com.smartgov.osmparser.elements;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartgov.osmparser.serializers.TagSerializer;

public class OsmElement {
	
	@XmlAttribute
	private String id;
	
	@XmlElement(name = "tag")
	@JsonSerialize(using = TagSerializer.class)
	private List<Tag> tags;
	
	public OsmElement() {
		tags = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}

	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "OsmElement [id=" + id + ", tags=" + tags + "]\n";
	}

}
