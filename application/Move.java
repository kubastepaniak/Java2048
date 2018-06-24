package application;

import java.util.stream.IntStream;

import javafx.scene.input.KeyCode;

public class Move {

	private KeyCode direction;

	public Move(KeyCode direction) {
		this.direction = direction;
	}

	private int change(int x) {
		if(direction == KeyCode.RIGHT || direction == KeyCode.DOWN) {
			return x - 1;
		}
		else {
			return x + 1;
		}
	}

	private IntStream revRange(int from, int to) {
	    return IntStream.range(from, to)
	                    .map(i -> to - i + from - 1);
	}

	public boolean shift() {

		boolean check = false;
		int[] jlist = {};
		int[] ilist = {};
		int[] klist = {};

		if(direction == KeyCode.RIGHT || direction == KeyCode.DOWN) {
			jlist = revRange(0, Main.height - 1).toArray();
	        ilist = IntStream.range(0, Main.width).toArray();

	        if(direction == KeyCode.DOWN) {
	        	int[] swap = ilist;
	            ilist = jlist;
	            jlist = swap;
	        }
		}

		if(direction == KeyCode.LEFT || direction == KeyCode.UP) {
			jlist = IntStream.range(1, Main.height).toArray();
	        ilist = IntStream.range(0, Main.width).toArray();

	        if(direction == KeyCode.UP) {
	        	int[] swap = ilist;
	            ilist = jlist;
	            jlist = swap;
	        }
		}

		if(direction == KeyCode.RIGHT || direction == KeyCode.LEFT) {
	        for(int vert : jlist) {
	            if(direction == KeyCode.RIGHT){
	                klist = IntStream.range(vert + 1, 4).toArray();
	            }
	            if(direction == KeyCode.LEFT) {
	                klist = revRange(0, vert).toArray();
	            }
	            for(int current : klist) {
	                for(int hor : ilist) {
	                    if(Main.grid[hor][change(current)].taken) {
	                        Tile t1start = Main.grid[hor][change(current)];
	                        Tile t1end = Main.grid[hor][current];
	                        //t1start.set_surf(t1start.get_file()) <- dunno
	                        if(t1start.taken && !t1end.taken) {
	                            Main.grid[hor][change(current)].free();
	                            // t1start = moveboxto(t1start, (t1end.rect[0], t1end.rect[1])) <- animation
	                            Main.grid[hor][current] = t1start;
	                            check = true;
	                        }
	                    }
	                }
	            }
	        }
		}

		if(direction == KeyCode.UP || direction == KeyCode.DOWN) {
	        for(int hor : ilist) {
	            if(direction == KeyCode.DOWN) {
	                klist = IntStream.range(hor + 1, Main.width).toArray();
	            }
	            if(direction == KeyCode.UP) {
	                klist = revRange(0, Main.width).toArray();
	            }
	            for(int current : klist) {
	                for(int vert : jlist) {
	                    if(Main.grid[change(current)][vert].taken) {
	                        Tile t1start = Main.grid[change(current)][vert];
	                        Tile t1end = Main.grid[current][vert];
	                        // t1start.set_surf(t1start.get_file()) <- dunno stil
	                        if(t1start.taken && !t1end.taken) {
	                            Main.grid[change(current)][vert].free();
	                            //t1start = moveboxto(t1start, (t1end.rect[0], t1end.rect[1])) <- animation
	                            Main.grid[current][vert] = t1start;
	                            check = true;
	                        }
	                    }
	                }
	            }
	        }
		}
		return check;
	}
}
