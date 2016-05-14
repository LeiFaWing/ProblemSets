package Avoider;

import apcs.Window;

public class Bullet {

	int x, y, dx, dy, width, height;
	int r, g, b;
	int speedx, speedy;
	
	public Bullet(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		width = 10;
		height = 20;
		r = Window.rollDice(255);
		g = Window.rollDice(255);
		b = Window.rollDice(255);
		speedx = (dx - x) / 10;
		speedy = (dy - y) / 10;
	}
	
	public void draw() {
		Window.out.color(r, g, b);
		Window.out.oval(x, y, width, height);
	}
	
	public void move() {
		x += speedx;
		y += speedy;
	}
	
	public boolean collides(Obstacle o) {
		if (Math.abs(x - o.x) < width / 2 + o.side / 2 &&
				Math.abs(y - o.y) < height / 2 + o.side / 2) {
			return true;
		}
		return false;
	}
	
	public boolean outside() {
		if (x < 0 || y < 0) {
			return true;
		}
		if (x > Window.width() || y > Window.height()) {
			return true;
		}
		
		return false;
	}
}
