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
 * Description: A class to organize and manage all known action items
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter, modified by Sparsh Goel
 * @version 1.00
 * 
 */

public class Elementlist {

	private boolean editChangesPending;

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes

	public Element MembersList = new Element();
	public data Data = new data();
	public Element TeamsList = new Element();
	// The standard empty action item

	List<Element> MemberList = new ArrayList<Element>();
	List<Element> TeamList = new ArrayList<Element>();
	List<data> DataList = new ArrayList<data>();

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItemManager class constructor.
	 * 
	 */
	public Elementlist() {

		MembersList = new Element();
		TeamsList = new Element();
		Data = new data();
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

	public void createActionItem33(String name, String next) throws Exception {

		data ai = new data(name, next);

		validateActionItem1(name);
		setCurrentActionItem33(ai);

		DataList.add(ai);
		reestablishActionItemAccessList33(ai, DataList);

	}

	public void createActionItem2(String name) throws Exception {

		Element ai = new Element(name);

		validateActionItem1(name);
		setCurrentActionItem2(ai);

		TeamList.add(ai);
		reestablishActionItemAccessList1(ai, TeamList);

	}

	public void reestablishActionItemAccessList1(Element ai, List<Element> nameList) {
		List<String> namesList = new ArrayList<>();
		namesList = establishSortedAccessList(ai, nameList);

		gui.MemberScreen.selectActionItemOptions1.addAll(namesList);
	}

	public void reestablishActionItemAccessList33(data ai, List<data> nameList33) {
		List<String> namesList33 = new ArrayList<>();
		namesList33 = establishSortedAccessList33(ai, nameList33);

		gui.MemberScreen.selectActionItemOptions1.addAll(namesList33);
	}

	public void reestablishActionItemAccessList2(Element ai, List<Element> nameList1) {
		List<String> namesList1 = new ArrayList<>();
		namesList1 = establishSortedAccessList(ai, nameList1);

		gui.TeamScreen.selectActionItemOptions1.addAll(namesList1);
	}

	// The usual getters and setters

	/**
	 * Get the current action item
	 * 
	 * @return - The current action item
	 */
	public Element getCurrentActionItem() {
		if (MembersList == null)

			return MembersList;
		return MembersList;
	}

	public data getCurrentActionItem33() {
		if (DataList == null)

			return Data;
		return Data;
	}

	public Element getCurrentActionItem1() {
		if (TeamsList == null)

			return TeamsList;
		return TeamsList;
	}

	public void setCurrentActionItem1(Element x) {
		MembersList = x;
	}

	public void setCurrentActionItem2(Element x) {
		TeamsList = x;
	}

	public void setCurrentActionItem33(data x) {
		Data = x;
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

	public List<String> getActionItemNames1(Element ai) {
		List<String> namesList1 = new ArrayList<>();
		namesList1 = establishSortedAccessList(ai, TeamList);
		return namesList1;
	}

	public List<String> establishSortedAccessList(Element ai, List<Element> MembersList) {
		List<String> sortedList = new ArrayList<>();

		for (Element a : MembersList) {
			sortedList.add(a.getMemberName().toString());

		}

		Collections.sort(sortedList);
		return sortedList;
	}

	public List<String> establishSortedAccessList33(data ai, List<data> Data) {
		List<String> sortedList1 = new ArrayList<>();

		for (data a : Data) {
			sortedList1.add(a.getMemberName().toString());

		}

		Collections.sort(sortedList1);
		return sortedList1;
	}

}
