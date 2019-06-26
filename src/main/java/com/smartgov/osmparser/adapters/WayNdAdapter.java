package com.smartgov.osmparser.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.smartgov.osmparser.elements.WayNd;

/**
 * A JAXB adapter to serialize {@literal <nd>} only as the ref attributes, in
 * order to represent the ref nodes of a way as an array of ids.
 */
public class WayNdAdapter extends XmlAdapter<WayNd, String>{

	@Override
	public WayNd marshal(String arg0) throws Exception {
		return null;
	}

	@Override
	public String unmarshal(WayNd arg0) throws Exception {
		return arg0.getRef();
	}

}
