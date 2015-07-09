package Agar;

import apcs.Window;

public class Player {

	int x, y, radius;
	int r, g, b;
	//int dx, dy;
	String name;

	public Player(String name) {
		x = Window.rollDice(10000);
		y = Window.rollDice(10000);
		r = Window.rollDice(256) - 1;
		g = Window.rollDice(256) - 1;
		b = Window.rollDice(256) - 1;
		this.name = name;
		radius = 15;
	}
	
	public void draw() {
		Window.out.color(r, g, b);
		Window.out.circle(Window.width() / 2, Window.height() / 2, radius);
	}
	
	public void draw(int xoffset, int yoffset) {
		Window.out.color(r, g, b);
		Window.out.circle(Window.width() / 2 + (x - xoffset), Window.height() / 2 + (y - yoffset), radius);
	}

	public void move() {
		// Get the raw difference i
		int dx = Window.mouse.getX() - Window.width() / 2;
		int dy = Window.mouse.getY() - Window.height() / 2;

		double magnitude = Math.sqrt(dx * dx + dy * dy);

		if (magnitude > 10) {
			dx = (int) (dx * 10 / magnitude);
			dy = (int) (dy * 10 / magnitude);
		}

		x = x + dx;
		y = y + dy;
	}
}
