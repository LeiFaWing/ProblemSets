package Simulation;

import apcs.Window;

public class Circle {
	
	int x;
	int y;
	int radius;
	int color;
	int dx, dy;
	int r, g, b;
	
	public Circle() {
		radius = Window.rollDice(30) + 20;
		x = Window.rollDice(Window.width() - radius * 2) + radius;
		y = Window.rollDice(Window.height() - radius * 2) + radius;
		dx = Window.rollDice(21) - 11;
		dy = Window.rollDice(21) - 11;
		r = Window.rollDice(256) - 1;
		g = Window.rollDice(256) - 1;
		b = Window.rollDice(256) - 1;
		
		color = Window.rollDice(4);
	}
	
	public void draw() {
//		if (color == 1) {
//			Window.out.color("red");
//		}
//		if (color == 2) {
//			Window.out.color("blue");
//		}
//		if (color == 3) {
//			Window.out.color("green");
//		}
//		if (color == 4) {
//			Window.out.color("yellow");
//		}
		Window.out.color(r, g, b);
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		x += dx;
		y += dy;
		
		if (x < radius) {
			x = radius;
			dx = -dx;
		}
		if (y < radius) {
			y = radius;
			dy = -dy;
		}
		if (x > Window.width() - radius) {
			x = Window.width() - radius;
			dx = -dx;
		}
		if (y > Window.height() - radius) {
			y = Window.height() - radius;
			dy = -dy;
		}
		
	}
	
	public boolean checkCollision(Circle c) {
		if (Math.abs(x - c.x) <= radius + c.radius &&
				Math.abs(y - c.y) <= radius + c.radius) {
			return true;
		}
		
		return false;
	}
}

