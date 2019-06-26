package com.smartgov.osmparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartgov.osmparser.elements.Node;
import com.smartgov.osmparser.elements.Relation;
import com.smartgov.osmparser.elements.Tag;
import com.smartgov.osmparser.elements.Way;
import com.smartgov.osmparser.examples.roads.OsmStreet;
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.tags.TagMatcher;

public class OsmParser {

	private OsmStreet osm;

	private List<ElementFilter> nodeFilters;
	private List<TagMatcher> nodeTagMatchers;
	
	private List<ElementFilter> wayFilters;
	private List<TagMatcher> wayTagMatchers;
	
	private List<ElementFilter> relationFilters;
	private List<TagMatcher> relationTagMatchers;
	
	public OsmParser() {
		this.nodeFilters = new ArrayList<>();
		this.nodeTagMatchers = new ArrayList<>();
		
		this.wayFilters = new ArrayList<>();
		this.wayTagMatchers = new ArrayList<>();
		
		this.relationFilters = new ArrayList<>();
		this.relationTagMatchers = new ArrayList<>();
	}
	
	public OsmStreet parse(File osmFile, Class<? extends Osm<?, ?, ?>> osmClass) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(OsmStreet.class);
		System.out.println(context.createUnmarshaller().unmarshal(new FileReader(osmFile)).getClass().getSimpleName());
        osm = (OsmStreet) context.createUnmarshaller().unmarshal(new FileReader(osmFile));
        return osm;
	}
	
	public void addNodeFilter(ElementFilter nodeFilter) {
		this.nodeFilters.add(nodeFilter);
	}
	
	public void addNodeTagMatcher(TagMatcher tagMatcher) {
		this.nodeTagMatchers.add(tagMatcher);
	}
	
	public void addWayFilter(ElementFilter wayFilter) {
		this.wayFilters.add(wayFilter);
	}
	
	public void addWayTagMatcher(TagMatcher tagMatcher) {
		this.wayTagMatchers.add(tagMatcher);
	}
	
	public void addRelationFilter(ElementFilter relationFilter) {
		this.relationFilters.add(relationFilter);
	}
	
	public void addRelationTagMatcher(TagMatcher tagMatcher) {
		this.relationTagMatchers.add(tagMatcher);
	}
	
	public void filterNodes() {
		for (ElementFilter filter : nodeFilters) {
			List<Node> nodesToRemove = new ArrayList<>();
			for (Node node : osm.getNodes()) {
				if (!filter.filter(node)) {
					nodesToRemove.add(node);
				}
				else {
					List<Tag> tagsToRemove = new ArrayList<>();
					for (TagMatcher tagMatcher : nodeTagMatchers) {
						for(Tag tag : node.getTags()) {
							if (!tagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
					}
					node.getTags().removeAll(tagsToRemove);
				}
			}
			osm.getNodes().removeAll(nodesToRemove);
		}
	}
	
	public void filterWays() {
		for (ElementFilter filter : wayFilters) {
			List<Way> waysToRemove = new ArrayList<>();
			for (Way way : osm.getWays()) {
				if (!filter.filter(way)) {
					waysToRemove.add(way);
				}
				else {
					List<Tag> tagsToRemove = new ArrayList<>();
					for (TagMatcher tagMatcher : wayTagMatchers) {
						for(Tag tag : way.getTags()) {
							if (!tagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
					}
					way.getTags().removeAll(tagsToRemove);
				}
			}
			osm.getWays().removeAll(waysToRemove);
		}
	}
	
	public void filterRelations() {
		for (ElementFilter filter : relationFilters) {
			List<Relation> relationsToRemove = new ArrayList<>();
			for (Relation relation : osm.getRelations()) {
				if (!filter.filter(relation)) {
					relationsToRemove.add(relation);
				}
				else {
					List<Tag> tagsToRemove = new ArrayList<>();
					for (TagMatcher tagMatcher : relationTagMatchers) {
						for(Tag tag : relation.getTags()) {
							if (!tagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
					}
					relation.getTags().removeAll(tagsToRemove);
				}
			}
			osm.getRelations().removeAll(relationsToRemove);
		}
	}
	
	public void writeNodes(File nodeFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(nodeFile, osm.getNodes());
	}
	
	public void writeWays(File wayFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(wayFile, osm.getWays());
	}
	
	public void writeRelations(File relationFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(relationFile, osm.getRelations());
	}
}
