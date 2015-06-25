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
			x = 200;
			color = "blue";
		}
		else {
			x = Window.width() - 200;
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
		else {
			if (Window.key.pressed("up") && y > radius) {
				y -= speed;
			}
			if (Window.key.pressed("down") && y < Window.height() - radius) {
				y += speed;
			}
			if (Window.key.pressed("left") && x > radius) {
				x -= speed;
			}
			if (Window.key.pressed("right") && x < Window.width() - radius) {
				x += speed;
			}
		}

	}

	@Override
	public int checkCollision(Thing o) {
		if (o.isFlag() && o.getNumber() != player) {
			if (Math.abs(x - o.getX()) <= radius + o.getWidth() / 2 &&
					Math.abs(y - o.getY()) <= radius + o.getHeight() / 2) {
				return 1;
			}
		}
		else if (o.isFlag() && o.getNumber() == player) {
			if (Math.abs(x - o.getX()) <= radius + o.getWidth() / 2 &&
					Math.abs(y - o.getY()) <= radius + o.getHeight() / 2) {
				return 3;
			}
		}
		else {
			if (player == 1 && x > Window.width() / 2) {
				if (Math.abs(x - o.getX()) <= radius + o.getRadius() &&
						Math.abs(y - o.getY()) <= radius + o.getRadius()) {
					return 2;
				}
			}
			else if (player == 2 && x < Window.width() / 2) {
				if (Math.abs(x - o.getX()) <= radius + o.getRadius() &&
						Math.abs(y - o.getY()) <= radius + o.getRadius()) {
					return 2;
				}
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
		if (player == 1) {
			this.x = 200;
			this.y = Window.height() / 2;
		}
		else {
			this.x = Window.width() - 200;
			this.y = Window.height() / 2;
		}
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
		return player;
	}


}
