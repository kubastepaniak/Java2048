package application;

import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScreenController extends StackPane {

	private HashMap<String, Node> screens = new HashMap<>();
	public Scene scene;
	public String current;

	public void setup() {
		addScreen("game", mainGame());
		addScreen("menu", menu());
		addScreen("win", win());
		addScreen("fail", fail());
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	private void addScreen(String name, Node screen) {
		screens.put(name, screen);
	}

	public void setScreen(String name) {
		if(!getChildren().isEmpty()) {
			getChildren().clear();
			getChildren().add(screens.get(name));
			current = name;
		} else {
			current = name;
			getChildren().add(screens.get(name));
		}
	}

	private GridPane mainGame() {
		GridPane root = new GridPane();
		Interface menu = new Interface();
		Grid tileGrid = new Grid();

		root.add(menu, 0, 0);
		root.add(tileGrid, 0, 1);
		root.setStyle("-fx-background-color: #faf8ef;");
		root.setPadding(new Insets(Main.margin));

		Input game = new Input(scene, tileGrid);

		return root;
	}

	private StackPane menu() {
		StackPane root = new StackPane();
		root.setPrefSize(Grid.getPixelWidth(), Grid.getPixelHeight() + Main.interfaceMargin);
		root.setStyle("-fx-background-color: #faf8ef;");
		root.setPadding(new Insets(2 * Main.margin, Main.margin, Main.margin, Main.margin));

		GridPane container = new GridPane();
		container.setVgap(25);
		container.setPrefWidth(275);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(0, 0, 250, 0));

		Text title = new Text("2048");
		title.setFont(new Font(100));
		title.setFill(Color.web("#786e64"));
		title.setStyle("-fx-font-weight: bold");

		Button start = new Button("Start");
		Button quit = new Button("Exit");
		start.setStyle("-fx-font: 30px arial; -fx-base: #786e64");
		start.setMinSize(275, 75);
		quit.setStyle("-fx-font: 30px arial; -fx-base: #786e64");
		quit.setMinSize(275, 75);

		container.add(title, 0, 0);
		container.add(start, 0, 1);
		container.add(quit, 0, 2);
		root.getChildren().add(container);

		start.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setScreen("game");
			}
		});

		quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});

		return root;
	}

	private StackPane win() {
		StackPane root = new StackPane();
		root.setPrefSize(Grid.getPixelWidth(), Grid.getPixelHeight() + Main.interfaceMargin);
		root.setStyle("-fx-background-color: #faf8ef;");
		root.setPadding(new Insets(2 * Main.margin, Main.margin, Main.margin, Main.margin));

		GridPane container = new GridPane();
		container.setVgap(25);
		container.setPrefWidth(275);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(0, 0, 250, 0));

		Text title = new Text("2048");
		title.setFont(new Font(100));
		title.setFill(Color.web("#786e64"));
		title.setStyle("-fx-font-weight: bold");

		Text win = new Text("Congratulations!\nYou have reached tile 2048!");
		win.setFont(new Font(30));
		win.setFill(Color.web("#786e64"));

		Button quit = new Button("Exit");
		quit.setStyle("-fx-font: 30px arial; -fx-base: #786e64");
		quit.setMinSize(275, 75);

		container.add(title, 0, 0);
		container.add(win, 0, 1);
		container.add(quit, 0, 2);
		root.getChildren().add(container);

		quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});

		return root;
	}

	private StackPane fail() {
		StackPane root = new StackPane();
		root.setPrefSize(Grid.getPixelWidth(), Grid.getPixelHeight() + Main.interfaceMargin);
		root.setStyle("-fx-background-color: #faf8ef;");
		root.setPadding(new Insets(2 * Main.margin, Main.margin, Main.margin, Main.margin));

		GridPane container = new GridPane();
		container.setVgap(25);
		container.setPrefWidth(275);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(0, 0, 250, 0));

		Text title = new Text("2048");
		title.setFont(new Font(100));
		title.setFill(Color.web("#786e64"));
		title.setStyle("-fx-font-weight: bold");

		Text fail = new Text("You failed!\nNo move or merge possible");
		fail.setFont(new Font(30));
		fail.setFill(Color.web("#786e64"));

		Button quit = new Button("Exit");
		quit.setStyle("-fx-font: 30px arial; -fx-base: #786e64");
		quit.setMinSize(275, 75);

		container.add(title, 0, 0);
		container.add(fail, 0, 1);
		container.add(quit, 0, 2);
		root.getChildren().add(container);

		quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});

		return root;
	}
}
