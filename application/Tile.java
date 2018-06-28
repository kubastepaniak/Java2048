package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

	public static final int TILE_SIZE = 125;

	boolean taken;
	int value;
	int verticalIndex;
	int horizontalIndex;
	Text text;
	Rectangle background;

	public Tile(int hor, int ver) {
		this.value = 0;
		this.horizontalIndex = hor;
		this.verticalIndex = ver;
		this.taken = false;
		setBG();
	}

	private void setBG() {
		if(taken) {
			getChildren().clear();
			background = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
			background.setFill(getRectColor());
			text = new Text(String.valueOf(value));
			if(value < 1000) {
				text.setFont(new Font(50));
			} else {
				text.setFont(new Font(30));
			}
			text.setStyle("-fx-font-weight: bold");
			text.setFill(getTextColor());
			getChildren().addAll(background, text);
		}
		else {
			getChildren().clear();
			background = new Rectangle(0 , 0, TILE_SIZE, TILE_SIZE);
			background.setFill(Color.web("#cdc1b4"));
			getChildren().add(background);
		}
	}

	private Color getTextColor() {
		if(value == 2 || value == 4) {
			return Color.rgb(120, 110, 100);
		} else {
			return Color.WHITE;
		}
	}

	private Color getRectColor() {
		switch(value) {
		case 2: return Color.web("#eee4da");
		case 4: return Color.web("#ede0c8");
		case 8: return Color.web("#f2b179");
		case 16: return Color.web("#f59563");
		case 32: return Color.web("#f67c5f");
		case 64: return Color.web("#f65e3b");
		case 128: return Color.web("#edcf72");
		case 256: case 512:	case 1024: case 2048: return Color.web("#edc850");
		default: return Color.WHITE;
		}
	}

	public void occupy() {
		taken = true;
		value = 2;
		setBG();
	}

	public void occupy(int points) {
		taken = true;
		value = points;
		setBG();
	}

	public void free() {
		taken = false;
		value = 0;
		setBG();
	}

	public void doubleValue() {
		this.value *= 2;
		Main.score += value;
		Interface.updateScore();
		setBG();

		if(this.value == 2048) {
			Main.screens.setScreen("win");
		}
	}
}-
