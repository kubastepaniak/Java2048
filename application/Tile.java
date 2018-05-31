package application;

import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

	int index;
	int value;
	boolean taken;
	int x;
	int y;

	public Tile(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
}
