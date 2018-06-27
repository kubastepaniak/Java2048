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
		if      (direction == KeyCode.RIGHT) { return moveRight(); }
		else if (direction == KeyCode.LEFT)  { return moveLeft(); }
		else if (direction == KeyCode.DOWN)  { return moveDown(); }
		else if (direction == KeyCode.UP)    { return moveUp(); }
		else    { return false; }
	}

	public void merge() {
		if      (direction == KeyCode.RIGHT) { mergeRight(); }
		else if (direction == KeyCode.LEFT)  { mergeLeft(); }
		else if (direction == KeyCode.DOWN)  { mergeDown(); }
		else if (direction == KeyCode.UP)    { mergeUp(); }
	}

	public boolean mergePossible() {
		if      (direction == KeyCode.RIGHT) { return mergeRightPossible(); }
		else if (direction == KeyCode.LEFT)  { return mergeLeftPossible(); }
		else if (direction == KeyCode.DOWN)  { return mergeDownPossible(); }
		else if (direction == KeyCode.UP)    { return mergeUpPossible(); }
		else    { return false; }
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

	private boolean moveLeft() {
		boolean check = false;
		for(int startCol : IntStream.range(1, Main.cols).toArray()) {
			for(int curCol: revRange(startCol + 1, 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && !Main.grid[curCol - 1][curRow].taken) {
						Tile temp = new Tile(curCol, curRow);
						temp.occupy(Main.grid[curCol][curRow].value);
						Main.grid[curCol][curRow].free();
						Main.grid[curCol - 1][curRow].occupy(temp.value);
						check = true;
					}
				}
			}
		}
		return check;
	}

	private boolean moveDown() {
		boolean check = false;
		for(int startRow : revRange(Main.rows - 1, 0).toArray()) {
			for(int curRow: IntStream.range(startRow, Main.rows - 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && !Main.grid[curCol][curRow + 1].taken) {
						Tile temp = new Tile(curCol, curRow);
						temp.occupy(Main.grid[curCol][curRow].value);
						Main.grid[curCol][curRow].free();
						Main.grid[curCol][curRow + 1].occupy(temp.value);
						check = true;
					}
				}
			}
		}
		return check;
	}

	private boolean moveUp() {
		boolean check = false;
		for(int startRow : IntStream.range(1, Main.rows).toArray()) {
			for(int curRow: revRange(startRow + 1, 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && !Main.grid[curCol][curRow - 1].taken) {
						Tile temp = new Tile(curCol, curRow);
						temp.occupy(Main.grid[curCol][curRow].value);
						Main.grid[curCol][curRow].free();
						Main.grid[curCol][curRow - 1].occupy(temp.value);
						check = true;
					}
				}
			}
		}
		return check;
	}

	private void mergeRight() {
		for(int startCol : revRange(Main.cols - 1, 0).toArray()) {
			for(int curCol: IntStream.range(startCol, Main.cols - 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol + 1][curRow].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol + 1][curRow].value) {
						Main.grid[curCol][curRow].free();
						Main.grid[curCol + 1][curRow].doubleValue();
					}
				}
			}
		}
	}

	private void mergeLeft() {
		for(int startCol : IntStream.range(1, Main.cols).toArray()) {
			for(int curCol: revRange(startCol + 1, 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol - 1][curRow].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol - 1][curRow].value) {
						Main.grid[curCol][curRow].free();
						Main.grid[curCol - 1][curRow].doubleValue();
					}
				}
			}
		}
	}

	private void mergeDown() {
		for(int startRow : revRange(Main.rows - 1, 0).toArray()) {
			for(int curRow: IntStream.range(startRow, Main.rows - 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol][curRow + 1].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol][curRow + 1].value) {
						Main.grid[curCol][curRow].free();
						Main.grid[curCol][curRow + 1].doubleValue();
					}
				}
			}
		}
	}

	private void mergeUp() {
		for(int startRow : IntStream.range(1, Main.rows).toArray()) {
			for(int curRow: revRange(startRow + 1, 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol][curRow - 1].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol][curRow - 1].value) {
						Main.grid[curCol][curRow].free();
						Main.grid[curCol][curRow - 1].doubleValue();
					}
				}
			}
		}
	}

	private boolean mergeRightPossible() {
		for(int startCol : revRange(Main.cols - 1, 0).toArray()) {
			for(int curCol: IntStream.range(startCol, Main.cols - 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol + 1][curRow].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol + 1][curRow].value) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean mergeLeftPossible() {
		for(int startCol : IntStream.range(1, Main.cols).toArray()) {
			for(int curCol: revRange(startCol + 1, 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol - 1][curRow].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol - 1][curRow].value) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean mergeDownPossible() {
		for(int startRow : revRange(Main.rows - 1, 0).toArray()) {
			for(int curRow: IntStream.range(startRow, Main.rows - 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol][curRow + 1].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol][curRow + 1].value) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean mergeUpPossible() {
		for(int startRow : IntStream.range(1, Main.rows).toArray()) {
			for(int curRow: revRange(startRow + 1, 1).toArray()) {
				for(int curCol : IntStream.range(0, Main.cols).toArray()) {
					if(Main.grid[curCol][curRow].taken && Main.grid[curCol][curRow - 1].taken &&
					   Main.grid[curCol][curRow].value == Main.grid[curCol][curRow - 1].value) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
