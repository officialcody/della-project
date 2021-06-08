package gui;

import control.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Element;
import model.Elementlist;

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
	private Boolean updatingGUI = false;

	public static ObservableList<String> selectActionItemOptions1 = FXCollections.observableArrayList();

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

		Memberlist.setLayoutX(430);
		Memberlist.setLayoutY(140);
		Memberlist.setPrefHeight(150);
		Memberlist.setPrefWidth(200);

		LxtName.setLayoutX(450);
		LxtName.setLayoutY(120);
		LxtName.setStyle("-fx-font-weight: bold");

		teamGroup.getChildren().addAll(Name, text1, AddName, Click, Type, Addlist, RemoveName, ClickName, Removelist,
				Add, Remove, Memberlist, LxtName);

	}
	
public void loadScreen() {


		

		Element e = ei.getCurrentActionItem1();
	setUpdatingGUI(true);

	// Fetch the current action item.  If there isn't one, leave now






		



	selectActionItemOptions1.clear();
	Memberlist.getItems().clear();
		selectActionItemOptions1.addAll(ei.getActionItemNames1(e));
		Memberlist.getItems().addAll(selectActionItemOptions1);
		
		
		
		
		




	// Define the text fields
	setUpdatingGUI(true);



	}

	private void crtscreen() throws NullPointerException {

		System.out.println(text1.getText());
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