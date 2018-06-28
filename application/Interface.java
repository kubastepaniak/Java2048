package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Interface extends StackPane {

	public static final int SPACING = 10;

	private static Text scoreText = new Text();
	private Text title;

	public Interface() {
		setPrefSize(Grid.getPixelWidth()-(2 * Main.margin), Main.interfaceMargin);
		setPadding(new Insets(0, 200, 50, 0));

		title = new Text("2048");
		title.setFont(new Font(100));
		title.setFill(Color.web("#786e64"));
		title.setStyle("-fx-font-weight: bold");

		updateScore();

		getChildren().addAll(title, scoreText);
		setAlignment(title, Pos.TOP_CENTER);
		setAlignment(scoreText, Pos.BOTTOM_LEFT);
	}

	public static void updateScore() {
		scoreText.setText("Score: " + String.valueOf(Main.score));
		scoreText.setFont(new Font(50));
		scoreText.setFill(Color.web("#786e64"));
		scoreText.setTextAlignment(TextAlignment.LEFT);
		scoreText.setY(225);
	}
}
