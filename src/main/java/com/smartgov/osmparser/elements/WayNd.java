package com.smartgov.osmparser.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Class used to represent and un-marshall a way nodes.
 */
public class WayNd {

	@XmlAttribute
	private String ref;

	/**
	 * Ref of the {@literal <nd>} element.
	 *
	 * @return un-marshalled node ref
	 */
	public String getRef() {
		return ref;
	}

}
