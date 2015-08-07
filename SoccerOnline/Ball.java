package soccer;

import apcs.Window;

public class Ball {

	int x, y, radius, dx, dy;
	String color;
	
	public Ball() {
		x = Window.width() / 2;
		y = Window.height() / 2;
		radius = 10;
		dx = 0;
		dy = 0;
		color = "purple";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		
//		dx *= 9 / 10;
//		dy *= 9 / 10;
		
		x += dx;
		y += dy;
	}
	
	public boolean checkBoundaries() {
		
		if (y < radius) {
			dy = 50;
			return true;
		}
		if (y > Window.height() - radius) {
			dy = -50;
			return true;
		}
		
		if (x < radius && y < Window.height() / 2 - 75) {
			dx = 50;
			return true;
		}
		
		if (x < radius && y > Window.height() / 2 + 75) {
			dx = 50;
			return true;
		}
		
		if (x > Window.width() - radius && y < Window.height() / 2 - 75) {
			dx = -50;
			return true;
		}
		
		if (x > Window.width() - radius && y > Window.height() / 2 + 75) {
			dx = -50;
			return true;
		}
		
		return false;
	}
	
	// team 2 scores
	public boolean blueScores() {
		return x < 0 && Math.abs(y - Window.height() / 2) <= 75;
	}
	
	// team 1 scores
	public boolean redScores() {
		return x > Window.width() && Math.abs(y - Window.height() / 2) <= 75;
	}
	
	public void reset() {
		x = Window.width() / 2;
		y = Window.height() / 2;
	}
	
	
}







