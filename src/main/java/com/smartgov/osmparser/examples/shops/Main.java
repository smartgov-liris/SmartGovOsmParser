package com.smartgov.osmparser.examples.shops;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.smartgov.osmparser.Osm;
import com.smartgov.osmparser.OsmParser;
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.elements.TagFilter;
import com.smartgov.osmparser.filters.tags.BaseTagMatcher;

/**
 * An example of how the API can be used to filter nodes that are shops but not bakeries.
 *
 */
public class Main {
	

	 public static void main(String[] args) throws JAXBException, IOException {
	        OsmParser parser = new OsmParser();
	        // Parse the test osm file
	        Osm osm = (Osm) parser.parse(new File(Main.class.getResource("../test.osm").getFile()));

	        // Keep only nodes that are shops but not bakeries
	        parser.setNodeFilter(
	        		new TagFilter(new BaseTagMatcher("shop", ".*"))
	        		.and(
	        			ElementFilter.not(
	        				new TagFilter(new BaseTagMatcher("shop", "bakery"))
	        				)
	        			)
	        		);
	        
	        // Keep all the shop tags
	        parser.setNodeTagMatcher(new BaseTagMatcher("shop", ".*"));
	        
	        // Apply nodes and tags filters
	        parser.filterNodes();
	        
	        // Custom mapper to indent output
	        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	        System.out.println(mapper.writeValueAsString(osm.getNodes()));
	        
	        // Write filtered nodes as a json
	        parser.writeNodes(new File("src/main/resources/com/smartgov/osmparser/examples/shops/shops.json"), mapper);
	 }
}
