package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane {

	public static final int SPACING = 10;

	private Tile[][] grid = Main.grid;
	private final int cols = Main.cols;
	private final int rows = Main.rows;

	public Grid() {
		setHgap(SPACING);
		setVgap(SPACING);
		setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));
		setMargin(this, new Insets(0, 200, 0, 0));
		setStyle("-fx-background-color: #bbada0;");
		setup();
	}


	public static void print() {
		System.out.print("\n");
		for(int row = 0; row < Main.rows; row++) {
			for(int col = 0; col < Main.cols; col++) {
				System.out.print("{" + Main.grid[col][row].value + "}");
			}
			System.out.print("\n");
		}
	}

	private void setup() {
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

	public static int getPixelWidth() {
		return 2 * Main.margin + Main.cols * (Tile.TILE_SIZE + SPACING) + SPACING;
	}

	public static int getPixelHeight() {
		return 2 * Main.margin + Main.rows * (Tile.TILE_SIZE + SPACING) + SPACING;
	}
}
