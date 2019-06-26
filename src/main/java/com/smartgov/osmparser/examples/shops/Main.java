package com.smartgov.osmparser.examples.shops;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.smartgov.osmparser.Osm;
import com.smartgov.osmparser.OsmParser;
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.elements.TagFilter;
import com.smartgov.osmparser.filters.tags.BaseTagMatcher;
import com.smartgov.osmparser.filters.tags.TagMatcher;

public class Main {
	

	 public static void main(String[] args) throws JAXBException, IOException {
	        OsmParser parser = new OsmParser();
	        Osm osm = (Osm) parser.parse(new File(Main.class.getResource("../test.osm").getFile()));

	        parser.setNodeFilter(
	        		new TagFilter(new BaseTagMatcher("shop", ".*"))
	        		.and(
	        			ElementFilter.not(
	        				new TagFilter(new BaseTagMatcher("shop", "bakery"))
	        				)
	        			)
	        		);
	        
	        parser.setNodeTagMatcher(new BaseTagMatcher("shop", ".*"));
	        parser.filterNodes();
	        
	        System.out.println(osm.getNodes());
	        parser.writeNodes(new File("src/main/resources/com/smartgov/osmparser/examples/roads/shops.json"));
	 }
}
