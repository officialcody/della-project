package control;

import model.*;
import persistence.*;

/**
 * <p>
 * Title: Controller
 * </p>
 *
 * <p>
 * Description: A singleton class to control instances of the assorted managers
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005
 * </p>
 *
 * @author Sparsh Goel 2020-02-08
 * @version 1.01
 */
public class Controller {
	//---------------------------------------------------------------------------------------------------------------------
	// Controller Attributes

	private static Controller theController = null;
	private ActionItemManager actionItemManager = null;
	private Elementlist ei = null;
	private static boolean dirtyFlag = false; // Has Della's state changed?
	//---------------------------------------------------------------------------------------------------------------------

	/*
      This constructor is private and synchronized because we are using the singleton design pattern and we want only one!
	 */
	private Controller() {
	}

	/**
	 * Return the singleton instance of the Controller class
	 * @return Controller
	 */
	public static synchronized Controller getInstance() {
		// If theController is not initialized, we start by trying to read the intial state from the xml file
		if (theController == null) {
			theController = (Controller) DataManager.readData();

			// If theController is still null, we were not able to initialize from the xml file
			if (theController == null) {
				theController = new Controller();	// So we must initialize by calling the constructor and
				theController.setActionItemManager(new ActionItemManager());	// create an Action Item
				theController.setElementlist(new Elementlist());
				
			}
			
		}
		return theController;
	}

	/**
	 * Save the current controller and all of the data objects rooted here to the persistent store
	 */
	public void save() {
		dirtyFlag = false;
		DataManager.writeData(this);
	}
	// The usual collection of getters and setters
	public ActionItemManager getActionItemManager() { return actionItemManager; }

	public boolean getDirtyFlag() { return dirtyFlag; }

	public void setActionItemManager(ActionItemManager x) { actionItemManager = x; }

	public void setDirtyFlag(boolean x) { dirtyFlag = x; }
	
	
	public Elementlist getElementlist() { return ei; }
	
	public void setElementlist(Elementlist x) { ei = x; }
	
	
}
