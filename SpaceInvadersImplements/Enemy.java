package SpaceInvaders;

import apcs.Window;

public class Enemy implements Thing{

	int x, y, speed, size, direction;
	String color;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 5;
		size = 30;
		color = "violet";
		direction = 1;
	}
	
	@Override
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, size);
	}

	@Override
	public void move() {
		x += speed * direction;
		
		if (x > Window.width() - size / 2) {
			direction = -1;
			y += speed * 8;
		}
		else if (x < size / 2) {
			direction = 1;
			y += speed * 8;
		}
	}

	@Override
	public boolean isTouching(Thing t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return true;
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
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean shoot() {
		if (Window.rollDice(100) == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean outside() {
		// TODO Auto-generated method stub
		if (y > Window.height() + size) {
			MainGame.gameover = true;
		}
		
		return false;
	}

	@Override
	public boolean isEnemySpaceship() {
		return true;
	}

}
