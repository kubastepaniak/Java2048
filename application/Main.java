package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int interfaceMargin = 300;

	public static final int height = 4;
	public static final int width = 4;
	public static Tile[][] grid = new Tile[height][width];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Grid root = new Grid(height, width);
			Scene scene = new Scene(root, root.getPixelWidth(), root.getPixelHeight() + interfaceMargin);
			Engine game = new Engine(scene, root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
