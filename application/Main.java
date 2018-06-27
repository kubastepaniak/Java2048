package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int interfaceMargin = 300;
	public static final int margin = 75;

	public static final int cols = 4;
	public static final int rows = 4;
	public static Tile[][] grid = new Tile[cols][rows];

	public static int score = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Interface menu = new Interface();
			Grid tileGrid = new Grid();
			root.add(menu, 0, 0);
			root.add(tileGrid, 0, 1);

			root.setStyle("-fx-background-color: #faf8ef;");
			root.setPadding(new Insets(margin));

			Scene scene = new Scene(root, Grid.getPixelWidth(), Grid.getPixelHeight() + interfaceMargin);
			Input game = new Input(scene, tileGrid);

			primaryStage.setScene(scene);
			primaryStage.setTitle("2048");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
