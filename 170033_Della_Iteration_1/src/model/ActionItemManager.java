package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.ActionItemScreen;

import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * <p>
 * Title: ActionItemManager
 * </p>
 *
 * <p>
 * Description: Action Item Manager Class
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter, Modified by Sparsh Goel
 * @version 1.00
 * 
 */
public class ActionItemManager {

	// ---------------------------------------------------------------------------------------------------------------------
	// Constants

	private transient SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private boolean editChangesPending;

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes
	public static final int statusOpen = 0; // The constants for Open and Close
	public static final int statusClosed = 1;
	public static final String[] statusStrings = { "Open", "Closed" };
	private ActionItem currentActionItem = null;

	private ActionItem emptyActionItem = null; // The standard empty action item
	List<ActionItem> ailist = new ArrayList<ActionItem>();

	private AccessItemManager aiM = new AccessItemManager();

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItemManager class constructor.
	 * 
	 */
	public ActionItemManager() {
		currentActionItem = new ActionItem();

		emptyActionItem = new ActionItem();
		emptyActionItem.setCreatedDate(null);
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

	public ActionItemScreen combovalue(String name) throws Exception {

		return null;

	}

	public ActionItem updateActionItem(String name, String description, String resolution, String status,
			String dueDateStr) throws Exception {
		// Just allocate a new action item and save it. The inner workings of
		// this method will change drastically in Task 01 so I don't care about
		// being wasteful now.
		ActionItem ai = new ActionItem(name, description, resolution, status);

		// Check if there are problems with the modifications.
		validateActionItem(ai, name, dueDateStr);

		// We passed the tests so it's ok to set the new current action item
		setCurrentActionItem(ai);

		return ai;

	}

	/**
	 * Check the parameters to see if the action item can be added to the list of
	 * action items.
	 * 
	 * @param name       String
	 * @param dueDateStr String
	 * @return boolean
	 * @throws an exception if there are any problems with the input.
	 */
	private void validateActionItem(ActionItem ai, String name, String dueDateStr) throws Exception {
		if (name.trim().length() == 0) {
			throw new Exception("The Action Item Name must not be empty!   ");
		}

		Date dueDate = null;

		if (dueDateStr.length() != 0) {
			try {
				dueDate = dateFormat.parse(dueDateStr);
			} catch (ParseException ex) {
				throw new Exception("Please use the requested date format!   ");
			}
		}
		ai.setDueDate(dueDate);
	}

	public ActionItem createActionItem(String name, String description, String resolution, String status,
			String dueDateStr) throws Exception {
		ActionItem ai1 = new ActionItem(name, description, resolution, status);
		validateActionItem(ai1, name, dueDateStr);

		setCurrentActionItem(ai1);
		ailist.add(ai1);

		reestablishActionItemAccessList(ai1, ailist);
		return ai1;

	}

	public void reestablishActionItemAccessList(ActionItem ai1, List<ActionItem> nameList) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList(ai1, nameList);

		gui.ActionItemScreen.selectActionItemOptions.addAll(namesList);
	}

	// The usual getters and setters

	/**
	 * Get the current action item
	 * 
	 * @return - The current action item
	 */
	public ActionItem getCurrentActionItem() {
		if (currentActionItem == null)
			return emptyActionItem;
		return currentActionItem;
	}

	public void setCurrentActionItem(ActionItem x) {
		currentActionItem = x;
	}

	public void clearCurrentActionItem() {
		currentActionItem = emptyActionItem;
	}

	public void setDateFormatChecker() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	public void setEditChangesPending(boolean flag) {
		editChangesPending = flag;
	}

	public boolean getEditChangesPending() {
		return editChangesPending;
	}

	public List<String> getActionItemNames(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemcreatedate(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList1(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemduedate(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList2(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemduedate1(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList3(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemduedate2(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList4(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemcreatecreate(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList6(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemduedue(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList5(ai, ailist);
		return namesList;
	}

	public ActionItem setActionItem(String actionItemName) {
		for (ActionItem x : ailist) {
			if (x.getActionItemName().equalsIgnoreCase(actionItemName.trim())) {
				currentActionItem = x;
				return x;
			}
		}
		return emptyActionItem;
	}

}
