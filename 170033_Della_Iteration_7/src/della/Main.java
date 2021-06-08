package della;

import gui.MainScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * <p>
 * Title: Della
 * </p>
 *
 * <p>
 * Description: An issue and action logging and tracking manager
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006
 * </p>
 *
 * @author Harry Sameshima; Modified by Lynn Robert Carter, Modified by Sparsh Goel
 *         2020-01-25
 * @version 1.01
 */
public class Main extends Application {

	public static int MAIN_HEIGHT = 600;
	public static int MAIN_WIDTH = 700;

	public gui.MainScreen theGUI;

	/**
	 * Setup the main stage of the Application
	 *
	 * @param mainStage
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("Della 07");
		Pane mainPane = new Pane();
		theGUI = new MainScreen(mainPane);
		Scene mainScene = new Scene(mainPane, MAIN_WIDTH, MAIN_HEIGHT);
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	/**
	 * Application entry point.
	 *
	 * @param args String[]
	 */
	public static void main(String[] args) {
		launch(args);
	}
}