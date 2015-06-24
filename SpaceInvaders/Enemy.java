package SpaceInvaders;

import apcs.Window;

public class Enemy {
	int x;
	int y;
	int side;
	int speed;
	String color;
	
	public Enemy() {
		x = Window.rollDice(Window.width() - 100) + 50;
		y = 100;
		side = 25;
		speed = 7;
		color = "green";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, side);
	}
	
	public void move() {
		x += speed;
		
		if (x > Window.width() - side || x < side) {
			speed *= -1;
			y += side;
		}
	}
	
	public boolean shoot() {
		if (Window.rollDice(50) == 1) {
			return true;
		}
		
		return false;
	}
}
