package model;


/**
 * <p>
 * Title: AccessItem
 * </p>
 *
 * <p>
 * Description: The AccessItem Class
 * </p>
 *
 * @author Sparsh Goel
 * @version 1
 */
public class AccessItem {
	
	String name;
	int nameIndex;
	
	public AccessItem() {
		name="";
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
