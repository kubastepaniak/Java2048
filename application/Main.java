package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
			Pane root = new Pane();
			Grid tileGrid = new Grid();
			root.getChildren().add(tileGrid);
			Scene scene = new Scene(root, tileGrid.getPixelWidth(), tileGrid.getPixelHeight() + interfaceMargin);
			Input game = new Input(scene, tileGrid);
			primaryStage.setScene(scene);
			primaryStage.setTitle("2048");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
