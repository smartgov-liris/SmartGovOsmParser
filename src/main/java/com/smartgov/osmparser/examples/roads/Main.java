/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.smartgov.osmparser.examples.roads;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.smartgov.osmparser.Osm;
import com.smartgov.osmparser.OsmParser;
import com.smartgov.osmparser.filters.elements.TagFilter;
import com.smartgov.osmparser.filters.tags.BaseTagMatcher;
import com.smartgov.osmparser.filters.tags.NoneTagMatcher;

/**
 * An example of how the API can be used to build an osm road graph.
 *
 */
public class Main {

    public static void main(String[] args) throws JAXBException, IOException {
        OsmParser parser = new OsmParser();
        // Parse the test osm file
        Osm osm = (Osm) parser.parse(new File(Main.class.getResource("../test.osm").getFile()));
        

        // Filter only highways
        parser.setWayFilter(new TagFilter(new BaseTagMatcher("highway", ".*")));
        
        // Keep highway, name and ref tags
        parser.setWayTagMatcher(
        		new BaseTagMatcher("highway", ".*")
        		.or("name", ".*")
        		.or("ref", ".*")
        		.or("oneway", ".*")
        		.or("service", ".*")
        		);

        // Filter the ways and their tags
        parser.filterWays();
        
        // Keep only nodes that belong to ways
        parser.setNodeFilter(new WayNodesFilter(osm.getWays()));
        
        // Does not keep any tag for nodes
        parser.setNodeTagMatcher(new NoneTagMatcher());
        
        // Filter nodes
        parser.filterNodes();
        
        // Custom object mapper to indent output
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        
        parser.writeNodes(new File("src/main/resources/com/smartgov/osmparser/examples/roads/nodes.json"), mapper);
        parser.writeWays(new File("src/main/resources/com/smartgov/osmparser/examples/roads/ways.json"), mapper);

    }
}
