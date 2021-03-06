package gui;

import control.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Element;
import model.Elementlist;
import model.data;

/**
 * <p>
 * Title: TeamScreen
 * </p>
 *
 * <p>
 * Description: The Della Team Screen code
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter, Modified by Sparsh Goel 2020-01-25
 * @version 1.01 Many thanks to Harry Sameshima for his original work.
 */

public class TeamScreen {
	private Label Name = new Label("Name of new team");
	private Label AddName = new Label("To add a name to the list:");
	private Label Click = new Label("1. Click on the box above.");
	private Label Type = new Label("2.Type the name.");
	private Label Addlist = new Label("3.Click to \u201C Add to list\u201D Button.");
	public static TextField text1 = new TextField();
	private Label RemoveName = new Label("To remove a name to the list:");
	private Label ClickName = new Label("1. Click on the name to remove.");
	private Label Removelist = new Label("2. Click on \u201C Remove from list\u201D Button.");
	private Button Add = new Button("Add to List ->");
	private Button Remove = new Button("<- Remove from List");
	public static ListView<String> Memberlist = new ListView<String>();
	private Button Addaf = new Button("Add affiliation ->");
	private Button Removeaf = new Button("<- Remove affiliation");
	private Boolean updatingGUI = false;
	private Label Affiliation5 = new Label();
	private Label Affiliation55 = new Label();
	public static ListView<String> teamlist = new ListView<String>();

	public static ListView<String> currentteam = new ListView<String>();

	public static ObservableList<String> selectActionItemOptions1 = FXCollections.observableArrayList();
	public static ObservableList<String> selectActionItemOptions2 = FXCollections.observableArrayList();

	private Label LxtName = new Label("Team known by Della");
	private Elementlist ei = null;

	private Controller theController = null;

	public TeamScreen(Group teamGroup) {
		theController = Controller.getInstance();
		ei = theController.getElementlist();
		loadScreen();
		Name.setLayoutX(15);
		Name.setLayoutY(120);
		Name.setStyle("-fx-font-weight: bold");

		text1.setLayoutX(15);
		text1.setLayoutY(140);
		text1.setPrefWidth(200);

		AddName.setLayoutX(15);
		AddName.setLayoutY(180);
		AddName.setStyle("-fx-font-weight: bold");

		Click.setLayoutX(15);
		Click.setLayoutY(200);

		Type.setLayoutX(15);
		Type.setLayoutY(220);

		Addlist.setLayoutX(15);
		Addlist.setLayoutY(240);

		Affiliation5.setLayoutX(15);
		Affiliation5.setLayoutY(480);

		Addaf.setLayoutX(250);
		Addaf.setLayoutY(500);
		Addaf.setPrefWidth(150);
		Addaf.setOnAction(e -> {
			crtscreen1();
		});

		Removeaf.setLayoutX(250);
		Removeaf.setLayoutY(550);
		Removeaf.setPrefWidth(150);

		Affiliation55.setLayoutX(450);
		Affiliation55.setLayoutY(480);

		RemoveName.setLayoutX(15);
		RemoveName.setLayoutY(300);
		RemoveName.setStyle("-fx-font-weight: bold");

		ClickName.setLayoutX(15);
		ClickName.setLayoutY(320);

		Removelist.setLayoutX(15);
		Removelist.setLayoutY(340);

		Add.setLayoutX(250);
		Add.setLayoutY(200);
		Add.setPrefWidth(150);
		Add.setOnAction(e -> {

			try {
				crtscreen();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		Remove.setLayoutX(250);
		Remove.setLayoutY(250);
		Remove.setPrefWidth(150);
		Remove.setOnAction(e -> {

			final int selectedIdx = Memberlist.getSelectionModel().getSelectedIndex();
			if (selectedIdx != -1) {
				@SuppressWarnings("unused")
				final int newSelectedIdx = (selectedIdx == Memberlist.getItems().size() - 1) ? selectedIdx - 1
						: selectedIdx;

				Memberlist.getItems().remove(selectedIdx);

			}
		});

		Memberlist.setLayoutX(440);
		Memberlist.setLayoutY(140);
		Memberlist.setPrefHeight(150);
		Memberlist.setPrefWidth(200);

		teamlist.setLayoutX(15);
		teamlist.setLayoutY(490);
		teamlist.setPrefHeight(100);
		teamlist.setPrefWidth(200);

		currentteam.setLayoutX(450);
		currentteam.setLayoutY(490);
		currentteam.setPrefHeight(100);
		currentteam.setPrefWidth(200);

		LxtName.setLayoutX(450);
		LxtName.setLayoutY(120);
		LxtName.setStyle("-fx-font-weight: bold");

		Memberlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
					throws NullPointerException {
			}

		});

		teamGroup.getChildren().addAll(Name, text1, AddName, Click, Type, Addlist, RemoveName, ClickName, Removelist,
				Add, Remove, Memberlist, LxtName, Affiliation5, Affiliation55, teamlist, currentteam, Addaf, Removeaf);

	}

	public void loadScreen() {

		Element e = ei.getCurrentActionItem1();
		data eo = ei.getCurrentActionItem33();
		setUpdatingGUI(true);

		selectActionItemOptions2.clear();
		currentteam.getItems().clear();
		selectActionItemOptions2.addAll(ei.getActionItemNames(e));
		currentteam.getItems().addAll(selectActionItemOptions2);

		teamlist.getItems().addAll(selectActionItemOptions2);

		selectActionItemOptions1.clear();
		Memberlist.getItems().clear();
		selectActionItemOptions1.addAll(ei.getActionItemNames1(e));
		Memberlist.getItems().addAll(selectActionItemOptions1);

		Affiliation55.setText(eo.getMemberName1());

// Define the text fields
		setUpdatingGUI(true);

	}

	private void crtscreen1() throws NullPointerException {

		selectActionItemOptions2.clear();

		selectActionItemOptions2.addAll(teamlist.getSelectionModel().getSelectedItem().toString());
		currentteam.getItems().addAll(selectActionItemOptions2);

		try {

			ei.createActionItem33(teamlist.getSelectionModel().getSelectedItem().toString(),
					Memberlist.getSelectionModel().getSelectedItem().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		theController.setDirtyFlag(true);

	}

	private void crtscreen() throws NullPointerException {
		Memberlist.getItems().add(text1.getText());
		try {
			ei.createActionItem2(text1.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		theController.setDirtyFlag(true);
	}

	public Boolean getUpdatingGUI() {
		return updatingGUI;
	}

	public void setUpdatingGUI(Boolean updatingGUI) {
		this.updatingGUI = updatingGUI;
	}

}