package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int interfaceMargin = 300;
	public static final int margin = 75;

	public static final int cols = 4;
	public static final int rows = 4;
	public static Tile[][] grid = new Tile[cols][rows];

	public static int score = 0;
	public static ScreenController screens = new ScreenController();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, Grid.getPixelWidth(), Grid.getPixelHeight() + interfaceMargin);


			screens.setScene(scene);
			screens.setup();
			root.getChildren().add(screens);
			screens.setScreen("menu");

			primaryStage.setScene(scene);
			primaryStage.setTitle("2048");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
