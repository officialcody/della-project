package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import control.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ActionItem;
import model.ActionItemManager;
/**
 * <p>
 * Title: ConsoleScreen
 * </p>
 *
 * <p>
 * Description: Console Screen Class
 * </p>
 *
 * <p>
 * Copyright: Copyright ï¿½ 2005, 2006
 * </p>
 *
 * @author Harry Sameshima; Modified by Lynn Robert Carter, Modified by Sparsh Goel 2020-02-08
 * @version 1.01
 */
public class ConsoleScreen {

	private Label ActionItems = new Label("Action Items:");
	private Label Name = new Label("Name:");
	private Label SelActionItem = new Label("Selected Action Item:");
	private TextField ItemName = new TextField();
	private Label Description = new Label("Description:");
	private TextArea Area = new TextArea();
	private Label Resolution = new Label("Resolution:");
	private TextArea nxtArea = new TextArea();
	private Label sorting = new Label("Sorting Direction:");
	private Label firstsorting = new Label("First Sorting Factor:");
	private Label secondsorting = new Label("Second Sorting Factor:");
	ComboBox<String> sortcombo = new ComboBox<String>(
	FXCollections.observableArrayList("Small to Large", "Large to Small"));
	ComboBox<String> firstcombo = new ComboBox<String>(
			FXCollections.observableArrayList("None", "Creation Date", "Due Date"));
	ComboBox<String> secondcombo = new ComboBox<String>(
			FXCollections.observableArrayList("None", "Creation Date", "Due Date"));
	private Label dates = new Label("Dates");
	private Label creation = new Label("Creation:");
	private Label newdate = new Label();
	private Label duedate = new Label();
	private Label due = new Label("Due:");
	private Label Actionitem = new Label("Action Item");
	private Label Status = new Label("Status:");
	private Label ActiveStatus = new Label();
	private Label Copyright = new Label("Copyright \u24B8 2020 Sparsh Goel");
	ActionItemScreen Item = null;
	public static ListView<String> newlist = new ListView<String>();
	private Controller theController = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	ActionItemManager aiM;
	ActionItem ai;

	private Boolean updatingGUI = false;
	public static List<ActionItem> ailist = new ArrayList<ActionItem>();
	List<String> sortedList = new ArrayList<>();
	public static ObservableList<String> selectActionItemOptions = FXCollections.observableArrayList();

