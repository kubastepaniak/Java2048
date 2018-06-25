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
			jlist = revRange(0, Main.cols - 1).toArray();
	        ilist = IntStream.range(0, Main.rows).toArray();

	        if(direction == KeyCode.DOWN) {
	        	int[] swap = ilist;
	            ilist = jlist;
	            jlist = swap;
	        }
		}

		if(direction == KeyCode.LEFT || direction == KeyCode.UP) {
			jlist = IntStream.range(1, Main.cols).toArray();
	        ilist = IntStream.range(0, Main.rows).toArray();

	        if(direction == KeyCode.UP) {
	        	int[] swap = ilist;
	            ilist = jlist;
	            jlist = swap;
	        }
		}

		if(direction == KeyCode.RIGHT || direction == KeyCode.LEFT) {
	        for(int vert : jlist) {
	            if(direction == KeyCode.RIGHT){
	                klist = IntStream.range(vert + 1, Main.rows).toArray();
	            }
	            if(direction == KeyCode.LEFT) {
	                klist = revRange(0, vert).toArray();
	            }
	            for(int current : klist) {
	                for(int hor : ilist) {
	                	if(Main.grid[change(current)][hor].taken) {
	                        Tile t1start = Main.grid[change(current)][hor];
	                        Tile t1end = Main.grid[current][hor];
	                        // t1start.set_surf(t1start.get_file()) <- dunno still
	                        if(t1start.taken && !t1end.taken) {
	                            Main.grid[change(current)][hor].free();
	                            //t1start = moveboxto(t1start, (t1end.rect[0], t1end.rect[1])) <- animation
	                            //Main.grid[current][vert] = t1start;
	                            Main.grid[current][hor].occupy(t1start.value);
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
	                klist = IntStream.range(hor + 1, Main.cols).toArray();
	            }
	            if(direction == KeyCode.UP) {
	                klist = revRange(0, hor).toArray();
	            }
	            for(int current : klist) {
	                for(int vert : jlist) {
	                    if(Main.grid[vert][change(current)].taken) {
	                        Tile t1start = Main.grid[vert][change(current)];
	                        Tile t1end = Main.grid[vert][current];
	                        //t1start.set_surf(t1start.get_file()) <- dunno
	                        if(t1start.taken && !t1end.taken) {
	                            Main.grid[vert][change(current)].free();
	                            // t1start = moveboxto(t1start, (t1end.rect[0], t1end.rect[1])) <- animation
	                            //Main.grid[hor][current] = t1start;
	                            Main.grid[vert][current].occupy(t1start.value);
	                            check = true;
	                        }
	                    }
	                }
	            }
	        }
		}
		return check;
	}

	public boolean mergePossible() {

		int[] currentList = {};

	    if(direction == KeyCode.RIGHT || direction == KeyCode.DOWN) {
	    	currentList = revRange(1, 4).toArray();
	    }
	    if(direction == KeyCode.LEFT || direction == KeyCode.UP) {
	    	currentList = IntStream.range(0, 3).toArray();
	    }

	    if(direction == KeyCode.RIGHT || direction == KeyCode.LEFT) {
	        for(int vert : IntStream.range(0, 4).toArray()) {
	            for(int hor : currentList) {
	                if(Main.grid[vert][hor].taken && Main.grid[vert][change(hor)].taken &&
	                   Main.grid[vert][hor].value == Main.grid[vert][change(hor)].value) {
	                    return true;
	                }
	            }
	        }
	    }
	    if(direction == KeyCode.UP || direction == KeyCode.DOWN) {
	        for(int hor : IntStream.range(0, 4).toArray()) {
	            for(int vert : currentList) {
	                if(Main.grid[vert][hor].taken && Main.grid[change(vert)][hor].taken &&
	                   Main.grid[vert][hor].value == Main.grid[change(vert)][hor].value) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

	public int[][] mergeWhere() {

		int[] currentList = {};

	    if(direction == KeyCode.RIGHT || direction == KeyCode.DOWN) {
	    	currentList = revRange(1, 4).toArray();
	    }
	    if(direction == KeyCode.LEFT || direction == KeyCode.UP) {
	    	currentList = IntStream.range(0, 3).toArray();
	    }

	    if(direction == KeyCode.RIGHT || direction == KeyCode.LEFT) {
	        for(int vert : IntStream.range(0, 4).toArray()) {
	            for(int hor : currentList) {
	                if(Main.grid[vert][hor].taken && Main.grid[vert][change(hor)].taken &&
	                   Main.grid[vert][hor].value == Main.grid[vert][change(hor)].value) {
	                    return new int[][] {{vert, change(hor)}, {vert, hor}};
	                }
	            }
	        }
	    }
	    if(direction == KeyCode.UP || direction == KeyCode.DOWN) {
	        for(int hor : IntStream.range(0, 4).toArray()) {
	            for(int vert : currentList) {
	                if(Main.grid[vert][hor].taken && Main.grid[change(vert)][hor].taken &&
	                   Main.grid[vert][hor].value == Main.grid[change(vert)][hor].value) {
	                    return new int[][] {{change(vert), hor}, {vert, hor}};
	                }
	            }
	        }
	    }
	    return null;
	}

	public void merge(int[][] blocks) {

		int[] first = blocks[0];
		int[] second = blocks[1];

		Main.grid[first[0]][first[1]].free();
		// animations
		Main.grid[second[0]][second[1]].doubleValue();
	}
}
