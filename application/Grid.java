package application;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

public class Grid extends Group {

	final int width;
	final int height;
	final int spacing = 10;
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
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				Tile newTile = new Tile((horizontal*150)+75, (vertical*150)+350, 125, 125);
				gridItems[vertical][horizontal] = newTile;
				nodesList.add(newTile);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSpacing() {
		return spacing;
	}
}
