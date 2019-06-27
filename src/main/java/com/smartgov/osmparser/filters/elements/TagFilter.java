package com.smartgov.osmparser.filters.elements;

import com.smartgov.osmparser.elements.OsmElement;
import com.smartgov.osmparser.filters.tags.TagMatcher;

/**
 * Filter elements by tag.
 */
public class TagFilter extends ElementFilter {

	private TagMatcher tagMatcher;
	
	/**
	 * Utility filter that keep only elements with at least a tag that matches
	 * the specified tag matcher.
	 *
	 * <p>
	 * Notice that this does not imply that the matching tags will be kept
	 * in the final representation. If it's what you want to do, use a
	 * {@link com.smartgov.osmparser.filters.tags.TagMatcher TagMatcher}
	 * instead.
	 * </p>
	 *
	 * @param tagMatcher tag matcher
	 */
	public TagFilter(TagMatcher tagMatcher) {
		super();
		this.tagMatcher = tagMatcher;
	}

	@Override
	public boolean filter(OsmElement element) {
		return hasMatchingTag(element);
	}
	
	private boolean hasMatchingTag(OsmElement element) {
		boolean hasTag = false;
		int i = 0;
		while (i < element.getTags().size() && !hasTag) {
			if(tagMatcher.matches(element.getTags().get(i))){
				hasTag = true;
			}
			i++;
		}
		return hasTag;
	}

}
