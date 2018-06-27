package application;

import java.util.stream.IntStream;

import javafx.scene.input.KeyCode;

public class Move {

	private KeyCode direction;

	public Move(KeyCode direction) {
		this.direction = direction;
	}

	private IntStream revRange(int from, int to) {
	    return IntStream.range(to, from)
	                    .map(i -> to - i + from - 1);
	}

	public boolean shift() {
		if(direction == KeyCode.RIGHT) {
			return moveRight();
		}
		return false;
	}

	private boolean moveRight() {
		boolean check = false;
		for(int startCol : revRange(Main.cols - 1, 0).toArray()) {
			for(int curCol: IntStream.range(startCol, Main.cols - 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && !Main.grid[curCol + 1][curRow].taken) {
						Tile temp = new Tile(curCol, curRow);
						temp.occupy(Main.grid[curCol][curRow].value);
						Main.grid[curCol][curRow].free();
						Main.grid[curCol + 1][curRow].occupy(temp.value);
						check = true;
					}
				}
			}
		}
		return check;
	}
}
