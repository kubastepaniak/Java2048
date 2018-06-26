package application;

import java.util.stream.IntStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	public void shift() {
		if(direction == KeyCode.RIGHT) {
			moveRight();
		}
	}

	private void moveRight() {
		for(int startCol : revRange(Main.cols - 1, 0).toArray()) {
			for(int curCol: IntStream.range(startCol, Main.cols - 1).toArray()) {
				for(int curRow : IntStream.range(0, Main.rows).toArray()) {
					if(Main.grid[curCol][curRow].taken && !Main.grid[curCol + 1][curRow].taken) {
						try {
							Tile temp = new Tile(curCol, curRow);
							temp.occupy(Main.grid[curCol][curRow].value);

							Main.grid[curCol][curRow].free();
							Animation movement = new Animation(temp, direction);
							movement.animation.play();
							movement.animation.setOnFinished(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									Main.grid[curCol + 1][curRow].occupy(temp.value);
									Main.mask.toBack();
									Main.mask.getChildren().clear();
								}
							});

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public void merge(int[][] blocks) {

		int[] first = blocks[0];
		int[] second = blocks[1];

		Main.grid[first[0]][first[1]].free();
		// animations
		Main.grid[second[0]][second[1]].doubleValue();
	}
}