	public ConsoleScreen(Group consoleGroup) {
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();
		loadScreen();

		ActionItems.setLayoutX(15);
		ActionItems.setLayoutY(110);
		ActionItems.setStyle("-fx-font-weight: bold");

		newlist.setLayoutX(10);
		newlist.setLayoutY(140);
		newlist.setPrefWidth(410);
		newlist.setPrefHeight(200);

		SelActionItem.setLayoutX(10);
		SelActionItem.setLayoutY(350);
		SelActionItem.setStyle("-fx-font-weight: bold");

		Name.setLayoutX(10);
		Name.setLayoutY(370);
		Name.setStyle("-fx-font-weight: bold");

		ItemName.setLayoutX(60);
		ItemName.setLayoutY(370);
		ItemName.setPrefWidth(350);

		Description.setLayoutX(10);
		Description.setLayoutY(400);
		Description.setStyle("-fx-font-weight: bold");

		Area.setLayoutX(10);
		Area.setLayoutY(420);
		Area.setPrefWidth(410);
		Area.setPrefHeight(80);

		Resolution.setLayoutX(10);
		Resolution.setLayoutY(500);
		Resolution.setStyle("-fx-font-weight: bold");

		nxtArea.setLayoutX(10);
		nxtArea.setLayoutY(520);
		nxtArea.setPrefWidth(410);
		nxtArea.setPrefHeight(60);

		sorting.setLayoutX(450);
		sorting.setLayoutY(150);

		firstsorting.setLayoutX(450);
		firstsorting.setLayoutY(200);

		secondsorting.setLayoutX(450);
		secondsorting.setLayoutY(250);

		sortcombo.setLayoutX(450);
		sortcombo.setLayoutY(170);
		sortcombo.setPrefWidth(100);

		firstcombo.setLayoutX(450);
		firstcombo.setLayoutY(280);
		firstcombo.setPrefWidth(100);

		secondcombo.setLayoutX(450);
		secondcombo.setLayoutY(220);
		secondcombo.setPrefWidth(100);

		dates.setLayoutX(430);
		dates.setLayoutY(370);
		dates.setStyle("-fx-font-weight: bold");

		creation.setLayoutX(450);
		creation.setLayoutY(390);
		creation.setStyle("-fx-font-weight: bold");

		newdate.setLayoutX(510);
		newdate.setLayoutY(390);
		newdate.setStyle("-fx-font-weight: bold");

		due.setLayoutX(480);
		due.setLayoutY(410);
		due.setStyle("-fx-font-weight: bold");

		duedate.setLayoutX(510);
		duedate.setLayoutY(410);
		duedate.setStyle("-fx-font-weight: bold");

		Actionitem.setLayoutX(450);
		Actionitem.setLayoutY(430);
		Actionitem.setStyle("-fx-font-weight: bold");

		Status.setLayoutX(470);
		Status.setLayoutY(450);
		Status.setStyle("-fx-font-weight: bold");

		ActiveStatus.setLayoutX(510);
		ActiveStatus.setLayoutY(450);
		ActiveStatus.setStyle("-fx-font-weight: bold");

		Copyright.setLayoutX(440);
		Copyright.setLayoutY(580);
		Copyright.setStyle("-fx-font-weight: bold");

		newlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
					throws NullPointerException {
				selectActionItem(observableValue, oldValue, newValue);
			}

		});
		;

		consoleGroup.getChildren().addAll(ActionItems, newlist, SelActionItem, Name, ItemName, Description, Area,
				Resolution, nxtArea, firstcombo, firstsorting, sorting, secondsorting, secondcombo, sortcombo, dates,
				creation, newdate, due, duedate, Actionitem, Status, ActiveStatus, Copyright);

	}

	public void loadScreen() {

		updatingGUI = true;

		// Fetch the current action item. If there isn't one, leave now
		ActionItem ai = aiM.getCurrentActionItem();

		if (ai == null) {

			updatingGUI = true;

			newdate.setText("");
			newdate.setText("");
		} else {

			selectActionItemOptions.clear();
			newlist.getItems().clear();

			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			// Define the text fields
			updatingGUI = true;
			newlist.getItems().addAll(selectActionItemOptions);
			ItemName.setText(ai.getActionItemName());
			Area.setText(ai.getDescription());
			nxtArea.setText(ai.getResolution());
			ActiveStatus.setText(ai.getStatus());
		}
		// Define the status combobox value

//Define the creation and due dates
		if (ai.getCreatedDate() != null)
			newdate.setText(dateFormat.format(ai.getCreatedDate()));
		else
			newdate.setText("");
		if (ai.getDueDate() != null)
			duedate.setText(dateFormat.format(ai.getDueDate()));
		else
			duedate.setText("");

		updatingGUI = false;

	}

	void selectActionItem(ObservableValue<? extends String> ov, String oldValue, String newValue)
			throws NullPointerException {
		ActionItem ai = aiM.getCurrentActionItem();

		ai = aiM.getCurrentActionItem();
		aiM.setActionItem(newlist.getSelectionModel().getSelectedItem().toString());
		ai = aiM.setActionItem(newValue);

		String name = ai.getActionItemName().toString();
		String description = ai.getDescription().toString();
		String resolution = ai.getResolution().toString();
		String status = ai.getStatus().toString();

		ItemName.setText(name);
		Area.setText(description);
		nxtArea.setText(resolution);
		ActiveStatus.setText(status);
		newdate.setText(dateFormat.format(ai.getCreatedDate()));
		duedate.setText(dateFormat.format(ai.getDueDate()));

		theController = Controller.getInstance();
		theController.setDirtyFlag(true);

	}
}
