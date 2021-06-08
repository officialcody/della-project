package model;

/**
 * <p>
 * Title: Element
 * </p>
 *
 * <p>
 * Description: Element class.
 * </p>
 *
 * @author Sparsh Goel
 * @version 1.00
 */
public class Element {

	private String Members;

	public Element() {
		Members = "";

	}

	public Element(String ai) {
		Members = ai;
	}

	public String getMemberName() {
		return Members;
	}

	public void setMemberName(String x) {
		Members = x;
	}
}
