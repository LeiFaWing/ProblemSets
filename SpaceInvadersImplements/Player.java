package SpaceInvaders;

import apcs.Window;

public class Player implements Thing{
	
	
	int x, y, speed, size;
	String color;
	final int delay = 10;
	int cd = delay;
	
	public Player() {
		x = Window.width() / 2;
		y = Window.height() - 100;
		speed = 10;
		size = 30;
		color = "blue";
	}
	
	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, size);
	}

	@Override
	public void move() {
		if (Window.key.pressed("left")) {
			x -= speed;
		}
		else if (Window.key.pressed("right")) {
			x += speed;
		}
		
		// stop player from going outside of the screen to the left
		if (x < size / 2) {
			x = size / 2;
		}
		
		// stop player from going outside of the screen to the right
		if (x > Window.width() - size / 2) {
			x = Window.width() - size / 2;
		}
		
		cd++;
	}

	@Override
	public boolean isTouching(Thing t) {
		
		return false;
	}

	@Override
	public boolean isEnemy() {
		return false;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean shoot() {
		// TODO Auto-generated method stub
		if (Window.key.pressed("space") && cd >= delay) {
			cd = 0;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean outside() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnemySpaceship() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
