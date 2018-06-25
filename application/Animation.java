package application;

import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Animation {

	private TranslateTransition animation;
//	private Tile tile;
//	private int colTo;
//	private int rowTo;
	private final KeyCode code;

	//public Animation(Tile tile, int colTo, int rowTo, final KeyCode code) {
	public Animation(Tile tile, final KeyCode code) {
		//this.tile = tile;
		//this.colTo = colTo;
		//this.rowTo = rowTo;
		this.code = code;
		this.animation = new TranslateTransition(Duration.millis(500), tile);
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
