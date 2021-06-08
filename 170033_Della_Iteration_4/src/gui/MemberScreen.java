package gui;

import control.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Elementlist;
/**
 * <p>
 * Title: MemberScreen
 * </p>
 *
 * <p>
 * Description: The Member Screen Class.
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006, 2007
 * </p>
 *
 * @author Harry Sameshima, Lynn Robert Carter, Modified by Sparsh Goel
 *         2020-02-08
 * @version 1.01
 */
public class MemberScreen {
	private Label Name = new Label("Name of someone new(Last, First Middle)");
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

	public static ObservableList<String> selectActionItemOptions1 = FXCollections.observableArrayList();

	private Label LxtName = new Label("Individuals known by Della");
	private Elementlist ei = null;

	private Controller theController = null;

	public MemberScreen(Group mainGroup) {

		theController = Controller.getInstance();
		ei = theController.getElementlist();

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

		Memberlist.setLayoutX(445);
		Memberlist.setLayoutY(140);
		Memberlist.setPrefHeight(150);
		Memberlist.setPrefWidth(200);

		LxtName.setLayoutX(450);
		LxtName.setLayoutY(120);
		LxtName.setStyle("-fx-font-weight: bold");

		mainGroup.getChildren().addAll(Name, text1, AddName, Click, Type, Addlist, RemoveName, ClickName, Removelist,
				Add, Remove, Memberlist, LxtName);

	}

	private void crtscreen() throws NullPointerException {

		System.out.println(text1.getText());
		Memberlist.getItems().add(text1.getText());

		try {
			ei.createActionItem1(text1.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

		theController.setDirtyFlag(true);

	}
}