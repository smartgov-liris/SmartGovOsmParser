package com.smartgov.osmparser.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.smartgov.osmparser.elements.WayNd;

public class WayNdAdapter extends XmlAdapter<WayNd, String>{

	@Override
	public WayNd marshal(String arg0) throws Exception {
		return null;
	}

	@Override
	public String unmarshal(WayNd arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getRef();
	}

}
