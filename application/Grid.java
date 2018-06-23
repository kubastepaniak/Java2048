package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.Node;
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
		setPadding(new Insets(Main.interfaceMargin + MARGIN, MARGIN, MARGIN, MARGIN));
		setup();
	}

	public void setup() {
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				Tile newTile = new Tile(String.valueOf(vertical * 10 + horizontal));
				add(newTile, horizontal, vertical);
			}
		}
	}

	public Tile getNode(int horizontal, int vertical) {
		for(Node node : this.getChildren()) {
			if(Grid.getColumnIndex(node) == horizontal && Grid.getRowIndex(node) == vertical) {
				return (Tile)node;
			}
		}
		return null;
	}

	public Tile getNode(String index) {
		return getNode(Character.getNumericValue(index.charAt(0)), Character.getNumericValue(index.charAt(1)));
	}

	public void addTile() {
		ArrayList<String> freeList = getFreeList();
		Random generator = new Random();
		int roll = generator.nextInt(freeList.size()) + 1;
		System.out.println(getChildren().get(1));

	}

	public ArrayList<String> getFreeList() {
		ArrayList<String> freeList = new ArrayList<String>();
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				Tile current = getNode(horizontal, vertical);
				freeList.add(current.index);
			}
		}
		return freeList;
	}

	public int getPixelWidth() {
		return 2 * MARGIN + width * (Tile.TILE_SIZE + SPACING) - SPACING;
	}

	public int getPixelHeight() {
		return 2 * MARGIN + height * (Tile.TILE_SIZE + SPACING) - SPACING;
	}
}
