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
import com.smartgov.osmparser.filters.elements.ElementFilter;
import com.smartgov.osmparser.filters.tags.TagMatcher;

/**
 * Main class used to load osm features from the osm file input and to filter
 * elements.
 *
 */
public class OsmParser {

	private Osm osm;

	private ElementFilter nodeFilter;
	private TagMatcher nodeTagMatcher;
	
	private ElementFilter wayFilter;
	private TagMatcher wayTagMatcher;
	
	private ElementFilter relationFilter;
	private TagMatcher relationTagMatcher;
	
	
	/**
	 * Parses the input file and returned the un-filtered osm feature (i.e.
	 * all the features contained in the file).
	 *
	 * @param osmFile an OSM file (<a
	 * href="https://wiki.openstreetmap.org/wiki/OSM_XML">official wiki
	 * page</a>)
	 * @return un-marshalled osm instance
	 */
	public Osm parse(File osmFile) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Osm.class);
        osm = (Osm) context.createUnmarshaller().unmarshal(new FileReader(osmFile));
        return osm;
	}
	
	/**
	 * Set up a node tag matcher.
	 *
	 * <p>
	 * When {@link #filterNodes} is called, only the node tags that match
	 * the specified tag matcher will be kept.
	 * </p>
	 *
	 * <p>
	 * Should not be confused with {@link #setNodeFilter}.
	 * </p>
	 *
	 * @param nodeTagMatcher node tags to keep
	 */
	public void setNodeTagMatcher(TagMatcher nodeTagMatcher) {
		this.nodeTagMatcher = nodeTagMatcher;
	}

	/**
	 * Set up a way tag matcher.
	 *
	 * <p>
	 * When {@link #filterWays} is called, only the way tags that match
	 * the specified tag matcher will be kept.
	 * </p>
	 *
	 * <p>
	 * Should not be confused with {@link #setWayFilter}.
	 * </p>
	 *
	 * @param wayTagMatcher way tags to keep
	 */
	public void setWayTagMatcher(TagMatcher wayTagMatcher) {
		this.wayTagMatcher = wayTagMatcher;
	}
	
	/**
	 * Set up a relation tag matcher.
	 *
	 * <p>
	 * When {@link #filterWays} is called, only the relation tags that match
	 * the specified tag matcher will be kept.
	 * </p>
	 *
	 * <p>
	 * Should not be confused with {@link #setRelationFilter}.
	 * </p>
	 *
	 * @param relationTagMatcher relation tags to keep
	 */
	public void setRelationTagMatcher(TagMatcher relationTagMatcher) {
		this.relationTagMatcher = relationTagMatcher;
	}
	
	/**
	 * Set up a node filter.
	 *
	 * <p>
	 * Only the nodes that match the specified filter will be kept.
	 * </p>
	 *
	 * @param nodeFilter nodes to keep
	 */
	public void setNodeFilter(ElementFilter nodeFilter) {
		this.nodeFilter = nodeFilter;
	}

	/**
	 * Set up a way filter.
	 *
	 * <p>
	 * Only the ways that match the specified filter will be kept.
	 * </p>
	 *
	 * @param wayFilter ways to keep
	 */
	public void setWayFilter(ElementFilter wayFilter) {
		this.wayFilter = wayFilter;
	}

	/**
	 * Set up a relation filter.
	 *
	 * <p>
	 * Only the relations that match the specified filter will be kept.
	 * </p>
	 *
	 * @param relationFilter relations to keep
	 */
	public void setRelationFilter(ElementFilter relationFilter) {
		this.relationFilter = relationFilter;
	}

	/**
	 * Filter the osm nodes thanks to the {@link #setNodeFilter node
	 * filter}, removing un-matching nodes from the osm
	 * instance.
	 *
	 * <p>
	 * If the node filter is <code>null</code>, all the instances will be
	 * kept.
	 * </p>
	 */
	public void filterNodes() {
		if(nodeFilter != null) {
			List<Node> nodesToRemove = new ArrayList<>();
			for (Node node : osm.getNodes()) {
				if (!nodeFilter.filter(node)) {
					nodesToRemove.add(node);
				}
				else {
					if (nodeTagMatcher != null) {
						List<Tag> tagsToRemove = new ArrayList<>();
						for(Tag tag : node.getTags()) {
							if (!nodeTagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
						node.getTags().removeAll(tagsToRemove);
					}
				}
			}
			System.out.println("hey " + nodesToRemove.size());
			osm.getNodes().removeAll(nodesToRemove);
			System.out.println("ok");
		}
	}

	/**
	 * Filter the osm ways thanks to the {@link #setWayFilter way
	 * filter}, removing un-matching ways from the osm
	 * instance.
	 *
	 * <p>
	 * If the way filter is <code>null</code>, all the instances will be
	 * kept.
	 * </p>
	 */
	public void filterWays() {
		if(wayFilter != null) {
			List<Way> waysToRemove = new ArrayList<>();
			for (Way way : osm.getWays()) {
				if (!wayFilter.filter(way)) {
					waysToRemove.add(way);
				}
				else {
					if (wayTagMatcher != null) {
						List<Tag> tagsToRemove = new ArrayList<>();
						for(Tag tag : way.getTags()) {
							if (!wayTagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
						way.getTags().removeAll(tagsToRemove);
					}
				}
			}
			osm.getWays().removeAll(waysToRemove);
		}
	}

	/**
	 * Filter the osm relations thanks to the {@link #setRelationFilter
	 * relation filter}, removing un-matching relations from the osm
	 * instance.
	 *
	 * <p>
	 * If the relation filter is <code>null</code>, all the instances will be
	 * kept.
	 * </p>
	 */
	public void filterRelations() {
		if(relationFilter != null) {
			List<Relation> relationsToRemove = new ArrayList<>();
			for (Relation relation : osm.getRelations()) {
				if (!relationFilter.filter(relation)) {
					relationsToRemove.add(relation);
				}
				else {
					if (relationTagMatcher != null) {
						List<Tag> tagsToRemove = new ArrayList<>();
						for(Tag tag : relation.getTags()) {
							if (!relationTagMatcher.matches(tag)) {
								tagsToRemove.add(tag);
							}
						}
						relation.getTags().removeAll(tagsToRemove);
					}
				}
			}
			osm.getRelations().removeAll(relationsToRemove);
		}
	}
	
	/**
	 * Write a JSON representation of the current osm nodes to the
	 * specified file, using the default Jackson ObjectMapper.
	 *
	 * @param nodeFile node json file
	 */
	public void writeNodes(File nodeFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(nodeFile, osm.getNodes());
	}
	
	/**
	 * Write a JSON representation of the current osm nodes to the
	 * specified file, using the specified Jackson ObjectMapper.
	 *
	 * @param nodeFile node json file
	 * @param objectMapper custom object mapper
	 */
	public void writeNodes(File nodeFile, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		objectMapper.writeValue(nodeFile, osm.getNodes());
	}
	
	/**
	 * Write a JSON representation of the current osm ways to the
	 * specified file, using the default Jackson ObjectMapper.
	 *
	 * @param wayFile way json file
	 */
	public void writeWays(File wayFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(wayFile, osm.getWays());
	}
	
	/**
	 * Write a JSON representation of the current osm ways to the
	 * specified file, using the specified Jackson ObjectMapper.
	 *
	 * @param wayFile way json file
	 * @param objectMapper custom object mapper
	 */
	public void writeWays(File wayFile, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		objectMapper.writeValue(wayFile, osm.getWays());
	}
	
	/**
	 * Write a JSON representation of the current osm relations to the
	 * specified file, using the default Jackson ObjectMapper.
	 *
	 * @param relationFile relation json file
	 */
	public void writeRelations(File relationFile) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(relationFile, osm.getRelations());
	}
	
	/**
	 * Write a JSON representation of the current osm relations to the
	 * specified file, using the specified Jackson ObjectMapper.
	 *
	 * @param relationFile relation json file
	 * @param objectMapper custom object mapper
	 */
	public void writeRelations(File relationFile, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		objectMapper.writeValue(relationFile, osm.getRelations());
	}
}
