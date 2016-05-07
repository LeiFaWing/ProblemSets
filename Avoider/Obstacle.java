package Avoider;

import apcs.Window;

public class Obstacle {

	int x, y, side, speed, direction;
	String color;
	
	public Obstacle() {
		direction = Window.rollDice(4);
		if (direction == 1) { // start on left side
			x = -50;
			y = Window.rollDice(Window.height());
		}
		else if (direction == 2) { // start on top side
			x = Window.rollDice(Window.width());
			y = - 50;
		}
		else if (direction == 3) { // start on right side
			x = Window.width() + 50;
			y = Window.rollDice(Window.height());
		}
		else { // start on bottom side
			x = Window.rollDice(Window.width());
			y = Window.height() + 50;
		}
		speed = Window.rollDice(10) + 5;
		side = Window.rollDice(20) + 10;
		color = "white";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, side);
	}
	
	public void move() {
		if (direction == 1) { // start on left side
			x += speed;
		}
		else if (direction == 2) { // start on top side
			y += speed;
		}
		else if (direction == 3) { // start on right side
			x -= speed;
		}
		else { // start on bottom side
			y -= speed;
		}
	}
	
	public boolean outside() {
		if (direction == 1 && x > Window.width()) {
			return true;
		}
		else if (direction == 2 && y > Window.height()) {
			return true;
		}
		else if (direction == 3 && x < 0) {
			return true;
		}
		else if (direction == 4 && y < 0) {
			return true;
		}
		
		return false;
	}
}
