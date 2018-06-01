package application;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane {

	public static final int MARGIN = 75;
	public static final int SPACING = 10;

	final int width;
	final int height;

	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		setHgap(SPACING);
		setVgap(SPACING);
		setPadding(new Insets(MARGIN + Main.interfaceMargin, MARGIN, MARGIN, MARGIN));
		setup();
	}

	public void setup() {
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				Tile newTile = new Tile(String.valueOf(vertical * 10 + horizontal));
				newTile.occupy();
				add(newTile, horizontal, vertical);
			}
		}
	}

	public int getPixelWidth() {
		return 2 * MARGIN + width * (Tile.TILE_SIZE + SPACING) - SPACING;
	}

	public int getPixelHeight() {
		return 2 * MARGIN + height * (Tile.TILE_SIZE + SPACING) - SPACING;
	}
}
