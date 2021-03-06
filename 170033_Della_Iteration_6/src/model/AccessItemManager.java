package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: AccessItemManager
 * </p>
 *
 * <p>
 * Description: A class to organize and manage all known access items
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

public class AccessItemManager {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


public void createAccessItem() {

}

public List<String> establishSortedAccessList (ActionItem ai, List<ActionItem> aiList) {
List<String> sortedList = new ArrayList<>();


for(ActionItem a : aiList) {
sortedList.add(a.getActionItemName().toString());
}


return sortedList;
}





public List<String> establishSortedAccessList1 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList1 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	String i = a.getActionMemberName()+" : "+a.getActionItemName();
sortedList1.add(i);



}


return sortedList1;
}

public List<String> establishSortedAccessList2 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList2 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = a.getActionMemberName()+" : "+dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList2.add(i);
}


return sortedList2;
}


public List<String> establishSortedAccessList3 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = a.getActionMemberName()+" : "+dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
}


return sortedList3;
}

public List<String> establishSortedAccessList4 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
}


return sortedList3;
}

public List<String> establishSortedAccessList5 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i =dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
}


return sortedList3;
}












}