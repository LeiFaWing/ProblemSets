package day1;



import apcs.Window;

public class Frog {
	int x, y, radius, cooldown;
	
	public Frog() {
		x = Window.width() / 2;
		y = Window.height() - 50;
		radius = 25;
		cooldown = 5;
	}
	
	public void draw() {
		Window.out.color("light green");
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		if (Window.key.pressed("up") && cooldown >= 5) {
			y -= 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("down") && cooldown >= 5) {
			y += 100;
			cooldown = 0;
		}
		else if (Window.key.pressed("right") && cooldown >= 5) {
			x += 50;
			cooldown = 0;
		}
		else if (Window.key.pressed("left") && cooldown >= 5) {
			x -= 50;
			cooldown = 0;
		}
		cooldown++;
	}

	public void reset() {
		x = Window.width() / 2;
		y = Window.height() - 50;
	}
}
