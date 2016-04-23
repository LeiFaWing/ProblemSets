package arrayGames;

import apcs.Window;

public class PuzzleGame {

	static int[][] grid = new int[7][7];
	static int x = 300, y = 350;
	static int cd = 5;
	static int delay = cd;
	static int timer = 1;
	static int score = 0;
	static boolean horizontal = true;

	public static void main(String[] args) {

		Window.size(700, 900);

		setup();

		for (int i = 0; i < 6; i++) {
			step();
			fall();
		}

		while (true) {
			draw();

			move();

			if (Window.key.pressed("z") && cd >= delay) {
				horizontal = !horizontal;
				x -= 50;
				y += 50;
				cd = 0;
			}

			if (Window.key.pressed("space") && cd >= delay) {
				swap();
				cd = 0;
				for (int i = 0; i < 6; i++) {
					fall();
					step();
				}
			}

			if (timer % 200 == 0) {
				for (int i = 0; i < grid.length; i++) {
					if (grid[i][0] != 0) {
						Window.out.color("white");
						Window.out.fontSize(40);
						Window.out.print("GAME OVER", 200, 200);
						Window.frame(2000);
						System.exit(0);
					}
				}
				grow();
			}

			cd++;
			timer++;

			Window.frame();
		}
	}

	public static void setup() {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = Window.rollDice(4);
			}
		}
	}

	public static void draw() {
		Window.out.background("black");

		if (horizontal) {
			Window.out.color("light gray");
			Window.out.rectangle(x, y, 200, 100);
		}
		else {
			Window.out.color("light gray");
			Window.out.rectangle(x, y, 100, 200);
		}

		// draw line
		Window.out.color("white");
		Window.out.rectangle(Window.width() / 2, 725, Window.width(), 25);

		// print score
		Window.out.fontSize(50);
		Window.out.print("Score: " + score, 20, 850);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					Window.out.color("blue");
				}
				else if (grid[i][j] == 2) {
					Window.out.color("green");
				}
				else if (grid[i][j] == 3) {
					Window.out.color("red");
				}
				else if (grid[i][j] == 4) {
					Window.out.color("yellow");
				}
				else {
					Window.out.color("black");
				}
				Window.out.square(i * 100 + 50, j * 100 + 50, 80);
			}
		}
	}

	public static void move() {
		if (Window.key.pressed("up") && cd >= delay) {
			cd = 0;
			y -= 100;
		}
		else if (Window.key.pressed("down") && cd >= delay) {
			cd = 0;
			y += 100;
		}
		else if (Window.key.pressed("left") && cd >= delay) {
			cd = 0;
			x -= 100;
		}
		else if (Window.key.pressed("right") && cd >= delay) {
			cd = 0;
			x += 100;
		}

		if (horizontal) {
			if (x < 100) {
				x = Window.width() - 100;
			}
			if (x > Window.width() - 100) {
				x = 100;
			}
			if (y < 50) {
				y = Window.height() - 250;
			}
			if (y > Window.height() - 250) {
				y = 50;
			}
		}
		else {
			if (x < 50) {
				x = Window.width() - 50;
			}
			if (x > Window.width() - 50) {
				x = 50;
			}
			if (y < 100) {
				y = Window.height() - 300;
			}
			if (y > Window.height() - 300) {
				y = 100;
			}
		}
	}

	public static void swap() {
		if (horizontal) {
			int bx1 = x / 100;
			int bx2 = bx1 - 1;
			int by = y / 100;

			int temp = grid[bx1][by];
			grid[bx1][by] = grid[bx2][by];
			grid[bx2][by] = temp;
		}
		else {
			int bx = x / 100;
			int by1 = y / 100;
			int by2 = by1 - 1;
			int temp = grid[bx][by1];
			grid[bx][by1] = grid[bx][by2];
			grid[bx][by2] = temp;
		}
	}

	public static void step() {

		// check horizontal 3 in a row
		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// check 5 in a row
				if (grid[i][j] != 0 && i < 3 && grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i+2][j] &&
						grid[i][j] == grid[i+3][j] && grid[i][j] == grid[i+4][j] ) {
					score += 30;
					grid[i][j] = 0;
					grid[i+1][j] = 0;
					grid[i+2][j] = 0;
					grid[i+3][j] = 0;
					grid[i+4][j] = 0;
				}
				else if (grid[i][j] != 0 && i < 4 && grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i+2][j] &&
						grid[i][j] == grid[i+3][j]) {
					score += 20;
					grid[i][j] = 0;
					grid[i+1][j] = 0;
					grid[i+2][j] = 0;
					grid[i+3][j] = 0;
				}
				else if (grid[i][j] != 0 && grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i+2][j]) {
					score += 10;
					grid[i][j] = 0;
					grid[i+1][j] = 0;
					grid[i+2][j] = 0;
				}
			}
		}

		// check vertical 3 in a row
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length - 2; j++) {
				if (grid[i][j] != 0 && j < 3 && grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i][j+2] &&
						grid[i][j] == grid[i][j+3] && grid[i][j] == grid[i][j+4] ) {
					score += 30;
					grid[i][j] = 0;
					grid[i][j+1] = 0;
					grid[i][j+2] = 0;
					grid[i][j+3] = 0;
					grid[i][j+4] = 0;
				}
				else if (grid[i][j] != 0 && j < 4 && grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i][j+2] &&
						grid[i][j] == grid[i][j+3]) {
					score += 20;
					grid[i][j] = 0;
					grid[i][j+1] = 0;
					grid[i][j+2] = 0;
					grid[i][j+3] = 0;
				}
				else if (grid[i][j] != 0 && grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i][j+2]) {
					score += 10;
					grid[i][j] = 0;
					grid[i][j+1] = 0;
					grid[i][j+2] = 0;
				}
			}
		}
	}

	public static void fall() {

		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[0].length - 2; j > -1; j-- ) {
				if (grid[i][j+1] == 0) {
					grid[i][j+1] = grid[i][j];
					grid[i][j] = 0;
				}
			}
		}
	}

	public static void grow() {
		// move blocks up
		for (int i = 0; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j-1] = grid[i][j];
				grid[i][j] = 0;
			}
		}

		// add new row of blocks to the bottom of the grid
		for (int i = 0; i < grid.length; i++) {
			grid[i][grid[0].length - 1] = Window.rollDice(4);
		}
	}

}

















