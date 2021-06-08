package model;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
/**
 * <p>
 * Title: ElementList
 * </p>
 *
 * <p>
 * Description: Element List class.
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006
 * </p>
 *
 * @author Sparsh Goel
 * @version 1.00
 */
public class Elementlist {

	private boolean editChangesPending;

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes

	public Element MembersList = new Element();
	// The standard empty action item

	List<Element> MemberList = new ArrayList<Element>();

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItemManager class constructor.
	 * 
	 */
	public Elementlist() {

		MembersList = new Element();

	}

	/**
	 * Update an existing action item based on the parameters pass to the routine
	 * 
	 * @param name        String
	 * @param description String
	 * @param resolution  String
	 * @param status      String
	 * @param dueDateStr  String
	 * @return ActionItem
	 */

	/**
	 * Check the parameters to see if the action item can be added to the list of
	 * action items.
	 * 
	 * @param name       String
	 * @param dueDateStr String
	 * @return boolean
	 * @throws an exception if there are any problems with the input.
	 */

	private void validateActionItem1(String name) throws Exception {
		if (name.trim().length() == 0) {
			throw new Exception("The Action Item Name must not be empty!   ");
		}

	}

	public void createActionItem1(String name) throws Exception {

		Element ai = new Element(name);

		validateActionItem1(name);
		setCurrentActionItem1(ai);

		MemberList.add(ai);
		reestablishActionItemAccessList1(ai, MemberList);

	}

	public void reestablishActionItemAccessList1(Element ai, List<Element> nameList) {
		List<String> namesList = new ArrayList<>();
		namesList = establishSortedAccessList(ai, nameList);

		
	}

	// The usual getters and setters

	/**
	 * Get the current action item
	 * 
	 * @return - The current action item
	 */

	public void setCurrentActionItem1(Element x) {
		MembersList = x;
	}

	public void setEditChangesPending(boolean flag) {
		editChangesPending = flag;
	}

	public boolean getEditChangesPending() {
		return editChangesPending;
	}

	public List<String> getActionItemNames(Element ai) {
		List<String> namesList = new ArrayList<>();
		namesList = establishSortedAccessList(ai, MemberList);
		return namesList;
	}

	public List<String> establishSortedAccessList(Element ai, List<Element> MembersList) {
		List<String> sortedList = new ArrayList<>();

		for (Element a : MembersList) {
			sortedList.add(a.getMemberName().toString());

		}

		Collections.sort(sortedList);
		return sortedList;
	}

}
