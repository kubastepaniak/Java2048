package application;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class AfterEvent implements EventHandler<ActionEvent> {

	Tile previous;
	GridPane grid;
	int col;
	int colTo;
	int row;

	public AfterEvent(TranslateTransition tran, Tile prev, GridPane grid, int col, int row, int colTo) {
		this.grid = grid;
		this.previous = prev;
		this.col = col;
		this.colTo = colTo;
		this.row = row;
		tran.setOnFinished(this);
	}

	@Override
	public void handle(ActionEvent event) {
		grid.getChildren().clear();
		Main.grid[col][row] = null;
		Main.grid[colTo][row] = previous;
		grid.add(previous, colTo, row);
		grid.add(new Tile(100, 100), 0, 0);
		grid.add(new Tile(100, 100), 0, 1);
		grid.add(new Tile(100, 100), 1, 1);
	}
}
