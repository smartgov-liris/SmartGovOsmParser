package com.smartgov.osmparser.elements;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartgov.osmparser.serializers.TagSerializer;

/**
 * Base class for osm root elements (nodes, ways and relations).
 *
 * <p>
 * Used to at least un-marshall the id and the tag list of the element, that
 * are common features of any osm element.
 * </p>
 */
public class OsmElement {
	
	@XmlAttribute
	private String id;
	
	@XmlElement(name = "tag")
	@JsonSerialize(using = TagSerializer.class)
	private List<Tag> tags;
	
	public OsmElement() {
		tags = new ArrayList<>();
	}
	
	/**
	 * Osm id
	 *
	 * @return id specified in the osm file
	 */
	public String getId() {
		return id;
	}

	/**
	 * Element's tags
	 *
	 * @return un-marshalled tag list from the osm file
	 */
	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "OsmElement [id=" + id + ", tags=" + tags + "]\n";
	}

}
