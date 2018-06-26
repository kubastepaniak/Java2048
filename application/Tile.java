package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane implements Cloneable {

	public static final int TILE_SIZE = 125;
	public static final int TEXT_FONT = 50;

	boolean dummy = false;
	boolean taken;
	int value = 2;
	int colIndex;
	int rowIndex;
	Text text;
	Rectangle background;

	public Tile(int col, int row) {
		this.colIndex = col;
		this.rowIndex = row;
		this.taken = false;
		setBG();
	}

	public Tile(int col, int row, boolean dummy) {
		this.dummy = dummy;
		setBG();
	}

	public void setBG() {
		if(dummy) {
			getChildren().clear();
			background = new Rectangle(0 , 0, TILE_SIZE, TILE_SIZE);
			background.setFill(Color.TRANSPARENT);
			getChildren().add(background);
		}
		else {
			if(taken) {
				getChildren().clear();
				background = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
				background.setFill(Color.rgb(230, 200, 150));
				text = new Text(String.valueOf(value));
				text.setFont(new Font(TEXT_FONT));
				text.setFill(Color.WHITE);
				getChildren().addAll(background, text);
			}
			else {
				getChildren().clear();
				background = new Rectangle(0 , 0, TILE_SIZE, TILE_SIZE);
				background.setFill(Color.rgb(200, 150, 90));
				getChildren().add(background);
			}
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
		value = 2;
		setBG();
	}

	public void doubleValue() {
		this.value = 2 * this.value;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
