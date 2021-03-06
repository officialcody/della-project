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
 * @author Sparsh Goel
 * @version 1.00
 */
public class Elementlist {

	private boolean editChangesPending;
	public Element MembersList = new Element();
	List<Element> MemberList = new ArrayList<Element>();

	public Elementlist() {
		MembersList = new Element();
	}

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
