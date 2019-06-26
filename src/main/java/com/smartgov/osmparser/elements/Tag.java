package com.smartgov.osmparser.elements;

import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartgov.osmparser.serializers.TagSerializer;

public class Tag {

	@XmlAttribute(name = "k")
	private String key;
	
	@XmlAttribute(name = "v")
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Tag [key=" + key + ", value=" + value + "]";
	}

}
