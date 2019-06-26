package com.smartgov.osmparser.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Class used to represent and un-marshal relation members.
 */
public class Member {
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute
	private String ref;
	
	@XmlAttribute
	private String role;

	/**
	 * Member type
	 *
	 * @return un-marshalled member type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Member ref
	 *
	 * @return un-marshalled member ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Member role
	 *
	 * @return un-marshalled member role
	 */
	public String getRole() {
		return role;
	}

}
