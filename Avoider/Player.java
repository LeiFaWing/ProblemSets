package Avoider;

import apcs.Window;

public class Player {

	int x, y, speed, radius, health;
	String color, name;

	public Player(String name) {
		this.name = name;
		x = Window.width() / 2;
		y = Window.height() / 2;
		speed = 10;
		radius = 20;
		health = 5;
		color = "red";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}
	
	public boolean collision(Obstacle o) {
		if (Math.abs(x - o.x) < radius + o.side / 2 && Math.abs(y - o.y) < radius + o.side / 2) {
			return true;
		}
		
		return false;
	}

	public void move() {
		if (Window.key.pressed("left")) {
			x -= speed;
		}
		if (Window.key.pressed("right")) {
			x += speed;
		}
		if (Window.key.pressed("down")) {
			y += speed;
		}
		if (Window.key.pressed("up")) {
			y -= speed;
		}
		
		if (x < radius) {
			x = radius;
		}
		if (x > Window.width() - radius) {
			x = Window.width() - radius;
		}
		if (y < radius) {
			y = radius;
		}
		if (y > Window.height() - radius) {
			y = Window.height() - radius;
		}
	}
}
