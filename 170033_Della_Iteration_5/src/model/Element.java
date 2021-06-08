package model;

/**
 * <p>
 * Title: Element
 * </p>
 *
 * <p>
 * Description: An entity to hold details about a particular action item
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006
 * </p>
 *
 * @author Sparsh Goel
 * @version 1.00
 */
public class Element {

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes

	private String Members;

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItem class constructors.
	 *
	 */
	public Element() {
		Members = "";

	}

	public Element(String ai) {

		Members = ai;

	}

	// Just the usual getters and setters
	public String getMemberName() {
		return Members;
	}

	public void setMemberName(String x) {
		Members = x;
	}
}
