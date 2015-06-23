package SpaceInvaders;

import apcs.Window;

public class Player {
	int x;
	int y;
	int radius;
	int speed;
	int cooldown = 5;
	
	public Player() {
		x = Window.width() / 2;
		y = Window.height() - 100;
		radius = 20;
		speed = 10;
	}
	
	public void draw() {
		Window.out.color("blue");
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		if (Window.key.pressed("left")) {
			x -= speed;
		}
		else if (Window.key.pressed("right")) {
			x += speed;
		}
		cooldown++;
	}
	
	public boolean shoot() {
		if (Window.key.pressed("space") && cooldown >= 5) {
			cooldown = 0;
			return true;
		}
		
		return false;
	}
}
