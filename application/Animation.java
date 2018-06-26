package application;

import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Animation {

	public TranslateTransition animation;
	private final KeyCode code;

	public Animation(Tile tile, final KeyCode code) {
		this.code = code;
		this.animation = new TranslateTransition(Duration.millis(500), tile);
		Main.mask.toFront();
		Main.mask.add(tile, tile.colIndex, tile.rowIndex);
		setStep();
	}

	private void setStep() {
		int step = Grid.SPACING + Tile.TILE_SIZE;
		if     (code == KeyCode.DOWN)  { animation.setByY(step); }
		else if(code == KeyCode.UP)    { animation.setByY(-step); }
		else if(code == KeyCode.RIGHT) { animation.setByX(step); }
		else if(code == KeyCode.LEFT)  { animation.setByX(-step); }
	}

}
