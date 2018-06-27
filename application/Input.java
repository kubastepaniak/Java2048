package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input implements EventHandler<KeyEvent> {

	Grid grid;
	Scene scene;

	public Input(Scene scene, Grid grid) {
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
			while(move.shift()) {
				move.shift();
			}
			grid.display();
		}

		if(event.getCode() == KeyCode.ESCAPE) {
			System.exit(0);
		}
	}
}
