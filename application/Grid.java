package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane {

	public static final int MARGIN = 75;
	public static final int SPACING = 10;

	private Tile[][] grid = Main.grid;
	private final int cols = Main.cols;
	private final int rows = Main.rows;

	public Grid() {
		setHgap(SPACING);
		setVgap(SPACING);
		setPadding(new Insets(Main.interfaceMargin + MARGIN, MARGIN, MARGIN, MARGIN));
		setup();
	}

	public void setup() {
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				grid[col][row] = new Tile(col, row);
			}
		}
		addTile();
		addTile();
		display();
	}

	public void display() {
		getChildren().clear();
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				add(grid[col][row], col, row);
			}
		}
	}

	public void addTile() {
		ArrayList<Integer[]> freeList = getFreeList();
		Random generator = new Random();
		System.out.println(freeList.size());
		int roll = generator.nextInt(freeList.size());
		grid[freeList.get(roll)[0]][freeList.get(roll)[1]].occupy();
	}

	public ArrayList<Integer[]> getFreeList() {
		ArrayList<Integer[]> freeList = new ArrayList<Integer[]>();
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				if(!grid[col][row].taken) {
					freeList.add(new Integer[] {col, row});
				}
			}
		}
		return freeList;
	}

	public int getPixelWidth() {
		return 2 * MARGIN + cols * (Tile.TILE_SIZE + SPACING) - SPACING;
	}

	public int getPixelHeight() {
		return 2 * MARGIN + rows * (Tile.TILE_SIZE + SPACING) - SPACING;
	}
}
