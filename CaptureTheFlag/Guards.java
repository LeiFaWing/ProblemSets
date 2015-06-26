package flag;

import apcs.Window;

public class Guards implements Thing{

	int x;
	int y;
	int radius;
	String color;
	int speed;
	int guard;
	
	public Guards(int guard) {
		this.guard = guard;
		if (guard == 1) {
			x = Window.rollDice(Window.width() / 2 - 100) + 50;
			color = "light blue";
		}
		else {
			x = Window.rollDice(Window.width() / 2 - 50) + Window.width() / 2;
			color = "orange";
		}
		y = Window.rollDice(Window.height() - 100) + 50;
		radius = 20;
		speed = 7;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		x += Window.rollDice(21) - 11;
		y += Window.rollDice(21) - 11;
		
		if (guard == 1 && x > Window.width() / 2) {
			x = Window.width() / 2;
		}
		
		if (guard == 2 && x < Window.width() / 2) {
			x = Window.width() / 2;
		}
		
		if (x > Window.width() - radius) {
			x = Window.width() + radius;
		}
		if (x < radius) {
			x = radius;
		}
		if (y > Window.height() - radius) {
			y = Window.height() - radius;
		}
		if (y < radius) {
			y = radius;
		}
	}

	@Override
	public int checkCollision(Thing o) {
		// TODO Auto-generated method stub
		if (guard == 1 && x > Window.width() / 2) {
			if (Math.abs(x - o.getX()) <= radius + o.getRadius() &&
					Math.abs(y - o.getY()) <= radius + o.getRadius()) {
				return 2;
			}
		}
		else if (guard == 2 && x < Window.width() / 2) {
			if (Math.abs(x - o.getX()) <= radius + o.getRadius() &&
					Math.abs(y - o.getY()) <= radius + o.getRadius()) {
				return 2;
			}
		}
		return 0;
	}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void follow(int x, int y) {
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

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return guard;
	}

}
