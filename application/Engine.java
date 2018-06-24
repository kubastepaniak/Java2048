package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Engine implements EventHandler<KeyEvent> {

	Grid grid;
	Scene scene;

	public Engine(Scene scene, Grid grid) {
		this.scene = scene;
		this.grid = grid;
		scene.setOnKeyPressed(this);
	}

	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == KeyCode.DOWN ||
		   event.getCode() == KeyCode.UP ||
		   event.getCode() == KeyCode.LEFT ||
		   event.getCode() == KeyCode.RIGHT) {
			Move move = new Move(event.getCode());
			move.shift();
			grid.addTile();
		}

		/*if(event.getCode() == KeyCode.UP) {
			move.shift();
			grid.addTile();
		}

		if(event.getCode() == KeyCode.LEFT) {
			move.shift();
			grid.addTile();
		}

		if(event.getCode() == KeyCode.RIGHT) {
			move.shift();
			grid.addTile();
		}*/
	}
}
