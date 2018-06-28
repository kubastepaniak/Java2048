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
		if(Main.screens.current == "game") {
			if(event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP ||
			   event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
				Move move = new Move(event.getCode());
				if(move.mergePossible() || move.shift()) {
					move.merge();
					move.shift();
					grid.addTile();
				}

				int failCondition = 0;
				Move[] checks = {new Move(KeyCode.DOWN), new Move(KeyCode.UP), new Move(KeyCode.LEFT), new Move(KeyCode.RIGHT)};
				for(Move m : checks) {
					if(!m.mergePossible() && grid.getFreeList().size() == 0) {
						failCondition++;
					}
				}
				if(failCondition == 4) {
					Main.screens.setScreen("fail");
				}
			}

			if(event.getCode() == KeyCode.ESCAPE) {
				System.exit(0);
			}
		}
	}
}
