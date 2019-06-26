package com.smartgov.osmparser.serializers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.smartgov.osmparser.elements.Tag;

/**
 * Jackson serializer used to serialize osm tags as "key: value" entries,
 * instead of default "{"key": "...", "value": "..."}" objects.
 */
public class TagSerializer extends StdSerializer<List<Tag>>{

	private static final long serialVersionUID = 1L;

	public TagSerializer() {
		this(null);
	}
	
	protected TagSerializer(Class<List<Tag>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Tag> tags, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> tagMap = new HashMap<>();
		for(Tag tag : tags) {
			tagMap.put(tag.getKey(), tag.getValue());
		}
		gen.writeObject(tagMap);
	}

}
