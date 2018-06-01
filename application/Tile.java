package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Pane {

	public static final int TILE_SIZE = 125;

	boolean taken = false;
	int value = 2;
	String index;
	ImageView graphic;
	Rectangle background;

	public Tile(String index) {
		this.index = index;
		setBG();
	}

	public void setBG() {
		if(taken) {
			try {
				getChildren().clear();
				graphic = new ImageView(new Image(new FileInputStream(getFile())));
				graphic.setFitHeight(TILE_SIZE);
				graphic.setFitWidth(TILE_SIZE);
				getChildren().add(graphic);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			getChildren().clear();
			background = new Rectangle(0 , 0, TILE_SIZE, TILE_SIZE);
			background.setFill(Color.rgb(200, 150, 90));
			getChildren().add(background);
		}
	}

	public void occupy() {
		taken = true;
		setBG();
	}

	public void free() {
		taken = false;
		setBG();
	}

	public String getFile() {
		return "graphics/" + String.valueOf(value) + ".bmp";
	}

}
