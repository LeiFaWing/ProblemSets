package flag;

import apcs.Window;

public class Player implements Thing{

	int x;
	int y;
	String color;
	int radius;
	int player;
	int speed;
	
	public Player(int player) {
		this.player = player;
		if (player == 1) {
			x = 100;
			color = "blue";
		}
		else {
			x = Window.width() - 100;
			color = "red";
		}
		y = Window.height() / 2;
		radius = 20;
		speed = 7;
	}
	
	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, radius);
		
	}

	@Override
	public void move() {
		if (player == 1) {
			if (Window.key.pressed("w")) {
				y -= speed;
			}
			if (Window.key.pressed("s")) {
				y += speed;
			}
			if (Window.key.pressed("a")) {
				x -= speed;
			}
			if (Window.key.pressed("d")) {
				x += speed;
			}
		}
		else {
			if (Window.key.pressed("up")) {
				y -= speed;
			}
			if (Window.key.pressed("down")) {
				y += speed;
			}
			if (Window.key.pressed("left")) {
				x -= speed;
			}
			if (Window.key.pressed("right")) {
				x += speed;
			}
		}
		
	}

	@Override
	public boolean checkCollision(Thing otherThing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void follow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
