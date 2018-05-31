package application;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

	int index;
	int value = 1;
	boolean taken = false;
	Image graphic;

	public Tile(int index, int size) {
		this.index = index;
		setWidth(size);
		setHeight(size);
		setXY();
	}

	public void setXY() {
		setX((double)((index / 10) - 1) * (Grid.TILE_SIZE + Grid.SPACING) + Grid.MARGIN);
		setY((double)((index % 10) - 1) * (Grid.TILE_SIZE + Grid.SPACING) + Main.interfaceMargin + Grid.MARGIN);
	}

	public String getFile() {
		if(taken){
			return "../graphics" + String.valueOf(value) + ".bmp";
		}
		else {
			return "";
		}
	}

}
