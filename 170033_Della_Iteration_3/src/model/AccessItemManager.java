package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Title: AccessItemManager.
 * </p>
 *
 * <p>
 * Description: Access Item Manager Class.
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2005
 * </p>
 *
 * @author Sparsh Goel
 * @version 1
 */
public class AccessItemManager {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
public ArrayList<AccessItem> accessList = null;
public AccessItem aI = null;

public AccessItemManager() {
aI = new AccessItem();
}

public void createAccessItem() {

}

public List<String> establishSortedAccessList (ActionItem ai, List<ActionItem> aiList) {
List<String> sortedList = new ArrayList<>();


for(ActionItem a : aiList) {
sortedList.add(a.getActionItemName().toString());
}

Collections.sort(sortedList);
return sortedList;
}


public List<String> establishSortedAccessList123 (ActionItem ai, List<ActionItem> aiList1) {
List<String> sortedList = new ArrayList<>();


for(ActionItem a : aiList1) {
sortedList.add(a.getActionItemName().toString());
}

Collections.sort(sortedList);
return sortedList;
}


public List<String> establishSortedAccessList1 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList1 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	String i = dateFormat.format(a.getCreatedDate())+" : "+a.getActionItemName();
sortedList1.add(i);



}

Collections.sort(sortedList1);


Collections.sort(sortedList1);
return sortedList1;
}

public List<String> establishSortedAccessList2 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList2 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = dateFormat.format(a.getDueDate())+" : "+a.getActionItemName();
sortedList2.add(i);
}

Collections.sort(sortedList2);


Collections.sort(sortedList2);
return sortedList2;
}


public List<String> establishSortedAccessList3 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList3 = new ArrayList<>();


for(ActionItem a : aiList) {
	
	String i = dateFormat.format(a.getCreatedDate())+" : "+dateFormat.format(a.getDueDate()) +" : "+ a.getActionItemName();
	sortedList3.add(i);




}


Collections.sort(sortedList3);
return sortedList3;
}


public List<String> establishSortedAccessList4 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList4 = new ArrayList<>();


for(ActionItem a : aiList) {
	
	String i = dateFormat.format(a.getDueDate())+" : "+dateFormat.format(a.getCreatedDate()) +" : "+ a.getActionItemName();
	sortedList4.add(i);




}


Collections.sort(sortedList4);
return sortedList4;
}



public List<String> establishSortedAccessList5 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList5 = new ArrayList<>();


for(ActionItem a : aiList) {
	
	String i = dateFormat.format(a.getDueDate())+" : "+dateFormat.format(a.getDueDate()) +" : "+ a.getActionItemName();
	sortedList5.add(i);




}


Collections.sort(sortedList5);
return sortedList5;
}



public List<String> establishSortedAccessList6 (ActionItem ai, List<ActionItem> aiList) {

List<String> sortedList6 = new ArrayList<>();


for(ActionItem a : aiList) {
	
	String i = dateFormat.format(a.getCreatedDate())+" : "+dateFormat.format(a.getCreatedDate()) +" : "+ a.getActionItemName();
	sortedList6.add(i);




}


Collections.sort(sortedList6);
return sortedList6;
}








public ArrayList<AccessItem> getAccessList() {
return accessList;
}

public int getAccessIndex() {
return aI.getNameIndex();
}

public int size() {
return accessList.size();
}
}