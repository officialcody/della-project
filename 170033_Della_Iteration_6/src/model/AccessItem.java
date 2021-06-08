package model;

/**
 * <p>
 * Title: ActionItem
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
 * @author Lynn Robert Carter
 * @version 1.00 
 * @author Sparsh Goel
 * 
 */

public class AccessItem {

	String name;
	int nameIndex;

	public AccessItem() {
		name = "";
		nameIndex = 0;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public void setNameIndex(int nameIndex) {
		this.nameIndex = nameIndex;
	}

}
