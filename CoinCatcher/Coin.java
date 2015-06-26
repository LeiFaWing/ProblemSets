package day2;

import apcs.Window;

public class Coin {
	
	int x;
	int y;
	int radius;
	String color;
	int speed;
	
	public Coin() {
		x = Window.rollDice(Window.width());
		y = (Window.rollDice(200) + 50) * -1;
		radius = 20;
		speed = 7;
		color = "Silver";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		y += speed;
	}
	
	public boolean checkCollision(Player p) {
		
		if (Math.abs(x - p.x) <= radius + p.width / 2 &&
				Math.abs(y - p.y) <= radius + p.height / 2) {
			return true;
		}
		
		return false;
	}
	
	public void reset() {
		x = Window.rollDice(Window.width());
		y = (Window.rollDice(200) + 50) * -1;
	}
	
	
}
