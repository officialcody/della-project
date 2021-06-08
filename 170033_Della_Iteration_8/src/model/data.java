package model;

/**
 * <p>
 * Title: data
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
public class data {

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes

	private String membername;
	private String teamname;
	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItem class constructors.
	 *
	 */
	public data() {
		membername = "";
		teamname = "";
	}

	public data(String ai, String bi) {

		membername = ai;
		teamname = bi;
	}

	// Just the usual getters and setters
	public String getMemberName() {
		return membername;
	}

	public String getMemberName1() {
		return teamname;
	}

	public void setMemberName(String x) {
		membername = x;
	}

	public void setMemberName1(String x) {
		teamname = x;
	}
}
