package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int interfaceMargin = 300;

	public static final int cols = 4;
	public static final int rows = 4;
	public static Tile[][] grid = new Tile[cols][rows];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Grid root = new Grid();
			Scene scene = new Scene(root, root.getPixelWidth(), root.getPixelHeight() + interfaceMargin);
			Input game = new Input(scene, root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
