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
	int sprintTime = 100;
	boolean tired = false;
	
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
		
		// sprint button is pressed
		if (Window.key.pressed("space") && !tired) {
			sprintTime--;
			speed = 13;
			
			if (sprintTime <= 0) {
				tired = true;
			}
		}
		else {
			sprintTime++;
			if (sprintTime > 100) {
				sprintTime = 100;
				tired = false;
			}
			speed = 10;
		}
		
		if (tired) {
			speed = 7;
		}
		
		
		
	}
	
	public boolean checkCollsion(Ball ball) {
		
		int a = x - ball.x;
		int b = y - ball.y;
		int c = radius + ball.radius;
		
		return a * a + b * b < c * c;
	}
	
	public void reset() {
		if (team == 1) {
			x = 100;
		}
		else if (team == 2) {
			x = Window.width() - 100;
		}
		y = Window.height() / 2;
	}
	
}








