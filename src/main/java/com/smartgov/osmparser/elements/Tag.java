package com.smartgov.osmparser.elements;


import javax.xml.bind.annotation.XmlAttribute;


/**
 * Class used to represent and un-marshall <a
 * href="https://wiki.openstreetmap.org/wiki/Tags">osm tags</a>.
 */
public class Tag {

	@XmlAttribute(name = "k")
	private String key;
	
	@XmlAttribute(name = "v")
	private String value;

	/**
	 * Tag's key
	 *
	 * @return un-marshalled key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Tag's value
	 *
	 * @return un-marshalled value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Tag [key=" + key + ", value=" + value + "]";
	}

}
