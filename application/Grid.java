package application;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

public class Grid extends Group {

	public static final int TILE_SIZE = 125;
	public static final int MARGIN = 75;
	public static final int SPACING = 10;

	final int width;
	final int height;
	ObservableList<Node> nodesList;
	Tile[][] gridItems;


	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.nodesList = this.getChildren();
		this.gridItems = new Tile[height][width];
		setup();
	}

	public void setup() {
		for(int vertical = 1; vertical <= height; vertical++) {
			for(int horizontal = 1; horizontal <= width; horizontal++) {
				Tile newTile = new Tile(vertical * 10 + horizontal, TILE_SIZE);
				gridItems[vertical - 1][horizontal - 1] = newTile;
				nodesList.add(newTile);
			}
		}
	}

	public int getPixelWidth() {
		return 2 * MARGIN + width * (TILE_SIZE + SPACING);
	}

	public int getPixelHeight() {
		return 2 * MARGIN + height * (TILE_SIZE + SPACING);
	}
}
