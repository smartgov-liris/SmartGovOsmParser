package com.smartgov.osmparser.elements;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.smartgov.osmparser.adapters.WayNdAdapter;

/**
 * Class used to represent and un-marshal <a
 * href="https://wiki.openstreetmap.org/wiki/Way">osm ways</a>.
 */
public class Way extends OsmElement {
	
	@XmlJavaTypeAdapter(WayNdAdapter.class)
	@XmlElement(name = "nd")
	private List<String> nodeRefs = new ArrayList<>();


	/**
	 * Way's node references.
	 *
	 * <p>
	 * A {@literal <nd ref="123456"/>} element is simply represented by
	 * "123456" when un-marshalled.
	 * </p>
	 *
	 * @return references of nodes that belong to this way
	 */
	public List<String> getNodeRefs() {
		return nodeRefs;
	}

}
