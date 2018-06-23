package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane {

	public static final int MARGIN = 75;
	public static final int SPACING = 10;

	public Tile[][] grid;
	final int height;
	final int width;

	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		this.grid = new Tile[height][width];
		setHgap(SPACING);
		setVgap(SPACING);
		setPadding(new Insets(Main.interfaceMargin + MARGIN, MARGIN, MARGIN, MARGIN));
		setup();
	}

	public void setup() {
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				grid[horizontal][vertical] = new Tile(horizontal, vertical);
			}
		}
		display();
	}

	public void display() {
		getChildren().clear();
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				add(grid[horizontal][vertical], horizontal, vertical);
			}
		}
	}

	public void addTile() {
		ArrayList<Integer[]> freeList = getFreeList();
		Random generator = new Random();
		int roll = generator.nextInt(freeList.size());
		grid[freeList.get(roll)[0]][freeList.get(roll)[1]].occupy();
	}

	public ArrayList<Integer[]> getFreeList() {
		ArrayList<Integer[]> freeList = new ArrayList<Integer[]>();
		for(int vertical = 0; vertical < height; vertical++) {
			for(int horizontal = 0; horizontal < width; horizontal++) {
				if(!grid[horizontal][vertical].taken) {
					freeList.add(new Integer[] {horizontal, vertical});
				}
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
