package soccer;

import apcs.Window;

public class Player {
	
	int x;
	int y;
	int radius;
	int team;
	int speed;
	String name;
	String color;
	
	public Player(int team, String name) {
		this.team = team;
		this.name = name;
		if (team == 1) {
			color = "red";
			x = 100;
		}
		else if (team == 2) {
			color = "blue";
			x = Window.width() - 100;
		}
		y = Window.height() / 2;
		speed = 10;
		radius = 20;
	}
	
	public void draw() {
		if (team == 1) {
			color = "red";
		}
		else if (team == 2) {
			color = "blue";
		}
		Window.out.color(color);
		Window.out.circle(x, y, radius);
		Window.out.color("white");
		Window.out.print(name, x, y);
	}
	
	public void move() {
		
		if (Window.key.pressed("w") && y > radius) {
			y -= speed;
		}
		if (Window.key.pressed("s") && y < Window.height() - radius) {
			y += speed;
		}
		if (Window.key.pressed("a") && x > radius) {
			x -= speed;
		}
		if (Window.key.pressed("d") && x < Window.width() - radius) {
			x += speed;
		}
		
		
	}
	
	public boolean checkCollsion(Ball ball) {
		
		int a = x - ball.x;
		int b = y - ball.y;
		int c = radius + ball.radius;
		
		return a * a + b * b < c * c;
	}
	
}








