package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {

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
			getChildren().clear();
			Image image = new Image(getClass().getResourceAsStream(getFile()));
			graphic = new ImageView(image);
			graphic.setFitHeight(TILE_SIZE);
			graphic.setFitWidth(TILE_SIZE);
			getChildren().add(graphic);
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
		return "/resources/" + String.valueOf(value) + ".bmp";
	}

}
