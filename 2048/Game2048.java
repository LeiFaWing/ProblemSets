package advanced1;

import apcs.Window;

public class Game2048 {

	static int[][] grid = new int[4][4];
	static int cooldown = 5;
	static boolean lose = false;
	static boolean isFull = false;
	static boolean win = false;

	public static void main(String[] args) {
		Window.size(600, 600);

		setup(2);
		while (true) {
			draw();
			
			if (lose) {
				Window.out.color("white");
				Window.out.font("arial", 50);
				Window.out.print("You Lose", 200, 200);
				Window.out.print("Press Space to Restart", 25, 300);
				
				if (Window.key.pressed("space")) {
					lose = false;
					grid = new int[4][4];
					setup(2);
				}
			}
			
			if (win) {
				Window.out.color("white");
				Window.out.font("arial", 50);
				Window.out.print("You Win", 200, 200);
				Window.out.print("Press Space to Restart", 25, 300);
				
				if (Window.key.pressed("space")) {
					win = false;
					grid = new int[4][4];
					setup(2);
				}
			}

			if (Window.key.pressed("left") && cooldown >= 5) {
				moveLeft();
				combineLeft();
				moveLeft();
				if (!isFull) {
					setup(1);
				}
				checkFull();
				checkWin();
				cooldown = 0;
			}
			if (Window.key.pressed("right") && cooldown >= 5) {
				moveRight();
				combineRight();
				moveRight();
				if (!isFull) {
					setup(1);
				}
				checkFull();
				checkWin();
				cooldown = 0;
			}
			if (Window.key.pressed("up") && cooldown >= 5) {
				moveUp();
				combineUp();
				moveUp();
				if (!isFull) {
					setup(1);
				}
				checkFull();
				checkWin();
				cooldown = 0;
			}
			if (Window.key.pressed("down") && cooldown >= 5) {
				moveDown();
				combineDown();
				moveDown();
				if (!isFull) {
					setup(1);
				}
				checkFull();
				checkWin();
				cooldown = 0;
			}


			cooldown++;
			Window.frame();
		}
	}
	
	public static void checkWin() {
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				// check for empty space
				if (grid[x][y] == 2048) {
					win = true;
					return;
				}
			}
		}
		
	}

	public static void checkFull() {
		boolean full = true;
		loop: for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				// check for empty space
				if (grid[x][y] == 0) {
					full = false;
					break loop;
				}
			}
		}

		isFull = full;

		if (full) {
			// check if you can combine left
			for (int x = 1; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x - 1][y] == grid[x][y]) {
						return;
					}
				}
			}

			// check if you can combine right
			for (int x = 2; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x + 1][y] == grid[x][y]) {
						return;
					}
				}
			}

			// check if you can combine up
			for (int x = 0; x < 4; x++) {
				for (int y = 1; y < 4; y++) {
					// check if space to the top is 0
					if (grid[x][y - 1] == grid[x][y]) {
						return;
					}
				}
			}

			// check if you can combine down
			for (int x = 0; x < 4; x++) {
				for (int y = 1; y < 4; y++) {
					// check if space to the top is 0
					if (grid[x][y - 1] == grid[x][y]) {
						return;
					}
				}
			}

			lose = true;
		}
	}

	public static void combineLeft() {
		// move left 3 times
		for (int i = 0; i < 3; i++) {
			// start at x = 1
			for (int x = 1; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x - 1][y] == grid[x][y]) {
						grid[x - 1][y] += grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void combineRight() {
		// move right 3 times
		for (int i = 0; i < 3; i++) {
			// start at x = 2 then go down
			for (int x = 2; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x + 1][y] == grid[x][y]) {
						grid[x + 1][y] += grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void combineUp() {
		// move up 3 times
		for (int i = 0; i < 3; i++) {
			// start at y = 1
			for (int x = 0; x < 4; x++) {
				for (int y = 1; y < 4; y++) {
					// check if space to the top is 0
					if (grid[x][y - 1] == grid[x][y]) {
						grid[x][y - 1] += grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void combineDown() {
		// move down 3 times
		for (int i = 0; i < 3; i++) {
			// start at y = 2
			for (int x = 0; x < 4; x++) {
				for (int y = 2; y >= 0; y--) {
					// check if space to the bottom is 0
					if (grid[x][y + 1] == grid[x][y]) {
						grid[x][y + 1] += grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void moveUp() {
		// move up 3 times
		for (int i = 0; i < 3; i++) {
			// start at y = 1
			for (int x = 0; x < 4; x++) {
				for (int y = 1; y < 4; y++) {
					// check if space to the top is 0
					if (grid[x][y - 1] == 0) {
						grid[x][y - 1] = grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void moveDown() {
		// move down 3 times
		for (int i = 0; i < 3; i++) {
			// start at y = 2
			for (int x = 0; x < 4; x++) {
				for (int y = 2; y >= 0; y--) {
					// check if space to the bottom is 0
					if (grid[x][y + 1] == 0) {
						grid[x][y + 1] = grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void moveLeft() {
		// move left 3 times
		for (int i = 0; i < 3; i++) {
			// start at x = 1
			for (int x = 1; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x - 1][y] == 0) {
						grid[x - 1][y] = grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void moveRight() {
		// move right 3 times
		for (int i = 0; i < 3; i++) {
			// start at x = 2 then go down
			for (int x = 2; x >= 0; x--) {
				for (int y = 0; y < 4; y++) {
					// check if space to the left is 0
					if (grid[x + 1][y] == 0) {
						grid[x + 1][y] = grid[x][y];
						grid[x][y] = 0;
					}
				}
			}
		}
	}

	public static void setup(int max) {
		int count = 0;
		while (count < max) {
			int x = Window.rollDice(4) - 1;
			int y = Window.rollDice(4) - 1;

			if (grid[x][y] == 0) {
				if (Window.rollDice(100) > 25) {
					grid[x][y] = 2;
				}
				else {
					grid[x][y] = 4;
				}
				count++;
			}
		}
	}

	public static void draw() {
		Window.out.background("white");
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				Window.out.color("black");
				Window.out.rectangle(x * 150, Window.height() / 2, 5, Window.height());
				Window.out.rectangle(Window.width() / 2, y * 150, Window.width(), 5);
				Window.out.rectangle(x * 150 + 150, Window.height() / 2, 5, Window.height());
				Window.out.rectangle(Window.width() / 2, y * 150 + 150, Window.width(), 5);

				if (grid[x][y] != 0) {

					if (grid[x][y] <= 8) {
						Window.out.color(grid[x][y] * 30, grid[x][y] * 20, grid[x][y] * 10);
						Window.out.square(x * 150 + 75, y * 150 + 75, 145);
					}

					else if (grid[x][y] <= 32) {
						Window.out.color(grid[x][y] * 15, grid[x][y] * 10, grid[x][y] * 5);
						Window.out.square(x * 150 + 75, y * 150 + 75, 145);
					}
					else if (grid[x][y] <= 128) {
						Window.out.color(grid[x][y], grid[x][y] * 2 - 1, grid[x][y]);
						Window.out.square(x * 150 + 75, y * 150 + 75, 145);
					}


					Window.out.color("black");
					Window.out.font("arial", 40);
					Window.out.print(grid[x][y], x * 150 + 60, y * 150 + 100);
				}
			}
		}
	}

}
