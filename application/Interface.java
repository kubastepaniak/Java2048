package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Interface extends Pane {

	public static final int SPACING = 10;

	private static Text scoreText = new Text();
	private Text title;

	public Interface() {
		setPrefSize(Grid.getPixelWidth(), Main.interfaceMargin);

		title = new Text("2048");
		title.setFont(new Font(100));
		title.setFill(Color.web("#786e64"));
		title.setX(Grid.getPixelWidth() / 5);
		title.setY(75);

		updateScore();

		getChildren().addAll(title, scoreText);
	}

	public static void updateScore() {
		scoreText.setText("Score: " + String.valueOf(Main.score));
		scoreText.setFont(new Font(50));
		scoreText.setFill(Color.web("#786e64"));
		scoreText.setTextAlignment(TextAlignment.LEFT);
		scoreText.setY(225);
	}
}
